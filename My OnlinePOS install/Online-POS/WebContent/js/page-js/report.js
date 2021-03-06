$(document).ready(function()
{
	$('#startDate').daterangepicker
	(
		{
			startDate: moment().startOf('month'),
			endDate: moment(),
			format: 'YYYY-MM-DD',
			buttonClasses: ['btn btn-sm'],
			applyClass: 'btn-primary',
			cancelClass: 'btn-default',
			showDropdowns: true,
			ranges:
			{
				'Өнөөдөр': [moment(), moment()],
				'Өчигдөр': [moment().subtract('days', 1), moment().subtract('days', 1)],
				'Сүүлийн 7 хоног': [moment().subtract('days', 6), moment()],
				'Сүүлийн 30 хоног': [moment().subtract('days', 29), moment()],
				'Энэ сар': [moment().startOf('month'), moment().endOf('month')],
				'Сүүлийн сар': [moment().subtract('month', 1).startOf('month'), moment().subtract('month', 1).endOf('month')]
			},
			locale:
			{
				applyLabel: 'Сонгох',
				cancelLabel: 'Цуцлах',
				fromLabel: 'Эхлэх',
				toLabel: 'Дуусах',
				customRangeLabel: 'Гараар сонгох',
				daysOfWeek: ['Ня', 'Да', 'Мя', 'Лх', 'Пү', 'Ба','Бя'],
				monthNames: ['1 сар', '2 сар', '3 сар', '4 сар', '5 сар', '6 сар', '7 сар', '8 сар', '9 сар', '10 сар', '11 сар', '12 сар']
			}
		},
		function(start, end, label)
		{
			$('#startDate').val(start.format('YYYY-MM-DD'));
			$('#endDate').val(end.format('YYYY-MM-DD'));
		}
	);
	$('#startDate').on('apply.daterangepicker', function(ev, picker)
	{
		$('#startDate').val(picker.startDate.format('YYYY-MM-DD'));
		$('#endDate').val(picker.endDate.format('YYYY-MM-DD'));
	});
	$('#startDate').on('cancel.daterangepicker', function(ev, picker)
	{
		$('#startDate').val('');
		$('#endDate').val('');
	});
	
	$("#endDate").datepicker(
	{
		changeMonth: true,
		changeYear: true,
		dateFormat: "yy-mm-dd",
		option: $.datepicker.regional["mn"]
	});
	
	$('#startDate').mask('9999-99-99');
	$('#endDate').mask('9999-99-99');
	$("#mainTable th:nth-child(1), #mainTable td:nth-child(1)").hide();
	$('#mainTable').dataTable();
	
	$("#searchBtn").click(function(event)
    {
    	if (($("#startDate").val().trim() == "") || ($("#startDate").val().trim() == ""))
    	{
    		event.preventDefault();
    	}
    });
	$("#print").click(function(event){
		event.preventDefault();
		var WinPrint= window.open('', '', 'left=0,top=0,width=800,height=900,toolbar=0,scrollbars=0,status=0');
		WinPrint.document.write($("#printPage").html());
		WinPrint.document.close();
		WinPrint.focus();
		WinPrint.print();
		WinPrint.close();
	});
$(document).keydown(function(event)
{	
//	Ctrl+4
		if(event.keyCode == 52 && event.ctrlKey){
			event.preventDefault();
			$("#logoutDialog").dialog("open");
			$("#btnCncl").focus();
			
		}
//		F4		
		if(event.keyCode == 115){
			event.preventDefault();
			window.location = "cash.jsp";
		}
//		tab
		if(event.which == 9){
			if($("#back").is(":focus")){
				$('#startDate').focus();
				event.preventDefault();
			}
		}
// ctrl+p
//		$("#print")
});
	$("#logoutDialog").dialog(
			{
				title: "Гарах",
				title_html: true,
				autoOpen: false,
				modal: true,
				buttons:[ 
						{
							html: "<i class='icon-off bigger-110'></i>&nbsp; Гарах",
							"class" : "btn btn-danger btn-xs ",
							"id" : "btnok",
								click: function() {
									window.location = "logout";
								}
							},
							{
							html: "<i class='icon-remove bigger-110'></i>&nbsp; Болих",
							"class" : "btn btn-success btn-xs",
							"id" : "btnCncl",
								click: function() {
									$(this).dialog("close");
								}
							}
				         ]
			});
});