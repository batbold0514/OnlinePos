<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="display" uri="http://displaytag.sf.net"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div class="row">
	<div class="col-sm-12">
		<h3 class="page-title">
			<s:text name="company" />
		</h3>
	</div>
	<p class="active_menu hide">company</p>
	<div class="portlet box blue">
		<div class="portlet-title">
			<div class="caption">
				<i class="fa fa-home"> <s:text name="company" /></i>
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
				<display:table name="companyList" id="companytable"
					class="display table-bordered table-hoverdataTable">
					<display:column property="id" title="" />
					<display:column property="compName" title="Салбарын нэр" />
					<display:column property="address" title="Хаяг" />
					<display:column property="phoneNumber" title="Утас" />
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
					<label for="compName" class="control-label col-sm-5 col-lg-5">
						<s:text name="compName" />
					</label>
					<div class="col-sm-7 col-lg-6">
						<s:textfield name="compName" cssClass="form-control" autofocus=""
							disabled="true" />
					</div>
				</div>
			</div>
		</div>
		<div class="form-group">
			<div class="row">
				<div class="col-sm-12">
					<label for="address" class="control-label col-sm-5 col-lg-5">
						<s:text name="address" />
					</label>
					<div class="col-sm-7 col-lg-6">
						<s:textfield name="address" cssClass="form-control" autofocus=""
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
	</div>
</div>
<div id="dialog-addnew" class="hide">
	<s:form action="" cssClass="form-horizontal" id="addForm">
		<s:hidden name="id" />
		<div class="form-group">
			<div class="row">
				<div class="col-sm-12">
					<label for="compName" class="control-label col-sm-5 col-lg-5">
						<s:text name="compName" />
					</label>
					<div class="col-sm-7 col-lg-6">
						<s:textfield name="compName" cssClass="form-control" autofocus="" />
					</div>
				</div>
			</div>
		</div>
		<div class="form-group">
			<div class="row">
				<div class="col-sm-12">
					<label for="address" class="control-label col-sm-5 col-lg-5">
						<s:text name="address" />
					</label>
					<div class="col-sm-7 col-lg-6">
						<s:textfield name="address" cssClass="form-control" autofocus="" />
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
							autofocus="" />
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
<script src="../js/PageJS/company.js"></script>