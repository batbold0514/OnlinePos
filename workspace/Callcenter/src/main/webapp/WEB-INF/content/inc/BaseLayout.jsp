<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<%-- <% response.setHeader("Content-Encoding", "gzip"); %> --%>
<html lang="mn">
<head>
<meta charset="UTF-8">
<meta http-equiv="content-type" content="text/html; charset=UTF-8">
<meta name="description" content="Call center">
<meta name="keywords" content="Callcenter">
<meta name="author" content="Infosystems LLC">
<meta name="MobileOptimized" content="320">
<link rel="shortcut icon" type="image/x-icon" href="../favicon.ico" />
<link rel="apple-touch-icon" href="../favicon.ico">
<link rel="apple-touch-startup-image" href="../img/favicon.ico">
<%@ taglib prefix="s" uri="/struts-tags"%>
<title><tiles:insertAttribute name="title" ignore="true" /></title>

 <!-- BEGIN GLOBAL MANDATORY STYLES -->          
   <link href="../assets/plugins/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css"/>
   <link href="../assets/plugins/bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
   <link href="../assets/plugins/uniform/css/uniform.default.css" rel="stylesheet" type="text/css"/>
   <!-- END GLOBAL MANDATORY STYLES -->
   
   <!-- BEGIN PAGE LEVEL PLUGIN STYLES --> 
   <link href="../assets/plugins/gritter/css/jquery.gritter.css" rel="stylesheet" type="text/css"/>
   <link href="../assets/plugins/bootstrap-daterangepicker/daterangepicker-bs3.css" rel="stylesheet" type="text/css" />
   <link href="../assets/plugins/fullcalendar/fullcalendar/fullcalendar.css" rel="stylesheet" type="text/css"/>
   <link href="../assets/plugins/jqvmap/jqvmap/jqvmap.css" rel="stylesheet" type="text/css"/>
   <link href="../assets/plugins/jquery-easy-pie-chart/jquery.easy-pie-chart.css" rel="stylesheet" type="text/css"/>
   <!-- END PAGE LEVEL PLUGIN STYLES -->
 
   <!-- BEGIN THEME STYLES --> 
   <link href="../assets/css/style-metronic.css" rel="stylesheet" type="text/css"/>
   <link href="../assets/css/style.css" rel="stylesheet" type="text/css"/>
   <link href="../assets/css/style-responsive.css" rel="stylesheet" type="text/css"/>
   <link href="../assets/css/plugins.css" rel="stylesheet" type="text/css"/>
   <link href="../assets/css/pages/tasks.css" rel="stylesheet" type="text/css"/>
   <link href="../assets/css/themes/default.css" rel="stylesheet" type="text/css" id="style_color"/>
   <link href="../assets/css/custom.css" rel="stylesheet" type="text/css"/>
   <link rel="stylesheet" type="text/css" href="../assets/plugins/clockface/css/clockface.css"/>
   
   <!-- END THEME STYLES -->
   
   <link rel="stylesheet" href="../css/chosen.css" />
   
	<link rel="stylesheet" type="text/css" href="../assets/plugins/bootstrap-switch/static/stylesheets/bootstrap-switch-metro.css"/>
	
	<link href="../assets/jquery-ui.structure.css" rel="stylesheet" type="text/css" />
	<link href="../assets/jquery-ui.theme.css" rel="stylesheet" type="text/css" />
	<script src="../assets/jquery.js" type="text/javascript"></script>
	<script src="../assets/jquery-ui.js" type="text/javascript"></script>

   <!-- BEGIN JAVASCRIPTS(Load javascripts at bottom, this will reduce page load time) -->
<!-- BEGIN CORE PLUGINS -->   
<!--[if lt IE 9]>
<script src="../assets/plugins/respond.min.js"></script>
<script src="../assets/plugins/excanvas.min.js"></script> 
<![endif]-->   
<script src="../assets/plugins/jquery-1.10.2.min.js" type="text/javascript"></script>
<script src="../assets/plugins/jquery-migrate-1.2.1.min.js" type="text/javascript"></script>   
<!-- IMPORTANT! Load jquery-ui-1.10.3.custom.min.js before bootstrap.min.js to fix bootstrap tooltip conflict with jquery ui tooltip -->
<script src="../assets/plugins/jquery-ui/jquery-ui-1.10.3.custom.min.js" type="text/javascript"></script>
<script src="../assets/plugins/bootstrap/js/bootstrap.min.js" type="text/javascript"></script>
<script src="../assets/plugins/bootstrap-hover-dropdown/twitter-bootstrap-hover-dropdown.min.js" type="text/javascript" ></script>
<%-- <script src="../assets/plugins/jquery-slimscroll/jquery.slimscroll.min.js" type="text/javascript"></script> --%>
<script src="../assets/plugins/jquery.blockui.min.js" type="text/javascript"></script>  
<script src="../assets/plugins/jquery.cookie.min.js" type="text/javascript"></script>
<script src="../assets/plugins/uniform/jquery.uniform.min.js" type="text/javascript" ></script>
<!-- END CORE PLUGINS -->
<!-- BEGIN PAGE LEVEL PLUGINS -->
<script src="../assets/plugins/jqvmap/jqvmap/jquery.vmap.js" type="text/javascript"></script>   
<script src="../assets/plugins/jqvmap/jqvmap/maps/jquery.vmap.russia.js" type="text/javascript"></script>
<script src="../assets/plugins/jqvmap/jqvmap/maps/jquery.vmap.world.js" type="text/javascript"></script>
<script src="../assets/plugins/jqvmap/jqvmap/maps/jquery.vmap.europe.js" type="text/javascript"></script>
<script src="../assets/plugins/jqvmap/jqvmap/maps/jquery.vmap.germany.js" type="text/javascript"></script>
<script src="../assets/plugins/jqvmap/jqvmap/maps/jquery.vmap.usa.js" type="text/javascript"></script>
<script src="../assets/plugins/jqvmap/jqvmap/data/jquery.vmap.sampledata.js" type="text/javascript"></script>  
<script src="../assets/plugins/flot/jquery.flot.js" type="text/javascript"></script>
<script src="../assets/plugins/flot/jquery.flot.resize.js" type="text/javascript"></script>
<script src="../assets/plugins/jquery.pulsate.min.js" type="text/javascript"></script>
<script src="../assets/plugins/bootstrap-daterangepicker/moment.min.js" type="text/javascript"></script>
<script src="../assets/plugins/bootstrap-daterangepicker/daterangepicker.js" type="text/javascript"></script>     
<script src="../assets/plugins/gritter/js/jquery.gritter.js" type="text/javascript"></script>
<!-- IMPORTANT! fullcalendar depends on jquery-ui-1.10.3.custom.min.js for drag & drop support -->
<script src="../assets/plugins/fullcalendar/fullcalendar/fullcalendar.min.js" type="text/javascript"></script>
<script src="../assets/plugins/jquery-easy-pie-chart/jquery.easy-pie-chart.js" type="text/javascript"></script>
<script src="../assets/plugins/jquery.sparkline.min.js" type="text/javascript"></script>  
<!-- END PAGE LEVEL PLUGINS -->
<!-- BEGIN PAGE LEVEL SCRIPTS -->
<script src="../assets/scripts/app.js" type="text/javascript"></script>
<script src="../assets/scripts/index.js" type="text/javascript"></script>
<script src="../assets/scripts/tasks.js" type="text/javascript"></script>        
<!-- END PAGE LEVEL SCRIPTS -->  

<!-- BEGIN PAGE LEVEL PLUGINS -->
<script src="../assets/plugins/bootbox/bootbox.min.js" type="text/javascript"></script>
<!-- END PAGE LEVEL PLUGINS -->
<!-- BEGIN PAGE LEVEL SCRIPTS -->
<script src="../assets/scripts/ui-bootbox.js"></script>
<!-- END PAGE LEVEL SCRIPTS -->

<script src="../assets/scripts/charts.js" type="text/javascript"></script>

<script src="../js/chosen.jquery.min.js"></script>
<script src="../assets/bootstrapValidator.js"></script>

<script src="../js/jquery.dataTables.min.js"></script>
<script src="../js/TableTools.js"></script>
<script src="../js/ZeroClipboard.js"></script>
<script src="../js/numeral.min.js"></script>
<script src="../js/raphael-min.js"></script>
<link rel="stylesheet" href="../css/morris-0.5.1.css">
<script src="../js/morris-0.5.1.min.js"></script>
<script type="text/javascript" src="../assets/plugins/clockface/js/clockface.js"></script>
<script type="text/javascript" src="../assets/scripts/jquery.jplayer.min.js"></script>

<script src="../js/date-time/locales/jquery.ui.datepicker-mn.js"></script>
<script src="../js/date-time/bootstrap-timepicker.min.js"></script>
<link rel="stylesheet" href="../css/jquery.dataTables.css" /> 
<link rel="stylesheet" href="../css/TableTools.css" />
<!-- <link rel="stylesheet" href="../assets/jquery.dataTables_themeroller.css" /> -->
<link rel="stylesheet" href="../css/main.css" />
<link href="../assets/jquery-ui.css" rel="stylesheet" type="text/css" />
<link href="../assets/css/jplayer.blue.monday.min.css" rel="stylesheet" type="text/css" />

<link href="../css/jquery.dataTables.yadcf.css" rel="stylesheet" type="text/css" />
<script src="../js/jquery.dataTables.yadcf.js"></script>

<script type="text/javascript" src="../assets/plugins/jquery.pulsate.min.js"></script>
<script src="../assets/plugins/bootstrap-switch/static/js/bootstrap-switch.min.js" type="text/javascript"></script>
<script src="../js/metronic.js"></script>
<link href="../../assets/css/components.css" id="style_components" rel="stylesheet" type="text/css"/>

<link rel="stylesheet" href="../css/jquery-ui-1.10.3.full.min.css" />
<script src="../js/fileinput/jquery.ajaxfileupload.js" type="text/javascript"></script>
<script>
var number = numeral(0);
  jQuery(document).ready(function() {    
     App.init(); // initlayout and core plugins
     Index.init();
     //Index.initJQVMAP(); // init index page's custom scripts
     Index.initCalendar(); // init index page's custom scripts
     Index.initCharts(); // init index page's custom scripts
     Index.initChat();
     Index.initMiniCharts();
     Index.initDashboardDaterange();
     Index.initIntro();
     Tasks.initDashboardWidget();

     startTime();
     $(document).keydown(function(event){
    	 zeroTime();
     }); 
     $(document).mousemove(function(event){
    	 zeroTime();
     }); 
     $(document).mousedown(function(event){
    	 zeroTime();
     });
  });
  function startTime()
  {
      number = number.add(1);
      var time = $("#logoutTime").text().trim();
      if(time.substring(0,1) == 0){
    	  time = time.substring(1);
      }
       if(number.format('hh:mm:ss') == time){
      	location = "logout";
      }
      setTimeout(function(){ startTime(); }, 1000); 
  }
  function zeroTime(){
	  number=number.set(0);
  }
</script>
<!-- END JAVASCRIPTS -->



</head>
<body>
	<div >
		<tiles:insertAttribute name="header" />
	</div>
	<div class="page-header-fixed page-full-width" id="main-container">
			<%-- <div class="page-sidebar nav-collapse collapse" id="sidebar">
				<tiles:insertAttribute name="menu" />
			</div> --%>
			<div class="page-content">
				<tiles:insertAttribute name="body" />
			</div>
		<%-- <div class="footer">
			<div class="footer-inner">
					<tiles:insertAttribute name="footer" />
			</div>
			<div class="footer-tools">
   			   <span class="go-top">
   				   <i class="icon-angle-up"></i>
  			    </span>
 			  </div>
		</div> --%>
	</div>
	<div id = "logoutTime" class = "hide">
		<s:property value = "#session.logoutTime.time"/>
	</div>
</body>
</html>