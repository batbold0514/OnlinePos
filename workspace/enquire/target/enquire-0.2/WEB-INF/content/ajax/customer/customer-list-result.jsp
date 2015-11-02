<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="display" uri="http://displaytag.sf.net"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<display:table name="listOfCustomer" id="customerID"
	class="display table-bordered table-hoverdataTable">
	<display:column property="id" title="ID" />
	<display:column property="enquireName" title="Үйлчлүүлэгчийн нэр" />
	<display:column property="phone" title="Утас" />
	<display:column property="user.userName" title="Нэвтрэх эрх" />
</display:table>