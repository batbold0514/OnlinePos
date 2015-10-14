<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="display" uri="http://displaytag.sf.net"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<display:table name="usersList" cellpadding="0" cellspacing="0"
	id="sampletable2"
	class="table table-striped table-bordered table-hover">
	<display:column property="userName" title="Хэрэглэгчийн нэр" />
	<c:forEach items="${sampletable2.role}" var="role">
		<display:column value="${role.role}" title="Хэрэглэгчийн эрх" />
	</c:forEach>
	<display:column property="id" title="ID" />
</display:table>
