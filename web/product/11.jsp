<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s" %>
<%@include file="layout/header.html" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link type="text/css" rel="stylesheet" href="layout/product.css" />
        <title>Disk Tunes</title>
    </head>
    <body>
        <div class="product">    
            <div class="songName"><h1>Neendran</h1></div>
                <img src="image/11.jpg" class="productImage"/><br/>
                <table>
                    <tr>
                        <td class="fCol">Version</td>
                        <td>Punjabi</td>
                    </tr>
                    <tr>
                        <td class="fCol">Casting</td>
                        <td>Amrinder Gill, Isha Rikhi</td>
                    </tr>
                    <tr>
                        <td class="fCol">Director</td>
                        <td>Amarpreet G.S. Chabbra</td>
                    </tr>
                    <tr>
                        <td class="fCol">Year</td>
                        <td>2014</td>
                    </tr>
                    <tr>
                        <td class="fCol">Description</td>
                        <td>Punjabi Romantic Song</td>
                    </tr>

                <table>
                    <br /><br />
                <div class="price"> Rs. 250 </div>    
                <center>
                    <form action="addToCart.action" method="POST" class="buyNow"><br/>
                    <input type="textfield" name="quantity" size="5" placeholder="Quantity"/><br/>
                    <input type="submit" value="Add To Cart"/><br/>
                    <%
                            request.setAttribute("LoginID","1");
                            request.setAttribute("Price","2000");
                    %>
                    </form>
                </center>
        </div>
    </body>
</html>