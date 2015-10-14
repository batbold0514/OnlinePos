<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="display" uri="http://displaytag.sf.net"%>
<style>
#hoho:hover {
	text-decoration: underline;
	color: red;
}

#hoho {
	font-family: comic sans ms;
}
</style>
<div class="profile-user-info profile-user-info-striped">
<s:hidden key="id" value="%{#session.id.id}"/>
	<div class="profile-info-row">
		<div class="profile-info-name">
			<s:text name="regNumber" />
		</div>

		<div class="profile-info-value">
			<s:if test="%{#session.id.regNumber==''}">
				<s:label key="regNumber" value="" id="regNumber" />
			</s:if>
			<s:else>
				<s:label key="regNumber" id="regNumber"  value="%{#session.id.regNumber}"/>
			</s:else>
		</div>
	</div>
	<div class="profile-info-row">
		<div class="profile-info-name">
			<s:text name="lastName" />
		</div>
		<div class="profile-info-value">
			<s:label key="lastName" id="lastName"  value="%{#session.id.lastName}"/>
		</div>
	</div>
	<div class="profile-info-row">
		<div class="profile-info-name">
			<s:text name="firstName" />
		</div>

		<div class="profile-info-value">
			<s:label key="firstName" id="firstName"  value="%{#session.id.firstName}"/>
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
				<s:label key="cardNumber" id="cardNumber"  value="%{#session.id.cardNumber}"/>
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
				<s:label key="birthday" id="birthday"  value="%{#session.id.birthday}"/>
			</s:else>
		</div>
	</div>
	<div class="profile-info-row">
		<div class="profile-info-name">
			<s:text name="age" />
		</div>

		<div class="profile-info-value">
			<s:label key="age" id="age"  value="%{#session.id.age}"/>
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
				<s:label key="mobil_1" id="mobil_1"  value="%{#session.id.mobil_1}"/>
			</s:else>
		</div>
	</div>
	<div class="profile-info-row">
		<div class="profile-info-name">
			<s:text name="mobil_2" />
		</div>

		<div class="profile-info-value">
			<s:if test="%{#session.id.mobil_2==''}">
				<s:label key="mobil_2" value="" id="mobil_2" />
			</s:if>
			<s:else>
				<s:label key="mobil_2" id="mobil_2"  value="%{#session.id.mobil_2}"/>
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
				<s:label key="phone" id="phone"  value="%{#session.id.phone}"/>
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
				<s:label key="occupation" id="occupation"  value="%{#session.id.occupation}"/>
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
				<s:label key="address.city" id="address.city"  value="%{#session.id.address.city}"/>
			</s:else>
		</div>
	</div>
	<div class="profile-info-row">
		<div class="profile-info-name">
			<s:text name="address.destrict" />
		</div>
		<div class="profile-info-value">
			<s:if test="%{#session.id.address.destrict==''}">
				<s:label key="address.destrict" value="" id="address.destrict" />
			</s:if>
			<s:else>
				<s:label key="address.destrict" id="address.destrict"  value="%{#session.id.address.destrict}"/>
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
				<s:label key="address.section" id="address.section" value="%{#session.id.address.section}"/>
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
				<s:label key="address.apartment" id="address.apartment" value="%{#session.id.address.apartment}"/>
			</s:else>
		</div>
	</div>
</div>
<div class="row">
	<div class="col-sm-offset-1 col-sm-12">
		<s:form action="linkSession">
			<s:hidden key="id" value = "%{#session.id.id}"/>
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
			<s:hidden key="id" value = "%{#session.id.id}"/>
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
			<s:hidden key="id" value = "%{#session.id.id}"/>
			<button class="btn btn-warning col-sm-10">
				<i class="icon-th-list"></i> <span> <s:text
						name="history" /></span>
			</button>
		</s:form>
	</div>
</div>
<script>
	jQuery(function($) {
		$("#birthday").datepicker({
			changeMonth : true,
			changeYear : true,
			dateFormat : "yy-mm-dd"
		});
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
</script>