<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="display" uri="http://displaytag.sf.net"%>
<display:table class="table table-striped table-bordered table-hover"
	id="example" name="bonusList">
	<display:column property="id" title="№" />
	<display:column property="name" title="Нэр" />
	<display:column property="value" title="Хэмжээ" />
</display:table>