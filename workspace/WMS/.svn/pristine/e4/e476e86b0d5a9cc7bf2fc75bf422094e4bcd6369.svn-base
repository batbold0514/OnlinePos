<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<div class="hidden" id="page">
	<s:url action="articleListSearch" includeParams="none" />
</div>
<div class="panel panel-yellow" id="mainPanel">
	<div class="panel-heading">
		<h3 class="panel-title text-center">
			<span class="fa fa-exchange"></span>&nbsp;
			<s:text name="transferShow" />
		</h3>
	</div>
	<div class="panel-body">
		<s:form action="alltransfer" cssClass="form-horizontal">
			<s:hidden key="id" />
			<s:hidden key="count" />
			<s:hidden key="colourId" value="%{colour.id}" />
			<s:hidden key="writer" />
			<s:hidden key="measuring_unit" />
			<s:hidden key="minCount" />
			<s:hidden key="buyPrice" />
			<s:hidden key="sellPrice" />
			<s:hidden key="locationId" value="%{location.id}" />
			<s:hidden key="ownerId" value="%{owner.id}" />
			<s:hidden key="packageWeight" />
			<s:hidden key="moisture" />
			<s:hidden key="categoryId" value="%{category.id}" />
			<s:hidden key="sizeId" value="%{size.id}" />
			<s:hidden key="partNumber" />
			<s:hidden key="serialNumber" />
			<s:hidden key="description" />
			<s:hidden key="measureId" value = "%{measure.id}"/>
			<div class="form-group">
				<label for="barCode" class="control-label col-sm-4 col-lg-offset-1 col-lg-3">
					<s:text name="barCode" />:
				</label>
				<div class="col-sm-7 col-lg-6">
					<div class="input-group">
  						<span class="input-group-addon">
  							<i class="glyphicon glyphicon-barcode"></i>
  						</span>
						<s:textfield key="barCode" readonly="true" cssClass="form-control" />
					</div>
				</div>
			</div>
			<div class="form-group">
				<label for="name" class="control-label col-sm-4 col-lg-offset-1 col-lg-3">
					<s:text name="articleName" />:
				</label>
				<div class="col-sm-7 col-lg-6">
					<div class="input-group">
  						<span class="input-group-addon">
  							<i class="icon icon-product"></i>
  						</span>
						<s:textfield key="name" readonly="true" cssClass="form-control" />
					</div>
				</div>
			</div>
			<div class="form-group">
				<label for="colour.name" class="control-label col-sm-4 col-lg-offset-1 col-lg-3">
					<s:text name="colour.name" />:
				</label>
				<div class="col-sm-7 col-lg-6">
					<s:textfield key="colourName" value="%{colour.name}" cssClass="form-control" readonly="true" />
				</div>
			</div>

			<div class="form-group">
				<label for="colour.code" class="control-label col-sm-4 col-lg-offset-1 col-lg-3">
					<s:text name="ColourCode" />:
				</label>
				<div class="col-sm-7 col-lg-6">
					<s:textfield key="colourCode" value="%{colour.code}" cssClass="form-control" readonly="true" />
				</div>
			</div>
			<div class="form-group">
				<label for="size.sizes" class="control-label col-sm-4 col-lg-offset-1 col-lg-3">
					<s:text name="size.sizes" />:
				</label>
				<div class="col-sm-7 col-lg-6">
					<div class="input-group">
  						<span class="input-group-addon">
  							<i class="fa fa-crop"></i>
  						</span>
						<s:textfield key="sizes" value="%{size.sizes}" cssClass="form-control" readonly="true" />
					</div>
				</div>
			</div>
			<div class="form-group">
				<label for="location.locationName" class="control-label col-sm-4 col-lg-offset-1 col-lg-3">
					<s:text name="location.locationName" />:
				</label>
				<div class="col-sm-7 col-lg-6">
					<div class="input-group">
  						<span class="input-group-addon">
  							<i class="fa fa-location-arrow"></i>
  						</span>
						<s:textfield key="locationLocationName" value="%{location.locationName}" cssClass="form-control" readonly="true" />
						<span class="input-group-addon">
  							<i class="fa fa-flag"></i>
  						</span>
					</div>
				</div>
			</div>
			<div class="form-group">
				<label for="changeLocation" class="control-label col-sm-4 col-lg-offset-1 col-lg-3">
					<s:text name="changeLocation.id" />:
				</label>
				<div class="col-sm-7 col-lg-6">
					<div class="input-group">
  						<span class="input-group-addon">
  							<i class="fa fa-location-arrow"></i>
  						</span>
						<s:select key="changeLocation"
								list="locationWnsShow"
								listKey="id"
								listValue="locationName"
								cssClass="form-control focus"
								id="changeLocation" />
						<span class="input-group-addon">
  							<i class="fa fa-random"></i>
  						</span>
					</div>
				</div>
			</div>
			<div class="form-group">
				<div class="row">
					<div class="col-sm-12">
						<label for="changeCount" class="control-label col-sm-4 col-lg-offset-1 col-lg-3">
							<s:text name="changeCount" />:
						</label>
						<div class="col-sm-7 col-lg-6">
							<s:textfield key="changeCount" value="%{#session.article.count}" cssClass="form-control" id="changeCount" />
						</div>
					</div>
				</div>
				<div class="row">
					<div class="col-sm-offset-4 col-sm-7 col-lg-offset-4 col-lg-6">
						<s:fielderror fieldName="changeCount" />
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
					<button type="submit" id="saveColour" class="btn btn-success btn-block">
						<span class="fa fa-exchange"></span>&nbsp;
						<s:text name="transferVerb" />
					</button>
				</div>
			</div>
		</s:form>
	</div>
</div>