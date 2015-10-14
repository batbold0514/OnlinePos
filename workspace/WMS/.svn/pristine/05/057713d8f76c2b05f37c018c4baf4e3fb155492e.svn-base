<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<script type="text/javascript" src="../js/page-js/output-article.js"></script>
<div class="hidden" id="page">
	<s:url action="outList" includeParams="none" />
</div>
<div class="panel panel-danger" id="mainPanel">
	<div class="panel-heading">
		<h3 class="panel-title text-center">
			<span class="fa fa-upload"></span>&nbsp;
			<s:text name="OutputArticle" />
		</h3>
	</div>
	<div class="panel-body">
		<s:form action="doOutputArticle" cssClass="form-horizontal">
			<s:hidden key="articleString" />
			<div class="form-group">
				<label for="articleString" class="control-label col-sm-4 col-lg-offset-1 col-lg-3">
					<s:text name="articleName" />:
				</label>
				<div class="col-sm-7 col-lg-6">
					<div class="input-group">
						<span class="input-group-addon">
							<i class="icon icon-product"></i>
						</span>
						<s:textfield key="articleName" cssClass="form-control" id="articleString" disabled="true" />
					</div>
				</div>
			</div>
			<div class="form-group">
				<div class="row">
					<div class="col-sm-12">
						<label for="outCount" class="control-label col-sm-4 col-lg-offset-1 col-lg-3">
							<s:text name="outCount" />(*):
						</label>
						<div class="col-sm-7 col-lg-6">
							<div class="input-group">
								<span class="input-group-addon">
									&nbsp;<i class="fa fa-minus"></i>
								</span>
								<s:textfield key="outCount" cssClass="form-control" id="outCount" />
							</div>
						</div>
					</div>
				</div>
				<div class="row">
					<div class="col-sm-offset-4 col-sm-7 col-lg-offset-4 col-lg-6">
						<s:fielderror fieldName="outCount" />
					</div>
				</div>
			</div>
			<div class="form-group">
				<div class="row">
					<div class="col-sm-12">
						<label for="fromString" class="control-label col-sm-4 col-lg-offset-1 col-lg-3">
							<s:text name="fromString" />(*):
						</label>
						<div class="col-sm-7 col-lg-6">
							<div class="input-group">
								<span class="input-group-addon">
									<i class="icon icon-employee"></i>
								</span>
								<s:select list="employeeList"
										listKey="id"
										listValue="firstName"
										key="fromString"
										headerKey=""
										headerValue=""
										cssClass="form-control"
										id="fromString" />
							</div>
						</div>
					</div>
				</div>
				<div class="row">
					<div class="col-sm-offset-4 col-sm-7 col-lg-offset-4 col-lg-6">
						<s:fielderror fieldName="fromString" />
					</div>
				</div>
			</div>
			<div class="form-group">
				<div class="row">
					<div class="col-sm-12">
						<label for="listCustomers" class="control-label col-sm-4 col-lg-offset-1 col-lg-3">
							<s:text name="customer" />(*):
						</label>
						<div class="col-sm-7 col-lg-6">
							<div class="input-group">
								<span class="input-group-addon">
									<i class="icon icon-customer"></i>
								</span>
								<s:select list="customers"
										key="customerString"
										listKey="id"
										listValue="name"
										headerKey=""
										headerValue=""
										cssClass="form-control"
										id="listCustomers" />
								<span class="input-group-btn">
        							<a class="btn btn-addon" id="customerAdd">
        								<i class="fa fa-plus"></i>
        							</a>
      							</span>
							</div>
						</div>
					</div>
				</div>
				<div class="row">
					<div class="col-sm-offset-4 col-sm-7 col-lg-offset-4 col-lg-6">
						<s:fielderror fieldName="outputCustomer" />
					</div>
				</div>
			</div>
			<div class="form-group">
				<label for="decription" class="control-label col-sm-4 col-lg-offset-1 col-lg-3">
					<s:text name="description" />:
				</label>
				<div class="col-sm-7 col-lg-6">
					<s:textarea key="description" value="" cssClass="form-control" id="decription" />
				</div>
			</div>
			<div class="form-group">
				<div class="col-sm-offset-1 col-sm-3 col-lg-offset-2 col-lg-2">
					<a onclick="window.history.back()" class="btn btn-back col-xs-12">
						<span class="fa fa-arrow-circle-o-left"></span>&nbsp;
						<s:text name="back" />
					</a>
				</div>
				<div class="col-sm-3 col-lg-2">
					<button type="reset" class="btn btn-gray col-xs-12">
						<span class="fa fa-refresh"></span>&nbsp;
						<s:text name="reset" />
					</button>
				</div>
				<div class="col-sm-4 col-lg-4">
					<button type="submit" class="btn btn-success col-xs-12">
						<span class="fa fa-upload"></span>&nbsp;
						<s:text name="out" />
					</button>
				</div>
			</div>
		</s:form>
	</div>
</div>
		
<div id="warning-dialog" title="Анхааруулга">
	<div class="ui-state-highlight ui-corner-all">
		<p>
			<span class="ui-icon ui-icon-info" style="float: left; margin: 0 7px 50px 0;"></span>
			Тухайн барааны нөөц доод хэмжээнээс багасаж байна.
		</p>
	</div>
</div>

<div id="danger-dialog" title="Анхааруулга">
	<div class="ui-state-error ui-corner-all">
		<p>
			<span class="ui-icon ui-icon-alert" style="float: left; margin: 0 7px 50px 0;"></span>
			Тухайн барааны нөөц хүрэлцэхгүй байна.
		</p>
	</div>
</div>

<div id="add-customer-dialog" title="Харилцагч нэмэх">
	<form>
		<div class="form-group">
			<label for="customerName">
				Харилцагчийн нэр:
			</label>
			<input type="text" name="customerName" class="form-control input-sm" id="customerName">
		</div>
	</form>
</div>