<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
	if (request.getAttribute("companySuccess") == null) {
%>
<s:fielderror fieldName="compName" id="compName" />
<s:fielderror fieldName="addresss" id="address" />
<s:fielderror fieldName="phoneNumber" id="phoneNumber" />
<%
	}
%>
	