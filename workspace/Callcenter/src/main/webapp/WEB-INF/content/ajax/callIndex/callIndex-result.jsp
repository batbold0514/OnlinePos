<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
	if (request.getAttribute("callIndexSuccess") == null) {
%>
<s:fielderror fieldName="callIndex" id="callIndex" />
<s:fielderror fieldName="callQuantity" id="callQuantity" />
<%
	}
%>
	