<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="display" uri="http://displaytag.sf.net"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div class="hidden" id="page">
	<s:url action="employee-list" includeParams="none" />
</div>
<p class="active_menu hide">empReport</p>
<div class="row">
	<div class="col-sm-12">
		<h3 class="page-title">
			<s:text name="employee" />
		</h3>
	</div>
	<div class="row">
		<s:form action="" id = "searchFrom">
			<div class="col-sm-12">
				<label class="control-label col-sm-2 col-lg-1" for="secondDate">
					<s:text name="firstDate" />
				</label>
				<div class="col-sm-3 col-lg-2">
					<s:textfield name="firstDate" id="date1" />
				</div>
				<label class="control-label col-sm-2 col-lg-1" for="secondDate">
					<s:text name="secondDate" />
				</label>
				<div class="col-sm-3 col-lg-2">
					<s:textfield name="secondDate" id="date2" />
				</div>
				<label class="control-label col-sm-2 col-lg-1" for="empId">
					<s:text name="employee"></s:text>
				</label>
				<div class="col-sm-3 col-lg-2">
				<%
					if(request.isUserInRole("admin-role")){
				%>
					<s:select list="employees" listKey="id" listValue="firstName" cssClass="form-control"
						headerKey="" headerValue="" name="empId" id="empselect"
					></s:select>
				<%
					}else{
				%>
					<s:textfield name="username" cssClass="form-control" disabled="true"></s:textfield>
				<%
					}
				%>
				</div>
				<div class="col-sm-2 col-lg-1">
					<button class="btn blue" id = "submit">
						<i class="fa fa-search"></i>
						<s:text name="search"></s:text>
					</button>
				</div>
			</div>
		</s:form>
	</div>
	<div class="portlet box blue">
		<div class="portlet-title">
			<div class="caption">
				<i class="fa fa-group"> <s:text name="employee" /></i>
			</div>
			<div class="tools">
				<a href="javascript:;" class="collapse"></a>
			</div>
		</div>
		<div class="portlet-body">
		</div>
	</div>
</div>
<div id="parseResult" class=hidden></div>
<div id="context" class="hide">${pageContext.request.contextPath}
</div>
<script src="../js/PageJS/emp-report.js"></script>