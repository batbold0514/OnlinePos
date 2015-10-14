<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="display" uri="http://displaytag.sf.net"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<display:table name="carPriceList" id="carPricetable"
	class="display table-bordered table-hoverdataTable">
	<display:column property="id" title="" />
	<display:column property="date" title="Огноо" />
	<display:column property="factory.factoryName" title="Үйлдвэр" />
	<display:column property="mark.mark" title="Загвар" />
	<display:column property="factoryDate" title="Үйлд.он" />
	<display:column property="importedDate" title="Импорт.он" />
	<display:column property="vinNumber" title="Арал" />
	<display:column property="price" title="Үнэ(сая.төг)" />
	<display:column property="estimator.firstName" title="Үнэлгээ хийсэн" />
	<display:column property="description" title="Тайлбар" />
	<display:column property="factory.id" title="" />
	<display:column property="mark.id" title="" />
	<display:column property="estimator.id" title="" />
</display:table>