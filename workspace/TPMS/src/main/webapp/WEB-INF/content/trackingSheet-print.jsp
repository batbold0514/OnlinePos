<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<style>
.header {
	background-color: #8d8d8d;
	color: white;
}

* {
	font-size: 11px;
	font-family: Helvetica, Arial, sans-serif;
}

.back {
	width: 95px;
	padding: 5px;
	margin: 2px;
	background-color: #449e00;
	color: white;
	border-radius: 5px;
}

#topTable {
	height: 560px;
}
</style>
<script type="text/javascript">
	$(document).ready(function() {
		$("#focus").focus();
	});
	$(document).ready(function() {
		var a1 = document.getElementById("knitter1").innerHTML;
		var b1 = parseInt(a1);
		$("#sum").val(b1);
	});
	function myFunction() {
		var sum1 = document.getElementById("knitter1").innerHTML;
		var sum2 = document.getElementById("detail").value;
		var sum3 = document.getElementById("sum");
		var sum4 = document.getElementById("final");
		var a = parseInt(sum1);
		var b = parseInt(sum2);
		sum3.value = a + b;
		sum4.value = b;
		window.location = 'trackingSheetShow?model.id='
				+ <s:property value="id"/>;
		window.print();
	}

	$(document).ready(function() {
		$("#back").click(function(event) {
			event.preventDefault();
			window.location.href = "trackingSheetList";
		});
		$("#focus").click(function(event) {
			event.preventDefault();
			var sum = $("#sum").val();
			if (sum == 'NaN') {
				alert("Detail жингээ буруу оруулсан байна!");
			} else {
				$("#mainForm").submit();
			}
		});
	});
</script>
</head>
<sj:head jquerytheme="south-street" jqueryui="true" />
<body onload="myFunction()">
	<div id="topTable">
		<table>
			<tr>
				<th>Сүлжмэл бүтээгдэхүүний дагалдах хуудас. №: &nbsp;<s:property
						value="startNumber" />
				</th>
			</tr>
			<tr>
				<td>Захиалагчийн нэр: &nbsp;&nbsp;<s:property
						value="customer.name" />
				</td>
			</tr>

		</table>

		<s:form action="trackingSheetSaveStatus" id="mainForm">
			<table border="1"
				style="border-spacing: 0; border-collapse: collapse;">
				<s:hidden key="id" />
				<s:set var="idts">
					<s:property value="id" />
				</s:set>
				<s:hidden key="customerLong" value="%{#session.ts.customer.id}" />
				<s:hidden key="yarnColorString" value="%{#session.ts.yarnColor.id}" />
				<s:hidden key="knitterSizeString"
					value="%{#session.ts.knitterSize.id}" />
				<s:hidden key="knitterQuantity" />
				<s:hidden key="productModelLong"
					value="%{#session.ts.productModel.id}" />
				<s:hidden key="knitterWeight" />
				<%-- <s:hidden key="actualWeight" /> --%>
				<s:hidden key="knitterChekerLong"
					value="%{#session.ts.knitterChecker.id}" />
				<s:hidden key="productionStepCheckerLong"
					value="%{#session.ts.productionStepChecker.id}" />
				<s:hidden key="actualChekerLong"
					value="%{#session.ts.actualChecker.id}" />
				<s:hidden key="startDate" />
				<s:hidden key="detailWeight" id="final" />
				<s:hidden key="startNumber"></s:hidden>
				<s:hidden key="bonus" />
				<s:hidden key="endNumber" />
				<s:hidden key="endDate" />
				<s:hidden key="BackingListNumber" />
				<s:hidden name="addId" id="clickId" />
				<tr>
					<th colspan="2"></th>
					<th colspan="2" class="header">Утасны</th>
					<th colspan="2" class="header">Сүлжмэлийн</th>
					<th colspan="2" class="header">Жин,гр</th>
				</tr>
				<tr>
					<th class="header">Огноо</th>
					<th class="header">Загварын дугаар</th>
					<td align="center">Код:</td>
					<td align="center"><c:forEach items="${yarnColorList}" var="p">
							<c:out value=" ${p.code}" />
						</c:forEach></td>
					<td align="center">Размер:</td>
					<td align="center"><s:property value="knitterSize.sizes" /></td>
					<td align="center" style="background-color: white">Сүлжмэл
						жин(гр):</td>
					<td align="center" style="background-color: white" id="knitter1"><s:property
							value="knitterWeight" /></td>
				</tr>
				<tr>
					<td align="center"><s:date name="startDate"
							format="yyyy-MM-dd" /></td>
					<td align="center"><s:property value="productModel.modelId" /></td>
					<td align="center">Өнгө:</td>
					<td align="center"><c:forEach items="${yarnColorList}" var="p">
							<c:out value=" ${p.name}" />
						</c:forEach></td>
					<td align="center">Тоо:</td>
					<td align="center"><s:property value="knitterQuantity" /></td>
					<td align="center" style="background-color: white">Деталь
						жин(гр):</td>
					<td align="center" style="background-color: white"><input
						style="width: 50px; text-align: right; background-color: white"
						value="<s:property value='detailWeight'/>" id="detail"
						onchange="myFunction()" disabled="disabled" /></td>
				</tr>
				<tr>
					<th>Сүлжигч:</th>
					<td colspan="3" align="center"><s:property
							value="mainKnitter.lastName" />&nbsp;<s:property
							value="mainKnitter.firstName" /></td>
					<th>Бэлэнгийн жин(гр):</th>
					<td align="center"><s:property value="actualWeight" /></td>
					<td style="background-color: white" align="center"
						title="Сүлжмэл + Detail">Нийт жин(гр):</td>
					<td align="center" style="background-color: white"><input
						readonly="readonly" id="sum" title="Сүлжмэл + Detail"
						style="border: none; width: 50px; text-align: center; background-color: white" /></td>
				</tr>
				<tr>
					<th colspan="1">Сүлжихийн чанар шалгагч:</th>
					<td colspan="2" align="center"><s:property
							value="knitterChecker.firstName" /></td>
					<th colspan="1">Дамжлага дундын чанар шалгагч:</th>
					<td colspan="1" align="center"><s:property
							value="productionStepChecker.firstName" /></td>
					<th colspan="2">Бэлэнгийн чанар шалгагч:</th>
					<td align="center" colspan="1"><s:property
							value="actualChecker.firstName" /></td>
				</tr>
				<tr>
					<th>№</th>
					<th colspan="2">Дамжлагын нэр</th>
					<th>Огноо</th>
					<th colspan="3">Ажилчны нэр</th>
					<th>Тоо ширхэг</th>
				</tr>
				<s:iterator value="#session.subWorkStepList" status="stat">
					<tr>
						<td style="text-align: center"><s:property
								value="%{#stat.index+1}" /> <s:property value="%{#stat.end}" />
							<div>
								<s:hidden key="subWorkStepList[%{#stat.index}].stepPrice.id" />
								<s:hidden
									key="subWorkStepList[%{#stat.index}].stepPrice.productStep.name" />
								<s:hidden key="subWorkStepList[%{#stat.index}].id" />
								<s:hidden key="subWorkStepList[%{#stat.index}].tsid"
									value="%{idts}" />
							</div></td>
						<td colspan="2" align="center"><s:property
								value="stepPrice.productStep.name" /></td>
						<td align="center"><s:property value="date" /></td>
						<td colspan="3" align="center"><s:property
								value="emp.lastName" />&nbsp;<s:property value="emp.firstName" />
						</td>
						<td><s:property value="quantity" /></td>

					</tr>
				</s:iterator>
			</table>
		</s:form>
	</div>
	<br />
		<div style="width: 100%; border-bottom: 1px dashed black"></div>
		<br />
		<table>
			<tr>
				<th>Сүлжмэл бүтээгдэхүүний дагалдах хуудас. №: &nbsp;&nbsp;<s:property
						value="startNumber" />
				</th>
			</tr>
			<tr>
				<td>Захиалагчийн нэр: &nbsp;&nbsp;&nbsp;&nbsp;<s:property
						value="customer.name" />
				</td>
			</tr>

		</table>
		<table border="1"
			style="border-spacing: 0; border-collapse: collapse; width: 100%;">
			<s:hidden key="id" />
			<s:set var="idts">
				<s:property value="id" />
			</s:set>
			<s:hidden key="customerLong" value="%{#session.ts.customer.id}" />
			<s:hidden key="yarnColorString" value="%{#session.ts.yarnColor.id}" />
			<s:hidden key="knitterSizeString"
				value="%{#session.ts.knitterSize.id}" />
			<s:hidden key="knitterQuantity" />
			<s:hidden key="productModelLong"
				value="%{#session.ts.productModel.id}" />
			<s:hidden key="knitterWeight" />
			<%-- <s:hidden key="actualWeight" /> --%>
			<s:hidden key="knitterChekerLong"
				value="%{#session.ts.knitterChecker.id}" />
			<s:hidden key="productionStepCheckerLong"
				value="%{#session.ts.productionStepChecker.id}" />
			<s:hidden key="actualChekerLong"
				value="%{#session.ts.actualChecker.id}" />
			<s:hidden key="startDate" />
			<s:hidden key="detailWeight" id="final" />
			<s:hidden key="startNumber"></s:hidden>
			<s:hidden key="bonus" />
			<s:hidden key="endNumber" />
			<s:hidden key="endDate" />
			<s:hidden key="BackingListNumber" />
			<s:hidden name="addId" id="clickId" />
			<tr>
				<th colspan="2"></th>
				<th colspan="2" class="header">Утасны</th>
				<th colspan="2" class="header">Сүлжмэлийн</th>
				<th colspan="2" class="header">Жин,гр</th>
			</tr>
			<tr>
				<th class="header">Огноо</th>
				<th class="header">Загварын дугаар</th>
				<td align="center">Код:</td>
				<td align="center"><c:forEach items="${yarnColorList}" var="p">
						<c:out value=" ${p.code}" />
					</c:forEach></td>
				<td align="center">Размер:</td>
				<td align="center"><s:property value="knitterSize.sizes" /></td>
				<td align="center" style="background-color: white">Сүлжмэл
					жин(гр):</td>
				<td align="center" style="background-color: white" id="knitter1"><s:property
						value="knitterWeight" /></td>
			</tr>
			<tr>
				<td align="center"><s:date name="startDate" format="yyyy-MM-dd" /></td>
				<td align="center"><s:property value="productModel.modelId" /></td>
				<td align="center">Өнгө:</td>
				<td align="center"><c:forEach items="${yarnColorList}" var="p">
						<c:out value=" ${p.name}" />
					</c:forEach></td>
				<td align="center">Тоо:</td>
				<td align="center"><s:property value="knitterQuantity" /></td>
				<td align="center" style="background-color: white">Detail
					жин(гр):</td>
				<td align="center" style="background-color: white"><input
					style="width: 50px; text-align: right; background-color: white"
					value="<s:property value='detailWeight'/>" id="detail"
					onchange="myFunction()" disabled="disabled" /></td>
			</tr>
			<tr>
				<th>Сүлжигч:</th>
				<td colspan="3" align="center"><s:property
						value="mainKnitter.lastName" />&nbsp;<s:property
						value="mainKnitter.firstName" /></td>
				<th>Бэлэнгийн жин(гр):</th>
				<td align="center"><s:property value="actualWeight" /></td>
				<td style="background-color: white" align="center"
					title="Сүлжмэл + Detail">Нийт жин(гр):</td>
				<td align="center" style="background-color: white"><input
					readonly="readonly" id="sum" title="Сүлжмэл + Detail"
					style="border: none; width: 50px; text-align: right; background-color: white" /></td>
			</tr>
		</table>
		<br />
		<div style="width: 100%; border-bottom: 1px dashed black"></div>
		<br />
		<table>
			<tr>
				<th>Сүлжмэл бүтээгдэхүүний дагалдах хуудас. №: &nbsp;&nbsp;<s:property
						value="startNumber" />
				</th>
			</tr>
			<tr>
				<td>Захиалагчийн нэр: &nbsp;&nbsp;&nbsp;&nbsp;<s:property
						value="customer.name" />
				</td>
			</tr>

		</table>
		<table border="1"
			style="border-spacing: 0; border-collapse: collapse; width: 100%;">
			<s:hidden key="id" />
			<s:set var="idts">
				<s:property value="id" />
			</s:set>
			<s:hidden key="customerLong" value="%{#session.ts.customer.id}" />
			<s:hidden key="yarnColorString" value="%{#session.ts.yarnColor.id}" />
			<s:hidden key="knitterSizeString"
				value="%{#session.ts.knitterSize.id}" />
			<s:hidden key="knitterQuantity" />
			<s:hidden key="productModelLong"
				value="%{#session.ts.productModel.id}" />
			<s:hidden key="knitterWeight" />
			<%-- <s:hidden key="actualWeight" /> --%>
			<s:hidden key="knitterChekerLong"
				value="%{#session.ts.knitterChecker.id}" />
			<s:hidden key="productionStepCheckerLong"
				value="%{#session.ts.productionStepChecker.id}" />
			<s:hidden key="actualChekerLong"
				value="%{#session.ts.actualChecker.id}" />
			<s:hidden key="startDate" />
			<s:hidden key="detailWeight" id="final" />
			<s:hidden key="startNumber"></s:hidden>
			<s:hidden key="bonus" />
			<s:hidden key="endNumber" />
			<s:hidden key="endDate" />
			<s:hidden key="BackingListNumber" />
			<s:hidden name="addId" id="clickId" />
			<tr>
				<th colspan="2"></th>
				<th colspan="2" class="header">Утасны</th>
				<th colspan="2" class="header">Сүлжмэлийн</th>
				<th colspan="2" class="header">Жин,гр</th>
			</tr>
			<tr>
				<th class="header">Огноо</th>
				<th class="header">Загварын дугаар</th>
				<td align="center">Код:</td>
				<td align="center"><c:forEach items="${yarnColorList}" var="p">
						<c:out value=" ${p.code}" />
					</c:forEach></td>
				<td align="center">Размер:</td>
				<td align="center"><s:property value="knitterSize.sizes" /></td>
				<td align="center" style="background-color: white">Сүлжмэл
					жин(гр):</td>
				<td align="center" style="background-color: white" id="knitter1"><s:property
						value="knitterWeight" /></td>
			</tr>
			<tr>
				<td align="center"><s:date name="startDate" format="yyyy-MM-dd" /></td>
				<td align="center"><s:property value="productModel.modelId" /></td>
				<td align="center">Өнгө:</td>
				<td align="center"><c:forEach items="${yarnColorList}" var="p">
						<c:out value=" ${p.name}" />
					</c:forEach></td>
				<td align="center">Тоо:</td>
				<td align="center"><s:property value="knitterQuantity" /></td>
				<td align="center" style="background-color: white">Detail
					жин(гр):</td>
				<td align="center" style="background-color: white"><input
					style="width: 50px; text-align: right; background-color: white"
					value="<s:property value='detailWeight'/>" id="detail"
					onchange="myFunction()" disabled="disabled" /></td>
			</tr>
			<tr>
				<th>Сүлжигч:</th>
				<td colspan="3" align="center"><s:property
						value="mainKnitter.lastName" />&nbsp;<s:property
						value="mainKnitter.firstName" /></td>
				<th>Бэлэнгийн жин(гр):</th>
				<td align="center"><s:property value="actualWeight" /></td>
				<td style="background-color: white" align="center"
					title="Сүлжмэл + Detail">Нийт жин(гр):</td>
				<td align="center" style="background-color: white"><input
					readonly="readonly" id="sum" title="Сүлжмэл + Detail"
					style="border: none; width: 50px; text-align: right; background-color: white" /></td>
			</tr>
		</table>

</body>
</html>