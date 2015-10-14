<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="display" uri="http://displaytag.sf.net"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="hidden" id="page">
	<s:url action="allEmployeeSalary1" includeParams="none" />
</div>
<div class="page-content">
	<div class="page-header">
		<h2>
			<s:text name="allEmployeeSalaryReport" />
			<small> <i class="icon-double-angle-right"></i>
			</small>
		</h2>
	</div>
	<%
		if (request.isUserInRole("admin-role")) {
	%>
	<s:form action="allEmployeeSalary" cssClass="form-horizontal">
		<div class="row-fluid">
			<div class="col-sm-12">
				<label for="startDate" class="control-label col-sm-2 col-lg-2">
					<s:text name="startDate" />:
				</label>
				<div class="col-sm-2 col-lg-2">
					<s:textfield name="startDateStr" cssClass="form-control"
						id="startDate" autofocus="" />
				</div>
				<label for="endDate" class="control-label col-sm-2 col-lg-2">
					<s:text name="endDate" />:
				</label>
				<div class="col-sm-2 col-lg-2">
					<s:textfield name="endDateStr" cssClass="form-control" id="endDate"
						autofocus="" />
				</div>
			</div>
		</div>
		<div class="row-fluid">
			<div class="col-sm-12">
				<label for="employee" class="control-label col-sm-2 col-lg-2">
					<s:text name="employee" />:
				</label>
				<div class="col-sm-2 col-lg-2">
					<s:select list="employees" listKey="id" listValue="firstName"
						name="employee.id" requiredLabel="true" headerKey="-1"
						headerValue="Бүгд" cssClass="form-control"/>
				</div>
				<div class="col-sm-6 col-lg-6 col-sm-offset-2 col-lg-offset-2">
					<button class="btn btn-success col-sm-4 col-lg-4">
						<i class="icon-search"></i><s:text name="search" />
					</button>
				</div>
			</div>
		</div>
	</s:form>
	<%
		} else {
	%>
	<s:form action="allEmployeeSalary" cssClass="form-horizontal">
		<div class="row-fluid">
			<div class="col-sm-12">
				<label for="startDate" class="control-label col-sm-2 col-lg-2">
					<s:text name="startDate" />
				</label>
				<div class="col-sm-2 col-lg-2">
					<s:textfield name="startDateStr" cssClass="form-control"
						id="startDate" autofocus="" />
				</div>
				<label for="endDate" class="control-label col-sm-2 col-lg-2">
					<s:text name="endDate" />
				</label>
				<div class="col-sm-2 col-lg-2">
					<s:textfield name="endDateStr" cssClass="form-control" id="endDate"
						autofocus="" />
				</div>
			</div>
		</div>
		<div class="row-fluid">
			<div class="col-sm-12">
				<label for="employee" class="controll-label col-sm-2 col-lg-2">
					<s:text name="employee" />
				</label>
				<div class="col-sm-2 col-lg-2">
					<s:select list="employees" listKey="id" listValue="firstName"
						name="employee.id" cssClass="form-control"/>
				</div>
				<div class="col-sm-2 col-lg-2">
					<button class="btn btn-success">
						<i class="icon-search"></i><s:text name="search" />
					</button>
				</div>
			</div>
		</div>
	</s:form>
	<%
		}
	%>
	<div class="row">
		<div class="col-xs-12">
			<div class="table-responsive" id="list-result">
				 <display:table id="example"
					class="table table-striped table-bordered table-hover"
					name="listEmployeeSalary">
					<display:column property="id" title="№" />
					<display:column property="employee.lastName" title="Ажилчны овог" />
					<display:column property="employee.firstName" title="Ажилчны нэр" />
					<display:column property="salary" title="Цалин"
						format="{0,number,#,##0}" />
					<display:column property="employee.id"/>
					<c:forEach items="${example.stepPriceList}" var="p">
						<display:column value="${p.number}"
							title="${p.stepPrice.productStep.name}" format="{0,number,#,##0}" />
						<display:column value="${p.price}" title="Үнэ"
							format="{0,number,#,##0}" />
					</c:forEach>
				</display:table>
				<%-- <table class="table table-striped table-bordered table-hover"
					id="example">
					<thead>
						<tr>
							<th>№</th>
							<th>Ажилчны овог</th>
							<th>Ажилчны нэр</th>
							<th style="width:100px !important" >Цалин</th>
							<c:forEach items="${listEmployeeSalary[0].stepPriceList}" var="p">
								<th style="width:180px !important"><c:out value="${p.stepPrice.productStep.name}"></c:out>
								</th>
								<th style="width:80px !important">Үнэ</th>
							</c:forEach>
						</tr>
					</thead>
					<tbody>
						<s:iterator value="listEmployeeSalary">
							<tr>
								<td><s:property value="id" /></td>
								<td><s:property value="employee.lastName" /></td>
								<td><s:property value="employee.firstName" /></td>
								<td style="width:100px !important"><s:property value="salary" /></td>
								<c:forEach items="${stepPriceList}" var="d">
									<td style="width:180px !important"><c:out value="${d.number}"></c:out>
									</td>
									<td style="width:80px !important"><c:out value="${d.price}"></c:out>
									</td>
								</c:forEach>
							</tr>
						</s:iterator>
					</tbody>
				</table> --%>
			</div>
		</div>
	</div>
</div>
<div id="context" class="hide">${pageContext.request.contextPath}
</div>
<script src="../js/PageJS/allEmployeeSalaryReport.js"></script>