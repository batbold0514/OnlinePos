<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<div class="hidden" id="page">
	<s:url action="inputArticleList" includeParams="none" />
</div>
<div class="panel panel-warning" id="mainPanel">
	<div class="panel-heading">
		<h3 class="panel-title text-center">
			<span class="fa fa-download"></span>&nbsp;
			<s:text name="inputArticleEdit" />
		</h3>
	</div>
	<div class="panel-body">
		<s:form action="editArticleSave" cssClass="form-horizontal">
			<fieldset>
				<legend class="text-center col-sm-offset-4 col-sm-7 col-lg-offset-4 col-lg-6">
					<s:property value="%{#session.categoryInArticle.name}" />:
				</legend>
				<s:hidden key="id" />
				<s:hidden key="writer" value="%{user}" />
				<s:hidden key="categoryString" value="%{#session.categoryInArticle.id}" />
				<s:if test="%{#session.categoryInArticle.owner == 'true'}">
					<div class="form-group">
						<div class="row">
							<div class="col-sm-12">
								<label for="ownerString" class="control-label col-sm-4 col-lg-offset-1 col-lg-3">
									<s:text name="ownerString" />(*):
								</label>
								<div class="col-sm-7 col-lg-6">
									<div class="input-group">
		  								<span class="input-group-addon input-sm">
		  									<i class="icon icon-employee"></i>
		  								</span>
										<s:select list="employeeList"
												listKey="id"
												listValue="firstName"
												headerKey=""
												headerValue=""
												key="ownerString"
												cssClass="form-control input-sm focus"
												id="ownerString" />
									</div>
								</div>
							</div>
						</div>
						<div class="row">
							<div class="col-sm-offset-4 col-sm-7 col-lg-offset-4 col-lg-6">
								<s:fielderror fieldName="ownerString" />
							</div>
						</div>
					</div>
				</s:if>
				<s:if test="%{#session.categoryInArticle.article_name == 'true'}">
					<div class="form-group">
						<div class="row">
							<div class="col-sm-12">
								<label for="name" class="control-label col-sm-4 col-lg-offset-1 col-lg-3">
									<s:text name="articleName" />(*):
								</label>
								<div class="col-sm-7 col-lg-6">
									<div class="input-group">
		  								<span class="input-group-addon input-sm">
		  									<i class="icon icon-product"></i>
		  								</span>
										<s:textfield key="name" cssClass="form-control input-sm" id="name" />
									</div>
								</div>
							</div>
						</div>
						<div class="row">
							<div class="col-sm-offset-4 col-sm-7 col-lg-offset-4 col-lg-6">
								<s:fielderror fieldName="name" />
							</div>
						</div>
					</div>
				</s:if>
				<s:if test="%{#session.categoryInArticle.barCode == 'true'}">
					<div class="form-group">
						<div class="row">
							<div class="col-sm-12">
								<label for="barCode" class="control-label col-sm-4 col-lg-offset-1 col-lg-3">
									<s:text name="barCode" />(*):
								</label>
								<div class="col-sm-7 col-lg-6">
									<div class="input-group">
		  								<span class="input-group-addon input-sm">
		  									<i class="glyphicon glyphicon-barcode"></i>
		  								</span>
										<s:textfield key="barCode" cssClass="form-control input-sm" id="barCode" />
									</div>
								</div>
							</div>
						</div>
						<div class="row">
							<div class="col-sm-offset-4 col-sm-7 col-lg-offset-4 col-lg-6">
								<s:fielderror fieldName="barCode" />
							</div>
						</div>
					</div>
				</s:if>
				<s:if test="%{#session.categoryInArticle.serial == 'true'}">
					<div class="form-group">
						<div class="row">
							<div class="col-sm-12">
								<label for="serialNumber" class="control-label col-sm-4 col-lg-offset-1 col-lg-3">
									<s:text name="serialNumber" />:
								</label>
								<div class="col-sm-7 col-lg-6">
									<s:textfield key="serialNumber" cssClass="form-control input-sm" id="serialNumber" />
								</div>
							</div>
						</div>
						<div class="row">
							<div class="col-sm-offset-4 col-sm-7 col-lg-offset-4 col-lg-6">
								<s:fielderror fieldName="serialNumber" />
							</div>
						</div>
					</div>
				</s:if>
				<s:if test="%{#session.categoryInArticle.count == 'true'}">
					<div class="form-group">
						<div class="row">
							<div class="col-sm-12">
								<label for="count" class="control-label col-sm-4 col-lg-offset-1 col-lg-3">
									<s:text name="quantity" />(*):
								</label>
								<div class="col-sm-7 col-lg-6">
									<s:textfield key="count" title="Бүхэл тоо оруулна" cssClass="form-control input-sm" id="count" />
								</div>
							</div>
						</div>
						<div class="row">
							<div class="col-sm-offset-4 col-sm-7 col-lg-offset-4 col-lg-6">
								<s:fielderror fieldName="count" />
							</div>
						</div>
					</div>
				</s:if>
				<s:if test="%{#session.categoryInArticle.measuring_unit == 'true'}">
					<div class="form-group">
						<div class="row">
							<div class="col-sm-12">
								<label for="measuring_unit" class="control-label col-sm-4 col-lg-offset-1 col-lg-3">
									<s:text name="measuring_unit" />(*):
								</label>
								<div class="col-sm-7 col-lg-6">
									<div class="input-group">
		  								<span class="input-group-addon input-sm">
		  									<i class="icon icon-scale"></i>
		  								</span>
										<s:select key="unitString"
												list="measures"
												listValue="measuringUnit"
												listKey="id"
												headerKey="-1"
												headerValue=""
												cssClass="form-control input-sm"
												id="measuring_unit"
												required="" />
									</div>
								</div>
							</div>
						</div>
						<div class="row">
							<div class="col-sm-offset-4 col-sm-7 col-lg-offset-4 col-lg-6">
								<s:fielderror fieldName="measuring_unit" />
							</div>
						</div>
					</div>
				</s:if>
				<s:if test="%{#session.categoryInArticle.minCount == 'true'}">
					<div class="form-group">
						<div class="row">
							<div class="col-sm-12">
								<label for="minCount" class="control-label col-sm-4 col-lg-offset-1 col-lg-3">
									<s:text name="minCount" />(*):
								</label>
								<div class="col-sm-7 col-lg-6">
									<s:textfield key="minCount" cssClass="form-control input-sm" id="minCount" required="" />
								</div>
							</div>
						</div>
						<div class="row">
							<div class="col-sm-offset-4 col-sm-7 col-lg-offset-4 col-lg-6">
								<s:fielderror fieldName="minCount" />
							</div>
						</div>
					</div>
				</s:if>
				<s:if test="%{#session.categoryInArticle.packageWeight == 'true'}">
					<div class="form-group">
						<div class="row">
							<div class="col-sm-12">
								<label for="packageWeight" class="control-label col-sm-4 col-lg-offset-1 col-lg-3">
									<s:text name="packageWeight" />:
								</label>
								<div class="col-sm-7 col-lg-6">
									<s:textfield key="packageWeight" cssClass="form-control input-sm" id="packageWeight" />
								</div>
							</div>
						</div>
						<div class="row">
							<div class="col-sm-offset-4 col-sm-7 col-lg-offset-4 col-lg-6">
								<s:fielderror fieldName="packageWeight" />
							</div>
						</div>
					</div>
				</s:if>
				<s:if test="%{#session.categoryInArticle.buyPrice == 'true'}">
					<div class="form-group">
						<div class="row">
							<div class="col-sm-12">
								<label for="buyPrice" class="control-label col-sm-4 col-lg-offset-1 col-lg-3">
									<s:text name="buyPrice" />:
								</label>
								<div class="col-sm-7 col-lg-6">
									<s:textfield key="buyPrice" cssClass="form-control input-sm" id="buyPrice" />
								</div>
							</div>
						</div>
						<div class="row">
							<div class="col-sm-offset-4 col-sm-7 col-lg-offset-4 col-lg-6">
								<s:fielderror fieldName="buyPrice" />
							</div>
						</div>
					</div>
				</s:if>
				<s:if test="%{#session.categoryInArticle.sellPrice == 'true'}">
					<div class="form-group">
						<div class="row">
							<div class="col-sm-12">
								<label for="sellPrice" class="control-label col-sm-4 col-lg-offset-1 col-lg-3">
									<s:text name="sellPrice" />:
								</label>
								<div class="col-sm-7 col-lg-6">
									<s:textfield key="sellPrice" cssClass="form-control input-sm" id="sellPrice" />
								</div>
							</div>
						</div>
						<div class="row">
							<div class="col-sm-offset-4 col-sm-7 col-lg-offset-4 col-lg-6">
								<s:fielderror fieldName="sellPrice" />
							</div>
						</div>
					</div>
				</s:if>
				<div class="form-group">
					<div class="row">
						<div class="col-sm-12">
							<label for="locationString" class="control-label col-sm-4 col-lg-offset-1 col-lg-3">
								<s:text name="locationString" />:
							</label>
							<div class="col-sm-7 col-lg-6">
								<div class="input-group">
		  							<span class="input-group-addon input-sm">
		  								<i class="fa fa-location-arrow"></i>
		  							</span>
									<s:select key="locationString"
											list="locationWms"
											listKey="id"
											listValue="locationName"
											headerKey=""
											headerValue=" "
											cssClass="form-control input-sm"
											id="locationString" />
								</div>
							</div>
						</div>
					</div>
					<div class="row">
						<div class="col-sm-offset-4 col-sm-7 col-lg-offset-4 col-lg-6">
							<s:fielderror fieldName="locationString" />
						</div>
					</div>
				</div>
				<s:if test="%{#session.categoryInArticle.article_size == 'true'}">
					<div class="form-group">
						<div class="row">
							<div class="col-sm-12">
								<label for="sizeString" class="control-label col-sm-4 col-lg-offset-1 col-lg-3">
									<s:text name="sizeString" />:
								</label>
								<div class="col-sm-7 col-lg-6">
									<s:select key="sizeString"
											list="sizes"
											listValue="sizes"
											listKey="id"
											headerKey=""
											headerValue=""
											cssClass="form-control input-sm"
											id="sizeString" />
								</div>
							</div>
						</div>
						<div class="row">
							<div class="col-sm-offset-4 col-sm-7 col-lg-offset-4 col-lg-6">
								<s:fielderror fieldName="sizeString" />
							</div>
						</div>
					</div>
				</s:if>
				<s:if test="%{#session.categoryInArticle.colour == 'true'}">
					<div class="form-group">
						<div class="row">
							<div class="col-sm-12">
								<label for="colourString" class="control-label col-sm-4 col-lg-offset-1 col-lg-3">
									<s:text name="colourString" />:
								</label>
								<div class="col-sm-7 col-lg-6">
									<s:select key="colourString"
											list="colours"
											listValue="code +' '+name"
											listKey="id"
											headerKey=""
											headerValue=""
											cssClass="form-control input-sm"
											id="colourString" />
								</div>
							</div>
						</div>
						<div class="row">
							<div class="col-sm-offset-4 col-sm-7 col-lg-offset-4 col-lg-6">
								<s:fielderror fieldName="colourString" />
							</div>
						</div>
					</div>
				</s:if>
				<s:if test="%{#session.categoryInArticle.partNumber == 'true'}">
					<div class="form-group">
						<div class="row">
							<div class="col-sm-12">
								<label for="partNumber" class="control-label col-sm-4 col-lg-offset-1 col-lg-3">
									<s:text name="partNumber" />:
								</label>
								<div class="col-sm-7 col-lg-6">
									<s:textfield key="partNumber" cssClass="form-control input-sm" id="partNumber" />
								</div>
							</div>
						</div>
						<div class="row">
							<div class="col-sm-offset-4 col-sm-7 col-lg-offset-4 col-lg-6">
								<s:fielderror fieldName="partNumber" />
							</div>
						</div>
					</div>
				</s:if>
				<s:if test="%{#session.categoryInArticle.moisture == 'true'}">
					<div class="form-group">
						<div class="row">
							<div class="col-sm-12">
								<label for="moisture" class="control-label col-sm-4 col-lg-offset-1 col-lg-3">
									<s:text name="moisture" />:
								</label>
								<div class="col-sm-7 col-lg-6">
									<s:textfield key="moisture" cssClass="form-control input-sm" id="moisture" />
								</div>
							</div>
						</div>
						<div class="row">
							<div class="col-sm-offset-4 col-sm-7 col-lg-offset-4 col-lg-6">
								<s:fielderror fieldName="moisture" />
							</div>
						</div>
					</div>
				</s:if>
				<s:if test="%{#session.categoryInArticle.description == 'true'}">
					<div class="form-group">
						<div class="row">
							<div class="col-sm-12">
								<label for="description" class="control-label col-sm-4 col-lg-offset-1 col-lg-3">
									<s:text name="description" />:
								</label>
								<div class="col-sm-7 col-lg-6">
									<s:textarea key="description" cssClass="form-control input-sm" id="description" />
								</div>
							</div>
						</div>
						<div class="row">
							<div class="col-sm-offset-4 col-sm-7 col-lg-offset-4 col-lg-6">
								<s:fielderror fieldName="desrription" />
							</div>
						</div>
					</div>
				</s:if>
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
							<span class="fa fa-save"></span>&nbsp;
							<s:text name="save" />
						</button>
					</div>
				</div>
			</fieldset>
		</s:form>
	</div>
</div>