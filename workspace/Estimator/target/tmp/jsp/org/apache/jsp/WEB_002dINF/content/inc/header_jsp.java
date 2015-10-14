package org.apache.jsp.WEB_002dINF.content.inc;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class header_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_s_form_id_cssClass;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_s_hidden_value_name_nobody;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_s_textfield_value_name_id_nobody;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_s_text_name_nobody;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _jspx_tagPool_s_form_id_cssClass = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_s_hidden_value_name_nobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_s_textfield_value_name_id_nobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_s_text_name_nobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
  }

  public void _jspDestroy() {
    _jspx_tagPool_s_form_id_cssClass.release();
    _jspx_tagPool_s_hidden_value_name_nobody.release();
    _jspx_tagPool_s_textfield_value_name_id_nobody.release();
    _jspx_tagPool_s_text_name_nobody.release();
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
      out.write("<!-- BEGIN TOP NAVIGATION BAR -->\r\n");
      out.write("<div class=\"header-inner\">\r\n");
      out.write("\t<!-- BEGIN LOGO -->\r\n");
      out.write("\t<a class=\"navbar-brand\" href=\"usersList\"> <img\r\n");
      out.write("\t\tsrc=\"../img/master-unelgee.png\" alt=\"logo\" class=\"img-responsive\" />\r\n");
      out.write("\t</a>\r\n");
      out.write("\r\n");
      out.write("\t<!-- END LOGO -->\r\n");
      out.write("\t<!-- BEGIN RESPONSIVE MENU TOGGLER -->\r\n");
      out.write("\t<a href=\"javascript:;\" class=\"navbar-toggle\" data-toggle=\"collapse\"\r\n");
      out.write("\t\tdata-target=\".navbar-collapse\"> <img\r\n");
      out.write("\t\tsrc=\"../assets/img/menu-toggler.png\" alt=\"\" />\r\n");
      out.write("\t</a>\r\n");
      out.write("\t<!-- END RESPONSIVE MENU TOGGLER -->\r\n");
      out.write("\r\n");
      out.write("\t<ul class=\"nav pull-right\">\r\n");
      out.write("\t\t<li><a href=\"logout\"> <i class=\"icon-off\"></i> ");
      if (_jspx_meth_s_text_0(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("\t\t</a></li>\r\n");
      out.write("\t</ul>\r\n");
      out.write("</div>\r\n");
      out.write("\r\n");
      out.write("<!-- END TOP NAVIGATION BAR -->\r\n");
      out.write("<!-- END HEADER-->\r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("\tjQuery(document)\r\n");
      out.write("\t\t\t.ready(\r\n");
      out.write("\t\t\t\t\tfunction() {\r\n");
      out.write("\t\t\t\t\t\t$(\"#time\").timepicker({\r\n");
      out.write("\t\t\t\t\t\t\tminuteStep : 1,\r\n");
      out.write("\t\t\t\t\t\t\tsecondStep : 5,\r\n");
      out.write("\t\t\t\t\t\t\tshowInputs : false,\r\n");
      out.write("\t\t\t\t\t\t\ttemplate : 'modal',\r\n");
      out.write("\t\t\t\t\t\t\tmodalBackdrop : true,\r\n");
      out.write("\t\t\t\t\t\t\tshowSeconds : true,\r\n");
      out.write("\t\t\t\t\t\t\tshowMeridian : false\r\n");
      out.write("\t\t\t\t\t\t});\r\n");
      out.write("\t\t\t\t\t\t$(\"#time\").keydown(function(e) {\r\n");
      out.write("\t\t\t\t\t\t\tif (e.which == 13) {\r\n");
      out.write("\t\t\t\t\t\t\t\t$(\"#btnOk\").trigger(\"click\");\r\n");
      out.write("\t\t\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t\t\t});\r\n");
      out.write("\t\t\t\t\t\t$('#addLogoutTime')\r\n");
      out.write("\t\t\t\t\t\t\t\t.bootstrapValidator(\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t{\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\tfields : {\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\ttime : {\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\tvalidators : {\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\tnotEmpty : {\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tmessage : 'Хоосон байна'\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t},\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\tregexp : {\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tregexp : /^[0-2][0-9]:[0-5][0-9]:[0-5][0-9]$/,\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tmessage : '23:59:59 байж болно'\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t}).on(\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t'success.form.bv',\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\tfunction(e) {\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\te.preventDefault();\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t$.post('saveLogoutTime', $(\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\"#addLogoutTime\")\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t.serialize(), function(\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\tresult) {\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t$(\"#logoutTime\").html(result);\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t$(\"#dialogLogoutTime\").dialog(\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\"close\");\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\tzeroTime();\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t});\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t});\r\n");
      out.write("\t\t\t\t\t\t$(\"#logoutTimeHeader\").click(function(e) {\r\n");
      out.write("\t\t\t\t\t\t\te.preventDefault();\r\n");
      out.write("\t\t\t\t\t\t\t$(\"#dialogLogoutTime\").dialog('open');\r\n");
      out.write("\t\t\t\t\t\t});\r\n");
      out.write("\t\t\t\t\t\t$(\"#dialogLogoutTime\")\r\n");
      out.write("\t\t\t\t\t\t\t\t.dialog(\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t{\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\ttitle : 'Гарах хугацаа',\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\ttitle_html : true,\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\tautoOpen : false,\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\tmodal : true,\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\twidth : 400,\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\theight : 200,\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\tbuttons : [\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t{\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\thtml : \"<i class='icon-check bigger-110'></i>&nbsp; Хадгалах\",\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\"class\" : \"btn btn-success btn-xs\",\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\"id\" : \"btnOk\",\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\tclick : function() {\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t$(\"#submitHeader\")\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t.trigger(\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\"click\");\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t},\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t{\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\thtml : \"<i class='icon-check bigger-110'></i>&nbsp; Болих\",\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\"class\" : \"btn btn-danger btn-xs\",\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\"id\" : \"btnBack\",\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\tclick : function() {\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t$(this).dialog(\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\"close\");\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t} ]\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t}).prev(\".ui-dialog-titlebar\").css(\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\"background\", \"#5cb85c\");\r\n");
      out.write("\t\t\t\t\t});\r\n");
      out.write("</script>\r\n");
      out.write("<div id=\"dialogLogoutTime\">\r\n");
      out.write("\t");
      if (_jspx_meth_s_form_0(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("</div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
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

  private boolean _jspx_meth_s_text_0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  s:text
    org.apache.struts2.views.jsp.TextTag _jspx_th_s_text_0 = (org.apache.struts2.views.jsp.TextTag) _jspx_tagPool_s_text_name_nobody.get(org.apache.struts2.views.jsp.TextTag.class);
    _jspx_th_s_text_0.setPageContext(_jspx_page_context);
    _jspx_th_s_text_0.setParent(null);
    _jspx_th_s_text_0.setName("logout");
    int _jspx_eval_s_text_0 = _jspx_th_s_text_0.doStartTag();
    if (_jspx_th_s_text_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_s_text_name_nobody.reuse(_jspx_th_s_text_0);
      return true;
    }
    _jspx_tagPool_s_text_name_nobody.reuse(_jspx_th_s_text_0);
    return false;
  }

  private boolean _jspx_meth_s_form_0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  s:form
    org.apache.struts2.views.jsp.ui.FormTag _jspx_th_s_form_0 = (org.apache.struts2.views.jsp.ui.FormTag) _jspx_tagPool_s_form_id_cssClass.get(org.apache.struts2.views.jsp.ui.FormTag.class);
    _jspx_th_s_form_0.setPageContext(_jspx_page_context);
    _jspx_th_s_form_0.setParent(null);
    _jspx_th_s_form_0.setCssClass("form-horizontal");
    _jspx_th_s_form_0.setId("addLogoutTime");
    int _jspx_eval_s_form_0 = _jspx_th_s_form_0.doStartTag();
    if (_jspx_eval_s_form_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      if (_jspx_eval_s_form_0 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
        out = _jspx_page_context.pushBody();
        _jspx_th_s_form_0.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
        _jspx_th_s_form_0.doInitBody();
      }
      do {
        out.write("\r\n");
        out.write("\t\t");
        if (_jspx_meth_s_hidden_0((javax.servlet.jsp.tagext.JspTag) _jspx_th_s_form_0, _jspx_page_context))
          return true;
        out.write("\r\n");
        out.write("\t\t<div class=\"form-group\">\r\n");
        out.write("\t\t\t<div class=\"row\">\r\n");
        out.write("\t\t\t\t<div class=\"col-sm-12\">\r\n");
        out.write("\t\t\t\t\t<label for=\"time\" class=\"control-label col-sm-5 col-lg-5\">\r\n");
        out.write("\t\t\t\t\t\t");
        if (_jspx_meth_s_text_1((javax.servlet.jsp.tagext.JspTag) _jspx_th_s_form_0, _jspx_page_context))
          return true;
        out.write(":\r\n");
        out.write("\t\t\t\t\t</label>\r\n");
        out.write("\t\t\t\t\t<div class=\"col-sm-7 col-lg-6\">\r\n");
        out.write("\t\t\t\t\t\t");
        if (_jspx_meth_s_textfield_0((javax.servlet.jsp.tagext.JspTag) _jspx_th_s_form_0, _jspx_page_context))
          return true;
        out.write("\r\n");
        out.write("\t\t\t\t\t</div>\r\n");
        out.write("\t\t\t\t</div>\r\n");
        out.write("\t\t\t</div>\r\n");
        out.write("\t\t</div>\r\n");
        out.write("\t\t<input id=\"submitHeader\" type=\"submit\" class=\"hide\" />\r\n");
        out.write("\t");
        int evalDoAfterBody = _jspx_th_s_form_0.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
      if (_jspx_eval_s_form_0 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE)
        out = _jspx_page_context.popBody();
    }
    if (_jspx_th_s_form_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_s_form_id_cssClass.reuse(_jspx_th_s_form_0);
      return true;
    }
    _jspx_tagPool_s_form_id_cssClass.reuse(_jspx_th_s_form_0);
    return false;
  }

  private boolean _jspx_meth_s_hidden_0(javax.servlet.jsp.tagext.JspTag _jspx_th_s_form_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  s:hidden
    org.apache.struts2.views.jsp.ui.HiddenTag _jspx_th_s_hidden_0 = (org.apache.struts2.views.jsp.ui.HiddenTag) _jspx_tagPool_s_hidden_value_name_nobody.get(org.apache.struts2.views.jsp.ui.HiddenTag.class);
    _jspx_th_s_hidden_0.setPageContext(_jspx_page_context);
    _jspx_th_s_hidden_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_s_form_0);
    _jspx_th_s_hidden_0.setName("id");
    _jspx_th_s_hidden_0.setValue("%{#session.logoutTime.id}");
    int _jspx_eval_s_hidden_0 = _jspx_th_s_hidden_0.doStartTag();
    if (_jspx_th_s_hidden_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_s_hidden_value_name_nobody.reuse(_jspx_th_s_hidden_0);
      return true;
    }
    _jspx_tagPool_s_hidden_value_name_nobody.reuse(_jspx_th_s_hidden_0);
    return false;
  }

  private boolean _jspx_meth_s_text_1(javax.servlet.jsp.tagext.JspTag _jspx_th_s_form_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  s:text
    org.apache.struts2.views.jsp.TextTag _jspx_th_s_text_1 = (org.apache.struts2.views.jsp.TextTag) _jspx_tagPool_s_text_name_nobody.get(org.apache.struts2.views.jsp.TextTag.class);
    _jspx_th_s_text_1.setPageContext(_jspx_page_context);
    _jspx_th_s_text_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_s_form_0);
    _jspx_th_s_text_1.setName("time");
    int _jspx_eval_s_text_1 = _jspx_th_s_text_1.doStartTag();
    if (_jspx_th_s_text_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_s_text_name_nobody.reuse(_jspx_th_s_text_1);
      return true;
    }
    _jspx_tagPool_s_text_name_nobody.reuse(_jspx_th_s_text_1);
    return false;
  }

  private boolean _jspx_meth_s_textfield_0(javax.servlet.jsp.tagext.JspTag _jspx_th_s_form_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  s:textfield
    org.apache.struts2.views.jsp.ui.TextFieldTag _jspx_th_s_textfield_0 = (org.apache.struts2.views.jsp.ui.TextFieldTag) _jspx_tagPool_s_textfield_value_name_id_nobody.get(org.apache.struts2.views.jsp.ui.TextFieldTag.class);
    _jspx_th_s_textfield_0.setPageContext(_jspx_page_context);
    _jspx_th_s_textfield_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_s_form_0);
    _jspx_th_s_textfield_0.setName("time");
    _jspx_th_s_textfield_0.setId("time");
    _jspx_th_s_textfield_0.setValue("%{#session.logoutTime.time}");
    int _jspx_eval_s_textfield_0 = _jspx_th_s_textfield_0.doStartTag();
    if (_jspx_th_s_textfield_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_s_textfield_value_name_id_nobody.reuse(_jspx_th_s_textfield_0);
      return true;
    }
    _jspx_tagPool_s_textfield_value_name_id_nobody.reuse(_jspx_th_s_textfield_0);
    return false;
  }
}
