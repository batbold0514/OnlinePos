<%-- <!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<%@ page isErrorPage="true" %>	
<html>
<head>
    <title>Error Page</title>
</head>
<body>
<p>
<font size=4 color=orange>Your are seeing the error page</font><br><br> <a href="/">return to the site</a><br><br>
In order that the development team can address this error, please report what you were doing that caused this error.
<br/><br/>
The following information can help the development team find where the error happened and what can be done to prevent it from happening in the future.
<br/>
<%
if(null == exception){
    exception = (Throwable)request.getAttribute("org.apache.struts.action.EXCEPTION");
}
%>
<pre style="font-size:12px"><%
if(null == exception){
    out.write("Source of error is unknown.");
}else{
    java.io.StringWriter sw = new java.io.StringWriter();
    java.io.PrintWriter pw = new java.io.PrintWriter(sw);

    exception.printStackTrace(pw);
    out.write(sw.getBuffer().toString());

}
%></pre>
</body>
</html> --%>

<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8" />
<title>404 Error Page</title>

<meta name="description" content="404 Error Page" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<link href="../css/bootstrap.min.css" rel="stylesheet" />
<link rel="stylesheet" href="../css/font-awesome.min.css" />
<link rel="stylesheet" href="../css/ace-fonts.css" />
<link rel="stylesheet" href="../css/ace.min.css" />
<link rel="stylesheet" href="../css/ace-rtl.min.css" />
<link rel="stylesheet" href="../css/ace-skins.min.css" />
<script src="../js/ace-extra.min.js"></script>

</head>

<body>
	<div class="main-content">
		<div class="page-content">
			<div class="row">
				<div class="col-xs-12">
					<!-- PAGE CONTENT BEGINS -->

					<div class="error-container">
						<div class="well">
							<h1 class="grey lighter smaller">
								<span class="blue bigger-125"> <i class="icon-sitemap"></i>
									500
								</span> Алдаа гарлаа
							</h1>

							<hr />
							<div>
								<div class="space"></div>

								<ul class="list-unstyled spaced inline bigger-110 margin-15">
									<li><i class="icon-hand-right blue"></i> Бидэнтэй холбоо барина уу
									</li>
								</ul>
							</div>

							<hr />
							<div class="space"></div>

							<div class="center">
								<a onclick="window.history.back()" class="btn btn-grey"> <i class="icon-arrow-left"></i>
									Буцах
								</a> <a href="#" class="btn btn-primary"> <i
									class="icon-home"></i> Нүүр
								</a>
							</div>
						</div>
					</div>
					<!-- PAGE CONTENT ENDS -->
				</div>
				<!-- /.col -->
			</div>
			<!-- /.row -->
		</div>
		<!-- /.page-content -->
	</div>
	<!-- /.main-content -->


	<!-- <script type="text/javascript">
		window.jQuery
				|| document.write("<script src='../js/jquery-2.0.3.min.js'>"
						+ "<"+"/script>");
	</script> -->


	<script type="text/javascript">
		if ("ontouchend" in document)
			document.write("<script src='../js/jquery.mobile.custom.min.js'>"
					+ "<"+"/script>");
	</script>
	<script src="../js/bootstrap.min.js"></script>
	<script src="../js/typeahead-bs2.min.js"></script>
	<script src="../js/ace-elements.min.js"></script>
	<script src="../js/ace.min.js"></script>
</body>
</html>

