jQuery(function($) {
	pageScript();
	events();
	initValidator();
	$(document).keydown(function(e){
		if($("#dialog-addnew").parents(".ui-dialog").is(":visible")){
			if(e.which == 13){
				$("#submitOk").trigger("click");
			}
		}
	});
});
function initValidator() {
	$('#addForm').bootstrapValidator({
		fields : {
			compName : {
				validators : {
					notEmpty : {
						message : 'Талбар хоосон байна'
					}
				}
			},
			address : {
				validators : {
					notEmpty : {
						message : 'Талбар хоосон байна'
					}
				}
			},
			phoneNumber : {
				validators : {
					notEmpty : {
						message : 'Талбар хоосон байна'
					},
					numeric : {
						message : 'Зөвхөн тоо байна'
					}
				}
			}
		}
	}).on('success.form.bv', function(e) {
        e.preventDefault();
        $.post('save-company', $("#addForm").serialize(), function(result) {
        	if (result.trim() != "") {
				errorMessage();
				$("#parseResult").html(result);
				for ( var i = 0; $(".errorMessage").length > i; i++) {
					var idName = $(".errorMessage").eq(i).attr("id");
					if ($(".errorMessage").eq(i).text().trim() === 'Unique') {
						$('#addForm').bootstrapValidator(
								'revalidateField', idName);
						$("input[name='userName']").val("");
						$('#addForm').bootstrapValidator(
								'updateMessage', "userName",
								'notEmpty', "Ижил өрийн нэр байна");
					} else {
						$('#addForm').bootstrapValidator(
								'revalidateField', idName);
					}
				}
			} else {
				successMessage();
				$.ajax({
					url : "company-list-ajax",
					success : function(result) {
						$("#list-result").html(result);
						pageScript();
						events();
					}
				});
				$("#dialog-addnew").dialog("close");
			}
        });
    });;
}
var id1,name,address,phone
function pageScript() {
	$("#regSearchTbl th:nth-child(1), #regSearchTbl td:nth-child(1)").hide();
	var context = $("#context").text().trim();
	var a = "http://" + window.location.host;
	var b = "/css/copy_csv_xls_pdf.swf";
	var c = a.concat(context);
	var n = c.concat(b);

	$("#regSearchTbl tbody tr").click(function(e) {
		position1 = oTable1.fnGetPosition(this);
		id1 = oTable1.fnGetData(position1)[0];
		name = oTable1.fnGetData(position1)[1];
		address = oTable1.fnGetData(position1)[2];
		phone = oTable1.fnGetData(position1)[3];
		if ($(this).hasClass('success')) {
			$(this).removeClass('success');
		} else {
			oTable1.$('tr.success').removeClass('success');
			$(this).addClass('success');
		}
	});
	
	$("#regSearchTbl tbody tr").dblclick(function(e) {
		position1 = oTable1.fnGetPosition(this);
		id1 = oTable1.fnGetData(position1)[0];
		name = oTable1.fnGetData(position1)[1];
		address = oTable1.fnGetData(position1)[2];
		phone = oTable1.fnGetData(position1)[3];
/*		$("input[name='id']").val(id1);
		$("input[name='compName']").val(name);
		$("input[name='address']").val(address);
		$("input[name='phoneNumber']").val(phone);
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
*/	});
	oTable1 = $('#regSearchTbl')
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
	$("#print").click(function(e){
		e.preventDefault();
		var anSelected = fnGetSelected(oTable1);
		if (anSelected.length !== 0) {
			WinPrint = window.open('', '', 'left=0,top=0,width=800,height=900,toolbar=0,scrollbars=0,status=0');
			$.ajax({
				url:"print-test",
				data:{"id":id1},
				success: function(result){
					WinPrint.document.write(result);
//					WinPrint.document.close();
//					WinPrint.focus();
//					WinPrint.print();
//					WinPrint.close();
				}
			});
		}
	});
	/*$("#btnShow").click(function(e) {
		var anSelected = fnGetSelected(oTable1);
		if (anSelected.length !== 0) {
			e.preventDefault();
			$("input[name='id']").val(id1);
			$("input[name='compName']").val(name);
			$("input[name='address']").val(address);
			$("input[name='phoneNumber']").val(phone);

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
				}]
			}).prev(".ui-dialog-titlebar").css("background", "blue");
		}
	});
	$("#btnAdd").click(function(e) {
		e.preventDefault();
		$("input[name='id']").val("");
		$("input[name='compName']").val("");
		$("input[name='address']").val("");
		$("input[name='phoneNumber']").val("");
		var $dialogContent = $("#dialog-addnew").removeClass('hide').dialog({
			width : 450,
			modal : true,
			title : 'Нэмэх',
			animate : true,
			open : function(event, ui) {
				$('#addForm').bootstrapValidator('resetForm');
				$("#factoryId").chosen();
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
							$("input[name='compName']").val(name);
							$("input[name='address']").val(address);
							$("input[name='phoneNumber']").val(phone);
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
																$("#submitOk").trigger("click");
															}
														} ]
											}).prev(".ui-dialog-titlebar").css(
											"background", "orange");
						}
					}).prev(".ui-dialog-titlebar").css("background", "yellow");*/

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
