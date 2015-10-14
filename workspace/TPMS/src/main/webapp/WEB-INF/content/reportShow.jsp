<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="display" uri="http://displaytag.sf.net"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%-- <style>
.redclass {
	background-color: rgb(242, 220, 219);
}

.blueclass {
	background-color: rgb(218, 238, 243);
}
</style>

<script type="text/javascript">
	$(document).ready(function() {
		$('#backID').click(function() {
			window.history.back()
		});
	});
</script> --%>
<div class="hidden" id="page">
	<s:url action="allEmployeeSalary1" includeParams="none" />
</div>
<div class="page-content">
	<div class="page-header">
		<h2>
			<s:property value="#session.d1" />
			ны өдрөөс
			<s:property value="#session.d2" />
			ны өдөр хүртэлх тайлан
		</h2>
	</div>
	<div class="row">
		<div class="col-sm-12">
			<div class="table-responsive">
				<s:form>
					<table class="table table-bordered table-hover"
						id="salaryReportShow">
						<thead>
							<tr>
								<th class="blueclass" colspan="8"><s:text
										name="modelInformation" /></th>
								<th class="redclass"><s:property value="firstName" /></th>
								<s:iterator value="sumList">
									<th class="redclass" colspan="3"><s:property
											value="workStep.stepPrice.productStep.name" /></th>
								</s:iterator>
								<th class="redclass"><s:text name="bodogdson" /></th>
							</tr>
							<tr>
								<th class="blueclass">№</th>
								<th class="blueclass">Загварын нэр төрөл</th>
								<th class="blueclass">Өнгө</th>
								<th class="blueclass">Хэмжээ</th>
								<th class="blueclass">Тоо ширхэг</th>
								<th class="blueclass">Гарсан гр жин</th>
								<th class="blueclass">Нэгж гр жин</th>
								<th class="blueclass">Карт №</th>
								<th class="redclass">их бие</th>

								<s:iterator value="sumList">
									<th class="redclass">үнэлгээ</th>
									<th class="redclass">тоо</th>
									<th class="redclass">нийт</th>
								</s:iterator>
								<th></th>
							</tr>
						</thead>
						<tbody>
							<s:iterator value="listReportShows">
								<tr>
									<td></td>
									<td><s:property value="modelNo" /></td>
									<td><s:property value="color" /></td>
									<td><s:property value="size" /></td>
									<td><s:property value="quantity" /></td>
									<td><s:property
											value="getText('{0,number,#,##0}',{outWeight})" /></td>
									<td><s:if test="quantity ==0"> 0
					</s:if> <s:else>
											<s:property value="getText('{0,number,#,##0}',{oneWeight})" />
										</s:else></td>
									<td><s:property value="CardNo" /></td>
									<td><s:property value="Number" /></td>
									<s:iterator value="sumWorkSteps">
										<s:if test="sum!=0">
											<th><s:property value="workStep.stepPrice.price" /></th>
											<th><s:property value="workStep.quantity" /></th>
											<th><s:property value="sum" /></th>
										</s:if>
										<s:else>
											<td><s:property value="workStep.stepPrice.price" /></td>
											<td><s:property value="0" /></td>
											<td><s:property value="sum" /></td>
										</s:else>
									</s:iterator>
									<td><s:property value="secondSum" /></td>
								</tr>
							</s:iterator>
						</tbody>
						<tfoot>
							<tr>
								<td>Нийт</td>
								<td></td>
								<td></td>
								<td></td>
								<td id = "total"></td>
								<td></td>
								<td></td>
								<td></td>
								<td></td>
								<s:iterator value="totalSumList">
									<td></td>
									<td></td>
									<td><s:property /></td>
								</s:iterator>
								<td><s:property value="secondTotal"/></td>
							</tr>
						</tfoot>
					</table>
					<div class="row">
						<div class="col-sm-5">
							<button class="btn btn-success col-sm-3 col-lg-3">
								<s:text name="back" />
							</button>
						</div>
						<%-- <table>
							<sj:submit value="%{getText('back')}"
								cssStyle="font-size:14px; float:right" button="true" id="backID" />
						</table> --%>
					</div>
				</s:form>
			</div>
		</div>
	</div>
</div>
<script>
	jQuery(function($) {
		var id, value, name, position1, oTable1;
		var context = $("#context").text().trim();
		var a = "http://" + window.location.host;
		var b = "/css/copy_csv_xls_pdf.swf";
		var c = a.concat(context);
		var n = c.concat(b);
		oTable1 = $("#salaryReportShow")
				.dataTable(
						{
							"fnFooterCallback" : function(nRow, aaData, iStart,
									iEnd, aiDisplay) {
								var iPageMarket = 0;
								var sellprice = 0;
								for ( var i = 0; i < aaData.length; i++) {
									var countPrice = aaData[i][4];
									var x = countPrice.indexOf(",");
									while (x != -1) {
										countPrice = countPrice.substring(0, x)
												+ countPrice.substring(x + 1);
										x = countPrice.indexOf(",");
									}
									iPageMarket += countPrice * 1;
								}
								var nCells = document.getElementById('total');
								nCells.innerHTML = iPageMarket;
							},
							"sDom" : "<'row'<'col-xs-4'l><'col-xs-4'f><'col-xs-4'T>r>t<'row'<'col-xs-4 customTool'><'col-xs-4'i><'col-xs-4'p>>",
							"sScrollX" : "100%",
							"iDisplayLength" : 25,
							"oTableTools" : {
								"sSwfPath" : n,
								"sRowSelect" : "single",
								"aButtons" : [ {
									"sExtends" : "copy",
									"sButtonText" : "Хуулах"
								}, {
									"sExtends" : "xls",
									"sButtonText" : "Excel руу хадгалах"
								} ]
							}
						});
	});

	
</script>