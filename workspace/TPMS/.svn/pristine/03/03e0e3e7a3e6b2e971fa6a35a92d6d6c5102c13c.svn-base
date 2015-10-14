<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="display" uri="http://displaytag.sf.net"%>
<div class="hidden" id="page">
	<s:url action="materials" includeParams="none"/>
</div>
<div class="page-content">
	<div class="page-header">
		<h2>
			<s:text name="MaterialList" />
			<small> <i class="icon-double-angle-right"></i> Жагсаалт
			</small>
		</h2>
	</div>
	<div class="row">
		<div class="col-xs-12">
			<div class="table-responsive" id="list-result">
				<display:table
					class="table table-striped table-bordered table-hover" id="example"
					name="listOfMaterials">
					<display:column property="id" title="ID" />
					<display:column property="prefix" title="Угтвар" />
					<display:column property="description" title="Тайлбар" />
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
						name="id" />
				</label>
				<div class="col-sm-7 col-lg-6">
					<s:textfield name="id" cssClass="form-control" id="stepID"
						autofocus="" disabled="true" />
				</div>
			</div>
		</div>
	</div>
	<div class="form-group">
		<div class="row">
			<div class="col-sm-12">
				<label for="prefix" class="control-label col-sm-5 col-lg-5"> <s:text
						name="prefix" />
				</label>
				<div class="col-sm-7 col-lg-6">
					<s:textfield name="prefix" cssClass="form-control" id="prefix"
						autofocus="" disabled="true" />
				</div>
			</div>
		</div>
	</div>
	<div class="form-group">
		<div class="row">
			<div class="col-sm-12">
				<label for="description" class="control-label col-sm-5 col-lg-5"> <s:text
						name="description" />
				</label>
				<div class="col-sm-7 col-lg-6">
					<s:textfield name="description" cssClass="form-control" id="description"
						autofocus="" disabled="true" />
				</div>
			</div>
		</div>
	</div>
</div>
<div id="dialog-addnew" class="hide">
	<s:form action="saveMaterial" cssClass="form-horizontal"
		id="addForm">
		<s:hidden name="id" />
		<div class="form-group">
			<div class="row">
				<div class="col-sm-12">
					<label for="prefix" class="control-label col-sm-5 col-lg-5">
						<s:text name="prefix" />(*):
					</label>
					<div class="col-sm-7 col-lg-6">
						<s:textfield name="prefix" cssClass="form-control" id="prefix"
							autofocus="" />
					</div>
				</div>
			</div>
			<div class="row">
				<div class="col-sm-offset-4 col-sm-7 col-lg-offset-3 col-lg-6"
					id="errorPrefixResult">
					<s:fielderror fieldName="prefix" />
				</div>
			</div>
		</div>
		<div class="form-group">
			<div class="row">
				<div class="col-sm-12">
					<label for="description" class="control-label col-sm-5 col-lg-5">
						<s:text name="description" />(*):
					</label>
					<div class="col-sm-7 col-lg-6">
						<s:textfield name="description" cssClass="form-control" id="description"
							autofocus="" />
					</div>
				</div>
			</div>
		</div>
	</s:form>
</div>
<div id="parseResult" class="hide"> </div>
<div id="context" class="hide">
  ${pageContext.request.contextPath}
</div>
<script src="../js/PageJS/materialList.js"></script>