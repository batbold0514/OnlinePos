jQuery(function($) {
	pageScript();
	dialog();
	event();
	var total = 0;
	var total01 =0;
	var total02 =0
	$("#userName").val($("#userNameDiv").text());
	$("#userNameShow").val($("#userNameDiv").text());
	$("#userNameAddPhone").val($("#userNameDiv").text());
	$('.paydate').datepicker({
		changeMonth : true,
		changeYear : true,
		dateFormat : "yy-mm-dd",
	});
	var tabNum;
	var exampleNum;
	for ( var i = 0; i < $("#sizeDebt").val(); i++) {
		total02+=changeValue02(i);
		total01+=changeValue01(i);
		var urlStr = "commitmentjson?showPlanId="
				+ $("#debtID" + i).text()+"&callQuantity="+$("#callQuantity").val();
		tabNum = 'area-tab' + i;
		exampleNum = 'area-example' + i;
		var areaTab = Morris.Line({
			element : tabNum,
			xkey : 'date',
			ykeys : [ 'yvalue' ],
			labels : [ 'Үлдэгдэл' ],
			hideHover : 'auto',
			resize : true,
			xLabelFormat : function(d) {
				return d.getFullYear() + '-' + (d.getMonth() + 1) + '-'
						+ (d.getDate());
			}
		});
		var areaExample = Morris.Line({
			element : exampleNum,
			xkey : 'date',
			ykeys : [ 'yvalue' ],
			labels : [ 'Үлдэгдэл' ],
			resize : true,
			hideHover : 'auto',
			xLabelFormat : function(d) {
				return d.getFullYear() + '-' + (d.getMonth() + 1) + '-'
						+ (d.getDate());
			},
		});
		requestData(urlStr, areaTab, areaExample);
	}
	$('#sumtotal').html(numeral(total01+total02).format('0,0.00'));
	$('#subshowTotal_2').html(numeral(total02).format('0,0.00'));
	$('#subshowTotal_1').html(numeral(total01).format('0,0.00'));
	$('#showTotal').html(numeral(total01+total02).format('0,0.00'));
	$("#changeMainNumberBtn").click(function(e){
		var number = $("#mainNumberSelect").val();
		$.ajax({
			url : 'changeMainNumber',
			data : { "phoneNumber" : number },
			success : function(result) {
				successMessage();
				window.location = 'show-plan.action?model.id='+$("#planId").val();
			}
		});
	});
});
function requestData(urlStr, areaTab, areaExample) {
	$.getJSON(urlStr, function(result) {
		if(result == ""){
			areaTab.setData(null);
			areaExample.setData(null);
		}else{
			areaTab.setData(result);
			areaExample.setData(result);
		}
	});
}
var userName, role, position1, id1, oTable1, oTable2, oTable3, oTable4;
function pageScript() {
	$(".errorMessage").parents(".form-group").addClass("has-error");
	var context = $("#context").text().trim();
	var a = "http://" + window.location.host;
	var b = "/css/copy_csv_xls_pdf.swf";
	var c = a.concat(context);
	var n = c.concat(b);
	oTable1 = $('#sampletable1')
			.dataTable(
					{
						"sDom" : "<'row'<'col-xs-4'l><'col-xs-4'f><'col-xs-4'T>r>t<'row'<'col-xs-4 customTool'><'col-xs-4'i><'col-xs-4'p>>",
						"aaSorting" : [ [ 2, "desc" ] ],
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
	oTable2 = $('#sampletable2')
			.dataTable(
					{
						"sDom" : "<'row'<'col-xs-4'l><'col-xs-4'f><'col-xs-4'T>r>t<'row'<'col-xs-4 customTool'><'col-xs-4'i><'col-xs-4'p>>",
						"aaSorting" : [ [ 2, "desc" ] ],
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
	oTable3 = $('#sampletable3')
			.dataTable(
					{
						"sDom" : "<'row'<'col-xs-4'l><'col-xs-4'f><'col-xs-4'T>r>t<'row'<'col-xs-4 customTool'><'col-xs-4'i><'col-xs-4'p>>",
						"aaSorting" : [ [ 2, "desc" ] ],
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
	oTable4 = $('#sampletable4')
			.dataTable(
					{
						"sDom" : "<'row'<'col-xs-4'l><'col-xs-4'f><'col-xs-4'T>r>t<'row'<'col-xs-4 customTool'><'col-xs-4'i><'col-xs-4'p>>",
						"aaSorting" : [ [ 2, "desc" ] ],
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

}
function dialog() {
	$("#dialogCall")
			.dialog(
					{
						title : "Амлалт",
						title_html : true,
						autoOpen : false,
						modal : true,
						height : $(window).height() * 9 /10,
						width : $(window).width() * 9 / 10,
						open : function(event, ui) {
							$('#addCommitment').bootstrapValidator('resetForm');
							$(".errorMessage").parents(".form-group")
									.removeClass("has-error");
							$(".errorMessage").remove();
						},
						buttons : [								
								{
									html : "<i class='icon-check bigger-110'></i>&nbsp; Болих",
									"class" : "btn btn-danger btn-xs",
									"id" : "btnBack",
									click : function() {
										$(this).dialog("close");
									}
								} ]
					}).prev(".ui-dialog-titlebar").css("background", "green");
}
function event() {
	
	$("#btnShow").click(function(e) {
		$("#dialogCall").dialog('open');
	});
	$("#btnReject").click(function(e) {
		$.ajax({
			url:"userChangeSearchTaxpayer",
			data:{"userName": $("#userNameDiv").val(),
				"callStatusIn":"reject"},
			success : function(result) {
				window.location = 'userlogin';
				}
		});
	});
	$("#btnAnswer").click(function(e) {
		$.ajax({
			url:"userChangeSearchTaxpayer",
			data:{"userName": $("#userNameDiv").val(),
				"callStatusIn":"answer"},
			success : function(result) {
				/*$.ajax({
					url : 'search-ajax-auto',
					success : function(result) {
						if(result.trim()!=""){
						$("#parseResult").html(result);
						$("#status_id").val("");
						}else{
							$("#parseResult").html("<div class = 'row' style='text-align: center;font-size: 15px;color: red'>Хэрэглэгч бүртгэлгүй байна!!!</div>");
						}
					}
				})*/
				}
		});
	});
}

function successMessage() {
	$.gritter.add({
		title : 'тайлбар',
		text : 'Амжилттай хадгаллаа',
		sticky : false,
		time : '1000'
	});
}
function errorMessage() {
	$.gritter.add({
		title : 'тайлбар',
		text : 'Алдаа гарлаа',
		sticky : false,
		time : '1000'
	});
}
function personIdChange(){
	$("#personIdString").val($("#conPersonId").val());
}
function changeValue02(changeLoc){	
	var sum = sumOfColumns02("debt_list_"+changeLoc, 3,true);
	$("#total_2"+changeLoc).text(numeral(sum).format('0,0.00'));
	$("#showTotal_2"+changeLoc).text($("#total_2"+changeLoc).text());
	return sum
}
function changeValue01(changeLoc){	
	var sum = sumOfColumns01("debt_list_"+changeLoc, 3,true);
	$("#total_1"+changeLoc).text(numeral(sum).format('0,0.00'));
	$("#showTotal_1"+changeLoc).text($("#total_1"+changeLoc).text());
	return sum
}
function showTotalDialog(){
	$("#showTotal-dialog").removeClass('hide').dialog({
		title : "Нийт дүн задаргаа",
		title_html : true,
		autoOpen : true,
		modal : true,
		width :  $(window).width() * 9 / 10,
		buttons : [ {
			html : "&nbsp; Болих ",
			"class" : "btn btn-danger btn-xs",
			click : function() {
				$(this).dialog("close");
			}
		}
		]
	}).prev(".ui-dialog-titlebar").css("background", "blue");
}
function sumOfColumns02(tableID, columnIndex, hasHeader) {
	  var tot = 0;
	  var table = document.getElementById(tableID);
	  if(table !=null){
	  var rows = table.getElementsByTagName("tr");
      for(i = 1; i < rows.length; i++)
      {
    	  if(document.getElementById(tableID).rows[i].cells[7].innerHTML == '02'){
    		  tot += parseInt(numeral().unformat(document.getElementById(tableID).rows[i].cells[2].innerHTML));
    	  }
    	}
	  }
	  return tot;
	}
function sumOfColumns01(tableID, columnIndex, hasHeader) {
	  var tot = 0;
	  var table = document.getElementById(tableID);
	  if(table !=null){
    var rows = table.getElementsByTagName("tr");
    for(i = 1; i < rows.length; i++)
    {
  	  if(document.getElementById(tableID).rows[i].cells[7].innerHTML == '01'){
  		  tot += parseInt(numeral().unformat(document.getElementById(tableID).rows[i].cells[2].innerHTML));
  	  }
  	}
	  }
	  return tot;
	}