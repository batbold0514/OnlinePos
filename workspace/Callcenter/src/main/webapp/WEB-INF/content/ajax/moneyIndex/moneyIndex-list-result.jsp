<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="display" uri="http://displaytag.sf.net"%>
<display:table name="listOfMoneyIndex" id="moneyIndexTable"
	class="display table-hover table-bordered">
	<display:column property="id" title="ID" />
	<display:column property="min" title="Бага" />
	<display:column property="max" title="Их" />
	<display:column property="money_index" title="Индекс" />
</display:table>
