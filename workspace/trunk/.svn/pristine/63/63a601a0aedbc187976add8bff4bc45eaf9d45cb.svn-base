<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sx" uri="/struts-dojo-tags"%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="display" uri="http://displaytag.sf.net"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page import="mn.chinbat.surgery.enums.Customer"%>
<%@page import="mn.chinbat.surgery.model.Messages"%>

<script type="text/javascript">
	$(document)
			.ready(
					function() {
						var n = "http://" + window.location.host
								+ "/css/copy_csv_xls_pdf.swf";
						var myTable = $('#example')
								.dataTable(
										{
											"fnFooterCallback" : function(nRow,
													aaData, iStart, iEnd,
													aiDisplay) {
												var iTotalMarket = 0;
												for ( var i = 0; i < aaData.length; i++) {
													var buy1 = aaData[i][6];
													var x1 = buy1.indexOf(",");
													while (x1 != -1) {
														buy1 = buy1.substring(
																0, x1)
																+ buy1
																		.substring(x1 + 1);
														x1 = buy1.indexOf(",");
													}
													iTotalMarket += buy1 * 1;
												}
												var nCells = document
														.getElementById('total');
												nCells.innerHTML = CommaFormatted(iTotalMarket);
<%if (Messages.getCustomer("customer").trim()
					.equals(Customer.degfim.toString().trim())) {%>
	iTotalMarket = 0;
												for ( var i = 0; i < aaData.length; i++) {
													var buy1 = aaData[i][7];
													var x1 = buy1.indexOf(",");
													while (x1 != -1) {
														buy1 = buy1.substring(
																0, x1)
																+ buy1
																		.substring(x1 + 1);
														x1 = buy1.indexOf(",");
													}
													iTotalMarket += buy1 * 1;
												}
												nCells = document
														.getElementById('total1');
												nCells.innerHTML = CommaFormatted(iTotalMarket);
<%}%>
	},
											"sDom" : "<'row'<'col-xs-4'l><'col-xs-4'f><'col-xs-4'T>r>t<'row'<'col-xs-4'C><'col-xs-4'i><'col-xs-4'p>>",
											"aoColumnDefs" : [ {
												"bVisible" : false,
												"aTargets" : [ 1 ]
											} ],
											"oColVis" : {
												"buttonText" : "Багана "
											},
											"oTableTools" : {
												"sSwfPath" : n,
												"sRowSelect" : "single",
												"aButtons" : [
														{
															"sExtends" : "copy",
															"sButtonText" : "Хуулах"
														},
														{
															"sExtends" : "xls",
															"sButtonText" : "Excel руу хадгалах"
														} ]
											}
										});
						$("#example tbody tr").click("click", function(event) {
							var position = myTable.fnGetPosition(this); // getting the clicked row position
							var id = myTable.fnGetData(position)[1]; // getting the value of the first (invisible) column 
							window.location = "showPatient?model.id=" + id;

						});
						$("#example tbody tr").css('cursor', 'hand');
						var myTable1 = $('#example1')
								.dataTable(
										{
											"fnFooterCallback" : function(nRow,
													aaData, iStart, iEnd,
													aiDisplay) {
												iTotalMarket = 0;
												for ( var i = 0; i < aaData.length; i++) {
													var buy1 = aaData[i][5];
													var x1 = buy1.indexOf(",");
													while (x1 != -1) {
														buy1 = buy1.substring(
																0, x1)
																+ buy1
																		.substring(x1 + 1);
														x1 = buy1.indexOf(",");
													}
													iTotalMarket += buy1 * 1;
												}
												nCells = document
														.getElementById('total2');
												nCells.innerHTML = CommaFormatted(iTotalMarket);
											},
											"sDom" : "<'row'<'col-xs-4'l><'col-xs-4'f><'col-xs-4'T>r>t<'row'<'col-xs-4'C><'col-xs-4'i><'col-xs-4'p>>",
											"aoColumnDefs" : [ {
												"bVisible" : false,
												"aTargets" : [ 1 ]
											} ],
											"oColVis" : {
												"buttonText" : "Багана "
											},
											"oTableTools" : {
												"sSwfPath" : n,
												"sRowSelect" : "single",
												"aButtons" : [
														{
															"sExtends" : "copy",
															"sButtonText" : "Хуулах"
														},
														{
															"sExtends" : "xls",
															"sButtonText" : "Excel руу хадгалах"
														} ]
											}
										});
						$("#example1 tbody tr").click("click", function(event) {
							var position = myTable1.fnGetPosition(this); // getting the clicked row position
							var id = myTable1.fnGetData(position)[1]; // getting the value of the first (invisible) column 
							window.location = "showPatient?model.id=" + id;

						});
						$("#example1 tbody tr").css('cursor', 'hand');
						$('.chosen-select').chosen();
					});
	function CommaFormatted(amount) {
		var delimiter = ","; // replace comma if desired
		amount = new String(amount);
		var a = amount.split('.', 2)
		var i = parseInt(a[0]);
		if (isNaN(i)) {
			return '';
		}
		var minus = '';
		if (i < 0) {
			minus = '-';
		}
		i = Math.abs(i);
		var n = new String(i);
		var a = [];
		while (n.length > 3) {
			var nn = n.substr(n.length - 3);
			a.unshift(nn);
			n = n.substr(0, n.length - 3);
		}
		if (n.length > 0) {
			a.unshift(n);
		}
		n = a.join(delimiter);
		amount = n;
		amount = minus + amount;
		return amount;
	}
</script>
<div class="hidden" id="page">
	<s:url action="monthBalance1" includeParams="none" />
</div>
<div class="page-header">
	<h2>
		<s:text name="monthb" />
		<small> <i class="icon-double-angle-right"></i> Жагсаалт
		</small>
	</h2>
	<div class="col-sm-6 col-lg-5">
		<s:form action="servicePriceSearch1">
			<table>
				<tr>
					<td><s:select id="ls" name="listServicePrice"
							cssClass="form-control tag-input-style chosen-select"
							list="listMonthMap" listKey="sp.code" listValue="sp.code"
							multiple="true" data-placeholder="Үйлчилгээ сонгоно уу" /></td>
					<td>
						<button class="btn btn-success">
							<s:text name="search"></s:text>
						</button>
					</td>
				</tr>
			</table>
		</s:form>
	</div>
</div>
<div class="page-content">
	<div class="row">
		<div class="col-sm-12 col-lg-12">
			<s:set var="host">${pageContext.request.serverName}</s:set>
			<input value="${host}" style="display: none" id="host">
			<display:table name="listMonthBalance"
				class="table table-striped table-bordered table-hover" id="example">
				<display:column property="orderNumber" title="Д/д" />
				<display:column property="patient.id" title="" />
				<display:column property="doctor.name" title="Эмч" />
				<display:column property="patient.firstName" title="Үйлчлүүлэгч" />
				<display:column property="patient.regNumber" title="Регистер №"></display:column>
				<display:column property="patient.cardNumber" title="Картын дугаар" />
				<display:column property="totalPrice" format="{0,number,#,###}"
					title="Нийт орлого" />
				<display:column property="paidValue" format="{0,number,#,###}"
					title="Төлөгдсөн" />
				<c:forEach items="${example.priceMapList}" var="price">
					<display:column title="${price.sp.code}" format="{0,number,#,###}"
						value="${price.count}" />
				</c:forEach>
				<display:column property="number" title="Үйлчилгээ хийсэн тоо" />
				<display:column property="duration" title="Үйлчилгээ хийсэн хугацаа"></display:column>
				<display:footer>
					<tr>
						<th><s:text name="total" /></th>
						<th />
						<th />
						<th />
						<th />
						<th />
						<th id="total"></th>
						<th id="total1"></th>
						<c:forEach items="${example.priceMapList}" var="price">
							<th />
						</c:forEach>
						<th />
						<th />
					</tr>
				</display:footer>
			</display:table>
			<div class="hr hr-24"></div>
			<br> Нөхөн төлбөр <br> 
			<display:table name="listRecoupment"
				class="table table-striped table-bordered table-hover" id="example1">
				<display:column property="orderNumber" title="Д/д" />
				<display:column property="patient.id" title="" />
				<display:column property="doctor.name" title="Эмч" />
				<display:column property="patient.firstName" title="Үйлчлүүлэгч" />
				<display:column property="patient.cardNumber" title="Картын дугаар" />
				<display:column property="recoupment" format="{0,number,#,###}"
					title="Нөхөн төлбөр" />
				<display:footer>
					<tr>
						<th><s:text name="total" /></th>
						<th />
						<th />
						<th />
						<th />
						<th id="total2" />
					</tr>
				</display:footer>
			</display:table>
			<div>
				<a onclick="window.history.back()" style="text-decoration: none;"
					class="btn btn-back col-xs-12  col-sm-12 col-md-offset-2 col-md-10 col-lg-offset-4 col-lg-2">
					<span class="fa fa-arrow-circle-o-left"></span>&nbsp; <s:text
						name="back" />
				</a>
			</div>
		</div>
	</div>
</div>
<%-- <script src="../js/PageJS/reportMonthBalanceDoctor1.js"></script> --%>