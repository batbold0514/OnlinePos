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
	$(".dateselect").datepicker({
		changeMonth : true,
		changeYear : true,
		dateFormat : "yy-mm-dd",
	});
	$(".select").chosen();
});
function initValidator() {
	$('#addForm').bootstrapValidator({
		fields : {
			dateStr : {
				validators : {
					notEmpty : {
						message : 'Талбар хоосон байна'
					}
				}
			},
			vinNumber : {
				validators : {
					notEmpty : {
						message : 'Талбар хоосон байна'
					}
				}
			},
			importedDate : {
				validators : {
					notEmpty : {
						message : 'Талбар хоосон байна'
					},
					numeric : {
						message : 'Зөвхөн тоо байна'
					}
				}
			},
			factoryDate : {
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
        $.post('save-car-price', $("#addForm").serialize(), function(result) {
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
					url : "car-price-list",
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
var id1,date,idate,fdate,vin,factory,mark,price,emp,desc
function pageScript() {
	$("#carPricetable th:nth-child(1), #carPricetable td:nth-child(1)").hide();
	$("#carPricetable th:nth-child(11), #carPricetable td:nth-child(11)").hide();
	$("#carPricetable th:nth-child(12), #carPricetable td:nth-child(12)").hide();
	$("#carPricetable th:nth-child(13), #carPricetable td:nth-child(13)").hide();
	var context = $("#context").text().trim();
	var a = "http://" + window.location.host;
	var b = "/css/copy_csv_xls_pdf.swf";
	var c = a.concat(context);
	var n = c.concat(b);
	$("#carPricetable tbody tr").click(function(e) {
		position1 = oTable1.fnGetPosition(this);
		id1 = oTable1.fnGetData(position1)[0];
		date = oTable1.fnGetData(position1)[1];
		idate = oTable1.fnGetData(position1)[5];
		fdate = oTable1.fnGetData(position1)[4];
		vin = oTable1.fnGetData(position1)[6];
		factory = oTable1.fnGetData(position1)[10];
		mark = oTable1.fnGetData(position1)[11];
		price = oTable1.fnGetData(position1)[7];
		emp = oTable1.fnGetData(position1)[12];
		desc = oTable1.fnGetData(position1)[9];
		if ($(this).hasClass('success')) {
			$(this).removeClass('success');
		} else {
			oTable1.$('tr.success').removeClass('success');
			$(this).addClass('success');
		}
	});
	$("#carPricetable tbody tr").dblclick(function(e) {
		position1 = oTable1.fnGetPosition(this);
		id1 = oTable1.fnGetData(position1)[0];
		date = oTable1.fnGetData(position1)[1];
		idate = oTable1.fnGetData(position1)[5];
		fdate = oTable1.fnGetData(position1)[4];
		vin = oTable1.fnGetData(position1)[6];
		factory = oTable1.fnGetData(position1)[10];
		mark = oTable1.fnGetData(position1)[11];
		price = oTable1.fnGetData(position1)[7];
		emp = oTable1.fnGetData(position1)[12];
		desc = oTable1.fnGetData(position1)[9];
		$("input[name='id']").val(id1);
		$("input[name='dateStr']").val(date);
		$("select[name='factoryStr']").val(factory);
		$("select[name='markStr']").val(mark);
		$("input[name='factoryDate']").val(fdate);
		$("input[name='importedDate']").val(idate);
		$("input[name='vinNumber']").val(vin);
		$("input[name='price']").val(price);
		$("select[name='empStr']").val(emp);
		$("input[name='description']").val(desc);
		
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
	oTable1 = $('#carPricetable')
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

	$("#factory").change(function(e){
		$.ajax({
			url : 'car-price-mark',
			data : { 'factorySearch' : $("#factory").val() },
			success : function(result){
				$("#markResult").html(result);
				$(".select").chosen();
			}
		});
	});
	
	$("#factoryDId").change(function(e){
		$.ajax({
			url : 'car-price-dialog-mark',
			data : {'factoryStr' : $("#factoryDId").val()},
			success : function(result){
				$("#carmarkdialog").html(result)
				$(".select").chosen();
			}
		});
	});
	
	$("#btnSearch").click(function(e){
//		e.priventDefault();
		$.ajax({
			url : 'search-carprice',
			data : $("#searchCarPriceForm").serialize(),
			success : function(result){
				$("#list-result").html(result);
				pageScript();
			}
		})
	});
	
	$("#btnShow").click(function(e) {
		var anSelected = fnGetSelected(oTable1);
		if (anSelected.length !== 0) {
			e.preventDefault();
			$("input[name='id']").val(id1);
			$("input[name='dateStr']").val(date);
			$("input[name='factoryStr']").val(factory);
			$("input[name='markStr']").val(mark);
			$("input[name='factoryDate']").val(fdate);
			$("input[name='importedDate']").val(idate);
			$("input[name='vinNumber']").val(vin);
			$("input[name='price']").val(price);
			$("input[name='empStr']").val(emp);
			$("input[name='description']").val(desc);

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
//		$("input[name='dateStr']").val("");
		$("select[name='factoryStr']").val("");
		$("select[name='markStr']").val("");
		$("input[name='factoryDate']").val("");
		$("input[name='importedDate']").val("");
		$("input[name='vinNumber']").val("");
		$("input[name='price']").val("");
		$("select[name='empStr']").val("");
		$("input[name='description']").val("");
		var $dialogContent = $("#dialog-addnew").removeClass('hide').dialog({
			width : 450,
			modal : true,
			title : 'Нэмэх',
			animate : true,
			open : function(event, ui) {
				$('#addForm').bootstrapValidator('resetForm');
				$(".dselect").chosen();
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
							$("input[name='dateStr']").val(date);
							$("select[name='factoryStr']").val(factory);
							$("select[name='markStr']").val(mark);
							$("input[name='factoryDate']").val(fdate);
							$("input[name='importedDate']").val(idate);
							$("input[name='vinNumber']").val(vin);
							$("input[name='price']").val(price);
							$("select[name='empStr']").val(emp);
							$("input[name='description']").val(desc);
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
