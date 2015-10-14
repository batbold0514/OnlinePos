<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<div class="hidden" id="page">
	<s:url action="inputArticleList" includeParams="none" />
</div>
<div class="panel panel-warning" id="mainPanel">
	<div class="panel-heading">
		<h3 class="panel-title text-center">
			<span class="fa fa-download"></span>&nbsp;
			<s:text name="editInputArticle" />
		</h3>
	</div>
	<div class="panel-body">
		<s:form action="saveEdit" cssClass="form-horizontal">
			<s:hidden key="id" />
			<s:hidden key="inDate" />
			<s:hidden key="beforeCount" />
			<s:hidden key="article.id" />
			<div class="form-group">
				<label for="article.name" class="control-label col-sm-4 col-lg-offset-1 col-lg-3">
					<s:text name="article.name" />:
				</label>
				<div class="col-sm-7 col-lg-6">
					<div class="input-group">
						<span class="input-group-addon">
							<i class="icon icon-product"></i>
						</span>
						<s:textfield key="article.name" cssClass="form-control" readonly="true" />
					</div>
				</div>
			</div>
			<div class="form-group">
				<label for="article.serialNumber" class="control-label col-sm-4 col-lg-offset-1 col-lg-3">
					<s:text name="serialNumber" />:
				</label>
				<div class="col-sm-7 col-lg-6">
					<s:textfield key="article.serialNumber" cssClass="form-control" readonly="true" />
				</div>
			</div>
			<div class="form-group">
				<label for="article.count" class="control-label col-sm-4 col-lg-offset-1 col-lg-3">
					<s:text name="nowQuantity" />:
				</label>
				<div class="col-sm-7 col-lg-6">
					<s:textfield key="article.count" cssClass="form-control" readonly="true" />
				</div>
			</div>
			<div class="form-group">
				<label for="inReciever" class="control-label col-sm-4 col-lg-offset-1 col-lg-3">
					<s:text name="inReciever.id" />:
				</label>
				<div class="col-sm-7 col-lg-6">
					<div class="input-group">
						<span class="input-group-addon">
							<i class="icon icon-employee"></i>
						</span>
						<s:select list="employees"
								listKey="id"
								listValue="firstName"
								value="%{#session.InputArticle.inReciever.id}"
								key="inReciever.id"
								cssClass="form-control"
								id="inReciever"
								autofocus="" />
					</div>
				</div>
			</div>
			<div class="form-group">
				<label for="addCount" class="control-label col-sm-4 col-lg-offset-1 col-lg-3">
					<s:text name="addCount" />:
				</label>
				<div class="col-sm-7 col-lg-6">
					<s:textfield key="addCount" cssClass="form-control" id="addCount" />
				</div>
			</div>
			<div class="form-group">
				<label for="customer" class="control-label col-sm-4 col-lg-offset-1 col-lg-3">
					<s:text name="customer" />:
				</label>
				<div class="col-sm-7 col-lg-6">
					<div class="input-group">
						<span class="input-group-addon">
							<i class="icon icon-customer"></i>
						</span>
						<s:select list="customers"
								key="customer.id"
								listKey="id"
								listValue="name"
								cssClass="form-control"
								id="customer" />
					</div>
				</div>
			</div>
			<div class="form-group">
				<div class="col-sm-offset-1 col-sm-3 col-lg-offset-2 col-lg-2">
					<a onclick="window.history.back()" class="btn btn-back btn-block">
						<span class="fa fa-arrow-circle-o-left"></span>&nbsp;
						<s:text name="back" />
					</a>
				</div>
				<div class="col-sm-3 col-lg-2">
					<button type="reset" class="btn btn-gray btn-block">
						<span class="fa fa-refresh"></span>&nbsp;
						<s:text name="reset" />
					</button>
				</div>
				<div class="col-sm-4">
					<button type="submit" class="btn btn-success btn-block">
						<span class="fa fa-save"></span>&nbsp;
						<s:text name="save" />
					</button>
				</div>
			</div>
		</s:form>
	</div>
</div>