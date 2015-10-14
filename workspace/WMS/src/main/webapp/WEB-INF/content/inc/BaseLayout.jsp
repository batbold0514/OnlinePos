<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<!DOCTYPE html>
<html lang="mn">
	<head>
		<meta charset="UTF-8">
		<meta http-equiv="content-type" content="text/html; charset=UTF-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta name="description" content="Warehouse Management System">
		<meta name="keywords" content="Warehouse management system, Агуулах удирдах систем, Warehouse, Агуулах">
		<meta name="author" content="Macs Progress LLC">
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<meta name="apple-mobile-web-app-capable" content="yes" />
		<meta name="apple-mobile-web-app-status-bar-style" content="black" />
		
		<link rel="shortcut icon" type="image/x-icon" href="../favicon.ico" />

    	<link rel="apple-touch-icon" href="../img/Logo.jpg">
    	<link rel="apple-touch-startup-image" href="../img/Logo.jpg">
    	
		<title>
			<tiles:insertAttribute name="title" ignore="true" />
		</title>
		
		<link rel="stylesheet" href="../css/demo_table.css">
		<link rel="stylesheet" href="../css/TableTools.css">
		<link rel="stylesheet" href="../css/metro-blue/jquery-ui-1.10.4.custom.min.css">
		<link rel="stylesheet" href="../css/bootstrap.min.css">
		<!-- <link rel="stylesheet" href="../css/dataTables.bootstrap.css"> -->
		<link rel="stylesheet" href="../css/font-awesome.min.css">
		<link rel="stylesheet" href="../css/chosen.min.css">
		<link rel="stylesheet" href="../css/daterangepicker-bs3.css">

		<!-- Our team CSS -->
		<link rel="stylesheet" href="../css/custom-icons.css">
		<link rel="stylesheet" href="../css/main.css">
		<style type="text/css">
		</style>

		<script type="text/javascript" src="../js/jquery-1.11.0.min.js"></script>
		<script type="text/javascript" src="../js/jquery.dataTables.js"></script>
		<script type="text/javascript" src="../js/bootstrap.min.js"></script>
		<%-- <script type="text/javascript" src="../js/dataTables.bootstrap.js"></script> --%>
		<script type="text/javascript" src="../js/jquery-ui-1.10.4.custom.min.js"></script>
		<script type="text/javascript" src="../js/jquery.ui.datepicker-mn.js"></script>
		<script type="text/javascript" src="../js/TableTools.min.js"></script>
		<script type="text/javascript" src="../js/ZeroClipboard.js"></script>
		<script type="text/javascript" src="../js/moment.min.js"></script>
		<script type="text/javascript" src="../js/daterangepicker.js"></script>

		<!-- Our team JS -->
		<script type="text/javascript" src="../js/main.js"></script>
		<script type="text/javascript">
			$(document).ready(function()
			{
			});
		</script>
	</head>	
	
	<body>
		<div class="wrap">
			<header class="navbar navbar-normal">
				<tiles:insertAttribute name="header" />
			</header>

			<div class="main-margin">
				<div class="row">
					<div class="col-sm-3" id="menuDiv">
						<tiles:insertAttribute name="menu" />
					</div>
					
					<div class="col-sm-9" id="body">
						<tiles:insertAttribute name="body" />
					</div>
				</div>
			</div>
		</div>
		
		<footer class="footer">
			<tiles:insertAttribute name="footer" />
		</footer>
	</body>
</html>