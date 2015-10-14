<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<s:set var="a" value='changerId'></s:set>
<thead>
	<tr>
		<th>id</th>
		<th>name</th>
		<th>count</th>
		<th style="width: 1%"></th>
	</tr>
</thead>
<s:iterator value="#session.multiOutlist" status="stat">
	<tr>
		<s:if test="%{#a == id}">
			<td>${multiOutlist[stat.index].id}</td>
			<td>${multiOutlist[stat.index].name}</td>
			<td style="background-color: red">${multiOutlist[stat.index].count}</td>
		< </s:if>
		<s:else>
			<td>${multiOutlist[stat.index].id}</td>
			<td>${multiOutlist[stat.index].name}</td>
			<td>${multiOutlist[stat.index].count}</td>
		</s:else>
		<td onclick="minus('<s:property value="%{#stat.index}"/>')"><a
			class="btn btn-danger"> <span class="fa fa-minus"></span>
		</a></td>
	</tr>
</s:iterator>