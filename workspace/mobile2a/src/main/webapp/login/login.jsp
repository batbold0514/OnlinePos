<%@ page import="mn.chinbat.interceptor.SessionInterceptor"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html lang="en">
	<head>
		<meta charset="utf-8" />
		<title>Login Page</title>
		
		<meta name="description" content="User login page" />
		<meta name="viewport" content="width=device-width, initial-scale=1.0" />
		
		<link href="../css/bootstrap.min.css" rel="stylesheet" />
		<link rel="stylesheet" href="../css/font-awesome.min.css" />
		<link rel="stylesheet" href="../css/ace-fonts.css" />
		<link rel="stylesheet" href="../css/ace.min.css" />
		<style>
			html, body
			{
				font-family: "Helvetica Neue",Helvetica,Arial,sans-serif !important;
			}
		</style>
	</head>
	
	<body class="login-layout">
		<div class="main-container">
			<div class="main-content">
				<div class="row">
					<div class="col-sm-10 col-sm-offset-1">
						<div class="login-container">
							<div class="center">
								<h1>
									<i class="icon-home green"></i> <span class="green">Mobile</span> <span
										class="white">Application</span>
								</h1>
								<h4 class="blue">&copy; Infosystems</h4>
							</div>
	
							<div class="space-6"></div>
	
							<div class="position-relative">
								<div id="login-box"
									class="login-box visible widget-box no-border">
									<div class="widget-body">
										<div class="widget-main">
											<h4 class="header blue lighter bigger">
												<i class="icon-coffee green"></i> Мэдээллээ оруулна уу
											</h4>
	
											<div class="space-6"></div>
										<%-- 	<%
												if (false) {
											%><span style="color: red"><s:text
													name="Лиценз хүчингүй байна!" /><br> </span>
											<%
												} else {
											%> --%>
											<%
												String result = request.getParameter("result");
													if (result == null)
														result = "";
													if (result.equalsIgnoreCase("false")) {
											%>
											<span style="color: red"><s:text
													name="wrong Name Or Password" /><br> </span>
											<%
												}
											%>
											<form method="POST" action="j_security_check">
												<fieldset>
													<label class="block clearfix"> <span
														class="block input-icon input-icon-right"> <input
															type="text" name="j_username" class="form-control focus"
															placeholder="Хэрэглэгчийн нэр" autofocus="autofocus" /> <i
															class="icon-user"></i>
													</span>
													</label> <label class="block clearfix"> <span
														class="block input-icon input-icon-right"> <input
															type="password" name="j_password" class="form-control"
															placeholder="Нууц үг"> <i class="icon-lock"></i>
													</span>
													</label>
	
													<div class="space"></div>
	
													<div class="clearfix">
														<button type="submit"
															class="width-35 pull-right btn btn-sm btn-primary">
															<i class="icon-key"></i> Нэвтрэх
														</button>
													</div>
	
													<div class="space-4"></div>
												</fieldset>
											</form>
											<%-- <%
												}
											%> --%>
										</div>
									</div>
									<!-- /widget-body -->
								</div>
								<!-- /login-box -->
	
								<div id="forgot-box" class="forgot-box widget-box no-border">
									<div class="widget-body">
										<div class="widget-main">
											<h4 class="header red lighter bigger">
												<i class="icon-key"></i> Retrieve Password
											</h4>
	
											<div class="space-6"></div>
											<p>Enter your email and to receive instructions</p>
	
											<form>
												<fieldset>
													<label class="block clearfix"> <span
														class="block input-icon input-icon-right"> <input
															type="email" class="form-control" placeholder="Email" />
															<i class="icon-envelope"></i>
													</span>
													</label>
	
													<div class="clearfix">
														<button type="button"
															class="width-35 pull-right btn btn-sm btn-danger">
															<i class="icon-lightbulb"></i> Send Me!
														</button>
													</div>
												</fieldset>
											</form>
										</div>
										<!-- /widget-main -->
	
										<div class="toolbar center">
											<a href="#" onclick="show_box('login-box'); return false;"
												class="back-to-login-link"> Back to login <i
												class="icon-arrow-right"></i>
											</a>
										</div>
									</div>
									<!-- /widget-body -->
								</div>
								<!-- /forgot-box -->
	
								<div id="signup-box" class="signup-box widget-box no-border">
									<div class="widget-body">
										<div class="widget-main">
											<h4 class="header green lighter bigger">
												<i class="icon-group blue"></i> New User Registration
											</h4>
	
											<div class="space-6"></div>
											<p>Enter your details to begin:</p>
	
											<form>
												<fieldset>
													<label class="block clearfix"> <span
														class="block input-icon input-icon-right"> <input
															type="email" class="form-control" placeholder="Email" />
															<i class="icon-envelope"></i>
													</span>
													</label> <label class="block clearfix"> <span
														class="block input-icon input-icon-right"> <input
															type="text" class="form-control" placeholder="Username" />
															<i class="icon-user"></i>
													</span>
													</label> <label class="block clearfix"> <span
														class="block input-icon input-icon-right"> <input
															type="password" class="form-control"
															placeholder="Password" /> <i class="icon-lock"></i>
													</span>
													</label> <label class="block clearfix"> <span
														class="block input-icon input-icon-right"> <input
															type="password" class="form-control"
															placeholder="Repeat password" /> <i class="icon-retweet"></i>
													</span>
													</label> <label class="block"> <input type="checkbox"
														class="ace" /> <span class="lbl"> I accept the <a
															href="#">User Agreement</a>
													</span>
													</label>
	
													<div class="space-24"></div>
	
													<div class="clearfix">
														<button type="reset" class="width-30 pull-left btn btn-sm">
															<i class="icon-refresh"></i> Reset
														</button>
	
														<button type="button"
															class="width-65 pull-right btn btn-sm btn-success">
															Register <i class="icon-arrow-right icon-on-right"></i>
														</button>
													</div>
												</fieldset>
											</form>
										</div>
	
										<div class="toolbar center">
											<a href="#" onclick="show_box('login-box'); return false;"
												class="back-to-login-link"> <i class="icon-arrow-left"></i>
												Back to login
											</a>
										</div>
									</div>
									<!-- /widget-body -->
								</div>
								<!-- /signup-box -->
							</div>
							<!-- /position-relative -->
						</div>
					</div>
					<!-- /.col -->
				</div>
				<!-- /.row -->
			</div>
		</div>
		<!-- /.main-container -->
	
		<!-- basic scripts -->
	
		<!--[if !IE]> -->
	
		<%-- <script type="text/javascript">
			window.jQuery
					|| document.write("<script src='../js/jquery-2.0.3.min.js'>"
							+ "<"+"/script>");
		</script> --%>
	
		<!-- <![endif]-->
	
		<!--[if IE]>
	<script type="text/javascript">
	 window.jQuery || document.write("<script src='assets/js/jquery-1.10.2.min.js'>"+"<"+"/script>");
	</script>
	<![endif]-->
	
		<script type="text/javascript">
			if ("ontouchend" in document)
				document.write("<script src='../js/jquery.mobile.custom.min.js'>"
						+ "<"+"/script>");
		</script>
	
		<!-- inline scripts related to this page -->
	
		<script type="text/javascript">
			function show_box(id) {
				jQuery('.widget-box.visible').removeClass('visible');
				jQuery('#' + id).addClass('visible');
			}
		</script>
	</body>
</html>
