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

/**
 *
 * @author ubuntu
 */
public class SignUp extends ActionSupport implements ModelDriven<MemberDetail>
{
    private String password;
    private MemberDetail obj=new MemberDetail();
    private DatabaseClass dbObj;
    public String execute() throws Exception
    {
        Connection con;
        PreparedStatement pst;
        int status1, status2;
        try
        {
            setDbObj(new DatabaseClass());
            con=getDbObj().getConnection();
            
            pst=con.prepareStatement("INSERT INTO MemberDetail values(?,?,?,?,?,?,?,?,?,?)");
            pst.setString(1, getObj().getLoginID());
            pst.setString(2, getObj().getFirstname());
            pst.setString(3, getObj().getLastname());
            pst.setString(4, getObj().getMobile());
            pst.setString(5, getObj().getEmail());
            pst.setString(6, getObj().getStreet());
            pst.setString(7, getObj().getCity());
            pst.setString(8, getObj().getState());
            pst.setString(9, getObj().getCountry());
            pst.setString(10, getObj().getOccupation());
            
            status1=pst.executeUpdate();
            
            pst=con.prepareStatement("INSERT INTO LoginMaster values(?,?,'User','Activated')");
            pst.setString(1, getObj().getLoginID());
            pst.setString(2, getPassword());
            
            status2=pst.executeUpdate();
            
            if(status1>0 && status2>0)
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
            System.out.println("Exception : "+e);
            return "Error";
        }
        
    }

    @Override
    public void validate()
    {
        if(getObj().getLoginID()==null)
        {
        
        }
    }
    
    @Override
    public MemberDetail getModel()
    {
        return getObj();
    }

    /**
     * @return the password
     */
    public String getPassword()
    {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password)
    {
        this.password = password;
    }

    /**
     * @return the obj
     */
    public MemberDetail getObj()
    {
        return obj;
    }

    /**
     * @param obj the obj to set
     */
    public void setObj(MemberDetail obj)
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
