<%-- 
    Document   : index
    Created on : 26 Jul, 2015, 5:00:11 PM
    Author     : ubuntu
--%>

<!-- LOGIN PAGE-->
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s" %>
<%@include file="layout/header.html" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        
    </head>
    <body>
        <c:if test="${requestScope['javax.servlet.forward.request_uri'] ne '/DiskTunes/productView.action'}">
            <%
                System.out.println("LOL HERE : "+request.getAttribute("javax.servlet.forward.request_uri"));
                response.sendRedirect("productView.action");
                
            %>
        </c:if>
        <!-- LOGIN FORM WAS HERE-->
            <br />
        ${requestScope.msg}
        <h1>View All Stock</h1>
        <table>
            <%! 
                int counter=0;
            %>
            <c:forEach var="list" items="${arrayList}">
                <%
                    if(counter==3)
                    {
                %>
                <tr>
                <%
                    }
                %>
                    
                    <td>
                        <%
                            counter++;
                        %>
                        <a href="product/${list.id}.jsp"><img src="product/image/${list.image}.jpg" height="100" width="100" /></a>
                        
                        <br />
                        <a href="product/${list.id}.jsp">${list.name}</a>
                    </td>
                <%
                    if(counter==3)
                    {
                %>
                </tr>
                <%
                    counter=0;
                    }
                %>
            </c:forEach>
        </table>
        <br /><br /><br />
        <table>
            <tr>
                <td>
                    <c:if test="${currentPage !=1}" >
                        <a href="productView.action?page=${currentPage -1}">Previous</a>
                    </c:if>
                </td>
                <c:forEach begin="1" end="${noOfPages}" var="i" >
                    <c:choose>
                        <c:when test="${currentPage eq i}">
                            <td>${i}</td>
                        </c:when>
                        <c:otherwise>
                            <td><a href="productView.action?page=${i}">${i}</a></td>
                        </c:otherwise>
                    </c:choose> 
                </c:forEach>
                <td>
                    <c:if test="${currentPage != noOfPages}" >
                        <a href="productView.action?page=${currentPage +1}">Next</a>
                    </c:if>
                </td>
            </tr>
        </table>
    </body>
</html>
