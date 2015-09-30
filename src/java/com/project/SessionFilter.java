/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.project;

import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.struts2.ServletActionContext;

/**
 *
 * @author ubuntu
 */
@WebFilter(filterName = "SessionFilter", urlPatterns =
{
    "/*"
})
public class SessionFilter implements Filter
{
    
    private static final boolean debug = true;

    // The filter configuration object we are associated with.  If
    // this value is null, this filter instance is not currently
    // configured. 
    private FilterConfig filterConfig = null;
    
    public SessionFilter()
    {
    }    
    
    private void doBeforeProcessing(ServletRequest request, ServletResponse response)
            throws IOException, ServletException
    {
        
        
        
    }    
    
    private void doAfterProcessing(ServletRequest request, ServletResponse response)
            throws IOException, ServletException
    {
        if (debug)
        {
            log("SessionFilter:DoAfterProcessing");
        }

	
    }

    /**
     *
     * @param request The servlet request we are processing
     * @param response The servlet response we are creating
     * @param chain The filter chain we are processing
     *
     * @exception IOException if an input/output error occurs
     * @exception ServletException if a servlet error occurs
     */
    public void doFilter(ServletRequest request, ServletResponse response,
            FilterChain chain)
            throws IOException, ServletException
    {
        HttpServletRequest httpServletRequest= (HttpServletRequest) request;
        HttpServletResponse httpServletResponse=(HttpServletResponse) response;
        HttpSession session=  httpServletRequest.getSession(false);
        String path = httpServletRequest.getRequestURI();
        
        System.out.println("IN FILTER : "+path);
        
        // Admin and User differentiate using admin/ folder and user as it is.
        if(session==null || session.getAttribute("LoginID")==null)
        {   
            if (path.startsWith("/DiskTunes/index.jsp") || path.startsWith("/DiskTunes/login.jsp") || path.startsWith("/DiskTunes/SignUp.jsp") ) 
            {
                chain.doFilter(request, response); // Just continue chain.
            }
            else if(path.startsWith("/DiskTunes/product/"))
            {
                chain.doFilter(request, response);
            }
            else if(path.startsWith("/DiskTunes/layout/"))
            {
                chain.doFilter(request, response);
            }
            else
            {
                httpServletResponse.sendRedirect("index.jsp");
            }
        }
        else
        {
            if(path.startsWith("/DiskTunes/Mula.jsp") || path.startsWith("statusAjax.jsp") || path.startsWith("stockIdAjax.jsp") || path.startsWith("checkUserNameAjax.jsp") || path.startsWith("deleteStockAjax.jsp") || path.startsWith("/DiskTunes/dashboardadmin.jsp") || path.startsWith("/DiskTunes/checkPlacedOrders.jsp") || path.startsWith("/DiskTunes/OrderStatus.jsp") || path.startsWith("/DiskTunes/AddStock.jsp") || path.startsWith("/DiskTunes/deleteStock.jsp") || path.startsWith("/DiskTunes/ViewAllStock.jsp"))
            {
                if(session.getAttribute("Role").equals("Admin"))
                {
                    chain.doFilter(request, response);
                }
                else
                {
                    httpServletResponse.sendRedirect("dashboard.jsp");
                }
            }
            chain.doFilter(request, response);
        }
        
    }

    /**
     * Return the filter configuration object for this filter.
     */
    public FilterConfig getFilterConfig()
    {
        return (this.filterConfig);
    }

    /**
     * Set the filter configuration object for this filter.
     *
     * @param filterConfig The filter configuration object
     */
    public void setFilterConfig(FilterConfig filterConfig)
    {
        this.filterConfig = filterConfig;
    }

    /**
     * Destroy method for this filter
     */
    public void destroy()
    {        
    }

    /**
     * Init method for this filter
     */
    public void init(FilterConfig filterConfig)
    {        
        this.filterConfig = filterConfig;
        if (filterConfig != null)
        {
            if (debug)
            {                
                log("SessionFilter:Initializing filter");
            }
        }
    }

    /**
     * Return a String representation of this object.
     */
    @Override
    public String toString()
    {
        if (filterConfig == null)
        {
            return ("SessionFilter()");
        }
        StringBuffer sb = new StringBuffer("SessionFilter(");
        sb.append(filterConfig);
        sb.append(")");
        return (sb.toString());
    }
    
    private void sendProcessingError(Throwable t, ServletResponse response)
    {
        String stackTrace = getStackTrace(t);        
        
        if (stackTrace != null && !stackTrace.equals(""))
        {
            try
            {
                response.setContentType("text/html");
                PrintStream ps = new PrintStream(response.getOutputStream());
                PrintWriter pw = new PrintWriter(ps);                
                pw.print("<html>\n<head>\n<title>Error</title>\n</head>\n<body>\n"); //NOI18N

                // PENDING! Localize this for next official release
                pw.print("<h1>The resource did not process correctly</h1>\n<pre>\n");                
                pw.print(stackTrace);                
                pw.print("</pre></body>\n</html>"); //NOI18N
                pw.close();
                ps.close();
                response.getOutputStream().close();
            } catch (Exception ex)
            {
            }
        } else
        {
            try
            {
                PrintStream ps = new PrintStream(response.getOutputStream());
                t.printStackTrace(ps);
                ps.close();
                response.getOutputStream().close();
            } catch (Exception ex)
            {
            }
        }
    }
    
    public static String getStackTrace(Throwable t)
    {
        String stackTrace = null;
        try
        {
            StringWriter sw = new StringWriter();
            PrintWriter pw = new PrintWriter(sw);
            t.printStackTrace(pw);
            pw.close();
            sw.close();
            stackTrace = sw.getBuffer().toString();
        } catch (Exception ex)
        {
        }
        return stackTrace;
    }
    
    public void log(String msg)
    {
        filterConfig.getServletContext().log(msg);        
    }
    
}
