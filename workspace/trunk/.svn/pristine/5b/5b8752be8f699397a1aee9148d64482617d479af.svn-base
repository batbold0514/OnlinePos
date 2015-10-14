<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="display" uri="http://displaytag.sf.net"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="hidden" id="page">
	<s:url action="search-patient" includeParams="none" />
</div>
<div class="page-content">
	<div class="page-header">
		<h2>
			<s:text name="listPatients" />
			<small> <i class="icon-double-angle-right"></i> Жагсаалт
			</small>
		</h2>
	</div>
	<div class="row">
		<div class="col-xs-12">
			<div class="table-responsive" id="list-result">
				<display:table name="patientAgeList"
					class="table table-striped table-bordered table-hover" id="example">
					<display:column property="id" title=""></display:column>
					<display:column href="calendarShow" paramProperty="id"
						paramId="model.id">
						<span class="label label-info arrowed-in-right arrowed"> <s:text
								name="appTime" />
						</span>
					</display:column>
					<display:column property="cardNumber" title="Картын дугаар"></display:column>
					<display:column property="lastName" title="Овог"></display:column>
					<display:column property="firstName" title="Нэр"></display:column>
					<display:column property="age" title="Нас" />
					<display:column property="regNumber" title="Регистер №"></display:column>
					<display:column property="phone" title="Гэрийн утас"></display:column>
					<display:column property="mobil_1" title="Гар утас"></display:column>
					<display:column property="mobil_2" title="Гар утас"></display:column>
					<display:column property="sex" title="Хүйс"></display:column>
				</display:table>
			</div>
		</div>
	</div>
</div>
<div id="parseResult" class=hidden></div>
<div id="context" class="hide">${pageContext.request.contextPath}
</div>
<script>
	jQuery(function($) {
		pageScript();
	});
	function pageScript() {
		$("#example th:nth-child(1), #example td:nth-child(1)").hide();
		$(".errorMessage").parents(".form-group").addClass("has-error");
		var userName, role, position1, id1, oTable1;
		var context = $("#context").text().trim();
		var a = "http://" + window.location.host;
		var b = "/css/copy_csv_xls_pdf.swf";
		var c = a.concat(context);
		var n = c.concat(b);
		$("#example tbody tr").click(function(e) {
			position1 = oTable1.fnGetPosition(this);
			id1 = oTable1.fnGetData(position1)[0];
			if ($(this).hasClass('success')) {
				$(this).removeClass('success');
			} else {
				oTable1.$('tr.success').removeClass('success');
				$(this).addClass('success');
			}
		});
		$("#example tbody tr").dblclick(function(event) {
			var position = oTable1.fnGetPosition(this);
			var id = oTable1.fnGetData(position1)[0];
			window.location = "showPatient?model.id=" + id;
		});
		oTable1 = $('#example')
				.dataTable(
						{
							"sDom" : "<'row'<'col-xs-4'l><'col-xs-4'f><'col-xs-4'T>r>t<'row'<'col-xs-4 customTool'><'col-xs-4'i><'col-xs-4'p>>",
							"aaSorting" : [ [ 2, "desc" ] ],
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
	}
</script>
<%-- <s:form action='linkPatient'>
	<sj:submit id="addPatient" value="%{getText('addPatient')}"
		button="true" cssStyle="font-size:15px; float:right"></sj:submit>
</s:form> --%>