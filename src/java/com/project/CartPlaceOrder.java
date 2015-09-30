/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.project;

import com.opensymphony.xwork2.ActionSupport;
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
public class CartPlaceOrder extends ActionSupport
{
    DatabaseClass dbObj=new DatabaseClass();
    public String execute() throws Exception
    {
        Connection con;
        PreparedStatement pst;
        Statement st;
        ResultSet rs,rs1, rs2;
        Date date1;
        int status, bal;
        HttpServletRequest request;
        HttpSession session;
        try
        {
            con=dbObj.getConnection();
            request= ServletActionContext.getRequest();
            session=request.getSession(false);
            if(request.getParameter("pMethod").equals("bal"))
            {
                st=con.createStatement();
                rs1= st.executeQuery("SELECT Balance FROM UserAccount WHERE LoginID='"+session.getAttribute("LoginID")+"'");
                rs1.next();
                bal= rs1.getInt(1);

                if(bal < Integer.parseInt(request.getParameter("tPrice")) )
                {
                    request.setAttribute("err", "Insufficient Balance");
                    return "Fail";
                }
                else
                {
                    st=con.createStatement();
                    status= st.executeUpdate("UPDATE UserAccount SET Balance="+(bal-Integer.parseInt(request.getParameter("tPrice")))+" WHERE LoginID='"+session.getAttribute("LoginID")+"'");
                }
            }
            pst= con.prepareStatement("INSERT INTO OrderMaster(OrderDate, Status, Price) VALUES (?,'Pending',?)");	
            date1 = new Date();
            int date,year,currentMonthInt=0;
            String month;
            String currentDate=date1.toString();
            date= Integer.parseInt(currentDate.substring(8,10));
            year= Integer.parseInt(currentDate.substring(24,28));
            month=currentDate.substring(4,7);
            switch(month)
            {
                    case "Jan": currentMonthInt=1;
                                    break;
                    case "Feb": currentMonthInt=2;
                                    break;
                    case "Mar": currentMonthInt=3;
                                    break;
                    case "Apr": currentMonthInt=4;
                                    break;
                    case "May": currentMonthInt=5;
                                    break;
                    case "Jun": currentMonthInt=6;
                                    break;
                    case "Jul": currentMonthInt=7;
                                    break;
                    case "Aug": currentMonthInt=8;
                                    break;
                    case "Sep": currentMonthInt=9;
                                    break;
                    case "Oct": currentMonthInt=10;
                                    break;
                    case "Nov": currentMonthInt=11;
                                    break;
                    case "Dec": currentMonthInt=12;
                                    break;

            }
            pst.setString(1, year+"-"+currentMonthInt+"-"+date);
            pst.setInt(2, Integer.parseInt(request.getParameter("tPrice")));
            status=pst.executeUpdate();
            if(status<=0)
            {
                return "Fail";
            }
            st=con.createStatement();
            rs=st.executeQuery("SELECT MAX(OrderID) FROM OrderMaster");
            //OrderView too
            rs.next();
            int OrderID= rs.getInt(1);
            st=con.createStatement();
            rs2= st.executeQuery("SELECT DiskID, Quantity FROM CartMaster WHERE LoginID='"+(String)session.getAttribute("LoginID")+"' AND OrderID=-1");
            while(rs2.next())
            {
                st=con.createStatement();
                status= st.executeUpdate("UPDATE StockMaster SET Quantity=Quantity-"+rs2.getInt(2)+" WHERE DiskID="+rs2.getInt(1));
                if(status==0)
                    return "Fail";
            }
            st=con.createStatement();
            status= st.executeUpdate("UPDATE CartMaster SET OrderID="+OrderID+" WHERE LoginID='"+(String)session.getAttribute("LoginID")+"' AND OrderID=-1");
            if(status>0)
                return "Success";
            else
                return "Fail";
            
            
        }
        catch(Exception e)
        {
            e.printStackTrace();
            return "Error";
        }
    }
    
}
