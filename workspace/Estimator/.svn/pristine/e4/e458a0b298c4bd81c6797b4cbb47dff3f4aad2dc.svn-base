<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="display" uri="http://displaytag.sf.net"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%--  <select id="select-beast"  class="demo-default" name="brokenPartStr" >
	<s:iterator value="brokenParts" var="broken">
		<option value="${broken.id}">${broken.partName}</option>
	</s:iterator>
</select>  --%>
<s:select list="brokenParts" listKey="id" listValue="partName" value="%{#session.brokenPartId}" id="brokenPartId"  name="brokenPartStr"></s:select> 
