jQuery(function($) {
	pageScript();
	events();
	initValidator();
	$(document).keydown(function(e) {
		if ($("#dialog-addnew").parents(".ui-dialog").is(":visible")) {
			if (e.which == 13) {
				$("#submitOk").trigger("click");
			}
		}
	});
});
function initValidator() {
	$('#addForm').bootstrapValidator({
		fields : {
			info : {
				validators : {
					notEmpty : {
						message : 'талбар хоосон байна'
					}
				}
			}
		}
	}).on('success.form.bv', function(e) {
		e.preventDefault();
		$.post('info-board-save', $("#addForm").serialize(), function(result) {
			if (result.trim() != "") {
				errorMessage();
				$('#addForm').bootstrapValidator('revalidateField', idName);
			} else {
				successMessage();
				$.ajax({
					url : "info-board-list",
					success : function(result) {
						$("#list-result").html(result);
						pageScript();
						events();
					}
				});
				$("#dialog-addnew").dialog("close");
			}
		});
	});

}
var id1, info, user, date, oTable1;
function pageScript() {
	$("#infoBoardTable th:nth-child(1), #infoBoardTable td:nth-child(1)").hide();
	var context = $("#context").text().trim();
	var a = "http://" + window.location.host;
	var b = "/css/copy_csv_xls_pdf.swf";
	var c = a.concat(context);
	var n = c.concat(b);
	$("#infoBoardTable tbody tr").click(function(e) {
		position1 = oTable1.fnGetPosition(this);
		id1 = oTable1.fnGetData(position1)[0];
		date = oTable1.fnGetData(position1)[1];
		info = oTable1.fnGetData(position1)[2];
		user = oTable1.fnGetData(position1)[3];
		if ($(this).hasClass('success')) {
			$(this).removeClass('success');
		} else {
			oTable1.$('tr.success').removeClass('success');
			$(this).addClass('success');
		}
		
		var string = "Огноо" + " : " + date + " \nМэдээлэл : " + info +" \nОруулсан : " +user ;
		$("#infoTextArea").val(string);
		
	});
	$("#infoBoardTable tbody tr").dblclick(function(e) {
		position1 = oTable1.fnGetPosition(this);
		id1 = oTable1.fnGetData(position1)[0];
		date = oTable1.fnGetData(position1)[1];
		info = oTable1.fnGetData(position1)[2];
		user = oTable1.fnGetData(position1)[3];
		$("input[name='id']").val(id1);
	// $("input[name='date']").val(date);
		$("textarea[name='info']").val(info);
	// $("input[name='user']").val(user);
		var $dialogContent1 = $("#dialog-addnew").removeClass('hide').dialog({
			width : 450,
			modal : true,
			title : "Засварлах",
			buttons : [ {
				html : "<i class='icon-remove bigger-110'></i>&nbsp; Болих",
				"class" : "btn btn-danger btn-xs",
				click : function() {
					$(this).dialog("close");
				}
			}, {
				html : "<i class='icon-save bigger-110'></i>&nbsp; Хадгалах",
				"class" : "btn btn-success btn-xs",
				click : function() {
					$("#submitOk").trigger("click");
				}
			} ]
		});
	});
	oTable1 = $('#infoBoardTable')
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

	$("#btnShow").click(function(e) {
		var anSelected = fnGetSelected(oTable1);
		if (anSelected.length !== 0) {
			e.preventDefault();
			$("input[name='id']").val(id1);
			$("input[name='dateStr']").val(date);
			$("input[name='info']").val(info);
			$("input[name='user']").val(user);

			var dialog = $("#dialog-show").removeClass('hide').dialog({
				width : 450,
				modal : true,
				title : "Харах",
				open : function(event, ui) {
					$('#addForm').bootstrapValidator('resetForm');
				},
				buttons : [ {
					text : "Болих",
					"class" : "btn",
					click : function() {
						$(this).dialog("close");
					}
				} ]
			}).prev(".ui-dialog-titlebar").css("background", "blue");
		}
	});
	$("#btnAdd").click(function(e) {
		e.preventDefault();
		$("input[name='id']").val("");
		$("textarea[name='info']").val("");
		var $dialogContent = $("#dialog-addnew").removeClass('hide').dialog({
			width : 450,
			modal : true,
			title : 'Нэмэх',
			animate : true,
			open : function(event, ui) {
				$('#addForm').bootstrapValidator('resetForm');
			},
			buttons : [ {
				html : "<i class='fa fa-times bigger-110'></i>&nbsp; Болих",
				"class" : "btn btn-danger",
				click : function() {
					$(this).dialog("close");
				}
			}, {
				html : "<i class='fa fa-save bigger-110'></i>&nbsp; Хадгалах",
				"class" : "btn btn-success",
				click : function() {
					$("#submitOk").trigger("click");
				}
			} ]
		}).prev(".ui-dialog-titlebar").css("background", "green");
	});
	$("#btnEdit")
			.click(
					function(e) {
						var anSelected = fnGetSelected(oTable1);
						if (anSelected.length !== 0) {
							e.preventDefault();
							$("input[name='id']").val(id1);
							$("textarea[name='info']").val(info);
							var $dialogContent1 = $("#dialog-addnew")
									.removeClass('hide')
									.dialog(
											{
												width : 450,
												modal : true,
												title : "Засварлах",
												open : function(event, ui) {
													$('#addForm')
															.bootstrapValidator(
																	'resetForm');
												},
												buttons : [
														{
															html : "<i class='fa fa-times bigger-110'></i>&nbsp; Болих",
															"class" : "btn btn-danger",
															click : function() {
																$(this)
																		.dialog(
																				"close");
															}
														},
														{
															html : "<i class='fa fa-save bigger-110'></i>&nbsp; Хадгалах",
															"class" : "btn btn-success",
															click : function() {
																$("#submitOk")
																		.trigger(
																				"click");
															}
														} ]
											}).prev(".ui-dialog-titlebar").css(
											"background", "orange");
						}
					}).prev(".ui-dialog-titlebar").css("background", "yellow");
	
	$("#btnDelete").click(function(e){
		var anSelected = fnGetSelected(oTable1);
		$.ajax({
			data : {'idstr' : id1},
			url : 'delete-infoboard',
			success : function(result) {
				$("#list-result").html(result);
				pageScript();
				events();
			}
		});
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
