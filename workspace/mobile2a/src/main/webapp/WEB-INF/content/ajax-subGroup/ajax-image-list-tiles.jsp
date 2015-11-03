<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<div class = "row" style="text-align: center;font-size: large;">
	<s:text  name = "images"/>
</div>
<div class="tiles col-xs-12 col-sm-12 col-lg-12">
	<c:forEach items="${session.imageList}" var="image">
		<div class="tile">
			<a href="../uploads/${image.name}" onclick="return hs.expand(this)" class="highslide">
				<img src="../uploads/${image.name}" alt="${image.name}" title="Дарж томруулна уу" width="120" height="120" />
			</a>
		</div>
	</c:forEach>
</div>