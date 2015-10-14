<%@page import="mn.chinbat.surgery.enums.Customer"%>
<%@page import="mn.chinbat.surgery.model.Messages"%>
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
	<div class="col-sm-12">
		<s:set var="user">${pageContext.request.remoteUser}</s:set>
		<s:form action="savePayment" cssClass="form-horizontal">
			<s:hidden key="id" />
			<s:hidden key="patientid" />
			<s:hidden key="user" value="%{user}" />
			<div class="row-fluid">
				<div class="form-group">
					<div class="row">
						<div class="col-sm-12">
							<label for="doctorId" class="control-label col-sm-4 col-lg-4">
								<s:text name="doctorID" />:
							</label>
							<div class="col-sm-4 col-lg-4">
								<%
									if (Messages.getCustomer("customer").trim()
												.equals(Customer.degfim.toString().trim())) {
								%>
								<s:if test="doctors == null">
									<s:select key="doctorID" list="allDoctors" listKey="id"
										id="doctorId" listValue="name" headerKey="" headerValue=""
										cssClass="form-control" />
								</s:if>
								<s:else>
									<s:select key="doctorID" list="doctors" listKey="id"
										id="doctorId" listValue="name" cssClass="form-control" />
								</s:else>
								<div class="row">
									<s:fielderror name="doctorID" />
								</div>
								<%
									}
								%>
							</div>
						</div>
					</div>
				</div>
				<div class="form-group">
					<div class="row">
						<div class="col-sm-12">
							<label for="value" class="control-label col-sm-4 col-lg-4">
								<s:text name="value" />:
							</label>
							<div class="col-sm-4 col-lg-4">
								<s:textfield name="value" id="value" cssClass="form-control" />
							</div>
							<div class="row">
								<s:fielderror name="value" />
							</div>
						</div>
					</div>
				</div>
				<div class="form-group">
					<div class="row">
						<div class="col-sm-12">
							<label for="paymentMethod"
								class="control-label col-sm-4 col-lg-4"> <s:text
									name="paymentMethod" />:
							</label>
							<div class="col-sm-4 col-lg-4">
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
					</div>
				</div>
				<div class="form-group">
					<div class="row">
						<div class="col-sm-12">
							<label for="description" class="control-label col-sm-4 col-lg-4">
								<s:text name="description" />:
							</label>
							<div class="col-sm-4 col-lg-4">
								<s:textarea name="description" id="description"
									cssClass="form-control" />
							</div>
						</div>
					</div>
				</div>
				<div class="form-group">
					<div class="row">
						<div class="col-sm-12">
							<label for="date" class="control-label col-sm-4 col-lg-4">
								<s:text name="date" />:
							</label>
							<div class="col-sm-4 col-lg-4">
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
					</div>
				</div>
				<div class="row">
					<div class="col-sm-offset-4 col-sm-12">
						<button class="btn btn-success col-sm-2" id="okbut">
							<s:text name="save" />
						</button>
						<a id="backbut" class="btn btn-warning col-sm-2"> <s:text
								name="back" />
						</a>
					</div>
				</div>
			</div>
		</s:form>
		<s:form action="back" cssClass="hide">
			<s:hidden key="id" />
			<button class="btn btn-warning col-sm-2" id="backbuth">
				<s:text name="back" />
			</button>
		</s:form>
	</div>
	<div id="dialog" title="Wait">
		<div style="text-align: center; width: 100%">
			<p>Түр хүлээн үү!</p>
			<img src="../img/waiting.gif" height="30px" width="40px" />
		</div>
	</div>
</div>
<script>
	$(document).ready(function() {
		$("#date").datepicker({
			changeMonth : true,
			changeYear : true,
			dateFormat : "yy-mm-dd"
		});
		$("#backbut").click(function(e) {
			document.getElementById('backbuth').click();
		});
		$("#okbut").click(function(e) {
			$("#dialog").dialog("open");
		});
		$("#dialog").dialog({
			autoOpen : false,
			modal : true
		});
	});

	
</script>