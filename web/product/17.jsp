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
            <div class="songName"><h1>Kindle</h1></div>
                <img src="image/17.jpg" class="productImage"/><br/>
                <table>
                    <tr>
                        <td class="fCol">Version</td>
                        <td>asd</td>
                    </tr>
                    <tr>
                        <td class="fCol">Casting</td>
                        <td>dfdf</td>
                    </tr>
                    <tr>
                        <td class="fCol">Director</td>
                        <td>gfgr</td>
                    </tr>
                    <tr>
                        <td class="fCol">Year</td>
                        <td>1999</td>
                    </tr>
                    <tr>
                        <td class="fCol">Description</td>
                        <td>sadad</td>
                    </tr>

                <table>
                    <br /><br />
                <div class="price"> Rs. 100 </div>    
                <center>
                    <form action="addToCart.action" method="POST" class="buyNow"><br/>
                    <input type="hidden" name="DiskID" value="17" /> 
                    <input type="textfield" name="Quantity" size="5" placeholder="Quantity"/><br/>
                    <input type="submit" value="Add To Cart"/><br/>
                    </form>
                </center>
        </div>
    </body>
</html>