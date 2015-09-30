/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.project;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.apache.struts2.ServletActionContext;

/**
 *
 * @author raxor
 */
public class AddBal 
{    
    DatabaseClass dbObj=new DatabaseClass();
    public String execute() throws Exception 
    {
        Connection con;
        Statement statement;
        ResultSet resultSet;
        HttpServletRequest request;
        HttpSession session;
        int status;
        int pBal;
        try
        {
            request= ServletActionContext.getRequest();
            session= request.getSession(false);
            con= dbObj.getConnection();
            statement= con.createStatement();
            resultSet= statement.executeQuery("SELECT Balance FROM UserAccount WHERE LoginID='"+session.getAttribute("LoginID")+"'");
            resultSet.next();
            pBal= resultSet.getInt(1);
            status= statement.executeUpdate("UPDATE UserAccount SET Balance="+(pBal+Integer.parseInt(request.getParameter("amount")))+" WHERE LoginID='"+session.getAttribute("LoginID")+"'");
            if(status<0)
                return "Error";
        }
        catch(Exception e)
        {
            e.printStackTrace();
            return "Error";
        }
        return "Success";
    }
    
}
