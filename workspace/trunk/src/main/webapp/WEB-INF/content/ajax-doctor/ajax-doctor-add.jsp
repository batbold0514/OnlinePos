<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
	if (request.getAttribute("DoctorSuccess") == null) {
%>
<s:fielderror fieldName="registrationNumber" id="errorRegistrationNumber" />
<s:fielderror fieldName="familyName" id="errorFamilyName" />
<s:fielderror fieldName="name" id="errorName" />
<s:fielderror fieldName="mobile1" id="errorMobile1" />
<s:fielderror fieldName="mobile2" id="errorMobile2" />
<s:fielderror fieldName="phoneNumber" id="errorPhoneNumber" />
<s:fielderror fieldName="doctorUserString" id="errorDoctorUserString" />
<%
	}
%>
