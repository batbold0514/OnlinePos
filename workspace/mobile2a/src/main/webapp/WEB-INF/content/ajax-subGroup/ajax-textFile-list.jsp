<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<div class = "row" style="text-align: center;font-size: large;">
	<s:text  name = "textFiles"/>
</div>
<div class="tiles col-xs-12 col-sm-12 col-lg-12">
	<c:forEach items="${session.textFileList}" var="image">
		<div class="tile double tile double-down" title="${image.name}">
			<object title="${image.name}" height="280px" width="280px" data="../textFiles/${image.name}" ></object>
		</div>
	</c:forEach>
</div>