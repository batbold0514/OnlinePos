<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<style>
.header {
	background-color: #8d8d8d;
	color: white;
}
</style>
<div class="hidden" id="page">
	<s:url action="trackingSheetList" includeParams="none"/>
</div>
<div class="page-content" >
	<div class="page-header">
		<h2>
			Дагалдах хуудас <small> <i class="icon-double-angle-right"></i>
				Дэлгэрэнгүй
			</small>
		</h2>
	</div>
	<div class="row">
		<div class="col-xs-12">
			<div class="row">
				<div class="col-sm-12">
					<div class="col-sm-offset-4 col-sm-7">
						Сүлжмэл бүтээгдэхүүний дагалдах хуудас. №: &nbsp;&nbsp;
						<strong><s:property value="startNumber" /></strong>
					</div>
					<div id="print" class="col-sm-1">
						<img src="../img/print.jpg" width="30px" height="30px">
					</div>
				</div>
			</div>
			<div class="row">
				<div class="col-sm-12">
					<div class="col-sm-offset-4">
						&nbsp;&nbsp;&nbsp;Захиалагчийн нэр: &nbsp;&nbsp;&nbsp;&nbsp;
						<s:property value="customer.name" />
					</div>
				</div>
			</div>

			<s:form action="trackingSheetSave" id="mainForm"
				cssClass="form-horizontal">
				<div class="table-responsive">
					<table class="table table-bordered table-hover">
						<s:hidden key="id" />
						<s:set var="idts">
							<s:property value="id" />
						</s:set>
						<s:hidden key="customerLong" value="%{#session.ts.customer.id}" />
						<s:hidden key="yarnColorString"
							value="%{#session.ts.yarnColor.id}" />
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
						<s:hidden key="bonusString" value="%{#session.ts.bonus.id}" />
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
							<td align="center">
								<c:forEach items="${yarnColorList}" var = "p">
									<c:out value=" ${p.code}"/>
								</c:forEach>
							</td>
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
							<td align="center"><c:forEach items="${yarnColorList}" var = "p">
									<c:out value=" ${p.name}"/>
								</c:forEach></td>
							<td align="center">Тоо:</td>
							<td align="center"><s:property value="knitterQuantity" /></td>
							<td align="center">Detail жин(гр):</td>
							<td align="center"><input
								style="width: 50px; text-align: right;"
								<s:property value='detailWeight'/> id="detail"
								onchange="myFunction()" /></td>
						</tr>
						<tr>
							<th>Сүлжигч:</th>
							<td colspan="3" align="center"><s:property value="mainKnitter.lastName" />&nbsp;<s:property value="mainKnitter.firstName" /></td>
							<th>Бэлэнгийн жин(гр):</th>
							<td align="center"><div>
									<table>
										<s:if test="%{status.id==0}">
											<s:textfield name="actualWeight"
												cssStyle="width:50px;text-align:right;" disabled="true" />
										</s:if>
										<s:else>
											<s:textfield name="actualWeight"
												cssStyle="width:50px;text-align:right;" />
										</s:else>
									</table>
								</div></td>
							<td align="center" title="Сүлжмэл + Detail">Нийт жин(гр):</td>
							<td align="center"><input readonly="readonly" id="sum"
								title="Сүлжмэл + Detail"
								style="border: none; width: 50px; text-align: right;" /></td>
						</tr>
						<tr>
						    <th colspan="1">Сүлжихийн ч.ш:</th>
							<td colspan="2" align="center"><s:property
									value="knitterChecker.firstName" /></td>
							<th colspan="1">Дамжлага дундын ч.ш:</th>
							<td colspan="1" align="center"><s:property
									value="productionStepChecker.firstName" /></td>
							<th colspan="2">Бэлэнгийн ч.ш:</th>
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
						<s:div id="my">
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
												name="wsDateList[%{#stat.index}]"  value ="%{#date}"/>
												
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
												cssStyle="width:100px" onchange="textChangeMy(%{#stat.index})" id = "myId%{#stat.index}"/>
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
						</s:div>
					</table>
				</div>
				<div class="row">
					<div class="col-sm-12">
						<div class="col-sm-offset-5">
							<s:radio id="focus" list="statusTrackingSheet" name="status"
								listValue="label" />
						</div>
					</div>
				</div>
				<div class="row">
					<div class="col-sm-12">
						<div class="col-sm-offset-5 col-sm-3">
							<input value="Хадгалах" class="btn btn-success" id="save"
								type="submit">
						</div>
						<div class="cols-sm-4">
							<a onclick="window.location = 'trackingSheetList'" class="btn btn-warning"> <b>Буцах</b>
							</a>
						</div>
					</div>
				</div>
			</s:form>
		</div>
	</div>
</div>

<script type="text/javascript">
	$(document).ready(function() {
		$("#focus").focus();
		$(".chosen-select").chosen();
		/*  window.onbeforeunload = function (e) {
		    var e = e || window.event;
		    var msg = "Do you really want to leave this page?"

		    // For IE and Firefox
		    if (e) {
		        e.returnValue = msg;
		    }

		    // For Safari / chrome
		    return msg;
		 };  */
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
	}
	function textChangeMy(val) { 
		$.ajax(
	     {
	    	url:"quantityChange-ajax",
	    	type: "POST",
	    	data:{
				 changeId:val,
				 quantityChange:$("#myId"+val).val()
				},
	    	 success:function(result)
	    	{
	    		$("#my").html(result);
	    	}
	     });
	}
	$(document)
			.ready(
					function() {
						$("#print").css('cursor', 'pointer');
						$('.dateMe').datepicker({
							changeMonth : true,
							changeYear : true,
							dateFormat : "yy-mm-dd",
							defaultDate: new Date()
						});
						$("#print")
								.click(
										function(event) {
											event.preventDefault();
											window.location.href = "trackingSheetPrint?model.id="
													+ <s:property value="id"/>;
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
