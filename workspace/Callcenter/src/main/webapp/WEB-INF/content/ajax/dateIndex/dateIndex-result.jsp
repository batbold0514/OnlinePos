<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
	if (request.getAttribute("dateIndexSuccess") == null) {
%>
<s:fielderror fieldName="min" id="min" />
<s:fielderror fieldName="max" id="max" />
<s:fielderror fieldName="date_index" id="date_index" />
<%
	}
%>
	