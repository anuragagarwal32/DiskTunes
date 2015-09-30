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
import java.net.URL;
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
                    String imagePath="/home/raxor/NetBeansProjects/DiskTunes/web/product/image/";
                    String jspPath="/home/raxor/NetBeansProjects/DiskTunes/web/product/";
                    System.out.println("Content type "+getObj().getImageContentType());
                    try
                    {   
                        file=new File(imagePath, diskId+".jpg");
                        FileUtils.copyFile(getObj().getImage(), file);
                        jspFile=new FileWriter(jspPath+diskId+".jsp");
                        jspFile.write("<%@page contentType=\"text/html\" pageEncoding=\"UTF-8\"%>\n" +
                                        "<%@taglib uri=\"/struts-tags\" prefix=\"s\" %>\n" +
                                        "<%@include file=\"../layout/header.html\" %>\n" +
                                        "<%@taglib uri=\"http://java.sun.com/jsp/jstl/core\" prefix=\"c\"%>"+
                                        "<!DOCTYPE html>\n" +
                                        "<html>\n" +
                                        "    <head>\n" +
                                        "        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n" +
                                        "        <link type=\"text/css\" rel=\"stylesheet\" href=\"../layout/custom.css\" />\n" +
                                        "        <link type=\"text/css\" rel=\"stylesheet\" href=\"../layout/product.css\" />"+
                                        "        <style>\n" +
                                    "            .songNameFinal{\n" +
                                    "                position: relative;\n" +
                                    "                top: -10px;\n" +
                                    "                font-size: 35px;\n" +
                                    "                color: #8efd39;\n" +
                                    "                font-family: Hobo Std;\n" +
                                    "            }\n" +
                                        "        </style>"+
                                        "        <script type=\"text/javascript\">\n" +
                                        "            function checkQuantity(quantity)\n" +
                                        "            {   \n" +
                                        "                xmlHttp=GetXmlHttpObject();\n" +
                                        "                \n" +
                                        "                if(xmlHttp==null)\n" +
                                        "                {\n" +
                                        "                    alert(\"Your Browser Does Not Support This Website! Kindly Update your Browser\");\n" +
                                        "                    return;\n" +
                                        "                }\n" +
                                        "                \n" +
                                        "                var url=\"quantityAjax.jsp?id=\"+"+diskId+";\n" +
                                        "                xmlHttp.onreadystatechange= displayQuantity;\n" +
                                        "                xmlHttp.open(\"GET\",url,true);\n" +
                                        "                xmlHttp.send();\n" +
                                        "            }\n" +
                                        "            \n" +
                                        "            function displayQuantity()\n" +
                                        "            {   \n" +
                                        "                document.getElementById(\"submit\").disabled=true;\n" +
                                        "                \n" +
                                        "                if((xmlHttp.readyState==4 || xmlHttp.readyState==\"complete\")&& xmlHttp.status==200)\n" +
                                        "                {\n" +
                                        "                    var dataReceived=parseInt(xmlHttp.response);\n" +
                                        "                    if(dataReceived===-1)\n" +
                                        "                    {\n" +
                                        "                        alert(\"Invalid ID\");\n" +
                                        "                        document.getElementById(\"submit\").disabled=true;\n" +
                                        "                    }\n" +
                                        "                    else if(dataReceived < document.getElementById(\"Quantity\").value)\n" +
                                        "                    {\n" +
                                        "                        \n" +
                                        "                        alert(\"Stock Less\\nQuantity Left : \"+dataReceived);\n" +
                                        "                        document.getElementById(\"submit\").disabled=true;\n" +
                                        "                    }\n" +
                                        "                    else\n" +
                                        "                    {\n" +
                                        "                        document.getElementById(\"submit\").disabled=false;\n" +
                                        "                    }\n" +
                                        "                    \n" +
                                        "                }\n" +
                                        "                \n" +
                                        "            }\n" +
                                        "            function GetXmlHttpObject()\n" +
                                        "            {   \n" +
                                        "                var xmlHttp=null;\n" +
                                        "                try\n" +
                                        "                {\n" +
                                        "                    xmlHttp=new XMLHttpRequest();\n" +
                                        "                }\n" +
                                        "                catch(e)\n" +
                                        "                {\n" +
                                        "                    try\n" +
                                        "                    {\n" +
                                        "                        xmlHttp=new ActiveXObject(\"Msxml2.XMLHTTP\");\n" +
                                        "                        \n" +
                                        "                    }\n" +
                                        "                    catch(e)\n" +
                                        "                    {\n" +
                                        "                        xmlHttp=new ActiveXObject(\"Microsoft.XMLHTTP\");\n" +
                                        "                    }\n" +
                                        "                }\n" +
                                        "                return xmlHttp;\n" +
                                        "                \n" +
                                        "            } \n" +
                                        "        </script>"+
                                        "    </head>\n" +
                                        "    <body>\n" +
                                        "   <c:if test=\"${sessionScope.LoginID ne null}\">\n" +
                                        "            <%@include file=\"layout/UserLook.jsp\" %>\n" +
                                        "        </c:if>\n" +
                                        "        <c:if test=\"${sessionScope.LoginID eq null}\">\n" +
                                        "            <form class=\"logInButton\" action=\"../login.jsp\">\n" +
                                        "                <input type=\"submit\" value=\"LOG IN\"/>\n" +
                                        "            </form>\n" +
                                        "            <form class=\"signUpButton\" action=\"../SignUp.jsp\">\n" +
                                        "                <input type=\"submit\" value=\"SIGN UP\"/>\n" +
                                        "            </form>\n" +
                                        "        </c:if>"+
                                        "        <div class=\"product\">    \n" +
                                        "            <div class=\"songNameFinal\"><h1>"+obj.getName()+"</h1></div><br><br><br><br>\n" +
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
                                        "                </table>\n" +
                                        "                    <br /><br />\n" +
                                        "                <div class=\"price\"> Rs. "+obj.getPrice()+" </div>    \n" +
                                        " <c:if test=\"${sessionScope.LoginID ne null}\">\n" +
                                        "                    <center>\n" +
                                        "                    <form action=\"addToCart.action\" method=\"POST\" class=\"buyNow\"><br/>\n" +
                                        "                    <input type=\"hidden\" name=\"DiskID\" value=\""+diskId+"\"/> \n" +
                                        "                    <input type=\"text\" name=\"Quantity\" size=\"5\" placeholder=\"Quantity\"/><br/>\n" +
                                        "                    <input type=\"submit\" value=\"Add To Cart\"/><br/>\n" +
                                        "                    </form>\n" +
                                        "                </center>\n" +
                                        "                </c:if>"+
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
