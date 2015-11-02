<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
	if (request.getAttribute("successDebtType") == null) {
%>
<s:fielderror fieldName="typeName" id="typeName" />
<s:fielderror fieldName="typeNumber" id="typeNumber" />
<s:fielderror fieldName="description" id="description" />
<%
	}
%>
	