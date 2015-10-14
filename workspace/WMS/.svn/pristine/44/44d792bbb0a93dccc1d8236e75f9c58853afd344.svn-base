<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<div class="hidden" id="page">
	<s:url action="inputArticleList" includeParams="none" />
</div>
<div class="panel panel-info" id="mainPanel">
	<div class="panel-heading">
		<h3 class="panel-title text-center">
			<span class="fa fa-download"></span>&nbsp;
			<s:text name="inputArticleShow" />
		</h3>
	</div>
	<div class="panel-body">
		<s:form cssClass="form-horizontal">
			<div class="form-group">
				<label for="articleName" class="control-label col-sm-4 col-lg-offset-1 col-lg-3">
					<s:text name="articleName" />:
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
				<label for="articleBarCode" class="control-label col-sm-4 col-lg-offset-1 col-lg-3">
					<s:text name="articleBarCode" />:
				</label>
				<div class="col-sm-7 col-lg-6">
					<div class="input-group">
						<span class="input-group-addon">
							<i class="glyphicon glyphicon-barcode"></i>
						</span>
						<s:textfield key="article.barCode" cssClass="form-control" readonly="true" />
					</div>
				</div>
			</div>
			<div class="form-group">
				<label for="articleColour" class="control-label col-sm-4 col-lg-offset-1 col-lg-3">
					<s:text name="inDate" />:
				</label>
				<div class="col-sm-7 col-lg-6">
					<div class="input-group">
						<span class="input-group-addon">
							<i class="fa fa-calendar"></i>
						</span>
						<s:textfield key="inDate" cssClass="form-control" readonly="true" />
						<span class="input-group-addon">
							<i class="fa fa-clock-o"></i>
						</span>
					</div>
				</div>
			</div>
			<div class="form-group">
				<label for="inReciever.id" class="control-label col-sm-4 col-lg-offset-1 col-lg-3">
					<s:text name="inReciever.id" />:
				</label>
				<div class="col-sm-7 col-lg-6">
					<div class="input-group">
						<span class="input-group-addon">
							<i class="icon icon-employee"></i>
						</span>
						<s:textfield key="inReciever.firstName" cssClass="form-control" readonly="true" />
					</div>
				</div>
			</div>
			<div class="form-group">
				<label for="addCountShow" class="control-label col-sm-4 col-lg-offset-1 col-lg-3">
					<s:text name="addCountShow" />:
				</label>
				<div class="col-sm-7 col-lg-6">
					<div class="input-group">
						<span class="input-group-addon">
							<i class="fa fa-plus"></i>&nbsp;
						</span>
						<s:textfield key="addCount" cssClass="form-control" readonly="true" />
					</div>
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
								disabled="true" />
					</div>
				</div>
			</div>
			<%-- <div class="form-group">
				<label for="articleLocation" class="control-label col-sm-4 col-lg-offset-1 col-lg-3">
					<s:text name="writer" />:
				</label>
				<div class="col-sm-7 col-lg-6">
					<div class="input-group">
						<span class="input-group-addon"> <i
							class="icon icon-product"></i>
						</span>
						<s:textfield key="writer" cssClass="form-control" readonly="true"/>
					</div>
				</div>
			</div> --%>
			<div class="form-group">
				<div class="col-sm-offset-1 col-sm-3 col-lg-offset-2 col-lg-2">
					<a onclick="window.history.back()" class="btn btn-back btn-block">
						<span class="fa fa-arrow-circle-o-left"></span>&nbsp;
						<s:text name="back" />
					</a>
				</div>
				<div class="col-sm-5 col-md-4 col-lg-3">
					<a href="showArticle?model.id=${article.id}" class="btn btn-info btn-block focus">
						<span class="fa fa-eye"></span>&nbsp;
						<s:text name="articleShow" />
					</a>
				</div>
			</div>
		</s:form>
	</div>
</div>