package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class UpdateOrder_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("\t\t<form class=\"search\">\n");
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
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <div class=\"bodyTag\">\n");
      out.write("        <center>\n");
      out.write("        <h1 class=\"heading\">UPDATE YOUR ORDER HERE</h1>\n");
      out.write("        <form method=\"POST\" action=\"UpdateOrder.action\">\n");
      out.write("            <table>\n");
      out.write("                <tr>\n");
      out.write("                    <td class=\"fCol\">Login ID</td>\n");
      out.write("                    <td><input type=\"text\" /></td>\n");
      out.write("                </tr>\n");
      out.write("                ");
      out.write("\n");
      out.write("                <tr>\n");
      out.write("                    <td class=\"fCol\">Stock ID</td>\n");
      out.write("                    <td><input type=\"text\" name=\"stockID\" maxLength=\"15\"/></td>\n");
      out.write("                </tr>\n");
      out.write("                ");
      out.write("\n");
      out.write("                <tr>\n");
      out.write("                    <td class=\"fCol\">Quantity</td>\n");
      out.write("                    <td><input type=\"text\" name=\"quantity\" maxLength=\"45\"/></td>\n");
      out.write("                </tr>\n");
      out.write("                ");
      out.write("\n");
      out.write("            </table>\n");
      out.write("            <input type=\"submit\" value=\"UPDATE\" class=\"submitButton\">\n");
      out.write("        </form>\n");
      out.write("        </center>\n");
      out.write("        </div>\n");
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
