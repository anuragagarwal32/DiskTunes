<%-- 
    Document   : dashboard
    Created on : 26 Jul, 2015, 5:44:23 PM
    Author     : ubuntu
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html>
<%--
    HttpSession nsession = request.getSession(false);
    if(nsession!=null)
    {
--%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Disk Tunes</title>
        <link type="image/jpeg" rel="icon" href="layout/logoIcon.jpg" />
    </head>
    <body>
        <h1>Dashboard</h1>
        <%
            System.out.println("LoginID : "+session.getAttribute("LoginID"));
            System.out.println("Name : "+session.getAttribute("Name"));
        %>
        <form action="signOut.action">
            <input type="submit" value="Sign Out"/>
        </form>
    </body>
</html>
<%--
    }
    else
    {
        //redirect to index.jsp
    }
--%>
