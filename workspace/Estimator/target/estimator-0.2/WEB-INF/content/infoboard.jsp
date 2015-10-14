<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="display" uri="http://displaytag.sf.net"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div class="row">
	<div class="col-sm-12">
		<h3 class="page-title">
			<s:text name="infoBoard" />
		</h3>
	</div>
	<p class = "active_menu hide">infoBoard</p>
	<div class="col-sm-8 col-md-8 col-lg-9">
		<div class="portlet box blue">
			<div class="portlet-title">
				<div class="caption">
					<i class="fa fa-group"> <s:text name="infoBoard" /></i>
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
				</div>
				<div id="list-result">
					<display:table name="infoBoardList" id="infoBoardTable"
						class="display table-bordered table-hoverdataTable">
						<display:column property="id" title="" />
						<display:column property="date" title="Огноо" format="{0,date,yyyy-MM-dd hh:mm:ss}"/>
						<display:column property="info" title="Мэдээлэл" />
						<display:column property="user.userName" title="Оруулсан" />
					</display:table>
				</div>
			</div>
		</div>
	</div>
	<div class="col-sm-4 col-md-4 col-lg-3">
		<s:textarea cssClass="form-control" rows="20" id="infoTextArea">
		</s:textarea>
	</div>
</div>
<div id="dialog-show-container">
	<div id="dialog-show" class="hide">
		<div class="form-group">
			<div class="row">
				<div class="col-sm-12">
					<label for="dateStr" class="control-label col-sm-5 col-lg-5">
						<s:text name="date" />
					</label>
					<div class="col-sm-7 col-lg-6">
						<s:textfield name="dateStr" cssClass="form-control" autofocus=""
							disabled="true" />
					</div>
				</div>
			</div>
		</div>
		<div class="form-group">
			<div class="row">
				<div class="col-sm-12">
					<label for="info" class="control-label col-sm-5 col-lg-5">
						<s:text name="info" />
					</label>
					<div class="col-sm-7 col-lg-6">
						<s:textfield name="info" cssClass="form-control" autofocus=""
							disabled="true" />
					</div>
				</div>
			</div>
		</div>
		<div class="form-group">
			<div class="row">
				<div class="col-sm-12">
					<label for=user class="control-label col-sm-5 col-lg-5"> <s:text
							name="input" />
					</label>
					<div class="col-sm-7 col-lg-6">
						<s:textfield name="user" cssClass="form-control" autofocus=""
							disabled="true" />
					</div>
				</div>
			</div>
		</div>
	</div>
</div>
<div id="dialog-addnew" class="hide">
	<s:form action="userSave" cssClass="form-horizontal" id="addForm">
		<s:hidden name="id" />
		<div class="form-group">
			<div class="row">
				<div class="col-sm-12">
					<label for="info" class="control-label col-sm-5 col-lg-5">
						<s:text name="info" /><span class="required"> * </span>
					</label>
					<div class="col-sm-7 col-lg-6">
						<s:textarea name="info" cssClass="form-control" id="info"
							autofocus="" rows="10">
						</s:textarea>
					</div>
				</div>
			</div>
		</div>
		<input type="submit" id="submitOk" class="hide" />
	</s:form>
</div>
<div id="parseResult" class=hidden></div>
<div id="context" class="hide">${pageContext.request.contextPath}
</div>
<script src="../js/PageJS/infoBoard.js"></script>