package org.apache.jsp.product;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class _16_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.ArrayList<String>(1);
    _jspx_dependants.add("/product/layout/header.html");
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

      out.write('\n');
      out.write('\n');
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
      out.write("        <link type=\"text/css\" rel=\"stylesheet\" href=\"layout/product.css\" />\n");
      out.write("        <title>Disk Tunes</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <div class=\"product\">    \n");
      out.write("            <div class=\"songName\"><h1>DiskTest</h1></div>\n");
      out.write("                <img src=\"image/16.jpg\" class=\"productImage\"/><br/>\n");
      out.write("                <table>\n");
      out.write("                    <tr>\n");
      out.write("                        <td class=\"fCol\">Version</td>\n");
      out.write("                        <td>LOL</td>\n");
      out.write("                    </tr>\n");
      out.write("                    <tr>\n");
      out.write("                        <td class=\"fCol\">Casting</td>\n");
      out.write("                        <td>asd</td>\n");
      out.write("                    </tr>\n");
      out.write("                    <tr>\n");
      out.write("                        <td class=\"fCol\">Director</td>\n");
      out.write("                        <td>LOL</td>\n");
      out.write("                    </tr>\n");
      out.write("                    <tr>\n");
      out.write("                        <td class=\"fCol\">Year</td>\n");
      out.write("                        <td>200</td>\n");
      out.write("                    </tr>\n");
      out.write("                    <tr>\n");
      out.write("                        <td class=\"fCol\">Description</td>\n");
      out.write("                        <td>Dfj</td>\n");
      out.write("                    </tr>\n");
      out.write("\n");
      out.write("                <table>\n");
      out.write("                    <br /><br />\n");
      out.write("                <div class=\"price\"> Rs. 10 </div>    \n");
      out.write("                <center>\n");
      out.write("                    <form action=\"addToCart.action\" method=\"POST\" class=\"buyNow\"><br/>\n");
      out.write("                    <input type=\"hidden\" name=\"DiskID\" value=\"16\" />                   <input type=\"textfield\" name=\"Quantity\" size=\"5\" placeholder=\"Quantity\"/><br/>\n");
      out.write("                    <input type=\"submit\" value=\"Add To Cart\"/><br/>\n");
      out.write("                    ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${requestScope.err}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\n");
      out.write("                    </form>\n");
      out.write("                </center>\n");
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