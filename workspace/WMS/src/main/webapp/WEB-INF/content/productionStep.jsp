<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<div class="hidden" id="page">
	<s:url action="productionSteps" includeParams="none" />
</div>
<div class="row">
	<div class="col-sm-12">
		<div class="panel panel-success" id="mainPanel">
			<div class="panel-heading">
				<h3 class="panel-title text-center">
					<span class="icon icon-next-task"></span>&nbsp;
					<s:text name="addProductionStep" />
				</h3>
			</div>
			<div class="panel-body">
				<div class="col-sm-8 col-sm-offset-2">
					<s:form action="saveProductionStep" method="POST"
						cssClass="form-horizontal">
						<s:hidden key="id" />
						<div class="form-group">
							<s:fielderror fieldName="name" cssStyle="Color:red" />
							<label for="name" class="col-sm-4 control-label"> <s:text
									name="name" />(*):
							</label>
							<div class="col-sm-8">
								<s:textfield key="name" cssClass="form-control" id="name"
									autofocus="" />
							</div>
						</div>
						<div class="form-group">
							<div class="col-sm-4">
								<a onclick="window.history.back()" class="btn btn-back"> <span
									class="fa fa-arrow-circle-o-left"></span>&nbsp; <s:text
										name="back" />
								</a>
							</div>
							<div class="col-sm-8">
								<button type="reset"
									class="btn btn-gray col-xs-12 col-sm-5 col-md-4">
									<span class="fa fa-refresh"></span>&nbsp;
									<s:text name="reset" />
								</button>
								<button type="submit"
									class="btn btn-success col-xs-12 col-sm-7 col-md-offset-1 col-md-7">
									<span class="fa fa-check"></span>&nbsp;
									<s:text name="save" />
								</button>
							</div>
						</div>
					</s:form>
				</div>
			</div>
		</div>
	</div>
</div>