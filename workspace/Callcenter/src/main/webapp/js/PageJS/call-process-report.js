jQuery(function($) {
	pageScript();
	$("#startDate").datepicker({
		changeMonth : true,
		changeYear : true,
		dateFormat : "yy-mm-dd",
	});
	$("#endDate").datepicker({
		changeMonth : true,
		changeYear : true,
		dateFormat : "yy-mm-dd",
	});
});
function pageScript() {
	// $("#sampletable2").DataTable();
	//$("#sampletable2 th:nth-child(1), #sampletable2 td:nth-child(1)").hide();
	$(".errorMessage").parents(".form-group").addClass("has-error");
	var id, sizes, position1;
	var context = $("#context").text().trim();
	var a = "http://" + window.location.host;
	var b = "/css/copy_csv_xls_pdf.swf";
	var c = a.concat(context);
	var n = c.concat(b);
	var oTable1 = $('#sampletable2')
			.dataTable(
					{
						"fnFooterCallback" : function(nRow, aaData, iStart,
								iEnd, aiDisplay) {
							var total = 0;
				            for ( var i=0 ; i<aaData.length; i++ )
				            {
								total += numeral().unformat(aaData[i][2]);
				            }
							var nCells = document.getElementById('total');
							nCells.innerHTML = numeral(total).format('0,0.00');;
							
						},
						"sDom" : "<'row'<'col-xs-4'l><'col-xs-4'f><'col-xs-4'T>r>t<'row'<'col-xs-4 customTool'><'col-xs-4'i><'col-xs-4'p>>",
						"aaSorting" : [ [ 0, "asc" ] ],
						"iDisplayLength" : 25,
						"oLanguage": {
							"sUrl":"../localisation/dataTable.mn.txt"
						},
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
	$("#sampletable2 tbody tr").click(function(e) {
		position1 = oTable1.fnGetPosition(this);
		if ($(this).hasClass('success')) {
			$(this).removeClass('success');
		} else {
			oTable1.$('tr.success').removeClass('success');
			$(this).addClass('success');
		}	
	});
	
	/*$("#sampletable2 tbody tr").dblclick(function(e) {
		position1 = oTable1.fnGetPosition(this);
		var id = oTable1.fnGetData(position1)[0];
		window.location = "show-plan?model.id=" + id;
	});*/

	function fnGetSelected(oTableLocal) {
		return oTableLocal.$('tr.success');
	}
}