<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<%-- <% response.setHeader("Content-Encoding", "gzip"); %> --%>
<html lang="mn">
<head>
<meta charset="UTF-8">
<meta http-equiv="content-type" content="text/html; charset=UTF-8">
<meta name="description" content="TPMS">
<meta name="keywords" content="TPMS">
<meta name="author" content="Macs Progress LLC">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="apple-mobile-web-app-capable" content="yes" />
<meta name="apple-mobile-web-app-status-bar-style" content="black" />
<link rel="shortcut icon" type="image/x-icon" href="../favicon.ico" />
<link rel="apple-touch-icon" href="../img/Logo.png">
<link rel="apple-touch-startup-image" href="../img/Logo.png">

<title><tiles:insertAttribute name="title" ignore="true" /></title>

<link href="../css/bootstrap.min.css" rel="stylesheet" />
<link href="../css/dataTables.bootstrap.css" rel="stylesheet" />
<link rel="stylesheet" href="../css/chosen.css" />
<link rel="stylesheet" href="../css/demo_table.css">
<link rel="stylesheet" href="../css/font-awesome.min.css" />
<link rel="stylesheet" href="../css/jquery.toastmessage.css" />
<link rel="stylesheet" href="../css/TableTools.css" />
<link rel="stylesheet" href="../css/jquery-ui-1.10.3.full.min.css" />
<link rel="stylesheet" href="../css/jquery.gritter.css" />
<link rel="stylesheet" href="../css/ace-fonts.css" />
<link rel="stylesheet" href="../css/ace.min.css" />
<link rel="stylesheet" href="../css/ace-skins.min.css" />
<link rel="stylesheet" href="../css/main.css" />
<script type="text/javascript">
	window.jQuery
			|| document.write("<script src='../js/jquery-2.1.1.min.js'>"
					+ "<" + "/script>");
</script>
<script type="text/javascript">
	if ("ontouchend" in document)
		document.write("<script src='../js/jquery.mobile.custom.min.js'>"
				+ "<" + "/script>");
</script>
<script src="../js/jquery.dataTables.min.js"></script>
<script src="../js/bootstrap.min.js"></script>
<script src="../js/jquery.dataTables.bootstrap.js"></script>
<script src="../js/jquery.validate.min.js"></script>
<script src="../js/typeahead-bs2.min.js"></script>
<script src="../js/jquery-ui-1.10.3.full.min.js"></script>
<script src="../js/jquery.ui.touch-punch.min.js"></script>
<script src="../js/jquery.slimscroll.min.js"></script>
<script src="../js/jquery.sparkline.min.js"></script>
<script src="../js/flot/jquery.flot.min.js"></script>
<script src="../js/flot/jquery.flot.resize.min.js"></script>
<script type="text/javascript" src="../js/jquery.gritter.min.js"></script>
<script type="text/javascript" src="../js/ZeroClipboard.js"></script>
<script type="text/javascript" src="../js/FixedColumns.js"></script>
<script type="text/javascript" src="../js/TableTools.min.js"></script>
<script type="text/javascript" src="../js/jquery.toastmessage.js"></script>
<script src="../js/chosen.jquery.min.js"></script>
<script src="../js/fuelux/fuelux.wizard.min.js"></script>
<!-- ace scripts -->
<script src="../js/ace-extra.min.js"></script>
<script src="../js/ace-elements.min.js"></script>
<script src="../js/ace.min.js"></script>
<script src="../js/main.js"></script>


</head>
<body>
	<div class="navbar navbar-default" id="navbar">
		<tiles:insertAttribute name="header" />
	</div>
	<div class="main-container" id="main-container">
		<div class="main-container-inner">
			<a class="menu-toggler" id="menu-toggler" href="#"> <span
				class="menu-text"></span>
			</a>
			<div class="sidebar" id="sidebar">
				<tiles:insertAttribute name="menu" />
			</div>
			<div class="main-content">
				<tiles:insertAttribute name="body" />
			</div>
		</div>
		<div class="footer">
			<div class="footer-inner">
				<div class="footer-content">
					<tiles:insertAttribute name="footer" />
				</div>
			</div>
		</div>
		<a href="#" id="btn-scroll-up"
			class="btn-scroll-up btn btn-sm btn-inverse"> <i
			class="icon-double-angle-up icon-only bigger-110"></i>
		</a>
	</div>
</body>
</html>