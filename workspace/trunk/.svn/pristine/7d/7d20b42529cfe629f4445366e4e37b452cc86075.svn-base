<%!int fontSize;%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<%@ taglib prefix="display" uri="http://displaytag.sf.net"%>

<div style="font-size: 12"><s:text name="serviceProvider" /></div>
<body>
	<form style="font-size: 10">
		<s:label label="%{getText('payment.savedDate')}" /><s:date name="payment.savedDate" format="dd/MM/yyyy HH:mm"/>
		<br />
		<s:label key="payment.paymentNumber" value="%{#session.paymentSession.paymentNumber}" />
		<br />
		<s:label key="patient.regNumber" value="%{#session.spSession.patient.regNumber}" />
		<br />
		<s:label key="patient.lastName" value="%{#session.spSession.patient.lastName}" />&nbsp;<s:label key="patient.firstName" value="%{#session.spSession.patient.firstName}" />
		<br />
		<s:label key="patient.cardNumber" value="%{#session.spSession.patient.cardNumber}"/>
		<br />
		<s:if test="%{#session.spSession.patient.phone != ''}">
		<s:label key="patient.phone" value="%{#session.spSession.patient.phone}" />
		</s:if>
		<s:if test="%{#session.spSession.patient.mobil_1 != ''}">
		<s:label key="patient.phone" value="%{#session.spSession.patient.mobil_1}" />
		</s:if>
		<s:if test="%{#session.spSession.patient.mobil_2 != ''}">
		<s:label key="patient.phone" value="%{#session.spSession.patient.mobil_2}" />
		</s:if>
	</form>
</body>
<s:if test= "%{#session.spSession.listOfSession.size >0}">
<table style="font-size: 11">
	<tr>
		<td>Үзлэг</td>
		<td>Үнэ</td>
		<td>Эмч</td>
	</tr>
	<s:iterator value="ServiceList">
		<tr>
			<td><s:property value="servicePrice.name" /></td>
			<td><s:property value="servicePrice.price" /></td>
			<td><s:property value="doctor.name" /></td>
		</tr>
	</s:iterator>
</table>
</s:if>
<div style="font-size: 11">_________________________________</div>
<body onload="print_paper()">
	<form style="font-size: 11">
		Эхний үлдэгдэл
		<s:label key="firstValue" value="%{#session.firstVal}"/>
		<br />
		Үйлчилгээний нийт үнэ
		<s:label key="allValue" value="%{#session.allVal}"/>
		<br />
		Төлсөн
		<s:label key="payment.value" value="%{#session.paymentSession.value}"/>
		<br />
		Эцсийн үлдэгдэл
		<s:label key="lastValue" value="%{#session.lastVal}" />
	</form>
</body>
<%
	request.getSession().removeAttribute("spSession");
	request.getSession().removeAttribute("paymentSession");
	request.getSession().removeAttribute("firstVal");
	request.getSession().removeAttribute("lastVal");
	request.getSession().removeAttribute("allVal");
%>
<form style="font-size: 11">
	Гарын үсэг ______________________ <br /> Манайхаар үйлчлүүлсэнд
	баярлалаа
</form>
<script>
	function print_paper() {
		window.location = 'print';
		window.print();
	}
</script>



