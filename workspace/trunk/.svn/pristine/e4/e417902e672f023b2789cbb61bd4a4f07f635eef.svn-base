<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="display" uri="http://displaytag.sf.net"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="hidden" id="page">
	<s:url action="search-patient" includeParams="none" />
</div>
<div class="page-content">
	<div class="page-header">
		<h2>
			<s:text name="addPatient" />
		</h2>
	</div>
	<div class="row">
		<div class="col-sm-12 col-lg-12">
			<s:form action="savePatient">
				<s:hidden key="id" />
				<s:hidden key="addId" />
				<div class="form-group">
					<label for="regNumber"
						class="control-label col-sm-4 col-lg-offset-1 col-lg-3"> <s:text
							name="regNumber" />:
					</label>
					<div class="col-sm-7 col-lg-6">
						<div class="input-group">
							<span class="input-group-addon"> <i
								class="icon icon-product"></i>
							</span>
							<s:textfield key="regNumber" cssClass="form-control focus"
								id="regNumber" />
						</div>
						<div class="col-sm-7 col-lg-6">
							<s:fielderror fieldName="regNumber"></s:fielderror>
						</div>
					</div>
				</div>
				<div class="form-group">
					<label for="lastName"
						class="control-label col-sm-4 col-lg-offset-1 col-lg-3"> <s:text
							name="lastName" />(*):
					</label>
					<div class="col-sm-7 col-lg-6">
						<div class="input-group">
							<span class="input-group-addon"> <i
								class="icon icon-product"></i>
							</span>
							<s:textfield key="lastName" cssClass="form-control focus"
								id="lastName" requiredLabel="true" />
						</div>
						<div class="col-sm-7 col-lg-6">
							<s:fielderror fieldName="lastName"></s:fielderror>
						</div>
					</div>
				</div>
				<div class="form-group">
					<label for="firstName"
						class="control-label col-sm-4 col-lg-offset-1 col-lg-3"> <s:text
							name="firstName" />(*):
					</label>
					<div class="col-sm-7 col-lg-6">
						<div class="input-group">
							<span class="input-group-addon"> <i
								class="icon icon-product"></i>
							</span>
							<s:textfield key="firstName" cssClass="form-control focus"
								id="firstName" requiredLabel="true" />
						</div>
						<div class="col-sm-7 col-lg-6">
							<s:fielderror fieldName="firstName"></s:fielderror>
						</div>
					</div>
				</div>
				<div class="form-group">
					<label for="cardNumber"
						class="control-label col-sm-4 col-lg-offset-1 col-lg-3"> <s:text
							name="cardNumber" />:
					</label>
					<div class="col-sm-7 col-lg-6">
						<div class="input-group">
							<span class="input-group-addon"> <i
								class="icon icon-product"></i>
							</span>
							<s:textfield key="cardNumber" cssClass="form-control focus"
								id="cardNumber" value="%{#session.newCardNumber}" />
						</div>
						<div class="col-sm-7 col-lg-6">
							<s:fielderror fieldName="cardNumber"></s:fielderror>
						</div>
					</div>
				</div>
				<div class="form-group">
					<label for="birthday"
						class="control-label col-sm-4 col-lg-offset-1 col-lg-3"> <s:text
							name="birthday" />:
					</label>
					<div class="col-sm-7 col-lg-6">
						<div class="input-group">
							<span class="input-group-addon"> <i
								class="icon icon-product"></i>
							</span>
							<s:textfield key="birthdayStr" cssClass="form-control focus"
								id="birthday" class="date" />
						</div>
						<div class="col-sm-7 col-lg-6">
							<s:fielderror fieldName="birthday"></s:fielderror>
						</div>
					</div>
				</div>
				<div class="form-group">
					<label for="sex"
						class="control-label col-sm-4 col-lg-offset-1 col-lg-3"> <s:text
							name="sex" />:
					</label>
					<div class="col-sm-7 col-lg-6">
						<div class="input-group">
							<span class="input-group-addon"> <i
								class="icon icon-product"></i>
							</span>
							<s:select key="sex" list="sexs"
								listValue="%{getText(toString())}"
								headerValue="%{getText('choseValue')}" cssClass="form-control"
								id="sex" />
						</div>
					</div>
				</div>
				<div class="form-group">
					<label for="mobil_1"
						class="control-label col-sm-4 col-lg-offset-1 col-lg-3"> <s:text
							name="mobil_1" />:
					</label>
					<div class="col-sm-7 col-lg-6">
						<div class="input-group">
							<span class="input-group-addon"> <i
								class="icon icon-product"></i>
							</span>
							<s:textfield key="mobil_1" cssClass="form-control focus"
								id="mobil_1" />
						</div>
						<div class="col-sm-7 col-lg-6">
							<s:fielderror fieldName="mobil_1"></s:fielderror>
						</div>
					</div>
				</div>
				<div class="form-group">
					<label for="mobil_2"
						class="control-label col-sm-4 col-lg-offset-1 col-lg-3"> <s:text
							name="mobil_2" />:
					</label>
					<div class="col-sm-7 col-lg-6">
						<div class="input-group">
							<span class="input-group-addon"> <i
								class="icon icon-product"></i>
							</span>
							<s:textfield key="mobil_2" cssClass="form-control focus"
								id="mobil_2" />
						</div>
					</div>
				</div>
				<div class="form-group">
					<label for="phone"
						class="control-label col-sm-4 col-lg-offset-1 col-lg-3"> <s:text
							name="phone" />:
					</label>
					<div class="col-sm-7 col-lg-6">
						<div class="input-group">
							<span class="input-group-addon"> <i
								class="icon icon-product"></i>
							</span>
							<s:textfield key="phone" cssClass="form-control focus" id="phone" />
						</div>
					</div>
				</div>
				<div class="form-group">
					<label for="occupation"
						class="control-label col-sm-4 col-lg-offset-1 col-lg-3"> <s:text
							name="occupation" />:
					</label>
					<div class="col-sm-7 col-lg-6">
						<div class="input-group">
							<span class="input-group-addon"> <i
								class="icon icon-product"></i>
							</span>
							<s:textfield key="occupation" cssClass="form-control focus"
								id="occupation" />
						</div>
					</div>
				</div>
				<div class="form-group">
					<label for="addressCity"
						class="control-label col-sm-4 col-lg-offset-1 col-lg-3"> <s:text
							name="address.city" />:
					</label>
					<div class="col-sm-7 col-lg-6">
						<div class="input-group">
							<span class="input-group-addon"> <i
								class="icon icon-product"></i>
							</span>
							<s:textfield key="addressCity" cssClass="form-control focus"
								id="address.city" />
						</div>
					</div>
				</div>
				<div class="form-group">
					<label for="addressDestrict"
						class="control-label col-sm-4 col-lg-offset-1 col-lg-3"> <s:text
							name="address.destrict" />:
					</label>
					<div class="col-sm-7 col-lg-6">
						<div class="input-group">
							<span class="input-group-addon"> <i
								class="icon icon-product"></i>
							</span>
							<s:textfield key="addressDestrict" cssClass="form-control focus"
								id="address.destrict" />
						</div>
					</div>
				</div>
				<div class="form-group">
					<label for="addressSection"
						class="control-label col-sm-4 col-lg-offset-1 col-lg-3"> <s:text
							name="address.section" />:
					</label>
					<div class="col-sm-7 col-lg-6">
						<div class="input-group">
							<span class="input-group-addon"> <i
								class="icon icon-product"></i>
							</span>
							<s:textfield key="addressSection" cssClass="form-control focus"
								id="address.section" />
						</div>
					</div>
				</div>
				<div class="form-group">
					<label for="addressApartment"
						class="control-label col-sm-4 col-lg-offset-1 col-lg-3"> <s:text
							name="address.apartment" />:
					</label>
					<div class="col-sm-7 col-lg-6">
						<div class="input-group">
							<span class="input-group-addon"> <i
								class="icon icon-product"></i>
							</span>
							<s:textfield key="addressApartment" cssClass="form-control focus"
								id="address.apartment" />
						</div>
					</div>
				</div>

				<div class="form-group">
					<div class="col-sm-offset-1 col-sm-3 col-lg-offset-2 col-lg-2">
						<a onclick="window.history.back()" class="btn btn-back btn-block">
							<span class="fa fa-arrow-circle-o-left"></span>&nbsp; <s:text
								name="back" />
						</a>
					</div>
					<div class="col-sm-3 col-lg-2">
						<button type="reset" class="btn btn-gray btn-block">
							<span class="fa fa-refresh"></span>&nbsp;
							<s:text name="reset" />
						</button>
					</div>
					<div class="col-sm-4">
						<button type="submit" id="search"
							class="btn btn-success btn-block">
							<span class="fa fa-search"></span>&nbsp;
							<s:text name="save" />
						</button>
					</div>
				</div>
			</s:form>
		</div>
	</div>
</div>
		<script>
			$(document).ready(function() {
				$("#birthday").datepicker({
					changeMonth : true,
					changeYear : true,
					dateFormat : "yy-mm-dd",
				});
			});
		
			
		</script>