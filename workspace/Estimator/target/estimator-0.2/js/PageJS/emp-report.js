jQuery(function($) {
	pageScript();
	events();
	$(document).keydown(function(e) {
		if ($("#dialog-addnew").parents(".ui-dialog").is(":visible")) {
			if (e.which == 13) {
				$("#submitOk").trigger("click");
			}
		}
	});

	$("#date1").datepicker({
		changeMonth : true,
		changeYear : true,
		dateFormat : "yy-mm-dd",
	});
	$("#date2").datepicker({
		changeMonth : true,
		changeYear : true,
		dateFormat : "yy-mm-dd",
	});
	
	$("#empselect").chosen();
	$("#submit").click(function(e){
		e.preventDefault();
		WinPrint = window.open('', '', 'left=0,top=0,width=800,height=900,toolbar=0,scrollbars=0,status=0');
		$.ajax({
			url:"emp-report-ajax",
			data:$("#searchFrom").serialize(),
			success: function(result){
				WinPrint.document.write(result);
			}
		});
	});
});
var id1;
function pageScript() {
	$("#sampletable2 th:nth-child(1), #sampletable2 td:nth-child(1)").hide();
	var context = $("#context").text().trim();
	var a = "http://" + window.location.host;
	var b = "/css/copy_csv_xls_pdf.swf";
	var c = a.concat(context);
	var n = c.concat(b);
	$("#sampletable2 tbody tr").click(function(e) {
		position1 = oTable1.fnGetPosition(this);
		id1 = oTable1.fnGetData(position1)[0];
		if ($(this).hasClass('success')) {
			$(this).removeClass('success');
		} else {
			oTable1.$('tr.success').removeClass('success');
			$(this).addClass('success');
		}

	});
	oTable1 = $('#sampletable2')
			.dataTable(
					{
						"sDom" : "<'row'<'col-xs-4'l><'col-xs-4'f><'col-xs-4'T>r>t<'row'<'col-xs-4 customTool'><'col-xs-4'i><'col-xs-4'p>>",
						"aaSorting" : [ [ 0, "desc" ] ],
						"iDisplayLength" : 25,
						"oLanguage" : {
							"sUrl" : "../localisation/dataTable.mn.txt"
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
}

function events() {

}
function fnGetSelected(oTableLocal) {
	return oTableLocal.$('tr.success');
}
