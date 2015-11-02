<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="display" uri="http://displaytag.sf.net"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="row">
	<div class="col-md-12">
		<h3 class="page-title">
			<s:text name="maxPrices" />
		</h3>
	</div>
	<div class="portlet box blue">
		<div class="portlet-title">
			<div class="caption">
				<i class="fa fa-tags"> <s:text name="maxPrices" /></i>
			</div>
			<div class="tools">
				<a href="javascript:;" class="collapse"></a>
			</div>
		</div>
		<div class="portlet-body">
			<div class="table-toolbar">
				<div class="btn-group">
					<%-- <button class="btn green" style="border-radius: 4rem" id="btnAdd">
						<s:text name="add" />
						<i class="fa fa-plus"></i>
					</button> --%>
					<button class="btn yellow" id="btnEdit">
						<s:text name="edit" />
						<i class="fa fa-edit"></i>
					</button>
					<button class="btn blue" id="btnShow">
						<s:text name="show" />
						<i class="fa fa-eye"></i>
					</button>
				</div>
			</div>
			<div id="list-result">
				<display:table name="listOfMaxPrice" id="maxPriceTable"
					class="display table-hover table-bordered">
					<display:column property="id" title="ID" />
					<display:column property="maxPrice" title="Тоо" />
				</display:table>
			</div>
		</div>
	</div>
</div>
	<div id="dialog-show" class="hide">
				<form action="#">
					<div class="form-body">
						<s:hidden key="id" />
						<div class="form-group">
							<div class="row">
								<div class="col-sm-12">
									<label for="maxPrice" class="control-label col-sm-5 col-lg-5">
										<s:text name="maxPrice" />:
									</label>
									<div class="col-sm-7 col-lg-6">
										<s:textfield name="maxPrice" cssClass="form-control"
											autofocus=""  disabled="true"/>
									</div>
								</div>
							</div>
						</div>
					</div>
				</form>
	</div>
<div id="dialog-addnew" class="hide">
	<form action="#" id="addform">
		<div class="form-body">
			<s:hidden key="id" />
			<div class="form-group">
				<div class="row">
					<div class="col-sm-12">
						<label for="maxPrice" class="control-label col-sm-5 col-lg-5">
							<s:text name="maxPrice" />:
						</label>
						<div class="col-sm-7 col-lg-6">
							<s:textfield name="maxPrice" cssClass="form-control" autofocus="" id = "maxPriceFrom"/>
						</div>
					</div>
				</div>
			</div>
		</div>
		<input type="submit" id = "submitOk" class ="hide"/>
	</form>
</div>
<div id = 'parseResult' class = "hidden"></div>
<script src="../js/PageJS/maxPrice.js"></script>