<%@page import="java.util.Date"%>
<%@page import="mn.infosystems.estimator.service.EstimaterStaticFunctions"%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="display" uri="http://displaytag.sf.net"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div style="width: 700px; padding-left: 5px; font-size: 12px;">
<table style="padding:5; border-spacing: 0 ; border-bottom: 2px solid blue;width: 100%">
	<tr>
		<td width="90px"><img
			src="http://unelgee.mn:80/images/logo_master.jpg" width="60"
			alt="LOGO" /></td>
		<td style="font-size: 42px; color: blue;text-align: center">Мастер Үнэлгээ ХХК</td>
	</tr>
</table>
<table style="border-spacing: 0 ;width: 100%">
	<tr>
		<td colspan="2" style="font-size: 30px;text-align: center;" >Үйл ажилгааны тайлна</td>
	</tr>
	<tr>
		<td colspan="2" style="text-align: center;"><s:property value="%{#session.firstDate}"/>-<s:property value="%{#session.secondDate}"/></td>
	</tr>
	<tr>
		<td colspan="2" style="text-align: right ;"> <%	out.print(EstimaterStaticFunctions.dateToStr(new Date()));
		%></td>
	</tr>
</table>
<table style="width: 100%; border-spacing: 0 ;" class = "borderbr">
	<thead>
		<tr>
			<th class="borderbr">№</th>
			<th class="borderbr">Огноо</th>
			<th class="borderbr">Үнэлгээ хийсэн тоо</th>
			<th class="borderbr">Үнэлгээний дүн</th>
			<th class="borderbr">Даатгалын тоо</th>
			<th class="borderbr">Даатгалын дүн</th>
		</tr>
	</thead>
	<tbody>
			<s:set var ="max" value = "0"/>
			<s:set var="estCountTotal" value = "0"></s:set>
			<s:set var="estPriceTotal" value = "0"></s:set>
			<s:set var="insuranceCountTotal" value = "0"></s:set>
			<s:set var="insurancePriceTotal" value = "0"></s:set>
		<s:iterator value="empReportList" var="emp">
			<tr>
				<td colspan="6" class="borderbr">${emp.employee.firstName}</td>
			</tr>
			<s:set var="estCount" value = "0"></s:set>
			<s:set var="estPrice" value = "0"></s:set>
			<s:set var="insuranceCount" value = "0"></s:set>
			<s:set var="insurancePrice" value = "0"></s:set>
			<s:iterator value="#emp.counList" var="countList" status="stat">
				<tr>
					<td class="borderbr">${stat.index+1}</td>
					<td class="borderbr">${countList.date}</td>
					<td class="borderbr"><s:property value="%{getText('{0,number,#,##0}',{#countList.estCount})}"/><s:set var="estCount" value = "%{#estCount+#countList.estCount}"></s:set></td>
					<td class="borderbr"><s:property value="%{getText('{0,number,#,##0}',{#countList.estPrice})}"/> <s:set var="estPrice" value = "%{#estPrice+#countList.estPrice}"></s:set></td>
					<td class="borderbr"><s:property value="%{getText('{0,number,#,##0}',{#countList.insuranceCount})}"/> <s:set var="insuranceCount" value = "%{#insuranceCount+#countList.insuranceCount}"></s:set></td>
					<td class="borderbr"><s:property value="%{getText('{0,number,#,##0}',{#countList.insurancePrice})}"/> <s:set var="insurancePrice" value = "%{#insurancePrice+#countList.insurancePrice}"></s:set></td>
					<s:if test="#max <#countList.estPrice">
						<s:set var ="max" value = "#countList.estPrice"/>
						<s:set var ="maxId" value = "#"/>
					</s:if>
				</tr>
			</s:iterator>
			<tr>
			<td colspan="2" class="borderbr">Нийт:</td>
			<td class="borderbr"><s:property value="%{getText('{0,number,#,##0}',{#estCount})}"/> <s:set var="estCountTotal" value = "%{#estCountTotal+#estCount}"></s:set></td>
			<td class="borderbr"><s:property value="%{getText('{0,number,#,##0}',{#estPrice})}"/> <s:set var="estPriceTotal" value = "%{#estPriceTotal+#estPrice}"></s:set></td>
			<td class="borderbr"><s:property value="%{getText('{0,number,#,##0}',{#insuranceCount})}"/> <s:set var="insuranceCountTotal" value = "%{#insuranceCountTotal+#insuranceCount}"></s:set></td>
			<td class="borderbr"><s:property value="%{getText('{0,number,#,##0}',{#insurancePrice})}"/> <s:set var="insurancePriceTotal" value = "%{#insurancePriceTotal+#insurancePrice}"></s:set></td>
		</tr>
		</s:iterator>
	</tbody>
	<tfoot>
		<tr>
			<td colspan="2" class="borderbr">Бүгд:</td>
			<td class="borderbr"><s:property value="%{getText('{0,number,#,##0}',{#estCountTotal})}"/></td>
			<td class="borderbr"><s:property value="%{getText('{0,number,#,##0}',{#estPriceTotal})}"/></td>
			<td class="borderbr"><s:property value="%{getText('{0,number,#,##0}',{#insuranceCountTotal})}"/></td>
			<td class="borderbr"><s:property value="%{getText('{0,number,#,##0}',{#insurancePriceTotal})}"/></td>
		</tr>
	</tfoot>
	</table>
<table style="border-spacing: 0 ;width: 100%">
	<tr>
		<s:set var = "total" value = "%{#session.customer.changePrice+#session.customer.repairPrice}"></s:set>
		<td colspan="2" > Хамгийн өндөр хохирлын дүн:<s:property value = "%{getText('{0,date,YYYY-MM-dd}',{#session.customer.date})}"/> <s:property value = "%{#session.customer.carMark.mark}"/> <s:property value = "%{#session.customer.importedDate}"/> <s:property value = "%{getText('{0,number,#,##0}',{#total})}"/> 
		</td>
	</tr>
	<tr>
		<td colspan="2" style="text-align: center;">Тайлан гаргасан                         /<s:property value = "%{#session.customer.company.compName}"/>/</td>
	</tr>
	<tr>
		<td colspan="2" style="text-align: center;">Хянасан                  /                  /</td>
	</tr>
</table>
</div>
<style>
.borderbr{
border : 1px solid
}
</style> 