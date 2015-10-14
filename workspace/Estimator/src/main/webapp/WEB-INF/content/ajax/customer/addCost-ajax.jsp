<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="display" uri="http://displaytag.sf.net"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<table  class="table table-bordered" style="" >
	<thead style="">
		<tr>
			<th>Зардлын нэр</th>
			<th>Зардал</th>
			<th></th>
		</tr>
	</thead>
	<tbody style="">
		<s:iterator value="#session.costList" var="cost">
			<tr>
				<td><s:property value="%{#cost.costName}"/></td>
				<td><s:property value="%{#cost.cost}"/></td>
				<th></th>
			</tr>
		</s:iterator>
		<tr>
			<td >
				<s:textfield name="costName" cssClass=" form-control" id ="costName"></s:textfield>
			</td>
			 <td class ="input-icon right">
				 <i class="fa fa-keyboard-o"></i>
					<s:textfield name="cost" cssClass=" form-control calculat" id ="cost"></s:textfield>
			</td>
			<th id = "addCostBtn" style="cursor: pointer;" class = "input-icon center">
				<i class="fa fa-check" style="color:green"></i>
				<div class = "form-control"></div>
			</th>
		</tr>
	</tbody>
</table>
<script >
jQuery(function($) {
	$("#addCostBtn").click(function(e) {
			e.preventDefault();
			addCost();
		});
});
</script>