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
		$(".errorMessage").parents(".form-group").addClass("has-error");
		var id, sizes, position1;
		var context = $("#context").text().trim();
		var a = "http://" + window.location.host;
		var b = "/css/copy_csv_xls_pdf.swf";
		var c = a.concat(context);
		var n = c.concat(b);
		var oTable1 = $('#example')
				.dataTable(
						{
							"sDom" : "<'row'<'col-xs-4'l><'col-xs-4'f><'col-xs-4'T>r>t<'row'<'col-xs-4 customTool'><'col-xs-4'i><'col-xs-4'p>>",
							"aaSorting" : [ [ 0, "desc" ] ],
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