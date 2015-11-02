<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="display" uri="http://displaytag.sf.net"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div class="form-group">
	<div class="row col-cm-12">
		<div class="col-sm-7 col-lg-6">
			<h3 class="page-title">
				<s:text name="connectedpersonreport" />
			</h3>
		</div>
		<div>
			<s:form action="connected-person-report">
				<div class="row col-sm-12">
					<label for="startDate" class="control-label col-sm-1 col-lg-1">
						<s:text name="startDate" />
					</label>
					<div class="col-sm-2 col-lg-2">
						<s:textfield name="startDateString" value="%{startDateString}"
							cssClass="form-control" id="startDate" />
					</div>
					<label for="endDate" class="control-label col-sm-1 col-lg-1">
						<s:text name="endDate" />
					</label>
					<div class="col-sm-2 col-lg-2">
						<s:textfield name="endDateString" value="%{endDateString}"
							cssClass="form-control" id="endDate" />
					</div>
					<div class="col-sm-2 col-lg-2">
						<s:select list="connectedPersons" listKey="id" listValue="personDescription" headerKey="%" headerValue="Бүгд" cssClass="form-control selects" 
						name = "connectedPersonString"/>
					</div>
					<div class = "col-sm-1 col-lg-1">
						<s:text name = "allShow"/><s:checkbox name = "allShow"/>
					</div>
					<div class="col-sm-3 col-lg-3">
						<button class="btn btn-success col-sm-12 col-lg-12">
							<s:text name="search" />
						</button>
					</div>
				</div>
			</s:form>
		</div>
	</div>
</div>
<hr>
<div class="row">
	<div class="portlet box blue">
		<div class="portlet-title">
			<div class="caption">
				<i class="fa fa-phone"> <s:text name="process" /></i>
			</div>
			<div class="tools">
				<a href="javascript:;" class="collapse"></a>
			</div>
		</div>
		<div class="portlet-body">
			<div id="list-result">
				<table id="sampletable2" class="display table-bordered table-hoverdataTable">
					<thead>
						<tr>
							<th>Холбогдсон этгээд</th>
							<th>Оператор</th>
							<s:if test="allShow != true">
								<th>Тоо ширхэг</th>
							</s:if><s:else>
								<th>Огноо</th>
							</s:else>
						</tr>
					</thead>
					<tbody>
						<s:iterator value="conPersonReports" var = "person">
							 <s:if test="allShow != true">
							 	<tr>
									<td><s:property value = "#person.listOfCall[0].person.personDescription"/></td>
									<td><s:property value = "#person.listOfCall[0].operator.userName"/></td>
									<td><s:property value = "#person.listOfCall.size"/></td>
								</tr>
							 </s:if><s:else>
							 	<s:iterator value="#person.listOfCall" var = "call">
								 	<tr>
								 		<td><s:property value = "#call.person.personDescription"/></td>
								 		<td><s:property value = "#call.operator.userName"/></td>
								 		<td><s:property value = "#call.date"/></td>
								 	</tr>
								</s:iterator>
							 </s:else>
						</s:iterator>
					</tbody>
					<tfoot>
						<tr>
							<th ><s:text name="total"/></th>
							<th></th>
							<th id="total" />
						</tr>
					</tfoot>
				</table>
			</div>
		</div>
	</div>
</div>

<script src="../js/PageJS/connected-person-report.js"></script>