<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!-- BEGIN TOP NAVIGATION BAR -->
<div class="header-inner">
	<!-- BEGIN LOGO -->
	<a class="navbar-brand" href="usersList"> <img
		src="../img/master-unelgee.png" alt="logo" class="img-responsive" />
	</a>

	<!-- END LOGO -->
	<!-- BEGIN RESPONSIVE MENU TOGGLER -->
	<a href="javascript:;" class="navbar-toggle" data-toggle="collapse"
		data-target=".navbar-collapse"> <img
		src="../assets/img/menu-toggler.png" alt="" />
	</a>
	<!-- END RESPONSIVE MENU TOGGLER -->

	<ul class="nav pull-right">
		<li><a href="logout"> <i class="icon-off"></i> <s:text
					name="logout" />
		</a></li>
	</ul>
</div>

<!-- END TOP NAVIGATION BAR -->
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
<div id="dialogLogoutTime" class="hide">
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


