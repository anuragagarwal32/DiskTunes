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
public class MufaInsert extends ActionSupport implements ModelDriven<UserAccount>
{
    private UserAccount obj=new UserAccount();
    private DatabaseClass dbObj=new DatabaseClass();
    @Override
    public String execute() throws Exception 
    {
        HttpServletRequest request= ServletActionContext.getRequest();
        Connection con=getDbObj().getConnection();
        try
        {
            if(con!=null)
            {
                PreparedStatement pst= con.prepareStatement("UPDATE UserAccount SET Balance=? WHERE LoginID=?");
                System.out.println("data here "+getObj().getLoginId());
                pst.setInt(1, Integer.parseInt(getObj().getNbal()));
                pst.setString(2, getObj().getLoginId());
                int status=pst.executeUpdate();
                if(status>0)
                {
                    request.setAttribute("msg","Balance Updated for Login Id : "+getObj().getLoginId());
                }
                else
                {
                    request.setAttribute("err", "Error Encountered Cannot Update Balance");
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

    @Override
    public void validate() 
    {
        if(getObj().getNbal()==null || getObj().getNbal().equals(""))
        {
            addFieldError("nbal", "Invalid Balance");
        }
    }
    @Override
    public UserAccount getModel() 
    {
        return getObj();
    }

    /**
     * @return the obj
     */
    public UserAccount getObj() {
        return obj;
    }

    /**
     * @param obj the obj to set
     */
    public void setObj(UserAccount obj) {
        this.obj = obj;
    }

    /**
     * @return the dbObj
     */
    public DatabaseClass getDbObj() {
        return dbObj;
    }

    /**
     * @param dbObj the dbObj to set
     */
    public void setDbObj(DatabaseClass dbObj) {
        this.dbObj = dbObj;
    }
}
