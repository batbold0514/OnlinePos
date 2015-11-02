<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
	if (request.getAttribute("moneyIndexSuccess") == null) {
%>
<s:fielderror fieldName="min" id="min" />
<s:fielderror fieldName="max" id="max" />
<s:fielderror fieldName="money_index" id="money_index" />
<%
	}
%>
	