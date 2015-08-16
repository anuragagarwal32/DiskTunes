
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s" %>
<%@include file="layout/header.html" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link type="text/css" rel="stylesheet" href="layout/custom.css" />
        <script type="text/javascript">
            function getStatus(id)
            {   
                xmlHttp=GetXmlHttpObject();
                if(xmlHttp==null)
                {
                    alert("Your Browser Does Not Support This Website! Kindly Update your Browser");
                    return;
                }
                var url="statusAjax.jsp?id="+id;
                xmlHttp.onreadystatechange= displayStatus;
                xmlHttp.open("GET",url,true);
                xmlHttp.send();
                
            }
            
            function displayStatus()
            {   
                if((xmlHttp.readyState==4 || xmlHttp.readyState=="complete")&& xmlHttp.status==200)
                {
                    var dataReceived=xmlHttp.responseText;
                    dataReceived =dataReceived.split(' ').join('');
                    if(dataReceived==0)
                    {
                        document.getElementById("status").selectedIndex=1;
                        document.getElementById("submitButton").disabled=false;
                    }
                    else if(dataReceived==1)
                    {
                        document.getElementById("status").selectedIndex=2;
                        document.getElementById("submitButton").disabled=false;
                    }
                    else
                    {
                        document.getElementById("status").selectedIndex=0;
                        document.getElementById("submitButton").disabled=true;
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
        <h1 class="heading">Manage User Login Account</h1>
        <form action="statusAction.action">    
            <table>
                <tr>
                    <td>
                        <span class="fCol">LoginID</span> 
                        <input type="text" name="loginId" id="loginId" maxLength="45" onchange="getStatus(this.value);"/>
                        <%--
                        <s:textfield name="loginId" id="loginId" maxLength="45" onchange="getStatus(this.value);"/>
                        --%>
                        <span class="fCol">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Status</span>
                        <select name="status" id="status">
                        <option value="-1" selected disabled="true">Invalid ID</option>
                        <option value="Activated">Activated</option>
                        <option value="Deactivated">Deactivated</option>
                        <option value="Delete">Delete</option>
                   </select>
                    </td>
                </tr>
            </table>
            <input type="submit" value="Submit" id="submitButton" disabled="true">
        </form>
        </center>
        </div>
    </body>
</html>