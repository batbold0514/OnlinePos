<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="display" uri="http://displaytag.sf.net"%>

<display:table name="reasonList" id="reasonTable"
	class="display table-hover table-bordered">
	<display:column property="id" title="ID" />
	<display:column property="description" title="Тайлбар" />
</display:table>