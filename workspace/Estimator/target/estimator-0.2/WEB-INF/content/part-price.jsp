<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="display" uri="http://displaytag.sf.net"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div class="row">
	<div class="col-sm-12">
		<h3 class="page-title">
			<s:text name="partPrice" />
		</h3>
	</div>
	<p class="active_menu hide">partPrice</p>
	<div class="portlet box blue">
		<div class="portlet-title">
			<div class="caption">
				<i class="fa fa-home"> <s:text name="partPrice" /></i>
			</div>
			<div class="tools">
				<a href="javascript:;" class="collapse"></a>
			</div>
		</div>
		<div class="portlet-body">
			<div class="table-toolbar col-sm-12">
				<div class="col-sm-8">
					<s:form action="search-partprice" id="searchPartPriceForm">
						<div class="row">
							<label class="control-label col-sm-2 col-lg-1" for="startDate">
								<s:text name="date"></s:text>
							</label>
							<div class="col-sm-4">
								<s:textfield name="startDate" cssClass="dateselect" size="8" />
								<s:textfield name="endDate" cssClass="dateselect" size="8" />
							</div>
							<label class="control-label col-sm-1 col-lg-1" for="date">
								<s:text name="year" />
							</label>
							<div class="col-sm-2">
								<s:textfield name="date1" size="1" value=""/>
								<s:textfield name="date2" size="1" value=""/>
							</div>
							<label class="control-label col-sm-1 col-lg-1"> 
								<s:text name="partName"/>
							</label>
							<div>
								<s:textfield name="partNameSearch" value=""/>
							</div>
						</div>
						<div class="row">
							<label class="control-label col-sm-1 col-lg-1" for="factory">
								<s:text name="factory" />
							</label>
							<div class="col-sm-3 col-lg-3">
								<s:select list="factories" name="factorySearch" listKey="id"
									cssClass="form-control select" listValue="factoryName"
									headerKey="" headerValue="" id="factory"></s:select>
							</div>
							<label class="control-label col-sm-1 col-lg-1" for="mark">
								<s:text name="mark" />
							</label>
							<div class="col-sm-3 col-lg-3" id="markResult">
								<s:select list="marks" name="markSearch" listKey="id"
									listValue="mark" headerKey="" headerValue=""
									cssClass="form-control select"></s:select>
							</div>
						</div>
					</s:form>
				</div>
				<div class="btn-group right col-sm-4 col-md-4 col-lg-4">
					<button class="btn gray" id="btnSearch">
						<s:text name="search" />
						<i class="fa fa-search"></i>
					</button>
					<button class="btn green" id="btnAdd">
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
				<display:table name="partPriceList" id="partPricetable"
					class="display table-bordered table-hoverdataTable">
					<display:column property="id" title="" />
					<display:column property="date" title="Огноо"
						format="{0,date,yyyy-MM-dd hh:mm}" />
					<display:column property="partFactory.factoryName" title="Үйлдвэр" />
					<display:column property="partMark.mark" title="Загвар" />
					<display:column property="factoryDate" title="Үйлд.он" />
					<display:column property="partName" title="Сэлбэгийн нэр" />
					<display:column property="price" title="Үнэ" />
					<display:column property="estimator.firstName"
						title="Үнэлгээ хийсэн" />
					<display:column property="description" title="Тайлбар" />
					<display:column property="partFactory.id" title="" />
					<display:column property="partMark.id" title="" />
					<display:column property="estimator.id" title="" />
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
					<label for="dateStr" class="control-label col-sm-5 col-lg-5">
						<s:text name="date" />
					</label>
					<div class="col-sm-7 col-lg-6">
						<s:textfield name="dateStr" cssClass="form-control dateselect" />
					</div>
				</div>
			</div>
			<div class="row">
				<div class="col-sm-12">
					<label for="factoryStr" class="control-label col-sm-5 col-lg-5">
						<s:text name="factory" />
					</label>
					<div class="col-sm-7 col-lg-6">
						<s:textfield name="factoryStr"></s:textfield>
					</div>
				</div>
			</div>
			<div class="row">
				<div class="col-sm-12">
					<label for="markStr" class="control-label col-sm-5 col-lg-5">
						<s:text name="mark" />
					</label>
					<div class="col-sm-7 col-lg-6">
						<s:textfield name="markStr"></s:textfield>
					</div>
				</div>
			</div>
			<div class="row">
				<div class="col-sm-12">
					<label for="factoryDate" class="control-label col-sm-5 col-lg-5">
						<s:text name="factoryDate" />
					</label>
					<div class="col-sm-7 col-lg-6">
						<s:textfield name="factoryDate" cssClass="form-control" />
					</div>
				</div>
			</div>
			<div class="row">
				<div class="col-sm-12">
					<label for="importedDate" class="control-label col-sm-5 col-lg-5">
						<s:text name="importedDate" />
					</label>
					<div class="col-sm-7 col-lg-6">
						<s:textfield name="importedDate" cssClass="form-control" />
					</div>
				</div>
			</div>
			<div class="row">
				<div class="col-sm-12">
					<label for="vinNumber" class="control-label col-sm-5 col-lg-5">
						<s:text name="vinNumber" />
					</label>
					<div class="col-sm-7 col-lg-6">
						<s:textfield name="vinNumber" cssClass="form-control" />
					</div>
				</div>
			</div>
			<div class="row">
				<div class="col-sm-12">
					<label for="price" class="control-label col-sm-5 col-lg-5">
						<s:text name="price" />
					</label>
					<div class="col-sm-7 col-lg-6">
						<s:textfield name="price" cssClass="form-control" />
					</div>
				</div>
			</div>
			<div class="row">
				<div class="col-sm-12">
					<label for="empStr" class="control-label col-sm-5 col-lg-5">
						<s:text name="estimator" />
					</label>
					<div class="col-sm-7 col-lg-6">
						<s:textfield name="empStr"></s:textfield>
					</div>
				</div>
			</div>
			<div class="row">
				<div class="col-sm-12">
					<label for="description" class="control-label col-sm-5 col-lg-5">
						<s:text name="description" />
					</label>
					<div class="col-sm-7 col-lg-6">
						<s:textfield name="description" cssClass="form-control" />
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
					<label for="dateStr" class="control-label col-sm-5 col-lg-5">
						<s:text name="date" />
					</label>
					<div class="col-sm-7 col-lg-6">
						<s:textfield name="dateStr" cssClass="form-control dateselect" />
					</div>
				</div>
			</div>
			<div class="row">
				<div class="col-sm-12">
					<label for="factoryStr" class="control-label col-sm-5 col-lg-5">
						<s:text name="factory" />
					</label>
					<div class="col-sm-7 col-lg-6">
						<s:select list="factories" name="factoryStr" listKey="id"
							id="factoryDId" listValue="factoryName" headerKey=""
							headerValue="" cssClass="form-control dselect"></s:select>
					</div>
				</div>
			</div>
			<div class="row">
				<div class="col-sm-12">
					<label for="markStr" class="control-label col-sm-5 col-lg-5">
						<s:text name="mark" />
					</label>
					<div class="col-sm-7 col-lg-6" id="carmarkdialog">
						<s:select list="marks" name="markStr" listKey="id"
							listValue="mark" headerKey="" headerValue=""
							cssClass="form-control dselect"></s:select>
					</div>
				</div>
			</div>
			<div class="row">
				<div class="col-sm-12">
					<label for="factoryDate" class="control-label col-sm-5 col-lg-5">
						<s:text name="factoryDate" />
					</label>
					<div class="col-sm-7 col-lg-6">
						<s:textfield name="factoryDate" cssClass="form-control" />
					</div>
				</div>
			</div>
			<div class="row">
				<div class="col-sm-12">
					<label for="partName" class="control-label col-sm-5 col-lg-5">
						<s:text name="partName" />
					</label>
					<div class="col-sm-7 col-lg-6">
						<s:textfield name="partName" cssClass="form-control" />
					</div>
				</div>
			</div>
			<div class="row">
				<div class="col-sm-12">
					<label for="price" class="control-label col-sm-5 col-lg-5">
						<s:text name="price" />
					</label>
					<div class="col-sm-7 col-lg-6">
						<s:textfield name="price" cssClass="form-control" />
					</div>
				</div>
			</div>
			<div class="row">
				<div class="col-sm-12">
					<label for="empStr" class="control-label col-sm-5 col-lg-5">
						<s:text name="estimator" />
					</label>
					<div class="col-sm-7 col-lg-6">
						<s:select list="emps" name="empStr" listKey="id"
							listValue="firstName" headerKey="" headerValue=""
							cssClass="form-control dselect"></s:select>
					</div>
				</div>
			</div>
			<div class="row">
				<div class="col-sm-12">
					<label for="description" class="control-label col-sm-5 col-lg-5">
						<s:text name="description" />
					</label>
					<div class="col-sm-7 col-lg-6">
						<s:textfield name="description" cssClass="form-control" />
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
<script src="../js/PageJS/partprice.js"></script>