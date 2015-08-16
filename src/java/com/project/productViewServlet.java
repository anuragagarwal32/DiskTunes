/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.project;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts2.ServletActionContext;

/**
 *
 * @author ubuntu
 */
public class productViewServlet extends HttpServlet
{

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        response.setContentType("text/html;charset=UTF-8");
        DatabaseClass dbObj=new DatabaseClass();
        Connection con;
        Product productObj=null;
        ArrayList<Product> arrayList;
        int noOfRecords;
        int noOfPages;
        int noOfRecordsPerPage;
        int offset;
        int page;
        Statement st;
        ResultSet rs;
        //RequestDispatcher requestDispatcher=null;
        try (PrintWriter out = response.getWriter())
        {
            
            con= dbObj.getConnection();
            
            noOfRecordsPerPage=12;
            page=1;
            if(request.getParameter("page")!=null)
            {
                page=Integer.parseInt(request.getParameter("page"));
            }
            offset=(page - 1) * noOfRecordsPerPage;
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
                
                //return "Fail";
            }
            rs.close();
            System.out.println("noOfRecords = "+noOfRecords+ " perPage = "+noOfRecordsPerPage);
            noOfPages=(int) Math.ceil(noOfRecords / noOfRecordsPerPage);
            query="SELECT DiskID, StockName, Image FROM StockMaster LIMIT "+offset+", "+noOfRecordsPerPage;
            st=con.createStatement();
            rs=st.executeQuery(query);
            arrayList=new ArrayList<Product>();
            while(rs.next())
            {
                productObj=new Product();
                productObj.setId(rs.getInt(1));
                productObj.setName(rs.getString(2));
                productObj.setImage(rs.getString(1));
                arrayList.add(productObj);
            }
            //requestDispatcher= getServletContext().getRequestDispatcher("index.jsp");
            response.sendRedirect("/index.jsp");
            request.setAttribute("arrayList", arrayList);
            request.setAttribute("noOfPages", noOfPages);
            request.setAttribute("currentPage", page);
            //requestDispatcher.forward(request, response);
        }
        catch(Exception e)
        {
            e.printStackTrace();
            //return "Error";
        }
        
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo()
    {
        return "Short description";
    }// </editor-fold>

}
