<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="display" uri="http://displaytag.sf.net"%>
<% response.setHeader("Content-Encoding", "gzip"); %>
<div class="hidden" id="page">
	<s:url action="sizeList" includeParams="none"/>
</div>
<div class="page-content">
	<div class="page-header">
		<h2>
			<s:text name="SizeList" />
			<small> <i class="icon-double-angle-right"></i> Жагсаалт
			</small>
		</h2>
	</div>
	<div class="row">
		<div class="col-xs-12">
			<div class="table-responsive" id="list-result">
				<display:table
					class="table table-striped table-bordered table-hover" id="example"
					name="sizeList">
					<display:column property="id" title="ID" />
					<display:column property="sizes" title="Размер" />
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
				<label for="sizes" class="control-label col-sm-5 col-lg-5"> <s:text
						name="sizes" />
				</label>
				<div class="col-sm-7 col-lg-6">
					<s:textfield name="sizes" cssClass="form-control" id="sizes"
						autofocus="" disabled="true" />
				</div>
			</div>
		</div>
	</div>
</div>
<div id="dialog-addnew" class="hide">
	<s:form action="saveColour" cssClass="form-horizontal"
		id="addForm">
		<s:hidden name="id" />
		<div class="form-group">
			<div class="row">
				<div class="col-sm-12">
					<label for="sizes" class="control-label col-sm-5 col-lg-5">
						<s:text name="sizes" />(*):
					</label>
					<div class="col-sm-7 col-lg-6">
						<s:textfield name="sizes" cssClass="form-control" id="sizes"
							autofocus="" />
					</div>
				</div>
			</div>
			<div class="row">
				<div class="col-sm-offset-4 col-sm-7 col-lg-offset-3 col-lg-6"
					id="errorSizesResult">
					<s:fielderror fieldName="sizes" />
				</div>
			</div>
		</div>
	</s:form>
</div>
<div id="context" class="hide">
  ${pageContext.request.contextPath}
</div>
<script src="../js/PageJS/sizeList.js"></script>