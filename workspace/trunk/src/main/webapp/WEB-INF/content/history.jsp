<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sx" uri="/struts-dojo-tags"%>
<sx:head />
<div class="hidden" id="page">
	<s:url action="search-patient" includeParams="none" />
</div>
<div class="pageContnet">
	<div class="pageHeader">
		<h2>
			<s:text name="history" />
		</h2>
	</div>
	<s:form action="historyRange">
		<div class="row-fluid">
		<s:hidden key="id" />
			<div class="col-sm-12">
				<div class="row">
					<label for="date" class="control-label col-sm-3 col-lg-1">
						<s:text name="date" />
					</label>
					<div class="col-sm-3 col-lg-2">
						<s:textfield name="dateStr" id="date" />
					</div>
					<label for="secondDate" class="control-label col-sm-3 col-lg-1">
						<s:text name="secondDate" />
					</label>
					<div class="col-sm-3 col-lg-2">
						<s:textfield name="secondDateStr" id="secondDate" />
					</div>
				</div>
				<div class="left">
					<button class="btn btn-success">
						<s:text name="search" />
					</button>
				</div>
			</div>
		</div>
	</s:form>
	<div class="center">
		<s:form action="back">
			<s:hidden key="id" />
			<button class="btn btn-warning">
				<s:text name="back"></s:text>
			</button>

		</s:form>
	</div>
</div>
<table style="width: 100%;margin-left: 15px; margin-right: 15px;">
	<tr>
		<th><s:text name="sessions" /></th>
		<th><s:text name="payments" /></th>
	</tr>
	<tr>
		<th colspan="2"><s:iterator value="listOfSessionPayments">
				<tr>
					<th colspan="2" style="border-bottom: 1px solid black;"><br /></th>
				</tr>
				<%
					if (request.isUserInRole("admin-role")) {
				%>
				<tr>
					<th><a href="money_back?model.id=<s:property value='id' />"><s:text
								name="money_back" /></a></th>
				</tr>
				<%
					}
				%>
				<tr>
					<th><table style="width: 80%">
							<s:iterator value="listOfSession">
								<tr style="width: 100%;">
									<th><s:date name="date" format="yyyy-MM-dd HH:mm" /></th>
									<th colspan="2"><s:text name="doctor" />:&nbsp;<s:property
											value="doctor.name" /></th>
								</tr>
								<tr>
									<th colspan="3">
										<ul style="list-style-type: decimal">
											<s:text name="Үзлэгүүд" />
											<s:iterator value=" listOfService" status="stat">
												<tr>
													<td><s:property value="#stat.index+1" />. <s:property
															value="code" /></td>
													<td><s:property value="name" /></td>
													<td align="right"><s:property
															value="getText('{0,number,#,###}',{price})" />-₮</td>
												</tr>
											</s:iterator>
										</ul>
									</th>
								</tr>
								<br />
								<tr>
									<th colspan="3"><s:if test=" checkDate <= date ">
											<a href="editDiagnosis?model.id=<s:property value='id'/>">
												<s:text name="edit" />
											</a>
										</s:if>
										<ul style="list-style-type: decimal">
											<s:text name="Оношнууд" />
											<s:iterator value=" listOfDiagnosis" status="stat">
												<tr>
													<td><s:property value="#stat.index+1" />. <s:property
															value="code" /></td>
													<td><s:property value="name" /></td>
												</tr>
											</s:iterator>
										</ul></th>
								</tr>
								<tr>
									<td style="border-top: 1px dashed black" colspan="2"
										align="center"><s:property value="note" /></td>
									<td style="border-top: 1px dashed black" align="right">&#8721;&nbsp;<s:property
											value="sum" />,-₮
									</td>
								</tr>
							</s:iterator>
						</table></th>
					<th style="vertical-align: top;">
						<table style="width: 80%;">
							<s:iterator value="listOfPayment">
								<tr style="width: 100%;">
									<th><s:date name="date" format="yyyy-MM-dd HH:mm" /></th>
									<th><s:property value="description" /></th>
									<th align="right"><s:property
											value="getText('{0,number,#,###}',{value})" />-₮</th>
								</tr>
								<tr style="font-style: normal">
									<th><s:property value="paymentNumber" /></th>
									<th colspan="2"><s:property value="doctor.name +' ' +doctor.familyName" /></th>
									<th colspan="2"><s:property value="user" /></th>
								</tr>
								<tr>
									<td style="border-top: 1px dashed black" colspan="3"><s:property
											value="note" /></td>
								</tr>
							</s:iterator>
						</table>
					</th>
				</tr>
			</s:iterator></th>
	</tr>
</table>
<div class="center">
	<s:form action="back">
		<s:hidden key="id" />
		<button class="btn btn-warning">
			<s:text name="back"></s:text>
		</button>
	</s:form>
</div>
<script>
	$(document).ready(function(){
		$("#date").datepicker({
			changeMonth : true,
			changeYear : true,
			dateFormat : "yy-mm-dd"
		});
		$("#secondDate").datepicker({
			changeMonth : true,
			changeYear : true,
			dateFormat : "yy-mm-dd"
		});
	});
</script>