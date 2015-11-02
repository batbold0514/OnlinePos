jQuery(function($) {
		pageScript();
	});
	function pageScript() {
//		$("#sampletable2").DataTable();
		var id, sizes, position1;
		var context = $("#context").text().trim();
		var a = "http://" + window.location.host;
		var b = "/css/copy_csv_xls_pdf.swf";
		var c = a.concat(context);
		var n = c.concat(b);
		var oTable1 = $('#sampletable2')
				.dataTable(
						{
							"sDom" : "<'row'<'col-xs-4'l><'col-xs-4'f><'col-xs-4'T>r>t<'row'<'col-xs-4 customTool'><'col-xs-4'i><'col-xs-4'p>>",
							"aaSorting" : [ [ 6, "desc" ] ],
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