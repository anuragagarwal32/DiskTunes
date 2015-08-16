<%@page import="java.sql.ResultSet"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Disk Tunes</title>
    </head>
        <h1>All Stock</h1>
        <center><table border="1">
                <tr>
                    <th>Stock Name</th>
                    <th>Version</th>
                    <th>Casting</th>
                    <th>Director</th>
                    <th>Year</th>
                    <th>Quantity</th>
                    <th>Price</th>
                </tr>
                <s:iterator value="userList">
             <tr>
                 <td><s:property value="StockName"/></td>
                 <td><s:property value="Version"/></td>
                 <td><s:property value="Casting"/></td>
                 <td><s:property value="Director"/></td>  
                 <td><s:property value="Year"/></td>
                 <td><s:property value="Quantity"/></td>
                 <td><s:property value="Price"/></td>
             </tr>
             </s:iterator>
            
            </table>
            
        </center>
</html>