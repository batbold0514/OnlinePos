<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="display" uri="http://displaytag.sf.net"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%-- <div class="col-md-12">
	<h2 class="page-title">
		<s:text name="createtaxpayerlist" />
	</h2>
</div> --%>
<div class="form-group">
	<div class="row">
		<div class="col-cm-12">
			<div class="col-sm-4 col-lg-5">
				<h3>
					<s:text name="createtaxpayerlist" />
				</h3>
			</div>
			<div class="col-sm-8 col-lg-7">
				<s:form action="tax-payers">
					<div class="pull-left">
						<div class="row">
							<div class="col-sm-12">
								<label for="limit" class="control-label col-sm-3 col-lg-3">
									<s:text name="limit" />(*):
								</label>
								<div class="col-sm-3 col-lg-3">
									<s:textfield name="limit" value="%{limit}"
										cssClass="form-control" id="limit" autofocus="" />
								</div>
								<label for="avgPay" class="control-label col-sm-3 col-lg-3">
									<s:text name="avgPay" />(*):
								</label>
								<div class="col-sm-3 col-lg-3">
									<s:textfield name="avgPay"
										cssClass="form-control" id="avgPay" autofocus="" />
								</div>
							</div>
						</div>
						<div class="row">
							<div class="col-sm-12 col-lg-12">
								
								<div class= "col-sm-8 col-lg-8">
									<s:radio key="autoOp" list="#{'1':'Автоматаар','2':'Гараар'}"
										value="autoOp" />
								</div>
								<div class="col-sm-4 col-lg-4">
									<button class="btn btn-success">
										<s:text name="createList" />
									</button>
								</div>
							</div>
						</div>
					</div>
				</s:form>
			</div>
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
			<div id="list-result">
				<s:form action="plan12">
					<div>
						<table class="display  table-hoverdataTable table-bordered"
							id="sampletable2">
							<thead>
								<tr>
									<th>ID</th>
									<th>Т/т Дугаар</th>
									<th>Т/т Нэр</th>
									<th><s:text name = "operator"/></th>
									<th><s:text name = "phoneNumber"/></th>
									<th><s:text name = "email"/></th>
									<th><s:text name = "taxPayerIndex"/></th>
									<th><s:text name = "avgPay"/></th>
								</tr>
							</thead>
							<s:iterator value="#session.planListSession" status="stat"
								var="ite">
								<tr>
									<th><s:property value="#ite.taxPayer.id" /></th>
									<th><s:property value="#ite.taxPayer.regNumber" /> <%-- <s:property value="#ite.taxPayer.id"/>
										<c:out value="${ite.taxPayer.id }"/> --%></th>
									<th>
										<%-- <s:property value="planListSession[%{#stat.index}].taxPayer.companyName"/> --%>
										<s:property value="#ite.taxPayer.companyName" />
									</th>
									<th><s:select list="operators" listKey="id" value="#ite.operator.id"
											listValue="code" headerKey="" headerValue=""
											 onchange="getval(%{#stat.index},this)"></s:select></th>
									<th><s:property value="#ite.taxPayer.phoneNumber" /></th>
									<th><s:property value="#ite.taxPayer.email" /></th>
									<th><s:property value="#ite.taxPayer.totalIndex" /></th>
									<th><s:property value="#ite.taxPayer.avgDay" /></th>
								</tr>
							</s:iterator>
						</table>
						<s:if test = "#session.planListSession != null">
							<div class="row">
								<div class=" col-sm-12">
									<button class="btn btn-success col-sm-12"
										style="border: 1px solid #07c" id="btn">
										<i class="icon-th-list"></i> <span> <s:text
												name="createDayPlan" /></span>
									</button>
								</div>
							</div>
						</s:if>
					</div>
				</s:form>
				<%-- <s:set var="index" value="0"></s:set>
				<display:table name="planList" id="sampletable2"
					class=" table table-bordered table-hoverdataTable">
					<display:column property="taxPayer.id" title="ID" />
					<display:column property="taxPayer.regNumber"
						title="Татвар төлөгчийн дугаар" />
					<display:column property="taxPayer.companyName"
						title="Татвар төлөгчийн нэр" />
					<display:column title="оператор" media="html">
						<s:select list="operators" listKey="id" listValue="code"
							cssClass="xaxa" name="opId[%{index}]" headerKey="-1"
							headerValue=""></s:select>
						<s:set var="index" value="%{#index+1}" />
					</display:column>
						<c:forEach items="${sampletable2.debtList}" var="role">
						<display:column value="${debtList.balance}" title="${debtList.debtNumber}" />
					</c:forEach>
					<display:column property="taxPayer.email"
						title="Татвар төлөгчийн е-мэйл" />
					<display:column property="taxPayer.phoneNumber"
						title="Татвар төлөгчийн утас" />
				</display:table> --%>
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
<div id = "dialog" class  = "">
	<div id = "showTaxPayer"></div>
</div>
<script src="../js/PageJS/tax-payer-list.js"></script>