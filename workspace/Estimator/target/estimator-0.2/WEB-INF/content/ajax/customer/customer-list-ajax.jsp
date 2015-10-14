<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="display" uri="http://displaytag.sf.net"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<display:table name="customerList" id="customerTable"
	class="display table-bordered table-hoverdataTable">
	<display:column property="id" title="" />
	<display:column property="date" title="Оноо" />
	<display:column property="cnumber" title="Улсын дугаар" />
	<display:column property="confirm.description" title="Төлөв" />
	<display:column property="ownerName" title="Эзэмшигч" />
	<display:column property="consumer" title="Захиалагч" />
	<display:column property="carFactory.factoryName" title="Үйлдвэр" />
	<display:column property="carMark.mark" title="Загвар" />
	<display:column property="factoryDate" title="Үйлд.он" />
	<display:column property="marketPrice" title="Э.З үнэ" />
	<display:column property="vinNumber" title="Арал" />
	<display:column property="mainEmp.firstName" title="Мэргэжилтэн" />
	<display:column property="carFactory.id" title="" />
	<display:column property="carMark.id" title="" />
	<display:column property="mainEmp.id" title="" />
	<display:column property="emp1.id" title="" />
	<display:column property="emp2.id" title="" />
</display:table>