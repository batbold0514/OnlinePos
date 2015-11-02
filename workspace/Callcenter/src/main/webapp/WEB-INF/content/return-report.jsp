<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="display" uri="http://displaytag.sf.net"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div class="form-group">
	<div class="row col-cm-12">
		<div class="col-sm-7 col-lg-6">
			<h3 class="page-title">
				<s:text name="returnreport" />
			</h3>
		</div>
		<div>
			<s:form action="return-report">
				<div class="row col-sm-12">
					<label for="startDate" class="control-label col-sm-1 col-lg-1">
						<s:text name="startDate" />
					</label>
					<div class="col-sm-2 col-lg-2">
						<s:textfield name="startDateString" value="%{startDateString}"
							cssClass="form-control" id="startDate" />
					</div>
					<label for="endDate" class="control-label col-sm-1 col-lg-1">
						<s:text name="endDate" />
					</label>
					<div class="col-sm-2 col-lg-2">
						<s:textfield name="endDateString" value="%{endDateString}"
							cssClass="form-control" id="endDate" />
					</div>
					<div class = "col-sm-2 col-lg-2">
						<s:select list="operators" listKey="id" listValue="code"
							headerKey="%" headerValue="Бүгд" name="operatorIdString"
							id="opId" cssClass="form-control selects"></s:select>
					</div>
					<div class = "col-sm-1 col-lg-1">
						<s:text name = "allShow"/><s:checkbox name = "allShow"/>
					</div>
					<div class="col-sm-3 col-lg-3">
						<button class="btn btn-success col-sm-12 col-lg-12">
							<s:text name="search" />
						</button>
					</div>
				</div>
			</s:form>
		</div>
	</div>
</div>
<hr>
<div class="row">
	<div class="portlet box blue">
		<div class="portlet-title">
			<div class="caption">
				<i class="fa fa-phone"> <s:text name="returns" /></i>
			</div>
			<div class="tools">
				<a href="javascript:;" class="collapse"></a>
			</div>
		</div>
		<div class="portlet-body">
			<div id="list-result">
				 <table class = "display table-bordered table-hoverdataTable" id = "sampletable2">
				 	<thead>
						<tr>
							<th>Хугацаа</th>
							<th>Компаны нэр</th>
							<th>Оператор</th>
							  	<s:if test="allShow == true">
							  		<th>Буцах шалтгаан</th>
								  	<th>Татварын албаны код</th>
									<th>Татварын төрөл</th>
								</s:if>
								<s:else>
									<th>Буцах шалтгаан</th>
									<th>Буцаалтын тоо</th>
								</s:else>  
							
						</tr>
					</thead>
					<tbody>
						 <s:iterator value="listOfReturnReportDebt" var="tpr">
						 	 <s:if test="allShow == true">
								<s:iterator value="#tpr.debtOfList" var="debt"> 
									<tr>
										<td> <s:property value = "#tpr.date"/></td>
										<td><s:property value = "#debt.taxPayer.companyName"/></td>
										<td><s:property value = "#tpr.operator.userName"/></td>
										<td> <s:property value = "#tpr.reason.description"/></td>
										<td><s:property value = "#debt.officeNumber"/></td>
										<td><s:property value = "#debt.type.typeName"/></td>
										
									</tr>
								</s:iterator> 
							</s:if><s:else>
								<tr>
									<td> <s:property value = "#tpr.date"/></td>
									<td><s:property value = "#tpr.debtOfList[0].taxPayer.companyName"/></td>
									<td><s:property value = "#tpr.operator.userName"/></td>
									<td> <s:property value = "#tpr.reason.description"/></td>
									<td> <s:property value = "#tpr.debtOfList.size"/></td>
									
								</tr>
								
							</s:else>
						</s:iterator> 
					</tbody>
				</table> 
			</div>
		</div>
	</div>
</div>

<script src="../js/PageJS/return-report.js"></script>