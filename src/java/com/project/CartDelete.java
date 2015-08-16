/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.project;

import com.opensymphony.xwork2.ActionSupport;
import java.sql.Connection;
import java.sql.Statement;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.apache.struts2.ServletActionContext;

/**
 *
 * @author ubuntu
 */
public class CartDelete extends ActionSupport
{
    DatabaseClass dbObj=new DatabaseClass();
    public String execute() throws Exception
    {
        Connection con;
        Statement st;
        int status;
        int quantity, diskID;
        HttpServletRequest request;
        HttpSession session;
        try
        {
            con= dbObj.getConnection();
            request= ServletActionContext.getRequest();
            session= request.getSession(false);
            st=con.createStatement();
            diskID= Integer.parseInt(request.getParameter("diskID"));
            status= st.executeUpdate("DELETE FROM CartMaster WHERE LoginID='"+session.getAttribute("LoginID")+"' AND DiskID="+diskID+" AND OrderID=-1");
            if(status > 0)
            {
                return "Success";
            }
            else
            {
                return "Fail";
            }
            
        }
        catch(Exception e)
        {
            e.printStackTrace();
            return "Error";
        }
    }
    
}
