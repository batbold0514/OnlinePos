<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<ul class="page-sidebar-menu" id="menu">
	<li class="sidebar-toggler-wrapper">
		<div class="sidebar-toggler hidden-phone"></div>
	</li>
	<li class=""><a href="#"><i class="fa fa-home"></i><span
			class="title"><s:text name="registration" /></span><span
			class="arrow "></span><span class="selectedd"></span> </a>
		<ul class="sub-menu">
		<%
			if(request.isUserInRole("admin-role") || request.isUserInRole("emp-role")){
		%>
			<li id="serviceReg"><a href="service-reg"><i
					class="fa fa-book"></i><span class="title"><s:text
							name="serviceReg" /></span> </a></li>
		<%-- 	<li id="crushEstimate"><a href="#"><i class="fa fa-wrench"></i>
					<s:text name="crushEstimate" /> </a></li> --%>
			<li id="carPrice"><a href="car-price"><i class="fa fa-truck"></i>
					<s:text name="carPrice" /></a></li>
			<li id="partPrice"><a href="part-price"><i
					class="fa fa-gear"></i> <s:text name="partPrice" /></a></li>
		<%
			}
		%>
			<li id="registerSearch"><a href="register-search"><i
					class="fa fa-search"></i> <s:text name="registerSearch" /></a></li>
			<li id="numberSearch"><a href="number-search"><i
					class="fa fa-search"></i> <s:text name="numberSearch" /></a></li>
			<li id="infoBoard"><a href="info-board"><i
					class="fa fa-list"></i> <s:text name="infoBoard" /></a></li>
		</ul></li>
	<li class=""><a href="#"><i class="fa fa-bar-chart-o"></i><span
			class="title"> <s:text name="report" /></span><span class="arrow"></span>
			<span class="selectedd"></span> </a>
		<ul class="sub-menu">
		<%
			if(request.isUserInRole("admin-role") || request.isUserInRole("emp-role")){
		%>
			<li id="empReport"><a href="emp-report"><i
					class="fa fa-th-list"></i> <s:text name="empReport" /></a></li>
		<%
			}
		%>
		</ul></li>
	<li class=""><a href="#"><i class="fa fa-bar-chart-o"></i><span
			class="title"> <s:text name="reference" /></span><span class="arrow"></span><span
			class="selectedd"></span> </a>
		<ul class="sub-menu">
		<%
			if(request.isUserInRole("admin-role") || request.isUserInRole("emp-role")){
		%>
			<li id="employee"><a href="employee-list"><i
					class="fa fa-group"></i> <s:text name="employee" /></a></li>
			<li id="carfactory"><a href="car-factory"><i
					class="fa fa-tags"></i> <s:text name="carfactory" /></a></li>
			<li id="carmark"><a href="car-mark"><i class="fa fa-tag"></i>
					<s:text name="carmark" /></a></li>
			<li id="breakedPart"><a href="breaked-part"><i
					class="fa fa-gears"></i> <s:text name="breakedPart" /></a></li>
			<li id="company"><a href="company"><i class="fa fa-home"></i>
					<s:text name="company" /></a></li>
		<%
			}		
		%>
		</ul></li>
	<%
		if (request.isUserInRole("admin-role")) {
	%>
	<li class=""><a href="#"><i class="fa fa-cogs"></i><span
			class="title"> <s:text name="others" />
		</span> <span class="arrow"></span> <span class="selectedd"></span> </a>
		<ul class="sub-menu">
			<li id="userList"><a href="usersList"><s:text name="users" /></a></li>
		</ul></li>
	<%
		}
	%>
</ul>
