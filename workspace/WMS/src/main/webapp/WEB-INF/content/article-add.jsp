<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<div class="hidden" id="page">
	<s:url action="inputArticleList" includeParams="none" />
</div>
<div class="panel panel-success" id="mainPanel">
	<div class="panel-heading">
		<h3 class="panel-title text-center">
			<span class="fa fa-download"></span>&nbsp;
			<s:text name="addInputArticle" />
		</h3>
	</div>
	<div class="panel-body">
		<s:form action="addCountArticle" cssClass="form-horizontal">
			<s:hidden key="id" />
			<s:hidden key="count" />
			<s:hidden key="categoryString" value="%{#session.articleAdd.category.id}" />
			<s:hidden key="ownerString" value="%{#session.articleAdd.owner.id}" />
			<s:hidden key="colourString" value="%{#session.articleAdd.colour.id}" />
			<s:hidden key="locationString" value="%{#session.articleAdd.location.id}" />
			<s:hidden key="sizeString" value="%{#session.articleAdd.size.id}" />
			<s:hidden key="minCount" />
			<s:hidden key="buyPrice" />
			<s:hidden key="sellPrice" />
			<s:hidden key="packageWeight" />
			<s:hidden key="moisture" />
			<s:hidden key="serialNumber" />
			<s:hidden key="measuring_unit" />
			<s:hidden key ="measureId" value="%{#session.articleAdd.measure.id}"/>
			<div class="form-group">
				<label for="name" class="control-label col-sm-4 col-lg-offset-1 col-lg-3">
					<s:text name="articleName" />:
				</label>
				<div class="col-sm-7 col-lg-6">
					<div class="input-group">
		  				<span class="input-group-addon input-sm">
		  					<i class="icon icon-product"></i>
		  				</span>
						<s:textfield key="name" cssClass="form-control input-sm" readonly="true" />
					</div>
				</div>
			</div>
			<div class="form-group">
				<label for="barCode" class="control-label col-sm-4 col-lg-offset-1 col-lg-3">
					<s:text name="barCode" />:
				</label>
				<div class="col-sm-7 col-lg-6">
					<div class="input-group">
		  				<span class="input-group-addon input-sm">
		  					<i class="glyphicon glyphicon-barcode"></i>
		  				</span>
						<s:textfield key="barCode" cssClass="form-control input-sm" readonly="true" />
					</div>
				</div>
			</div>
			<div class="form-group">
				<label for="measuring_unit" class="control-label col-sm-4 col-lg-offset-1 col-lg-3">
					<s:text name="measuring_unit" />:
				</label>
				<div class="col-sm-7 col-lg-6">
					<s:property value="measure.measuringUnit" />
				</div>
			</div>
			<div class="form-group">
				<label for="count" class="control-label col-sm-4 col-lg-offset-1 col-lg-3">
					<s:text name="quantity" />:
				</label>
				<div class="col-sm-7 col-lg-6">
					<s:property value="count" />
				</div>
			</div>
			<div class="form-group">
				<label for="addCount" class="control-label col-sm-4 col-lg-offset-1 col-lg-3">
					<s:text name="addCount" />:
				</label>
				<div class="col-sm-7 col-lg-6">
					<s:textfield key="addCount" cssClass="form-control input-sm focus" id="addCount" />
				</div>
			</div>
			<div class="form-group">
				<label for="description" class="control-label col-sm-4 col-lg-offset-1 col-lg-3">
					<s:text name="description" />:
				</label>
				<div class="col-sm-7 col-lg-6">
					<s:textarea key="description" cssClass="form-control input-sm" id="description" />
				</div>
			</div>
			<div class="form-group">
				<div class="row">
					<div class="col-sm-12">
						<label for="inReciever.id" class="control-label col-sm-4 col-lg-offset-1 col-lg-3">
							<s:text name="inReciever.id" />(*):
						</label>
						<div class="col-sm-7 col-lg-6">
							<div class="input-group">
				  				<span class="input-group-addon input-sm">
				  					<i class="icon icon-employee"></i>
				  				</span>
								<s:select list="employeeList"
										listKey="id"
										listValue="firstName"
										key="inReciever.id"
										headerKey="-1"
										headerValue=""
										cssClass="form-control input-sm"
										id="inReciever.id" />
							</div>
						</div>
					</div>
				</div>
				<div class="row">
					<div class="col-sm-offset-4 col-sm-7 col-lg-offset-4 col-lg-6">
						<s:fielderror fieldName="inReciever.id" />
					</div>
				</div>
			</div>
			<div class="form-group">
				<div class="row">
					<div class="col-sm-12">
						<label for="customer" class="control-label col-sm-4 col-lg-offset-1 col-lg-3">
							<s:text name="customer" />:
						</label>
						<div class="col-sm-7 col-lg-6">
							<div class="input-group">
				  				<span class="input-group-addon input-sm">
				  					<i class="icon icon-customer"></i>
				  				</span>
								<s:select list="customers"
										key="customerString"
										listKey="id"
										listValue="name"
										headerKey=""
										headerValue=""
										cssClass="form-control input-sm"
										id="customer" />
							</div>
						</div>
					</div>
					<div class="row">
						<div class="col-sm-offset-4 col-sm-7 col-lg-offset-4 col-lg-6">
							<s:fielderror fieldName="customer" />
						</div>
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
						<span class="fa fa-download"></span>&nbsp;
						<s:text name="doInputArticle" />
					</button>
				</div>
			</div>
		</s:form>
	</div>
</div>