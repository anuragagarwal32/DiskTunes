/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.project;

import com.opensymphony.xwork2.ActionSupport;
import java.io.File;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.servlet.http.HttpServletRequest;
import org.apache.struts2.ServletActionContext;

/**
 *
 * @author ubuntu
 */
public class DeleteStock extends ActionSupport
{
    private String stockId;
    private DatabaseClass dbObj=new DatabaseClass();
    Connection con;
    HttpServletRequest request;
    public String execute() throws Exception
    {
        try
        {
            con=getDbObj().getConnection();
            request= ServletActionContext.getRequest();
            String query;
            Statement st;
            query="SELECT DiskID from StockMaster WHERE StockID="+getStockId();
            st=con.createStatement();
            ResultSet rs= st.executeQuery(query);
            if(rs.next())
            {
                int diskId= rs.getInt(1);
                System.out.println(diskId);
                query="DELETE FROM StockMaster WHERE StockID="+getStockId();
                st= con.createStatement();
                int status= st.executeUpdate(query);
                if(status>0)
                {
                     File file=new File("/home/ubuntu/NetBeansProjects/DiskTunes/web/product/"+diskId+".jsp");
                     if(file.delete())
                     {
                         File imageFile=new File("/home/ubuntu/NetBeansProjects/DiskTunes/web/product/image/"+diskId+".jpg");
                         if(imageFile.delete())
                         {
                             request.setAttribute("msg", "Stock Successfully Deleted");
                         }
                         else
                         {
                             request.setAttribute("err", "Error Occured! Please Try Again Later file");
                             return "Fail";
                         }
                     }
                     else
                     {
                         request.setAttribute("err", "Error Occured! Please Try Again Later image file");
                         return "Fail";
                     }
                    return "Success";
                }
                else
                {
                    request.setAttribute("err", "Error Occured! Please Try Again Later");
                    return "Fail";
                }
            }
            else
            {
                request.setAttribute("err", "Error Occured! Please Try Again Later");
                return "Fail";
            }
        }
        catch(Exception e)
        {
            System.out.println("Exception : "+e);
            return "error";
        }
        
    }

    @Override
    public void validate()
    {
        if(getStockId().equals("") || getStockId()==null)
        {
            addFieldError("submitButton", "Invalid Stock ID");
        }
    }

    /**
     * @return the stockId
     */
    public String getStockId()
    {
        return stockId;
    }

    /**
     * @param stockId the stockId to set
     */
    public void setStockId(String stockId)
    {
        this.stockId = stockId;
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
