<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	if (request.getAttribute("successShowPlanCall") == null) {
%>
<s:iterator begin="0" end="callCommitmentShows.size-1" status="stat" var="iter">
	<s:fielderror id="errorCommitShowValues%{#stat.index}">
	   <s:param>errorCommitShowValues<s:property value="%{#stat.index}"/></s:param>
	</s:fielderror>
	<s:fielderror id="errorCommitShowDates%{#stat.index}">
	   <s:param>errorCommitShowDates<s:property value="%{#stat.index}"/></s:param>
	</s:fielderror>
 </s:iterator> 
 <%}%>