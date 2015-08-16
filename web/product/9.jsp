<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Disk Tunes</title>
    </head>
    <body>
    		
		<h1>Twinkle</h1><br/>
hathni<br/>
<img src="image/9.jpg" height=50 width=50 /><br/>
		Casting :No comments<br/>
		Director :Unknown<br/>
		Year : 1947<br/>
		Quantity Left :5000<br/>
		Price : 1<br/>
		Description : too heavy<br/>
    	<form action="addToCart.action" method="POST"><br/>
    		<input type="textfield" name="quantity" /><br/>
    		<input type="submit" value="Add To Cart"/><br/>
    		<%
    			request.setAttribute("LoginID","10");
    			request.setAttribute("Price","1");
    		%>
    	</form>
    </body>
</html>