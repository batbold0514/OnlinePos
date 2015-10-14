<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<div class="sidebar-shortcuts" id="sidebar-shortcuts">
	<div class="sidebar-shortcuts-large" id="sidebar-shortcuts-large">
		<a href="<s:url action="numberAndPriceReport" includeParams="none"/>"
			class="btn btn-success"> <i class="icon-signal"></i>
		</a> <a href="productModels" class="btn btn-info"> <i
			class="icon-pencil"></i>
		</a> <a href="<s:url action="allEmployeeSalary1" includeParams="none"/>"
			class="btn btn-warning"> <i class="icon-group"></i>
		</a> <a href="<s:url action="employeeList" includeParams="none"/>"
			class="btn btn-danger"> <i class="icon-cogs"></i>
		</a>
	</div>

	<div class="sidebar-shortcuts-mini" id="sidebar-shortcuts-mini">
		<span class="btn btn-success"></span> <span class="btn btn-info"></span>

		<span class="btn btn-warning"></span> <span class="btn btn-danger"></span>
	</div>
</div>
<ul class="nav nav-list" id="menu">
	<%
		if (!request.isUserInRole("employee-role")) {
	%>
	<li><a
		href="<s:url action="trackingSheetList" includeParams="none"/>"> <i
			class="icon-paste"></i> <span class="menu-text"> <s:text
					name="TrackingSheet" /></span>
	</a></li>
	<%
		}
		if (request.isUserInRole("admin-role")
				|| request.isUserInRole("user-role")
				|| request.isUserInRole("designer-role")) {
	%>
	<li><a href="#" class="dropdown-toggle"> <i
			class="icon-picture"></i> <span class="menu-text"><s:text
					name="ProductModel" /></span> <b class="arrow icon-angle-down"></b></a>
		<ul class="submenu">
			<li><a
				href="<s:url action="productModels" includeParams="none"/>"><s:text
						name="listProductModel" /></a></li>
			<li><a
				href="<s:url action="productModel" includeParams="none"/>"><s:text
						name="saveProductModel" /></a></li>
		</ul></li>
	<%
		}
	%>
	<li><a href="#" class="dropdown-toggle"> <i class="icon-book"></i>
			<span class="menu-text"><s:text name="Report" /></span> <b
			class="arrow icon-angle-down"></b></a>
		<ul class="submenu">
			<li><a
				href="<s:url action="allEmployeeSalary1" includeParams="none"/>"><s:text
						name="allEmployeeSalaryReport" /></a></li>
			<%
				if (request.isUserInRole("admin-role")
						|| request.isUserInRole("user-role")
						|| request.isUserInRole("designer-role")) {
			%>
			<li><a
				href="<s:url action="numberAndPriceReport" includeParams="none"/>"><s:text
						name="numberAndPriceReport" /></a></li>
			<li><a href="<s:url action="yarnReport" includeParams="none"/>"><s:text
						name="yarnReport" /></a></li>
			<li><a href="<s:url action="totalYarnReport" includeParams="none"/>"><s:text
						name="totalYarnReport" /></a></li>
			<li><a href="<s:url action="modelReport" includeParams="none"/>"><s:text
						name="ModelReport" /></a></li>
			<%
				}
			%>
		</ul></li>
	<%
		if (request.isUserInRole("admin-role")) {
	%>
	<li><a href="#" class="dropdown-toggle"> <i
			class="icon-info-sign"></i> <span class="menu-text"><s:text
					name="Settings" /></span> <b class="arrow icon-angle-down"></b></a>
		<ul class="submenu">
			<li><a
				href="<s:url action="productionSteps" includeParams="none"/>"><s:text
						name="listProductionStep" /></a></li>

			<li><a href="<s:url action="stoll-price" includeParams="none"/>">
					<s:text name="StollPrice" />
			</a></li>
			<li><a
				href="<s:url action="customer-list" includeParams="none"/>"> <s:text
						name="CustomerList" />
			</a></li>
			<li><a href="<s:url action="materials" includeParams="none"/>"><s:text
						name="Material" /></a></li>
			<li><a
				href="<s:url action="productTypes" includeParams="none"/>"><s:text
						name="productType" /></a></li>
			<li><a href="<s:url action="colourList" includeParams="none"/>">
					<s:text name="ColourList" />
			</a></li>
			<li><a href="<s:url action="sizeList" includeParams="none"/>">
					<s:text name="SizeList" />
			</a></li>
			<li><a
				href="<s:url action="occupationList" includeParams="none"/>"> <s:text
						name="occupation" />
			</a></li>
			<li><a
				href="<s:url action="employeeList" includeParams="none"/>"> <s:text
						name="listEmployee" />
			</a></li>
			<li><a href="<s:url action="usersList" includeParams="none"/>"><s:text
						name="userList" /></a></li>
			<li><a href="<s:url action="bonusList" includeParams="none"/>">
					<s:text name="Bonus" />
			</a></li>
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
