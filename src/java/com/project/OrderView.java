/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.project;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.apache.struts2.ServletActionContext;

/**
 *
 * @author ubuntu
 */
public class OrderView extends ActionSupport implements ModelDriven<OrderMaster>
{
    private OrderMaster obj=null;
    private DatabaseClass dbObj=new DatabaseClass();
    private ArrayList<OrderMaster> arrayList;
    public String execute() throws Exception
    {
        Connection con;
        Statement st;
        ResultSet rs;
        HttpServletRequest request;
        HttpSession session;
        try
        {
            con= getDbObj().getConnection();
            request= ServletActionContext.getRequest();
            session= request.getSession(false);
            arrayList=new ArrayList<OrderMaster>();
            String loginID =(String) session.getAttribute("LoginID");
            System.out.println("LoginID : "+loginID);
            st= con.createStatement();
            rs= st.executeQuery("SELECT OrderID, Price, OrderDate, Status FROM OrderMaster WHERE OrderID in (SELECT distinct(OrderID) FROM CartMaster WHERE LoginID='"+loginID+"')");
            while(rs.next())
            {
                setObj(new OrderMaster());
                getObj().setOrderID(rs.getInt(1));
                getObj().setPrice(rs.getInt(2));
                getObj().setOrderDate(rs.getDate(3));
                getObj().setStatus(rs.getString(4));
                getArrayList().add(getObj());
            }
            request.setAttribute("arrayList", getArrayList());
        }
        catch(Exception e)
        {
            e.printStackTrace();
            return "Error";
        }
        return "Success";
    }

    @Override
    public OrderMaster getModel()
    {
        return getObj();
    }

    /**
     * @return the obj
     */
    public OrderMaster getObj()
    {
        return obj;
    }

    /**
     * @param obj the obj to set
     */
    public void setObj(OrderMaster obj)
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

    /**
     * @return the arrayList
     */
    public ArrayList<OrderMaster> getArrayList()
    {
        return arrayList;
    }

    /**
     * @param arrayList the arrayList to set
     */
    public void setArrayList(ArrayList<OrderMaster> arrayList)
    {
        this.arrayList = arrayList;
    }
    
}
