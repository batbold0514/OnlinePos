<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="display" uri="http://displaytag.sf.net"%>
<display:table name="listOfDebtType" id="debtTypeTable"
	class="display table-hover table-bordered">
	<display:column property="id" title="ID" />
	<display:column property="typeName" title="Нэр" />
	<display:column property="description" title="Тайлбар" />
	<display:column property="typeNumber" title="Дугаар" />
	<display:column property="debtTypeIndex" title="Индекс" />
	<display:column property="status.description" title="Төлөв" />
	<display:column property="status.id" title="Төлөв" />
</display:table>
