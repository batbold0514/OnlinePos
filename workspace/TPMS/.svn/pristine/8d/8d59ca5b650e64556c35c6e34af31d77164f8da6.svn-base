<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<div class="hidden" id="page">
	<s:url action="productModel" includeParams="none"/>
</div>
<div class="page-content">
	<div class="page-header">
		<h3>
			<s:text name="editSteps" />
		</h3>
	</div>
	<div class="row">
		<div class="col-sm-12">
			<s:form action="edit-next" enctype="multipart/form-data"
				cssClass="form-horizontal">
				<s:hidden key="id" readonly="true" />
				<s:select key="listOfStep.id" cssClass="form-control chosen-select"
					list="productStepList" listKey="id" listValue="name"
					multiple="true" value="%{#session.psList}" />
				<div class="hr hr16 hr-dotted"></div>
				<div class="row">

					<div class="col-sm-12">
						<div class="col-sm-2">
							<a onclick="window.history.back()" class="btn btn-warning"> <b>Буцах</b>
							</a>
						</div>
						<div class="col-sm-3">
							<button class="btn btn-success">
								<s:text name="next" />
							</button>
						</div>
					</div>
				</div>
			</s:form>
		</div>
	</div>
</div>
<script type="text/javascript">
	$(document).ready(function() {
		$(".chosen-select").chosen();
	});
</script>