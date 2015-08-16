<%-- 
    Document   : cart
    Created on : 15 Aug, 2015, 2:08:24 PM
    Author     : ubuntu
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>CART</h1>
        <c:if test="${requestScope['javax.servlet.forward.request_uri'] ne '/DiskTunes/cartView.action'}">
            <%
                System.out.println("LOL HERE : "+request.getAttribute("javax.servlet.forward.request_uri"));
                response.sendRedirect("cartView.action");
            %>
        </c:if>
        <%
                int counter=0;
        %>
        <c:forEach var="list" items="${arrayList}">
            <br/>
            <%
                counter++;
            %>
            <a href="product/${list.diskID}.jsp">${list.name}</a><br/>
            Quantity <form action="updateCart.action">
                        <input type="hidden" name="diskID" value="${list.diskID}" />
                        <input type="text" name="quantity" value="${list.quantity}" />
                        <input type="submit" value="Update" />
                     </form>
                    <br />
                    <form action="deleteCart.action">
                        <input type="hidden" name="DiskID" value="${list.diskID}" />
                        <input type="submit" value="Remove" />
                    </form>
            Price   ${list.price}
        </c:forEach>
            <%
                if(counter==0)
                {   
            %>
                Cart is Empty!
            <%
                }
                else
                {
            %>
            <form action="placeOrder.action">
                <input type="submit" value="Place Order" />
            </form>
            <%
                }
            %>
    </body>
</html>
