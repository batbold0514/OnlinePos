<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="display" uri="http://displaytag.sf.net"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="hidden" id="page">
	<s:url action="doctors" includeParams="none" />
</div>
<div class="page-content">
	<div class="page-header">
		<h2>
			<s:text name="listDoctor" />
			<small> <i class="icon-double-angle-right"></i> Жагсаалт
			</small>
		</h2>
	</div>
	<div class="row">
		<div class="col-xs-12">
			<div class="table-responsive" id="list-result">
				<display:table name="doctorList" id="example"
					class="table table-striped table-bordered table-hover">
					<display:column property="id" />
					<display:column property="registrationNumber" title="Регистр №"
						sortable="true" />
					<display:column property="familyName" title="Овог" sortable="true" />
					<display:column property="name" title="Нэр" sortable="true" />
					<display:column property="mobile1" title="Гар утас 1"
						sortable="true" />
					<display:column property="mobile2" title="Гар утас 2"
						sortable="true" />
					<display:column property="phoneNumber" title="Утас" sortable="true" />
					<display:column property="status" title="Статус" sortable="true" />
					<display:column property="doctorUser.userName"
						title="Хэрэглэгчийн нэр" sortable="true" />
				</display:table>
			</div>
		</div>
	</div>
</div>

<div id="dialog-show" class="hide">
	<div class="form-group">
		<div class="row">
			<div class="col-sm-12">
				<label for="registrationNumber"
					class="control-label col-sm-5 col-lg-5"> <s:text
						name="registrationNumber" />(*):
				</label>
				<div class="col-sm-7 col-lg-6">
					<s:textfield name="registrationNumber" cssClass="form-control"
						id="registrationNumber" autofocus="" disabled="true" />
				</div>
			</div>
		</div>
	</div>
	<div class="form-group">
		<div class="row">
			<div class="col-sm-12">
				<label for="familyName" class="control-label col-sm-5 col-lg-5">
					<s:text name="familyName" />(*):
				</label>
				<div class="col-sm-7 col-lg-6">
					<s:textfield name="familyName" cssClass="form-control"
						id="familyName" autofocus="" disabled="true" />
				</div>
			</div>
		</div>
	</div>
	<div class="form-group">
		<div class="row">
			<div class="col-sm-12">
				<label for="name" class="control-label col-sm-5 col-lg-5"> <s:text
						name="name" />(*):
				</label>
				<div class="col-sm-7 col-lg-6">
					<s:textfield name="name" cssClass="form-control" id="name"
						autofocus="" disabled="true" />
				</div>
			</div>
		</div>
	</div>
	<div class="form-group">
		<div class="row">
			<div class="col-sm-12">
				<label for="mobile1" class="control-label col-sm-5 col-lg-5">
					<s:text name="mobile1" />(*):
				</label>
				<div class="col-sm-7 col-lg-6">
					<s:textfield name="mobile1" cssClass="form-control" id="mobile1"
						autofocus="" disabled="true" />
				</div>
			</div>
		</div>
	</div>
	<div class="form-group">
		<div class="row">
			<div class="col-sm-12">
				<label for="mobile2" class="control-label col-sm-5 col-lg-5">
					<s:text name="mobile2" />(*):
				</label>
				<div class="col-sm-7 col-lg-6">
					<s:textfield name="mobile2" cssClass="form-control" id="mobile2"
						autofocus="" disabled="true" />
				</div>
			</div>
		</div>
	</div>
	<div class="form-group">
		<div class="row">
			<div class="col-sm-12">
				<label for="phoneNumber" class="control-label col-sm-5 col-lg-5">
					<s:text name="phoneNumber" />(*):
				</label>
				<div class="col-sm-7 col-lg-6">
					<s:textfield name="phoneNumber" cssClass="form-control"
						id="phoneNumber" autofocus="" disabled="true" />
				</div>
			</div>
		</div>
	</div>
	<div class="form-group">
		<div class="row">
			<div class="col-sm-12">
				<label for="status" class="control-label col-sm-5 col-lg-5">
					<s:text name="status" />(*):
				</label>
				<div class="col-sm-7 col-lg-6" >
					<s:select key="status" list="statuss"
						listValue="%{getText(toString())}"
						headerValue="%getText('choseValue')}" cssClass="form-control"
						disabled="true" />
				</div>
			</div>
		</div>
	</div>
	<div class="form-group">
		<div class="row">
			<div class="col-sm-12">
				<label for="doctorUserString"
					class="control-label col-sm-5 col-lg-5"> <s:text
						name="doctorUserString" />(*):
				</label>
				<div class="col-sm-7 col-lg-6">
					<s:textfield name="doctorUserString" cssClass="form-control"
						id="doctorUserString" autofocus="" disabled="true" />
				</div>
			</div>
		</div>
	</div>
</div>
<div id="dialog-addnew" class="hide">
	<s:form action="userSave" cssClass="form-horizontal" id="addForm">
		<s:hidden name="id" />
		<s:hidden key = "doctorUserStringHid"/>
		<div class="form-group">
			<div class="row">
				<div class="col-sm-12">
					<label for="registrationNumber"
						class="control-label col-sm-5 col-lg-5"> <s:text
							name="registrationNumber" />(*):
					</label>
					<div class="col-sm-7 col-lg-6">
						<s:textfield name="registrationNumber" cssClass="form-control"
							id="registrationNumber" autofocus="" />
					</div>
				</div>
			</div>
			<div class="row">
				<div class="col-sm-offset-4 col-sm-7 col-lg-offset-3 col-lg-6"
					id="errorRegistrationNumberResult">
					<s:fielderror fieldName="registrationNumber" />
				</div>
			</div>
		</div>
		<div class="form-group">
			<div class="row">
				<div class="col-sm-12">
					<label for="familyName" class="control-label col-sm-5 col-lg-5">
						<s:text name="familyName" />(*):
					</label>
					<div class="col-sm-7 col-lg-6">
						<s:textfield name="familyName" cssClass="form-control"
							id="familyName" autofocus="" />
					</div>
				</div>
			</div>
			<div class="row">
				<div class="col-sm-offset-4 col-sm-7 col-lg-offset-3 col-lg-6"
					id="errorFamilyNameResult">
					<s:fielderror fieldName="familyName" />
				</div>
			</div>
		</div>
		<div class="form-group">
			<div class="row">
				<div class="col-sm-12">
					<label for="name" class="control-label col-sm-5 col-lg-5">
						<s:text name="name" />(*):
					</label>
					<div class="col-sm-7 col-lg-6">
						<s:textfield name="name" cssClass="form-control" id="name"
							autofocus="" />
					</div>
				</div>
			</div>
			<div class="row">
				<div class="col-sm-offset-4 col-sm-7 col-lg-offset-3 col-lg-6"
					id="errorNameResult">
					<s:fielderror fieldName="name" />
				</div>
			</div>
		</div>
		<div class="form-group">
			<div class="row">
				<div class="col-sm-12">
					<label for="mobile1" class="control-label col-sm-5 col-lg-5">
						<s:text name="mobile1" />(*):
					</label>
					<div class="col-sm-7 col-lg-6">
						<s:textfield name="mobile1" cssClass="form-control" id="mobile1"
							autofocus="" />
					</div>
				</div>
			</div>
			<div class="row">
				<div class="col-sm-offset-4 col-sm-7 col-lg-offset-3 col-lg-6"
					id="errorMobile1Result">
					<s:fielderror fieldName="mobile1" />
				</div>
			</div>
		</div>
		<div class="form-group">
			<div class="row">
				<div class="col-sm-12">
					<label for="mobile2" class="control-label col-sm-5 col-lg-5">
						<s:text name="mobile2" />(*):
					</label>
					<div class="col-sm-7 col-lg-6">
						<s:textfield name="mobile2" cssClass="form-control" id="mobile2"
							autofocus="" />
					</div>
				</div>
			</div>
			<div class="row">
				<div class="col-sm-offset-4 col-sm-7 col-lg-offset-3 col-lg-6"
					id="errorMobile2Result">
					<s:fielderror fieldName="mobile2" />
				</div>
			</div>
		</div>
		<div class="form-group">
			<div class="row">
				<div class="col-sm-12">
					<label for="phoneNumber" class="control-label col-sm-5 col-lg-5">
						<s:text name="phoneNumber" />(*):
					</label>
					<div class="col-sm-7 col-lg-6">
						<s:textfield name="phoneNumber" cssClass="form-control"
							id="phoneNumber" autofocus="" />
					</div>
				</div>
			</div>
			<div class="row">
				<div class="col-sm-offset-4 col-sm-7 col-lg-offset-3 col-lg-6"
					id="errorPhoneNumberResult">
					<s:fielderror fieldName="phoneNumber" />
				</div>
			</div>
		</div>
		<div class="form-group">
			<div class="row">
				<div class="col-sm-12">
					<label for="status" class="control-label col-sm-5 col-lg-5">
						<s:text name="status" />(*):
					</label>
					<div class="col-sm-7 col-lg-6">
						<s:select key="status" list="statuss"
							listValue="%{getText(toString())}"
							headerValue="%getText('choseValue')}" cssClass="form-control" />
					</div>
				</div>
			</div>
			<div class="row">
				<div class="col-sm-offset-4 col-sm-7 col-lg-offset-3 col-lg-6"
					id="errorStatusResult">
					<s:fielderror fieldName="status" />
				</div>
			</div>
		</div>
		<div class="form-group">
			<div class="row">
				<div class="col-sm-12">
					<label for="doctorUserString"
						class="control-label col-sm-5 col-lg-5"> <s:text
							name="doctorUserString" />(*):
					</label>
					<div class="col-sm-7 col-lg-6" id = "doctor-list">
						<s:select key="doctorUserString" list="usersList"
							listValue="userName" listKey="id"
							headerValue="" headerKey=""
							cssClass="form-control" />
					</div>
				</div>
			</div>
			<div class="row">
				<div class="col-sm-offset-4 col-sm-7 col-lg-offset-3 col-lg-6"
					id="errordoctorUserStringResult">
					<s:fielderror fieldName="doctorUserString" />
				</div>
			</div>
		</div>
	</s:form>
</div>

<div id="parseResult" class="hide"></div>
<div id="context" class="hide">${pageContext.request.contextPath}
</div>
<script src="../js/PageJS/doctorList.js"></script>