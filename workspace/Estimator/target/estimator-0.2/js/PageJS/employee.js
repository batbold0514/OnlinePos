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
			lastName : {
				validators : {
					notEmpty : {
						message : 'талбар хоосон байна'
					}
				}
			},
			firstName : {
				validators : {
					notEmpty : {
						message : 'талбар хоосон байна'
					}
				}
			},
			phoneNumber : {
				validators : {
					notEmpty : {
						message : 'талбар хоосон байна'
					}
				}
			},
			regNumber : {
				validators : {
					notEmpty : {
						message : 'талбар хоосон байна'
					},
					regexp : {
						regexp : /[А-ЯӨҮ]{2}[0-9]{8}/,
						message : 'формат буруу байна'
					}
				}
			},
			status : {
				validators : {
					notEmpty : {
						message : 'талбар хоосон байна'
					}
				}
			},

		}
	}).on('success.form.bv', function(e) {
		e.preventDefault();
		$.post('employee-save', $("#addForm").serialize(), function(result) {
			if (result.trim() != "") {
				errorMessage();
				$('#addForm').bootstrapValidator('revalidateField', idName);
			} else {
				successMessage();
				$.ajax({
					url : "employeeList-ajax",
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
var id1, lastName, firstName, regNumber, phoneNumber, status , username, userid;
function pageScript() {
	$("#sampletable2 th:nth-child(1), #sampletable2 td:nth-child(1)").hide();
	$("#sampletable2 th:nth-child(6), #sampletable2 td:nth-child(6)").hide();
	$("#sampletable2 th:nth-child(9), #sampletable2 td:nth-child(9)").hide();
	var context = $("#context").text().trim();
	var a = "http://" + window.location.host;
	var b = "/css/copy_csv_xls_pdf.swf";
	var c = a.concat(context);
	var n = c.concat(b);
	$("#sampletable2 tbody tr").click(function(e) {
		position1 = oTable1.fnGetPosition(this);
		id1 = oTable1.fnGetData(position1)[0];
		lastName = oTable1.fnGetData(position1)[1];
		firstName = oTable1.fnGetData(position1)[2];
		phoneNumber = oTable1.fnGetData(position1)[3];
		regNumber = oTable1.fnGetData(position1)[4];
		status = oTable1.fnGetData(position1)[5];
		username = oTable1.fnGetData(position1)[7];
		userid = oTable1.fnGetData(position1)[8];
		if ($(this).hasClass('success')) {
			$(this).removeClass('success');
		} else {
			oTable1.$('tr.success').removeClass('success');
			$(this).addClass('success');
		}
		
	});
	$("#sampletable2 tbody tr").dblclick(function(e) {
		position1 = oTable1.fnGetPosition(this);
		id1 = oTable1.fnGetData(position1)[0];
		lastName = oTable1.fnGetData(position1)[1];
		firstName = oTable1.fnGetData(position1)[2];
		phoneNumber = oTable1.fnGetData(position1)[3];
		regNumber = oTable1.fnGetData(position1)[4];
		status = oTable1.fnGetData(position1)[5];
		$("input[name='id']").val(id1);
		$("input[name='lastName']").val(lastName);
		$("input[name='firstName']").val(firstName);
		$("input[name='phoneNumber']").val(code);
		$("input[name='regNumber']").val(regNumber);
		$("select[name='roleString']").val(status);
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
	oTable1 = $('#sampletable2')
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
			$("input[name='lastName']").val(lastName);
			$("input[name='firstName']").val(firstName);
			$("input[name='phoneNumber']").val(phoneNumber);
			$("input[name='regNumber']").val(regNumber);
			$("input[name='status']").val(status);
			$("input[name='user']").val(username)
			
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
		$("input[name='lastName']").val("");
		$("input[name='firstName']").val("");
		$("input[name='phoneNumber']").val("");
		$("input[name='regNumber']").val("");
		$("select[name='status']").val("");
		$("select[name='userStr']").val("");
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
						$.ajax({
							data : {'empId' : id1},
							url : 'user-list-ajax',
							success : function(result){
								$("#usersSelectList").html(result);
							}
						});
						if (anSelected.length !== 0) {
							e.preventDefault();
							$("input[name='id']").val(id1);
							$("input[name='lastName']").val(lastName);
							$("input[name='firstName']").val(firstName);
							$("input[name='phoneNumber']").val(phoneNumber);
							$("input[name='regNumber']").val(regNumber);
							$("select[name='status']").val(status);
							$("select[name='userStr']").val(userid);
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
