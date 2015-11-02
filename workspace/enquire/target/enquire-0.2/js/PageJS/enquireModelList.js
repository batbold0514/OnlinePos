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
			enquireNumber : {
				validators : {
					notEmpty : {
						message : 'Захиалгын дугаар хоосон байна'
					}
				}
			},
			enquireNameString : {
				validators : {
					notEmpty : {
						message : 'Захиалагч хоосон байна'
					}
				}
			},
			priceStr : {
				validators : {
					notEmpty : {
						message : 'Үнэ хоосон байна'
					},
					 numeric:{
	                    	message: 'Зөвхөн тоо байна'
	                    }
				}
			},
			bankName : {
				validators : {
					notEmpty : {
						message : 'Банкын нэр хоосон байна'
					}
				}
			},
			bankNumber : {
				validators : {
					notEmpty : {
						message : 'Банкын дугаар хоосон байна'
					}
				}
			},
			enquiretypeString : {
				validators : {
					notEmpty : {
						message : 'Төрөл хоосон байна'
					}
				}
			},
			enquireNameString : {
				validators : {
					notEmpty : {
						message : 'Төрөл хоосон байна'
					}
				}
			},
		}
	}).on('success.form.bv', function(e) {
        e.preventDefault();
        $.post('save-enquireModel-ajax', $("#addForm").serialize(), function(result) {
        	if (result.trim() != "") {
				errorMessage();
				$("#parseResult").html(result);
				for ( var i = 0; $(".errorMessage").length > i; i++) {
					var idName = $(".errorMessage").eq(i).attr("id");
						$('#addForm').bootstrapValidator('revalidateField', idName);
				}
			} else {
				successMessage();
				$.ajax({
					url : "get-enquireModel-ajax",
					success : function(result) {
						$("#list-result").html(result);
						pageScript();
					}
				});
				$("#dialog-addnew").dialog("close");
			}
        });
    });
}

var id,position1,enquirename,enquirenumber ,price,bankname,banknumber,phone,createdate,enquiretype,customerstring;
function pageScript() {
	$("#enquireModel th:nth-child(1), #enquireModel td:nth-child(1)").hide();
	var context = $("#context").text().trim();
	var a = "http://" + window.location.host;
	var b = "/css/copy_csv_xls_pdf.swf";
	var c = a.concat(context);
	var n = c.concat(b);
	$("#enquireModel tbody tr").click(function(e) {
		position1 = oTable1.fnGetPosition(this);
		id = oTable1.fnGetData(position1)[0];
		enquirenumber = oTable1.fnGetData(position1)[1];
		price = oTable1.fnGetData(position1)[2];
		price = price.replace(",", "");
		bankname = oTable1.fnGetData(position1)[3];
		banknumber = oTable1.fnGetData(position1)[4];
		createdate = oTable1.fnGetData(position1)[5];
		enquiretype = oTable1.fnGetData(position1)[6];
		customerstring= oTable1.fnGetData(position1)[7];
		if ($(this).hasClass('success')) {
			$(this).removeClass('success');
		} else {
			oTable1.$('tr.success').removeClass('success');
			$(this).addClass('success');
		}
	});
	$("#enquireModel tbody tr").dblclick(function(e) {
		position1 = oTable1.fnGetPosition(this);
		id = oTable1.fnGetData(position1)[0];
		enquirenumber = oTable1.fnGetData(position1)[1];
		price = oTable1.fnGetData(position1)[2];
		bankname = oTable1.fnGetData(position1)[3];
		banknumber = oTable1.fnGetData(position1)[4];
		createdate = oTable1.fnGetData(position1)[5];
		enquiretype = oTable1.fnGetData(position1)[6];
		customerstring= oTable1.fnGetData(position1)[7];
		price = price.replace(",", "");
		$("input[name='id']").val(id);
		$("input[name='enquireNumber']").val(enquirenumber);
		$("input[name='priceStr']").val(price);
		$("input[name='bankName']").val(bankname);
		$("input[name='bankNumber']").val(banknumber);
		$("input[name='createDate']").val(createdate);
		$("select[name='enquiretypeString']").val(enquiretype);
		$("select[name='customerString']").val(customerstring);
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
	oTable1 = $('#enquireModel')
			.dataTable(
					{
						"sDom" : "<'row'<'col-xs-4'l><'col-xs-4'f><'col-xs-4'T>r>t<'row'<'col-xs-4 customTool'><'col-xs-4'i><'col-xs-4'p>>",
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
			$("input[name='id']").val(id);
			$("input[name='enquireNumber']").val(enquirenumber);
			$("input[name='priceStr']").val(price);
			$("input[name='bankName']").val(bankname);
			$("input[name='bankNumber']").val(banknumber);
			$("input[name='createDate']").val(createdate);
			$("select[name='enquiretypeString']").val(enquiretype);
			$("select[name='customerString']").val(customerstring);

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
		$("input[name='enquireNumber']").val("");
		$("input[name='priceStr']").val("");
		$("input[name='bankName']").val("");
		$("input[name='bankNumber']").val("");
		$("input[name='createDate']").val("");
		$("select[name='enquiretypeString']").val("");
		$("select[name='customerString']").val("");
		$("select[name='itemNameString']").val("");
		var $dialogContent = $("#dialog-addnew").removeClass('hide').dialog({
			width : 450,
			modal : true,
			title : 'Нэмэх',
			animate : true,
			open : function(event, ui) {
				$(".select").chosen();
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
							$("input[name='id']").val(id);
							$("input[name='enquireNumber']").val(enquirenumber);
							$("input[name='priceStr']").val(price);
							$("input[name='bankName']").val(bankname);
							$("input[name='bankNumber']").val(banknumber);
							$("input[name='createDate']").val(createdate);
							$("select[name='enquiretypeString']").val(enquiretype);
							$("select[name='customerString']").val(customerstring);
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
																$(this).dialog("close");
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
					}).prev(".ui-dialog-titlebar").css("background", "yellow");

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