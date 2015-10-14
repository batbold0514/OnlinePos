<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="display" uri="http://displaytag.sf.net"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="hidden" id="page">
	<s:url action="usersList" includeParams="none" />
</div>
<div class="page-content">
	<div class="page-header">
		<h2>
			<s:text name="userList" />
			<small> <i class="icon-double-angle-right"></i> Жагсаалт
			</small>
		</h2>
	</div>
	<div class="row">
		<div class="col-xs-12">
			<div class="table-responsive" id="list-result">
				<display:table name="usersList" id="sampletable2"
					class="table table-striped table-bordered table-hover">
					<display:column property="userName" title="Хэрэглэгчийн нэр" />
					<c:forEach items="${sampletable2.role}" var="role">
						<display:column value="${role.role}" title="Хэрэглэгчийн эрх" />
					</c:forEach>
					<display:column property="id" title="ID" />
				</display:table>
			</div>
		</div>
	</div>
</div>
<div id="dialog-show" class="hide">
	<div class="form-group">
		<div class="row">
			<div class="col-sm-12">
				<label for="userName" class="control-label col-sm-5 col-lg-5">
					<s:text name="userName" />(*):
				</label>
				<div class="col-sm-7 col-lg-6">
					<s:textfield name="userName" cssClass="form-control" id="userName"
						autofocus="" disabled="true" />
				</div>
			</div>
		</div>
	</div>
	<div class="form-group">
		<div class="row">
			<div class="col-sm-12">
				<label for="roleString" class="control-label col-sm-5 col-lg-5">
					<s:text name="roleString" />(*):
				</label>
				<div class="col-sm-7 col-lg-6">
					<s:select key="roleString" list="{'','admin-role','user-role'}"
						cssClass="form-control" disabled="true" />
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
						<s:text name="userName" />(*):
					</label>
					<div class="col-sm-7 col-lg-6">
						<s:textfield name="userName" cssClass="form-control" id="userName"
							autofocus="" />
					</div>
				</div>
			</div>
			<div class="row">
				<div class="col-sm-offset-4 col-sm-7 col-lg-offset-3 col-lg-6"
					id="erroruserNameResult">
					<s:fielderror fieldName="userName" />
				</div>
			</div>
		</div>
		<div class="form-group">
			<div class="row">
				<div class="col-sm-12">
					<label for="roleString" class="control-label col-sm-5 col-lg-5">
						<s:text name="roleString" />(*):
					</label>
					<div class="col-sm-7 col-lg-6">
						<s:select key="roleString" headerKey="" headerValue=""
							list="roles" listKey="role" listValue="role"
							cssClass="form-control" />
					</div>
				</div>
			</div>
			<div class="row">
				<div class="col-sm-offset-4 col-sm-7 col-lg-offset-4 col-lg-6"
					id="errorroleStringResult">
					<s:fielderror fieldName="roleString" />
				</div>
			</div>
		</div>
		<div class="form-group">
			<div class="row">
				<div class="col-sm-12">
					<label for="pwd" class="control-label col-sm-5 col-lg-5"> <s:text
							name="pwd" />(*):
					</label>
					<div class="col-sm-7 col-lg-6">
						<s:password key="pwd" requiredLabel="true" cssClass="form-control" />
					</div>
				</div>
			</div>
			<div class="row">
				<div class="col-sm-offset-4 col-sm-7 col-lg-offset-4 col-lg-6"
					id="errorpwdResult">
					<s:fielderror fieldName="pwd" />
				</div>
			</div>
		</div>
		<div class="form-group">
			<div class="row">
				<div class="col-sm-12">
					<label for="confirmPwd" class="control-label col-sm-5 col-lg-5">
						<s:text name="confirmPwd" />(*):
					</label>
					<div class="col-sm-7 col-lg-6">
						<s:password key="confirmPwd" requiredLabel="true"
							cssClass="form-control" />
					</div>
				</div>
			</div>
			<div class="row">
				<div class="col-sm-offset-4 col-sm-7 col-lg-offset-4 col-lg-6"
					id="errorconfirmPwdResult">
					<s:fielderror fieldName="confirmPwd" />
				</div>
			</div>
		</div>
	</s:form>
</div>
<div id="parseResult" class=hidden></div>
<div id="context" class="hide">${pageContext.request.contextPath}
</div>
<script src="../js/PageJS/userList.js"></script>