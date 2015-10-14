$(document).ready(function() {
	initMainTable2();
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
if(aiRows.length!=1)
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
function initMainTable2() {
	var dtSWFpath = "http://" + window.location.host
			+ "/swf/copy_csv_xls_pdf.swf";
	var asInitVals = new Array();
	$(".tfot2 input").keyup(
			function() {
				/* Filter on the column (the index) of this element */
				var a = this.value;
				oTable.fnFilter(this.value, $(".tfot2 input").index(this),
						true, false);

			});

	$(".tfot2 input").each(function(i) {
		asInitVals[i] = this.value;
	});

	$(".tfot2 input").focus(function() {
		if (this.className == "search_init") {
			this.className = "";
			this.value = "";
		}
	});
	$("#mainTable tbody tr").css('cursor', 'pointer');
	$(".tfot2 input").blur(function(i) {
		if (this.value == "") {
			this.className = "search_init";
			this.value = asInitVals[$(".tfot2 input").index(this)];
		}
	});
	oTable = $('#mainTable')
	.dataTable(
			{
				"fnFooterCallback" : function(nRow, aaData, iStart,
						iEnd, aiDisplay) {
					var iPageMarket = 0;
					var sellprice = 0;
					for ( var i = iStart; i < iEnd; i++) {
						var countPrice= aaData[aiDisplay[i]][7];
						var buy=aaData[aiDisplay[i]][9];
						var x = countPrice.indexOf(",");
						while(x!=-1){
							countPrice = countPrice.substring(0,x)+countPrice.substring(x+1);
							x = countPrice.indexOf(",");
						}
						x= buy.indexOf(",");
						while(x!=-1){
							buy= buy.substring(0,x)+buy.substring(x+1);
							x = buy.indexOf(",");
						}
						if (countPrice
								* buy* 1 != null) {
							iPageMarket += countPrice
									* buy* 1;
						}
					}

					for ( var j = iStart; j < iEnd; j++) {
						var countPrice= aaData[aiDisplay[j]][7];
						var sell=aaData[aiDisplay[j]][10];
						var x = countPrice.indexOf(",");
						while(x!=-1){
							countPrice= countPrice.substring(0,x)+countPrice.substring(x+1);
							x = countPrice.indexOf(",");
						}
						x= sell.indexOf(",");
						while(x!=-1){
							sell= sell.substring(0,x)+sell.substring(x+1);
							x = sell.indexOf(",");
						}
						if (countPrice
								* sell * 1 != null) {
							sellprice += countPrice
									* sell * 1;
						}
					}
					var nCells = document.getElementById('total');
//					nCells.value = CommaFormatted(iPageMarket);
					nCells.innerHTML = CommaFormatted(iPageMarket);
					var nCells1 = document.getElementById('total1');
					nCells1.innerHTML = CommaFormatted(sellprice);
				},
				"sPaginationType" : "full_numbers",
				"sDom" : 'T<"clear">lfrtip',
				"aaSorting" :  [] ,
				"aoColumnDefs" : [ {
					"bSortable" : false,
					"aTargets" : [ 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10,
							11, 12 ]
				} ],
				"oTableTools" : {
					"sSwfPath" : dtSWFpath,
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
	
	$(document).ready(function() {
		$('.sort-box').chosen({});
		var foo = new Array();
		var sum1 = "";
		$(".sort-box").on('change', function(event, params) {
			var myValues = $('.sort-box :selected').text();
			for (x in params) {
				if (x == "selected") {
					foo.push(params[x]);
				} else if (x == "deselected") {
					foo.splice(foo.indexOf(params[x]), 1);
				}
			}
			sum1 = foo.toString();
			if(foo.length != 0)
			oTable.fnSort(eval("[" + sum1 + "]"));
			else oTable.fnSort([]);
		});
		
	});
	/*
	 * new FixedColumns( oTable, { "iLeftWidth": 150, "fnDrawCallback": function (
	 * left, right ) { var that = this, groupVal = null, matches = 0, heights =
	 * [], index = -1;
	 * 
	 * Get the heights of the cells and remove redundant ones $('tbody tr td',
	 * left.body).each( function ( i ) { var currVal = this.innerHTML;
	 * 
	 * Reset values on new cell data. if (currVal != groupVal) { groupVal =
	 * currVal; index++; heights[index] = 0; matches = 0; } else { matches++; }
	 * 
	 * heights[ index ] += $(this.parentNode).height(); if ( currVal == groupVal &&
	 * matches > 0 ) { this.parentNode.parentNode.removeChild(this.parentNode); } } );
	 * 
	 * Now set the height of the cells which remain, from the summed heights
	 * $('tbody tr td', left.body).each( function ( i ) { that.fnSetRowHeight(
	 * this.parentNode, heights[ i ] ); } ); } } );
	 */
	$("#mainTable tbody tr").click(function(event) {
		var position = oTable.fnGetPosition(this);
		var id = oTable.fnGetData(position)[0];
		window.location = "showArticle?model.id=" + id;
	});
	$(".tfot2 td").each(function(i) {
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