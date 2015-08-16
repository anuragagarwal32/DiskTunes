/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.project;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.servlet.http.HttpServletRequest;
import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

/**
 *
 * @author ubuntu
 */
public class AddStock extends ActionSupport implements ModelDriven<Stock>
{
    private Stock obj=new Stock();
    private DatabaseClass dbObj=new DatabaseClass();
    @Override
    public String execute() throws Exception 
    {
        HttpServletRequest request;
        Connection con;
        FileWriter jspFile;
        File file;
        try
        {
            con = getDbObj().getConnection();
            request = ServletActionContext.getRequest();
            if(con!=null)
            {
                int diskId;
                PreparedStatement pst= con.prepareStatement("INSERT INTO StockMaster(StockID, StockName, Version, Image, Casting, Director, Year, Quantity, Price, DiskDesc) values (?,?,?,?,?,?,?,?,?,?)");
                pst.setString(1,getObj().getId());
                pst.setString(2,getObj().getName());
                pst.setString(3,getObj().getVersion());
                pst.setString(4,"0.jpg");
                pst.setString(5,getObj().getCasting());
                pst.setString(6,getObj().getDirector());
                pst.setString(7,getObj().getYear());
                pst.setString(8,getObj().getQuantity());
                pst.setString(9,getObj().getPrice());
                pst.setString(10,getObj().getDesc());
                int status=pst.executeUpdate();
                Statement st=con.createStatement();
                ResultSet rs=st.executeQuery("SELECT DiskID FROM StockMaster WHERE StockID="+getObj().getId());
                rs.next();
                diskId=rs.getInt(1);
                st=con.createStatement();
                String query="UPDATE StockMaster SET Image='"+diskId+".jpg' WHERE StockID="+getObj().getId();
                status=st.executeUpdate(query);
                if(status>0)
                {
                    String imagePath="/home/ubuntu/NetBeansProjects/DiskTunes/web/product/image/";
                    String jspPath="/home/ubuntu/NetBeansProjects/DiskTunes/web/product/";
                    System.out.println("Content type "+getObj().getImageContentType());
                    try
                    {   
                        file=new File(imagePath, diskId+".jpg");
                        FileUtils.copyFile(getObj().getImage(), file);
                        jspFile=new FileWriter(jspPath+diskId+".jsp");
                        jspFile.write("<%@page contentType=\"text/html\" pageEncoding=\"UTF-8\"%>\n" +
                                        "<%@taglib uri=\"/struts-tags\" prefix=\"s\" %>\n" +
                                        "<%@include file=\"layout/header.html\" %>\n" +
                                        "<!DOCTYPE html>\n" +
                                        "<html>\n" +
                                        "    <head>\n" +
                                        "        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n" +
                                        "        <link type=\"text/css\" rel=\"stylesheet\" href=\"layout/product.css\" />\n" +
                                        "        <title>Disk Tunes</title>\n" +
                                        "    </head>\n" +
                                        "    <body>\n" +
                                        "        <div class=\"product\">    \n" +
                                        "            <div class=\"songName\"><h1>"+obj.getName()+"</h1></div>\n" +
                                        "                <img src=\"image/"+diskId+".jpg\" class=\"productImage\"/><br/>\n" +
                                        "                <table>\n" +
                                        "                    <tr>\n" +
                                        "                        <td class=\"fCol\">Version</td>\n" +
                                        "                        <td>"+obj.getVersion()+"</td>\n" +
                                        "                    </tr>\n" +
                                        "                    <tr>\n" +
                                        "                        <td class=\"fCol\">Casting</td>\n" +
                                        "                        <td>"+obj.getCasting()+"</td>\n" +
                                        "                    </tr>\n" +
                                        "                    <tr>\n" +
                                        "                        <td class=\"fCol\">Director</td>\n" +
                                        "                        <td>"+obj.getDirector()+"</td>\n" +
                                        "                    </tr>\n" +
                                        "                    <tr>\n" +
                                        "                        <td class=\"fCol\">Year</td>\n" +
                                        "                        <td>"+obj.getYear()+"</td>\n" +
                                        "                    </tr>\n" +
                                        "                    <tr>\n" +
                                        "                        <td class=\"fCol\">Description</td>\n" +
                                        "                        <td>"+obj.getDesc()+"</td>\n" +
                                        "                    </tr>\n" +
                                        "\n" +
                                        "                <table>\n" +
                                        "                    <br /><br />\n" +
                                        "                <div class=\"price\"> Rs. "+obj.getPrice()+" </div>    \n" +
                                        "                <center>\n" +
                                        "                    <form action=\"addToCart.action\" method=\"POST\" class=\"buyNow\"><br/>\n" +
                                        "                    <input type=\"hidden\" name=\"DiskID\" value=\""+diskId+"\" /> \n"+
                                        "                    <input type=\"textfield\" name=\"Quantity\" size=\"5\" placeholder=\"Quantity\"/><br/>\n" +
                                        "                    <input type=\"submit\" value=\"Add To Cart\"/><br/>\n" +
                                        "                    </form>\n" +
                                        "                </center>\n" +
                                        "        </div>\n" +
                                        "    </body>\n" +
                                        "</html>");
                        jspFile.flush();
                        jspFile.close();
                        return "Success";
                    }
                    catch(FileNotFoundException e)
                    {
                        System.out.println("Exception "+e);
                        return "Error";
                    }
                    finally
                    {
                        con.close();
                    }
                }
                else
                {
                    request.setAttribute("err","Cannot Insert");
                    return "Fail";
                }
            }
            else
            {
                System.out.println("Cannot Establish Connection!");
                return "Error";
            }
        }
        catch(Exception e)
        {
            System.out.println("Exception "+e);
            return "Error";
        }
    }

    @Override
    public void validate() 
    {
        
    }
    
    @Override
    public Stock getModel() 
    {
        return getObj();
    }

    /**
     * @return the obj
     */
    public Stock getObj() 
    {
        return obj;
    }

    /**
     * @param obj the obj to set
     */
    public void setObj(Stock obj) 
    {
        this.obj = obj;
    }

    /**
     * @return the dbObj
     */
    public DatabaseClass getDbObj() 
    {
        return dbObj;
    }

    /**
     * @param dbObj the dbObj to set
     */
    public void setDbObj(DatabaseClass dbObj) 
    {
        this.dbObj = dbObj;
    }
    
}
