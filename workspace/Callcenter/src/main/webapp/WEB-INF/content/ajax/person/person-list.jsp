<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="display" uri="http://displaytag.sf.net"%>

<display:table name="listOfPeople" id="peopleTable"
	class="display table-hover table-bordered">
	<display:column property="id" title="ID" />
	<display:column property="personDescription" title="Холбогдсон этгээд" />
</display:table>