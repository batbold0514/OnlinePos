<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="display" uri="http://displaytag.sf.net"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div class="row">
	<div class="col-sm-12">
		<h3 class="page-title">
			<s:text name="enquireModel" />
		</h3>
	</div>
	<p class = "active_menu hide">enquireModelList</p>
	<div class="portlet box blue">
		<div class="portlet-title">
			<div class="caption">
				<i class="fa fa-user"> <s:text name="enquireModel" /></i>
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
				<display:table name="listOfModel" id="enquireModel"
					class="display table-bordered table-hoverdataTable">
					<display:column property="id" title="ID" />
					<display:column property="enquireNumber" title="Захиалгын дугаар" />
					<display:column property="price" title="Үнэ" format="{0,number,#,##0.00}"/>
					<display:column property="bankName" title="Банкын нэр" />
					<display:column property="bankNumber" title="Банкын дугаар" />
					<display:column property="createDate" title="Огноо" format="{0,date,yyyy-MM-dd}"/>
					<display:column property="enquireType.description" title="Төлөв" />
					<display:column property="customer.enquireName" title="Үйлчлүүлэгч " />
					<display:column property="customer.phone" title="Утас" />
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
						<s:select name="enquireNameString" list="customers" listKey="enquireName" listValue="enquireName" cssClass="form-control"
							 autofocus="" disabled="true"/>
					</div>
				</div>
			</div>
		</div>
		<div class="form-group">
			<div class="row">
				<div class="col-sm-12">
					<label for="enquireNumber" class="control-label col-sm-5 col-lg-5">
						<s:text name="enquireNumber" /><span class="required"> * </span>
					</label>
					<div class="col-sm-7 col-lg-6">
						<s:textfield name="enquireNumber" cssClass="form-control"
							id="enquireNumber" autofocus="" disabled="true"/>
					</div>
				</div>
			</div>
		</div>
		<div class="form-group">
			<div class="row">
				<div class="col-sm-12">
					<label for="enquiretypeString" class="control-label col-sm-5 col-lg-5">
						<s:text name="enquiretype" /><span class="required"> * </span>
					</label>
					<div class="col-sm-7 col-lg-6"> 
						<s:select name="enquiretypeString" list="enquireTypes" listKey="description" listValue="description" cssClass="form-control"
							autofocus="" />
					</div>
				</div>
			</div>
		</div>
		<div class="form-group">
			<div class="row">
				<div class="col-sm-12">
					<label for="priceStr" class="control-label col-sm-5 col-lg-5">
						<s:text name="priceStr" /><span class="required"> * </span>
					</label>
					<div class="col-sm-7 col-lg-6">
						<s:textfield name="priceStr" cssClass="form-control"
							id="priceStr" autofocus="" disabled="true"/>
					</div>
				</div>
			</div>
		</div>
		<div class="form-group">
			<div class="row">
				<div class="col-sm-12">
					<label for="bankName" class="control-label col-sm-5 col-lg-5">
						<s:text name="bankName" /><span class="required"> * </span>
					</label>
					<div class="col-sm-7 col-lg-6">
						<s:textfield name="bankName" cssClass="form-control"
							id="bankNname" autofocus="" disabled="true"/>
					</div>
				</div>
			</div>
		</div>
		<div class="form-group">
			<div class="row">
				<div class="col-sm-12">
					<label for="bankNumber" class="control-label col-sm-5 col-lg-5">
						<s:text name="bankNumber" /><span class="required"> * </span>
					</label>
					<div class="col-sm-7 col-lg-6">
						<s:textfield name="bankNumber" cssClass="form-control"
							id="bankNumber" autofocus=""disabled="true" />
					</div>
				</div>
			</div>
		</div>
		<div class="form-group">
			<div class="row">
				<div class="col-sm-12">
					<label for="itemNameString" class="control-label col-sm-5 col-lg-5">
						<s:text name="itemNameString" /><span class="required"> * </span>
					</label>
					<div class="col-sm-7 col-lg-6"> 
						<s:select name="itemNameString" list="itemNames" listKey="id" listValue="name" cssClass="form-control"
							 autofocus="" headerKey="" headerValue="" multiple=""/>
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
					<label for="enquireName" class="control-label col-sm-5 col-lg-5">
						<s:text name="enquireName" /><span class="required"> * </span>
					</label>
					<div class="col-sm-7 col-lg-6"> 
						<s:select name="enquireNameString" list="customers" listKey="enquireName" listValue="enquireName" cssClass="form-control"
							id="enquireName" autofocus="" headerKey="" headerValue=""/>
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
		<div class="form-group">
			<div class="row">
				<div class="col-sm-12">
					<label for="enquireNumber" class="control-label col-sm-5 col-lg-5">
						<s:text name="enquireNumber" /><span class="required"> * </span>
					</label>
					<div class="col-sm-7 col-lg-6">
						<s:textfield name="enquireNumber" cssClass="form-control"
							id="enquireNumber" autofocus="" />
					</div>
				</div>
			</div>
		</div>
		<div class="form-group">
			<div class="row">
				<div class="col-sm-12">
					<label for="enquiretypeString" class="control-label col-sm-5 col-lg-5">
						<s:text name="enquiretype" /><span class="required"> * </span>
					</label>
					<div class="col-sm-7 col-lg-6"> 
						<s:select name="enquiretypeString" list="enquireTypes" listKey="description" listValue="description" cssClass="form-control"
							id="enquiretypeString" autofocus="" headerKey="" headerValue=""/>
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
		<div class="form-group">
			<div class="row">
				<div class="col-sm-12">
					<label for="price" class="control-label col-sm-5 col-lg-5">
						<s:text name="price" /><span class="required"> * </span>
					</label>
					<div class="col-sm-7 col-lg-6">
						<s:textfield name="priceStr" cssClass="form-control"
							id="price" autofocus="" />
					</div>
				</div>
			</div>
		</div>
		<div class="form-group">
			<div class="row">
				<div class="col-sm-12">
					<label for="bankName" class="control-label col-sm-5 col-lg-5">
						<s:text name="bankName" /><span class="required"> * </span>
					</label>
					<div class="col-sm-7 col-lg-6">
						<s:textfield name="bankName" cssClass="form-control"
							id="bankNname" autofocus="" />
					</div>
				</div>
			</div>
		</div>
		<div class="form-group">
			<div class="row">
				<div class="col-sm-12">
					<label for="bankNumber" class="control-label col-sm-5 col-lg-5">
						<s:text name="bankNumber" /><span class="required"> * </span>
					</label>
					<div class="col-sm-7 col-lg-6">
						<s:textfield name="bankNumber" cssClass="form-control"
							id="bankNumber" autofocus="" />
					</div>
				</div>
			</div>
		</div>
		<div class="form-group">
			<div class="row">
				<div class="col-sm-12">
					<label for="itemNameString" class="control-label col-sm-5 col-lg-5">
						<s:text name="itemNameString" /><span class="required"> * </span>
					</label>
					<div class="col-sm-7 col-lg-6"> 
						<s:select name="itemNameString" list="itemNames" listKey="id" listValue="name" cssClass="form-control select"
							id="itemNameString" autofocus="" headerKey="" headerValue="" multiple="true"/>
					</div>
				</div>
			</div>
			<div class = "row">
				<div class="col-sm-12"
					id="itemNameStringResult">
					<s:fielderror fieldName="itemNameString" />
				</div>
			</div>
		</div>
		<input type="submit" id="submitOk" class="hide" />
	</s:form>
</div>

<div id="parseResult" class=hidden></div>
<div id="context" class="hide">${pageContext.request.contextPath}
</div>
<script src="../js/PageJS/enquireModelList.js">
</script>