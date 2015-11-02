<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="display" uri="http://displaytag.sf.net"%>

<display:table name="planList" id="sampletable2" 
	class=" display table-bordered table-hoverdataTable">
	<display:column property="id" title="ID" />
	<display:column property="taxPayer.regNumber" title="Дугаар" />
	<display:column property="taxPayer.companyName" title="Нэр" />
	<display:column property="operator.code" title="оператор" />
	<%-- <c:forEach items="${sampletable2.debtList}" var="role">
		<display:column value="${debtList.balance}"
			title="${debtList.debtNumber}" />
	</c:forEach> --%>
	<display:column property="taxPayer.email" title="Е-мэйл" />
	<display:column property="taxPayer.phoneNumber" title="Утас" />
	<display:footer media="html">
	</display:footer>
</display:table>