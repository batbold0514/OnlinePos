<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sx" uri="/struts-dojo-tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<script>
	var date = new Date();
</script>
<table class="table">
	<s:iterator value="listOfSessionPayments">
		<tr style="width: 100%">
			<th><a
				href="printsessionpayment?model.id=<s:property value='id' />"><s:text
						name="print" /></a></th>
			<s:if test="%{deference > 0}">
				<th colspan="3" style="color: green; text-align: right;"><s:text
						name="residue" />:&nbsp;<s:property
						value="getText('{0,number,#,###}',{deference})" />₮</th>
			</s:if>
			<s:else>
				<th colspan="3" style="color: red; text-align: right;"><s:text
						name="residue" />:&nbsp;<s:property
						value="getText('{0,number,#,###}',{deference})" />₮</th>
			</s:else>
		</tr>
	</s:iterator>
</table>
<div class="hr hr-2"></div>
<div class="tabbable">

	<ul id="myTab" class="nav nav-tabs">
		<li class="active"><a href="#home" data-toggle="tab"><s:text
					name="sessions" /></a></li>
		<li><a href="#profile" data-toggle="tab"><s:text
					name="payments" /></a></li>
	</ul>

	<div class="tab-content scrollver">
		<div class="tab-pane in active" id="home">
			<table class="table">
				<s:iterator value="listOfSessionPayments">
					<s:iterator value="listOfSession">
						<tr style="width: 100%;">
							<th style="border-top: 1px dashed black"><s:property
									value="getText('{0,date,yyyy-MM-dd}',{date})" /></th>
							<th colspan="2" style="border-top: 1px dashed black"><s:text
									name="doctor" />:&nbsp;<s:property value="doctor.name" /></th>
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
						<tr>
							<th colspan="3">
								<ul style="list-style-type: decimal">
									<s:text name="Оношнууд" />
									<s:iterator value=" listOfDiagnosis" status="stat">
										<tr>
											<td><s:property value="#stat.index+1" />. <s:property
													value="code" /></td>
											<td><s:property value="name" /></td>
										</tr>
									</s:iterator>
								</ul>
							</th>
						</tr>
						<tr style="witdh: 100%">
							<th style="border-top: 1px dashed black"><s:property
									value="note" /></th>
						</tr>
						<tr>
							<td colspan="2" align="center">
							<td align="right">&#8721;&nbsp;<s:property
									value="getText('{0,number,#,###}',{sum})" />-₮
							</td>
							<th><s:if test=" checkDate <= date ">
									<a href="editDoctorSession?model.id=<s:property value='id'/>">
										<s:text name="edit" />
									</a>
								</s:if></th>
						</tr>
					</s:iterator>
				</s:iterator>
			</table>
		</div>
		<div class="tab-pane" id="profile">
			<table class="table">
				<s:iterator value="listOfSessionPayments">
					<s:iterator value="listOfPayment">
						<tr style="width: 100%">
							<th style="border-top: 1px dashed black"><s:date name="savedDate" format="yyyy-MM-dd HH:mm:ss" /></th>
							<th style="border-top: 1px dashed black"><s:property value="description" /></th>
							<th style="border-top: 1px dashed black" align="right"><s:property
									value="getText('{0,number,#,###}',{value})" />-₮</th>
						</tr>
						<tr>
							<th><s:property value="paymentNumber" /></th>
							<th><s:property value="user" /></th>
							<th><s:text name="Эмч : " /> <s:property
									value="doctor.name" /></th>
							<%
								if (request.isUserInRole("admin-role")) {
							%>
							<th><s:if
									test="%{savedDate.day==date.day && savedDate.month == date.month}">
									<a href="editPayment?model.id=<s:property value='id'/>"> <s:text
											name="edit" /></a>
								</s:if></th>
							<%
								;
										}
							%>
						</tr>
					</s:iterator>
				</s:iterator>
			</table>
		</div>
	</div>
</div>
