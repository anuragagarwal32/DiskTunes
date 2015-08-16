<%-- 
    Document   : mufa
    Created on : 26 Jul, 2015, 9:17:20 PM
    Author     : ubuntu
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s" %>
<%@include file="layout/header.html" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link type="text/css" rel="stylesheet" href="layout/custom.css" />
        <script type="text/javascript">
            function getBal(id)
            {   
                xmlHttp=GetXmlHttpObject();
                if(xmlHttp==null)
                {
                    alert("Your Browser Does Not Support This Website! Kindly Update your Browser");
                    return;
                }
                var url="mufaAjax.jsp?id="+id;
                xmlHttp.onreadystatechange= displayBal;
                xmlHttp.open("GET",url,true);
                xmlHttp.send();
                
            }
            
            function displayBal()
            {   
                document.getElementById("cbal").value="";
                document.getElementById("nbal").value="";
                if((xmlHttp.readyState==4 || xmlHttp.readyState=="complete")&& xmlHttp.status==200)
                {
                    var dataReceived=xmlHttp.responseText;
                    if(dataReceived==-1)
                    {
                        document.getElementById("cbal").value="Invalid Id";
                        document.getElementById("submitButton").disabled=true;
                    }
                    else
                    {
                        document.getElementById("cbal").value= dataReceived.split(' ').join('');
                        document.getElementById("submitButton").disabled=false;
                    }
                    
                }
                
            }
            function GetXmlHttpObject()
            {   
                var xmlHttp=null;
                try
                {
                    xmlHttp=new XMLHttpRequest();
                }
                catch(e)
                {
                    try
                    {
                        xmlHttp=new ActiveXObject("Msxml2.XMLHTTP");
                        
                    }
                    catch(e)
                    {
                        xmlHttp=new ActiveXObject("Microsoft.XMLHTTP");
                    }
                }
                return xmlHttp;
                
            } 
        </script>
    </head>
    <body>
        <div class="bodyTag">
        <center>
        <h1>Manage User Financial Account</h1>
        <form action="mufaAction.action">    
            <!-- onkeyup for checking at every key press-->
            <table>
                <tr>
                    <td class="fCol">UserID</td>
                    <td><input type="text" name="loginId" id="loginId" onchange="getBal(this.value);" /></td>
                    <%--    
                        <s:textfield name="loginId" id="loginId" onchange="getBal(this.value);"/>
                    --%>
                </tr>
                <tr>
                    <td class="fCol">Current Balance</td> 
                    <td><input type="text" name="cbal" id="cbal" readonly="true"/></td>
                    <%--
                    <s:textfield name="cbal" id="cbal" readonly="true"/>
                    --%>
                </tr>  
                <tr>
                    <td class="fCol">New Balance</td>
                    <td><input type="text" name="nbal" id="nbal" /></td>
                    <%--
                    <s:textfield name="nbal" id="nbal" />
                    --%>
                </tr>
            </table>
            <input type="submit" value="Submit" id="submitButton" class="submitButton" disabled="true"/>
            ${requestScope.err} ${requestScope.msg}
        </form>
        </center>
        </div>
    </body>
</html>
