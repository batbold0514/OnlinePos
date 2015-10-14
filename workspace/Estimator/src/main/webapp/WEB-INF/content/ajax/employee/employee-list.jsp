<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="display" uri="http://displaytag.sf.net"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<display:table name="employeeList" id="sampletable2"
	class="display table-bordered table-hoverdataTable">
	<display:column property="id" title="" />
	<display:column property="lastName" title="Овог" />
	<display:column property="firstName" title="Нэр" />
	<display:column property="phoneNumber" title="Утасны дугаар" />
	<display:column property="regNumber" title="Регистер" />
	<display:column property="status" title="Төлөв" />
	<display:column property="status.status" title="Төлөв" />
	<display:column property="user.userName" title="Хэрэглэчийн эрх" />
	<display:column property="user.id" title="" />
</display:table>