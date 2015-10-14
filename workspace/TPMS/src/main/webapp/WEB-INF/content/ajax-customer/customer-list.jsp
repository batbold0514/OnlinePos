<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="display" uri="http://displaytag.sf.net"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="hidden" id="page">
	<s:url action="customer-list" includeParams="none"/>
</div>
<div class="page-content">
	<div class="page-header">
		<h2>
			<s:text name="CustomerList" />
			<small> <i class="icon-double-angle-right"></i> Жагсаалт
			</small>
		</h2>
	</div>
	<div class="row">
		<div class="col-xs-12">
			<div class="table-responsive" id="list-result">
				<display:table name="customerList" id="customertable"
					class="table table-striped table-bordered table-hover">
					<display:column property="id" title="ID" />
					<display:column property="name" title="Нэр" />
				</display:table>
			</div>
		</div>
	</div>
</div>
<div id="dialog-show" class="hide">
	<div class="form-group">
		<div class="row">
			<div class="col-sm-12">
				<label for="id" class="control-label col-sm-5 col-lg-5"> <s:text
						name="id" />(*):
				</label>
				<div class="col-sm-7 col-lg-6">
					<s:textfield name="id" cssClass="form-control" id="id" autofocus=""
						readonly="true" />
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
</div>

<div id="dialog-addnew" class="hide">
	<s:form cssClass="form-horizontal" id="addForm">
		<s:hidden name="id" />
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
	</s:form>
</div>
<div id="parseResult"></div>
<div id="context" class="hide">
  ${pageContext.request.contextPath}
</div>
<script src="../js/PageJS/customerList.js"></script>