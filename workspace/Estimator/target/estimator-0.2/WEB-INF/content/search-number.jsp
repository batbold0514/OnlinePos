<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="display" uri="http://displaytag.sf.net"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div class="row">
	<div class="col-sm-12">
		<h3 class="page-title">
			<s:text name="numberSearch" />
		</h3>
	</div>
	<p class="active_menu hide">numberSearch</p>
	<div class="col-sm-12">
		<s:form action="search-number">
			<label for="numberString" class="control-label"><s:text
					name="search" /> </label>
			<s:textfield name="numberString" />
			<button class="btn btn-primary">
				<i class="fa fa-search"></i>
				<s:text name="search" />
			</button>
			<button class="btn " id = "print">
				<i class="fa fa-print"></i>
				<s:text name="print" />
			</button>
		</s:form>
	</div>
	<div class="portlet box blue">
		<div class="portlet-title">
			<div class="caption">
				<i class="fa fa-home"> <s:text name="search" /></i>
			</div>
			<div class="tools">
				<a href="javascript:;" class="collapse"></a>
			</div>
		</div>
		<div class="portlet-body">
			<div id="list-result">
				<display:table name="cusotmerList" id="numberSearchTbl"
					class="display table-bordered table-hoverdataTable">
					<display:column property="id" title="" />
					<display:column property="date" title="Огноо" format="{0,date,yyyy-MM-dd hh:mm}"/>
					<display:column property="cnumber" title="Улсын дугаар" />
					<display:column property="confirm.description" title="Төлөв" />
					<display:column property="ownerName" title="Эзэмшигч" />
					<display:column property="ownerPhoneNumber" title="Эзэмшигч утас" />
					<display:column property="carFactory.factoryName" title="Үйлдвэр" />
					<display:column property="carMark.mark" title="Загвар" />
					<display:column property="factoryDate" title="Үйлд.он" />
					<display:column property="color" title="Өнгө" />
					<display:column property="vinNumber" title="Арал" />
					<display:column property="mainEmp.firstName" title="Үнэлгээ хийсэн" />
				</display:table>
			</div>
		</div>
	</div>
</div>
<%-- <div id="dialog-show-container">
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
</div> --%>
<div id="parseResult" class=hidden></div>
<div id="context" class="hide">${pageContext.request.contextPath}
</div>
<script src="../js/PageJS/search-number.js"></script>