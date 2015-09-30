package com.project;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import java.sql.*;
import java.util.Date;
/**
 *
 * @author twinklesharma
 */
public class DeleteOrder extends ActionSupport implements ModelDriven<Order> 
{
    
    private Order obj=new Order();
    private DatabaseClass dbObj=new DatabaseClass();
    @Override
    public String execute() throws Exception 
    {
        try
        {
            Connection con=getDbObj().getConnection();
            if(con!=null)
            {
                PreparedStatement pst= con.prepareStatement("DELETE FROM  OrderMaster WHERE LoginID=?");
                pst.setString(1,getObj().getLoginID());
     
                int status=pst.executeUpdate();
                if(status>0)
                {
                    return "Success";
                }
                else
                {
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
            System.out.println("Exception : "+e);
            return "Error";
        }
    }

     @Override
    public Order getModel() 
    {
        return obj;
    }

    /**
     * @return the obj
     */
    public Order getObj() 
    {
        return obj;
    }

    /**
     * @param obj the obj to set
     */
    public void setObj(Order obj) {
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
