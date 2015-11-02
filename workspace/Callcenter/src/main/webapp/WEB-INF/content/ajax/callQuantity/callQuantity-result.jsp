<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
	if (request.getAttribute("callQuantitySuccess") == null) {
%>
<s:fielderror fieldName="count" id="count" />
<%
	}
%>
	