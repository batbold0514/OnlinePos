<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="display" uri="http://displaytag.sf.net"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<display:table name="listPt" id="productTypeTable"
	class="table table-striped table-bordered table-hover">
	<display:column property="prefix" title="Код" />
	<display:column property="name" title="Төрөл" />
	<display:column property="active" title="Төлөв" />
	<display:column property="id" />
</display:table>