<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
	if (request.getAttribute("accountSuccess") == null) {
%>
<s:fielderror fieldName="number" id="number" />
<s:fielderror fieldName="bankName" id="bankName" />
<s:fielderror fieldName="debtTypeNumber" id="debtTypeNumber" />
<s:fielderror fieldName="officeNumber" id="officeNumber" />
<%
	}
%>
	