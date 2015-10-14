<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
	if (request.getAttribute("successTrackingSheet") == null) {
%>
<s:form cssClass="form-horizontal" id="editForm">
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
						listKey="id" headerKey="-1" headerValue="" value= "customer.id"
						cssClass="chosen-select" data-placeholder="Үйлчлүүлэгч сонгоно уу" />
				</div>
			</div>
		</div>
		<div class="row">
			<div class="col-sm-offset-4 col-sm-7 col-lg-offset-3 col-lg-6"
				id="errorcstomereditFormResult">
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
					<div hidden="true">
					<s:date name="startDate" format="yyyy-MM-dd" var="date"/>
					</div>
					<s:textfield name="stDate" value= "%{#date}"
						cssClass="form-control" id="date-r" />
				</div>
			</div>
		</div>
		<div class="row">
			<div class="col-sm-offset-4 col-sm-7 col-lg-offset-3 col-lg-6"
				id="errorstartDateeditFormResult">
				<s:fielderror fieldName="startDate" />
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
					<s:select data-placeholder="Дамжлага сонгоно уу"
						id="productModelSelectID1" list="productModels" listValue="modelId" listKey="id"
						key="productMoodel" headerKey="-1" headerValue="" value= "productModel.id"
						cssClass="chosen-select" />
				</div>
				<div class="row">
					<div class="col-sm-12" id="selectColors1">
						<s:iterator value="yarnColorList" status="stat" begin="0"
							end="yarnColorList.size-1" id="iterate">
							<div class="row">
								<label for="2" class="control-label col-sm-5 col-lg-5"> <s:text
										name="%{#stat.index+1} -р өнгө" />
								</label>
								<div class="col-sm-7 col-lj-6">
									<s:select list="colours" listKey="id" listValue="code + ' ' + name"
										headerKey="" headerValue="" name="listColorID[%{#stat.index}]"/>
								</div>
							</div>
						</s:iterator>
					</div>
				</div>
			</div>
		</div>
		<div class="row">
			<div class="col-sm-offset-4 col-sm-7 col-lg-offset-4 col-lg-6"
				id="errorproductMoodeleditFormResult">
				<s:fielderror fieldName="productMoodel" />
			</div>
		</div>
	</div>
	<div class="form-group">
		<div class="row">
			<div class="col-sm-12">
				<label for="kniterChecker" class="control-label col-sm-5 col-lg-5">
					<s:text name="knitterChecker.id" />(*):
				</label>
				<div class="col-sm-7 col-lg-6">
					<s:select list="employees" listValue="firstName" listKey="id"
						key="kniterChecker" headerKey="-1" headerValue="" value= "knitterChecker.id"
						cssClass="chosen-select" />
				</div>
			</div>
		</div>
		<div class="row">
			<div class="col-sm-offset-4 col-sm-7 col-lg-offset-4 col-lg-6"
				id="errorkniterCheckereditFormResult">
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
					<s:select list="sizes" listKey="id" listValue="sizes"
						key="knitterSizeString" headerKey="-1" headerValue="" value = "knitterSize.id"
						cssClass="chosen-select" />
				</div>
			</div>
		</div>
		<div class="row">
			<div class="col-sm-offset-4 col-sm-7 col-lg-offset-4 col-lg-6"
				id="errorknitterSizeStringeditFormResult">
				<s:fielderror fieldName="knitterSizeString" />
			</div>
		</div>
	</div>
	<div class="form-group">
		<div class="row">
			<div class="col-sm-12">
				<label for="knitterQuantity" class="control-label col-sm-5 col-lg-5">
					<s:text name="knitterQuantity" />(*):
				</label>
				<div class="col-sm-7 col-lg-6">
					<s:textfield key="knitterQuantity" title="эерэг тоо"
						cssClass="form-control"/>
				</div>
			</div>
		</div>
		<div class="row">
			<div class="col-sm-offset-4 col-sm-7 col-lg-offset-4 col-lg-6"
				id="errorknitterQuantityeditFormResult">
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
				id="errorknitterWeighteditFormResult">
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
					<s:select list="employees" listValue="firstName" listKey="id"
						key="PSChecker" headerKey="-1" headerValue=""
						cssClass="chosen-select" value= "productionStepChecker.id"/>
				</div>
			</div>
		</div>
		<div class="row">
			<div class="col-sm-offset-4 col-sm-7 col-lg-offset-4 col-lg-6"
				id="errorPSCheckereditFormResult">
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
					<s:select list="employees" listValue="firstName" listKey="id"
						key="aChecker" headerKey="-1" headerValue=""
						cssClass="chosen-select" value = "actualChecker.id"/>
				</div>
			</div>
		</div>
		<div class="row">
			<div class="col-sm-offset-4 col-sm-7 col-lg-offset-4 col-lg-6"
				id="erroraCheckereditFormResult">
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
				id="errorbonusStringeditFormResult">
				<s:fielderror fieldName="bonusString" />
			</div>
		</div>
	</div>
</s:form>
<%} %>

