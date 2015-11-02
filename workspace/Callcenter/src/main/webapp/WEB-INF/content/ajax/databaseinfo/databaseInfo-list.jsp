<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="display" uri="http://displaytag.sf.net"%>
<display:table name="databaseInfos" id="databaseInfoTable"
	class="display table-hover table-bordered">
	<display:column property="id" title="ID" />
	<display:column property="url" title="Баазын зам" />
	<display:column property="username" title="Хэрэглэгчийн нэр" />
	<display:column property="password" title="Нууц үг" />
	<display:column property="downloadTime" title="Татах цаг" />
</display:table>