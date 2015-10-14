<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sx" uri="/struts-dojo-tags"%>
<%@ taglib prefix="display" uri="http://displaytag.sf.net"%>
<div class="hidden" id="page">
	<s:url action="employeeList" includeParams="none"/>
</div>
<div class="page-content">
	<div class="page-header">
		<sx:head />
		<h2>
			<s:text name="listEmployee" />
			<small> <i class="icon-double-angle-right"></i> Жагсаалт
			</small>
		</h2>
	</div>
	<div class="row">
		<div class="col-xs-12">
			<div class="table-responsive" id="list-result">
				<display:table name="empList"
					class="table table-striped table-bordered table-hover" id="example">
					<display:column property="id" title="ID" sortable="true" />
					<display:column property="lastName" title="Овог" sortable="true" />
					<display:column property="firstName" title="Нэр" sortable="true" />
					<display:column property="code" title="Ажилчны код" sortable="true" />
					<display:column property="regNumber" title="Регистр №"
						sortable="true" />
					<display:column property="position.name" title="Ажил/Мэргэжил"
						sortable="true" />
					<display:column property="birthday" title="Төрсөн өдөр"
						sortable="true" />
					<display:column property="phone" title="Утас" sortable="true" />
					<display:column property="email" title="Емайл" sortable="true" />
					<display:column property="status.label" title="Төлөв"
						sortable="true" />
					<display:column property="empUser.userName" title="Нэвтрэх нэр"
						sortable="true" />
					<display:column property="position.id" />
					<display:column property="empUser.id" />
				</display:table>
			</div>
		</div>
	</div>
</div>
<div id="parseResult" class="hidden"></div>
<div id="dialog-show" class="hide">
	<div class="form-group">
		<div class="row">
			<s:hidden key="id" />
			<div class="col-sm-12">
				<label for="lastName" class="control-label col-sm-5 col-lg-5">
					<s:text name="lastName" />
				</label>
				<div class="col-sm-7 col-lg-6">
					<s:textfield name="lastName" cssClass="form-control" id="lastName"
						autofocus="" disabled="true" />
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
					<s:textfield name="firstName" cssClass="form-control"
						id="firstName" autofocus="" disabled="true" />
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
					<s:textfield name="code" cssClass="form-control"
						id="code" autofocus="" disabled="true" />
				</div>
			</div>
		</div>
	</div>
	<div class="form-group">
		<div class="row">
			<div class="col-sm-12">
				<label for="regNumber" class="control-label col-sm-5 col-lg-5">
					<s:text name="regNumber" />
				</label>
				<div class="col-sm-7 col-lg-6">
					<s:textfield name="regNumber" cssClass="form-control"
						id="regNumber" autofocus="" disabled="true" />
				</div>
			</div>
		</div>
	</div>
	<div class="form-group">
		<div class="row">
			<div class="col-sm-12">
				<label for="positionString" class="control-label col-sm-5 col-lg-5">
					<s:text name="positionString" />
				</label>
				<div class="col-sm-7 col-lg-6">
					<s:textfield name="postion.name" cssClass="form-control"
						id="postion" autofocus="" disabled="true" />
				</div>
			</div>
		</div>
	</div>
	<div class="form-group">
		<div class="row">
			<div class="col-sm-12">
				<label for="birthday" class="control-label col-sm-5 col-lg-5">
					<s:text name="birthday" />
				</label>
				<div class="col-sm-7 col-lg-6">
					<s:textfield name="birthday" cssClass="form-control" id="birthday"
						autofocus="" disabled="true" />
				</div>
			</div>
		</div>
	</div>
	<div class="form-group">
		<div class="row">
			<div class="col-sm-12">
				<label for="phone" class="control-label col-sm-5 col-lg-5">
					<s:text name="phone" />
				</label>
				<div class="col-sm-7 col-lg-6">
					<s:textfield name="phone" cssClass="form-control" id="phone"
						autofocus="" disabled="true" />
				</div>
			</div>
		</div>
	</div>
	<div class="form-group">
		<div class="row">
			<div class="col-sm-12">
				<label for="email" class="control-label col-sm-5 col-lg-5">
					<s:text name="email" />
				</label>
				<div class="col-sm-7 col-lg-6">
					<s:textfield name="email" cssClass="form-control" id="email"
						autofocus="" disabled="true" />
				</div>
			</div>
		</div>
	</div>
	<div class="form-group">
		<div class="row">
			<div class="col-sm-12">
				<label for="status" class="control-label col-sm-5 col-lg-5">
					<s:text name="status" />
				</label>
				<div class="col-sm-7 col-lg-6">
					<s:textfield name="status.label" cssClass="form-control"
						id="status" autofocus="" disabled="true" />
				</div>
			</div>
		</div>
	</div>
	<div class="form-group">
		<div class="row">
			<div class="col-sm-12">
				<label for="empUser.userName"
					class="control-label col-sm-5 col-lg-5"> <s:text
						name="empUser.userName" />
				</label>
				<div class="col-sm-7 col-lg-6">
					<s:textfield name="empUser.userName" cssClass="form-control"
						id="empUser" autofocus="" disabled="true" />
				</div>
			</div>
		</div>
	</div>
</div>
<div id="dialog-addnew" class="hide">
	<s:form action="saveColour" cssClass="form-horizontal" id="addForm">
		<s:hidden name="id" />
		<div class="form-group">
			<div class="row">
				<div class="col-sm-12">
					<label for="lastName" class="control-label col-sm-5 col-lg-5">
						<s:text name="lastName" />(*):
					</label>
					<div class="col-sm-7 col-lg-6">
						<s:textfield name="lastName" cssClass="form-control" id="lastName"
							autofocus="" />
					</div>
				</div>
			</div>
			<div class="row">
				<div class="col-sm-offset-4 col-sm-7 col-lg-offset-3 col-lg-6"
					id="errorLastNameResult">
					<s:fielderror fieldName="lastName" />
				</div>
			</div>
		</div>
		<div class="form-group">
			<div class="row">
				<div class="col-sm-12">
					<label for="firstName" class="control-label col-sm-5 col-lg-5">
						<s:text name="firstName" />(*):
					</label>
					<div class="col-sm-7 col-lg-6">
						<s:textfield name="firstName" cssClass="form-control"
							id="firstName" autofocus="" />
					</div>
				</div>
			</div>
			<div class="row">
				<div class="col-sm-offset-4 col-sm-7 col-lg-offset-3 col-lg-6"
					id="errorFirstNameResult">
					<s:fielderror fieldName="firstName" />
				</div>
			</div>
		</div>
		<div class="form-group">
			<div class="row">
				<div class="col-sm-12">
					<label for="code" class="control-label col-sm-5 col-lg-5">
						<s:text name="code" />(*):
					</label>
					<div class="col-sm-7 col-lg-6">
						<s:textfield name="code" cssClass="form-control"
							id="code" autofocus="" />
					</div>
				</div>
			</div>
			<div class="row">
				<div class="col-sm-offset-4 col-sm-7 col-lg-offset-3 col-lg-6"
					id="errorCodeResult">
					<s:fielderror fieldName="code" />
				</div>
			</div>
		</div>
		<div class="form-group">
			<div class="row">
				<div class="col-sm-12">
					<label for="regNumber" class="control-label col-sm-5 col-lg-5">
						<s:text name="regNumber" />(*):
					</label>
					<div class="col-sm-7 col-lg-6">
						<s:textfield name="regNumber" cssClass="form-control"
							id="regNumber" autofocus="" />
					</div>
				</div>
			</div>
			<div class="row">
				<div class="col-sm-offset-4 col-sm-7 col-lg-offset-3 col-lg-6"
					id="errorRegNumberResult">
					<s:fielderror fieldName="regNumber" />
				</div>
			</div>
		</div>
		<div class="form-group">
			<div class="row">
				<div class="col-sm-12">
					<label for="positionString" class="control-label col-sm-5 col-lg-5">
						<s:text name="positionString" />(*):
					</label>
					<div class="col-sm-7 col-lg-6">
						<s:select list="positions" key="positionString" listKey="id"
							listValue="name" headerKey="-1" headerValue=""
							requiredLabel="true" id="positionID"/>
					</div>
				</div>
			</div>
			<div class="row">
				<div class="col-sm-offset-4 col-sm-7 col-lg-offset-3 col-lg-6"
					id="errorPositionStringResult">
					<s:fielderror fieldName="positionString" />
				</div>
			</div>
		</div>
		<div class="form-group">
			<div class="row">
				<div class="col-sm-12">
					<label for="birthday" class="control-label col-sm-5 col-lg-5">
						<s:text name="birthday" />
					</label>
					<div class="col-sm-7 col-lg-6">
						<s:textfield name="birthString" cssClass="form-control"
							id="birthday1" />
					</div>
				</div>
			</div>
		</div>
		<div class="form-group">
			<div class="row">
				<div class="col-sm-12">
					<label for="email" class="control-label col-sm-5 col-lg-5">
						<s:text name="email" />
					</label>
					<div class="col-sm-7 col-lg-6">
						<s:textfield name="email" cssClass="form-control" id="email" />
					</div>
				</div>
			</div>
		</div>
		<div class="form-group">
			<div class="row">
				<div class="col-sm-12">
					<label for="phone" class="control-label col-sm-5 col-lg-5">
						<s:text name="phone" />
					</label>
					<div class="col-sm-7 col-lg-6">
						<s:textfield name="phone" cssClass="form-control" id="phone" />
					</div>
				</div>
			</div>
		</div>
		<div class="form-group">
			<div class="row">
				<div class="col-sm-12">
					<label for="empUser.userName"
						class="control-label col-sm-5 col-lg-5"> <s:text
							name="empUser.userName" />
					</label>
					<div class="col-sm-7 col-lg-6">
						<s:select list="empUsers" listKey="id" listValue="userName"
							key="employeeUser" headerKey="-1" headerValue="" id="empUserID" />
					</div>
				</div>
			</div>
		</div>
		<div class="form-group">
		<div class="row">
			<div class="col-sm-12">
				<label for="status" class="control-label col-sm-5 col-lg-5">
					<s:text name="status" />
				</label>
				<div class="col-sm-7 col-lg-6">
					<s:select list="statuses" key="status" listValue="label" />
				</div>
			</div>
		</div>
	</div>
	</s:form>
</div>
<div id="context" class="hide">
  ${pageContext.request.contextPath}
</div>
<script src="../js/PageJS/employeeList.js"></script>