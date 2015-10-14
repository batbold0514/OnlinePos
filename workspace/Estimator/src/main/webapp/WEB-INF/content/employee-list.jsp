<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="display" uri="http://displaytag.sf.net"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div class="hidden" id="page">
	<s:url action="employee-list" includeParams="none" />
</div>
<p class = "active_menu hide">employee</p>
<div class="row">
	<div class="col-sm-12">
		<h3 class="page-title">
			<s:text name="employee" />
		</h3>
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
			<div class="table-toolbar">
				<div class="btn-group">
					<button class="btn green" style="border-radius: 4rem" id="btnAdd">
						<s:text name="add" />
						<i class="fa fa-plus"></i>
					</button>
					<button class="btn yellow" id="btnEdit">
						<s:text name="edit" />
						<i class="fa fa-edit"></i>
					</button>
					<button class="btn blue" id="btnShow">
						<s:text name="show" />
						<i class="fa fa-eye"></i>
					</button>
				</div>
			</div>
			<div id="list-result">
				<display:table name="employeeList" id="sampletable2"
					class="display table-bordered table-hoverdataTable">
					<display:column property="id" title="" />
					<display:column property="lastName" title="Овог" />
					<display:column property="firstName" title="Нэр" />
					<display:column property="phoneNumber" title="Утасны дугаар" />
					<display:column property="regNumber" title="Регистер" />
					<display:column property="status" title="Төлөв" />
					<display:column property="status.status" title="Төлөв" />
					<display:column property="user.userName" title="Хэрэглэчийн эрх" />
					<display:column property="user.id" title="" />
				</display:table>
			</div>
		</div>
	</div>
</div>
<div id="dialog-show-container">
	<div id="dialog-show" class="hide">
		<div class="form-group">
			<div class="row">
				<div class="col-sm-12">
					<label for="lastName" class="control-label col-sm-5 col-lg-5">
						<s:text name="lastName" />
					</label>
					<div class="col-sm-7 col-lg-6">
						<s:textfield name="lastName" cssClass="form-control" autofocus=""
							disabled="true" />
					</div>
				</div>
			</div>
		</div>
		<div class="form-group">
			<div class="row">
				<div class="col-sm-12">
					<label for="firstName" class="control-label col-sm-5 col-lg-5">
						<s:text name="firstName" />
					</label>
					<div class="col-sm-7 col-lg-6">
						<s:textfield name="firstName" cssClass="form-control" autofocus=""
							disabled="true" />
					</div>
				</div>
			</div>
		</div>
		<div class="form-group">
			<div class="row">
				<div class="col-sm-12">
					<label for="phoneNumber" class="control-label col-sm-5 col-lg-5">
						<s:text name="phoneNumber" />
					</label>
					<div class="col-sm-7 col-lg-6">
						<s:textfield name="phoneNumber" cssClass="form-control"
							autofocus="" disabled="true" />
					</div>
				</div>
			</div>
		</div>
		<div class="form-group">
			<div class="row">
				<div class="col-sm-12">
					<label for=regNumber class="control-label col-sm-5 col-lg-5">
						<s:text name="regNumber" />
					</label>
					<div class="col-sm-7 col-lg-6">
						<s:textfield name="regNumber" cssClass="form-control" autofocus=""
							disabled="true" />
					</div>
				</div>
			</div>
		</div>
		<div class="form-group">
			<div class="row">
				<div class="col-sm-12">
					<label for=user class="control-label col-sm-5 col-lg-5">
						<s:text name="user" />
					</label>
					<div class="col-sm-7 col-lg-6">
						<s:textfield name="user" cssClass="form-control" autofocus=""
							disabled="true" />
					</div>
				</div>
			</div>
		</div>
		<div class="form-group">
			<div class="row">
				<div class="col-sm-12">
					<label for=status class="control-label col-sm-5 col-lg-5">
						<s:text name="status" />
					</label>
					<div class="col-sm-7 col-lg-6">
						<s:textfield name="status" cssClass="form-control" autofocus=""
							disabled="true" />
					</div>
				</div>
			</div>
		</div>
	</div>
</div>
<div id="dialog-addnew" class="hide">
	<s:form action="userSave" cssClass="form-horizontal" id="addForm">
		<s:hidden name="id" />
		<div class="form-group">
			<div class="row">
				<div class="col-sm-12">
					<label for="lastName" class="control-label col-sm-5 col-lg-5">
						<s:text name="lastName" /><span class="required"> * </span>
					</label>
					<div class="col-sm-7 col-lg-6">
						<s:textfield name="lastName" cssClass="form-control" id="lastName"
							autofocus="" />
					</div>
				</div>
			</div>
		</div>
		<div class="form-group">
			<div class="row">
				<div class="col-sm-12">
					<label for="firstName" class="control-label col-sm-5 col-lg-5">
						<s:text name="firstName" /><span class="required"> * </span>
					</label>
					<div class="col-sm-7 col-lg-6">
						<s:textfield name="firstName" cssClass="form-control"
							id="firstName" autofocus="" />
					</div>
				</div>
			</div>
		</div>
		<div class="form-group">
			<div class="row">
				<div class="col-sm-12">
					<label for="phoneNumber" class="control-label col-sm-5 col-lg-5">
						<s:text name="phoneNumber" /><span class="required"> * </span>
					</label>
					<div class="col-sm-7 col-lg-6">
						<s:textfield name="phoneNumber" cssClass="form-control"
							id="phoneNumber" autofocus="" />
					</div>
				</div>
			</div>
		</div>
		<div class="form-group">
			<div class="row">
				<div class="col-sm-12">
					<label for="regNumber" class="control-label col-sm-5 col-lg-5">
						<s:text name="regNumber" /><span class="required"> * </span>
					</label>
					<div class="col-sm-7 col-lg-6">
						<s:textfield name="regNumber" cssClass="form-control"
							id="regNumber" autofocus="" />
					</div>
				</div>
			</div>
		</div>
		<div class="form-group">
			<div class="row">
				<div class="col-sm-12" id="usersSelectList">
					<label for="user" class="control-label col-sm-5 col-lg-5">
						<s:text name="user" /><span class="required"> * </span>
					</label>
					<div class="col-sm-7 col-lg-6">
						<s:select list="usersList" listKey="id" listValue="userName" headerKey="" headerValue="" cssClass="form-control"
							name="userStr" autoficus="" id="user"></s:select>
					</div>
				</div>
			</div>
		</div>
		<div class="form-group">
			<div class="row">
				<div class="col-sm-12">
					<label for="status" class="control-label col-sm-5 col-lg-5">
						<s:text name="status" /><span class="required"> * </span>
					</label>
					<div class="col-sm-7 col-lg-6">
						<s:select list="employeeStatuses" listKey="id" listValue="status" cssClass="form-control"
							name="statusStr" autoficus="" id="status"></s:select>
					</div>
				</div>
			</div>
		</div>
		<input type="submit" id="submitOk" class="hide" />
	</s:form>
</div>
<div id="parseResult" class=hidden></div>
<div id="context" class="hide">${pageContext.request.contextPath}
</div>
<script src="../js/PageJS/employee.js"></script>