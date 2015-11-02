<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="display" uri="http://displaytag.sf.net"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<div class="row">
	<div class="col-md-12">
		<h3 class="page-title">
			<s:text name="debtType" />
		</h3>
	</div>
	<div class="portlet box blue">
		<div class="portlet-title">
			<div class="caption">
				<i class="fa fa-tags"> <s:text name="debtType" /></i>
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
				<display:table name="listOfDebtType" id="debtTypeTable"
					class="display table-hover table-bordered">
					<display:column property="id" title="ID" />
					<display:column property="typeName" title="Нэр" />
					<display:column property="description" title="Тайлбар" />
					<display:column property="typeNumber" title="Код" />
					<display:column property="debtTypeIndex" title="Индекс" />
					<display:column property="status.description" title="Төлөв" />
					<display:column property="status.id" title="Төлөв" />
				</display:table>
			</div>
		</div>
	</div>
</div>
<div id="dialog-show" class="hide">
	<form action="#">
		<div class="form-body">
			<s:hidden key="id" />
			<div class="form-group">
				<div class="row">
					<div class="col-sm-12">
						<label for="typeName" class="control-label col-sm-5 col-lg-5">
							<s:text name="typeName" />
						</label>
						<div class="col-sm-7 col-lg-6">
							<s:textfield name="typeName" cssClass="form-control"
								id="typeName" autofocus="" disabled="true" />
						</div>
					</div>
				</div>
			</div>
			<div class="form-group">
				<div class="row">
					<div class="col-sm-12">
						<label for="typeNumber" class="control-label col-sm-5 col-lg-5">
							<s:text name="typeNumber" />
						</label>
						<div class="col-sm-7 col-lg-6">
							<s:textfield name="typeNumber" cssClass="form-control"
								id="typeNumber" autofocus="" disabled="true" />
						</div>
					</div>
				</div>
			</div>
			<div class="form-group">
				<div class="row">
					<div class="col-sm-12">
						<label for="description" class="control-label col-sm-5 col-lg-5">
							<s:text name="description" />
						</label>
						<div class="col-sm-7 col-lg-6">
							<s:textfield name="description" cssClass="form-control"
								id="description" autofocus="" disabled="true" />
						</div>
					</div>
				</div>
			</div>
			<div class="form-group">
				<div class="row">
					<div class="col-sm-12">
						<label for="debtTypeIndex" class="control-label col-sm-5 col-lg-5">
							<s:text name="debtTypeIndex" />
						</label>
						<div class="col-sm-7 col-lg-6">
							<s:textfield name="debtTypeIndex" cssClass="form-control"
								autofocus="" disabled="true" />
						</div>
					</div>
				</div>
			</div>
			<div class="form-group">
				<div class="row">
					<div class="col-sm-12">
						<label for="debtTypeIndex" class="control-label col-sm-5 col-lg-5">
							<s:text name="status" />
						</label>
						<div class="col-sm-7 col-lg-6">
							<s:textfield name="status" cssClass="form-control"
								autofocus="" disabled="true" />
						</div>
					</div>
				</div>
			</div>
		</div>
	</form>
</div>
<div id="dialog-addnew" class="hide">
	<form action="#" id="addform">
		<div class="form-body">
			<s:hidden key="id" />
			<div class="form-group">
				<div class="row">
					<div class="col-sm-12">
						<label for="typeName" class="control-label col-sm-5 col-lg-5">
							<s:text name="typeName" /><span class="required"> * </span>
						</label>
						<div class="col-sm-7 col-lg-6">
							<s:textfield name="typeName" cssClass="form-control" autofocus=""
								id="typeName2" />
						</div>
					</div>
				</div>
			</div>
			<div class="form-group">
				<div class="row">
					<div class="col-sm-12">
						<label for="typeNumber" class="control-label col-sm-5 col-lg-5">
							<s:text name="typeNumber" /><span class="required"> * </span>
						</label>
						<div class="col-sm-7 col-lg-6">
							<s:textfield name="typeNumber" cssClass="form-control"
								autofocus="" />
						</div>
					</div>
				</div>
			</div>
			<div class="form-group">
				<div class="row">
					<div class="col-sm-12">
						<label for="description" class="control-label col-sm-5 col-lg-5">
							<s:text name="description" /><span class="required"> * </span>
						</label>
						<div class="col-sm-7 col-lg-6">
							<s:textfield name="description" cssClass="form-control"
								autofocus="" />
						</div>
					</div>
				</div>
			</div>
			<div class="form-group">
				<div class="row">
					<div class="col-sm-12">
						<label for="debtTypeIndex" class="control-label col-sm-5 col-lg-5">
							<s:text name="debtTypeIndex" /><span class="required"> *
						</span>
						</label>
						<div class="col-sm-7 col-lg-6">
							<s:textfield name="debtTypeIndex" cssClass="form-control"
								autofocus="" />
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
							<s:select list="statuses" name="statusString" listKey="id"
								listValue="description" cssClass="form-control"></s:select>
						</div>
					</div>
				</div>
			</div>
		</div>
		<input type="submit" id="submitOk" class="hide" />
	</form>
</div>
<div id='parseResult' class="hidden"></div>
<script src="../js/PageJS/debtTypeList.js"></script>