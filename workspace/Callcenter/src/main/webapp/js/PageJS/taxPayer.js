jQuery(function($) {
	pageScript();
});
var userName, role, position1, id1, oTable1;
function pageScript() {
	var context = $("#context").text().trim();
	var a = "http://" + window.location.host;
	var b = "/css/copy_csv_xls_pdf.swf";
	var c = a.concat(context);
	var n = c.concat(b);
	$("#sampletable2 tbody tr").click(function(e) {
		position1 = oTable1.fnGetPosition(this);
		id1 = oTable1.fnGetData(position1)[0];
		description = oTable1.fnGetData(position1)[1];
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
						"aaSorting" : [ [ 2, "desc" ] ],
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
}

	function successMessage() {
		$.gritter.add({
			title : 'тайлбар',
			text : 'Амжилттай хадгаллаа',
			sticky : false,
			time : '1000'
		});
	}

	function errorMessage() {
		$.gritter.add({
			title : 'тайлбар',
			text : 'Алдаа гарлаа',
			sticky : false,
			time : '1000'
		});
	}

