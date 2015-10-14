<%@page import="java.awt.event.WindowEvent"%>
<%@page import="java.awt.Window"%>
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
			<s:form action="save-edit-step" method="POST"
				cssClass="form-horizontal">
				<s:hidden key="id" />
				<s:iterator value="#session.listofs" status="stat" begin="0"
					end="#session.listofs.size/2-1">
					<div class="form-group">
						<div class="row">
							<div class="col-sm-12">
								<label for="status" class="control-label col-sm-4 col-lg-4">
									<s:property value="name" />:
								</label>
								<div class="col-sm-7 col-lg-6">
									<s:if test="id == 1000">
										<s:textfield name="listOfPrice[%{#stat.index}]"
											cssClass="form-control" value="%{#session.stoll}"
											readonly="true" />
									</s:if>
									<s:else>
										<s:textfield name="listOfPrice[%{#stat.index}]"
											cssClass="form-control" id="focus" />
									</s:else>
								</div>
							</div>
						</div>
						<div class="row">
							<div class="col-sm-offset-4 col-sm-7 col-lg-offset-3 col-lg-6"
								id="errorstatusResult">
								<s:fielderror fieldName="status" />
							</div>
						</div>
					</div>
				</s:iterator>
				<div class="row">
					<div class="col-sm-12">
					<div class="col-sm-5">
					</div>
						<div class="col-sm-2">
							<a onclick="window.history.back()" class="btn btn-warning"> <b>Буцах</b>
							</a>
						</div>
						<div class="col-sm-3">
							<button class="btn btn-success" id="save">
								<s:text name="save" />
							</button>
						</div>
					</div>
				</div>
			</s:form>
		</div>
	</div>
</div>
<script>
	function myLocation() {
		window.location = 'productModel';
	}
</script>
<script type="text/javascript">
	$(function() {
		$("input[type=submit]").button();
	});
	$(function() {
		$("#focus").focus();
	});
</script>