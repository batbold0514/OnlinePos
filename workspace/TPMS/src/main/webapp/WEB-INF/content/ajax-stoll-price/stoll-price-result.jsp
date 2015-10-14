<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
	if (request.getAttribute("successStollPrice") == null) {
%>
<s:fielderror fieldName="costPrice" id="errorCostPrice" />
<s:fielderror fieldName="sellPrice" id="errorSellPrice" />
<%
	}
%>
	