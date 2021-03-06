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
public class CartView extends ActionSupport implements ModelDriven<CartClass>
{
    CartClass obj=null;
    DatabaseClass dbObj=new DatabaseClass();
    private ArrayList<CartClass> arrayList;
    public String execute() throws Exception
    {
        Connection con;
        ResultSet resultSet1, resultSet2;
        Statement st;
        HttpServletRequest request;
        HttpSession session;
        try
        {
            request= ServletActionContext.getRequest();
            session=request.getSession(false);
            arrayList=new ArrayList<CartClass>();
            con= dbObj.getConnection();
            st=con.createStatement();
            resultSet1=st.executeQuery("SELECT DiskID, Quantity FROM CartMaster WHERE LoginID='"+session.getAttribute("LoginID")+"' AND OrderID=-1");
            while(resultSet1.next())
            {
                obj=new CartClass();
                obj.setDiskID(resultSet1.getInt(1));
                obj.setQuantity(resultSet1.getInt(2));
                st=con.createStatement();
                resultSet2=st.executeQuery("SELECT StockName, Price FROM StockMaster WHERE DiskID="+obj.getDiskID());
                if(resultSet2.next())
                {
                    obj.setName(resultSet2.getString(1));
                    obj.setPrice(resultSet2.getInt(2));
                    arrayList.add(obj);
                }
            }
            request.setAttribute("arrayList", arrayList);
            /*else
            {
                return "noItemInCart";
            }*/
            return "Success";
        }
        catch(Exception e)
        {
            e.printStackTrace();
            return "Error";
        }
    }

    @Override
    public CartClass getModel()
    {
        return obj;
    }
    
}
