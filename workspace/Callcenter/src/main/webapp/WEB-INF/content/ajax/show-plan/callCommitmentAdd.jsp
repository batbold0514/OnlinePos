<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<s:set var="location" value="#session.callCommitmentLocation"></s:set>
	  <table class="table table-hoverdataTable table-bordered">
	  	<s:hidden class="" name="callCommitments[%{#location}].listsize" />
		<s:hidden class="" name="callCommitments[%{#location}].primaryData" />
		<thead>
			<tr>
				<th>Татварын дугаар</th>
				<th>Татварын төрөл</th>
				<th>Өрийн дүн</th>
				<th>Мэдэгхэд хуудас үүссэн огноо</th>
				<th>Өр үүссэн он,улирал</th>
				<th>Өр дуудах төвөөс буцах хугацаа</th>
				<th>Татварын алба</th>
				<th>Тайлангын хэлбэр</th>
				<th>Хэсэгчилж төлөх дүн</th>
				<th>Огноо</th>
				<th>Тайлбар</th>
			</tr>
		</thead>
		<tbody>
		<s:iterator begin="0" end="#session.callCommitments[#location].listsize" status="statUnit">
				<tr >
					<th>
						<s:property value="#session.callCommitments[#location].listOfDebt[#statUnit.index].debtNumber" />
						<input name="callCommitments[${location}].listOfDebt[${statUnit.index}].id" type="text" value="${callCommitments[location].listOfDebt[statUnit.index].id}" class = "hide"/>
						</th>
					<th><s:property value="#session.callCommitments[#location].listOfDebt[#statUnit.index].type.typeName" /></th>
					<th><s:property value="getText('{0,number,#,##0.00}',{#session.callCommitments[#location].listOfDebt[#statUnit.index].balance})" /></th>
					<th> <s:date name="#session.callCommitments[#location].listOfDebt[#statUnit.index].startDate" format="yyyy-MM-dd"/> </th>
					<th><s:property value="#session.callCommitments[#location].listOfDebt[#statUnit.index].create_yaer" />-<s:property value="#session.callCommitments[#location].listOfDebt[#statUnit.index].bill_time" /></th>
					<th><s:date name="#session.callCommitments[#location].listOfDebt[#statUnit.index].endDate" format="yyyy-MM-dd"/></th>
					<th><s:property value="#session.callCommitments[#location].listOfDebt[#statUnit.index].officeNumber" /></th>
					<th><s:property value="#session.callCommitments[#location].listOfDebt[#statUnit.index].dtype_code" /></th>
						<th>
							<div class="form-group">
								<div class="row" >
									<div class="col-sm-12">
										<div class="col-sm-12">
											<input class="commitValue" name="callCommitments[${location}].commitValues[${statUnit.index}]" type="text" 
											value = "<s:property value = '#session.callCommitments[#location].commitValues[#statUnit.index]'/>"/>
										</div>
									</div>
								</div>
								<div class="row">
									<div class="col-sm-12"
										id="errorCommitValues${location}${statUnit.index}Result">
										<s:fielderror
											fieldName="commitValues<s:property value='%{#location}'/><s:property value='%{#statUnit.index}'/>" />
									</div>
								</div>
							</div>
						</th>
						  <th>
							<div class="form-group">
								<div class="row">
									<div class="col-sm-12">
										<div class="col-sm-12">
											<input class="paydate" name="callCommitments[${location}].commitDates[${statUnit.index}]" type="text"
											value = "<s:property value = '#session.callCommitments[#location].commitDates[#statUnit.index]'/>"/>
										</div>
									</div>
								</div>
								<div class="row">
									<div class="col-sm-12"
										id="errorCommitDates${location}${statUnit.index}Result">
										<s:fielderror
											fieldName="commitDates<s:property value='%{#location}'/><s:property value='%{#statUnit.index}'/>" />
									</div>
								</div>
							</div>
						</th>
						<th style="width: 30%">
							<div class="input-group">
								<input class="form-control" name="callCommitments[${location}].commitDescriptions[${statUnit.index}]" type="text"
								value = "<s:property value = '#session.callCommitments[#location].commitDescriptions[#statUnit.index]'/>"/>
								 <c:if test="${statUnit.index < callCommitments[location].primaryData}">
								 	<span class="input-group-addon input-sm" style="cursor:pointer" onclick="callCommitmentAdd(${location},${statUnit.index})">
	                               	<i class="fa fa-plus" style="color: green" ></i>
	                               </span>
	                             </c:if>
	                             <c:if test="${statUnit.index >= callCommitments[location].primaryData}">
	                           		 <span class="input-group-addon input-sm" onclick="callCommitmentRemove(${location},${statUnit.index})" style="cursor:pointer">
	                              		<i class="fa fa-minus" style="color: red" ></i>
	                            	</span>
	                             </c:if>
							</div>
						</th> 
					
				</tr>
			</s:iterator>
			</tbody>
		</table> 

<script type="text/javascript">
$(document).ready(function()
		{
	$('.paydate').datepicker({
		changeMonth : true,
		changeYear : true,
		dateFormat : "yy-mm-dd",
	});
	$('.dd').datepicker({
		changeMonth : true,
		changeYear : true,
		dateFormat : "yy-mm-dd",
	});
});
</script>