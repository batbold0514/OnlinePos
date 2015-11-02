<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="display" uri="http://displaytag.sf.net"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<display:table name="listOfType" id="enquireType"
	class="display table-bordered table-hoverdataTable">
	<display:column property="id" title="ID" />
	<display:column property="description" title="Тайлбар" />
</display:table>