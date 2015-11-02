<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<ul class="page-sidebar-menu" id="menu">
	<li class="sidebar-toggler-wrapper">
		<div class="sidebar-toggler hidden-phone"></div>
	</li>

	<li class=""><a href="#"><i class="fa fa-home"></i><span
			class="title"><s:text name="project" /></span><span
			class="arrow "></span><span class="selectedd"></span> </a>
		<ul class="sub-menu">
			<li id="createProject"><a href="create-project"><s:text name="createProject" /></a></li>
			<li id="activeProject"><a href="active-project"><s:text name="activeProjects" /></a></li>
		</ul></li>
	<li class=""><a href="#"><i class="fa fa-home"></i><span
			class="title"><s:text name="enquireModel" /></span><span
			class="arrow "></span><span class="selectedd"></span> </a>
		<ul class="sub-menu">
				<li id="enquireModelList"><a href="enquireModelLists"><s:text name="enquireModel" /></a></li>
		</ul></li>
	<li class=""><a href="#"><i class="fa fa-cogs"></i><span
			class="title"> <s:text name="report" />
		</span> <span class="arrow"></span> <span class="selectedd"></span> </a>
		<ul class="sub-menu">
			<li id="projectReport"><a href="#"><s:text name="projectReport" /></a></li>
			<li id="budgetReport"><a href="#"><s:text name="budgetReport" /></a></li>
			<li id="humanResourceReport"><a href="#"><s:text name="humanResourceReport" /></a></li>
		</ul></li>
	<li class=""><a href="#"><i class="fa fa-cogs"></i><span
			class="title"> <s:text name="others" />
		</span> <span class="arrow"></span> <span class="selectedd"></span> </a>
		<ul class="sub-menu">
			<li id="userList"><a href="usersList"><s:text name="users" /></a></li>
			<li id="enquireTypeList"><a href="enquireTypeLists"><s:text name="enquireType" /></a></li>
			<li id="customer"><a href="customerList"><s:text name="customer" /></a></li>
			<li id="itemName"><a href="itemNameList"><s:text name="itemName" /></a></li>
		</ul>
	</li>
</ul>
