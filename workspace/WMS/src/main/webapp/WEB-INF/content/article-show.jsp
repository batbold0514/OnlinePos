<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<div class="hidden" id="page">
	<s:url action="articleListSearch" includeParams="none" />
</div>
<div class="panel panel-info" id="mainPanel">
	<div class="panel-heading">
		<h3 class="panel-title text-center">
			<span class="icon icon-product"></span>&nbsp;
			<s:text name="article" />
		</h3>
	</div>
	<div class="panel-body">
		<s:form cssClass="form-horizontal">
			<fieldset>
				<legend class="text-center col-sm-offset-4 col-sm-7 col-lg-offset-4 col-lg-6">
					<s:property value="name" />:
				</legend>
				<s:hidden key="id" />
				<s:hidden key="writer" value="%{user}" />
				<s:hidden key="categoryString" value="%{#session.categoryInArticle.id}" />
				<s:if test="%{owner != null}">
					<div class="form-group">
						<label for="ownerString" class="control-label col-sm-4 col-lg-offset-1 col-lg-3">
							<s:text name="ownerString" />:
						</label>
						<div class="col-sm-7 col-lg-6">
							<div class="input-group">
  								<span class="input-group-addon input-sm">
  									<i class="icon icon-employee"></i>
  								</span>
								<s:textfield key="owner.firstName" cssClass="form-control input-sm" disabled="true" />
							</div>
						</div>
					</div>
				</s:if>
				<s:if test="%{name != null}">
					<div class="form-group">
						<label for="name" class="control-label col-sm-4 col-lg-offset-1 col-lg-3">
							<s:text name="articleName" />:
						</label>
						<div class="col-sm-7 col-lg-6">
							<div class="input-group">
  								<span class="input-group-addon input-sm">
  									<i class="icon icon-product"></i>
  								</span>
								<s:textfield key="name" cssClass="form-control input-sm" disabled="true" />
							</div>
						</div>
					</div>
				</s:if>
				<s:if test="%{serialNumber != null}">
					<div class="form-group">
						<label for="serialNumber" class="control-label col-sm-4 col-lg-offset-1 col-lg-3">
							<s:text name="serialNumber" />:
						</label>
						<div class="col-sm-7 col-lg-6">
							<s:textfield key="serialNumber" cssClass="form-control input-sm" disabled="true" />
						</div>
					</div>
				</s:if>
				<s:if test="%{count != null}">
					<div class="form-group">
						<label for="count" class="control-label col-sm-4 col-lg-offset-1 col-lg-3">
							<s:text name="quantity" />:
						</label>
						<div class="col-sm-7 col-lg-6">
							<s:textfield key="count" cssClass="form-control input-sm" disabled="true" />
						</div>
					</div>
				</s:if>
				<s:if test="%{measure != null}">
					<div class="form-group">
						<label for="measuring_unit" class="control-label col-sm-4 col-lg-offset-1 col-lg-3">
							<s:text name="measuring_unit" />:
						</label>
						<div class="col-sm-7 col-lg-6">
							<div class="input-group">
  								<span class="input-group-addon input-sm">
  									<i class="icon icon-scale"></i>
  								</span>
								<s:select key="measure.id"
										list="measures"
										listValue="measuringUnit"
										listKey="id"
										disabled="true"
										cssClass="form-control input-sm" />
							</div>
						</div>
					</div>
				</s:if>
				<s:if test="%{minCount != null}">
					<div class="form-group">
						<label for="minCount" class="control-label col-sm-4 col-lg-offset-1 col-lg-3">
							<s:text name="minCount" />:
						</label>
						<div class="col-sm-7 col-lg-6">
							<s:textfield key="minCount" cssClass="form-control input-sm" disabled="true" />
						</div>
					</div>
				</s:if>
				<s:if test="%{packageWeight != null}">
					<div class="form-group">
						<label for="packageWeight" class="control-label col-sm-4 col-lg-offset-1 col-lg-3">
							<s:text name="packageWeight" />:
						</label>
						<div class="col-sm-7 col-lg-6">
							<s:textfield key="packageWeight" cssClass="form-control input-sm" disabled="true" />
						</div>
					</div>
				</s:if>
				<s:if test="%{buyPrice != null}">
					<div class="form-group">
						<label for="buyPrice" class="control-label col-sm-4 col-lg-offset-1 col-lg-3">
							<s:text name="buyPrice" />:
						</label>
						<div class="col-sm-7 col-lg-6">
							<s:textfield key="buyPrice" cssClass="form-control input-sm" disabled="true" />
						</div>
					</div>
				</s:if>
				<s:if test="%{sellPrice != null}">
					<div class="form-group">
						<label for="sellPrice" class="control-label col-sm-4 col-lg-offset-1 col-lg-3">
							<s:text name="sellPrice" />:
						</label>
						<div class="col-sm-7 col-lg-6">
							<s:textfield key="sellPrice" cssClass="form-control input-sm" disabled="true" />
						</div>
					</div>
				</s:if>
				<div class="form-group">
					<label for="locationString" class="control-label col-sm-4 col-lg-offset-1 col-lg-3">
						<s:text name="locationString" />:
					</label>
					<div class="col-sm-7 col-lg-6">
						<div class="input-group">
  							<span class="input-group-addon input-sm">
  								<i class="fa fa-location-arrow"></i>
  							</span>
							<s:select key="location.id"
									list="locationWms"
									listKey="id"
									listValue="locationName"
									cssClass="form-control input-sm"
									disabled="true" />
						</div>
					</div>
				</div>
				<s:if test="%{size != null}">
					<div class="form-group">
						<label for="sizeString" class="control-label col-sm-4 col-lg-offset-1 col-lg-3">
							<s:text name="sizeString" />:
						</label>
						<div class="col-sm-7 col-lg-6">
							<div class="input-group">
  								<span class="input-group-addon input-sm">
  									<i class="fa fa-crop"></i>
  								</span>
								<s:select key="size.id"
										list="sizes"
										listValue="sizes"
										listKey="id"
										disabled="true"
										cssClass="form-control input-sm" />
							</div>
						</div>
					</div>
				</s:if>
				<s:if test="%{colour != null}">
					<div class="form-group">
						<label for="colourString" class="control-label col-sm-4 col-lg-offset-1 col-lg-3">
							<s:text name="colourString" />:
						</label>
						<div class="col-sm-7 col-lg-6">
							<div class="input-group">
  								<span class="input-group-addon input-sm">
  									<i class="icon icon-paint"></i>
  								</span>
								<s:select key="colourString"
										list="colours"
										listValue="code +' '+name"
										listKey="id"
										disabled="true"
										cssClass="form-control input-sm" />
							</div>
						</div>
					</div>
				</s:if>
				<s:if test="%{partNumber != null}">
					<div class="form-group">
						<label for="partNumber" class="control-label col-sm-4 col-lg-offset-1 col-lg-3">
							<s:text name="partNumber" />:
						</label>
						<div class="col-sm-7 col-lg-6">
							<s:textfield key="partNumber" disabled="true" cssClass="form-control input-sm" />
						</div>
					</div>
				</s:if>
				<s:if test="%{moisture != null}">
					<div class="form-group">
						<label for="moisture" class="control-label col-sm-4 col-lg-offset-1 col-lg-3">
							<s:text name="moisture" />:
						</label>
						<div class="col-sm-7 col-lg-6">
							<div class="input-group">
  								<span class="input-group-addon input-sm">
  									&nbsp;<i class="fa fa-tint"></i>
  								</span>
								<s:textfield key="moisture" cssClass="form-control input-sm" disabled="true" />
							</div>
						</div>
					</div>
				</s:if>
				<s:if test="%{barCode != null}">
					<div class="form-group">
						<label for="barCode" class="control-label col-sm-4 col-lg-offset-1 col-lg-3">
							<s:text name="barCode" />:
						</label>
						<div class="col-sm-7 col-lg-6">
							<div class="input-group">
  								<span class="input-group-addon input-sm">
  									<i class="glyphicon glyphicon-barcode"></i>
  								</span>
								<s:textfield key="barCode" disabled="true" cssClass="form-control input-sm" />
							</div>
						</div>
					</div>
				</s:if>
				<s:if test="%{description != null}">
					<div class="form-group">
						<label for="description" class="control-label col-sm-4 col-lg-offset-1 col-lg-3">
							<s:text name="description" />:
						</label>
						<div class="col-sm-7 col-lg-6">
							<s:textarea key="description" disabled="true" cssClass="form-control input-sm" />
						</div>
					</div>
				</s:if>
				<div class="form-group">
					<label for="inReciever.id" class="control-label col-sm-4 col-lg-offset-1 col-lg-3">
						<s:text name="inReciever.id" />:
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
									cssClass="form-control input-sm"
									disabled="true" />
						</div>
					</div>
				</div>
				<div class="form-group">
					<label for="fromSb" class="control-label col-sm-4 col-lg-offset-1 col-lg-3">
						<s:text name="fromSb" />:
					</label>
					<div class="col-sm-7 col-lg-6">
						<s:textfield key="fromSb" disabled="true" cssClass="form-control input-sm" />
					</div>
				</div>
				<div class="form-group">
					<div class="col-sm-3 col-md-offset-1 col-md-2 col-lg-offset-2 col-lg-2">
						<a onclick="window.history.back()" class="btn btn-back btn-block">
							<span class="fa fa-arrow-circle-o-left"></span>
							<s:text name="back" />
						</a>
					</div>
					<div class="col-sm-3 col-lg-2">
						<a href="outputArticle?model.id=${id}" class="btn btn-danger btn-block">
							<span class="fa fa-upload"></span>
							<s:text name="OutputArticle" />
						</a>
					</div>
					<div class="col-sm-3 col-lg-2">
						<a href="transfer-part?model.id=${id}" class="btn btn-yellow btn-block">
							<span class="fa fa-exchange"></span>
							<s:text name="transfer" />
						</a>
					</div>
					<div class="col-sm-3 col-lg-2">
						<a href="addArticle?model.id=${id}" class="btn btn-success btn-block">
							<span class="fa fa-download"></span>
							<s:text name="InputArticle" />
						</a>
					</div>
				</div>
			</fieldset>
		</s:form>
	</div>
</div>