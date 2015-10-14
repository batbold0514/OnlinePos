<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<div class="hidden" id="page">
	<s:url action="articleListSearch" includeParams="none" />
</div>
<div class="panel panel-search" id="mainPanel">
	<div class="panel-heading">
		<h3 class="panel-title text-center">
			<span class="fa fa-search"></span>&nbsp;
			<s:text name="articleSearch" />
		</h3>
	</div>
	<div class="panel-body">
		<s:form action="articleList" cssClass="form-horizontal" >
			<div class="form-group">
				<label for="articleName" class="control-label col-sm-4 col-lg-offset-1 col-lg-3">
					<s:text name="articleName" />:
				</label>
				<div class="col-sm-7 col-lg-6">
					<div class="input-group">
						<span class="input-group-addon">
							<i class="icon icon-product"></i>
						</span>
						<s:textfield key="articleName" cssClass="form-control focus" id="articleName" />
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
						<s:textfield key="articleBarCode" cssClass="form-control" id="articleBarCode" />
					</div>
				</div>
			</div>
			<div class="form-group">
				<label for="articleColour" class="control-label col-sm-4 col-lg-offset-1 col-lg-3">
					<s:text name="articleColour" />:
				</label>
				<div class="col-sm-7 col-lg-6">
					<div class="input-group">
						<span class="input-group-addon">
							<i class="icon icon-paint"></i>
						</span>
						<s:select list="Colours"
								listKey="code"
								listValue="code +' ' +name"
								key="articleCode"
								headerKey=""
								headerValue=""
								cssClass="form-control"
								id="articleColour" />
					</div>
				</div>
			</div>
			<div class="form-group">
				<label for="articleSize" class="control-label col-sm-4 col-lg-offset-1 col-lg-3">
					<s:text name="articleSize" />:
				</label>
				<div class="col-sm-7 col-lg-6">
					<div class="input-group">
						<span class="input-group-addon">
							<i class="fa fa-crop"></i>
						</span>
						<s:select list="sizes"
								listKey="id"
								listValue="sizes"
								key="articleSize"
								headerKey="-1"
								headerValue=""
								cssClass="form-control"
								id="articleSize" />
					</div>
				</div>
			</div>
			<div class="form-group">
				<label for="articleLocation" class="control-label col-sm-4 col-lg-offset-1 col-lg-3">
					<s:text name="articleLocation" />:
				</label>
				<div class="col-sm-7 col-lg-6">
					<div class="input-group">
						<span class="input-group-addon">
							<i class="fa fa-location-arrow"></i>
						</span>
						<s:select list="locations"
								listKey="id"
								listValue="locationName"
								key="articleLocation"
								headerKey="-1"
								headerValue=""
								cssClass="form-control"
								id="articleLocation" />
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
					<button type="submit" id="search" class="btn btn-success btn-block">
						<span class="fa fa-search"></span>&nbsp;
						<s:text name="search" />
					</button>
				</div>
			</div>
		</s:form>
	</div>
</div>