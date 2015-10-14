<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="display" uri="http://displaytag.sf.net"%>
<link href="../css/style.css" rel="stylesheet" type="text/css" />
<style type="text/css" title="currentStyle">
@import "../css/TableTools_JUI.css";

@import "../css/demo_table_jui.css";
</style>
<script src="../js/jquery.dataTables.js"></script>
<script type="text/javascript" charset="utf-8"
	src="../js/ZeroClipboard.js"></script>
<script type="text/javascript" charset="utf-8" src="../js/TableTools.js"></script>
<script charset="utf-8">
	$(document).ready(function() {
		var n = "http://" + window.location.host +"/css/copy_csv_xls_pdf.swf";
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
	});
</script>
<h3>
	<s:text name="List of payments" />
</h3>
<div class="demo_jui" style="margin-left: 50px; margin-right: 50px">
	<display:table name="paymentList" cellpadding="0" cellspacing="0"
		class="display" id="example">

		<display:column property="paymentNumber" title="Number"
			sortable="true" />
		<display:column property="paymentMethod" title="Method"
			sortable="true" />
		<display:column property="value" title="Value" sortable="true" />
		<display:column property="description" title="Description"
			sortable="true" />
		<display:column property="date" title="Date" sortable="true" />
		<display:column property="printed" title="Printed" sortable="true" />
		<display:setProperty name="export.excel.filename"
			value="Payment-List.xls" />
		<display:setProperty name="export.csv.filename"
			value="Payment-List.csv" />
		<%-- <display:column property="user" title="Teller" sortable="true" /> --%>
	</display:table>
</div>
<br />