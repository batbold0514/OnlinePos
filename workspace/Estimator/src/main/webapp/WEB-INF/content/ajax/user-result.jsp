<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
	if (request.getAttribute("successUser") == null) {
%>
<s:fielderror fieldName="userName" id="userName" />
<s:fielderror fieldName="roleString" id="roleString" />
<s:fielderror fieldName="pwd" id="pwd" />
<s:fielderror fieldName="confirmPwd" id="confirmPwd" />
<s:fielderror fieldName="code" id="code" />
<%
	}
%>
	