/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.project;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.servlet.http.HttpServletRequest;
import org.apache.struts2.ServletActionContext;

/**
 *
 * @author ubuntu
 */
public class MufaInsert extends ActionSupport
{
    
    private DatabaseClass dbObj=new DatabaseClass();
    @Override
    public String execute() throws Exception 
    {
        HttpServletRequest request= ServletActionContext.getRequest();
        Connection con=dbObj.getConnection();
        try
        {
            String status=request.getParameter("status");
            String loginid=request.getParameter("loginId");
            if(con!=null)
            {
                PreparedStatement pst= con.prepareStatement("UPDATE LoginMaster SET Status=? WHERE LoginID=?");
                pst.setString(1, status);
                pst.setString(2, loginid);
                int success= pst.executeUpdate();
                if(success>0)
                {
                    
                }
                
            }
            else
            {
                System.out.println("Cannot Establish Connection with Database");
            }
            return "Success";
        }
        catch(SQLException | NullPointerException e)
        {
            System.out.println("Exception Occured : "+e);
            return "Error";
        }
        finally
        {
            con.close();
        }
    }

    
}
