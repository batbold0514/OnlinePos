<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<div class="container">
	<div class="navbar-header">
		<button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#navbar-collapse">
			<span class="sr-only">Toggle navigation</span>
			<span class="icon-bar"></span>
			<span class="icon-bar"></span>
			<span class="icon-bar"></span>
		</button>
		<a href="#" class="navbar-brand bh-logo-a">
			<img src="../img/Logo.jpg" alt="Logo" class="bh-logo-img">
		</a>
	</div>
	
	<nav class="collapse navbar-collapse" id="navbar-collapse">
		<ul class="nav navbar-nav col-sm-9">
			<li class="active col-sm-3 col-sm-offset-6 text-center">
				<a href="#" class="bh-header-font">WMS</a>
			</li>
		</ul>
		
		<ul class="nav navbar-nav navbar-right">
			<li>
				<a href="logout">
					<i class="fa fa-sign-out"></i>
					<s:text name="logout" />
				</a>
			</li>
		</ul>
	</nav>
</div>