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
import java.sql.Statement;
import java.util.Date;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.apache.struts2.ServletActionContext;

/**
 *
 * @author ubuntu
 */
public class Cart extends ActionSupport implements ModelDriven<Order>
{
    
    private Order obj=new Order();
    private DatabaseClass dbObj=new DatabaseClass();
    @Override
    public String execute() throws Exception 
    {
        try
        {
            Connection con=getDbObj().getConnection();
            PreparedStatement pst;
            Date date1;
            ResultSet rs;
            Statement st;
            int DiskID, previousQuantity, Quantity, status;
            String LoginID;
            HttpSession session;
            HttpServletRequest request;
            if(con!=null)
            {
                request= ServletActionContext.getRequest();
                session= request.getSession(false);
                DiskID=Integer.parseInt(request.getParameter("DiskID"));
                LoginID=(String) session.getAttribute("LoginID");
                Quantity=Integer.parseInt(request.getParameter("Quantity"));
                if(Quantity>0)
                {
                    st=con.createStatement();
                    rs=st.executeQuery("SELECT Quantity FROM CartMaster WHERE LoginID='"+LoginID+"' AND DiskID="+DiskID + " AND OrderID=-1");
                    if(rs.next())
                    {
                        //Update
                        previousQuantity = rs.getInt(1);
                        st= con.createStatement();
                        status=st.executeUpdate("UPDATE CartMaster SET Quantity="+(previousQuantity+Quantity)+" WHERE DiskID="+DiskID+" AND LoginID='"+LoginID+"' AND OrderID=-1");
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
                        pst=con.prepareStatement("INSERT INTO CartMaster(LoginID, DiskID, OrderID, Quantity) VALUES (?,?,-1,?)");
                        pst.setString(1,LoginID);
                        pst.setInt(2,DiskID);
                        pst.setInt(3, Quantity);
                        status= pst.executeUpdate();
                        if(status>0)
                        {
                            return "Success";
                        }
                        else
                        {
                            return "Fail";
                        }   
                    }
                }
                else
                {
                    request.setAttribute("err", "Quantity Must be Greater Than 0");
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
