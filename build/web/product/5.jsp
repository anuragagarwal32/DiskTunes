<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Disk Tunes</title>
    </head>
    <body>
    		
		<h1>Aaf</h1><br/>
fddsf<br/>
<img src="image/5.jpg" height=50 width=50 /><br/>
		Casting :dgdsg<br/>
		Director :dsgsj<br/>
		Year : 2000<br/>
		Quantity Left :20<br/>
		Price : 100<br/>
		Description : affd<br/>
    	<form action="addToCart.action" method="POST"><br/>
    		<input type="textfield" name="quantity" /><br/>
    		<input type="submit" value="Add To Cart"/><br/>
    		<%
    			request.setAttribute("LoginID","5");
    			request.setAttribute("Price","100");
    		%>
    	</form>
    </body>
</html>