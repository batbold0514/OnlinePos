<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<s:iterator value="#session.subWorkStepList" status="stat" var="ite">
	<tr>
		<td style="text-align: center"><s:property
				value="%{#stat.index+1}" />
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
		<td align="center"><div>
				<div hidden="true">
					<s:date name = "%{#ite.date}" var = "date" format="yyyy-MM-dd" />
				</div>
				<s:if test="%{date != null}">
				<table>
					<s:fielderror>
						<s:param>subWorkStepList[<s:property
								value="%{#stat.index}" />].date</s:param>
					</s:fielderror>
						<s:textfield cssClass="form-control dateMe" 
						name="subWorkStepList[%{#stat.index}].date"  value ="%{#date}"/>
						
				</table>
				 </s:if><s:else>
				<table>
					<s:fielderror>
						<s:param>subWorkStepList[<s:property
								value="%{#stat.index}" />].date</s:param>
					</s:fielderror>
						<s:textfield cssClass="form-control dateMe" 
						name="subWorkStepList[%{#stat.index}].date"/>
						
				</table>
				</s:else>
			</div></td>
		<td colspan="3" align="center">
			<div>
				<table>
					<s:fielderror>
						<s:param>subWorkStepList[<s:property
								value="%{#stat.index}" />].emp.id</s:param>
					</s:fielderror>
					<s:select id="employees" list="employees"
						listValue="code + ' ' + lastName + ' '+ firstName " listKey="id"
						name="subWorkStepList[%{#stat.index}].emp.id" headerKey="-1"
						headerValue="" cssClass="chosen-select col-sm-3" data-placeholder="Ажилчин сонгоно уу"/>
				</table>
			</div>
		</td>
		<td>
			<div>
				<table>
					<s:textfield name="subWorkStepList[%{#stat.index}].quantity"
						cssStyle="width:100px" onchange="textChange(%{#stat.index})" id = "id%{#stat.index}"/>
						<s:fielderror>
					<s:param>subWorkStepList[<s:property value="%{#stat.index}"/>].quantity</s:param>
					</s:fielderror>

				</table>
			</div>
		</td>
		<td><a
			href="trackingSheetAdd?model.id=<s:property value='idts'/>&WSID=<s:property value='%{#stat.index}'/>">
				Нэмэх</a></td>

	</tr>
</s:iterator>