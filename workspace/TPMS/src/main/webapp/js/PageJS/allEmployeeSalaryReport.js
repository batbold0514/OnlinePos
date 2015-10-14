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
		var id, sizes, position1,oTable1;
		var context = $("#context").text().trim();
		var a = "http://" + window.location.host;
		var b = "/css/copy_csv_xls_pdf.swf";
		var c = a.concat(context);
		var n = c.concat(b);
		$("#example th:nth-child(5), #example td:nth-child(5)").hide();
		$("#example tbody tr").click(function(e) {
			position1 = oTable1.fnGetPosition(this);
			id = oTable1.fnGetData(position1)[0];
			sizes = oTable1.fnGetData(position1)[1];
			if ($(this).hasClass('success')) {
				$(this).removeClass('success');
			} else {
				oTable1.$('tr.success').removeClass('success');
				$(this).addClass('success');
			}
		});
		$("#example tbody tr").dblclick(function(event) {
			var position2 = oTable1.fnGetPosition(this);
			var id1 = oTable1.fnGetData(position2)[4];
			window.location = "reportShow?model.id=" + id1;
		});
		oTable1 = $('#example')
				.dataTable(
						{
							"sScrollX": "100%",
							"sDom" : "<'row'<'col-xs-4'l><'col-xs-4'f><'col-xs-4'T>r>t<'row'<'col-xs-4 customTool'><'col-xs-4'i><'col-xs-4'p>>",
							"iDisplayLength": 25,
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
		new FixedColumns( oTable1, {
	 		"iLeftColumns": 3
	 	} );
	}