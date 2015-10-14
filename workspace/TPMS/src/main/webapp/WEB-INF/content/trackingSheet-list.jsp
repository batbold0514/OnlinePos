<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="display" uri="http://displaytag.sf.net"%>
<div class="hidden" id="page">
	<s:url action="trackingSheetList" includeParams="none" />
</div>
<div class="page-content">
	<div class="page-header">
		<h2>
			Дагалдах хуудас <small> <i class="icon-double-angle-right"></i>
				Жагсаалт
			</small>
		</h2>
	</div>
	<div class="row">
		<div class="col-xs-12">
			<div class="row">
				<div class="col-sm-12">
					<s:form cssClass="form-horizontal" action="trackingSheetSearch">
						<label for="startDate" class="control-label col-sm-4 col-lg-2">
							<s:text name="startDate" />:
						</label>
						<div class="col-sm-4 col-lg-2">
							<s:textfield name="startDateTs" cssClass="form-control"
								id="startDate" />
						</div>
						<label for="endDate" class="control-label col-sm-4 col-lg-2">
							<s:text name="endDate" />:
						</label>
						<div class="col-sm-4 col-lg-2">
							<s:textfield name="endDateTs" cssClass="form-control"
								id="endDate" />
						</div>
						<button class="btn btn-success col-sm-4 col-lg-1">
							<i class="icon-search"></i>
							<s:text name="search" />
						</button>
					</s:form>
				</div>
			</div>
			<div class="table-responsive" id="list-result">
				<display:table
					class="table table-striped table-bordered table-hover" id="example"
					name="listTrackingSheet">
					<display:column property="id" title="ID"></display:column>
					<display:column property="startNumber" title="Эхэлсэн дугаар"></display:column>
					<display:column property="customer.name" title="Захиалагч"></display:column>
					<display:column property="productModel.modelId"
						title="Загварын код"></display:column>
					<display:column property="knitterQuantity" title="Тоо ширхэг"></display:column>
					<display:column property="knitterSize.sizes" title="Размер"></display:column>
					<display:column property="yarnColor.code" title="Өнгөний код"></display:column>
					<display:column property="knitterWeight" title="Гарсан гр/жин"></display:column>
					<display:column property="status.label" title="Төлөв"></display:column>
					<display:column property="bonus.name" title="Бонус"></display:column>
					<display:column property="endNumber" title="Дууссан дугаар"></display:column>
					<display:column property="barcode" title="Баркод"></display:column>
					<display:column property="startDate" title="Нээсэн огноо"></display:column>
					<%-- <display:column property="knitterChecker.firstName"
		title="Сүлжихийн чанар шалгагч"></display:column> --%>
					<display:footer>
						<tfoot>
							<tr>
								<th><input type="text" list="datalistId0"
									name="search_engine" value="" class="search_init" /></th>
								<th><input type="text" list="datalistId1"
									name="search_engine" value="" class="search_init" /></th>
								<th><input type="text" list="datalistId2"
									name="search_engine" value="" class="search_init" /></th>
								<th><input type="text" list="datalistId3"
									name="search_engine" value="" class="search_init" /></th>
								<th><input type="text" list="datalistId4"
									name="search_engine" value="" class="search_init" /></th>
								<th><input type="text" list="datalistId5"
									name="search_engine" value="" class="search_init" /></th>
								<th><input type="text" list="datalistId6"
									name="search_engine" value="" class="search_init" /></th>
								<th><input type="text" list="datalistId7"
									name="search_engine" value="" class="search_init" /></th>
								<th><input type="text" list="datalistId8"
									name="search_engine" value="" class="search_init" /></th>
								<th><input type="text" list="datalistId9"
									name="search_engine" value="" class="search_init" /></th>
								<th><input type="text" list="datalistId10"
									name="search_engine" value="" class="search_init" /></th>
								<th><input type="text" list="datalistId11"
									name="search_engine" value="" class="search_init" /></th>
								<th><input type="text" list="datalistId12"
									name="search_engine" value="" class="search_init" /></th>
							</tr>
							<tr>
								<td></td>
								<td></td>
								<td></td>
								<td></td>
								<td></td>
								<td></td>
								<td></td>
								<td></td>
								<td></td>
								<td></td>
								<td></td>
								<td></td>
								<td></td>
							</tr>
						</tfoot>
					</display:footer>
				</display:table>
			</div>
		</div>
	</div>
</div>
<div id="dialog-addnew">
	<s:form cssClass="form-horizontal" id="addForm">
		<s:hidden key="actualWeight" />
		<s:hidden key="id" />
		<s:hidden key="status" />
		<div class="form-group">
			<div class="row">
				<div class="col-sm-12">
					<label for="cstomer" class="control-label col-sm-5 col-lg-5">
						<s:text name="customer" />(*):
					</label>
					<div class="col-sm-7 col-lg-6">
						<s:select name="cstomer" list="customers" listValue="name"
							listKey="id" headerKey="-1" headerValue=""
							cssClass="chosen-select"
							data-placeholder="Үйлчлүүлэгч сонгоно уу" />
					</div>
				</div>
			</div>
			<div class="row">
				<div class="col-sm-offset-4 col-sm-7 col-lg-offset-3 col-lg-6"
					id="errorcstomeraddFormResult">
					<s:fielderror fieldName="cstomer" />
				</div>
			</div>
		</div>
		<div class="form-group">
			<div class="row">
				<div class="col-sm-12">
					<label for="stDate" class="control-label col-sm-5 col-lg-5">
						<s:text name="startDate" />(*):
					</label>
					<div class="col-sm-7 col-lg-6">
						<s:textfield cssClass="form-control date" name="stDate" />
					</div>
				</div>
			</div>
			<div class="row">
				<div class="col-sm-offset-4 col-sm-7 col-lg-offset-3 col-lg-6"
					id="errorstDateaddFormResult">
					<s:fielderror fieldName="stDate" />
				</div>
			</div>
		</div>
		<div class="form-group">
			<div class="row">
				<div class="col-sm-12">
					<label for="productMoodel" class="control-label col-sm-5 col-lg-5">
						<s:text name="productModel.id" />(*):
					</label>
					<div class="col-sm-7 col-lg-6">
						<s:select data-placeholder="Загварын дугаар сонгоно уу"
							id="productModelSelectID" list="productModels"
							listValue="modelId" listKey="id" key="productMoodel"
							headerKey="-1" headerValue="" cssClass="chosen-select" />
					</div>
				</div>
			</div>
			<div class="row">
				<div class="col-sm-offset-4 col-sm-7 col-lg-offset-4 col-lg-6"
					id="errorproductMoodeladdFormResult">
					<s:fielderror fieldName="productMoodel" />
				</div>
			</div>
			<div class="row">
				<div class="col-sm-12" id="selectColors"></div>
			</div>
		</div>
		<div class="form-group">
			<div class="row">
				<div class="col-sm-12">
					<label for="kniterChecker" class="control-label col-sm-5 col-lg-5">
						<s:text name="knitterChecker.id" />(*):
					</label>
					<div class="col-sm-7 col-lg-6">
						<s:select data-placeholder="Чанар шалгагч сонгоно уу"
							list="employees" listValue="firstName" listKey="id"
							key="kniterChecker" headerKey="-1" headerValue=""
							cssClass="chosen-select" />
					</div>
				</div>
			</div>
			<div class="row">
				<div class="col-sm-offset-4 col-sm-7 col-lg-offset-4 col-lg-6"
					id="errorkniterCheckeraddFormResult">
					<s:fielderror fieldName="kniterChecker" />
				</div>
			</div>
		</div>
		<div class="form-group">
			<div class="row">
				<div class="col-sm-12">
					<label for="knitterSizeString"
						class="control-label col-sm-5 col-lg-5"> <s:text
							name="knitterSizeString" />(*):
					</label>
					<div class="col-sm-7 col-lg-6">
						<s:select data-placeholder="Размер сонгоно уу" list="sizes"
							listKey="id" listValue="sizes" key="knitterSizeString"
							headerKey="-1" headerValue="" cssClass="chosen-select" />
					</div>
				</div>
			</div>
			<div class="row">
				<div class="col-sm-offset-4 col-sm-7 col-lg-offset-4 col-lg-6"
					id="errorknitterSizeStringaddFormResult">
					<s:fielderror fieldName="knitterSizeString" />
				</div>
			</div>
		</div>
		<div class="form-group">
			<div class="row">
				<div class="col-sm-12">
					<label for="knitterQuantity"
						class="control-label col-sm-5 col-lg-5"> <s:text
							name="knitterQuantity" />(*):
					</label>
					<div class="col-sm-7 col-lg-6">
						<s:textfield key="knitterQuantity" title="эерэг тоо"
							cssClass="form-control" />
					</div>
				</div>
			</div>
			<div class="row">
				<div class="col-sm-offset-4 col-sm-7 col-lg-offset-4 col-lg-6"
					id="errorknitterQuantityaddFormResult">
					<s:fielderror fieldName="knitterQuantity" />
				</div>
			</div>
		</div>
		<div class="form-group">
			<div class="row">
				<div class="col-sm-12">
					<label for="knitterWeight" class="control-label col-sm-5 col-lg-5">
						<s:text name="knitterWeight" />(*):
					</label>
					<div class="col-sm-7 col-lg-6">
						<s:textfield key="knitterWeight" title="эерэг тоо"
							cssClass="form-control" />
					</div>
				</div>
			</div>
			<div class="row">
				<div class="col-sm-offset-4 col-sm-7 col-lg-offset-4 col-lg-6"
					id="errorknitterWeightaddFormResult">
					<s:fielderror fieldName="knitterWeight" />
				</div>
			</div>
		</div>
		<div class="form-group">
			<div class="row">
				<div class="col-sm-12">
					<label for="PSChecker" class="control-label col-sm-5 col-lg-5">
						<s:text name="productionStepChecker.id" />(*):
					</label>
					<div class="col-sm-7 col-lg-6">
						<s:select data-placeholder="Чанар шалгагч сонгоно уу"
							list="employees" listValue="firstName" listKey="id"
							key="PSChecker" headerKey="-1" headerValue=""
							cssClass="chosen-select" />
					</div>
				</div>
			</div>
			<div class="row">
				<div class="col-sm-offset-4 col-sm-7 col-lg-offset-4 col-lg-6"
					id="errorPSCheckeraddFormResult">
					<s:fielderror fieldName="PSChecker" />
				</div>
			</div>
		</div>
		<div class="form-group">
			<div class="row">
				<div class="col-sm-12">
					<label for="aChecker" class="control-label col-sm-5 col-lg-5">
						<s:text name="actualChecker.id" />(*):
					</label>
					<div class="col-sm-7 col-lg-6">
						<s:select data-placeholder="Чанар шалгагч сонгоно уу"
							list="employees" listValue="firstName" listKey="id"
							key="aChecker" headerKey="-1" headerValue=""
							cssClass="chosen-select" />
					</div>
				</div>
			</div>
			<div class="row">
				<div class="col-sm-offset-4 col-sm-7 col-lg-offset-4 col-lg-6"
					id="erroraCheckeraddFormResult">
					<s:fielderror fieldName="aChecker" />
				</div>
			</div>
		</div>
		<div class="form-group">
			<div class="row">
				<div class="col-sm-12">
					<label for="bonusString" class="control-label col-sm-5 col-lg-5">
						<s:text name="bonusString" />(*):
					</label>
					<div class="col-sm-7 col-lg-6">
						<s:select list="bonuses" listValue="name" listKey="id"
							key="bonusString" cssClass="form-control" />
					</div>
				</div>
			</div>
			<div class="row">
				<div class="col-sm-offset-4 col-sm-7 col-lg-offset-4 col-lg-6"
					id="errorbonusStringaddFormResult">
					<s:fielderror fieldName="bonusString" />
				</div>
			</div>
		</div>
	</s:form>
</div>
<div id="dialog-edit">
	<div id="edit-result"></div>
	<div id="pic" class="hide center">
		<img src="../img/waiting.gif" height="30px" width="40px" />
	</div>
</div>

<div id="parseResult" class=hidden></div>
<div id="editId"></div>
<div id="context" class="hide">${pageContext.request.contextPath}
</div>
<script src="../js/PageJS/trackingSheetList.js"></script>
