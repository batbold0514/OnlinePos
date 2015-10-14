<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="display" uri="http://displaytag.sf.net"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="hidden" id="page">
	<s:url action="productTypes" includeParams="none"/>
</div>
<div class="page-content">
	<div class="page-header">
		<h2>
			<s:text name="productTypes" />
			<small> <i class="icon-double-angle-right"></i> Жагсаалт
			</small>
		</h2>
	</div>
	<div class="row">
		<div class="col-xs-12">
			<div class="table-responsive" id="list-result">
				<display:table name="listPt" id="productTypeTable"
					class="table table-striped table-bordered table-hover">
					<display:column property="prefix" title="Код" />
					<display:column property="name" title="Төрөл" />
					<display:column property="active" title="Төлөв" />
					<display:column property="id" />
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
				<label for="prefix" class="control-label col-sm-5 col-lg-5">
					<s:text name="prefix" />(*):
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
	<div class="control-group">
		<div class="row">
			<div class="col-sm-offset-4">
				<label class="col-sm-offset-4"> <input type="radio"
					id="radio1" name="active" id="radio1" /> <span class="lbl">
						Идэвхтэй </span>
				</label>
			</div>
			<div class="col-sm-offset-4">
				<label class="col-sm-offset-4"> <input type="radio"
					id="radio2" name="active" id="radio2" /> <span class="lbl">
						Идэвхгүй </span>
				</label>

			</div>
		</div>
		<div class="row">
			<div class="col-sm-offset-4 col-sm-7 col-lg-offset-4 col-lg-6"
				id="errorActiveResult">
				<s:fielderror fieldName="active" />
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
		<div class="control-group">
			<div class="row">
				<div class="col-sm-offset-4">
					<label class="col-sm-offset-4"> <input type="radio"
						name="active" class="ace" value="true" /> <span class="lbl">
							Идэвхтэй </span>
					</label>
				</div>
				<div class="col-sm-offset-4">
					<label class="col-sm-offset-4"> <input type="radio"
						name="active" class="ace" value="false" /> <span class="lbl">
							Идэвхгүй </span>
					</label>

				</div>
			</div>
			<div class="row">
				<div class="col-sm-offset-4 col-sm-7 col-lg-offset-4 col-lg-6"
					id="errorActiveResult">
					<s:fielderror fieldName="active" />
				</div>
			</div>
		</div>
	</s:form>
</div>
<div id="parseResult"></div>
<div id="context" class="hide">
  ${pageContext.request.contextPath}
</div>
<script src="../js/PageJS/productTypeList.js"></script>