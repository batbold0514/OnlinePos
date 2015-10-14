<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
	if (request.getAttribute("partPriceSuccess") == null) {
%>
<s:fielderror fieldName="dateStr" id="dateStr" />
<%
	}
%>
	