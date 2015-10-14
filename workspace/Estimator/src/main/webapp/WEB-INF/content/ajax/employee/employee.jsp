<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
	if (request.getAttribute("employeeSuccess") == null) {
%>
<s:fielderror fieldName="lastName" id="lastName" />
<s:fielderror fieldName="firstName" id="firstName" />
<s:fielderror fieldName="phoneNumber" id="phoneNumber" />
<s:fielderror fieldName="regNumber" id="regNumber" />
<s:fielderror fieldName="status" id="status" />
<%
	}
%>
	