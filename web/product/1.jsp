<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Disk Tunes</title>
    </head>
    <body>
    		
		<h1>dfsfj</h1><br/>
efsd<br/>
<img src="image/1.jpg" height=50 width=50 /><br/>
		Casting :jfdsjk<br/>
		Director :jsdfsjk<br/>
		Year : 2000<br/>
		Quantity Left :200<br/>
		Price : 2000<br/>
		Description : jfd<br/>
    	<form action="addToCart.action" method="POST"><br/>
    		<input type="textfield" name="quantity" /><br/>
    		<input type="submit" value="Add To Cart"/><br/>
    		<%
    			request.setAttribute("LoginID","1");
    			request.setAttribute("Price","2000");
    		%>
    	</form>
    </body>
</html>