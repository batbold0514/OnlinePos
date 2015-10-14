<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="tiles col-sm-12 col-lg-12">
	<c:forEach items="${session.print.imageOfList}" var="image">
		<c:if test="${image.isMain == 'false'}">
	<div class="tile tile-width" style="height: 280px">
		<img src="../uploads/${image.name}" alt="${image.name}" width="330" height="280" />
	</div>
		</c:if>
	</c:forEach>
</div>
<link href="../assets/css/style.css" rel="stylesheet" type="text/css" />
<style>
.tile-width {
  width: 330px !important;
}
</style>