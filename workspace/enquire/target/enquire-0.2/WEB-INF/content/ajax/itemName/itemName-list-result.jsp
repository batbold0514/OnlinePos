<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="display" uri="http://displaytag.sf.net"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<display:table name="listOfItemName" id="itemNameID"
	class="display table-bordered table-hoverdataTable">
	<display:column property="id" title="ID" />
	<display:column property="name" title="Барааны нэр" />
	<display:column property="description" title="Тайлбар" />
	<display:column property="price" title="Үнэ" format="{0,number,#,##0.00}"/>
</display:table>