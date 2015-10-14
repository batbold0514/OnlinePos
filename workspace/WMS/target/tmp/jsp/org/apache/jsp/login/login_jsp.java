package org.apache.jsp.login;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class login_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html lang=\"mn\">\r\n");
      out.write("\t<head>\r\n");
      out.write("\t\t<meta charset=\"UTF-8\">\r\n");
      out.write("\t\t<meta http-equiv=\"content-type\" content=\"text/html; charset=UTF-8\">\r\n");
      out.write("\t\t<meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\r\n");
      out.write("\t\t<meta name=\"description\" content=\"Warehouse Management System\">\r\n");
      out.write("\t\t<meta name=\"keywords\" content=\"Warehouse management system, Агуулах удирдах систем, Warehouse, Агуулах\">\r\n");
      out.write("\t\t<meta name=\"author\" content=\"Macs Progress LLC\">\r\n");
      out.write("\t\t<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t<link rel=\"shortcut icon\" type=\"image/x-icon\" href=\"../favicon.ico\">\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t<title>WMS - Нэвтрэх хуудас</title>\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t<link rel=\"stylesheet\" href=\"../css/bootstrap.min.css\">\r\n");
      out.write("\t\t<link rel=\"stylesheet\" href=\"../css/font-awesome.min.css\">\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t<!-- Our team CSS -->\r\n");
      out.write("\t\t<link rel=\"stylesheet\" href=\"../css/signin.css\">\r\n");
      out.write("\t\t<style type=\"text/css\">\r\n");
      out.write("\t\t</style>\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t<script type=\"text/javascript\" src=\"../js/jquery-1.11.0.min.js\"></script>\r\n");
      out.write("\t\t<script type=\"text/javascript\" src=\"../js/bootstrap.min.js\"></script>\r\n");
      out.write("\t\t<script type=\"text/javascript\" src=\"../js/jquery.validate.min.js\"></script>\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t<!-- Our team JS -->\r\n");
      out.write("\t\t<script type=\"text/javascript\" src=\"../js/page-js/signin.js\"></script>\r\n");
      out.write("\t\t<script type=\"text/javascript\">\r\n");
      out.write("\t\t\t$(document).ready(function()\r\n");
      out.write("\t\t\t{\r\n");
      out.write("\t\t\t});\r\n");
      out.write("\t\t</script>\r\n");
      out.write("\t</head>\r\n");
      out.write("\t\r\n");
      out.write("\t<body>\r\n");
      out.write("\t\t<div class=\"container\">\r\n");
      out.write("\t\t\t<form action=\"j_security_check\" method=\"POST\" class=\"form-signin\" id=\"form-login\">\r\n");
      out.write("        \t\t<h2 class=\"form-signin-heading text-center\">\r\n");
      out.write("        \t\t\t<b>Нэвтрэх хэсэг</b>\r\n");
      out.write("        \t\t</h2>\r\n");
      out.write("        \t\t");

        			String errorClass = "";
        			String result = request.getParameter("result");
					if (result != null )
					{
						errorClass = "has-error";
				
      out.write("\r\n");
      out.write("\t\t\t\t<div class=\"row\">\r\n");
      out.write("\t\t\t\t\t<div class=\"col-sm-12 text-danger\">\r\n");
      out.write("\t\t\t\t\t\tНэвтрэх нэр эсвэл нууц үг буруу байна!\r\n");
      out.write("\t\t\t        </div>\r\n");
      out.write("\t\t        </div>\r\n");
      out.write("        \t\t<div class=\"form-group ");
      out.print( errorClass );
      out.write("\">\r\n");
      out.write("        \t\t\t<label class=\"error\" for=\"j_username\"></label>\r\n");
      out.write("        \t\t\t<input type=\"text\" name=\"j_username\" class=\"form-control\" placeholder=\"Нэвтрэх нэр\" id=\"j_username\" autofocus />\r\n");
      out.write("        \t\t</div>\r\n");
      out.write("        \t\t<div class=\"form-group ");
      out.print( errorClass );
      out.write("\">\r\n");
      out.write("        \t\t\t<label class=\"error\" for=\"j_password\"></label>\r\n");
      out.write("        \t\t\t<input type=\"password\" name=\"j_password\" class=\"form-control\" placeholder=\"Нууц үг\" id=\"j_password\" />\r\n");
      out.write("        \t\t</div>\r\n");
      out.write("        \t\t<label class=\"checkbox\">\r\n");
      out.write("          \t\t\tБүртгэл \r\n");
      out.write("          \t\t\t<small>&nbsp;&rarr;&nbsp;</small>\r\n");
      out.write("          \t\t\t<a href=\"contact\">Холбоо барих</a>\r\n");
      out.write("        \t\t</label>\r\n");
      out.write("        \t\t<button type=\"submit\" class=\"btn btn-primary btn-block\">\r\n");
      out.write("        \t\t\t<i class=\"fa fa-key\"></i>&nbsp;\r\n");
      out.write("        \t\t\tНэвтрэх\r\n");
      out.write("        \t\t</button>\r\n");
      out.write("      \t\t</form>\r\n");
      out.write("      \t\t");

				}
			
      out.write("\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t</body>\r\n");
      out.write("</html> ");
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
