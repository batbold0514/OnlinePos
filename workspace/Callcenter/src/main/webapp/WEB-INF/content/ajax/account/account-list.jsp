<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="display" uri="http://displaytag.sf.net"%>

<display:table name="listOfAccounts" id="accountTable"
	class="display table-hover table-bordered">
	<display:column property="id" title="ID" />
	<display:column property="number" title="Дансны дугаар" />
	<display:column property="bankName" title="Банк" />
	<display:column property="debtTypeNumber" title="Татварын төрөл" />
	<display:column property="officeNumber" title="Албаны дугаар" />
</display:table>