package org.apache.jsp.WEB_002dINF.content.inc;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class BaseLayout_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<!DOCTYPE html>\r\n");
      out.write("\r\n");
      out.write("<html lang=\"mn\">\r\n");
      out.write("<head>\r\n");
      out.write("<meta charset=\"UTF-8\">\r\n");
      out.write("<meta http-equiv=\"content-type\" content=\"text/html; charset=UTF-8\">\r\n");
      out.write("<meta name=\"description\" content=\"Call center\">\r\n");
      out.write("<meta name=\"keywords\" content=\"Callcenter\">\r\n");
      out.write("<meta name=\"author\" content=\"Infosystems LLC\">\r\n");
      out.write("<meta name=\"MobileOptimized\" content=\"320\">\r\n");
      out.write("\r\n");
      out.write("<link rel=\"shortcut icon\" type=\"image/x-icon\" href=\"../favicon.ico\" />\r\n");
      out.write("<link rel=\"apple-touch-icon\" href=\"../favicon.ico\">\r\n");
      out.write("<link rel=\"apple-touch-startup-image\" href=\"../img/favicon.ico\">\r\n");
      out.write("\r\n");
      out.write("<title>");
      if (_jspx_meth_tiles_insertAttribute_0(_jspx_page_context))
        return;
      out.write("</title>\r\n");
      out.write("\r\n");
      out.write("<!-- BEGIN GLOBAL MANDATORY STYLES -->\r\n");
      out.write("<link href=\"../assets/plugins/font-awesome/css/font-awesome.min.css\"\r\n");
      out.write("\trel=\"stylesheet\" type=\"text/css\" />\r\n");
      out.write("<link href=\"../assets/plugins/bootstrap/css/bootstrap.min.css\"\r\n");
      out.write("\trel=\"stylesheet\" type=\"text/css\" />\r\n");
      out.write("<link href=\"../assets/plugins/uniform/css/uniform.default.css\"\r\n");
      out.write("\trel=\"stylesheet\" type=\"text/css\" />\r\n");
      out.write("<!-- END GLOBAL MANDATORY STYLES -->\r\n");
      out.write("\r\n");
      out.write("<!-- BEGIN PAGE LEVEL PLUGIN STYLES -->\r\n");
      out.write("<link href=\"../assets/plugins/gritter/css/jquery.gritter.css\"\r\n");
      out.write("\trel=\"stylesheet\" type=\"text/css\" />\r\n");
      out.write("<link\r\n");
      out.write("\thref=\"../assets/plugins/bootstrap-daterangepicker/daterangepicker-bs3.css\"\r\n");
      out.write("\trel=\"stylesheet\" type=\"text/css\" />\r\n");
      out.write("<link\r\n");
      out.write("\thref=\"../assets/plugins/fullcalendar/fullcalendar/fullcalendar.css\"\r\n");
      out.write("\trel=\"stylesheet\" type=\"text/css\" />\r\n");
      out.write("<link href=\"../assets/plugins/jqvmap/jqvmap/jqvmap.css\" rel=\"stylesheet\"\r\n");
      out.write("\ttype=\"text/css\" />\r\n");
      out.write("<link\r\n");
      out.write("\thref=\"../assets/plugins/jquery-easy-pie-chart/jquery.easy-pie-chart.css\"\r\n");
      out.write("\trel=\"stylesheet\" type=\"text/css\" />\r\n");
      out.write("<!-- END PAGE LEVEL PLUGIN STYLES -->\r\n");
      out.write("\r\n");
      out.write("<!-- BEGIN THEME STYLES -->\r\n");
      out.write("<link href=\"../assets/css/style-metronic.css\" rel=\"stylesheet\"\r\n");
      out.write("\ttype=\"text/css\" />\r\n");
      out.write("<link href=\"../assets/css/style.css\" rel=\"stylesheet\" type=\"text/css\" />\r\n");
      out.write("<link href=\"../assets/css/style-responsive.css\" rel=\"stylesheet\"\r\n");
      out.write("\ttype=\"text/css\" />\r\n");
      out.write("<link href=\"../assets/css/plugins.css\" rel=\"stylesheet\" type=\"text/css\" />\r\n");
      out.write("<link href=\"../assets/css/pages/tasks.css\" rel=\"stylesheet\"\r\n");
      out.write("\ttype=\"text/css\" />\r\n");
      out.write("<link href=\"../assets/css/themes/light.css\" rel=\"stylesheet\"\r\n");
      out.write("\ttype=\"text/css\" id=\"style_color\" />\r\n");
      out.write("<link href=\"../assets/css/custom.css\" rel=\"stylesheet\" type=\"text/css\" />\r\n");
      out.write("<link rel=\"stylesheet\" type=\"text/css\"\r\n");
      out.write("\thref=\"../assets/plugins/clockface/css/clockface.css\" />\r\n");
      out.write("\r\n");
      out.write("<!-- END THEME STYLES -->\r\n");
      out.write("\r\n");
      out.write("<link rel=\"stylesheet\" href=\"../css/chosen.css\" />\r\n");
      out.write("\r\n");
      out.write("<link rel=\"stylesheet\" type=\"text/css\"\r\n");
      out.write("\thref=\"../assets/plugins/bootstrap-switch/static/stylesheets/bootstrap-switch-metro.css\" />\r\n");
      out.write("\r\n");
      out.write("<link href=\"../assets/jquery-ui.structure.css\" rel=\"stylesheet\"\r\n");
      out.write("\ttype=\"text/css\" />\r\n");
      out.write("<link href=\"../assets/jquery-ui.theme.css\" rel=\"stylesheet\"\r\n");
      out.write("\ttype=\"text/css\" />\r\n");
      out.write("<script src=\"../assets/jquery.js\" type=\"text/javascript\"></script>\r\n");
      out.write("<script src=\"../assets/jquery-ui.js\" type=\"text/javascript\"></script>\r\n");
      out.write("\r\n");
      out.write("<!-- BEGIN JAVASCRIPTS(Load javascripts at bottom, this will reduce page load time) -->\r\n");
      out.write("<!-- BEGIN CORE PLUGINS -->\r\n");
      out.write("<!--[if lt IE 9]>\r\n");
      out.write("<script src=\"../assets/plugins/respond.min.js\"></script>\r\n");
      out.write("<script src=\"../assets/plugins/excanvas.min.js\"></script> \r\n");
      out.write("<![endif]-->\r\n");
      out.write("<script src=\"../assets/plugins/jquery-1.10.2.min.js\"\r\n");
      out.write("\ttype=\"text/javascript\"></script>\r\n");
      out.write("\t");
      out.write("\r\n");
      out.write("<script src=\"../assets/plugins/jquery-migrate-1.2.1.min.js\"\r\n");
      out.write("\ttype=\"text/javascript\"></script>\r\n");
      out.write("<!-- IMPORTANT! Load jquery-ui-1.10.3.custom.min.js before bootstrap.min.js to fix bootstrap tooltip conflict with jquery ui tooltip -->\r\n");
      out.write("<script src=\"../assets/plugins/jquery-ui/jquery-ui-1.10.3.custom.min.js\"\r\n");
      out.write("\ttype=\"text/javascript\"></script>\r\n");
      out.write("<script src=\"../assets/plugins/bootstrap/js/bootstrap.min.js\"\r\n");
      out.write("\ttype=\"text/javascript\"></script>\r\n");
      out.write("<script\r\n");
      out.write("\tsrc=\"../assets/plugins/bootstrap-hover-dropdown/twitter-bootstrap-hover-dropdown.min.js\"\r\n");
      out.write("\ttype=\"text/javascript\"></script>\r\n");
      out.write("<script\r\n");
      out.write("\tsrc=\"../assets/plugins/jquery-slimscroll/jquery.slimscroll.min.js\"\r\n");
      out.write("\ttype=\"text/javascript\"></script>\r\n");
      out.write("<script src=\"../assets/plugins/jquery.blockui.min.js\"\r\n");
      out.write("\ttype=\"text/javascript\"></script>\r\n");
      out.write("<script src=\"../assets/plugins/jquery.cookie.min.js\"\r\n");
      out.write("\ttype=\"text/javascript\"></script>\r\n");
      out.write("<script src=\"../assets/plugins/uniform/jquery.uniform.min.js\"\r\n");
      out.write("\ttype=\"text/javascript\"></script>\r\n");
      out.write("<!-- END CORE PLUGINS -->\r\n");
      out.write("<!-- BEGIN PAGE LEVEL PLUGINS -->\r\n");
      out.write("<script src=\"../assets/plugins/jqvmap/jqvmap/jquery.vmap.js\"\r\n");
      out.write("\ttype=\"text/javascript\"></script>\r\n");
      out.write("<script src=\"../assets/plugins/jqvmap/jqvmap/maps/jquery.vmap.russia.js\"\r\n");
      out.write("\ttype=\"text/javascript\"></script>\r\n");
      out.write("<script src=\"../assets/plugins/jqvmap/jqvmap/maps/jquery.vmap.world.js\"\r\n");
      out.write("\ttype=\"text/javascript\"></script>\r\n");
      out.write("<script src=\"../assets/plugins/jqvmap/jqvmap/maps/jquery.vmap.europe.js\"\r\n");
      out.write("\ttype=\"text/javascript\"></script>\r\n");
      out.write("<script\r\n");
      out.write("\tsrc=\"../assets/plugins/jqvmap/jqvmap/maps/jquery.vmap.germany.js\"\r\n");
      out.write("\ttype=\"text/javascript\"></script>\r\n");
      out.write("<script src=\"../assets/plugins/jqvmap/jqvmap/maps/jquery.vmap.usa.js\"\r\n");
      out.write("\ttype=\"text/javascript\"></script>\r\n");
      out.write("<script\r\n");
      out.write("\tsrc=\"../assets/plugins/jqvmap/jqvmap/data/jquery.vmap.sampledata.js\"\r\n");
      out.write("\ttype=\"text/javascript\"></script>\r\n");
      out.write("<script src=\"../assets/plugins/flot/jquery.flot.js\"\r\n");
      out.write("\ttype=\"text/javascript\"></script>\r\n");
      out.write("<script src=\"../assets/plugins/flot/jquery.flot.resize.js\"\r\n");
      out.write("\ttype=\"text/javascript\"></script>\r\n");
      out.write("<script src=\"../assets/plugins/jquery.pulsate.min.js\"\r\n");
      out.write("\ttype=\"text/javascript\"></script>\r\n");
      out.write("<script src=\"../assets/plugins/bootstrap-daterangepicker/moment.min.js\"\r\n");
      out.write("\ttype=\"text/javascript\"></script>\r\n");
      out.write("<script\r\n");
      out.write("\tsrc=\"../assets/plugins/bootstrap-daterangepicker/daterangepicker.js\"\r\n");
      out.write("\ttype=\"text/javascript\"></script>\r\n");
      out.write("<script src=\"../assets/plugins/gritter/js/jquery.gritter.js\"\r\n");
      out.write("\ttype=\"text/javascript\"></script>\r\n");
      out.write("<!-- IMPORTANT! fullcalendar depends on jquery-ui-1.10.3.custom.min.js for drag & drop support -->\r\n");
      out.write("<script\r\n");
      out.write("\tsrc=\"../assets/plugins/fullcalendar/fullcalendar/fullcalendar.min.js\"\r\n");
      out.write("\ttype=\"text/javascript\"></script>\r\n");
      out.write("<script\r\n");
      out.write("\tsrc=\"../assets/plugins/jquery-easy-pie-chart/jquery.easy-pie-chart.js\"\r\n");
      out.write("\ttype=\"text/javascript\"></script>\r\n");
      out.write("<script src=\"../assets/plugins/jquery.sparkline.min.js\"\r\n");
      out.write("\ttype=\"text/javascript\"></script>\r\n");
      out.write("<!-- END PAGE LEVEL PLUGINS -->\r\n");
      out.write("<!-- BEGIN PAGE LEVEL SCRIPTS -->\r\n");
      out.write("<script src=\"../assets/scripts/app.js\" type=\"text/javascript\"></script>\r\n");
      out.write("<script src=\"../assets/scripts/index.js\" type=\"text/javascript\"></script>\r\n");
      out.write("<script src=\"../assets/scripts/tasks.js\" type=\"text/javascript\"></script>\r\n");
      out.write("<!-- END PAGE LEVEL SCRIPTS -->\r\n");
      out.write("\r\n");
      out.write("<!-- BEGIN PAGE LEVEL PLUGINS -->\r\n");
      out.write("<script src=\"../assets/plugins/bootbox/bootbox.min.js\"\r\n");
      out.write("\ttype=\"text/javascript\"></script>\r\n");
      out.write("<!-- END PAGE LEVEL PLUGINS -->\r\n");
      out.write("<!-- BEGIN PAGE LEVEL SCRIPTS -->\r\n");
      out.write("<script src=\"../assets/scripts/ui-bootbox.js\"></script>\r\n");
      out.write("<!-- END PAGE LEVEL SCRIPTS -->\r\n");
      out.write("\r\n");
      out.write("<script src=\"../assets/scripts/charts.js\" type=\"text/javascript\"></script>\r\n");
      out.write("\r\n");
      out.write("<script src=\"../js/chosen.jquery.min.js\"></script>\r\n");
      out.write("<script src=\"../assets/bootstrapValidator.js\"></script>\r\n");
      out.write("\r\n");
      out.write("<script src=\"../js/jquery.dataTables.min.js\"></script>\r\n");
      out.write("<script src=\"../js/TableTools.js\"></script>\r\n");
      out.write("<script src=\"../js/ZeroClipboard.js\"></script>\r\n");
      out.write("<script src=\"../js/numeral.min.js\"></script>\r\n");
      out.write("<script src=\"../js/raphael-min.js\"></script>\r\n");
      out.write("<link rel=\"stylesheet\" href=\"../css/morris-0.5.1.css\">\r\n");
      out.write("<script src=\"../js/morris-0.5.1.min.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\"\r\n");
      out.write("\tsrc=\"../assets/plugins/clockface/js/clockface.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\"\r\n");
      out.write("\tsrc=\"../assets/scripts/jquery.jplayer.min.js\"></script>\r\n");
      out.write("\r\n");
      out.write("<script src=\"../js/date-time/locales/jquery.ui.datepicker-mn.js\"></script>\r\n");
      out.write("<script src=\"../js/date-time/bootstrap-timepicker.min.js\"></script>\r\n");
      out.write("<link rel=\"stylesheet\" href=\"../css/jquery.dataTables.css\" />\r\n");
      out.write("<link rel=\"stylesheet\" href=\"../css/TableTools.css\" />\r\n");
      out.write("<!-- <link rel=\"stylesheet\" href=\"../assets/jquery.dataTables_themeroller.css\" /> -->\r\n");
      out.write("<link rel=\"stylesheet\" href=\"../css/main.css\" />\r\n");
      out.write("<link href=\"../assets/jquery-ui.css\" rel=\"stylesheet\" type=\"text/css\" />\r\n");
      out.write("<link href=\"../assets/css/jplayer.blue.monday.min.css\" rel=\"stylesheet\"\r\n");
      out.write("\ttype=\"text/css\" />\r\n");
      out.write("\r\n");
      out.write("<link href=\"../css/jquery.dataTables.yadcf.css\" rel=\"stylesheet\"\r\n");
      out.write("\ttype=\"text/css\" />\r\n");
      out.write("<script src=\"../js/jquery.dataTables.yadcf.js\"></script>\r\n");
      out.write("\r\n");
      out.write("<script type=\"text/javascript\"\r\n");
      out.write("\tsrc=\"../assets/plugins/jquery.pulsate.min.js\"></script>\r\n");
      out.write("\r\n");
      out.write("<script src=\"../js/metronic.js\"></script>\r\n");
      out.write("<link href=\"../assets/css/components.css\" id=\"style_components\"\r\n");
      out.write("\trel=\"stylesheet\" type=\"text/css\" />\r\n");
      out.write("<script src=\"../js/autocomplete/selectize.js\" type=\"text/javascript\"></script>\r\n");
      out.write("<script src=\"../js/autocomplete/index.js\" type=\"text/javascript\"></script>\r\n");
      out.write("<link href=\"../dist/css/selectize.default.css\" rel=\"stylesheet\" type=\"text/css\" />\r\n");
      out.write("<script src=\"../js/calculator/zeninput.js\" type=\"text/javascript\"></script>\r\n");
      out.write("<!-- file upload start-->\r\n");
      out.write("<link rel=\"stylesheet\" href=\"../css/jquery-ui-1.10.3.full.min.css\" />\r\n");
      out.write("<script src=\"../js/fileinput/jquery.ajaxfileupload.js\" type=\"text/javascript\"></script>\r\n");
      out.write("\r\n");
      out.write("<!-- file upload end -->\r\n");
      out.write("<!--image zoom start -->\r\n");
      out.write("\r\n");
      out.write(" <!-- image zoom end -->\r\n");
      out.write("<script>\r\n");
      out.write("\tvar number = numeral(0);\r\n");
      out.write("\tjQuery(document).ready(function() {\r\n");
      out.write("\t\tApp.init(); // initlayout and core plugins\r\n");
      out.write("\t\tIndex.init();\r\n");
      out.write("\t\tactive_menu();\r\n");
      out.write("\t\t//Index.initJQVMAP(); // init index page's custom scripts\r\n");
      out.write("\t\t/* \tIndex.initCalendar(); // init index page's custom scripts\r\n");
      out.write("\t\t\tIndex.initCharts(); // init index page's custom scripts\r\n");
      out.write("\t\t\tIndex.initChat();\r\n");
      out.write("\t\t\tIndex.initMiniCharts();\r\n");
      out.write("\t\t\tIndex.initDashboardDaterange();\r\n");
      out.write("\t\t\tIndex.initIntro();\r\n");
      out.write("\t\t\tTasks.initDashboardWidget(); */\r\n");
      out.write("\r\n");
      out.write("\t\t/* startTime();\r\n");
      out.write("\t\t$(document).keydown(function(event) {\r\n");
      out.write("\t\t\tzeroTime();\r\n");
      out.write("\t\t});\r\n");
      out.write("\t\t$(document).mousemove(function(event) {\r\n");
      out.write("\t\t\tzeroTime();\r\n");
      out.write("\t\t});\r\n");
      out.write("\t\t$(document).mousedown(function(event) {\r\n");
      out.write("\t\t\tzeroTime();\r\n");
      out.write("\t\t}); */\r\n");
      out.write("\r\n");
      out.write("\t});\r\n");
      out.write("\t/* function startTime() {\r\n");
      out.write("\t\tnumber = number.add(1);\r\n");
      out.write("\t\tvar time = $(\"#logoutTime\").text().trim();\r\n");
      out.write("\t\tif (time.substring(0, 1) == 0) {\r\n");
      out.write("\t\t\ttime = time.substring(1);\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\tif (number.format('hh:mm:ss') == time) {\r\n");
      out.write("\t\t\tlocation = \"logout\";\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\tsetTimeout(function() {\r\n");
      out.write("\t\t\tstartTime();\r\n");
      out.write("\t\t}, 1000);\r\n");
      out.write("\t}\r\n");
      out.write("\tfunction zeroTime() {\r\n");
      out.write("\t\tnumber = number.set(0);\r\n");
      out.write("\t} */\r\n");
      out.write("\tfunction active_menu() {\r\n");
      out.write("\t\tvar s = document.getElementsByClassName(\"active_menu\");\r\n");
      out.write("\t\t$(\"#\" + s[0].innerHTML).addClass('active');\r\n");
      out.write("\t\t$(\"#\" + s[0].innerHTML).parents('li').addClass(\"active\");\r\n");
      out.write("\t\t$(\"#\" + s[0].innerHTML).parents('li').find('a').children(\"span.arrow\")\r\n");
      out.write("\t\t\t\t.addClass(\"open\");\r\n");
      out.write("\t\t$(\"#\" + s[0].innerHTML).parents('li').find('a').children(\r\n");
      out.write("\t\t\t\t\"span.selectedd\").addClass(\"selected\");\r\n");
      out.write("\t}\r\n");
      out.write("</script>\r\n");
      out.write("<!-- END JAVASCRIPTS -->\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("</head>\r\n");
      out.write("<body class=\"page-header-fixed page-sidebar-fixed page-footer-fixed\">\r\n");
      out.write("\t<div class=\"header navbar navbar-inverse navbar-fixed-top\">\r\n");
      out.write("\t\t");
      if (_jspx_meth_tiles_insertAttribute_1(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("\t</div>\r\n");
      out.write("\t<div class=\"clearfix\"></div>\r\n");
      out.write("\t<div class=\"page-container\">\r\n");
      out.write("\t\t<div class=\"page-sidebar-wrapper\">\r\n");
      out.write("\t\t\t<div class=\"page-sidebar navbar-collapse collapse\">\r\n");
      out.write("\t\t\t\t");
      if (_jspx_meth_tiles_insertAttribute_2(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t<div class=\"page-content-wrapper\">\r\n");
      out.write("\t\t\t<div class=\"page-content\">\r\n");
      out.write("\t\t\t\t");
      if (_jspx_meth_tiles_insertAttribute_3(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t</div>\r\n");
      out.write("\t<!-- BEGIN FOOTER -->\r\n");
      out.write("\t");
      if (_jspx_meth_tiles_insertAttribute_4(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("\t<!-- END FOOTER -->\r\n");
      out.write("</body>\r\n");
      out.write("\r\n");
      out.write("\r\n");
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

  private boolean _jspx_meth_tiles_insertAttribute_0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  tiles:insertAttribute
    org.apache.tiles.jsp.taglib.InsertAttributeTag _jspx_th_tiles_insertAttribute_0 = (_jspx_resourceInjector != null) ? _jspx_resourceInjector.createTagHandlerInstance(org.apache.tiles.jsp.taglib.InsertAttributeTag.class) : new org.apache.tiles.jsp.taglib.InsertAttributeTag();
    _jspx_th_tiles_insertAttribute_0.setJspContext(_jspx_page_context);
    _jspx_th_tiles_insertAttribute_0.setName("title");
    _jspx_th_tiles_insertAttribute_0.setIgnore(true);
    _jspx_th_tiles_insertAttribute_0.doTag();
    return false;
  }

  private boolean _jspx_meth_tiles_insertAttribute_1(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  tiles:insertAttribute
    org.apache.tiles.jsp.taglib.InsertAttributeTag _jspx_th_tiles_insertAttribute_1 = (_jspx_resourceInjector != null) ? _jspx_resourceInjector.createTagHandlerInstance(org.apache.tiles.jsp.taglib.InsertAttributeTag.class) : new org.apache.tiles.jsp.taglib.InsertAttributeTag();
    _jspx_th_tiles_insertAttribute_1.setJspContext(_jspx_page_context);
    _jspx_th_tiles_insertAttribute_1.setName("header");
    _jspx_th_tiles_insertAttribute_1.doTag();
    return false;
  }

  private boolean _jspx_meth_tiles_insertAttribute_2(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  tiles:insertAttribute
    org.apache.tiles.jsp.taglib.InsertAttributeTag _jspx_th_tiles_insertAttribute_2 = (_jspx_resourceInjector != null) ? _jspx_resourceInjector.createTagHandlerInstance(org.apache.tiles.jsp.taglib.InsertAttributeTag.class) : new org.apache.tiles.jsp.taglib.InsertAttributeTag();
    _jspx_th_tiles_insertAttribute_2.setJspContext(_jspx_page_context);
    _jspx_th_tiles_insertAttribute_2.setName("menu");
    _jspx_th_tiles_insertAttribute_2.doTag();
    return false;
  }

  private boolean _jspx_meth_tiles_insertAttribute_3(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  tiles:insertAttribute
    org.apache.tiles.jsp.taglib.InsertAttributeTag _jspx_th_tiles_insertAttribute_3 = (_jspx_resourceInjector != null) ? _jspx_resourceInjector.createTagHandlerInstance(org.apache.tiles.jsp.taglib.InsertAttributeTag.class) : new org.apache.tiles.jsp.taglib.InsertAttributeTag();
    _jspx_th_tiles_insertAttribute_3.setJspContext(_jspx_page_context);
    _jspx_th_tiles_insertAttribute_3.setName("body");
    _jspx_th_tiles_insertAttribute_3.doTag();
    return false;
  }

  private boolean _jspx_meth_tiles_insertAttribute_4(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  tiles:insertAttribute
    org.apache.tiles.jsp.taglib.InsertAttributeTag _jspx_th_tiles_insertAttribute_4 = (_jspx_resourceInjector != null) ? _jspx_resourceInjector.createTagHandlerInstance(org.apache.tiles.jsp.taglib.InsertAttributeTag.class) : new org.apache.tiles.jsp.taglib.InsertAttributeTag();
    _jspx_th_tiles_insertAttribute_4.setJspContext(_jspx_page_context);
    _jspx_th_tiles_insertAttribute_4.setName("footer");
    _jspx_th_tiles_insertAttribute_4.doTag();
    return false;
  }
}
