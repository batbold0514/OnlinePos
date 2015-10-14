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
		var context = $("#context").text().trim();
		var a = "http://" + window.location.host;
		var b = "/css/copy_csv_xls_pdf.swf";
		var c = a.concat(context);
		var n = c.concat(b);
		var oTable1 = $('#example')
				.dataTable(
						{
							"sDom" : "<'row'<'col-xs-4'l><'col-xs-4'f><'col-xs-4'T>r>t<'row'<'col-xs-4 customTool'><'col-xs-4'i><'col-xs-4'p>>",
							"aaSorting" : [ [ 0, "asc" ] ],
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
	}