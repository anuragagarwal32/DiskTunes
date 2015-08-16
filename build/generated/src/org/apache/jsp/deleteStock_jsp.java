package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class deleteStock_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_s_textfield_onchange_name_label_nobody;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _jspx_tagPool_s_textfield_onchange_name_label_nobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
  }

  public void _jspDestroy() {
    _jspx_tagPool_s_textfield_onchange_name_label_nobody.release();
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
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <script type=\"text/javascript\">\n");
      out.write("            function getId(id)\n");
      out.write("            {   \n");
      out.write("                xmlHttp=GetXmlHttpObject();\n");
      out.write("                if(xmlHttp==null)\n");
      out.write("                {\n");
      out.write("                    alert(\"Your Browser Does Not Support This Website! Kindly Update your Browser\");\n");
      out.write("                    return;\n");
      out.write("                }\n");
      out.write("                var url=\"deleteStockAjax.jsp?id=\"+id;\n");
      out.write("                xmlHttp.onreadystatechange= displayId;\n");
      out.write("                xmlHttp.open(\"GET\",url,true);\n");
      out.write("                xmlHttp.send();\n");
      out.write("                \n");
      out.write("            }\n");
      out.write("            \n");
      out.write("            function displayId()\n");
      out.write("            {   \n");
      out.write("                if((xmlHttp.readyState==4 || xmlHttp.readyState==\"complete\")&& xmlHttp.status==200)\n");
      out.write("                {\n");
      out.write("                    var dataReceived=xmlHttp.responseText;\n");
      out.write("                    dataReceived =dataReceived.split(' ').join('');\n");
      out.write("                    if(dataReceived==-1)\n");
      out.write("                    {\n");
      out.write("                        document.write(\"Id Not Found! Try Again\");\n");
      out.write("                        document.getElementById(\"submitButton\").disabled=true;\n");
      out.write("                    }\n");
      out.write("                    else\n");
      out.write("                    {\n");
      out.write("                        document.write(\"Id Found\");\n");
      out.write("                        document.getElementById(\"submitButton\").disabled=false;\n");
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
      out.write("        <h1>Hello World!</h1>\n");
      out.write("        <form action=\"deleteStock.action\" method=\"POST\">\n");
      out.write("            ");
      if (_jspx_meth_s_textfield_0(_jspx_page_context))
        return;
      out.write("\n");
      out.write("            <input type=\"submit\" value=\"Delete Stock\" disabled=\"true\"/>\n");
      out.write("        </form>\n");
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

  private boolean _jspx_meth_s_textfield_0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  s:textfield
    org.apache.struts2.views.jsp.ui.TextFieldTag _jspx_th_s_textfield_0 = (org.apache.struts2.views.jsp.ui.TextFieldTag) _jspx_tagPool_s_textfield_onchange_name_label_nobody.get(org.apache.struts2.views.jsp.ui.TextFieldTag.class);
    _jspx_th_s_textfield_0.setPageContext(_jspx_page_context);
    _jspx_th_s_textfield_0.setParent(null);
    _jspx_th_s_textfield_0.setName("DiskID");
    _jspx_th_s_textfield_0.setLabel("Disk Id");
    _jspx_th_s_textfield_0.setOnchange("getId(this.value)");
    int _jspx_eval_s_textfield_0 = _jspx_th_s_textfield_0.doStartTag();
    if (_jspx_th_s_textfield_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_s_textfield_onchange_name_label_nobody.reuse(_jspx_th_s_textfield_0);
      return true;
    }
    _jspx_tagPool_s_textfield_onchange_name_label_nobody.reuse(_jspx_th_s_textfield_0);
    return false;
  }
}
