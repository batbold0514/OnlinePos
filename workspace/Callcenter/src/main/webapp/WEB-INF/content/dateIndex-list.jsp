<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="display" uri="http://displaytag.sf.net"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<div class="row">
	<div class="col-md-12">
		<h3 class="page-title">
			<s:text name="dateIndexs" />
		</h3>
	</div>
	<div class="portlet box blue">
		<div class="portlet-title">
			<div class="caption">
				<i class="fa fa-tags"> <s:text name="dateIndexs" /></i>
			</div>
			<div class="tools">
				<a href="javascript:;" class="collapse"></a>
			</div>
		</div>
		<div class="portlet-body">
			<div class="table-toolbar">
				<div class="btn-group">
					<button class="btn green" style="border-radius: 4rem" id="btnAdd">
						<s:text name="add" />
						<i class="fa fa-plus"></i>
					</button>
					<button class="btn yellow" id="btnEdit">
						<s:text name="edit" />
						<i class="fa fa-edit"></i>
					</button>
					<button class="btn blue" id="btnShow">
						<s:text name="show" />
						<i class="fa fa-eye"></i>
					</button>
					<button class="btn red" id="btnDelete">
						<s:text name="delete" />
						<i class="fa fa-trash-o"></i>
					</button>
				</div>
				<div class="make-switch" data-on-label="&nbsp;Идэвхтэй&nbsp;"
					data-off-label="&nbsp;Идэвхгүй&nbsp;">
					<s:checkbox name="statusStr" cssClass="toggle" id="statusSwitch"/>
				</div>
				<%-- <div class="btn-group pull-right">
					<button class="btn dropdown-toggle" data-toggle="dropdown">
						<s:text name="tools"></s:text>
						<i class="fa fa-angle-down"></i>
					</button>
					<div class="tools"></div>
					<ul class="dropdown-menu pull-right">
						<li><a href="#"><s:text name="print" /></a></li>
						<li><a class="default DTTT_button_print" href="#"><s:text
									name="savepdf" /></a></li>
						<li><a href="#"><s:text name="excel" /></a></li>
					</ul>
				</div> --%>
			</div>
			<div id="list-result">
				<display:table name="listOfDateIndex" id="dateIndexTable"
					class="display table-hover table-bordered">
					<display:column property="id" title="ID" />
					<display:column property="min" title="Доод хэмжээ" />
					<display:column property="max" title="Дээд хэмжээ" />
					<display:column property="date_index" title="Индекс" />
					
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
									<label for="min" class="control-label col-sm-5 col-lg-5">
										<s:text name="min" />:
									</label>
									<div class="col-sm-7 col-lg-6">
										<s:textfield name="min" cssClass="form-control"
											autofocus="" disabled="true" />
									</div>
								</div>
							</div>
						</div>
						<div class="form-group">
							<div class="row">
								<div class="col-sm-12">
									<label for="max" class="control-label col-sm-5 col-lg-5">
										<s:text name="max" />:
									</label>
									<div class="col-sm-7 col-lg-6">
										<s:textfield name="max" cssClass="form-control"
											autofocus="" disabled="true" />
									</div>
								</div>
							</div>
						</div>
						<div class="form-group">
							<div class="row">
								<div class="col-sm-12">
									<label for="date_index"
										class="control-label col-sm-5 col-lg-5"> <s:text
											name="date_index" />:
									</label>
									<div class="col-sm-7 col-lg-6">
										<s:textfield name="date_index" cssClass="form-control"
											id="description" autofocus="" disabled="true" />
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
						<label for="min" class="control-label col-sm-5 col-lg-5">
							<s:text name="min" /><span class="required"> * </span>
						</label>
						<div class="col-sm-7 col-lg-6">
							<s:textfield name="min" cssClass="form-control" autofocus="" id = "minFrom"/>
						</div>
					</div>
				</div>
			</div>
			<div class="form-group">
				<div class="row">
					<div class="col-sm-12">
						<label for="max" class="control-label col-sm-5 col-lg-5">
							<s:text name="max" /><span class="required"> * </span>
						</label>
						<div class="col-sm-7 col-lg-6">
							<s:textfield name="max" cssClass="form-control" autofocus="" id = "maxFrom"/>
						</div>
					</div>
				</div>
			</div>
			<div class="form-group">
				<div class="row">
					<div class="col-sm-12">
						<label for="date_index" class="control-label col-sm-5 col-lg-5">
							<s:text name="date_index" />:
						</label>
						<div class="col-sm-7 col-lg-6">
							<s:textfield name="date_index" cssClass="form-control"autofocus=""/>
						</div>
					</div>
				</div>
			</div>
		</div>
		<input type="submit" id = "submitOk" class ="hide"/>
	</form>
</div>
<div id = 'parseResult' class = "hidden"></div>
<script src="../js/PageJS/dateIndexList.js"></script>