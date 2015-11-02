<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<s:fielderror fieldName="id" />
<s:fielderror fieldName="im" />
<s:fielderror fieldName="imageId" />
<s:fielderror fieldName="imageIds" />
<s:fielderror fieldName="exception" />
<%
	response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Алдаатай хүсэлт байна.");
%>