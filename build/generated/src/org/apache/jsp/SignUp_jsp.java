package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class SignUp_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.ArrayList<String>(1);
    _jspx_dependants.add("/layout/header.html");
  }

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<!--\n");
      out.write("To change this license header, choose License Headers in Project Properties.\n");
      out.write("To change this template file, choose Tools | Templates\n");
      out.write("and open the template in the editor.\n");
      out.write("-->\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <title>Disk Tunes</title>\n");
      out.write("            <!-- <link type=\"image/jpeg\" rel=\"icon\" href=\"./img.JPG\" /> -->\n");
      out.write("            <title>Disk Tunes</title>\n");
      out.write("        <link type=\"image/jpeg\" rel=\"icon\" href=\"layout/logoIcon.jpg\" />\n");
      out.write("            <link type=\"text/css\" rel=\"stylesheet\" href=\"layout/header.css\" />\n");
      out.write("        <meta charset=\"UTF-8\">\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <div class=\"disk\">dISK</div>\n");
      out.write("        <div class=\"tunes\">tunes</div>\n");
      out.write("        <img src=\"layout/logo.jpg\" class=\"logoImage\"/>\n");
      out.write("        <img src=\"layout/toolbar.jpeg\" class=\"toolbar\"/>\n");
      out.write("\t\t<div class=\"tagline\">LOSE YOURSELF IN MUSIC</div>\n");
      out.write("\t\t<form class=\"search\" action=\"search.action\">\n");
      out.write("                    <input type=\"text\" placeholder=\"Search!\" name=\"search\" size=\"35\"/>\n");
      out.write("                        <input type=\"image\" class=\"submitButton\" src=\"layout/icon_red_search.png\"/>\n");
      out.write("\t\t</form>\n");
      out.write("        \n");
      out.write("    </body>\n");
      out.write("</html>\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <link type=\"text/css\" rel=\"stylesheet\" href=\"layout/custom.css\" />\n");
      out.write("        <script type=\"text/javascript\">\n");
      out.write("            function checkUserName(id)\n");
      out.write("            {   \n");
      out.write("                xmlHttp=GetXmlHttpObject();\n");
      out.write("                if(xmlHttp==null)\n");
      out.write("                {\n");
      out.write("                    alert(\"Your Browser Does Not Support This Website! Kindly Update your Browser\");\n");
      out.write("                    return;\n");
      out.write("                }\n");
      out.write("                var url=\"checkUserNameAjax.jsp?id=\"+id;\n");
      out.write("                xmlHttp.onreadystatechange= function()\n");
      out.write("                {\n");
      out.write("                    if((xmlHttp.readyState==4 || xmlHttp.readyState==\"complete\")&& xmlHttp.status==200)\n");
      out.write("                    {\n");
      out.write("                        var dataReceived=xmlHttp.responseText;\n");
      out.write("                        if(dataReceived==-1)\n");
      out.write("                        {\n");
      out.write("                            document.getElementById(\"loginIDinnerHTML\").innerHTML= \"Username Already Exists! Choose Another\";\n");
      out.write("                            document.getElementById(\"submitButton\").disabled=true;\n");
      out.write("                        }\n");
      out.write("                        else\n");
      out.write("                        {\n");
      out.write("                            document.getElementById(\"loginIDinnerHTML\").innerHTML= \"Username Available\";\n");
      out.write("                            document.getElementById(\"submitButton\").disabled=false;\n");
      out.write("                        }\n");
      out.write("\n");
      out.write("                    }\n");
      out.write("                }\n");
      out.write("                xmlHttp.open(\"GET\",url,true);\n");
      out.write("                xmlHttp.send();\n");
      out.write("                \n");
      out.write("            }\n");
      out.write("            \n");
      out.write("            function checkPasswordLength(password)\n");
      out.write("            {   \n");
      out.write("                if(password.length<8)\n");
      out.write("                {\n");
      out.write("                    document.getElementById(\"passwordinnerHTML\").innerHTML= \"Password must be atleast 8 characters long\";\n");
      out.write("                    document.getElementById(\"submitButton\").disabled=true;\n");
      out.write("                }\n");
      out.write("                else\n");
      out.write("                {\n");
      out.write("                    document.getElementById(\"passwordinnerHTML\").innerHTML= \"\";\n");
      out.write("                    document.getElementById(\"submitButton\").disabled=false;\n");
      out.write("                }\n");
      out.write("            }\n");
      out.write("            \n");
      out.write("            \n");
      out.write("            function checkPasswordMatch()\n");
      out.write("            {\n");
      out.write("               if(document.getElementById(\"password\").value === document.getElementById(\"cpassword\").value)\n");
      out.write("               {\n");
      out.write("                   document.getElementById(\"cpasswordinnerHTML\").innerHTML=\"Password Match\";\n");
      out.write("                   document.getElementById(\"submitButton\").disabled=false;\n");
      out.write("               }\n");
      out.write("               else\n");
      out.write("               {\n");
      out.write("                   document.getElementById(\"cpasswordinnerHTML\").innerHTML=\"Password does not Match\";\n");
      out.write("                   document.getElementById(\"submitButton\").disabled=true;\n");
      out.write("               }\n");
      out.write("            }\n");
      out.write("            function GetXmlHttpObject()\n");
      out.write("            {   \n");
      out.write("                var xmlHttp=null;\n");
      out.write("                try\n");
      out.write("                {\n");
      out.write("                    xmlHttp=new XMLHttpRequest();\n");
      out.write("                }\n");
      out.write("                catch(e)\n");
      out.write("                {\n");
      out.write("                    try\n");
      out.write("                    {\n");
      out.write("                        xmlHttp=new ActiveXObject(\"Msxml2.XMLHTTP\");\n");
      out.write("                        \n");
      out.write("                    }\n");
      out.write("                    catch(e)\n");
      out.write("                    {\n");
      out.write("                        xmlHttp=new ActiveXObject(\"Microsoft.XMLHTTP\");\n");
      out.write("                    }\n");
      out.write("                }\n");
      out.write("                return xmlHttp;\n");
      out.write("                \n");
      out.write("            } \n");
      out.write("        </script>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <div class=\"bodyTag\">\n");
      out.write("        <center>\n");
      out.write("        <h1 class=\"heading\">SIGN UP</h1>\n");
      out.write("        <form action=\"signUpAction.action\" method=\"POST\">\n");
      out.write("            <table>\n");
      out.write("                <tr>\n");
      out.write("                    <td class=\"fCol\">Username</td>\n");
      out.write("                    <td><input type=\"text\" name=\"loginID\" id=\"loginID\" onchange=\"checkUserName(this.value);\"/></td>\n");
      out.write("                    ");
      out.write("\n");
      out.write("                </tr>\n");
      out.write("                <div id=\"loginIDinnerHTML\"></div><br />\n");
      out.write("                <tr>\n");
      out.write("                    <td class=\"fCol\">Password</td>\n");
      out.write("                    <td><input type=\"password\" name=\"password\" id=\"password\" onkeyup=\"checkPasswordLength(this.value);\"></td>\n");
      out.write("                </tr>\n");
      out.write("                <div id=\"passwordinnerHTML\"></div><br />\n");
      out.write("                <tr>\n");
      out.write("                    <td class=\"fCol\">Confirm Password</td>\n");
      out.write("                    <td><input type=\"password\" name=\"cpassword\" id=\"cpassword\" onkeyup=\"checkPasswordMatch();\"></td>\n");
      out.write("                </tr>\n");
      out.write("                <div id=\"cpasswordinnerHTML\"></div><br />\n");
      out.write("                <tr>\n");
      out.write("                    <td class=\"fCol\">First Name</td>\n");
      out.write("                    <td><input type=\"text\" name=\"firstname\" id=\"firstname\"></td>\n");
      out.write("                </tr>\n");
      out.write("                <tr>\n");
      out.write("                    <td class=\"fCol\">Last Name</td>\n");
      out.write("                    <td><input type=\"text\" name=\"lastname\" id=\"lastname\"></td>\n");
      out.write("                </tr>\n");
      out.write("                <tr>\n");
      out.write("                    <td class=\"fCol\">Mobile</td>\n");
      out.write("                    <td><input type=\"text\" name=\"mobile\" id=\"mobile\"></td>\n");
      out.write("                </tr>\n");
      out.write("                <tr>\n");
      out.write("                    <td class=\"fCol\">Email ID</td>\n");
      out.write("                    <td><input type=\"text\" name=\"email\" id=\"email\"></td>\n");
      out.write("                </tr>\n");
      out.write("                <tr>\n");
      out.write("                    <td class=\"fCol\">Street</td>\n");
      out.write("                    <td><input type=\"text\" name=\"street\" id=\"street\"></td>\n");
      out.write("                </tr>\n");
      out.write("                <tr>\n");
      out.write("                    <td class=\"fCol\">City</td>\n");
      out.write("                    <td><input type=\"text\" name=\"city\" id=\"city\"></td>\n");
      out.write("                </tr>\n");
      out.write("                <tr>\n");
      out.write("                    <td class=\"fCol\">State</td>\n");
      out.write("                    <td><input type=\"text\" name=\"state\" id=\"state\"></td>\n");
      out.write("                </tr>\n");
      out.write("                <tr>\n");
      out.write("                    <td class=\"fCol\">Country</td>\n");
      out.write("                    <td><input type=\"text\" name=\"country\" id=\"country\"></td>\n");
      out.write("                </tr>\n");
      out.write("                <tr>\n");
      out.write("                    <td class=\"fCol\">Occupation</td>\n");
      out.write("                    <td><input type=\"text\" name=\"occupation\" id=\"occupation\"></td>\n");
      out.write("                </tr>                \n");
      out.write("            </table>\n");
      out.write("            \n");
      out.write("          ");
      out.write("\n");
      out.write("            <input type=\"submit\" value=\"SignUp\" name=\"SignUP\" id=\"submitButton\" disabled=\"true\"/>\n");
      out.write("        </form>\n");
      out.write("        </center>\n");
      out.write("        </div>\n");
      out.write("            \n");
      out.write("        ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${requestScope.err}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\n");
      out.write("        ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${requestScope.msg}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\n");
      out.write("    </body>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
