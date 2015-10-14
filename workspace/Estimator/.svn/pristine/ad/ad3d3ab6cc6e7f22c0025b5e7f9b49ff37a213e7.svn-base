<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="display" uri="http://displaytag.sf.net"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div class="row">
	<div class="col-sm-12">
		<h3 class="page-title">
			<s:text name="users" />
		</h3>
	</div>
	<p class = "active_menu hide">userList</p>
	<div class="portlet box blue">
		<div class="portlet-title">
			<div class="caption">
				<i class="fa fa-user"> <s:text name="users" /></i>
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
				<display:table name="usersList" id="sampletable2"
					class="display table-bordered table-hoverdataTable">
					<display:column property="userName" title="Хэрэглэгчийн нэр" />
					<c:forEach items="${sampletable2.role}" var="role">
						<display:column value="${role.role}" title="Хэрэглэгчийн эрх" />
					</c:forEach>
					<display:column property="id" title="ID" />
					<display:column property="code" title="Хэрэглэгчийн код" />
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
					<label for="userName" class="control-label col-sm-5 col-lg-5">
						<s:text name="userName" />
					</label>
					<div class="col-sm-7 col-lg-6">
						<s:textfield name="userName" cssClass="form-control" autofocus=""
							disabled="true" />
					</div>
				</div>
			</div>
		</div>
		<div class="form-group">
			<div class="row">
				<div class="col-sm-12">
					<label for="roleString" class="control-label col-sm-5 col-lg-5">
						<s:text name="roleString" />
					</label>
					<div class="col-sm-7 col-lg-6">
						<s:select name="roleString" list="{'','admin-role','user-role'}"
							cssClass="form-control" disabled="true" />
					</div>
				</div>
			</div>
		</div>
		<div class="form-group">
			<div class="row">
				<div class="col-sm-12">
					<label for="code" class="control-label col-sm-5 col-lg-5">
						<s:text name="code" />
					</label>
					<div class="col-sm-7 col-lg-6">
						<s:textfield name="code" cssClass="form-control" autofocus=""
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
					<label for="userName" class="control-label col-sm-5 col-lg-5">
						<s:text name="userName" /><span class="required"> * </span>
					</label>
					<div class="col-sm-7 col-lg-6">
						<s:textfield name="userName" cssClass="form-control"
							id="userNameAdd" autofocus="" />
					</div>
				</div>
			</div>
		</div>
		<div class="form-group">
			<div class="row">
				<div class="col-sm-12">
					<label for="code" class="control-label col-sm-5 col-lg-5">
						<s:text name="code"></s:text><span class="required"> * </span>
					</label>
					<div class="col-sm-7 col-lg-6">
						<s:textfield name="code" cssClass="form-control" id="codeAdd"></s:textfield>
					</div>
				</div>
			</div>
		</div>
		<div class="form-group">
			<div class="row">
				<div class="col-sm-12">
					<label for="roleString" class="control-label col-sm-5 col-lg-5">
						<s:text name="roleString" /><span class="required"> * </span>
					</label>
					<div class="col-sm-7 col-lg-6">
						<s:select key="roleString" headerKey="" headerValue=""
							list="roles" listKey="role" listValue="role"
							cssClass="form-control" id="roleStringAdd" />
					</div>
				</div>
			</div>
		</div>
		<div class="form-group">
			<div class="row">
				<div class="col-sm-12">
					<label for="pwd" class="control-label col-sm-5 col-lg-5"> <s:text
							name="pwd" /><span class="required"> * </span>
					</label>
					<div class="col-sm-7 col-lg-6">
						<s:password key="pwd" requiredLabel="true" cssClass="form-control" />
					</div>
				</div>
			</div>
		</div>
		<div class="form-group">
			<div class="row">
				<div class="col-sm-12">
					<label for="confirmPwd" class="control-label col-sm-5 col-lg-5">
						<s:text name="confirmPwd" /><span class="required"> * </span>
					</label>
					<div class="col-sm-7 col-lg-6">
						<s:password key="confirmPwd" requiredLabel="true"
							cssClass="form-control" />
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
<script src="../js/PageJS/userList.js">
</script>
