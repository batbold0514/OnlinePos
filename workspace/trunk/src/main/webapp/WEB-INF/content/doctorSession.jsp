<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="display" uri="http://displaytag.sf.net"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div class="hidden" id="page">
	<s:url action="search-patient" includeParams="none" />
</div>
<div class="page-content">
	<div class="page-header">
		<h3>
			<s:text name="addSession" />
		</h3>
	</div>
	<s:form action="saveSession" id="id1" cssClass="form-horizontal">
		<s:hidden key="id" />
		<div class="row">
			<div class="col-sm-12">
				<div class="row">
					<div class="form-group">
						<label for="date" class="control-label col-sm-4 col-lg-4">
							<s:text name="date"></s:text>:
						</label>
						<div class="col-sm-4 col-lg-4">
							<%
								if (request.isUserInRole("admin-role")) {
							%>
							<s:textfield key="dateStr" displayFormat="yyyy-MM-dd" id="date"
								cssClass="form-control" />
							<%
								;
									} else {
							%>
							<s:textfield key="dateStr" displayFormat="yyyy-MM-dd" id="date"
								disabled="true" cssClass="form-control" />
							<%
								;
									}
							%>
						</div>
					</div>
				</div>
				<div class="row">
					<div class="form-group">
						<label for="doctor" class="control-label col-sm-4 col-lg-4">
							<s:text name="doctor"></s:text>:
						</label>
						<div class="col-sm-4 col-lg-4">
							<s:if test="%{#session.doctor == null}">
								<s:select label="%{getText('doctor')}" name="doctor.id"
									id="doctor" list="doctors" listKey="id" listValue="name"
									headerKey="" headerValue="<---Select Doctor--->"
									cssClass="form-control" />
							</s:if>
							<s:else>
								<s:select label="%{getText('doctor')}" name="doctor.id"
									id="doctor" list="doctors" listKey="id" listValue="name"
									headerValue="%{#session.doctor.name}"
									headerKey="%{#session.doctor.id}" cssClass="form-control" />
							</s:else>
						</div>
					</div>
					<div class="row">
						<s:fielderror name="doctor.id" />
					</div>
				</div>
				<div class="row">
					<div class="form-group">
						<label for="ls" class="control-label col-sm-4 col-lg-4"> <s:text
								name="listOfService"></s:text>:
						</label>
						<div class="col-sm-4 col-lg-4">
							<s:select label="%{getText('listOfService')}" id="ls"
								name="listOfService.id"
								cssClass="form-control tag-input-style chosen-select"
								list="prices" listKey="id"
								listValue="code+'  | '+price+' | '+name" multiple="true"
								data-placeholder="Үйлчилгээ сонгоно уу" onselect="alt()" />
						</div>
					</div>
					<div class="row">
						<s:fielderror name="listOfService.id" />
					</div>
				</div>
				<div class="row">
					<div class="form-group">
						<label for="ld" class="control-label col-sm-4 col-lg-4"> <s:text
								name="listOfDiagnosis"></s:text>:
						</label>
						<div class="col-sm-4 col-lg-4">
							<s:select label="%{getText('listOfDiagnosis')}" id="ld"
								name="listOfDiagnosis.id"
								cssClass="form-control tag-input-style chosen-select"
								list="diagnosisList" listKey="id" listValue="code+' | '+name"
								multiple="true" data-placeholder="Онош сонгоно уу" />
						</div>
					</div>
					<div class="row">
						<s:fielderror name="listOfService.id" />
					</div>
				</div>
				<div class="row">
					<div class="form-group">
						<label for="textarea" class="control-label col-sm-4 col-lg-4">
							<s:text name="note"></s:text>:
						</label>
						<div class="col-sm-4 col-lg-4">
							<s:textarea cols="43" rows="5" name="note" id="textarea"
								onkeyup="myfunc(note.value)" cssClass="form-control" />
						</div>
					</div>
				</div>
				<div class="row">
					<div class="col-lg-offset-5 col-sm-offset-5 col-sm-12">
						<button class="btn btn-success col-sm-1 col-lg-1" id="okbut">
							<i class="icon-save"></i>
							<s:text name="save"></s:text>
						</button>
						<button class="btn btn-warning col-sm-1 col-lg-1" form="backform">
							<i class="icon-arrow-right"></i>
							<s:text name="back"></s:text>
						</button>
						<%-- <button class="btn btn-info col-sm-1 col-lg-1" form="nextform">
							<i class="icon-next"></i><s:text name="next"></s:text>
						</button> --%>
						<s:submit cssClass="btn btn-info col-sm-1 col-lg-1"
							action="sessionNext" value="Дараах" >
						</s:submit>
					</div>
				</div>
			</div>
		</div>
	</s:form>
	<div class="center">
		<s:form action="back" id="backform">
			<s:hidden key="id" />
		</s:form>
	</div>
	<div id="dialog" title="Wait">
		<div style="text-align: center; width: 100%">
			<p>Түр хүлээн үү!</p>
			<img src="../img/waiting.gif" height="30px" width="40px" />
		</div>
	</div>
</div>
<script type="text/javascript">
	$(function() {
		$("input[type=submit]").button();
		$("#textarea").attr("maxlength", "1024");
	});
	function myfunc(str) {
		if (str.length >= 1024) {
			alert("Тайлбар 1024 тэмдэгтээс хэтрэхгүй");
		}
	}
	$(document).ready(function() {
		$("#date").datepicker({
			changeMonth : true,
			changeYear : true,
			dateFormat : "yy-mm-dd"
		});
		$("#okbut").click(function(e) {
			$("#dialog").dialog("open");
		});
		$("#dialog").dialog({
			autoOpen : false,
			modal : true
		});
		$('.chosen-select').chosen();
	});

	
</script>