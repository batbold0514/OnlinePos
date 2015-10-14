<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<link rel="stylesheet" href="../css/bootstrap.min.css">
<script>
	function myfunction() {
		window.history.back();
		window.print();
	}
</script>
<body onload="myfunction()">
		<table class="table table-bordered table-hovered">
			<thead>
				<tr>
					<td>№</td>
					<th>Нэр</th>
					<th>Өнгө</th>
					<th>Размер</th>
					<th>Тоо ширхэг</th>
					<th>Нэг бүрийн үнэ</th>
					<th>Нийт үнэ</th>
					<th>Хямдрал</th>
					<th>Нийт үнэ</th>
				</tr>
			</thead>
			<tbody>
				<s:iterator value="#session.multiOutlist" status="stat">
					<tr>
						<td><s:property value='%{#stat.index+1}' /></td>
						<td>${multiOutlist[stat.index].name}</td>
						<td>${multiOutlist[stat.index].colour.name}</td>
						<td>${multiOutlist[stat.index].size.sizes}</td>
						<td>${multiOutlist[stat.index].count}</td>
						<td>${multiOutlist[stat.index].buyPrice}</td>
						<td></td>
						<td></td>
						<td></td>
					</tr>
				</s:iterator>
			</tbody>
		</table>
</body>