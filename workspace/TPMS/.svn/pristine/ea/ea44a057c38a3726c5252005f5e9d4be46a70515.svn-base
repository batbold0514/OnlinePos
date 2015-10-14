<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="display" uri="http://displaytag.sf.net"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div class="hidden" id="page">
	<s:url action="numberAndPriceReport" includeParams="none" />
</div>
<div class="page-content">
	<div class="page-header">
		<h2>
			<s:text name="numberAndPriceReport" />
			<small> <i class="icon-double-angle-right"></i> Жагсаалт
			</small>
		</h2>
	</div>
	<s:form action="numberAndPriceReport" cssClass="form-horizontal">
		<div class="row-fluid">
			<div class="col-sm-12">
				<label for="startDate" class="control-label col-sm-2 col-lg-2">
					<s:text name="startDate" />:
				</label>
				<div class="col-sm-2 col-lg-2">
					<s:textfield name="startDateStr" cssClass="form-control"
						id="startDate" autofocus="" />
				</div>
				<label for="endDate" class="control-label col-sm-2 col-lg-2">
					<s:text name="endDate" />:
				</label>
				<div class="col-sm-2 col-lg-2">
					<s:textfield name="endDateStr" cssClass="form-control" id="endDate"
						autofocus="" />
				</div>
				<label for="customerId" class="control-label col-sm-2 col-lg-2">
					<s:text name="Customer" />:
				</label>
				<div class="col-sm-2 col-lg-2">
					<s:select list="customers" listKey="id" listValue="name"
						name="customerId" requiredLabel="true" headerKey="-1"
						headerValue="" cssClass="form-control" />
				</div>
			</div>
			<div class="col-sm-12">
				<label for="colour" class="control-label col-sm-2 col-lg2">
					<s:text name="colour" />:
				</label>
				<div class="col-sm-2 col-lg-2">
					<s:select list="colours" listKey="id" listValue="code +' '+ name"
						name="colourId" requiredLabel="true" headerKey="-1" headerValue=""
						cssClass="form-control" />
				</div>
				<label for="Size" class="control-label col-sm-2 col-lg-2"> <s:text
						name="Size" />:
				</label>
				<div class="col-sm-2 col-lg-2">
					<s:select list="sizes" listKey="id" listValue="sizes" name="sizeId"
						requiredLabel="true" headerKey="-1" headerValue=""
						cssClass="form-control" />
				</div>
				<label for="ProductModel" class="control-label col-sm-2 col-lg-2">
					<s:text name="ProductModel" />:
				</label>
				<div class="col-sm-2 col-lg-2">
					<s:select list="productModels" listKey="modelId"
						listValue="modelId" name="modelNumber" requiredLabel="true"
						headerKey="" headerValue="" cssClass="form-control" />
				</div>
				<div class="col-sm-4 col-lg-4">
					<button class="btn btn-success col-sm-4 col-lg-4">
						<s:text name="search" />
					</button>
				</div>
			</div>
		</div>
	</s:form>
	<%-- <th><div>
				<table>
					<s:text name="totalCost" />
					<s:text name=" : " />
					<s:property value="getText('{0,number,#,##0}',{totalCost})" />
				</table>
			</div></th>
		<th><div>
				<table style="float: left">
					<s:text name="totalSell"  />
					<s:text name=" : " />
					<s:property value="getText('{0,number,#,##0}',{totalSell})" />
				</table>
			</div></th> --%>
	<div class="row-fluid">
		<div class="col-sm-12">
			<h3>
				<label class="control-label col-sm-4 col-lg-4"> <s:text
						name="totalCost" /> <s:text name=" : " /> <s:property
						value="getText('{0,number,#,##0}',{totalCost})" />
				</label> <label class="control-label sol-sm-4 col-lg-4"> <s:text
						name="totalSell" /> <s:text name=" : " /> <s:property
						value="getText('{0,number,#,##0}',{totalSell})" />
				</label>
			</h3>
		</div>
	</div>
	<div class="row">
		<div class="col-xs-12">
			<h4>Дууссан</h4>
			<display:table id="example" cellpadding="0" cellspacing="0"
				class="table table-striped table-bordered table-hover"
				name="listOfNumberPriceFinish">
				<display:column property="trackingSheet.productModel.modelId"
					title="Загварын дугаар" style="vertical-align: middle;" />
				<display:column property="quantity" title="Тоо ширхэг"
					style="vertical-align: middle;" format="{0,number,#,##0}" />
				<display:column property="trackingSheet.productModel.sellPrice"
					format="{0,number,#,##0}" title="Нэгж үнэ"
					style="vertical-align: middle;" />
				<display:column
					value="${example.quantity*example.trackingSheet.productModel.sellPrice}"
					format="{0,number,#,##0}" title="Нийт үнэ"
					style="vertical-align: middle;" />
				<display:column property="trackingSheet.knitterSize.sizes"
					title="Размер" style="vertical-align: middle;" />
				<display:column property="trackingSheet.yarnColor.code" title="Өнгө"
					style="vertical-align: middle;" />
				<display:column property="trackingSheet.customer.name"
					title="Захиалагч" style="vertical-align: middle;" />
				<display:column href="editProductModel"
					paramProperty="trackingSheet.productModel.id" paramId="model.id"
					media="html">
					<s:text name="show" />
				</display:column>
				<display:column href="trackingSheetShow"
					paramProperty="trackingSheet.id" paramId="model.id" media="html">
					<s:text name="TrackingSheet" />
				</display:column>
				<display:footer>
					<tr>
						<th colspan="1" style="text-align: right">Total:</th>
						<th id="total"></th>
						<th />
						<th id="total1"></th>
						<th />
						<th />
						<th />
						<th />
						<th />
					</tr>
				</display:footer>
			</display:table>
		</div>
	</div>
	<div class="row">
		<div class="col-xs-12">
			<h4>Дуусаагүй</h4>
			<display:table id="example1" cellpadding="0" cellspacing="0"
				class="table table-striped table-bordered table-hover"
				name="listOfNumberPriceUnFinish">
				<display:column property="trackingSheet.productModel.modelId"
					title="Загварын дугаар" style="vertical-align: middle;" />
				<display:column property="quantity" title="Тоо ширхэг"
					style="vertical-align: middle;" format="{0,number,#,##0}" />
				<display:column property="trackingSheet.productModel.sellPrice"
					format="{0,number,#,##0}" title="Нэгж үнэ"
					style="vertical-align: middle;" />
				<display:column
					value="${example.quantity*example.trackingSheet.productModel.sellPrice}"
					format="{0,number,#,##0}" title="Нийт үнэ"
					style="vertical-align: middle;" />
				<display:column property="trackingSheet.knitterSize.sizes"
					title="Размер" style="vertical-align: middle;" />
				<display:column property="trackingSheet.yarnColor.code" title="Өнгө"
					style="vertical-align: middle;" />
				<display:column property="trackingSheet.customer.name"
					title="Захиалагч" style="vertical-align: middle;" />
				<display:column href="editProductModel"
					paramProperty="trackingSheet.productModel.id" paramId="model.id"
					media="html">
					<s:text name="show" />
				</display:column>
				<display:column href="showTrackingSheetList"
					paramProperty="trackingSheet.id" paramId="model.id" media="html">
					<s:text name="TrackingSheet" />
				</display:column>
				<display:footer>
					<tr>
						<th colspan="1" style="text-align: right">Total:</th>
						<th id="total2"></th>
						<th />
						<th id="total3"></th>
						<th />
						<th />
						<th />
						<th />
						<th />
					</tr>
				</display:footer>
			</display:table>
		</div>
	</div>
</div>
<div id="context" class="hidden">
	${pageContext.request.contextPath}</div>
<script src="../js/PageJS/numberAndPrice.js"></script>