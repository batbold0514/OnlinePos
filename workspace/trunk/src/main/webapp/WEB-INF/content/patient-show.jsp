<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="display" uri="http://displaytag.sf.net"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="hidden" id="page">
	<s:url action="search-patient" includeParams="none" />
</div>
<s:set var="user">${pageContext.request.remoteUser}</s:set>
<style>
#hoho:hover {
	text-decoration: underline;
	color: red;
}

#hoho {
	font-family: comic sans ms;
}

#collapseDown {
	width: 100%;
}
</style>
<div class="page-content">
	<div class="page-header">
		<h2>
			<s:text name="patient" />
		</h2>
	</div>
	<div class="row">
		<div class="col-sm-12 col-lg-12">
			<s:form>
				<s:hidden key="id" />
				<s:hidden key="addressId" />
				<div class="span4 col-sm-5 col-lg-5">
					<div id="show-result">
						<div class="profile-user-info profile-user-info-striped">
							<div class="profile-info-row">
								<div class="profile-info-name">
									<s:text name="regNumber" />
								</div>

								<div class="profile-info-value">
									<s:if test="%{#session.id.regNumber==''}">
										<s:label key="regNumber" value="" id="regNumber" />
									</s:if>
									<s:else>
										<s:label key="regNumber" id="regNumber" />
									</s:else>
								</div>
							</div>
							<div class="profile-info-row">
								<div class="profile-info-name">
									<s:text name="lastName" />
								</div>
								<div class="profile-info-value">
									<s:label key="lastName" id="lastName" />
								</div>
							</div>
							<div class="profile-info-row">
								<div class="profile-info-name">
									<s:text name="firstName" />
								</div>
								<div class="profile-info-value">
									<s:label key="firstName" id="firstName" />
									<div class="pull-right">
										<table id="editBtn">
											<tr>
												<td><i class="icon-edit"></i></td>
											</tr>
										</table>
									</div>
								</div>
							</div>
							<div class="profile-info-row">
								<div class="profile-info-name">
									<s:text name="cardNumber" />
								</div>

								<div class="profile-info-value">
									<s:if test="%{#session.id.cardNumber==''}">
										<s:label key="cardNumber" value="" id="cardNumber" />
									</s:if>
									<s:else>
										<s:label key="cardNumber" id="cardNumber" />
									</s:else>
								</div>
							</div>
							<div class="profile-info-row">
								<div class="profile-info-name">
									<s:text name="birthday" />
								</div>

								<div class="profile-info-value">
									<s:if test="%{#session.id.birthday==null}">
										<s:label key="birthday" value="" id="birthday" />
									</s:if>
									<s:else>
										<s:label key="birthday" id="birthday" />
									</s:else>
								</div>
							</div>
							<div class="profile-info-row">
								<div class="profile-info-name">
									<s:text name="age" />
								</div>

								<div class="profile-info-value">
									<s:label key="age" id="age" />
								</div>
							</div>
							<div class="profile-info-row">
								<div class="profile-info-name">
									<s:text name="mobil_1" />
								</div>

								<div class="profile-info-value">
									<s:if test="%{#session.id.mobil_1==''}">
										<s:label key="mobil_1" value="" id="mobil_1" />
									</s:if>
									<s:else>
										<s:label key="mobil_1" id="mobil_1" />
									</s:else>
								</div>
							</div>
							<div class="hide" id="collapseProf">
								<div class="profile-info-row">
									<div class="profile-info-name">
										<s:text name="mobil_2" />
									</div>

									<div class="profile-info-value">
										<s:if test="%{#session.id.mobil_2==''}">
											<s:label key="mobil_2" value="" id="mobil_2" />
										</s:if>
										<s:else>
											<s:label key="mobil_2" id="mobil_2" />
										</s:else>
									</div>
								</div>
								<div class="profile-info-row">
									<div class="profile-info-name">
										<s:text name="phone" />
									</div>

									<div class="profile-info-value">
										<s:if test="%{#session.id.phone==''}">
											<s:label key="phone" value="" id="phone" />
										</s:if>
										<s:else>
											<s:label key="phone" id="phone" />
										</s:else>
									</div>
								</div>
								<div class="profile-info-row">
									<div class="profile-info-name">
										<s:text name="occupation" />
									</div>

									<div class="profile-info-value">
										<s:if test="%{#session.id.occupation==''}">
											<s:label key="occupation" value="" id="occupation" />
										</s:if>
										<s:else>
											<s:label key="occupation" id="occupation" />
										</s:else>
									</div>
								</div>
								<div class="profile-info-row">
									<div class="profile-info-name">
										<s:text name="address.city" />
									</div>

									<div class="profile-info-value">
										<s:if test="%{#session.id.address.city==''}">
											<s:label key="address.city" value="" id="address.city" />
										</s:if>
										<s:else>
											<s:label key="address.city" id="address.city" />
										</s:else>
									</div>
								</div>
								<div class="profile-info-row">
									<div class="profile-info-name">
										<s:text name="address.destrict" />
									</div>
									<div class="profile-info-value">
										<s:if test="%{#session.id.address.destrict==''}">
											<s:label key="address.destrict" value=""
												id="address.destrict" />
										</s:if>
										<s:else>
											<s:label key="address.destrict" id="address.destrict" />
										</s:else>
									</div>
								</div>
								<div class="profile-info-row">
									<div class="profile-info-name">
										<s:text name="address.section" />
									</div>

									<div class="profile-info-value">
										<s:if test="%{#session.id.address.section==''}">
											<s:label key="address.section" value="" id="address.section" />
										</s:if>
										<s:else>
											<s:label key="address.section" id="address.section" />
										</s:else>
									</div>
								</div>
								<div class="profile-info-row">
									<div class="profile-info-name">
										<s:text name="address.apartment" />
									</div>
									<div class="profile-info-value">
										<s:if test="%{#session.id.address.apartment==''}">
											<s:label key="address.apartment" value=""
												id="address.apartment" />
										</s:if>
										<s:else>
											<s:label key="address.apartment" id="address.apartment" />
										</s:else>
									</div>
								</div>
							</div>
							<div id="collapseDown">
								<span class="pull-right" id="blah"><i
									class="icon-double-angle-down" id="collapseIcon"></i></span>
							</div>
						</div>
						<div class="row">
							<div class="col-sm-offset-1 col-sm-12">
								<s:form></s:form>
								<s:form action="linkSession">
									<s:hidden key="id" />
									<s:hidden key="userId" value="%{user}" />
									<button class="btn btn-success col-sm-10">
										<i class="icon-plus-sign"></i> <span><s:text
												name="addSession" /></span>
									</button>
								</s:form>
							</div>
						</div>
						<div class="row">
							<div class="col-sm-offset-1 col-sm-12">
								<s:form action="payment">
									<s:hidden key="id" />
									<button class="btn btn-primary col-sm-10">
										<i class="icon-plus"></i> <span><s:text
												name="addPayment" /></span>
									</button>
								</s:form>
							</div>
						</div>
						<div class="row">
							<div class="col-sm-offset-1 col-sm-12">
								<s:form action="history">
									<s:hidden key="id" />
									<button class="btn btn-warning col-sm-10">
										<i class="icon-th-list"></i> <span> <s:text
												name="history" /></span>
									</button>
								</s:form>
							</div>
						</div>
					</div>
				</div>

				<div class="span4 col-sm-7 col-lg-7">
					<div class="widget-box">
						<s:include value="SessionPayment.jsp"></s:include>
					</div>
				</div>
			</s:form>
		</div>
	</div>
</div>
<div id="dialog-edit" class="hide">
	<s:form action="savePatient" cssClass="form-horizontal" id="addForm">
		<s:push value="patient">
			<s:hidden name="id" />
			<s:hidden key="addId" value="%{#session.id.address.id}" />
			<div class="form-group">
				<div class="row">
					<div class="col-sm-12">
						<label for="regNumber" class="control-label col-sm-5 col-lg-5">
							<s:text name="regNumber" />(*):
						</label>
						<div class="col-sm-7 col-lg-6">
							<s:textfield name="regNumber" cssClass="form-control"
								id="regNumber" autofocus="" />
						</div>
					</div>
				</div>
				<div class="row">
					<div class="col-sm-offset-4 col-sm-7 col-lg-offset-3 col-lg-6"
						id="errorRegNumberResult">
						<s:fielderror fieldName="regNumber" />
					</div>
				</div>
			</div>
			<div class="form-group">
				<div class="row">
					<div class="col-sm-12">
						<label for="lastName" class="control-label col-sm-5 col-lg-5">
							<s:text name="lastName" />(*):
						</label>
						<div class="col-sm-7 col-lg-6">
							<s:textfield name="lastName" cssClass="form-control"
								id="lastName" autofocus="" />
						</div>
					</div>
				</div>
				<div class="row">
					<div class="col-sm-offset-4 col-sm-7 col-lg-offset-4 col-lg-6"
						id="errorLastNameResult">
						<s:fielderror fieldName="lastName" />
					</div>
				</div>
			</div>
			<div class="form-group">
				<div class="row">
					<div class="col-sm-12">
						<label for="firstName" class="control-label col-sm-5 col-lg-5">
							<s:text name="firstName" />(*):
						</label>
						<div class="col-sm-7 col-lg-6">
							<s:textfield name="firstName" cssClass="form-control"
								id="firstName" autofocus="" />
						</div>
					</div>
				</div>
				<div class="row">
					<div class="col-sm-offset-4 col-sm-7 col-lg-offset-4 col-lg-6"
						id="errorFirstNameResult">
						<s:fielderror fieldName="firstName" />
					</div>
				</div>
			</div>
			<%
				if (request.isUserInRole("admin-role")) {
			%>
			<div class="form-group">
				<div class="row">
					<div class="col-sm-12">
						<label for="cardNumber" class="control-label col-sm-5 col-lg-5">
							<s:text name="cardNumber" />(*):
						</label>
						<div class="col-sm-7 col-lg-6">
							<s:textfield name="cardNumber" cssClass="form-control"
								id="cardNumber" autofocus="" />
						</div>
					</div>
				</div>
				<div class="row">
					<div class="col-sm-offset-4 col-sm-7 col-lg-offset-4 col-lg-6"
						id="errorCardNumberResult">
						<s:fielderror fieldName="cardNumber" />
					</div>
				</div>
			</div>
			<%
				} else {
			%>
			<div class="form-group">
				<div class="row">
					<div class="col-sm-12">
						<label for="cardNumber" class="control-label col-sm-5 col-lg-5">
							<s:text name="cardNumber" />(*):
						</label>
						<div class="col-sm-7 col-lg-6">
							<s:textfield name="cardNumber" cssClass="form-control"
								id="cardNumber" autofocus="" readonly="true" />
						</div>
					</div>
				</div>
				<div class="row">
					<div class="col-sm-offset-4 col-sm-7 col-lg-offset-4 col-lg-6"
						id="errorCardNumberResult">
						<s:fielderror fieldName="cardNumber" />
					</div>
				</div>
			</div>
			<%
				}
			%>
			<div class="form-group">
				<div class="row">
					<div class="col-sm-12">
						<label for="birthday" class="control-label col-sm-5 col-lg-5">
							<s:text name="birthday" />(*):
						</label>
						<div class="col-sm-7 col-lg-6">
							<s:textfield name="birthdayStr" cssClass="form-control"
								id="birthday" autofocus="" />
						</div>
					</div>
				</div>
			</div>
			<div class="form-group">
				<div class="row">
					<div class="col-sm-12">
						<label for="sex" class="control-label col-sm-5 col-lg-5">
							<s:text name="sex" />(*):
						</label>
						<div class="col-sm-7 col-lg-6">
							<s:select key="sex" list="sexs"
								listValue="%{getText(toString())}"
								headerValue="%{getText('choseValue')}" />
						</div>
					</div>
				</div>
			</div>
			<div class="form-group">
				<div class="row">
					<div class="col-sm-12">
						<label for="mobil_1" class="control-label col-sm-5 col-lg-5">
							<s:text name="mobil_1" />(*):
						</label>
						<div class="col-sm-7 col-lg-6">
							<s:textfield name="mobil_1" cssClass="form-control" id="mobil_1"
								autofocus="" />
						</div>
					</div>
				</div>
				<div class="row">
					<div class="col-sm-offset-4 col-sm-7 col-lg-offset-4 col-lg-6"
						id="errorMobil_1Result">
						<s:fielderror fieldName="mobil_1" />
					</div>
				</div>
			</div>
			<div class="form-group">
				<div class="row">
					<div class="col-sm-12">
						<label for="mobil_2" class="control-label col-sm-5 col-lg-5">
							<s:text name="mobil_1" />(*):
						</label>
						<div class="col-sm-7 col-lg-6">
							<s:textfield name="mobil_2" cssClass="form-control" id="mobil_2"
								autofocus="" />
						</div>
					</div>
				</div>
			</div>
			<div class="form-group">
				<div class="row">
					<div class="col-sm-12">
						<label for="phone" class="control-label col-sm-5 col-lg-5">
							<s:text name="phone" />(*):
						</label>
						<div class="col-sm-7 col-lg-6">
							<s:textfield name="phone" cssClass="form-control" id="phone"
								autofocus="" />
						</div>
					</div>
				</div>
			</div>
			<div class="form-group">
				<div class="row">
					<div class="col-sm-12">
						<label for="occupation" class="control-label col-sm-5 col-lg-5">
							<s:text name="occupation" />(*):
						</label>
						<div class="col-sm-7 col-lg-6">
							<s:textfield name="occupation" cssClass="form-control"
								id="occupation" autofocus="" />
						</div>
					</div>
				</div>
			</div>
			<div class="form-group">
				<div class="row">
					<div class="col-sm-12">
						<label for="addressCity" class="control-label col-sm-5 col-lg-5">
							<s:text name="address.city" />(*):
						</label>
						<div class="col-sm-7 col-lg-6">
							<s:textfield name="addressCity" cssClass="form-control"
								value="%{address.city}" id="address.city" autofocus="" />
						</div>
					</div>
				</div>
			</div>
			<div class="form-group">
				<div class="row">
					<div class="col-sm-12">
						<label for="addressDestrict"
							class="control-label col-sm-5 col-lg-5"> <s:text
								name="address.destrict" />(*):
						</label>
						<div class="col-sm-7 col-lg-6">
							<s:textfield name="addressDestrict" cssClass="form-control"
								value="%{address.destrict}" id="address.destrict" autofocus="" />
						</div>
					</div>
				</div>
			</div>
			<div class="form-group">
				<div class="row">
					<div class="col-sm-12">
						<label for="addressSection"
							class="control-label col-sm-5 col-lg-5"> <s:text
								name="address.section" />(*):
						</label>
						<div class="col-sm-7 col-lg-6">
							<s:textfield name="addressSection" cssClass="form-control"
								id="address.section" autofocus="" value="%{address.section}" />
						</div>
					</div>
				</div>
			</div>
			<div class="form-group">
				<div class="row">
					<div class="col-sm-12">
						<label for="addressApartment"
							class="control-label col-sm-5 col-lg-5"> <s:text
								name="address.apartment" />(*):
						</label>
						<div class="col-sm-7 col-lg-6">
							<s:textfield name="AddressApartment" cssClass="form-control"
								id="address.apartment" autofocus="" value="%{address.apartment}" />
						</div>
					</div>
				</div>
			</div>
		</s:push>
	</s:form>
</div>
<script>
	jQuery(function($) {
		pageScript();
		$("#birthday").datepicker({
			changeMonth : true,
			changeYear : true,
			dateFormat : "yy-mm-dd"
		});
		$("#editBtn").hover(function() {
			$("#editBtn").css("background-color", "yellow");
			$("#editBtn").css({
				"cursor" : "pointer"
			});
		}, function() {
			$("#editBtn").css("background-color", "transparent");
			$("#editBtn").css({
				"cursor" : "default"
			});
		});
		$("#blah").click(function() {
			if ($("#collapseProf").hasClass('hide')) {
				$("#collapseProf").removeClass('hide');
				$("#collapseIcon").removeClass('icon-double-angle-down');
				$("#collapseIcon").addClass('icon-double-angle-up');
			} else {
				$("#collapseProf").addClass('hide');
				$("#collapseIcon").removeClass('icon-double-angle-up');
				$("#collapseIcon").addClass('icon-double-angle-down');
			}
		});
		$("#blah").hover(function() {
			$("#blah").css("background-color", "yellow");
			$("#blah").css({
				"cursor" : "pointer"
			});
		}, function() {
			$("#blah").css("background-color", "transparent");
			$("#blah").css({
				"cursor" : "default"
			});
		});

	});
	function pageScript() {
		$("#editBtn")
				.click(
						function(e) {
							e.preventDefault();
							var $dialogContent1 = $("#dialog-edit")
									.removeClass('hide')
									.dialog(
											{

												width : 450,
												modal : true,
												title : "Patient edit",
												buttons : [
														{
															html : "<i class='icon-remove bigger-110'></i>&nbsp; Cancel",
															"class" : "btn btn-danger btn-xs",
															click : function() {
																$(
																		".errorMessage")
																		.parents(
																				".form-group")
																		.removeClass(
																				"has-error");
																$(this)
																		.dialog(
																				"close");
															}
														},
														{
															html : "<i class='icon-save bigger-110'></i>&nbsp; Save",
															"class" : "btn btn-success btn-xs",
															click : function() {
																var dialog = this;
																ajaxResults(
																		$dialogContent1,
																		dialog);
															}
														} ]

											});
						});
		function ajaxResults($dialogContent, dialog) {
			$.ajax({
				url : "ajax-save-patient",
				data : $("#addForm").serialize(),
				success : function(result) {
					if (result.trim() != "") {
						$(".errorMessage").parents(".form-group").removeClass(
								"has-error");
						$(".errorMessage").remove();
						$().toastmessage('showErrorToast', "Алдаа гарлаа!");
						$("#parseResult").html(result);
						for ( var i = 0; $(".errorMessage").length > i; i++) {
							var idName = $(".errorMessage").eq(i).attr("id");
							$("#" + idName + "Result").html(
									$(".errorMessage").eq(i));
						}
						$(".errorMessage").parents(".form-group").addClass(
								"has-error");
					} else {
						$().toastmessage('showSuccessToast',
								"Амжилттай хадгалагдлаа");
						$.ajax({
							url : "patient-show-ajax",
							success : function(result) {
								$("#show-result").html(result);
								pageScript();
							}
						});
						$(".errorMessage").parents(".form-group").removeClass(
								"has-error");
						$(".errorMessage").remove();
						$(dialog).dialog("close");
					}
				}
			});
		}
	}
</script>
