<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="display" uri="http://displaytag.sf.net"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<table  class="table table-bordered" style="">
	<thead style="">
		<tr>
			<th>Эвдэрсэн эд анги</th>
			<th>Эвдрэл</th>
			<th>Засах үнэ</th>
			<th>Солих үнэ</th>
			<th></th>
		</tr>
	</thead>
	<tbody style="">
		<s:iterator value="#session.defectList" var="def">
			<tr>
				<td><s:property value="%{#def.breakedPart.partName}"/></td>
				<td><s:property value="%{#def.crashGrade.grade}"/></td>
				<td><s:property value="%{#def.repairPrice}"/></td>
				<td><s:property value="%{#def.changePrice}"/></td>
				<th></th>
			</tr>
		</s:iterator>
		<tr>
			<td id = "brokenTdEdit">
				<s:select list="brokenParts" listKey="id" listValue="partName"  headerKey="" headerValue=""  name="brokenPartStr" id ="brokenPartIdEdit"></s:select> 
			</td>
			<td ><s:select list="crashGrades" listKey="id" listValue="grade"	name="crashGradeStr" cssClass="form-control" class = "dselect" id ="crashGradeIdEdit"></s:select>
			</td>
			 <td class ="input-icon right">
				 <i class="fa fa-keyboard-o"></i>
					<s:textfield name="repairPriceStr" cssClass=" form-control calculat" id ="repairPriceIdEdit"></s:textfield>
			</td>
			<td class ="input-icon right">
				 <i class="fa fa-keyboard-o"></i>
					<s:textfield name="changePriceStr" cssClass="form-control calculat" id ="changePriceIdEdit"></s:textfield>
			</td> 
			<th id = "addDefectBtnEdit" style="cursor: pointer;" class = "input-icon center">
				<i class="fa fa-check" style="color:green"></i>
				<div class = "form-control"></div>
			</th>
		</tr>
	</tbody>
</table>