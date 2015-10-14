<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="display" uri="http://displaytag.sf.net"%>
<display:table name="doctorList" id="example"
	class="table table-striped table-bordered table-hover">
	<display:column property="id" />
	<display:column property="registrationNumber" title="Регистр №"
		sortable="true" />
	<display:column property="familyName" title="Овог" sortable="true" />
	<display:column property="name" title="Нэр" sortable="true" />
	<display:column property="mobile1" title="Гар утас 1" sortable="true" />
	<display:column property="mobile2" title="Гар утас 2" sortable="true" />
	<display:column property="phoneNumber" title="Утас" sortable="true" />
	<display:column property="status" title="Статус" sortable="true" />
	<display:column property="doctorUser.userName" title="Хэрэглэгчийн нэр"
		sortable="true" />
</display:table>