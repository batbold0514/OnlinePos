<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
	if (request.getAttribute("dbInfo") == null) {
%>
<s:fielderror fieldName="url" id="url" />
<s:fielderror fieldName="username" id="username" />
<s:fielderror fieldName="password" id="password" />
<s:fielderror fieldName="downloadTime" id="downloadTime" />
<%
	}
%>
	