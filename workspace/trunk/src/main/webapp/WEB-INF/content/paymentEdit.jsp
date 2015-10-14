<%@page import="mn.chinbat.surgery.enums.Customer"%>
<%@page import="mn.chinbat.surgery.model.Messages"%>
<%@page import="javax.swing.JOptionPane"%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="display" uri="http://displaytag.sf.net"%>
<div class="hidden" id="page">
	<s:url action="search-patient" includeParams="none" />
</div>
<div class="page-content">
	<div class="page-header">
		<h3>
			<s:text name="addPayment" />
		</h3>
	</div>
	<s:set var="user">${pageContext.request.remoteUser}</s:set>
	<s:form action="savePayment" cssClass="form-horizontal">
		<s:hidden key="id" />
		<s:hidden key="patientid" value="%{#session.id.patientid}" />
		<s:hidden key="user" value="%{user}" />
		<div class="row">
			<div class="col-sm-12">
				<div class="row">
					<label for="value" class="control-label col-sm-4 col-lg-4">
						<s:text name="value" />:
					</label>
					<div class="col-sm-4 col-lg-3">
						<s:textfield name="value" id="value" cssClass="form-control" />
					</div>
					<div class="row">
						<s:fielderror name="value" />
					</div>
				</div>
				<div class="row">
					<label for="paymentMethod" class="control-label col-sm-4 col-lg-4">
						<s:text name="paymentMethod" />:
					</label>
					<div class="col-sm-4 col-lg-3">
						<%
							if (request.isUserInRole("admin-role")) {
						%>
						<s:select key="paymentMethod" list="PaymentMethods"
							listValue="label" id="paymentMethod" cssClass="form-control" />
						<%
							;
								} else {
						%>
						<s:select key="paymentMethod" list="PaymentMethodsForUser"
							listValue="label" id="paymentMethod" cssClass="form-control" />
						<%
							;
								}
						%>
					</div>
				</div>
				<div class="row">
					<label for="description" class="control-label col-sm-4 col-lg-4">
						<s:text name="description" />:
					</label>
					<div class="col-sm-4 col-lg-3">
						<s:textarea name="description" id="description"
							cssClass="form-control" />
					</div>
				</div>
				<div class="row">
					<label for="date" class="control-label col-sm-4 col-lg-4">
						<s:text name="date" />:
					</label>
					<div class="col-sm-4 col-lg-3">
						<%
							if (request.isUserInRole("admin-role")) {
						%>
						<s:textfield name="dateString" id="date" cssClass="form-control" />
						<%
							;
								} else {
						%>
						<s:textfield name="dateString" disabled="true" id="date"
							cssClass="form-control" />
						<%
							;
								}
						%>
					</div>
				</div>
				<div class="row">
					<div class="col-sm-offset-5 col-sm-12">
						<button class="btn btn-success col-sm-1">
							<s:text name="save" />
						</button>
						<button class="btn btn-warning col-sm-1" form="formBack">
							<s:text name="back" />
						</button>
					</div>
				</div>
			</div>
		</div>
	</s:form>
	<s:form action="back" id="formBack">
		<s:hidden key="patient.id" />
	</s:form> 
</div>
<script>
	$(document).ready(function() {
		$("#date").datepicker({
			changeMonth : true,
			changeYear : true,
			dateFormat : "yy-mm-dd"
		});
	});
</script>
<%-- <%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<%@ taglib prefix="sx" uri="/struts-dojo-tags"%>
<sj:head jquerytheme="lefrog" jqueryui="true" />
<h3>
	<s:text name="addPayment" />
</h3>
<sx:head />
<s:set var="user">${pageContext.request.remoteUser}</s:set>
<table>
	<tr>
		<th><s:form action="editPayment">
				<s:hidden key="id" />
				<s:hidden key = "patientid" value="%{#session.id.patientid}"/>
				<s:hidden key= "patient.id"/>
				<s:hidden key = "user" value = "%{user}"/>
				<s:textfield key="value" />
				<s:select key="paymentMethod" list="PaymentMethods" />
				<s:textfield key="description" />
				<sx:datetimepicker key="date" type="date" displayFormat="yyyy-MM-dd" disabled="true"/>
				<sj:submit id="save" value="%{getText('save')}" button="true"
					cssStyle="font-size:15px; float:right"></sj:submit>
			</s:form></th>
		<th style="vertical-align: bottom"><s:form action="back">
				<s:hidden key="patient.id" />
				<sj:submit id="backID" button="true" value="%{getText('back')}" cssStyle="font-size:15px"></sj:submit>
			</s:form></th>
	</tr>
</table> --%>