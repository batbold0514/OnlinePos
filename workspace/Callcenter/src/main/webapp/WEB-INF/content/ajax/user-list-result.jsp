<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="display" uri="http://displaytag.sf.net"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<display:table name="usersList" id="sampletable2"
	class=" display table-bordered table-hoverdataTable">
	<display:column property="userName" title="Хэрэглэгчийн нэр" />
	<c:forEach items="${sampletable2.role}" var="role">
		<display:column value="${role.role}" title="Хэрэглэгчийн эрх" />
	</c:forEach>
	<display:column property="id" title="ID" />
	<display:column property="code" title="Хэрэглэгчийн код" />
	<display:column property="senior_code" title="Ахлах оператор" />
	<display:column property="senior_id" title="Ахлах ID" />
	<display:column property="operatorLine" title="Холбогдох шугам" />
	<display:column property="loginStatus.description" title="Төвөв" />
	<display:column property="loginStatus.id" title="" />
</display:table>