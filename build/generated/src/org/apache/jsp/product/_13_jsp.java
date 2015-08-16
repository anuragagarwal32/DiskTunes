package org.apache.jsp.product;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class _13_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

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
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>Disk Tunes</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("    \t\t\n");
      out.write("\t\t<h1>fad</h1>\n");
      out.write("grg\n");
      out.write("<img src=\"images/13.jpg\" height=50 width=50 />\n");
      out.write("\t\tCasting :hthe\n");
      out.write("\t\tDirector :etrt\n");
      out.write("\t\tYear : 2000\n");
      out.write("\t\tQuantity Left :50\n");
      out.write("\t\tPrice : 1000\n");
      out.write("\t\tDescription : sdsfgsf\n");
      out.write("    \t<form action=\"addToCart.action\" method=\"POST\">\n");
      out.write("    \t\t<input type=\"textfield\" name=\"quantity\" />\n");
      out.write("    \t\t<input type=\"submit\" value=\"Add To Cart\"/>\n");
      out.write("    \t\t");

    			request.setAttribute("LoginID","7");
    			request.setAttribute("Price","1000");
    		
      out.write("\n");
      out.write("    \t</form>\n");
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
