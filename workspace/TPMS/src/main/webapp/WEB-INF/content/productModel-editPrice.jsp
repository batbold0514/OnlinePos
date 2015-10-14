<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<script>
	function myLocation() {
		window.location = 'productModel';
	}
	$(document).ready(function() {
		$("#focus").focus();
	});
</script>

<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

<script type="text/javascript">
	$(function() {
		$("input[type=submit]").button();
	});
</script>
<div class="page-content">
	<div class="page-header">
		<h2>
			<s:text name="addProductModel" />
		</h2>
	</div>
	<div class="row">
		<div class="col-xs-12">
			<s:form action="savePmPrice" method="POST" cssClass="form-horizontal">
				<s:hidden key="id" />
				<s:hidden key="description" />
				<s:hidden key="percent" />
				<s:hidden key="chordPrice" />
				<s:hidden key="unitChordPrice" />
				<s:hidden key="aidPrice" />
				<s:hidden key="sellPrice" />
				<s:hidden key="yarnNumber" />
				<div class="form-group">
					<div class="row">
						<div class="col-sm-12">
							<label for="label" class="control-label col-sm-4 col-lg-4">
								<s:text name="label" />:
							</label>
							<div class="col-sm-7 col-lg-6">
								<s:textfield name="label" label="%{getText('status')}"
									value="%{status.label}" readonly="true" cssClass="form-control" />
							</div>
						</div>
					</div>
					<div class="row">
						<div class="col-sm-offset-4 col-sm-7 col-lg-offset-3 col-lg-6"
							id="errorlabelResult">
							<s:fielderror fieldName="label" />
						</div>
					</div>
				</div>
				<div class="form-group">
					<div class="row">
						<div class="col-sm-12">
							<label for="modelId" class="control-label col-sm-4 col-lg-4">
								<s:text name="modelId" />:
							</label>
							<div class="col-sm-7 col-lg-6">
								<s:textfield key="modelId" readonly="true"
									cssClass="form-control" />
							</div>
						</div>
					</div>
					<div class="row">
						<div class="col-sm-offset-4 col-sm-7 col-lg-offset-3 col-lg-6"
							id="errormodelIdResult">
							<s:fielderror fieldName="modelId" />
						</div>
					</div>
				</div>
				<div class="form-group">
					<div class="row">
						<div class="col-sm-12">
							<label for="stoll" class="control-label col-sm-4 col-lg-4">
								<s:text name="stoll" />:
							</label>
							<div class="col-sm-7 col-lg-6">
								<s:textfield key="stoll" readonly="true" cssClass="form-control" />
							</div>
						</div>
					</div>
					<div class="row">
						<div class="col-sm-offset-4 col-sm-7 col-lg-offset-3 col-lg-6"
							id="errorstollResult">
							<s:fielderror fieldName="stoll" />
						</div>
					</div>
				</div>

				<s:iterator value="#session.listOfStepPrice" status="stat">
					<s:if test="productStep.id != 1000">
						<div class="form-group">
							<div class="row">
								<div class="col-sm-12">
									<label for="stoll" class="control-label col-sm-4 col-lg-4">
										<s:property value="productStep.name" />:
									</label>
									<div class="col-sm-7 col-lg-6">
										<s:textfield name="listOfPrice[%{#stat.index}]"
											value="%{price}" requiredLabel="true" cssClass="form-control"
											id="focus" />
									</div>
								</div>
							</div>
							<div class="row">
								<div class="col-sm-offset-4 col-sm-7 col-lg-offset-3 col-lg-6"
									id="errorlistOfPrice[%{#stat.index}]Result">
									<s:fielderror fieldName="listOfPrice[%{#stat.index}]" />
								</div>
							</div>
						</div>
					</s:if>
					<s:else>
						<div class="form-group">
							<div class="row">
								<div class="col-sm-12">
									<label for="stoll" class="control-label col-sm-4 col-lg-4">
										<s:property value="productStep.name" />:
									</label>
									<div class="col-sm-7 col-lg-6">
										<s:textfield name="listOfPrice[%{#stat.index}]"
											value="%{price}" requiredLabel="true" cssClass="form-control"
											readonly="true" />
									</div>
								</div>
							</div>
						</div>
					</s:else>
				</s:iterator>
				<div class="row">
					<div class="col-sm-12">
						<div class="col-sm-offset-6 col-sm-3">
							<button id="save" class="btn btn-success">
								<s:text name="save" />
							</button>
						</div>
						<div class="col-sm-3">
							<a
								href="<s:url action='editProductModel?model.id=%{id}'></s:url>"
								class="btn btn-warning"><s:text name="back" /></a>
						</div>
					</div>
				</div>
			</s:form>
		</div>
	</div>
</div>