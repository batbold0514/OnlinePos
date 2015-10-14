jQuery(function($) {
	$(document).keydown(function(e) {
		if ($("#dialog-addnew").parents(".ui-dialog").is(":visible")) {
			if (e.which == 13) {
				e.preventDefault();
			}
		}
	});
	pageScript();
	events();
	autoCompleteInit();
	eventsOther(); 
	fileUpload();
	initHS();
	$("#addDefectBtn").click(function(e) {
		e.preventDefault();
		addDefect();
	});
	$("#addCostBtn").click(function(e) {
		e.preventDefault();
		addCost();
	});
	/*
	 * $(".customerDialogTab").click(function(e){ $(".dselect").chosen(); });
	 */
});
function eventsOther(){
	$("#firstDate").datepicker({
		changeMonth : true,
		changeYear : true,
		dateFormat : "yy-mm-dd",
	});
	$("#secondDate").datepicker({
		changeMonth : true,
		changeYear : true,
		dateFormat : "yy-mm-dd",
	});

	$(".datePicker").datepicker({
		changeMonth : true,
		changeYear : true,
		dateFormat : "yy-mm-dd",
	});

	$(".select").chosen();
	$(".dselect").chosen({
		width: "95%"
	});
	$("#factorySearch").change(function(e) {
		$.ajax({
			data : {
				'searchCarFactory' : $("select[name='searchCarFactory']").val()
			},
			url : 'carmark-ajax',
			success : function(result) {
				$("#carmarkresult").html(result);
				$(".select").chosen();
			}
		});
	});
	$("#factorySelect").change(function(e) {
		$.ajax({
			data : {
				'factoryStr' : $("select[name='factoryStr']").val()
			},
			url : 'carmark-dialog-ajax',
			success : function(result) {
				$("#markSelect").html(result);
				$(".dselect").chosen();
			}
		});
	});
}
function fileUpload(){
	$('#defectTableSlim').slimScroll({height: '250px',size: '12px'});
	$('#costTableSlim').slimScroll({height: '250px',size: '12px'});
	$('#custImageUpload').ajaxfileupload({
		  'action' : 'images-save',
		  'onComplete' : function(response) {
			  if(response.trim() == "success")
			  {
				 $.ajax({
					 url: "new-image-list",
					 success: function(result)
						{
							 $("#imageId").html(result);
								$.gritter.add(
								{
									title: 'Амжилттай хадгаллаа',
									text: 'Зурагнуудыг амжилттай хадгаллаа!',
									class_name: 'gritter-success gritter-right',
									time : '3000'
								});   
						}
				 });
				    
			  } else{
				  $.gritter.add(
							{
								title: 'Мэдээлэл',
								text: response,
								class_name: 'gritter-error gritter-right',
								time : '3000'
							});
			  }
			}
		}); 
}
function carmarksave() {
$.post('customer-save',	$("#addForm").serialize(),	function(result) {
		if (result.trim() != "") {
			errorMessage();
			$(".errorMessage").parents(".form-group").removeClass("has-error");
			$(".errorMessage").remove();
			$("#parseResult").html(result);
			for (var i = 0; $(".errorMessage").length > i; i++) {
				var idName = $(".errorMessage").eq(i).attr("id");
				$("#"+ idName+"Result").html(
						"<div class = 'errorMessage' style='text-align: center'>"
								+ $(".errorMessage").eq(i).text()
								+ "</div>");
			}
			$(".errorMessage").parents(".form-group").addClass("has-error");
		} else {
			
			 $.ajax({
				 url: "search-customer-ajax",
				 success: function(result)
					{
						 $("#list-result").html(result);
						 successMessage();
						 $("#dialog-addnew").dialog("close");
						 pageScript();
						 events();
					}
			 });
			
		}
	});

}
function carmarkedit() {
	$.post('customer-save',	$("#editForm").serialize(),	function(result) {
		if (result.trim() != "") {
			errorMessage();
			$(".errorMessage").parents(".form-group").removeClass("has-error");
			$(".errorMessage").remove();
			$("#parseResult").html(result);
			for (var i = 0; $(".errorMessage").length > i; i++) {
				var idName = $(".errorMessage").eq(i).attr("id");
				$("#"+ idName+"Result").html(
						"<div class = 'errorMessage' style='text-align: center'>"
								+ $(".errorMessage").eq(i).text()
								+ "</div>");
			}
			$(".errorMessage").parents(".form-group").addClass("has-error");
		} else {
			 $.ajax({
				 url: "search-customer-ajax",
				 success: function(result)
					{
					successMessage();
					$("#list-result").html(result);
					 $("#dialog-edit").dialog("close");
					 pageScript();
					events();
					}
			 });
		}
	});
}
var id1, confirm, mark, factory,prtContent , WinPrint;
function pageScript() {
	
	//$("#dialog-addnew").addClass('hide'); `
	
	$("#customerTable th:nth-child(1), #customerTable td:nth-child(1)").hide();
	$("#customerTable th:nth-child(13), #customerTable td:nth-child(13)").hide();
	$("#customerTable th:nth-child(14), #customerTable td:nth-child(14)").hide();
	$("#customerTable th:nth-child(15), #customerTable td:nth-child(15)").hide();
	$("#customerTable th:nth-child(16), #customerTable td:nth-child(16)").hide();
	$("#customerTable th:nth-child(17), #customerTable td:nth-child(17)").hide();
	var context = $("#context").text().trim();
	var a = "http://" + window.location.host;
	var b = "/css/copy_csv_xls_pdf.swf";
	var c = a.concat(context);
	var n = c.concat(b);
	$("#customerTable tbody tr").click(function(e) {
		position1 = oTable1.fnGetPosition(this);
		id1 = oTable1.fnGetData(position1)[0];
		confirm = oTable1.fnGetData(position1)[3];
		if ($(this).hasClass('success')) {
			$(this).removeClass('success');
		} else {
			oTable1.$('tr.success').removeClass('success');
			$(this).addClass('success');
		}
	});
	$("#customerTable tbody tr").dblclick(function(e) {
		position1 = oTable1.fnGetPosition(this);
		id1 = oTable1.fnGetData(position1)[0];
		$("input[name='id']").val(id1);
		editajax();
			
	});
	oTable1 = $('#customerTable')
			.dataTable(
					{
						"sDom" : "<'row'<'col-xs-4'l><'col-xs-4'f><'col-xs-4'T>r>t<'row'<'col-xs-4 customTool'><'col-xs-4'i><'col-xs-4'p>>",
						"aaSorting" : [ [ 0, "desc" ] ],
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

function events() {
	
	/*$("#estMaterialId").click(function(e){
		alert('xaxa');
	});*/
	
	$("#btnSearch").click(function(e) {
		e.preventDefault();
		$.ajax({
			data : $("#searchCustomerForm").serialize(),
			url : 'search-customer-ajax',
			success : function(result) {
				$("#list-result").html(result);
				pageScript();
				events();
			}
		});
	});

	$("#btnAdd").click(function(e) {
		e.preventDefault();
		$.ajax({
			url:"emptyList",
			success:function(){
				
			}
		});
		var $dialogContent = $("#dialog-addnew").removeClass('hide').dialog({
			width : 800,
			modal : true,
			title : 'Нэмэх',
			animate : true,
			open : function(event, ui) {
				$(".errorMessage").parents(".form-group")
				.removeClass("has-error");
				$(".errorMessage").remove();
				$("#imageId").html("");
			},
			buttons : [  {
				html : "<i class='fa fa-picture-o bigger-110'></i>&nbsp; Зураг",
				"class" : "btn green",
				click : function() {
					event.preventDefault();
					$("#custImageUpload").trigger("click");
				}
			},			{
				html : "<i class='fa fa-save bigger-110'></i>&nbsp; Хадгалах",
				"class" : "btn btn-success",
				click : function() {
					carmarksave();
				}
			} ,
			{
				html : "<i class='fa fa-times bigger-110'></i>&nbsp; Болих",
				"class" : "btn btn-danger",
				click : function() {
					$(this).dialog("close");
				}
			}]
		}).prev(".ui-dialog-titlebar").css("background", "green");
	});
	$("#btnEdit").click(function(e) {
						var anSelected = fnGetSelected(oTable1);
						if (anSelected.length !== 0) {
							e.preventDefault();
							editajax();
							
						}
					}).prev(".ui-dialog-titlebar").css("background", "yellow");

	
	$("#confirmBtn").click(function(e) {
		var anSelected = fnGetSelected(oTable1);
		if (anSelected.length !== 0) {
			if(confirm != "Батлагдсан"){
				$.ajax({
					data:{"id":id1},
					url:"confirm-ajax",
					success : function(result) {
						$("#list-result").html(result);
						pageScript();
						events();
						}
				});
			}else{
				alert("Батлагдсан байна");
			}
		}else{
			alert("Мөр сонгоогүй байна");
		}
	});

}

function fnGetSelected(oTableLocal) {
	return oTableLocal.$('tr.success');
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
function autoCompleteInit(){
	$('.calculat').zeninput();
	$(".dselect").chosen({
		width: "95%"
	});
	$('#brokenPartId').selectize({
		create: true,
		sortField: {
			field: 'text',
			direction: 'asc'
		}
	});
	$("#brokenPartId").change(function(event)
	{
		if(this.value !=""){
		$.ajax({
			 data:{"brokenPartStr":this.value},
			 url:"brokenPartChange",
			 success : function(result) {
				 $("#brokenTd").html(result);
				 autoCompleteInit();
				}
		 });
		}
	});
}
function addDefect(){
	if($("#brokenPartId").val() != ""){
		$.ajax({
			data:{
				"brokenPartStr":$("#brokenPartId").val(),
				"crashGradeStr":$("#crashGradeId").val(),
				"repairPriceStr":$("#repairPriceId").val(),
				"changePriceStr":$("#changePriceId").val(),
				},
			url:"addDefect-ajax",
			 success : function(result) {
				 $("#changeDefectTable").html(result);
				 autoCompleteInit();
				}
		});
	}else{
		alert("Эвдэрсэн эд анги хоосон байна");
	}
}
function initHS()
{
	hs.graphicsDir = '../js/fileinput/graphics/';
	hs.align = 'center';
	hs.transitions = ['expand', 'crossfade'];
	hs.wrapperClassName = 'dark borderless';
	hs.fadeInOut = true;
	hs.dimmingOpacity = .75;
	
	if (hs.addSlideshow)
		hs.addSlideshow(
		{
			interval: 5000,
			repeat: false,
			useControls: true,
			fixedControls: 'fit',
			overlayOptions:
			{
				opacity: .6,
				position: 'bottom center',
				hideOnMouseOut: true
			}
		});
}
function addCost(){
	if($("#costName").val() != "" && $("#cost").val() != ""){
		$.ajax({
			data:{
				"costName":$("#costName").val(),
				"cost":$("#cost").val(),
				},
			url:"addCost-ajax",
			 success : function(result) {
				 $("#changeCostTable").html(result);
				 $('.calculat').zeninput();
				}
		});
	}else{
		alert("хоосон байна");
	}
}

function editajax(){
	 Metronic.startPageLoading();
		$.ajax({
			data :{"id":id1},
			url : 'customer-edit-ajax',
			success : function(result) {
				$("#dialog-edit").html(result);
				$('#defectTableSlimEdit').slimScroll({height: '250px',size: '12px'});
				$('#costTableSlimEdit').slimScroll({height: '250px',size: '12px'});
				$(".datePicker").datepicker({
					changeMonth : true,
					changeYear : true,
					dateFormat : "yy-mm-dd",
				});

				$(".select").chosen();
				$(".dselect").chosen({
					width: "95%"
				});
				$("#factorySelectEdit").change(function(e) {
					$.ajax({
						data : {
							'factoryStr' : $("select[name='factoryStr']").val()
						},
						url : 'carmark-dialog-ajax',
						success : function(result) {
							$("#markSelectEdit").html(result);
							$(".dselect").chosen();
						}
					});
				});	
				Metronic.stopPageLoading();
				var $dialogContent1 = $("#dialog-edit").removeClass('hide')
				.dialog({width : 800,modal : true,
							title : "Засварлах",
							open : function(event, ui) {
								$(".errorMessage").parents(".form-group")
								.removeClass("has-error");
								$(".errorMessage").remove();
							},
							buttons : [
									{
										html : "<i class='fa fa-print bigger-110'></i>&nbsp;Зураг хэвлэх",
										"class" : "btn",
										click : function() {
											WinPrint = window.open('', '', 'left=0,top=0,width=800,height=900,toolbar=0,scrollbars=0,status=0');
											$.ajax({
												url:"print-image",
												data:{"id":$("#customerId").val()},
												success: function(result){
													WinPrint.document.write(result);
													WinPrint.document.close();
													WinPrint.focus();
													WinPrint.print();
													WinPrint.close();
												}
											});
										}
									}, 
									{
										html : "<i class='fa fa-print bigger-110'></i>&nbsp; Хэвлэх",
										"class" : "btn",
										click : function() {
											WinPrint = window.open('', '', 'left=0,top=0,width=800,height=900,toolbar=0,scrollbars=0,status=0');
											$.ajax({
												url:"print-test",
												data:{"id":$("#customerId").val()},
												success: function(result){
													WinPrint.document.write(result);
													WinPrint.document.close();
													WinPrint.focus();
													WinPrint.print();
													WinPrint.close();
												}
											});
										}
									},
									
								  {
										html : "<i class='fa fa-picture-o bigger-110'></i>&nbsp; Зураг",
										"class" : "btn green",
										click : function() {
											event.preventDefault();
											$("#imageUpload").trigger("click");
										}
									},
									{
										html : "<i class='fa fa-save bigger-110'></i>&nbsp; Хадгалах",
										"class" : "btn btn-success",
										click : function() {
											carmarkedit();
										}
									},
									{
										html : "<i class='fa fa-times bigger-110'></i>&nbsp; Болих",
										"class" : "btn btn-danger",
										click : function() {
											$("#dialog-edit").dialog("close");
										}
									}
									 ]
						}).prev(".ui-dialog-titlebar").css(
						"background", "orange");
			}
		
		});
}
