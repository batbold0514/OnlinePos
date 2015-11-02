<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<div class="header navbar navbar-default navbar-static-top">
	<!-- BEGIN TOP NAVIGATION BAR -->
	<div class="header-inner">
		<!-- BEGIN LOGO -->
		<%
		if (request.isUserInRole("admin-role")) {
			%>
			<a class="navbar-brand" href="adminlogin"> <img
				src="../img/mtalogo1.png" alt="logo" class="img-responsive" />
			</a>
			<%
		} else if (request.isUserInRole("operator")) {
			%>
			<a class="navbar-brand" href="userlogin"> <img
				src="../img/mtalogo1.png" alt="logo" class="img-responsive" />
			</a>
			<%
		}else{%>
		<a class="navbar-brand" href="seniorlogin"> <img
			src="../img/mtalogo1.png" alt="logo" class="img-responsive" />
		</a>
		<%
			}
		%>
		
		<!-- END LOGO -->
		<!-- BEGIN RESPONSIVE MENU TOGGLER -->
		<a href="javascript:;" class="navbar-toggle" data-toggle="collapse"
			data-target=".navbar-collapse"> <img
			src="../assets/img/menu-toggler.png" alt="" />
		</a>
		<!-- END RESPONSIVE MENU TOGGLER -->

		<!-- BEGIN HORIZANTAL MENU -->
		<div class="hor-menu hidden-sm hidden-xs">
			<ul class="nav navbar-nav">
			
					<%
						if (request.isUserInRole("admin-role")) {
						%>
						<li><a href="adminlogin"><s:text name="home" /></a>
						<%
					} else if (request.isUserInRole("operator")) {
						%>
						<li><a href="userlogin"><s:text name="home" /></a>
						<%
					}else{%>
					<li><a href="seniorlogin"><s:text name="home" /></a>
					<%
						}
					%>

				<%
					if (request.isUserInRole("senior-operator")) {
				%>
				<li><a href="operator-status"><s:text name="operatorStatus" /></a>
				<li><a data-hover="dropdown" data-close-others="true"
					class="dropdown-toggle" href="javascript:;"> <span
						class="selected"></span> <s:text name="plan"></s:text> <i
						class="icon-angle-down"></i>
				</a>
					<ul class="dropdown-menu">
						<li><a href="manage-operators"><s:text
									name="manageOperator" /></a></li>
						<li><a href="taxpayer-list"> <s:text name="taxpayerlist"></s:text></a></li>
						<li><a href="day-plan"><s:text name="dayplan" /></a></li>
					</ul></li>
				<%
					}
				%>
			
				<li><a data-hover="dropdown" data-close-others="true"
					class="dropdown-toggle" href="javascipt:;"><span
						class="selected"></span> <s:text name="report" /><i
						class="icon-angle-down"></i> </a>
					<ul class="dropdown-menu">
						<li><a href="call-report"><s:text name="callreport" /></a></li>
						<li><a href="process-report"><s:text name="processreport" /></a></li>
						<li><a href="connected-person-report"><s:text name="connectedpersonreport" /></a></li>
						<li><a href="return-report"><s:text name="returnreport" /></a></li>
						<li><a href="commitment-report"><s:text name="commitmentReport" /></a></li>
						<%
					if (request.isUserInRole("admin-role")
							|| request.isUserInRole("senior-operator")) {
					%>
						<li><a href="debt-report-pre"><s:text name="debtreport" /></a></li>
						<%} %>
					</ul>
				</li>
				<%
					if (request.isUserInRole("admin-role")
							|| request.isUserInRole("senior-operator")) {
				%>
				<li><a data-hover="dropdown" data-close-others="true"
					class="dropdown-toggle" href="javascript:;"> <span
						class="selected"></span> <s:text name="settings"></s:text> <i
						class="icon-angle-down"></i>
				</a>
					<ul class="dropdown-menu">
						<% if(request.isUserInRole("admin-role")){ %>
						<li><a href="usersList"><s:text name="operator" /></a></li>
						<li><a href="usersListInActive"><s:text name="inactiveOperator" /></a></li>
						<% } %>
						<li><a href="reasons"><s:text name="reasons" /></a></li>
						<li><a href="returnReason"><s:text name="returnReason" /></a></li>
						<li><a href="call-duration"><s:text name="callDuration" /></a></li>
						<li><a href="debtTypes"><s:text name="debtType" /></a></li>
						<li><a href="moneyIndexsList"><s:text name="moneyIndexs" /></a></li>
						<li><a href="dateIndexsList"><s:text name="dateIndexs" /></a></li>
						<li><a href="callIndexs"><s:text name="callIndexs" /></a></li>
						<li><a href="callQuantitys"><s:text name="callQuantitys" /></a></li>
						<li><a href="maxPrices"><s:text name="maxPrices" /></a></li>
						<li><a href="connected-people"><s:text name="connected-people" /></a></li>
						<li><a href="account-number"><s:text name="accountNumber" /></a></li>
						<li><a href="" id="logoutTimeHeader"><s:text
									name="logoutTime" /></a></li>
						<li><a href="dataDownload" id="logoutTimeHeader"><s:text
									name="dataDownload" /></a></li>
					</ul></li>
					<% } %>
				<li><span class="hor-menu-search-form-toggler">&nbsp;</span>
					<div class="search-form">
						<form class="form-search">
							<div class="input-group">
								<input type="text" placeholder="Search..." class="form-control">
								<div class="input-group-btn">
									<button type="button" class="btn"></button>
								</div>
							</div>
						</form>
					</div></li>
			</ul>
		</div>
		<!-- END HORIZANTAL MENU -->

	</div>

	<ul class="nav pull-right">
		<li><a href="logout"> <i class="icon-off"></i> <s:text
					name="logout" />
		</a></li>
	</ul>
	<!-- END TOP NAVIGATION BAR -->
</div>
<!-- END HEADER-->
<script type="text/javascript">
	jQuery(document)
			.ready(
					function() {
						$("#time").timepicker({
							minuteStep : 1,
							secondStep : 5,
							showInputs : false,
							template : 'modal',
							modalBackdrop : true,
							showSeconds : true,
							showMeridian : false
						});
						$("#time").keydown(function(e) {
							if (e.which == 13) {
								$("#btnOk").trigger("click");
							}
						});
						$('#addLogoutTime')
								.bootstrapValidator(
										{
											fields : {
												time : {
													validators : {
														notEmpty : {
															message : 'Хоосон байна'
														},
														regexp : {
															regexp : /^[0-2][0-9]:[0-5][0-9]:[0-5][0-9]$/,
															message : '23:59:59 байж болно'
														}
													}
												}
											}
										}).on(
										'success.form.bv',
										function(e) {
											e.preventDefault();
											$.post('saveLogoutTime', $(
													"#addLogoutTime")
													.serialize(), function(
													result) {
												$("#logoutTime").html(result);
												$("#dialogLogoutTime").dialog(
														"close");
												zeroTime();
											});
										});
						$("#logoutTimeHeader").click(function(e) {
							e.preventDefault();
							$("#dialogLogoutTime").dialog('open');
						});
						$("#dialogLogoutTime")
								.dialog(
										{
											title : 'Гарах хугацаа',
											title_html : true,
											autoOpen : false,
											modal : true,
											width : 400,
											height : 200,
											buttons : [
													{
														html : "<i class='icon-check bigger-110'></i>&nbsp; Хадгалах",
														"class" : "btn btn-success btn-xs",
														"id" : "btnOk",
														click : function() {
															$("#submitHeader")
																	.trigger(
																			"click");
														}
													},
													{
														html : "<i class='icon-check bigger-110'></i>&nbsp; Болих",
														"class" : "btn btn-danger btn-xs",
														"id" : "btnBack",
														click : function() {
															$(this).dialog(
																	"close");
														}
													} ]
										}).prev(".ui-dialog-titlebar").css(
										"background", "#5cb85c");
					});
</script>
<div id="dialogLogoutTime">
	<s:form cssClass="form-horizontal" id="addLogoutTime">
		<s:hidden name="id" value="%{#session.logoutTime.id}" />
		<div class="form-group">
			<div class="row">
				<div class="col-sm-12">
					<label for="time" class="control-label col-sm-5 col-lg-5">
						<s:text name="time" />:
					</label>
					<div class="col-sm-7 col-lg-6">
						<s:textfield name="time" id="time"
							value="%{#session.logoutTime.time}" />
					</div>
				</div>
			</div>
		</div>
		<input id="submitHeader" type="submit" class="hide" />
	</s:form>
</div>


