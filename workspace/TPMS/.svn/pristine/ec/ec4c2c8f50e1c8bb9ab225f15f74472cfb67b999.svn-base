<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="display" uri="http://displaytag.sf.net"%>
<div class="hidden" id="page">
	<s:url action="modelReport" includeParams="none"/>
</div>
<div class="page-content">
	<div class="page-header">
		<h2>
			<s:text name="ModelReport" />
			<small> <i class="icon-double-angle-right"></i> Жагсаалт
			</small>
		</h2>
	</div>
	<s:form action="modelReport">
		<div class="row-fluid">
			<div class="col-sm-12">
				<label for="startDate" class="control-label col-sm-2 col-lg-2">
					<s:text name="startDate" />
				</label>
				<div class="col-sm-2 col-lg-2">
					<s:textfield name="startDateStr" cssClass="form-control"
						id="startDate" autofocus=""/>
				</div>
				<label for="endDate" class="control-label col-sm-2 col-lg-2">
					<s:text name="endDate" />
				</label>
				<div class="col-sm-2 col-lg-2">
					<s:textfield name="endDateStr" cssClass="form-control" id="endDate"
						autofocus="" />
				</div>
				<div class="col-sm-2 col-lg-2">
					<button class="btn btn-success col-sm-5 col-lg-5">
						<s:text name="search" />
					</button>
				</div>
			</div>
		</div>
	</s:form>
	<div class="row">
		<div class="col-xs-12">
			<div class="table-responsive" id="list-result">
				<display:table id="example"
					class="table table-striped table-bordered table-hover"
					name="modelReportList">
					<display:column title="" media="html">
						<input type="checkbox" name="idList" value="" />
					</display:column>
					<display:column property="number" title="№" />
					<display:column property="customer.name" title="Захиалагчийн нэр" />
					<display:column property="model.modelId" title="Загвар" />
					<display:column property="colour.code" title="Өнгөний код" />
					<display:column property="colour.name" title="Өнгөний тайлбар" />
					<display:column property="sizes.sizes" title="Размер" />
					<display:column property="quantity" format="{0,number,#,##0}"
						title="Тоо ширхэг" />
					<display:column property="model.sellPrice"
						format="{0,number,#,##0}" title="Худалдах үнэ" />
					<display:column property="barCode" title="Бар код" />
				</display:table>
			</div>
		</div>
	</div>
	<s:form action="excelExport">
		<s:hidden key="listOfNumbers" value="" id="list" />
		<s:hidden key="startDateStr" />
		<s:hidden key="endDateStr" />
		<div class="col-sm-2 col-lg-2">
			<button class="btn btn-success col-sm-2 col-lg-5" id="btn">
				<s:text name="export" />
			</button>
		</div>
	</s:form>
</div>
<div id="context" class="hidden">
  ${pageContext.request.contextPath}
</div>
<script src="../js/PageJS/modelReport.js"></script>