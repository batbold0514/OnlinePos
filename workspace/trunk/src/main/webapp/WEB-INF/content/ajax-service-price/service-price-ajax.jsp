<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
	if (request.getAttribute("priceSuccess") == null) {
%>
<s:fielderror fieldName="code" id="errorCode" />
<s:fielderror fieldName="name" id="errorName" />
<s:fielderror fieldName="priceStr" id="errorPriceStr" />
<%
	}
%>