<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<ul class="nav nav-list" id="menu">

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