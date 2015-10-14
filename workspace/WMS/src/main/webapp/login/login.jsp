<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
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
		
		<link rel="shortcut icon" type="image/x-icon" href="../favicon.ico">
		
		<title>WMS - Нэвтрэх хуудас</title>
		
		<link rel="stylesheet" href="../css/bootstrap.min.css">
		<link rel="stylesheet" href="../css/font-awesome.min.css">
		
		<!-- Our team CSS -->
		<link rel="stylesheet" href="../css/signin.css">
		<style type="text/css">
		</style>
		
		<script type="text/javascript" src="../js/jquery-1.11.0.min.js"></script>
		<script type="text/javascript" src="../js/bootstrap.min.js"></script>
		<script type="text/javascript" src="../js/jquery.validate.min.js"></script>
		
		<!-- Our team JS -->
		<script type="text/javascript" src="../js/page-js/signin.js"></script>
		<script type="text/javascript">
			$(document).ready(function()
			{
			});
		</script>
	</head>
	
	<body>
		<div class="container">
			<form action="j_security_check" method="POST" class="form-signin" id="form-login">
        		<h2 class="form-signin-heading text-center">
        			<b>Нэвтрэх хэсэг</b>
        		</h2>
        		<%
        			String errorClass = "";
        			String result = request.getParameter("result");
					if (result != null )
					{
						errorClass = "has-error";
				%>
				<div class="row">
					<div class="col-sm-12 text-danger">
						Нэвтрэх нэр эсвэл нууц үг буруу байна!
			        </div>
		        </div>
        		<div class="form-group <%= errorClass %>">
        			<label class="error" for="j_username"></label>
        			<input type="text" name="j_username" class="form-control" placeholder="Нэвтрэх нэр" id="j_username" autofocus />
        		</div>
        		<div class="form-group <%= errorClass %>">
        			<label class="error" for="j_password"></label>
        			<input type="password" name="j_password" class="form-control" placeholder="Нууц үг" id="j_password" />
        		</div>
        		<label class="checkbox">
          			Бүртгэл 
          			<small>&nbsp;&rarr;&nbsp;</small>
          			<a href="contact">Холбоо барих</a>
        		</label>
        		<button type="submit" class="btn btn-primary btn-block">
        			<i class="fa fa-key"></i>&nbsp;
        			Нэвтрэх
        		</button>
      		</form>
      		<%
				}
			%>
		</div>
	</body>
</html> 