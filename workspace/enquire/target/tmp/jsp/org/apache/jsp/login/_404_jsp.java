package org.apache.jsp.login;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class _404_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html lang=\"en\">\r\n");
      out.write("<head>\r\n");
      out.write("<meta charset=\"utf-8\" />\r\n");
      out.write("<title>404 Error Page</title>\r\n");
      out.write("\r\n");
      out.write("<meta name=\"description\" content=\"404 Error Page\" />\r\n");
      out.write("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\" />\r\n");
      out.write("<link href=\"../css/bootstrap.min.css\" rel=\"stylesheet\" />\r\n");
      out.write("<link rel=\"stylesheet\" href=\"../css/font-awesome.min.css\" />\r\n");
      out.write("<link rel=\"stylesheet\" href=\"../css/ace-fonts.css\" />\r\n");
      out.write("<link rel=\"stylesheet\" href=\"../css/ace.min.css\" />\r\n");
      out.write("<link rel=\"stylesheet\" href=\"../css/ace-rtl.min.css\" />\r\n");
      out.write("<link rel=\"stylesheet\" href=\"../css/ace-skins.min.css\" />\r\n");
      out.write("<script src=\"../js/ace-extra.min.js\"></script>\r\n");
      out.write("\r\n");
      out.write("</head>\r\n");
      out.write("\r\n");
      out.write("<body>\r\n");
      out.write("\t<div class=\"main-content\">\r\n");
      out.write("\t\t<div class=\"page-content\">\r\n");
      out.write("\t\t\t<div class=\"row\">\r\n");
      out.write("\t\t\t\t<div class=\"col-xs-12\">\r\n");
      out.write("\t\t\t\t\t<!-- PAGE CONTENT BEGINS -->\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t<div class=\"error-container\">\r\n");
      out.write("\t\t\t\t\t\t<div class=\"well\">\r\n");
      out.write("\t\t\t\t\t\t\t<h1 class=\"grey lighter smaller\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<span class=\"blue bigger-125\"> <i class=\"icon-sitemap\"></i>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t404\r\n");
      out.write("\t\t\t\t\t\t\t\t</span> Хуудас олдсонгүй\r\n");
      out.write("\t\t\t\t\t\t\t</h1>\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\t<hr />\r\n");
      out.write("\t\t\t\t\t\t\t<div>\r\n");
      out.write("\t\t\t\t\t\t\t\t<div class=\"space\"></div>\r\n");
      out.write("\t\t\t\t\t\t\t\t<h4 class=\"smaller\">Дараах зүйлсийг шалгана уу:</h4>\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\t\t<ul class=\"list-unstyled spaced inline bigger-110 margin-15\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<li><i class=\"icon-hand-right blue\"></i> URL ээ зөв бичсэн эсэхээ шалгана уу <s:text /></li>\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<li><i class=\"icon-hand-right blue\"></i> FAQ уншина уу</li>\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<li><i class=\"icon-hand-right blue\"></i> Бидэнтэй холбоо барина уу\r\n");
      out.write("\t\t\t\t\t\t\t\t\t</li>\r\n");
      out.write("\t\t\t\t\t\t\t\t</ul>\r\n");
      out.write("\t\t\t\t\t\t\t</div>\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\t<hr />\r\n");
      out.write("\t\t\t\t\t\t\t<div class=\"space\"></div>\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\t<div class=\"center\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<a onclick=\"window.history.back()\" class=\"btn btn-grey\"> <i class=\"icon-arrow-left\"></i>\r\n");
      out.write("\t\t\t\t\t\t\t\t\tБуцах\r\n");
      out.write("\t\t\t\t\t\t\t\t</a> <a href=\"#\" class=\"btn btn-primary\"> <i\r\n");
      out.write("\t\t\t\t\t\t\t\t\tclass=\"icon-home\"></i> Нүүр\r\n");
      out.write("\t\t\t\t\t\t\t\t</a>\r\n");
      out.write("\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t<!-- PAGE CONTENT ENDS -->\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t<!-- /.col -->\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t<!-- /.row -->\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t<!-- /.page-content -->\r\n");
      out.write("\t</div>\r\n");
      out.write("\t<!-- /.main-content -->\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\t<script type=\"text/javascript\">\r\n");
      out.write("\t\twindow.jQuery\r\n");
      out.write("\t\t\t\t|| document.write(\"<script src='../js/jquery-2.0.3.min.js'>\"\r\n");
      out.write("\t\t\t\t\t\t+ \"<\"+\"/script>\");\r\n");
      out.write("\t</script>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\t<script type=\"text/javascript\">\r\n");
      out.write("\t\tif (\"ontouchend\" in document)\r\n");
      out.write("\t\t\tdocument.write(\"<script src='../js/jquery.mobile.custom.min.js'>\"\r\n");
      out.write("\t\t\t\t\t+ \"<\"+\"/script>\");\r\n");
      out.write("\t</script>\r\n");
      out.write("\t<script src=\"../js/bootstrap.min.js\"></script>\r\n");
      out.write("\t<script src=\"../js/typeahead-bs2.min.js\"></script>\r\n");
      out.write("\t<script src=\"../js/ace-elements.min.js\"></script>\r\n");
      out.write("\t<script src=\"../js/ace.min.js\"></script>\r\n");
      out.write("</body>\r\n");
      out.write("</html>\r\n");
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
