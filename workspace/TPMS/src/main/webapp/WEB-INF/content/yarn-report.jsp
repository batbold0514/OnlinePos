<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="display" uri="http://displaytag.sf.net"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="hidden" id="page">
	<s:url action="yarnReport" includeParams="none" />
</div>
<div class="page-content">
	<div class="page-header">
		<h2>
			<s:text name="yarnReport" />
			<small> <i class="icon-double-angle-right"></i> Жагсаалт
			</small>
		</h2>
	</div>
	<div class="row">
		<div class="col-sm-12 col-lg-12">
			<s:form action="yarnReportShow" cssClass="form-horizontal">
				<div class="row">
					<label for="firstDate" class="control-label col-sm-2 col-lg-2">
						<s:text name="firstDate" />:
					</label>
					<div class="col-sm-2 col-lg-2">
						<s:textfield name="firstDateStr" cssClass="form-control"
							id="firstDate" autofocus="" />
					</div>
					<label for="secondDate" class="control-label col-sm-2 col-lg-2">
						<s:text name="secondDate" />:
					</label>
					<div class="col-sm-2 col-lg-2">
						<s:textfield name="secondDateStr" cssClass="form-control"
							id="secondDate" autofocus="" />
					</div>
					<label for="customer" class="control-label col-sm-2 col-lg-2">
						<s:text name="customer" />:
					</label>
					<div class="col-sm-2 col-lg-2">
						<s:select list="customers" listKey="name" listValue="name"
							name="customer" headerKey="-1" headerValue=""
							cssClass="form-control" />
					</div>
				</div>
				<div class="row">
					<label for="colour" class="control-label col-sm-2 col-lg-2">
						<s:text name="colour" />:
					</label>
					<div class="col-sm-2 sol-lg-2">
						<s:select list="Colours" listKey="code" listValue="code"
							name="colour" headerKey="-1" headerValue=""
							cssClass="form-control" />
					</div>
					<label for="knitterSize" class="control-label col-sm-2 col-lg-2">
						<s:text name="knitterSize" />:
					</label>
					<div class="col-sm-2 sol-lg-2">
						<s:select list="sizes" listKey="sizes" listValue="sizes"
							name="knitterSize" headerKey="-1" headerValue=""
							cssClass="form-control" />
					</div>
					<label for="productModel" class="control-label col-sm-2 col-lg-2">
						<s:text name="productModel" />:
					</label>
					<div class="col-sm-2 sol-lg-2">
						<s:select list="productModels" listKey="modelId"
							listValue="modelId" name="productModel" headerKey="-1"
							headerValue="" cssClass="form-control" />
					</div>
				</div>
				<div class="col-sm-5 col-lg-3 col-sm-offset-7 col-lg-offset-10">
					<button class="btn btn-success col-sm-5 col-lg-5">
						<i class="icon-search"></i><s:text name="search" />
					</button>
				</div>
			</s:form>
			<div class="row">
				<div class="col-xs-12">
					<h4>Бүгд</h4>
					<display:table id="example"
						class="table table-striped table-bordered table-hover"
						name="listTrackingSheet">
						<display:column property="productModel.modelId" title="Загварын №" />
						<display:column property="productModel.yarnNumber"
							title="Утасны №" />
						<display:column property="knitterSize.sizes" title="Размер" />
						<display:column property="yarnColor.code" title="Өнгөний код" />
						<display:column property="productModel.chordPrice"
							format="{0,number,#,##0}" title="Төлөвлөгдсөн" />
						<display:column property="knitterQuantity"
							format="{0,number,#,##0}" title="Төлөвлөгдсөн хэмжээ" />
						<display:column
							value="${example.knitterQuantity * example.productModel.chordPrice}"
							title="Нийт Төлөвлөгдсөн" format="{0,number,#,##0}" />
						<display:column property="knitterWeight" title="Зарцуулагдсан"
							format="{0,number,#,##0}" />
						<%-- <display:column property="knitterQuantity"
					title="Зарцуулагдсан хэмжээ" format="{0,number,#,##0}" />
				<display:column
					value="${example.knitterQuantity * example.knitterWeight}"
					title="Нийт Зарцуулагдсан" format="{0,number,#,##0}" /> --%>
						<display:column
							value="${example.knitterQuantity * example.knitterWeight - example.knitterQuantity * example.productModel.chordPrice }"
							title="Зөрүү" format="{0,number,#,##0}" />
						<display:footer>
							<tr>
								<th style="text-align: left">Total:</th>
								<th />
								<th />
								<th />
								<th />
								<th />
								<th id="total">
								<th id="totalAll"></th>
								<th id="defTotal" />
							</tr>
						</display:footer>
					</display:table>
				</div>
			</div>
			<div class="row">
				<div class="col-xs-12">
					<h4>Дууссан</h4>
					<display:table id="example1"
						class="table table-striped table-bordered table-hover"
						name="listYarnFinish">
						<display:column property="productModel.modelId" title="Загварын №" />
						<display:column property="productModel.yarnNumber"
							title="Утасны №" />
						<display:column property="knitterSize.sizes" title="Размер" />
						<display:column property="yarnColor.code" title="Өнгөний код" />
						<display:column property="productModel.chordPrice"
							title="Төлөвлөгдсөн" format="{0,number,#,##0}" />
						<display:column property="knitterQuantity"
							title="Төлөвлөгдсөн хэмжээ" format="{0,number,#,##0}" />
						<display:column
							value="${example1.knitterQuantity * example1.productModel.chordPrice}"
							title="Нийт Төлөвлөгдсөн" format="{0,number,#,##0}" />
						<display:column property="knitterWeight" title="Зарцуулагдсан"
							format="{0,number,#,##0}" />
						<%-- <display:column property="knitterQuantity"
					title="Зарцуулагдсан хэмжээ" format="{0,number,#,##0}" />
				<display:column
					value="${example1.knitterQuantity * example1.knitterWeight}"
					title="Нийт Зарцуулагдсан" format="{0,number,#,##0}" /> --%>
						<display:column
							value="${example1.knitterQuantity * example1.knitterWeight - example1.knitterQuantity * example1.productModel.chordPrice }"
							title="Зөрүү" format="{0,number,#,##0}" />
						<display:footer>
							<tr>
								<th style="text-align: left">Total:</th>
								<th />
								<th />
								<th />
								<th />
								<th />
								<th id="total1">
								<th id="totalFinish"></th>
								<th id="defTotalFinish" />
							</tr>
						</display:footer>
					</display:table>
				</div>
			</div>
			<div class="row">
				<div class="col-xs-12">
					<h4>Дуусаагүй</h4>
					<display:table id="example2"
						class="table table-striped table-bordered table-hover"
						name="listYarnUnfinish">
						<display:column property="productModel.modelId" title="Загварын №" />
						<display:column property="productModel.yarnNumber"
							title="Утасны №" />
						<display:column property="knitterSize.sizes" title="Размер" />
						<display:column property="yarnColor.code" title="Өнгөний код" />
						<display:column property="productModel.chordPrice"
							title="Төлөвлөгдсөн" format="{0,number,#,##0}" />
						<display:column property="knitterQuantity"
							title="Төлөвлөгдсөн хэмжээ" format="{0,number,#,##0}" />
						<display:column
							value="${example2.knitterQuantity * example2.productModel.chordPrice}"
							title="Нийт Төлөвлөгдсөн" format="{0,number,#,##0}" />
						<display:column property="knitterWeight" title="Зарцуулагдсан"
							format="{0,number,#,##0}" />
						<%--<display:column property="knitterQuantity"
					title="Зарцуулагдсан хэмжээ" format="{0,number,#,##0}" />
				<display:column
					value="${example2.knitterQuantity * example2.knitterWeight}"
					title="Нийт Зарцуулагдсан" format="{0,number,#,##0}" /> --%>
						<display:column
							value="${example2.knitterQuantity * example2.knitterWeight - example2.knitterQuantity * example2.productModel.chordPrice }"
							title="Зөрүү" format="{0,number,#,##0}" />
						<display:footer>
							<tr>
								<th style="text-align: left">Total:</th>
								<th />
								<th />
								<th />
								<th />
								<th />
								<th id="total2">
								<th id="totalUnfinish"></th>
								<th id="defTotalUnFinish" />
							</tr>
						</display:footer>
					</display:table>
				</div>
			</div>
		</div>
	</div>
</div>
<div id="context" class="hide">${pageContext.request.contextPath}
</div>
<script src="../js/PageJS/yarnReport.js"></script>