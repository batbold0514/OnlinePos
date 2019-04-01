<%@ page import="utils.LoggedUser"%>
<%@ page import="models.Company"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	int status = LoggedUser.checkLogin(session);
	if (status != 1)
	{
		if (status == 0)
		{
			response.sendRedirect("login.jsp");
		}
		else
		{
			response.sendRedirect("login.jsp?message=" + status);
		}
	}
%>
<!DOCTYPE html>
<html lang="mn">
	<head>
		<meta charset="utf-8" />
	    <meta http-equiv="content-type" content="text/html; charset=UTF-8">
	    <meta name="description" content="Infosystems LLC - Online POS: Report page">
	    <meta name="keywords" content="Infosystems POS, Online POS, POS, Infosystems LLC, Infosystems">
	    <meta name="author" content="Infosystems LLC">
	    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=0"/>
	    <meta name="apple-mobile-web-app-capable" content="yes" />
		<meta name="apple-mobile-web-app-status-bar-style" content="black" />
	
	    <title>Тайлан - [${company.name} ХХК]</title>
	    
	    <link rel="icon" type="image/x-icon" href="images/favicon.ico" />
	    <link rel="apple-touch-icon" href="images/Logo.png">
	    <link rel="apple-touch-startup-image" href="images/Logo.png">
	    
	    <link rel="stylesheet" href="css/bootstrap.min.css" />
	    <link rel="stylesheet" href="css/font-awesome.min.css" />
	    <link rel="stylesheet" type="text/css" href="css/select2.css" />
	    <link rel="stylesheet" href="css/jquery-ui-1.10.3.full.min.css" />
	    <link rel="stylesheet" href="css/daterangepicker-bs3.css" />
	    <link rel="stylesheet" href="css/ace-fonts.css" />
	    <link rel="stylesheet" href="css/ace.min.css" />
	    <link rel="stylesheet" href="css/ace-skins.min.css" />
	    <link rel="stylesheet" href="css/custom-icons.css" />
	   <link href="css/jquery.gritter.css" rel="stylesheet" type="text/css"/>
	    <link rel="stylesheet" href="css/style.css" />
	    <style type="text/css">
	    	
	    </style>
	    
	    <script type="text/javascript" src="js/ace-extra.min.js"></script>
	    <script type="text/javascript" src="js/jquery-1.11.0.min.js"></script>
	    <script type="text/javascript" src="js/jquery.dataTables.min.js"></script>
	    <script type="text/javascript" src="js/bootstrap.min.js"></script>
	    <script type="text/javascript" src="js/jquery-ui-1.10.3.full.min.js"></script>
	    <script type="text/javascript" src="js/jquery.validate.min.js"></script>
	    <script type="text/javascript" src="js/jquery.ui.datepicker-mn.js"></script>
	    <script type="text/javascript" src="js/jquery.dataTables.min.js"></script>
		<script type="text/javascript" src="js/jquery.dataTables.bootstrap.js"></script>
		<script type="text/javascript" src="js/jquery.maskedinput.min.js"></script>
	    <script type="text/javascript" src="js/date-time/moment.min.js"></script>
		<script type="text/javascript" src="js/date-time/daterangepicker.js"></script>
	    <script type="text/javascript" src="js/ace-elements.min.js"></script>
	    <script type="text/javascript" src="js/ace.min.js"></script>
	    <script src="js/jquery.gritter.min.js" type="text/javascript"></script>
	    <script type="text/javascript" src="js/page-js/item-list.js"></script>
	    
	    
	     <script type="text/javascript" src="js/select2.min.js"></script>
	     <script type="text/javascript" src="js/fnReloadAjax.js"></script>
	     
	    
	    <script type="text/javascript">
	    	$(document).ready(function()
	    	{
	    		
	      	});
	    </script>
	</head>
	<body>
		
			<header class="navbar navbar-default" id="navbar">
				<div class="navbar-container container" id="navbar-container">
					<div class="navbar-header pull-left">
						<a href="index.jsp" class="navbar-brand">
		            		<small>
		              			<i class="icon-medkit"></i>
		              			Инфосистемс POS ${test}
		            		</small>
		          		</a><!-- /.brand -->
		        	</div><!-- /.navbar-header -->
		        	<div class="navbar-header pull-right">
		          		<ul class="nav ace-nav">
		            		<li class="light-blue2 "  >
		              			<a href="#" data-toggle="dropdown" class="dropdown-toggle">
		                			<span class="user-info">
		                  				<small>Тавтай морилно уу,</small>
		                  				${user.userName}
		                			</span>
		                			<i class="icon-caret-down"></i>
		              			</a>
		              			<ul class="user-menu pull-right dropdown-menu dropdown-yellow dropdown-caret dropdown-close">
		                			<li class="hidden">
		                  				<a href="#">
		                    				<i class="icon-cog"></i>
		                    				Тохиргоо
		                  				</a>
		                			</li>
		                			<li class="hidden">
		                				<a href="#">
					                    	<i class="icon-user"></i>
					                    	Хувийн хэрэг
					                  	</a>
					                </li>
					                <li>
					                  	<a href="index.jsp">
					                    	<i class="bhicon bhicon-cash"></i>
					                    	Касс
					                  	</a>
					                </li>
					                <li class="divider"></li>
					                <li>
					                  	<a href="logout">
					                    	<i class="icon-off"></i>
					                    	Гарах
					                  	</a>
					                </li>
		              			</ul>
		            		</li>
		          		</ul><!-- /.ace-nav -->
		        	</div><!-- /.navbar-header -->
		      	</div><!-- /.container -->
		    </header>
		    
		    <div class="main-container container" id="main-container">
	      		<div class="main-container-inner">
	        		<div class="main-content bh-main-content">
	        			<div class="page-content">
	        				<div class="page-header">
	        					<h1>Тайлан</h1>
	        				</div>
				            <div class="row">
				              	<div class="col-sm-12">
				              	<div class="table-toolbar">
				<div class="btn-group">
					<button class="btn btn-success" style="border-radius: 4rem" id="btnAdd">
						add	<i class="icon-plus-sign"></i>
					</button>
					
			</div>
				              		<div class="table-responsive">
				              		
				              			<table class="table table-striped table-bordered table-hover" id="mainTable">
				              				<thead>
				              					<tr>
				              						<th></th>
				              						<th>id</th>
				              						<th>Барааны нэр</th>
				              						<th>Тайлбар</th>
				              						<th>unit_id</th>
				              						<th>Хэмжих нэгж</th>
				              						<th>Барааны тасаг</th>
				              						<th>Үнэ</th>
				              						<th>Тоо ширхэг</th>
				              					</tr>
				              				</thead>
				              				<tbody id="tableBody">${tableBody}</tbody>
				              			</table>
				              			<div class="12 text-center blue">
				              				<h2>
				              					<b>${total}</b>
				              				</h2>
				              			</div>
				              		</div>
				          		</div>
				          	</div>
				        </div>
	        		</div>
	        	</div>
	        </div>
	        <footer class="footer">
	        	<div class="container">
		        	<div class="row center">
		          		<div class="col-xs-12 col-sm-offset-4 col-sm-4 center">
		            		&copy;2014  Infosystems LLC
		          		</div>
		          		<div id="time" class="col-xs-12 col-sm-4 center bigger-120 bolder dark">
		          		</div>
		        	</div>
		      	</div>
		    </footer>
		    <div id = "logoutDialog">
		  		<div class="center">
		  			<b>Итгэлтэй байна уу?</b>
		  		</div>
			</div>
		 </div>
	</body>
	<div id="addItemsDialog">
		<div class="col-sm-12">
			<div class="row">
				<form action="#" id = "addform">
                    <div class="row">
						<div class="form-group">
							<label for="talon" class="control-label col-xs-6 col-sm-6 col-md-6 no-padding-right">Барааны нэр:</label>
							<div class="col-xs-6 col-sm-6 col-md-6">
								<input type="text" name="itemName"  class="col-xs-12 col-sm-12 =" tabindex="3" id = "itemName"/>
							</div>
	                    </div>
                    </div>
                    <div class="row">
	                    <div class="form-group">
							<label for="talon" class="control-label col-xs-6 col-sm-6 col-md-6 no-padding-right">Хэмжих нэгж:</label>
							<div class="col-xs-6 col-sm-6 col-md-6">
								<select id="units" name = "unitId" class="width-100"></select>
							</div>
	                    </div>
                    </div>
                    <div class="row">
	                    <div class="form-group">
							<label for="talon" class="control-label col-xs-6 col-sm-6 col-md-6 no-padding-right">Үнэ:</label>
							<div class="col-xs-6 col-sm-6 col-md-6">
								<input type="number" name="price" id = "price" class="col-xs-12 col-sm-12 " />
							</div>
	                    </div>
                    </div>
                    <div class="row">
	                    <div class="form-group">
							<label for="talon" class="control-label col-xs-6 col-sm-6 col-md-6 no-padding-right">Тоо ширхэг:</label>
							<div class="col-xs-6 col-sm-6 col-md-6">
								<input type="number" name="quantity" id = "quantity" class="col-xs-12 col-sm-12 " />
							</div>
	                    </div>
                    </div>
                    <div class="row">
	                    <div class="form-group">
							<label for="talon" class="control-label col-xs-6 col-sm-6 col-md-6 no-padding-right">Тайлбар:</label>
							<div class="col-xs-6 col-sm-6 col-md-6">
								<input type="text" name="description" id = "description"  class="col-xs-12 col-sm-12 " />
							</div>
	                    </div>
                    </div>
                    <div class="row">
						<div class="form-group">
							<label for="talon" class="control-label col-xs-6 col-sm-6 col-md-6 no-padding-right">Барааны тасаг:</label>
							<div class="col-xs-6 col-sm-6 col-md-6">
								<select id="assetAccounts" name = "assetAcc" class="width-100" multiple="multiple"></select>
							</div>
	                    </div>
                    </div>
                    <input type="submit" id = "submitOk" class ="hide"/>
                    
				</form>
			</div>
		</div>
	</div>
</html>