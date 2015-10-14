$(document).ready(
			function() {
				$(".date").datepicker({
					changeMonth : true,
					changeYear : true,
					dateFormat : "yy-mm-dd",
					defaultDate : new Date()
				});
				var n = "http://" + window.location.host
						+ "/css/copy_csv_xls_pdf.swf";
				var myTable = $('#example').dataTable(
						{
							"fnFooterCallback" : function(nRow, aaData, iStart,
									iEnd, aiDisplay) {
								var iTotalMarket = 0;
					            for ( var i=0 ; i<aaData.length ; i++ )
					            {
					            	var buy1=aaData[i][3];
					            	var x1 = buy1.indexOf(",");
									while(x1!=-1){
										buy1 = buy1.substring(0,x1)+buy1.substring(x1+1);
										x1 = buy1.indexOf(",");
									}
									iTotalMarket += buy1 * 1;
					            }
								var nCells = document.getElementById('total');
								nCells.innerHTML = CommaFormatted(iTotalMarket);
								var iTotalMarket = 0;
					            for ( var i=0 ; i<aaData.length ; i++ )
					            {
					            	var buy1=aaData[i][4];
									iTotalMarket += buy1 * 1;
					            }
								nCells = document.getElementById('total1');
								nCells.innerHTML = CommaFormatted(iTotalMarket);
							},
							"sDom" : "<'row'<'col-xs-4'l><'col-xs-4'f><'col-xs-4'T>r>t<'row'<'col-xs-4'C><'col-xs-4'i><'col-xs-4'p>>",
							"aoColumnDefs" : [ {
								"bVisible" : false,
								"aTargets" : [ 1 ]
							} ],
							"oColVis":{"buttonText":"Багана ",
								"bRestore": true,
								"sRestore": "Revert to original visibility"},
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
				$("#example tbody tr").click("click", function(event) {
					var position = myTable.fnGetPosition(this); // getting the clicked row position
					var id = myTable.fnGetData(position)[1]; // getting the value of the first (invisible) column 
					window.location = "showDoctorOfMonthBalance?model=" + id;

				});
				var myTable1 = $('#example1').dataTable(
						{
							"fnFooterCallback" : function(nRow, aaData, iStart,
									iEnd, aiDisplay) {
								var iTotalMarket = 0;
					            for ( var i=0 ; i<aaData.length ; i++ )
					            {
					            	var buy1=aaData[i][3];
					            	var x1 = buy1.indexOf(",");
									while(x1!=-1){
										buy1 = buy1.substring(0,x1)+buy1.substring(x1+1);
										x1 = buy1.indexOf(",");
									}
									iTotalMarket += buy1 * 1;
					            }
								var nCells = document.getElementById('total2');
								nCells.innerHTML = CommaFormatted(iTotalMarket);
								var iTotalMarket = 0;
					            for ( var i=0 ; i<aaData.length ; i++ )
					            {
					            	var buy1=aaData[i][4];
									iTotalMarket += buy1 * 1;
					            }
								nCells = document.getElementById('total3');
								nCells.innerHTML = CommaFormatted(iTotalMarket);
							},
							"sDom" : "<'row'<'col-xs-4'l><'col-xs-4'f><'col-xs-4'T>r>t<'row'<'col-xs-4'C><'col-xs-4'i><'col-xs-4'p>>",
							"aoColumnDefs" : [ {
								"bVisible" : false,
								"aTargets" : [ 1 ]
							} ],
							"oColVis":{"buttonText":"Багана ",
								"bRestore": true,
								"sRestore": "Revert to original visibility"},
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
				$("#example1 tbody tr").click("click", function(event) {
					var position = myTable1.fnGetPosition(this); // getting the clicked row position
					var id = myTable1.fnGetData(position)[1]; // getting the value of the first (invisible) column 
					window.location = "showDoctorOfMonthBalance?model=" + id;

				});
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
