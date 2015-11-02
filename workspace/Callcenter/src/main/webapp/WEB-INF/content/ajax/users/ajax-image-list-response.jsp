<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:forEach items="${session.imageList}" var="image">
	<tr data-id="${image.id}"
		<c:if test="${image.isMain == 'true'}">
			data-main-image="true"
		</c:if>>
		<td class="center">
			<!-- <label>
				<input type="checkbox" class="ace"></input>
				<span class="lbl"></span>
			</label> -->
		</td>
		<td>
			<a href="../uploads/${image.name}" onclick="return hs.expand(this)" class="highslide">
				<img src="../uploads/${image.name}" alt="${image.name}" title="Дарж томруулна уу" width="80" height="80" />
			</a>
		</td>
		<td>
			<a href="../uploads/${image.name}">${image.name}</a>
		</td>
		<td>
			<c:choose>
				<c:when test="${image.isMain == 'true'}">
					<span class="label label-info arrowed">
						Үндсэн
					</span>
				</c:when>
				<c:otherwise>
					<span class="label label-success">
						Хадгалагдсан
					</span>
				</c:otherwise>
			</c:choose>
		</td>
		<td>
			<div class="btn-group">
				<c:if test="${image.isMain == 'false'}">
					<button class="btn btn-sm btn-info set-main-image-btn">
						<i class="icon-home"></i> 
						Нүүр зураг
					</button>
				</c:if>
				<button class="btn btn-sm btn-danger delete-image-btn">
					<i class="icon-trash"></i>
					Устгах
				</button>
			</div>
		</td>
	</tr>
</c:forEach>
<script>
jQuery(document).ready(function() {
	initEvents();
	initTableEvents();
});
</script>