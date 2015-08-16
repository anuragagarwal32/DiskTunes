package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class Mula_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("            function getStatus(id)\n");
      out.write("            {   \n");
      out.write("                xmlHttp=GetXmlHttpObject();\n");
      out.write("                if(xmlHttp==null)\n");
      out.write("                {\n");
      out.write("                    alert(\"Your Browser Does Not Support This Website! Kindly Update your Browser\");\n");
      out.write("                    return;\n");
      out.write("                }\n");
      out.write("                var url=\"statusAjax.jsp?id=\"+id;\n");
      out.write("                xmlHttp.onreadystatechange= displayStatus;\n");
      out.write("                xmlHttp.open(\"GET\",url,true);\n");
      out.write("                xmlHttp.send();\n");
      out.write("                \n");
      out.write("            }\n");
      out.write("            \n");
      out.write("            function displayStatus()\n");
      out.write("            {   \n");
      out.write("                if((xmlHttp.readyState==4 || xmlHttp.readyState==\"complete\")&& xmlHttp.status==200)\n");
      out.write("                {\n");
      out.write("                    var dataReceived=xmlHttp.responseText;\n");
      out.write("                    dataReceived =dataReceived.split(' ').join('');\n");
      out.write("                    if(dataReceived==0)\n");
      out.write("                    {\n");
      out.write("                        document.getElementById(\"status\").selectedIndex=1;\n");
      out.write("                        document.getElementById(\"submitButton\").disabled=false;\n");
      out.write("                    }\n");
      out.write("                    else if(dataReceived==1)\n");
      out.write("                    {\n");
      out.write("                        document.getElementById(\"status\").selectedIndex=2;\n");
      out.write("                        document.getElementById(\"submitButton\").disabled=false;\n");
      out.write("                    }\n");
      out.write("                    else\n");
      out.write("                    {\n");
      out.write("                        document.getElementById(\"status\").selectedIndex=0;\n");
      out.write("                        document.getElementById(\"submitButton\").disabled=true;\n");
      out.write("                    }\n");
      out.write("                }\n");
      out.write("                \n");
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
      out.write("        <h1 class=\"heading\">Manage User Login Account</h1>\n");
      out.write("        <form action=\"statusAction.action\">    \n");
      out.write("            <table>\n");
      out.write("                <tr>\n");
      out.write("                    <td>\n");
      out.write("                        <span class=\"fCol\">LoginID</span> \n");
      out.write("                        <input type=\"text\" name=\"loginId\" id=\"loginId\" maxLength=\"45\" onchange=\"getStatus(this.value);\"/>\n");
      out.write("                        ");
      out.write("\n");
      out.write("                        <span class=\"fCol\">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Status</span>\n");
      out.write("                        <select name=\"status\" id=\"status\">\n");
      out.write("                        <option value=\"-1\" selected disabled=\"true\">Invalid ID</option>\n");
      out.write("                        <option value=\"Activated\">Activated</option>\n");
      out.write("                        <option value=\"Deactivated\">Deactivated</option>\n");
      out.write("                        <option value=\"Delete\">Delete</option>\n");
      out.write("                   </select>\n");
      out.write("                    </td>\n");
      out.write("                </tr>\n");
      out.write("            </table>\n");
      out.write("            <input type=\"submit\" value=\"Submit\" id=\"submitButton\" disabled=\"true\">\n");
      out.write("        </form>\n");
      out.write("        </center>\n");
      out.write("        </div>\n");
      out.write("    </body>\n");
      out.write("</html>");
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
