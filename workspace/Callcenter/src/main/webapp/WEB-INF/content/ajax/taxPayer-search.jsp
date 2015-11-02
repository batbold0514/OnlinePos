<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="display" uri="http://displaytag.sf.net"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="mn.infosystems.callcenter.model.Users"%>
<%
	if (request.getAttribute("searchAjax") != null) {
%>
<div class="col-sm-12">
	<div id="userRole" class="hide">
		<%
			out.print(request.isUserInRole("operator"));
		%>
	</div>
	<div class="portlet-body">
		<div class="table-toolbar">
			<div class="btn-group">
					<button class="btn yellow " id="btnAnswer" >
							<i class="fa fa-phone"></i>
							<s:text name="answer" />
						</button> 
					<button class="btn green" style="border-radius: 4rem" id="btnShow">
						<i class="fa fa-eye "></i>
						<s:text name="show" />
					</button>
				<button class="btn danger" id="btnReject">
					<i class="fa fa-mail-forward"></i>
					<s:text name="reject" />
				</button>
			</div>
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
									<s:hidden name="sizeDebt" id="sizeDebt"
										value="%{#session.taxPayer.activeDebtList.size}" />
									<table class="display ">
										<tr>
											<th><label class="control-label" for="companyName">
													<s:text name="taxpayer"></s:text>:
											</label> <s:property
													value="#session.taxPayer.companyName + '  ' +#session.taxPayer.etype " /></th>
											<th><label class="control-label" for="regNumber">
													<s:text name="regNumber"></s:text>:
											</label> <s:property value="#session.taxPayer.regNumber" /></th>
											<th><label class="control-label" for="phoneNumber">
													<s:text name="phoneNumber"></s:text>:
											</label> <s:property value="#session.taxPayer.phoneNumber" /></th>
											<s:hidden id="phoneNumber"
												name="#session.taxPayer.phoneNumber" />
											<th><label class="control-label" for="email"> <s:text
														name="email"></s:text>:
											</label> <s:property value="#session.taxPayer.email" /></th>
										</tr>
										<tr>
											<th><label class="control-label" for="rectorLastName">
													<s:text name="rectorLastName"></s:text>:
											</label> <s:property value="#session.taxPayer.rectorLastName" /></th>
											<th><label class="control-label" for="rectorFirstName">
													<s:text name="rectorFirstName"></s:text>:
											</label> <s:property value="#session.taxPayer.rectorFirstName" /></th>
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
										<s:iterator value="#session.taxPayer.activeDebtList"
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
								<s:iterator value="#session.taxPayer.activeDebtList"
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
										<s:iterator value="#session.taxPayer.calls" status="stat"
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
													value="#session.taxPayer.companyName + '  ' +#session.taxPayer.etype" /></th>
											<th><label class="control-label" for="regNumber">
													<s:text name="regNumber"></s:text>:
											</label> <s:property value="#session.taxPayer.regNumber" /></th>
											<th><label class="control-label" for="phoneNumber">
													<s:text name="phoneNumber"></s:text>:
											</label> <s:property value="#session.taxPayer.phoneNumber" /></th>
											<th><label class="control-label" for="email"> <s:text
														name="email"></s:text>:
											</label> <s:property value="#session.taxPayer.email" /></th>
										</tr>
										<tr>
											<th><label class="control-label" for="rectorLastName">
													<s:text name="rectorLastName"></s:text>:
											</label> <s:property value="#session.taxPayer.rectorLastName" /></th>
											<th><label class="control-label" for="rectorFirstName">
													<s:text name="rectorFirstName"></s:text>:
											</label> <s:property value="#session.taxPayer.rectorFirstName" /></th>
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
										<s:iterator value="#session.taxPayer.activeDebtList"
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
								<s:iterator value="#session.taxPayer.activeDebtList"
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
										<s:iterator value="#session.taxPayer.calls" status="stat"
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
										<s:select list="#session.taxPayer.phones"
											id="mainNumberSelect" listKey="number" listValue="number"
											key="phoneNumber" value="#session.taxPayer.phoneNumber"></s:select>
									</div>
									<div class="col-sm-1">
										<button id="changeMainNumberBtn" class="btn btn-success">
											<s:text name="save" />
										</button>
									</div>
								</div>
								<div class="row col-sm-12">
									<table>
										<s:iterator value="#session.taxPayer.phones"
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
				</label> <s:property value="#session.taxPayer.companyName" /></th>
				<th><label class="control-label" for="phoneNumber"> <s:text
							name="phoneNumber"></s:text>:
				</label> <s:property value="#session.taxPayer.phoneNumber" /></th>
				<th><label class="control-label" for="rectorLastName">
						<s:text name="rectorLastName"></s:text>:
				</label> <s:property value="#session.taxPayer.rectorLastName" /></th>
				<th><label class="control-label" for="rectorFirstName">
						<s:text name="rectorFirstName"></s:text>:
				</label> <s:property value="#session.taxPayer.rectorFirstName" /></th>
				<th style="cursor:pointer" onclick="showTotalDialog()"><label style="cursor:pointer" class="col-sm-6 col-lg-6" for="total"> <s:text
							name="total" ></s:text>:
				</label>
					<div id="sumtotal" class="col-sm-6  col-lg-6"></div></th>
			</tr>
		</table>

	</div>
	<s:form action="#" cssClass="form-horizontal" id="addCommitment">
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
												</tr>
											</thead>
											<tbody>
												<s:iterator begin="0" end="#session.callCommitments[#stat.index].listsize" status="statUnit">
													<tr>
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
													</tr>
												</s:iterator>
													
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
<div class = "hide" id = "showTotal-dialog">
		<div class = "row">
			<div class="col-sm-offset-4 col-sm-4">
				<h4 > Тайлан</h4>
			</div>
			<div class="col-sm-4">
				<h4 > Хяналт шалгалт</h4>
			</div>
		</div>
	<div class = "row">
		<div class="col-sm-4">
			<h5><s:text name="total"/> </h5>
		</div>
		<div class="col-sm-4">
			<h5 id = "subshowTotal_1">  </h5>
		</div>
		<div class="col-sm-4">
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
<div id="context" class="hide">${pageContext.request.contextPath}
</div>
<script src="../js/PageJS/taxpayer-search.js"></script>
<%}%>