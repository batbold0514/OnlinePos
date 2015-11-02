<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="display" uri="http://displaytag.sf.net"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class = "row">
	<table border="1px"; style="width: 550px;margin-left: 20px" >
		<tr>
			<td style="width: 100px">
				<s:text name ="companyname" />
			</td>
			<td > 
				<s:text name="regNumber" />
			</td>
			<td >
				<s:text name="rectorFirstName" />
			</td>
			<td >
				<s:text name="rectorLastName" />
			</td>
		</tr>
		<tr>
			<td style="width: 100px">
				<s:property value="taxPayer.companyName" />
			</td>
			<td > 
				<s:property value="taxPayer.regNumber" />
			</td>
			<td >
				<s:property value="taxPayer.rectorFirstName" />
			</td>
			<td >
				<s:property value="taxPayer.rectorLastName" />
			</td>
		</tr>
		<tr>
			<td colspan="2">
				<div class ="col-sm-6"> Дуудлагын тоо</div>
				<div class="col-sm-6"><s:property value="callQuantity"/></div>
			</td>
			<td colspan="2">
				<div class ="col-sm-6"> <s:text name="index"/>:</div>
				<div class="col-sm-6"><s:property value="callIndex"/></div>
			</td>
		</tr>
	<c:forEach items="${listOfDebtx}" var="debt">
		<tr>
			<td style="width: 100px">
				<c:out value="${debt.debt.debtNumber}" />
			</td>
			<td colspan="3">
				<table style="width: 450px;">
					<tr>
						<td>
							<div class ="col-sm-6"> Үнэ</div>
							<div class="col-sm-6"> <c:out value="${debt.debt.balance}" /></div>	
						</td>
						<td>
							<div class ="col-sm-6"> <s:text name="index"/>:</div>
							<div class="col-sm-6"> <c:out value="${debt.balanceIndex}" /></div>
						</td>
					</tr>
					<tr>
						<td>
							<div class ="col-sm-6"> Төрлийн нэр</div>
							<div class="col-sm-6"><c:out value="${debt.debt.type.typeName}" /></div>
						</td>
						<td>
							<div class ="col-sm-6"> <s:text name="index"/>:</div>
							<div class="col-sm-6"> <c:out value="${debt.debt.type.debtTypeIndex}" /></div>
						</td>
					</tr>
					<tr>
						<td>
							<div class ="col-sm-6"> Өдөр</div>
							<div class="col-sm-6"> <c:out value="${debt.date}" /></div>
						</td>
						<td>
							<div class ="col-sm-6"> <s:text name="index"/>:</div>
							<div class="col-sm-6"><c:out value="${debt.dateIndex}" /></div>
						</td>
					</tr> 
				</table>
			</td>
		</tr>
	</c:forEach>
	</table>
</div>
