jQuery(function($) {
	pageScript();
	$(".date").datepicker({
		changeMonth : true,
		changeYear : true,
		dateFormat : "yy-mm-dd",
		defaultDate : new Date()
	});
});
function pageScript() {
	$(document).ready(
			function() {
				var context = $("#context").text().trim();
				var a = "http://" + window.location.host;
				var b = "/css/copy_csv_xls_pdf.swf";
				var c = a.concat(context);
				var n = c.concat(b);
				var myTable;
				$("#example tbody tr").click("click", function(event) {
					var position = myTable.fnGetPosition(this); 
					var id = myTable.fnGetData(position)[1];
					window.location = "showPatient?model.id=" + id;

				});
				myTable = $('#example').dataTable(
						{
							"fnFooterCallback" : function(nRow, aaData, iStart,
									iEnd, aiDisplay) {
								var iTotalMarket = 0;
					            for ( var i=0 ; i<aaData.length ; i++ )
					            {
					            	var buy1=aaData[i][9];
					            	var x1 = buy1.indexOf(",");
									while(x1!=-1){
										buy1 = buy1.substring(0,x1)+buy1.substring(x1+1);
										x1 = buy1.indexOf(",");
									}
									iTotalMarket += buy1 * 1;
					            }
								var total1 = 0;
								for ( var i = iStart; i < iEnd; i++) {
									var buy=aaData[ aiDisplay[i]][9];
									var x = buy.indexOf(",");
									while(x!=-1){
										buy = buy.substring(0,x)+buy.substring(x+1);
										x = buy.indexOf(",");
									}
									total1 += buy * 1;
								}
								var nCells = document.getElementById('total');
								nCells.innerHTML = CommaFormatted(iTotalMarket);
								
							},
							"sDom" : "<'row'<'col-xs-4'l><'col-xs-4'f><'col-xs-4'T>r>t<'row'<'col-xs-4'><'col-xs-4'i><'col-xs-4'p>>",
							"aoColumnDefs" : [ {
								"bVisible" : false,
								"aTargets" : [ 1 ]
							} ],
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
				
				$("#example tbody tr").css('cursor', 'hand');
			});
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
}