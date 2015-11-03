<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<ul class="page-sidebar-menu" id="menu">
	<li class="sidebar-toggler-wrapper">
		<div class="sidebar-toggler hidden-phone"></div>
	</li>
	<%
		if (request.isUserInRole("admin-role")) {
	%>
	<li class=""><a href="#"><i class="fa fa-home"></i><span
			class="title"><s:text name="registration" /></span><span
			class="arrow "></span><span class="selectedd"></span> </a>
		<ul class="sub-menu">
			<li id = "KeepingAndCredit"><a href="KeepingAndCredit"><s:text name="keepingAndCredit" /></a> </li>
			<li id = "AssetsAndBond"><a href="AssetsAndBond"><s:text name="assetsAndBond" /></a> </li>
			<li id = "Investment"><a href="Investment"><s:text name="investment" /></a> </li>
			<li id = "Insurance"><a href="Insurance"><s:text name="insurance" /></a> </li>
			<li id = "Custodians"><a href="Custodians"><s:text name="custodians" /></a> </li>
		</ul>
	</li>
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
