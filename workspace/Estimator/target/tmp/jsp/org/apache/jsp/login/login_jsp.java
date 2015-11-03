package org.apache.jsp.login;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import mn.infosystems.estimator.model.Messages;
import mn.chinbat.interceptor.SessionInterceptor;

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
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html lang=\"en\">\r\n");
      out.write("\t<head>\r\n");
      out.write("\t\t<meta charset=\"utf-8\" />\r\n");
      out.write("\t\t<title>Login Page</title>\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t<meta name=\"description\" content=\"User login page\" />\r\n");
      out.write("\t\t<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\" />\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t<link href=\"../css/bootstrap.min.css\" rel=\"stylesheet\" />\r\n");
      out.write("\t\t<link rel=\"stylesheet\" href=\"../css/font-awesome.min.css\" />\r\n");
      out.write("\t\t<link rel=\"stylesheet\" href=\"../css/ace-fonts.css\" />\r\n");
      out.write("\t\t<link rel=\"stylesheet\" href=\"../css/ace.min.css\" />\r\n");
      out.write("\t\t<style>\r\n");
      out.write("\t\t\thtml, body\r\n");
      out.write("\t\t\t{\r\n");
      out.write("\t\t\t\tfont-family: \"Helvetica Neue\",Helvetica,Arial,sans-serif !important;\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t</style>\r\n");
      out.write("\t</head>\r\n");
      out.write("\t\r\n");
      out.write("\t<body class=\"login-layout\">\r\n");
      out.write("\t\t<div class=\"main-container\">\r\n");
      out.write("\t\t\t<div class=\"main-content\">\r\n");
      out.write("\t\t\t\t<div class=\"row\">\r\n");
      out.write("\t\t\t\t\t<div class=\"col-sm-10 col-sm-offset-1\">\r\n");
      out.write("\t\t\t\t\t\t<div class=\"login-container\">\r\n");
      out.write("\t\t\t\t\t\t\t<div class=\"center\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<h1>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<i class=\"icon-home green\"></i> <span class=\"green\">Estimator</span> <span\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\tclass=\"white\">Application</span>\r\n");
      out.write("\t\t\t\t\t\t\t\t</h1>\r\n");
      out.write("\t\t\t\t\t\t\t\t<h4 class=\"blue\">&copy; Infosystems</h4>\r\n");
      out.write("\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\r\n");
      out.write("\t\t\t\t\t\t\t<div class=\"space-6\"></div>\r\n");
      out.write("\t\r\n");
      out.write("\t\t\t\t\t\t\t<div class=\"position-relative\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<div id=\"login-box\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\tclass=\"login-box visible widget-box no-border\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<div class=\"widget-body\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<div class=\"widget-main\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t<h4 class=\"header blue lighter bigger\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t<i class=\"icon-coffee green\"></i> Мэдээллээ оруулна уу\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t</h4>\r\n");
      out.write("\t\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t<div class=\"space-6\"></div>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t");
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t");

												String result = request.getParameter("result");
													if (result == null)
														result = "";
													if (result.equalsIgnoreCase("false")) {
											
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t<span style=\"color: red\">");
out.print(Messages.getString("wrongNameOrPassword")); 
      out.write("</span> \r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t");

												}
											
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t<form method=\"POST\" action=\"j_security_check\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t<fieldset>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t<label class=\"block clearfix\"> <span\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\tclass=\"block input-icon input-icon-right\"> <input\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\ttype=\"text\" name=\"j_username\" class=\"form-control focus\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tplaceholder=\"Хэрэглэгчийн нэр\" autofocus=\"autofocus\" /> <i\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tclass=\"icon-user\"></i>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t</span>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t</label> <label class=\"block clearfix\"> <span\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\tclass=\"block input-icon input-icon-right\"> <input\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\ttype=\"password\" name=\"j_password\" class=\"form-control\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tplaceholder=\"Нууц үг\"> <i class=\"icon-lock\"></i>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t</span>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t</label>\r\n");
      out.write("\t\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"space\"></div>\r\n");
      out.write("\t\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"clearfix\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t<button type=\"submit\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tclass=\"width-35 pull-right btn btn-sm btn-primary\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<i class=\"icon-key\"></i> Нэвтрэх\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t</button>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"space-4\"></div>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t</fieldset>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t</form>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t");
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<!-- /widget-body -->\r\n");
      out.write("\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t<!-- /login-box -->\r\n");
      out.write("\t\r\n");
      out.write("\t\t\t\t\t\t\t\t<div id=\"forgot-box\" class=\"forgot-box widget-box no-border\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<div class=\"widget-body\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<div class=\"widget-main\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t<h4 class=\"header red lighter bigger\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t<i class=\"icon-key\"></i> Retrieve Password\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t</h4>\r\n");
      out.write("\t\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t<div class=\"space-6\"></div>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t<p>Enter your email and to receive instructions</p>\r\n");
      out.write("\t\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t<form>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t<fieldset>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t<label class=\"block clearfix\"> <span\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\tclass=\"block input-icon input-icon-right\"> <input\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\ttype=\"email\" class=\"form-control\" placeholder=\"Email\" />\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<i class=\"icon-envelope\"></i>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t</span>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t</label>\r\n");
      out.write("\t\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"clearfix\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t<button type=\"button\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tclass=\"width-35 pull-right btn btn-sm btn-danger\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<i class=\"icon-lightbulb\"></i> Send Me!\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t</button>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t</fieldset>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t</form>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<!-- /widget-main -->\r\n");
      out.write("\t\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<div class=\"toolbar center\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t<a href=\"#\" onclick=\"show_box('login-box'); return false;\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\tclass=\"back-to-login-link\"> Back to login <i\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\tclass=\"icon-arrow-right\"></i>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t</a>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<!-- /widget-body -->\r\n");
      out.write("\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t<!-- /forgot-box -->\r\n");
      out.write("\t\r\n");
      out.write("\t\t\t\t\t\t\t\t<div id=\"signup-box\" class=\"signup-box widget-box no-border\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<div class=\"widget-body\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<div class=\"widget-main\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t<h4 class=\"header green lighter bigger\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t<i class=\"icon-group blue\"></i> New User Registration\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t</h4>\r\n");
      out.write("\t\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t<div class=\"space-6\"></div>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t<p>Enter your details to begin:</p>\r\n");
      out.write("\t\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t<form>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t<fieldset>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t<label class=\"block clearfix\"> <span\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\tclass=\"block input-icon input-icon-right\"> <input\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\ttype=\"email\" class=\"form-control\" placeholder=\"Email\" />\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<i class=\"icon-envelope\"></i>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t</span>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t</label> <label class=\"block clearfix\"> <span\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\tclass=\"block input-icon input-icon-right\"> <input\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\ttype=\"text\" class=\"form-control\" placeholder=\"Username\" />\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<i class=\"icon-user\"></i>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t</span>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t</label> <label class=\"block clearfix\"> <span\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\tclass=\"block input-icon input-icon-right\"> <input\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\ttype=\"password\" class=\"form-control\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tplaceholder=\"Password\" /> <i class=\"icon-lock\"></i>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t</span>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t</label> <label class=\"block clearfix\"> <span\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\tclass=\"block input-icon input-icon-right\"> <input\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\ttype=\"password\" class=\"form-control\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tplaceholder=\"Repeat password\" /> <i class=\"icon-retweet\"></i>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t</span>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t</label> <label class=\"block\"> <input type=\"checkbox\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\tclass=\"ace\" /> <span class=\"lbl\"> I accept the <a\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\thref=\"#\">User Agreement</a>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t</span>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t</label>\r\n");
      out.write("\t\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"space-24\"></div>\r\n");
      out.write("\t\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"clearfix\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t<button type=\"reset\" class=\"width-30 pull-left btn btn-sm\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<i class=\"icon-refresh\"></i> Reset\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t</button>\r\n");
      out.write("\t\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t<button type=\"button\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tclass=\"width-65 pull-right btn btn-sm btn-success\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tRegister <i class=\"icon-arrow-right icon-on-right\"></i>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t</button>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t</fieldset>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t</form>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<div class=\"toolbar center\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t<a href=\"#\" onclick=\"show_box('login-box'); return false;\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\tclass=\"back-to-login-link\"> <i class=\"icon-arrow-left\"></i>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\tBack to login\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t</a>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<!-- /widget-body -->\r\n");
      out.write("\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t<!-- /signup-box -->\r\n");
      out.write("\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t<!-- /position-relative -->\r\n");
      out.write("\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t<!-- /.col -->\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t<!-- /.row -->\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t<!-- /.main-container -->\r\n");
      out.write("\t\r\n");
      out.write("\t\t<!-- basic scripts -->\r\n");
      out.write("\t\r\n");
      out.write("\t\t<!--[if !IE]> -->\r\n");
      out.write("\t\r\n");
      out.write("\t\t");
      out.write("\r\n");
      out.write("\t\r\n");
      out.write("\t\t<!-- <![endif]-->\r\n");
      out.write("\t\r\n");
      out.write("\t\t<!--[if IE]>\r\n");
      out.write("\t<script type=\"text/javascript\">\r\n");
      out.write("\t window.jQuery || document.write(\"<script src='assets/js/jquery-1.10.2.min.js'>\"+\"<\"+\"/script>\");\r\n");
      out.write("\t</script>\r\n");
      out.write("\t<![endif]-->\r\n");
      out.write("\t\r\n");
      out.write("\t\t<script type=\"text/javascript\">\r\n");
      out.write("\t\t\tif (\"ontouchend\" in document)\r\n");
      out.write("\t\t\t\tdocument.write(\"<script src='../js/jquery.mobile.custom.min.js'>\"\r\n");
      out.write("\t\t\t\t\t\t+ \"<\"+\"/script>\");\r\n");
      out.write("\t\t</script>\r\n");
      out.write("\t\r\n");
      out.write("\t\t<!-- inline scripts related to this page -->\r\n");
      out.write("\t\r\n");
      out.write("\t\t<script type=\"text/javascript\">\r\n");
      out.write("\t\t\tfunction show_box(id) {\r\n");
      out.write("\t\t\t\tjQuery('.widget-box.visible').removeClass('visible');\r\n");
      out.write("\t\t\t\tjQuery('#' + id).addClass('visible');\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t</script>\r\n");
      out.write("\t</body>\r\n");
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
