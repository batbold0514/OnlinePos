jQuery(function($) {
	pageScript();
	$("#startDate").daterangepicker(
			{
				startDate : moment().startOf('month'),
				endDate : moment(),
				format : 'YYYY-MM-DD',
				buttonClasses : [ 'btn btn-sm' ],
				applyClass : 'btn-primary',
				cancelClass : 'btn-default',
				showDropdowns : true,
				ranges : {
					'Өнөөдөр' : [ moment(), moment() ],
					'Өчигдөр' : [ moment().subtract('days', 1),
							moment().subtract('days', 1) ],
					'Сүүлийн 7 хоног' : [ moment().subtract('days', 6),
							moment() ],
					'Сүүлийн 30 хоног' : [ moment().subtract('days', 29),
							moment() ],
					'Өнгөрсөн сар' : [
							moment().subtract('month', 1).startOf('month'),
							moment().subtract('month', 1).endOf('month') ],
					'Энэ сар' : [ moment().startOf('month'),
							moment().endOf('month') ],
				},
				locale : {
					applyLabel : 'Сонгох',
					cancelLabel : 'Цуцлах',
					fromLabel : 'Эхлэх',
					toLabel : 'Дуусах',
					customRangeLabel : 'Гараар сонгох',
					daysOfWeek : [ 'Ня', 'Да', 'Мя', 'Лх', 'Пү', 'Ба', 'Бя' ],
					monthNames : [ '1 сар', '2 сар', '3 сар', '4 сар', '5 сар',
							'6 сар', '7 сар', '8 сар', '9 сар', '10 сар',
							'11 сар', '12 сар' ]
				} 
				
			},
			
			function(start, end) {
				console.log("Callback has been called!");
				$('#startDate span').html(
						start.format('MMMM D, YYYY') + ' * '
								+ end.format('MMMM D, YYYY'));
			});
	$("#endDate").daterangepicker(
			{
				startDate : moment().startOf('month'),
				endDate : moment(),
				format : 'YYYY-MM-DD',
				buttonClasses : [ 'btn btn-sm' ],
				applyClass : 'btn-primary',
				cancelClass : 'btn-default',
				showDropdowns : true,
				ranges : {
					'Өнөөдөр' : [ moment(), moment() ],
					'Өчигдөр' : [ moment().subtract('days', 1),
							moment().subtract('days', 1) ],
					'Сүүлийн 7 хоног' : [ moment().subtract('days', 6),
							moment() ],
					'Сүүлийн 30 хоног' : [ moment().subtract('days', 29),
							moment() ],
					'Өнгөрсөн сар' : [
							moment().subtract('month', 1).startOf('month'),
							moment().subtract('month', 1).endOf('month') ],
					'Энэ сар' : [ moment().startOf('month'),
							moment().endOf('month') ]
				},
				locale : {
					applyLabel : 'Сонгох',
					cancelLabel : 'Цуцлах',
					fromLabel : 'Эхлэх',
					toLabel : 'Дуусах',
					customRangeLabel : 'Гараар сонгох',
					daysOfWeek : [ 'Ня', 'Да', 'Мя', 'Лх', 'Пү', 'Ба', 'Бя' ],
					monthNames : [ '1 сар', '2 сар', '3 сар', '4 сар', '5 сар',
							'6 сар', '7 сар', '8 сар', '9 сар', '10 сар',
							'11 сар', '12 сар' ]
				}
			},
			function(start, end) {
				console.log("Callback has been called!");
				$('#startDate span').html(
						start.format('MMMM D, YYYY') + ' - '
								+ end.format('MMMM D, YYYY'));
			});
	$(".selects").chosen();
});
function pageScript() {
	// $("#sampletable2").DataTable();
	// $("#sampletable2 th:nth-child(1), #sampletable2 td:nth-child(1)").hide();
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
							for ( var i = 0; i < aaData.length; i++) {
								total += numeral().unformat(aaData[i][5]);
							}
							var nCells = document
									.getElementById('totalBalance');
							nCells.innerHTML = numeral(total).format('0,0.00');

						},
						"sDom" : "<'row'<'col-xs-4'l><'col-xs-4'f><'col-xs-4'T>r>t<'row'<'col-xs-4 customTool'><'col-xs-4'i><'col-xs-4'p>>",
						"aaSorting" : [ [ 0, "asc" ] ],
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
	$("#sampletable2 tbody tr").click(function(e) {
		position1 = oTable1.fnGetPosition(this);
		if ($(this).hasClass('success')) {
			$(this).removeClass('success');
		} else {
			oTable1.$('tr.success').removeClass('success');
			$(this).addClass('success');
		}
	});

	/*
	 * $("#sampletable2 tbody tr").dblclick(function(e) { position1 =
	 * oTable1.fnGetPosition(this); var id = oTable1.fnGetData(position1)[0];
	 * window.location = "show-plan?model.id=" + id; });
	 */

	function fnGetSelected(oTableLocal) {
		return oTableLocal.$('tr.success');
	}
}