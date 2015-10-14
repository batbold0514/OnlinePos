<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
	if (request.getAttribute("patientSuccess") == null) {
%>
<s:fielderror fieldName="cardNumber" id="errorCardNumber" />
<s:fielderror fieldName="regNumber" id="errorRegNumber" />
<s:fielderror fieldName="mobil_1" id="errorMobil_1" />
<s:fielderror fieldName="firstName" id="errorFirstName" />
<s:fielderror fieldName="lastName" id="errorLastName" />
<%
	}
%>
