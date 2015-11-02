<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="display" uri="http://displaytag.sf.net"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="mn.infosystems.callcenter.model.Users"%>
<div class="col-md-12">
	<h3 class="page-title">
		<s:text name="taxpayerinformation" />
	</h3>
</div>
<div class="row">
	<div id="userRole" class="hide">
		<%
			out.print(request.isUserInRole("operator"));
		%>
	</div>
	<%-- <div class="portlet box blue">
		<div class="portlet-title">
			<div class="caption">
				<i class="fa fa-group"> <s:text name="taxpayer" /></i>
			</div>
			<div class="tools">
				<a href="javascript:;" class="collapse"></a>
			</div>
		</div>
	</div> --%>
	<div class="portlet-body">
		<div class="table-toolbar">
			<div class="btn-group">
				<%-- <a href='sip:9<s:property value="%{#session.plan.taxPayer.phoneNumber}" />'>
				  --%><!-- <a href = "sip:104"> -->
					<button class="btn green" style="border-radius: 4rem" id="btnCall">
						<i class="fa fa-phone "></i>
						<s:text name="call" />
					</button>
		<!-- 		</a> -->
				<button class="btn yellow" id="btnEmail">
					<i class="fa fa-mail-forward"></i>
					<s:text name="email" />
				</button>
				<button class="btn btn-info" id="btnPrint">
					<i class="fa fa-print"></i>
					<s:text name="print" />
				</button>
				<%-- <button class="btn blue" id="btnFax">
					<i class="fa fa-file"></i>
					<s:text name="fax" />
				</button> --%>
			</div>
			<%-- <% Users user =(Users)session.getAttribute("users");
			out.print(user.getPauseStatus());%> --%>
			<!-- <div class="btn-group pull-right">
				<button class="btn dropdown-toggle" data-toggle="dropdown">
					Tools <i class="fa fa-angle-down"></i>
				</button>
				<ul class="dropdown-menu pull-right">
					<li><a href="#">Print</a></li>
					<li><a href="#">Save as PDF</a></li>
					<li><a href="#">Export to Excel</a></li>
				</ul>
			</div> -->
		</div>
		<div class="row">
			<div class="col-sm-12">
				<s:hidden key="callQuantity" id="callQuantity" />
				<div class="tabbable tabbable-custom boxless">
					<ul class="nav nav-tabs">
						<li class="active"><a href="#tab_0" data-toggle="tab"><s:text
									name="all"></s:text></a></li>
						<li class=""><a href="#tab_1" data-toggle="tab"><s:text
									name="taxpayerinformation"></s:text></a></li>
						<li class=""><a href="#tab_2" data-toggle="tab"><s:text
									name="debtInfo"></s:text></a></li>
						<li><a href="#tab_3" data-toggle="tab"><s:text
									name="commitment"></s:text></a></li>
						<li><a href="#tab_4" data-toggle="tab"><s:text
									name="history"></s:text></a></li>
						<li><a href="#tab_5" data-toggle="tab"><s:text
									name="phones"></s:text></a></li>
					</ul>
					<div class="tab-content">
						<div id="tab_0" class="tab-pane active">
							<div class="note note-success">
								<div class="from-group">
									<s:hidden value="%{#session.plan.id}" id="planId" />
									<s:hidden name="sizeDebt" id="sizeDebt"
										value="%{#session.plan.taxPayer.activeDebtList.size}" />
									<table class="display ">
										<tr>
											<th><label class="control-label" for="companyName">
													<s:text name="taxpayer"></s:text>:
											</label> <s:property
													value="#session.plan.taxPayer.companyName + '  ' +#session.plan.taxPayer.etype " /></th>
											<th><label class="control-label" for="regNumber">
													<s:text name="regNumber"></s:text>:
											</label> <s:property value="#session.plan.taxPayer.regNumber" /></th>
											<th><label class="control-label" for="phoneNumber">
													<s:text name="phoneNumber"></s:text>:
											</label> <s:property value="#session.plan.taxPayer.phoneNumber" /></th>
											<s:hidden id="phoneNumber"
												name="#session.plan.taxPayer.phoneNumber" />
											<th><label class="control-label" for="email"> <s:text
														name="email"></s:text>:
											</label> <s:property value="#session.plan.taxPayer.email" /></th>
										</tr>
										<tr>
											<th><label class="control-label" for="rectorLastName">
													<s:text name="rectorLastName"></s:text>:
											</label> <s:property value="#session.plan.taxPayer.rectorLastName" /></th>
											<th><label class="control-label" for="rectorFirstName">
													<s:text name="rectorFirstName"></s:text>:
											</label> <s:property value="#session.plan.taxPayer.rectorFirstName" /></th>
										</tr>
									</table>
								</div>
								<div class="form-group"></div>
							</div>
							<div class="note note-info">
								<table class="table table-hoverdataTable table-bordered"
									id="sampletable1">
									<thead>
										<tr>
											<th>Мэдэгдэх хуудасны дугаар</th>
											<th>Татварын дугаар</th>
											<th>Татварын төрөл</th>
											<th>Өрийн дүн</th>
											<th>Өр үүссэн огноо</th>
										</tr>
									</thead>
									<tbody>
										<s:iterator value="#session.plan.taxPayer.activeDebtList"
											status="stat" var="iter">
											<tr>
												<th><s:property value="#iter.ticketNumber" /></th>
												<th><s:property value="#iter.debtNumber" /></th>
												<th><s:property value="#iter.type.typeName" /></th>
												<th><s:property
														value="getText('{0,number,#,##0.00}',{#iter.balance})" /></th>
												<th><s:date name="#iter.startDate" format="yyyy-MM-dd" /></th>
											</tr>
										</s:iterator>
									</tbody>
								</table>
							</div>
							<div class="note note-warning">
								<s:iterator value="#session.plan.taxPayer.activeDebtList"
									status="stat" var="iter">
									<div class="row">
										<div class="col-sm-12">
											<div id="debtID${stat.index}" class="hide">${iter.id}</div>
											<div id="debtbalance${stat.index}" class="hide">
												${iter.balance}</div>
											<div class="form-control" style="text-align: center;">
												${iter.type.typeName}-${iter.dtype_code}:
												<s:property
													value="getText('{0,number,#,##0.00}',{#iter.balance})" />
											</div>
											<div id="area-example${stat.index}" style="height: 250px;"></div>
										</div>
									</div>
								</s:iterator>
							</div>
							<div class="note note-error">
								<table class="table table-hoverdataTable table-bordered"
									id="sampletable2">
									<thead>
										<tr>
											<th>Дуудлага хийсэн огноо</th>
											<th>Дуудлага үргэлжилсэн хугацаа</th>
											<th>Дуудлага хийсэн оператор</th>
											<th>Дуудлагын төлөв</th>
										</tr>
									</thead>
									<tbody>
										<s:iterator value="#session.plan.taxPayer.calls" status="stat"
											var="iter">
											<tr>
												<th><s:date name="#iter.date" format="yyyy-MM-dd" /></th>
												<th><s:property value="#iter.duration" /></th>
												<th><s:property value="#iter.operator.code" /></th>
												<th><s:property value="#iter.reason.description" /></th>
											</tr>
										</s:iterator>
									</tbody>
								</table>
							</div>
						</div>
						<div id="tab_1" class="tab-pane">
							<div class="note note-success">
								<div class="from-group">
									<table class="display ">
										<tr>
											<th><label class="control-label" for="companyName">
													<s:text name="taxpayer"></s:text>:
											</label> <s:property
													value="#session.plan.taxPayer.companyName + '  ' +#session.plan.taxPayer.etype" /></th>
											<th><label class="control-label" for="regNumber">
													<s:text name="regNumber"></s:text>:
											</label> <s:property value="#session.plan.taxPayer.regNumber" /></th>
											<th><label class="control-label" for="phoneNumber">
													<s:text name="phoneNumber"></s:text>:
											</label> <s:property value="#session.plan.taxPayer.phoneNumber" /></th>
											<th><label class="control-label" for="email"> <s:text
														name="email"></s:text>:
											</label> <s:property value="#session.plan.taxPayer.email" /></th>
										</tr>
										<tr>
											<th><label class="control-label" for="rectorLastName">
													<s:text name="rectorLastName"></s:text>:
											</label> <s:property value="#session.plan.taxPayer.rectorLastName" /></th>
											<th><label class="control-label" for="rectorFirstName">
													<s:text name="rectorFirstName"></s:text>:
											</label> <s:property value="#session.plan.taxPayer.rectorFirstName" /></th>
										</tr>
									</table>
								</div>
								<div class="form-group"></div>
							</div>
						</div>
						<div id="tab_2" class="tab-pane">
							<div class="note note-info">
								<table class="table table-hoverdataTable table-bordered"
									id="sampletable3">
									<thead>
										<tr>
											<th>Мэдэгдэх хуудасны дугаар</th>
											<th>Татварын дугаар</th>
											<th>Татварын төрөл</th>
											<th>Өрийн дүн</th>
											<th>Өр үүссэн огноо</th>
										</tr>
									</thead>
									<tbody>
										<s:iterator value="#session.plan.taxPayer.activeDebtList"
											status="stat" var="iter">
											<tr>
												<th><s:property value="#iter.ticketNumber" /></th>
												<th><s:property value="#iter.debtNumber" /></th>
												<th><s:property value="#iter.type.typeName" /></th>
												<th><s:property
														value="getText('{0,number,#,##0.00}',{#iter.balance})" /></th>
												<th><s:date name="#iter.startDate" format="yyyy-MM-dd" /></th>
											</tr>
										</s:iterator>
									</tbody>
								</table>
							</div>
						</div>
						<div id="tab_3" class="tab-pane">
							<div class="note note-warning">
								<s:iterator value="#session.plan.taxPayer.activeDebtList"
									status="stat" var="iter">
									<div class="row">
										<div class="form-control" style="text-align: center;">
											${iter.type.typeName}-${iter.dtype_code}:
											<s:property
												value="getText('{0,number,#,##0.00}',{#iter.balance})" />
										</div>
										<div class="col-sm-12">
											<div id="area-tab${stat.index}" style="height: 250px;"></div>
										</div>
									</div>
								</s:iterator>
							</div>
						</div>
						<div id="tab_4" class="tab-pane">
							<div class="note note-error">
								<table class="table table-hoverdataTable table-bordered"
									id="sampletable4">
									<thead>
										<tr>
											<th>Дуудлага хийсэн огноо</th>
											<th>Дуудлага үргэлжилсэн хугацаа</th>
											<th>Дуудлага хийсэн оператор</th>
											<th>Дуудлагын төлөв</th>
										</tr>
									</thead>
									<tbody>
										<s:iterator value="#session.plan.taxPayer.calls" status="stat"
											var="iter">
											<tr>
												<th><s:date name="#iter.date" format="yyyy-MM-dd" /></th>
												<th><s:property value="#iter.duration" /></th>
												<th><s:property value="#iter.operator.code" /></th>
												<th><s:property value="#iter.reason.description" /></th>

											</tr>
										</s:iterator>
									</tbody>
								</table>
							</div>
						</div>
						<div id="tab_5" class="tab-pane">
							<div class="note note-error">
								<div class="row col-sm-12">
									<div class="col-sm-3 col-lg-1">
										<s:text name="mainNumber"></s:text>
									</div>
									<div class="col-sm-3 col-lg-1">
										<s:select list="#session.plan.taxPayer.phones"
											id="mainNumberSelect" listKey="number" listValue="number"
											key="phoneNumber" value="#session.plan.taxPayer.phoneNumber"></s:select>
									</div>
									<div class="col-sm-1">
										<button id="changeMainNumberBtn" class="btn btn-success">
											<s:text name="save" />
										</button>
									</div>
								</div>
								<div class="row col-sm-12">
									<table>
										<s:iterator value="#session.plan.taxPayer.phones"
											status="stat" var="iter">
											<tr>
												<th><s:property value="#iter.number" /></th>
												<th><button class="btn btn-success">
														<s:text name="call" />
													</button></th>
											</tr>
										</s:iterator>
									</table>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
		<!-- <div class="tiles">
			<div class="tile double bg-green">
				<div class="corner"></div>
				<div class="tile-body"></div>
				<div class="tile-object">
					<div class="name">
						<i class="fa fa-envelope"></i>
					</div>
					<div class="number"> 123
					</div>
				</div>
			</div>
		</div> -->
	</div>
</div>
<div id="dialogCall">
	<div class="row">
		<div id="userNameDiv" class="hide">
			<%
				out.append(request.getRemoteUser());
			%>
		</div>
		<table>
			<tr>
				<th><label class="control-label" for="companyName"> <s:text
							name="taxpayer"></s:text>:
				</label> <s:property value="#session.plan.taxPayer.companyName" /></th>
				<th><label class="control-label" for="phoneNumber"> <s:text
							name="phoneNumber"></s:text>:
				</label> <s:property value="#session.plan.taxPayer.phoneNumber" /></th>
				<th><label class="control-label" for="rectorLastName">
						<s:text name="rectorLastName"></s:text>:
				</label> <s:property value="#session.plan.taxPayer.rectorLastName" /></th>
				<th><label class="control-label" for="rectorFirstName">
						<s:text name="rectorFirstName"></s:text>:
				</label> <s:property value="#session.plan.taxPayer.rectorFirstName" /></th>
				<th style="cursor:pointer" onclick="showTotalDialog()"><label style="cursor:pointer" class="col-sm-6 col-lg-6" for="total"> <s:text
							name="total" ></s:text>:
				</label>
					<div id="sumtotal" class="col-sm-6  col-lg-6"></div></th>
			</tr>
		</table>

	</div>
	<s:form action="#" cssClass="form-horizontal" id="addCommitment">
		<s:hidden name="id" id = "planId"/>
		<s:hidden name="userName" id="userName" />
		<div class="row">
			<div class="form-group">
				<div class="row">
					<div class="col-sm-12">
						<label for="reasons" class="control-label col-sm-3 col-lg-3">
							<s:text name="reasons"></s:text>
						</label>
						<div class="col-sm-4 col-lg-3">
							<s:select list="reasonsList" listKey="id" listValue="description"
								name="reason" />
						</div>
						<label for="connectedPerson"
							class="control-label col-sm-3 col-lg-2"> <s:text
								name="personDescription" />
						</label>
						<div class="col-sm-3 col-lg-3">
							<s:select list="connectedPeople" listKey="id"
								listValue="personDescription" headerKey="" headerValue=""
								name="personIdString" id="conPersonId"
								onchange="personIdChange()"></s:select>
						</div>
					</div>
				</div>
			</div>
		</div>
		<div class="row">
			<div class="col-sm-12">
				<div class="tabbable tabbable-custom boxless">
					<ul class="nav nav-tabs">
						<s:iterator value="#session.callCommitments"
							status="stat" var="iter">
							<li <s:if test="#stat.index==0">class="active"</s:if>><a
								href="#tab_call_${stat.index}" data-toggle="tab"> <s:property
										value="#iter.listOfDebt[0].type.typeName" /> <%-- <s:hidden name = "callCommitments[%{#stat.index}].debt.id"/> --%>
							</a></li>
						</s:iterator>
					</ul>
					<div class="tab-content" style="background-color: #f0f0f0;">
						<s:iterator value="#session.callCommitments"
							status="stat" var="iter">
							<div id="tab_call_${stat.index}"
								<s:if test="#stat.index==0">class="tab-pane active"</s:if>
								<s:else>class="tab-pane"</s:else>>
								<div class="note">
									 <div class="row">
											<s:iterator value="#session.accounts[#stat.index]"
												var="accountNumber">
												<div class="row">
													<div class="col-sm-6">
														<div class="col-sm-6">
															<s:text name="bankName" /> :
														</div>
														<div class="col-sm-6">
															<s:property value="#accountNumber.bankName" />
														</div>
													</div>
													<div class="col-sm-6">
														<div class="col-sm-6">
															<s:text name="accountNumber" />:
														</div>
														<div class="col-sm-6">
															<s:property value="#accountNumber.number" />
														</div>
													</div>
												</div>
											</s:iterator>
									</div> 
									<div class="row">
										
										<div class="row">
													<div class="col-sm-6">
														<div class="col-sm-6">
															Тайлан нийт дүн :
														</div>
														<div class="col-sm-6">
															<p id = "total_1${stat.index}"/> 
														</div>
													</div>
													<div class="col-sm-6">
														<div class="col-sm-6">
															Хяналт шалгалтын нийт дүн:
														</div>
														<div class="col-sm-6">
															<p id = "total_2${stat.index}"/> 
														</div>
													</div>
												</div>
									</div>
									<div class="row" id="tab_call_debt_${stat.index}">
										<table class="table table-hoverdataTable table-bordered" id = "debt_list_${stat.index }">
											<s:hidden name="callCommitments[%{#stat.index}].listsize" />
											<s:hidden name="callCommitments[%{#stat.index}].primaryData" />
											<thead>
												<tr>
													<th>Татварын дугаар</th>
													<th>Татварын төрөл</th>
													<th>Өрийн дүн</th>
													<th>Мэдэгхэд хуудас үүссэн огноо</th>
													<th>Өр үүссэн он,улирал</th>
													<th>Өр дуудах төвөөс буцах хугацаа</th>
													<th>Татварын алба</th>
													<th>Тайлангын хэлбэр</th>
													<th>Хэсэгчилж төлөх дүн</th>
													<th>Огноо</th>
													<th>Тайлбар</th>
												</tr>
											</thead>
											<tbody>
												<s:iterator begin="0" end="#session.callCommitments[#stat.index].listsize" status="statUnit">
													<tr>
														
														<%-- <s:hidden name = "#iter.listOfDebt[#statUnit.index].debtNumber"/>
														<s:hidden name = "#iter.listOfDebt[#statUnit.index].type.typeName"/>
														<s:hidden name = "#iter.listOfDebt[#statUnit.index].balance"/>
														<s:hidden name = "#iter.listOfDebt[#statUnit.index].startDate"/>
														<s:hidden name = "#iter.listOfDebt[#statUnit.index].create_yaer"/> 
														<s:hidden name = "#iter.listOfDebt[#statUnit.index].endDate"/>--%>
														<td>
															<s:property value="#iter.listOfDebt[#statUnit.index].debtNumber" /> 
															<input name="callCommitments[${stat.index}].listOfDebt[${statUnit.index}].id" type="text" value="${iter.listOfDebt[statUnit.index].id}" class = "hide"/>
															</td>
														<td><s:property value="#iter.listOfDebt[#statUnit.index].type.typeName" /></td>
														<td><s:property value="getText('{0,number,#,##0.00}',{#iter.listOfDebt[#statUnit.index].balance})" /></td>
														<td><s:date name="#iter.listOfDebt[#statUnit.index].startDate"	format="yyyy-MM-dd" /></td>
														<td><s:property value="#iter.listOfDebt[#statUnit.index].create_yaer" />-<s:property value="#iter.listOfDebt[#statUnit.index].bill_time" /></td>
														<td><s:date name="#iter.listOfDebt[#statUnit.index].endDate" format="yyyy-MM-dd" /></td>
														<td><s:property value="#iter.listOfDebt[#statUnit.index].officeNumber" /></td>
														<td><s:property value="#iter.listOfDebt[#statUnit.index].dtype_code" /></td>
														<td>
															<div class="form-group">
																<div class="row">
																	<div class="col-sm-12">
																		<div class="col-sm-12">
																			<input class="commitValue"
																				name="callCommitments[${stat.index}].commitValues[${statUnit.index}]"
																				type="text" />
																		</div>
																	</div>
																</div>
																<div class="row">
																	<div class="col-sm-12"
																		id="errorCommitValues${stat.index}${statUnit.index}Result">
																		<s:fielderror
																			fieldName="commitValues<s:property value='%{#stat.index}'/><s:property value='%{#statUnit.index}'/>" />
																	</div>
																</div>
															</div>
														</td>
														<td>
															<div class="form-group">
																<div class="row">
																	<div class="col-sm-12">
																		<div class="col-sm-12">
																			<input class="paydate"
																				name="callCommitments[${stat.index}].commitDates[${statUnit.index}]"
																				type="text" />
																		</div>
																	</div>
																</div>
																<div class="row">
																	<div class="col-sm-12"
																		id="errorCommitDates${stat.index}${statUnit.index}Result">
																		<s:fielderror
																			fieldName="commitDates<s:property value='%{#stat.index}'/><s:property value='%{#statUnit.index}'/>" />
																	</div>
																</div>
															</div>
														</td>
														<td style="width: 30%">
															<div class="input-group">
																<input class="form-control"
																	name="callCommitments[${stat.index}].commitDescriptions[${statUnit.index}]"
																	type="text" />
																<c:if test="${statUnit.index < callCommitments[stat.index].primaryData}">
																	<span class="input-group-addon input-sm" style="cursor:pointer"
																		onclick="callCommitmentAdd(${stat.index},${statUnit.index})"> <i
																		class="fa fa-plus" style="color: green"></i>
																	</span>
																	
																</c:if>
																<c:if test="${statUnit.index >= callCommitments[stat.index].primaryData}">
																	<span class="input-group-addon input-sm" style="cursor:pointer"
																		onclick="callCommitmentRemove(${stat.index},${statUnit.index})">
																		<i class="fa fa-minus" style="color: red"></i>
																	</span>
																</c:if>
															</div>
														</td>

													</tr>
												</s:iterator>
													
												<%-- <s:textfield id = "subTotal%{#stat.index}" value = "%{subTotal_0}"/> --%>
												<%-- <p id = "subTotal${stat.index}" class = "">${subTotal_0}</p> --%>
							</table>
									</div>
								</div>
							</div>
						</s:iterator>
					</div>
				</div>
			</div>
		</div>
	</s:form>
</div>
<div id="phone-dialog" class="hide">
	<div class="row">
		<s:form action="addPhoneNumber" id="phoneNumberForm">
			<s:hidden name="id" />
			<s:hidden name="userName" id="userNameAddPhone" />
			<div class="form-froup">
				<label for="phoneNumber" class="control-label col-sm-5 col-lg-5">
					<s:text name="phoneNumber"></s:text>
				</label>
				<div class="col-sm-6 col-lg-6">
					<s:textfield name="phoneNumber" id="phoneNumber" />
				</div>
			</div>
		</s:form>
	</div>
</div>
<div id="return-dialog" class="hide">
	<s:form action="returnTaxpayer" id="returnTaxPayerForm">
		<s:hidden name="id" />
		<s:hidden name="personIdString" id="personIdString" />
		<div class="form-group">
			<label class="control-label col-sm-5 col-lg-5"> <s:text
					name="returnReason" />
			</label>
			<div class="col-sm-7 col-lg-7">
				<s:select list="reasons" listKey="id" listValue="description"
					name="returnReasonIdString" id="reasonList" cssClass="form-control"></s:select>
			</div>
		</div>
	</s:form>
</div>
<div id="print-dialog" class = "hide">
	<div class="note note-success">
		<div class="from-group">
			<table class="table" style="border: 1px;" id="printtable1">
				<tr>
					<th><label class="control-label" for="companyName"> <s:text
								name="taxpayer"></s:text>:
					</label> <s:property
							value="#session.plan.taxPayer.companyName + '  ' +#session.plan.taxPayer.etype " /></th>
					<th><label class="control-label" for="regNumber"> <s:text
								name="regNumber"></s:text>:
					</label> <s:property value="#session.plan.taxPayer.regNumber" /></th>
					<th><label class="control-label" for="phoneNumber"> <s:text
								name="phoneNumber"></s:text>:
					</label> <s:property value="#session.plan.taxPayer.phoneNumber" /></th>
					<th><label class="control-label" for="email"> <s:text
								name="email"></s:text>:
					</label> <s:property value="#session.plan.taxPayer.email" /></th>
				</tr>
				<tr>
					<th><label class="control-label" for="rectorLastName">
							<s:text name="rectorLastName"></s:text>:
					</label> <s:property value="#session.plan.taxPayer.rectorLastName" /></th>
					<th><label class="control-label" for="rectorFirstName">
							<s:text name="rectorFirstName"></s:text>:
					</label> <s:property value="#session.plan.taxPayer.rectorFirstName" /></th>
				</tr>
			</table>
		</div>
		<div class="form-group"></div>
	</div>
	<div class="note note-info">
		<table class="display">
			<thead>
				<tr>
					<th>Мэдэгдэх хуудасны дугаар</th>
					<th>Татварын дугаар</th>
					<th>Татварын төрөл</th>
					<th>Өрийн дүн</th>
					<th>Өр үүссэн огноо</th>
				</tr>
			</thead>
			<tbody>
				<s:iterator value="#session.plan.taxPayer.activeDebtList"
					status="stat" var="iter">
					<tr>
						<th><s:property value="#iter.ticketNumber" /></th>
						<th><s:property value="#iter.debtNumber" /></th>
						<th><s:property value="#iter.type.typeName" /></th>
						<th><s:property
								value="getText('{0,number,#,##0.00}',{#iter.balance})" /></th>
						<th><s:date name="#iter.startDate" format="yyyy-MM-dd" /></th>
					</tr>
				</s:iterator>
			</tbody>
		</table>
	</div>
	<div class="note note-warning">
		<s:iterator value="#session.plan.taxPayer.activeDebtList"
			status="stat" var="iter">
			<div class="row">
				<div class="col-sm-12">
					<div id="debtID${stat.index}" class="hide">${iter.id}</div>
					<div id="debtbalance${stat.index}" class="hide">
						${iter.balance}</div>
					<div class="form-control" style="text-align: center;">
						${iter.type.typeName} :
						<s:property value="getText('{0,number,#,##0.00}',{#iter.balance})" />
					</div>
					<div id="area-example${stat.index}" style="height: 250px;"></div>
				</div>
			</div>
		</s:iterator>
	</div>
	<div class="note note-error">
		<table class="table table-hoverdataTable table-bordered">
			<thead>
				<tr>
					<th>Дуудлага хийсэн огноо</th>
					<th>Дуудлага үргэлжилсэн хугацаа</th>
					<th>Дуудлага хийсэн оператор</th>
					<th>Дуудлагын төлөв</th>
				</tr>
			</thead>
			<tbody>
				<s:iterator value="#session.plan.taxPayer.calls" status="stat"
					var="iter">
					<tr>
						<th><s:date name="#iter.date" format="yyyy-MM-dd" /></th>
						<th><s:property value="#iter.duration" /></th>
						<th><s:property value="#iter.operator.code" /></th>
						<th><s:property value="#iter.reason.description" /></th>
					</tr>
				</s:iterator>
			</tbody>
		</table>
	</div>
</div>
<div class = "hide" id = "showTotal-dialog">
	<s:form action="#" cssClass="form-horizontal" id="addCommitmentShow">
		<s:hidden name="id" />
		<s:hidden name="userName" id="userNameShow" />
		<div class="row">
			<div class="form-group">
				<div class="row">
					<div class="col-sm-12">
						<label for="reasons" class="control-label col-sm-3 col-lg-3">
							<s:text name="reasons"></s:text>
						</label>
						<div class="col-sm-4 col-lg-3">
							<s:select list="reasonsList" listKey="id" listValue="description"
								name="reason" />
						</div>
						<label for="connectedPerson"
							class="control-label col-sm-3 col-lg-2"> <s:text
								name="personDescription" />
						</label>
						<div class="col-sm-3 col-lg-3">
							<s:select list="connectedPeople" listKey="id"
								listValue="personDescription" headerKey="" headerValue=""
								name="personIdString" id="conPersonId"
								onchange="personIdChange()"></s:select>
						</div>
					</div>
				</div>
			</div>
		</div>
		<div class = "row">
			<div class="col-sm-offset-4 col-sm-2">
				<h4 > Тайлан</h4>
			</div>
			<div class="col-sm-2">
				<h4 > Хяналт шалгалт</h4>
			</div>
			<div class="col-sm-2">
				Мөнгөн дүн
			</div>
			<div class="col-sm-2">
				Огноо
			</div>
		</div>
		<s:iterator value="#session.callCommitments" status="stat" var="iter">
			<div class = "row">
				<div class="col-sm-4">
					<s:property value="#iter.listOfDebt[0].type.typeName" /> :
				</div>
				<div class="col-sm-2">
					<p id = "showTotal_1${stat.index}"/> 
				</div>
				<div class="col-sm-2">
					<p id = "showTotal_2${stat.index}"/> 
				</div>
				<div class = "col-sm-2">
					<div class="form-group">
						<div class="row">
							<div class="col-sm-12">
								<div class="col-sm-12">
									<input class="commitValue"
										name="callCommitmentShows[${stat.index}].commitValues"
										type="text" />
								</div>
							</div>
						</div>
						<div class="row">
							<div class="col-sm-12"
								id="errorCommitShowValues${stat.index}Result">
								<s:fielderror
									fieldName="commitShowValues<s:property value='%{#stat.index}'/>" />
							</div>
						</div>
					</div>
				</div>
				<div class = "col-sm-2">
					<div class="form-group">
						<div class="row">
							<div class="col-sm-12">
								<div class="col-sm-12">
									<input class="paydate"
										name="callCommitmentShows[${stat.index}].commitDates"
										type="text" />
								</div>
							</div>
						</div>
						<div class="row">
							<div class="col-sm-12"
								id="errorCommitShowDates${stat.index}Result">
								<s:fielderror
									fieldName="commitShowDates<s:property value='%{#stat.index}'/>" />
							</div>
						</div>
					</div>
				</div>
			</div>
		</s:iterator>
	</s:form>
	<div class = "row">
		<div class="col-sm-4">
			<h5><s:text name="total"/> </h5>
		</div>
		<div class="col-sm-2">
			<h5 id = "subshowTotal_1">  </h5>
		</div>
		<div class="col-sm-2">
			<h5 id = "subshowTotal_2"></h5> 
		</div>
	</div>	
	<div class = "row">
		<div class="col-sm-6">
			<h4 > <s:text name="total"/></h4>
		</div>
		<div class="col-sm-6">
			<h4 id = "showTotal"> </h4>
		</div>
	</div>
	
	
</div>
<div id="parseResult" class=hidden></div>
<div id="context" class="hide">${pageContext.request.contextPath}
</div>
<div id="dialog-commitment" class="hide"></div>
<script src="../js/PageJS/show-plan.js"></script>
