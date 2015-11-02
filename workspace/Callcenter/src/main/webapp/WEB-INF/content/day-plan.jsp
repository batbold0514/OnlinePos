<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="display" uri="http://displaytag.sf.net"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div class="form-group">
	<div class="row col-cm-12">
		<div class="col-sm-7 col-lg-6">
			<h3 class="page-title">
				<s:text name="plan" />
			</h3>
		</div>
		<div class="col-cm-5 col-lg-6">
			<s:form action="day-plan">
				<div class="pull-left">
					<div class="row">
						<div class="col-sm-12">
							<label for="date" class="control-label col-sm-4 col-lg-4">
								<s:text name="date" />(*):
							</label>
							<div class="col-sm-4 col-lg-4">
								<s:textfield name="dateStr" value="%{dateStr}"
									cssClass="form-control" id="date"  />
							</div>
							<div class="col-sm-4 col-lg-4">
								<button class="btn btn-success">
									<s:text name="search" />
								</button>
							</div>
						</div>
					</div>
				</div>
			</s:form>
		</div>
	</div>
</div>
<hr>
<div class="row">
	<div class="portlet box blue">
		<div class="portlet-title">
			<div class="caption">
				<i class="fa fa-group"> <s:text name="taxpayer" /></i>
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
					<button class="btn blue" id="btnEditOp">
						<s:text name="editOp" />
						<i class="fa fa-edit"></i>
					</button>
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
				<display:table name="planList" id="sampletable2" 
					class=" display table-bordered table-hoverdataTable">
					<display:column property="id" title="ID" />
					<display:column property="taxPayer.regNumber" title="Т/т дугаар" />
					<display:column property="taxPayer.companyName" title="Т/т нэр" />
					<display:column property="operator.code" title="оператор" />
					<%-- <c:forEach items="${sampletable2.debtList}" var="role">
						<display:column value="${debtList.balance}"
							title="${debtList.debtNumber}" />
					</c:forEach> --%>
					<display:column property="taxPayer.email" title="Е-мэйл" />
					<display:column property="taxPayer.phoneNumber" title="Холбогдох утас" />
					<display:footer media="html">
					</display:footer>
				</display:table>
			</div>
			<%-- <div class="row">
				<div class=" col-sm-12">
					<s:form action="plan">
						<s:hidden key="opId" value=""></s:hidden>
						<button class="btn btn-success col-sm-12"
							style="border: 1px solid #07c" id="btn">
							<i class="icon-th-list"></i> <span> <s:text
									name="createDayPlan" /></span>
						</button>
					</s:form>
				</div>
			</div> --%>
		</div>
	</div>
</div>

<div id = "dialog-editOp" class="hide">
	<form action="#" id="addform">
		<div class="form-body">
			<s:hidden key="id" />
			<div class="form-group">
				<div class="row">
					<div class="col-sm-12">
						<label for="regNumber" class="control-label col-sm-5 col-lg-5">
							<s:text name="regNumber" />
						</label>
						<div class="col-sm-7 col-lg-6">
							<s:textfield name="regNumber" cssClass="form-control"
								id="regNumber" disabled="true"/>
						</div>
					</div>
				</div>
			</div>
			<div class="form-group">
				<div class="row">
					<div class="col-sm-12">
						<label for="companyName" class="control-label col-sm-5 col-lg-5">
							<s:text name="taxpayer" />
						</label>
						<div class="col-sm-7 col-lg-6">
							<s:textfield name="companyName" cssClass="form-control"
								id="companyName"  disabled="true"/>
						</div>
					</div>
				</div>
			</div>
			<div class="form-group">
				<div class="row">
					<div class="col-sm-12">
						<label for="operatorCode" class="control-label col-sm-5 col-lg-5">
							<s:text name="operator" />
						</label>
						<div class="col-sm-7 col-lg-6">
							<s:select list="operators" listKey="id" name = "operatorCode" cssClass="form-control"
							listValue="code" headerKey="" headerValue="" id="operatorCode" autofocus=""></s:select>
						</div>
					</div>
				</div>
			</div>
			<div class="form-group">
				<div class="row">
					<div class="col-sm-12">
						<label for="email" class="control-label col-sm-5 col-lg-5">
							E-mail
						</label>
						<div class="col-sm-7 col-lg-6">
							<s:textfield name="email" cssClass="form-control"
								id="email"  disabled="true"/>
						</div>
					</div>
				</div>
			</div>
			<div class="form-group">
				<div class="row">
					<div class="col-sm-12">
						<label for="phoneNumber" class="control-label col-sm-5 col-lg-5">
							<s:text name="phoneNumber" />
						</label>
						<div class="col-sm-7 col-lg-6">
							<s:textfield name="phoneNumber" cssClass="form-control"
								id="phoneNumber"  disabled="true"/>
						</div>
					</div>
				</div>
			</div>
			<input type="submit" id = "submitOk" class ="hide"/>
		</div>
	</form>
</div>
<div id = "parseResult" class="hidden"></div>
<script src="../js/PageJS/day-plan.js"></script>
