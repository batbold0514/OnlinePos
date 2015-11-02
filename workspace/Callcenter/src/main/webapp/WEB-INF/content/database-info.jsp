<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="display" uri="http://displaytag.sf.net"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<div class="row">
	<div class="col-md-12">
		<h3 class="page-title">
			<s:text name="databaseinfo" />
		</h3>
	</div>
	<div class="portlet box blue">
		<div class="portlet-title">
			<div class="caption">
				<i class="fa fa-tags"> <s:text name="databaseinfo" /></i>
			</div>
			<div class="tools">
				<a href="javascript:;" class="collapse"></a>
			</div>
		</div>
		<div class="portlet-body">
			<div class="table-toolbar">
				<div class="btn-group">
					<button class="btn yellow" id="btnEdit">
						<s:text name="edit" />
						<i class="fa fa-edit"></i>
					</button>
					<button class="btn blue" id="btnShow">
						<s:text name="show" />
						<i class="fa fa-eye"></i>
					</button>
					<button class="btn red" id="btnChange">
						<s:text name="calculateIndex" />
						<i class="fa fa-refresh"></i>
					</button>
				</div>
			</div>
			<div id="list-result">
				<display:table name="databaseInfos" id="databaseInfoTable"
					class="display table-hover table-bordered">
					<display:column property="id" title="ID" />
					<display:column property="url" title="Баазын зам" />
					<display:column property="username" title="Хэрэглэгчийн нэр" />
					<display:column property="password" title="Нууц үг" />
					<display:column property="downloadTime" title="Татах цаг" />
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
						<label for="url" class="control-label col-sm-5 col-lg-5">
							<s:text name="url" />:
						</label>
						<div class="col-sm-7 col-lg-6">
							<s:textfield name="url" cssClass="form-control" autofocus=""
								disabled="true" />
						</div>
					</div>
				</div>
			</div>
			<div class="form-group">
				<div class="row">
					<div class="col-sm-12">
						<label for="username" class="control-label col-sm-5 col-lg-5">
							<s:text name="username" />:
						</label>
						<div class="col-sm-7 col-lg-6">
							<s:textfield name="username" cssClass="form-control" autofocus=""
								disabled="true" />
						</div>
					</div>
				</div>
			</div>
			<div class="form-group">
				<div class="row">
					<div class="col-sm-12">
						<label for="password" class="control-label col-sm-5 col-lg-5">
							<s:text name="password" />:
						</label>
						<div class="col-sm-7 col-lg-6">
							<s:textfield name="password" cssClass="form-control"
								id="password" autofocus="" disabled="true" />
						</div>
					</div>
				</div>
			</div>
			<div class="form-group">
				<div class="row">
					<div class="col-sm-12">
						<label for="downloadTime" class="control-label col-sm-5 col-lg-5">
							<s:text name="downloadTime" />:
						</label>
						<div class="col-sm-7 col-lg-6">
							<s:textfield name="downloadTime" cssClass="form-control"
								id="downloadTime" autofocus="" disabled="true" />
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
						<label for="url" class="control-label col-sm-5 col-lg-5">
							<s:text name="url" />:
						</label>
						<div class="col-sm-7 col-lg-6">
							<s:textfield name="url" cssClass="form-control" autofocus="" id="url"/>
						</div>
					</div>
				</div>
			</div>
			<div class="form-group">
				<div class="row">
					<div class="col-sm-12">
						<label for="username" class="control-label col-sm-5 col-lg-5">
							<s:text name="username" />:
						</label>
						<div class="col-sm-7 col-lg-6">
							<s:textfield name="username" cssClass="form-control" autofocus="" id="username"/>
						</div>
					</div>
				</div>
			</div>
			<div class="form-group">
				<div class="row">
					<div class="col-sm-12">
						<label for="password" class="control-label col-sm-5 col-lg-5">
							<s:text name="password" />:
						</label>
						<div class="col-sm-7 col-lg-6">
							<s:textfield name="password" cssClass="form-control"
								id="password" autofocus="" />
						</div>
					</div>
				</div>
			</div>
			<div class="form-group">
				<div class="row">
					<div class="col-sm-12">
						<label for="downloadTime" class="control-label col-sm-5 col-lg-5">
							<s:text name="downloadTime" />:
						</label>
						<div class="col-sm-7 col-lg-6">
							<s:textfield name="downloadTime" cssClass="form-control clockface-open"
								id="downloadTime" />
						</div>
					</div>
				</div>
			</div>
		</div>
		<div class="hide">
			<s:submit name="submit" id="submit"></s:submit>
		</div>
	</form>
</div>
<div id="loadingDialog" title="Мэдээлэл">
	<div class = "center">          
  		 <i class = "fa fa-refresh animated center" ></i>
  	</div>
</div>
<div id='parseResult' class="hidden"></div>
<script src="../js/PageJS/databaseinfo.js"></script>