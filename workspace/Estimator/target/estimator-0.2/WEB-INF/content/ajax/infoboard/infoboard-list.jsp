<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="display" uri="http://displaytag.sf.net"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<display:table name="infoBoardList" id="infoBoardTable"
	class="display
table-bordered table-hoverdataTable">
	<display:column property="id" title="" />
	<display:column property="date" title="Огноо" />
	<display:column property="info" title="Мэдээлэл" />
	<display:column property="user.userName" title="Оруулсан" />
</display:table>