<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	if (request.getAttribute("successShowPlanCall") == null) {
%>
<s:iterator begin="0" end="callCommitments.size-1" status="stat" var="iter">
	<s:iterator begin="0" end="callCommitments[#stat.index].listsize" status="statUnit" var="iterUnit">
		<s:fielderror id="errorCommitValues%{#stat.index}%{#statUnit.index}">
		   <s:param>errorCommitValues<s:property value="%{#stat.index}"/><s:property value="%{#statUnit.index}"/></s:param>
		</s:fielderror>
		<s:fielderror id="errorCommitDates%{#stat.index}%{#statUnit.index}">
		   <s:param>errorCommitDates<s:property value="%{#stat.index}"/><s:property value="%{#statUnit.index}"/></s:param>
		</s:fielderror>
	</s:iterator>
 </s:iterator> 
 <%}%>