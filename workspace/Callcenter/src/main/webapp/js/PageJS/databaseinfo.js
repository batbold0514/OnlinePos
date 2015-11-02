jQuery(function($) {
	pageScript();
	initValidator();
	events();
	$(document).keydown(function(e) {
		if ($("#dialog-addnew").parents(".ui-dialog").is(":visible")) {
			if (e.which == 13) {
				$("#submitOk").trigger("click");
			}
		}
	});
	$('#downloadTime').clockface({
		format : 'HH:mm',
		trigger : 'manual'
	});
});
function initValidator() {
	$('#addform')
			.bootstrapValidator({
				fields : {
					url : {
						validators : {
							notEmpty : {
								message : 'Хоосон байна'
							}
						}
					},
					username : {
						validators : {
							notEmpty : {
								message : 'Хоосон байна'
							}
						}
					},
					password : {
						validators : {
							notEmpty : {
								message : 'Хоосон байна'
							}
						}
					},
					downloadTime : {
						validators : {
							notEmpty : {
								message : 'Хоосон байна'
							},
							regexp : {
								regexp : /^(\d{2}|\d{1}):\d{2}$/,
								message : 'формат буруу байна'
							}
						}
					}
				}
			})
			.on(
					'success.form.bv',
					function(e) {
						e.preventDefault();
						$
								.post(
										'save-databaseinfo-ajax',
										$("#addform").serialize(),
										function(result) {
											if (result.trim() != "") {
												errorMessage();
												$("#parseResult").html(result);
												for ( var i = 0; $(".errorMessage").length > i; i++) {
													var idName = $(
															".errorMessage")
															.eq(i).attr("id");
													$('#addform')
															.bootstrapValidator(
																	'updateMessage',
																	idName,
																	"notEmpty",
																	$(
																			"#"
																					+ idName
																					+ "From")
																			.val()
																			+ " интервалд агуулагдаж байна");
													$('#addform')
															.bootstrapValidator(
																	'resetField',
																	idName,
																	"true");
													$('#addform')
															.bootstrapValidator(
																	'revalidateField',
																	idName);
												}
											} else {
												successMessage();
												$
														.ajax({
															url : "database-result-ajax",
															success : function(
																	result) {
																$(
																		"#list-result")
																		.html(
																				result);
																pageScript();
															}
														});
												$("#dialog-addnew").dialog(
														"close");
											}
										});
					});
}
var url, username, password, dtime, position1, id1, oTable;
function pageScript() {
	$("#loadingDialog").dialog(
			{
				autoOpen: false,
				modal: true
			});
	$("#databaseInfoTable th:nth-child(1), #databaseInfoTable td:nth-child(1)")
			.hide();
	var context = $("#context").text().trim();
	var a = "http://" + window.location.host;
	var b = "/css/copy_csv_xls_pdf.swf";
	var c = a.concat(context);
	var n = c.concat(b);
	$("#databaseInfoTable tbody tr").click(function(e) {
		// position1 = oTable1.fnGetPosition(this);
		// position1 = 0;
		// id1 = oTable1.fnGetData(position1)[0];
		// url = oTable1.fnGetData(position1)[1];
		// username = oTable1.fnGetData(position1)[2]
		// password = oTable1.fnGetData(position1)[3];
		// dtime = oTable1.fnGetData(position1)[4];
		if ($(this).hasClass('success')) {
			$(this).removeClass('success');
		} else {
			oTable1.$('tr.success').removeClass('success');
			$(this).addClass('success');
		}
	});
	oTable1 = $('#databaseInfoTable')
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
function events() {
	$("#btnChange").click(function(e) {
		 Metronic.startPageLoading();
		$.ajax({
			url : 'changeIndexNow',
			success : function(result) {
				if(result.trim() == ""){
					successChangeNowMessage();
				}else{
					errorMessage();
				}
				Metronic.stopPageLoading();
			}
		});
	});
	$("#btnShow").click(function(e) {
		// var anSelected = fnGetSelected(oTable1);
		if (true) {
			e.preventDefault();
			position1 = 0;
			id1 = oTable1.fnGetData(position1)[0];
			url = oTable1.fnGetData(position1)[1];
			username = oTable1.fnGetData(position1)[2]
			password = oTable1.fnGetData(position1)[3];
			dtime = oTable1.fnGetData(position1)[4];
			$("input[name='id']").val(id1);
			$("input[name='url']").val(url);
			$("input[name='username']").val(username);
			$("input[name='password']").val(password);
			$("input[name='downloadTime']").val(dtime);
			var dialog = $("#dialog-show").removeClass('hide').dialog({
				width : 450,
				modal : true,
				title : "Show",
				open : function(event, ui) {
					$('#addform').bootstrapValidator('resetForm');
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

	$("#btnEdit")
			.click(
					function(e) {
						var anSelected = fnGetSelected(oTable1);
						if (true) {
							e.preventDefault();
							position1 = 0;
							id1 = oTable1.fnGetData(position1)[0];
							url = oTable1.fnGetData(position1)[1];
							username = oTable1.fnGetData(position1)[2]
							password = oTable1.fnGetData(position1)[3];
							dtime = oTable1.fnGetData(position1)[4];
							$("input[name='id']").val(id1);
							$("input[name='url']").val(url);
							$("input[name='username']").val(username);
							$("input[name='password']").val(password);
							$("input[name='downloadTime']").val(dtime);
							var $dialogContent1 = $("#dialog-addnew")
									.removeClass('hide')
									.dialog(
											{
												width : 450,
												modal : true,
												title : "Засварлах",
												open : function(event, ui) {
													$('#addform')
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
																var dialog = this;
																$("#submit")
																		.trigger(
																				"click");
															}
														} ]
											}).prev(".ui-dialog-titlebar").css(
											"background", "orange");
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
function successChangeNowMessage() {
	$.gritter.add({
		title : 'тайлбар',
		text : 'Амжилттай өөрчиллөө',
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
