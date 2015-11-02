<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="display" uri="http://displaytag.sf.net"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div class="row">
	<p class="active_menu hide">createProject</p>
	<div class="form-group col-sm-12">
		<label class="control-label col-sm-2" for="projectName"> <s:text
				name="projectName" />
		</label>
		<div class="col-sm-8">
			<s:textfield name="projectName" cssClass="form-control" />
		</div>
	</div>
	<div class="form-group col-sm-12">
		<label class="control-label col-sm-2" for="projectManagerId"><s:text
				name="projectManager" /></label>
		<div class="col-sm-8">
			<s:select name="projectManagerId" list="employees" listKey="id"
				cssClass="form-control select" listValue="firstName" headerKey=""
				headerValue=""></s:select>
		</div>
	</div>
	<div class="form-group col-sm-12">
		<label class="control-label col-sm-2" for="startDateStr"> <s:text
				name="firstDate" />
		</label>
		<div class="col-sm-3">
			<s:textfield name="startDateStr" cssClass="date form-control" />
		</div>
		<label class="control-label col-sm-2" for="endDateStr"> <s:text
				name="endDate" />
		</label>
		<div class="col-sm-3">
			<s:textfield name="endDateStr" cssClass="date form-control" />
		</div>
	</div>
	<div class="form-group col-sm-12">
		<label class="control-label col-sm-2" for="projectGoal"> <s:text
				name="projectGoal"></s:text>
		</label>
		<div class="col-sm-8">
			<s:textarea name="projectGoal" rows="5" cssClass="form-control" />
		</div>
	</div>
	<div class="form-group col-sm-12">
		<label class="control-label col-sm-2" for="members"> <s:text
				name="projectMembers" />
		</label>
		<div class="col-sm-8">
			<s:select list="employees" name="members" listKey="id"
				listValue="firstName" headerKey="" headerValue=""
				cssClass="form-control select" multiple="true"></s:select>
		</div>
	</div>
</div>
<div class="row">
	<div class="col-sm-10">
		<div class="row">
			<button class="btn grey" id="addBtn">
				<s:text name="add"></s:text>
			</button>
			<button class="btn grey" id="editBtn">
				<s:text name="edit"></s:text>
			</button>
			<button class="btn grey" id=createBtn>
				<s:text name="delete"></s:text>
			</button>
		</div>
		<div class="row">
			<table class="table table-hover table-bordered">
				<thead>
					<tr>
						<th><s:text name="firstDate" /></th>
						<th><s:text name="endDate" /></th>
						<th><s:text name="status" /></th>
						<th><s:text name="projectManager" /></th>
					</tr>
				</thead>
				<tbody>
					<s:iterator value="#session.tasks" status="stat" var="iter">
						<tr>
							<th><s:property value="#iter.startDate" /></th>
							<th><s:property value="#iter.endDate" /></th>
							<th><s:property value="#iter.status.status" /></th>
							<th><s:property value="#iter.id" /></th>
						</tr>
					</s:iterator>
				</tbody>
			</table>
		</div>
	</div>
</div>

<div class="hide" id="dialog-task">
	<s:form action="#" id="taskForm">
		<div class="form-group col-sm-12">
			<label class="control-label col-4" for="employee"> <s:text
					name="employee"></s:text>
			</label>
			<div class="col-sm-8">
				<s:select list="employees" name="employee" listKey="id"
					listValue="firstName" headerKey="" headerValue=""
					cssClass="form-control dselect"></s:select>
			</div>
		</div>
		<div class="form-group col-sm-12">
			<label class="control-label col-4" for="firstDate"> <s:text
					name="firstDate"></s:text>
			</label>
			<div class="col-sm-8">
				<s:textfield name="firstDate" cssClass="form-control date"></s:textfield>
			</div>
		</div>
		<div class="form-group col-sm-12">
			<label class="control-label col-4" for="endDate"> <s:text
					name="endDate"></s:text>
			</label>
			<div class="col-sm-8">
				<s:textfield name="endDate" cssClass="form-control date"></s:textfield>
			</div>
		</div>
		<div class="form-group col-sm-12">
			<label class="control-label col-4" for="description"> <s:text
					name="description"></s:text>
			</label>
			<div class="col-sm-8">
				<s:textfield name="description" cssClass="form-control"></s:textfield>
			</div>
		</div>

	</s:form>
</div>
<script src="../js/PageJS/create-project.js">
	
</script>
