<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
	if (request.getAttribute("successenquireType") == null) {
%>
<s:fielderror fieldName="desctiption" id="desctiption" />
<%
	}
%>
	