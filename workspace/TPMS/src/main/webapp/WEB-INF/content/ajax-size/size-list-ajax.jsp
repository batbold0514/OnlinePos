<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="display" uri="http://displaytag.sf.net"%>
<display:table class="table table-striped table-bordered table-hover"
	id="example" name="sizeList">
	<display:column property="id" title="ID" />
	<display:column property="sizes" title="Размер" />
</display:table>