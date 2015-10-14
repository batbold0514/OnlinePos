$(document).ready(function()
{
	initMainTable4();
	initDateRangePicker();
	$("#secondDate").datepicker(
	{
		changeMonth: true,
		changeYear: true,
		dateFormat: "yy-mm-dd",
		option: $.datepicker.regional["mn"]
	});
});

(function($) {
	$.fn.dataTableExt.oApi.fnGetColumnData = function(oSettings, iColumn,
			bUnique, bFiltered, bIgnoreEmpty) {
		// check that we have a column id
		if (typeof iColumn == "undefined")
			return new Array();

		// by default we only want unique data
		if (typeof bUnique == "undefined")
			bUnique = true;

		// by default we do want to only look at filtered data
		if (typeof bFiltered == "undefined")
			bFiltered = true;

		// by default we do not want to include empty values
		if (typeof bIgnoreEmpty == "undefined")
			bIgnoreEmpty = true;

		// list of rows which we're going to loop through
		var aiRows;

		// use only filtered rows
		if (bFiltered == true)
			aiRows = oSettings.aiDisplay;
		// use all rows
		else
			aiRows = oSettings.aiDisplayMaster; // all row numbers

		// set up data array
		var asResultData = new Array();

		for ( var i = 0, c = aiRows.length; i < c; i++) {
			iRow = aiRows[i];
			var aData = this.fnGetData(iRow);
			var sValue = aData[iColumn];

			// ignore empty values?
			if (bIgnoreEmpty == true && sValue.length == 0)
				continue;

			// ignore unique values?
			else if (bUnique == true
					&& jQuery.inArray(sValue, asResultData) > -1)
				continue;

			// else push the value onto the result data array
			else
				asResultData.push(sValue);
		}

		return asResultData;
	}
}(jQuery));

function initMainTable4() {
	var dtSWFpath = "http://" + window.location.host
			+ "/swf/copy_csv_xls_pdf.swf";
	var asInitVals = new Array();
	$(".tfot input").keyup(function() {
		/* Filter on the column (the index) of this element */
		var a = this.value;
		oTable.fnFilter(this.value, $(".tfot input").index(this), true, false);

	});

	$(".tfot input").each(function(i) {
		asInitVals[i] = this.value;
	});

	$(".tfot input").focus(function() {
		if (this.className == "search_init") {
			this.className = "";
			this.value = "";
		}
	});

	$("#mainTable tbody tr").css('cursor', 'pointer');

	$(".tfot input").blur(function(i) {
		if (this.value == "") {
			this.className = "search_init";
			this.value = asInitVals[$(".tfot input").index(this)];
		}
	});
	var position1;
	var id1;
	var oTable = $('#mainTable')
			.dataTable(
					{
						"fnFooterCallback" : function(nRow, aaData, iStart,
								iEnd, aiDisplay) {
							var iPageMarket = 0;
							for ( var i = iStart; i < iEnd; i++) {
								var countPrice=aaData[aiDisplay[i]][4]; 
								var buy = aaData[aiDisplay[i]][5];
								var x = countPrice.indexOf(",");
								while(x!=-1){
									countPrice = countPrice.substring(0,x)+countPrice.substring(x+1);
									x = countPrice.indexOf(",");
								}
								x= buy.indexOf(",");
								while(x!=-1){
									buy = buy.substring(0,x)+buy.substring(x+1);
									x = buy.indexOf(",");
								}
								if (countPrice
										* buy * 1 != null) {
									iPageMarket += countPrice
											* buy * 1;
								}
							}
							var nCells = document.getElementById('total');
							nCells.innerHTML = CommaFormatted(iPageMarket);
						},

						"sPaginationType" : "full_numbers",
						"sDom" : 'T<"clear">lfrtip',
						"aaSorting" : [ [ 0, "desc" ] ],
						"aoColumnDefs" : [ {
							"bVisible" : false,
							"aTargets" : [ 9 ]
						} ],
						"oTableTools" : {
							"sSwfPath" : dtSWFpath,
							"sRowSelect" : "single",
							"aButtons" : [
							  {
								  "sExtends" : "copy",
									"sButtonText" : "Хуулах",
									"bShowAll" : true,
							}, {
								"sExtends" : "print",
								"sButtonText" : "Хэвлэх",
								"bShowAll" : true,
							}, {
								"sExtends" : "collection",
								"sButtonText" : "Хадгалах",
								"aButtons" : [ "csv", "xls", "pdf" ]
							} ],
						},
						"oLanguage" : {
							"sLengthMenu" : "Нэг хуудсанд _MENU_-г харах",
							"sZeroRecords" : "Уучлаарай, юу ч олдсонгүй.",
							"sInfo" : "Нийт _TOTAL_ бичлэгийн _START_-с эхлэн _END_ хүртэл харуулж байна.",
							"sInfoEmpty" : "0 бичлэг байна.",
							"sInfoFiltered" : "(Нийт _MAX_ бичлэгээс хайв.)",
							"sSearch" : "Хайх: ",
							"oPaginate" : {
								"sFirst" : "Анхных",
								"sPrevious" : "<",
								"sNext" : ">",
								"sLast" : "Сүүлчийнх"
							}
						}
					});
	$("#mainTable tbody tr").click(function(e) {
		position1 = oTable.fnGetPosition(this);
		id1 = oTable.fnGetData(position1)[0];
		if ($(this).hasClass('row_selected')) {
			$(this).removeClass('row_selected');
		} else {
			oTable.$('tr.row_selected').removeClass('row_selected');
			$(this).addClass('row_selected');
		}
	});

	/* Add a click handler for the delete row */
	$('#show').click(function() {
		var anSelected = fnGetSelected(oTable);
		if (anSelected.length !== 0) {
			window.location = "inputArticleShow?model.id=" + id1;
			// oTable.fnDeleteRow( anSelected[0] );
		}
	});
	$('#edit').click(function() {
		var anSelected = fnGetSelected(oTable);
		if (anSelected.length !== 0) {
			window.location = "editInputArticle?model.id=" + id1;
			// oTable.fnDeleteRow( anSelected[0] );
		}
	});
	$('#input').click(function() {
		var anSelected = fnGetSelected(oTable);
		if (anSelected.length !== 0) {
			id = oTable.fnGetData(position1)[9];
			window.location = "addArticle?model.id=" + id;
			// oTable.fnDeleteRow( anSelected[0] );
		}
	});
	$('#inputPlus').click(function() {
		var anSelected = fnGetSelected(oTable);
		if (anSelected.length !== 0) {
			id = oTable.fnGetData(position1)[9];
			window.location = "addArticle?model.id=" + id;
		} else {
			window.location = "articleListSearch";
		}
	});
	function fnGetSelected(oTableLocal) {
		return oTableLocal.$('tr.row_selected');
	}
	$("#mainTable tbody tr").dblclick(function(event) {
		var position = oTable.fnGetPosition(this);
		var id = oTable.fnGetData(position)[9];
		window.location = "addArticle?model.id=" + id;
	});
	$(".tfot td").each(function(i) {
		this.innerHTML = fnCreateSelect(oTable.fnGetColumnData(i), i);
		$('select', this).change(function() {
		});
	});
}

function CommaFormatted(amount) {
    var delimiter = ","; // replace comma if desired
    amount = new String(amount);
    var a = amount.split('.',2)
    var i = parseInt(a[0]);
    if(isNaN(i)) { return ''; }
    var minus = '';
    if(i < 0) { minus = '-'; }
    i = Math.abs(i);
    var n = new String(i);
    var a = [];
    while(n.length > 3)
    {
        var nn = n.substr(n.length-3);
        a.unshift(nn);
        n = n.substr(0,n.length-3);
    }
    if(n.length > 0) { a.unshift(n); }
    n = a.join(delimiter);
    amount = n; 
    amount = minus + amount;
    return amount;
}
function fnCreateSelect(aData, count) {
	var r = '<datalist id="datalistId' + count + '"><option value=""></option>', i, iLen = aData.length;

	for (i = 0; i < iLen; i++) {
		r += '<option value="' + aData[i] + '">' + aData[i] + '</option>';
	}
	return r + '</datalist>';
}

function initDateRangePicker()
{
	$('#firstDate').daterangepicker
	(
		{
			startDate: moment().startOf('month'),
			endDate: moment(),
			format: 'YYYY-MM-DD',
			buttonClasses: ['btn'],
			applyClass: 'btn-sm btn-success col-sm-5',
			cancelClass: 'btn-sm btn-gray col-sm-offset-1 col-sm-5',
			showDropdowns: true,
			ranges:
			{
				'Өнөөдөр': [moment(), moment()],
				/* 'Өчигдөр': [moment().subtract('days', 1), moment().subtract('days', 1)], */
				'Сүүлийн 7 хоног': [moment().subtract('days', 6), moment()],
				/* 'Сүүлийн 30 хоног': [moment().subtract('days', 29), moment()], */
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
			$('#firstDate').val(start.format('YYYY-MM-DD'));
			$('#secondDate').val(end.format('YYYY-MM-DD'));
		}
	);
	$('#firstDate').on('apply.daterangepicker', function(ev, picker)
	{
		$('#firstDate').val(picker.startDate.format('YYYY-MM-DD'));
		$('#secondDate').val(picker.endDate.format('YYYY-MM-DD'));
	});
	$('#firstDate').on('cancel.daterangepicker', function(ev, picker)
	{
		$('#firstDate').val('');
		$('#secondDate').val('');
	});
}