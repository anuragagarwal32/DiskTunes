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
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.struts2.ServletActionContext;

/**
 *
 * @author ubuntu
 */
public class Login extends ActionSupport implements ModelDriven<LoginClass>
{
    private LoginClass obj=new LoginClass();
    private DatabaseClass dbObj=new DatabaseClass();
    
    @Override
    public String execute() throws Exception 
    {
        Connection con=null;
        try
        {   
            HttpServletRequest request= ServletActionContext.getRequest();
            HttpServletResponse response;
            PreparedStatement pst;
            ResultSet rs;
            HttpSession sess;
            String fname;
            con=dbObj.getConnection();
            if(con!=null)
            {
                
               /* sess = request.getSession(false);
                System.out.println(obj.getUsername());
                if(sess==null)    
                {*/
                    response= ServletActionContext.getResponse();
                    System.out.println(obj.getUsername());
                    pst = con.prepareStatement("SELECT FirstName from MemberDetail where LoginID=?");
                    pst.setString(1,obj.getUsername());
                    rs=pst.executeQuery();
                    if(rs.next())
                    {
                        fname= rs.getString(1);
                    }
                    else
                    {
                        fname=null;
                    }
                    pst = con.prepareStatement("SELECT LoginID, Password, Status, Role from LoginMaster where LoginID=?");
                    pst.setString(1,obj.getUsername());
                    rs = pst.executeQuery();
                    if(rs.next())
                    {   
                        if(rs.getString(2).equals(obj.getPassword()))
                        {   
                            if(rs.getString(3).equals("Activated"))
                            {
                                sess = request.getSession(true);
                                sess.setAttribute("LoginID", rs.getString(1));
                                sess.setAttribute("Role", rs.getString(4));
                                sess.setAttribute("Name", fname);
                                if(rs.getString(4).equals("Admin"))
                                {
                                    return "Admin";
                                }
                                return "Success";
                            }
                            else
                            {
                                request.setAttribute("err","Your Account is Deactivated");
                                return "Fail";
                            }
                        }
                        else
                        {
                            request.setAttribute("err","Login Failed! Invalid Username or Password");
                            return "Fail";
                        }
                    }
                    else
                    {
                        request.setAttribute("err","Login Failed! Invalid Username or Password");
                        return "Fail";
                    }
              /* }
               else
                {
                    return "Login";
                }*/
            }
            else
            {
                System.out.println("Cannot Establish a Connection with Database");
                return "Error";
            }
            
        }
        catch(SQLException | NullPointerException e)
        {
            System.out.println("Exception Caught : "+e);
            return "Error";
        }
        finally
        {
            con.close();
        }
    }
    @Override
    public void validate() 
    {
        if((obj.getUsername().equals("") || obj.getUsername()==null) && (obj.getPassword().equals("") || obj.getPassword()==null))
        {
            addFieldError("username", "Enter Username And Password");
        }
        else
        {
            if(obj.getUsername().equals("") || obj.getUsername()==null)
            {
                addFieldError("username", "Enter Username");
            }
            if(obj.getPassword().equals("") || obj.getPassword()==null)
            {
                addFieldError("password", "Enter Password");
            }
        }
    }

    @Override
    public LoginClass getModel() 
    {
        return obj;
    }
    
}
