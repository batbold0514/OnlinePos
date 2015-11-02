<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="display" uri="http://displaytag.sf.net"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div class="row">
	<div class="col-sm-12">
		<h3 class="page-title">
			<s:text name="customer" />
		</h3>
	</div>
	<p class = "active_menu hide">customer</p>
	<div class="portlet box blue">
		<div class="portlet-title">
			<div class="caption">
				<i class="fa fa-user"> <s:text name="customer" /></i>
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
				<display:table name="listOfCustomer" id="customerID"
					class="display table-bordered table-hoverdataTable">
					<display:column property="id" title="ID" />
					<display:column property="enquireName" title="Үйлчлүүлэгчийн нэр" />
					<display:column property="phone" title="Утас" />
					<display:column property="user.userName" title="Нэвтрэх эрх" />
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
					<label for="enquireName" class="control-label col-sm-5 col-lg-5">
						<s:text name="enquireName" /><span class="required"> * </span>
					</label>
					<div class="col-sm-7 col-lg-6">
						<s:textfield name="enquireName" cssClass="form-control"
							 autofocus="" disabled="true"/>
					</div>
				</div>
			</div>
		</div>
		<div class="form-group">
			<div class="row">
				<div class="col-sm-12">
					<label for="phone" class="control-label col-sm-5 col-lg-5">
						<s:text name="phone" /><span class="required"> * </span>
					</label>
					<div class="col-sm-7 col-lg-6">
						<s:textfield name="phone" cssClass="form-control"
							id="phone" autofocus="" disabled="true"/>
					</div>
				</div>
			</div>
		</div>
		<div class="form-group">
			<div class="row">
				<div class="col-sm-12">
					<label for="users" class="control-label col-sm-5 col-lg-5">
						<s:text name="users" /><span class="required"> * </span>
					</label>
					<div class="col-sm-7 col-lg-6"> 
						<s:select name="usersString" list="users" listKey="userName" listValue="userName" cssClass="form-control"
							id="usersString" autofocus="" disabled="true"/>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>
<div id="dialog-addnew" class="hide">
	<s:form action="" cssClass="form-horizontal" id="addForm">
		<s:hidden name="id" />
		<div class="form-group">
			<div class="row">
				<div class="col-sm-12">
					<label for="enquireName" class="control-label col-sm-5 col-lg-5">
						<s:text name="enquireName" /><span class="required"> * </span>
					</label>
					<div class="col-sm-7 col-lg-6">
						<s:textfield name="enquireName" cssClass="form-control"
							id="enquireName" autofocus="" />
					</div>
				</div>
			</div>
		</div>
		<div class="form-group">
			<div class="row">
				<div class="col-sm-12">
					<label for="phone" class="control-label col-sm-5 col-lg-5">
						<s:text name="phone" /><span class="required"> * </span>
					</label>
					<div class="col-sm-7 col-lg-6">
						<s:textfield name="phone" cssClass="form-control"
							id="phone" autofocus="" />
					</div>
				</div>
			</div>
		</div>
		<div class="form-group">
			<div class="row">
				<div class="col-sm-12">
					<label for="users" class="control-label col-sm-5 col-lg-5">
						<s:text name="users" /><span class="required"> * </span>
					</label>
					<div class="col-sm-7 col-lg-6"> 
						<s:select name="usersString" list="users" listKey="userName" listValue="userName" cssClass="form-control" headerKey="" headerValue=""
							id="usersString" autofocus="" />
					</div>
				</div>
			</div>
			<div class = "row">
				<div class="col-sm-12"
					id="enquiretypeStringResult">
					<s:fielderror fieldName="enquiretypeString" />
				</div>
			</div>
		</div>
		<input type="submit" id="submitOk" class="hide" />
	</s:form>
</div>

<div id="parseResult" class=hidden></div>
<div id="context" class="hide">${pageContext.request.contextPath}
</div>
<script src="../js/PageJS/customerList.js">
</script>