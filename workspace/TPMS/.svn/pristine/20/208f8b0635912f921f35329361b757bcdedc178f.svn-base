<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<%@ taglib prefix="sx" uri="/struts-dojo-tags"%>
<%@ taglib prefix="display" uri="http://displaytag.sf.net"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<sj:head jquerytheme="south-street" jqueryui="true" />
<sx:head />
<link href="../css/style.css" rel="stylesheet" type="text/css" />
<style type="text/css" title="currentStyle">
@import "../css/demo_page.css";

@import "../css/TableTools_JUI.css";

@import "../css/demo_table_jui.css";

* {
	font-size: 14px;
	font-family: Helvetica, Arial, sans-serif;
}
</style>
<script src="../js/jquery.dataTables.js"></script>
<script src="../js/excellentexport.js"></script>
<script type="text/javascript" charset="utf-8"
	src="../js/ZeroClipboard.js"></script>
<script type="text/javascript" charset="utf-8" src="../js/TableTools.js"></script>
<script charset="utf-8">
	$(document).ready(function() {
		var n = "http://" + window.location.host + "${pageContext.request.contextPath}/css/copy_csv_xls_pdf.swf";
		$('#example').dataTable({
			"bJQueryUI" : true,
			"sPaginationType" : "full_numbers",
			"sDom" : '<"H"Tlfr>t<"F"ip>',
			"oTableTools" : {
				"sSwfPath" : n,
				"aButtons" : [ {
					"sExtends" : "copy",
					"sButtonText" : "Copy to clipboard"
				}, {
					"sExtends" : "xls",
					"sButtonText" : "Save for Excel"
				} ]
			}
		});
		$("#focus").focus();
	});
</script>
<body onload="autoClick()">
	<div class="demo_jui" style="margin-left: 50px; margin-right: 50px">
		<display:table id="example" cellpadding="0" cellspacing="0"
			class="display" name="modelReportList">
			<display:column property="quantity" title="Тоо хэмжээ" />
			<display:column property="model.sellPrice" title="Худалдах үнэ" />
			<display:column property="model.modelId" title="Сериал дугаар" />
			<display:column property="weight"  title="Пакетын жин" />
			<display:column property="sizes.sizes" title="Размер" />
			<display:column property="colour.code" title="Өнгө" />
			<display:column property="barCode" title="Бар код" />
			<display:column title="Нэр" />
			<display:column title="Хэмжих нэгж" />
			<display:column title="Худалдан авсан үнэ" />
			<display:column title="Доод хэмжээ" />
			<display:column title="Тайлбар" />
			<display:column title="Байрлал" />
			<display:column title="Нярав" />
			<display:column title="Чийгшил" />
			<display:column title="Категор" />
			<display:column title="Партын дугаар" />
		</display:table>
	</div>
	<a download="model.xls" href="#" id="exportBtn"
		onclick="return ExcellentExport.excel(this, 'example','products');">
		Export table to Excel</a>
</body>
<script>
	function autoClick() {
		document.getElementById('exportBtn').click();
		window.location = 'modelReport';
	}
</script>
