<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<ul class="nav nav-list" id="menu">

	<li><a href="<s:url action="calendar" includeParams="none"/>">
			<i class="icon-time"></i> <span class="menu-text"> <s:text
					name="Appcal" /></span>
	</a></li>

	<li><a href="#" class="dropdown-toggle"> <i
			class="icon-group"></i> <span class="menu-text"><s:text
					name="patient" /></span> <b class="arrow icon-angle-down"></b></a>
		<ul class="submenu">
			<li><a
				href="<s:url action="search-patient" includeParams="none"/>"><s:text
						name="search" /></a></li>
			<li><a href="<s:url action="linkPatient" includeParams="none"/>"><s:text
						name="addPatient" /></a></li>
		</ul></li>
	<li><a href="#" class="dropdown-toggle"> <i class="icon-list-alt"></i>
			<span class="menu-text"><s:text name="report" /></span> <b
			class="arrow icon-angle-down"></b></a>
		<ul class="submenu">
			<li><a href="<s:url action="dayBalance" includeParams="none"/>"><s:text
						name="dayb" /></a></li>
			<li><a
				href="<s:url action="monthBalance" includeParams="none"/>"><s:text
						name="monthb" /></a></li>
			<li><a
				href="<s:url action="monthBalance1" includeParams="none"/>"><s:text
						name="monthb1" /></a></li>
			<li><a
				href="<s:url action="debtCustomers" includeParams="none"/>"><s:text
						name="Debtcus" /></a></li>
			<li><a
				href="<s:url action="donationCustomers" includeParams="none"/>"><s:text
						name="donationcus" /></a></li>
			<li><a
				href="<s:url action="bestCustomers" includeParams="none"/>"><s:text
						name="bestCustomers" /></a></li>

		</ul></li>
	<li><a href="#" class="dropdown-toggle"> <i class="icon-tags"></i>
			<span class="menu-text"><s:text name="price" /></span> <b
			class="arrow icon-angle-down"></b></a>
		<ul class="submenu">
			<li><a href="<s:url action="linkPrices" includeParams="none"/>"><s:text
						name="listPrices" /></a></li>
		</ul></li>
	<li><a href="#" class="dropdown-toggle"> <i class="icon-comment"></i>
			<span class="menu-text"><s:text name="Diagnosis" /></span> <b
			class="arrow icon-angle-down"></b></a>
		<ul class="submenu">
			<li><a
				href="<s:url action="diagnosisList" includeParams="none"/>"><s:text
						name="DiagnosisList" /></a></li>
		</ul></li>
	<%
		if (request.isUserInRole("admin-role")) {
	%>
	<li><a href="#" class="dropdown-toggle"> <i
			class="icon-user"></i> <span class="menu-text"><s:text
					name="doctor" /></span> <b class="arrow icon-angle-down"></b></a>
		<ul class="submenu">
			<li><a href="<s:url action="doctors" includeParams="none"/>"><s:text
						name="listDoctor" /></a></li>

		</ul></li>
	<li><a href="#" class="dropdown-toggle"> <i
			class="icon-user"></i> <span class="menu-text"><s:text
					name="user" /></span> <b class="arrow icon-angle-down"></b></a>
		<ul class="submenu">
			<li><a href="<s:url action="usersList" includeParams="none"/>"><s:text
						name="userList" /></a></li>

		</ul></li>
	<%
		}
	%>
</ul>
<div class="sidebar-collapse" id="sidebar-collapse">
	<i class="icon-double-angle-left" data-icon1="icon-double-angle-left"
		data-icon2="icon-double-angle-right"></i>
</div>
<script type="text/javascript">
	try {
		ace.settings.check('sidebar', 'collapsed')
	} catch (e) {
	}

	
</script>