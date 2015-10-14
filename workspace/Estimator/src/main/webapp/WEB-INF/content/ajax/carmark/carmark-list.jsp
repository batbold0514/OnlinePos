<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="display" uri="http://displaytag.sf.net"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<display:table name="carMarkList" id="sampletable2"
	class="display table-bordered table-hoverdataTable">
	<display:column property="id" title="" />
	<display:column property="factory.factoryName" title="Үйлдвэрийн нэр" />
	<display:column property="mark" title="Марк" />
	<display:column property="factory.id" title="" />
</display:table>