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
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts2.ServletActionContext;

/**
 *
 * @author ubuntu
 */
public class productView extends ActionSupport implements ModelDriven<Product>
{
    
    private Product productObj=null;
    private DatabaseClass dbObj=new DatabaseClass();
    private ArrayList<Product> arrayList;
    
    public String execute() throws Exception
    {
        
        Statement st;
        ResultSet rs;
        HttpServletRequest request;
        HttpServletResponse response;
        int noOfRecords;
        int noOfPages;
        int noOfRecordsPerPage;
        int offset;
        int page;
        try
        {
            request= ServletActionContext.getRequest();
            response= ServletActionContext.getResponse();
            noOfRecordsPerPage=12;
            page=1;
            if(request.getParameter("page")!=null)
            {
                page=Integer.parseInt(request.getParameter("page"));
            }
            offset=(page - 1) * noOfRecordsPerPage;
            Connection con = getDbObj().getConnection();
            String query="SELECT COUNT(*) FROM StockMaster ";
            st= con.createStatement();
            rs= st.executeQuery(query);
            if(rs.next())
            {
                noOfRecords=rs.getInt(1);
            }
            else
            {
                noOfRecords=0;
                return "Fail";
            }
            rs.close();
            /*Ceil not working properly
            if((Math.ceil(getNoOfRecords() / getNoOfRecordsPerPage())- ((int) Math.ceil(getNoOfRecords() / getNoOfRecordsPerPage()))) > 0.0)
            {
                setNoOfPages(((int) Math.ceil(getNoOfRecords() / getNoOfRecordsPerPage()))+1);
            }
            else
            {
                setNoOfPages((int) Math.ceil(getNoOfRecords() / getNoOfRecordsPerPage()));
            }*/
            noOfPages=(int) Math.ceil((float)noOfRecords / noOfRecordsPerPage);
            
            //System.out.println("Page ceil = "+Math.ceil((float)noOfRecords / noOfRecordsPerPage));
            query="SELECT DiskID, StockName, Image FROM StockMaster LIMIT "+offset+", "+noOfRecordsPerPage;
            st=con.createStatement();
            rs=st.executeQuery(query);
            setArrayList(new ArrayList<Product>());
            while(rs.next())
            {
                setProductObj(new Product());
                getProductObj().setId(rs.getInt(1));
                getProductObj().setName(rs.getString(2));
                getProductObj().setImage(rs.getString(1));
                getArrayList().add(getProductObj());
            }
            
            request.setAttribute("arrayList", getArrayList());
            request.setAttribute("noOfPages", noOfPages);
            request.setAttribute("currentPage", page);
        }
        catch(Exception e)
        {
            e.printStackTrace();
            return "Error";
        }
        return "Success";
    }

    /**
     * @return the productObj
     */
    public Product getProductObj()
    {
        return productObj;
    }

    /**
     * @param productObj the productObj to set
     */
    public void setProductObj(Product productObj)
    {
        this.productObj = productObj;
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
    public ArrayList<Product> getArrayList()
    {
        return arrayList;
    }

    /**
     * @param arrayList the arrayList to set
     */
    public void setArrayList(ArrayList<Product> arrayList)
    {
        this.arrayList = arrayList;
    }

    @Override
    public Product getModel()
    {
        return productObj;
    }

    
    
}
