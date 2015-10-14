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

$(document).ready(
			function() {
				$(".date").datepicker({
					changeMonth : true,
					changeYear : true,
					dateFormat : "yy-mm-dd",
					defaultDate : new Date()
				});
				var n = "http://" + window.location.host
						+ "/css/copy_csv_xls_pdf.swf";
				var myTable = $('#example').dataTable(
						{
							"fnFooterCallback" : function(nRow, aaData, iStart,
									iEnd, aiDisplay) {
								var iTotalMarket = 0;
					            for ( var i=0 ; i<aaData.length ; i++ )
					            {
					            	var buy1 = aaData[i][3];
					            	var x1 = buy1.indexOf(",");
									while(x1!=-1){
										buy1 = buy1.substring(0,x1)+buy1.substring(x1+1);
										x1 = buy1.indexOf(",");
									}
									iTotalMarket += buy1 * 1;
					            }
								/*
								 * var iPageMarket = 0; for ( var i = iStart; i <
								 * iEnd; i++) { var buy =
								 * aaData[aiDisplay[i]][3]; var x =
								 * buy.indexOf(","); while (x != -1) { buy =
								 * buy.substring(0, x) + buy.substring(x + 1); x =
								 * buy.indexOf(","); } iPageMarket += buy * 1; }
								 */

								var nCells = document.getElementById('total');
								nCells.innerHTML = CommaFormatted(iTotalMarket);
								<%
									if(Messages.getCustomer("customer").trim().equals(Customer.degfim.toString().trim())){
								%>
								var iTotalMarket = 0;
					            for ( var i=0 ; i<aaData.length ; i++ )
					            {
					            	var buy1=aaData[i][4];
					            	var x1 = buy1.indexOf(",");
									while(x1!=-1){
										buy1 = buy1.substring(0,x1)+buy1.substring(x1+1);
										x1 = buy1.indexOf(",");
									}
									iTotalMarket += buy1 * 1;
					            }
								/*
								 * iPageMarket = 0; for ( var i = iStart; i <
								 * iEnd; i++) { var buy =
								 * aaData[aiDisplay[i]][4]; var x =
								 * buy.indexOf(","); while (x != -1) { buy =
								 * buy.substring(0, x) + buy.substring(x + 1); x =
								 * buy.indexOf(","); } iPageMarket += buy * 1; }
								 */
								nCells = document.getElementById('total1');
								nCells.innerHTML = CommaFormatted(iTotalMarket);
								var iTotalMarket = 0;
					            for ( var i=0 ; i<aaData.length ; i++ )
					            {
					            	var buy1=aaData[i][5];
					            	var x1 = buy1.indexOf(",");
									while(x1!=-1){
										buy1 = buy1.substring(0,x1)+buy1.substring(x1+1);
										x1 = buy1.indexOf(",");
									}
									iTotalMarket += buy1 * 1;
					            }
								/*
								 * iPageMarket = 0; for ( var i = iStart; i <
								 * iEnd; i++) { var buy =
								 * aaData[aiDisplay[i]][5]; var x =
								 * buy.indexOf(","); while (x != -1) { buy =
								 * buy.substring(0, x) + buy.substring(x + 1); x =
								 * buy.indexOf(","); } iPageMarket += buy * 1; }
								 */
								nCells = document.getElementById('total2');
								nCells.innerHTML = CommaFormatted(iTotalMarket);
								var iTotalMarket = 0;
					            for ( var i=0 ; i<aaData.length ; i++ )
					            {
					            	var buy1=aaData[i][6];
					            	var x1 = buy1.indexOf(",");
									while(x1!=-1){
										buy1 = buy1.substring(0,x1)+buy1.substring(x1+1);
										x1 = buy1.indexOf(",");
									}
									iTotalMarket += buy1 * 1;
					            }
								/*
								 * iPageMarket = 0; for ( var i = iStart; i <
								 * iEnd; i++) { var buy =
								 * aaData[aiDisplay[i]][6]; var x =
								 * buy.indexOf(","); while (x != -1) { buy =
								 * buy.substring(0, x) + buy.substring(x + 1); x =
								 * buy.indexOf(","); } iPageMarket += buy * 1; }
								 */
								nCells = document.getElementById('total3');
								nCells.innerHTML = CommaFormatted(iTotalMarket);
								<% } %>
							},
							"sDom" : "<'row'<'col-xs-4'l><'col-xs-4'f><'col-xs-4'T>r>t<'row'<'col-xs-4'C><'col-xs-4'i><'col-xs-4'p>>",
							"aoColumnDefs" : [ {
								"bVisible" : false,
								"aTargets" : [ 1 ]
							} ],
							"oColVis":{"buttonText":"Багана ",
								       "sRestore": "Revert to original visibility"},
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
				$("#example tbody tr").click("click", function(event) {
					var position = myTable.fnGetPosition(this); // getting the
																// clicked row
																// position
					var id = myTable.fnGetData(position)[1]; // getting the
																// value of the
																// first
																// (invisible)
																// column
					window.location = "showDoctorOfMonthBalance1?model=" + id;

				});
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
<div class="page-content">
	<div class="page-header">
		<h2>
			<s:text name="monthb" />
			<small> <i class="icon-double-angle-right"></i> Жагсаалт
			</small>
		</h2>
	</div>
	<div class="row">
	<div class="col-sm-12 col-lg12">
	<s:form action="monthBalance1" cssClass="form-horizontal">
		   <div class="row">
				<div class="col-sm-6 col-lg-6">
				    <div class="form-group">
						<label for="date" class="col-sm-6 col-lg-6 control-label ">
							<s:text name="date" />:
						</label>
						<div class="col-sm-4 col-lg-4">
							<s:textfield name="dateStr" cssClass="date form-control" />
						</div>
					</div>
				</div>
				<div class="col-sm-6 col-lg-6">
					<%
						if (request.isUserInRole("admin-role")) {
					%>
					<div class="form-group">
						<label for="doctorID" class="col-sm-4 col-lg-4 control-label ">
							<s:text name="doctorID" />:
						</label>
						<div class="col-sm-4 col-lg-4 ">
							<s:select key="doctorID" list="doctors" listValue="name"
								listKey="id" headerValue="Бүгд" headerKey="-1" cssClass="form-control"/>
						</div>
					</div>
					<%
						}
					%>
				</div>
			</div>
			<div class="row">
				<div class="col-sm-6 col-lg-6">
					<div class="form-group">
						<label for="secondDate" class="col-sm-6 col-lg-6 control-label ">
							<s:text name="secondDate" />:
						</label>
						<div class="col-sm-4 col-lg-4 ">
							<s:textfield name="secondDateStr" cssClass="date form-control" />
						</div>
					</div>
				</div>
				<div class="col-sm-offset-2 col-lg-offset-2 col-sm-4 col-lg-4">
					<button class="btn btn-success col-sm-6 col-lg-6">
					    <i class="icon-search"></i>
						<s:text name="search" />
					</button>
				</div>
			</div>
	</s:form>
	<div class="hr hr-24"></div>
	<s:set var="host">${pageContext.request.serverName}</s:set>
	<br> <br> <input value="${host}" style="display: none"
		id="host">
		<display:table name="listMonthBalance"class="table table-striped table-bordered table-hover" id="example">
			<display:column property="orderNumber" title="Д/д" />
			<display:column property="doctor.id" title="" />
			<display:column property="doctor.name" title="Эмч" />
			<display:column property="totalPrice" format="{0,number,#,###}"
				title="Үйлчилгээний дүн" />
			<display:column property="paidValue" format="{0,number,#,###}"
				title="Орлого" />
			<display:column property="directValue" title="Шууд төлбөр" />
			<display:column property="recoupment" title="Нөхөн төлбөр" />
			<%-- <c:forEach items="${example.priceMapList}" var="price">
			<display:column title="${price.sp.name}" format="{0,number,#,###}"
				value="${price.count}" />
		</c:forEach> --%>
			<display:column property="number" title="Үйлчилгээ хийсэн тоо" />
			<display:column property="duration" title="Үйлчилгээ хийсэн хугацаа"></display:column>
			<display:footer>
				<tr>
					<th><s:text name="total" /></th>
					<th />
					<th />
					<th id="total"></th>
					<th id="total1" />
					<%-- <c:forEach items="${example.priceMapList}" var="price">
					<th />
				</c:forEach> --%>
					<th id="total2" />
					<th id="total3" />
					<th />
					<th />
				</tr>
			</display:footer>
		</display:table>
	</div>
</div>
</div>
<%-- <script src="../js/PageJS/reportMonthBalance1.js"></script> --%>