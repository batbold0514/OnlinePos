jQuery(function($) {
	pageScript();
	events();
	$(document).keydown(function(e){
		if($("#dialog-addnew").parents(".ui-dialog").is(":visible")){
			if(e.which == 13){
				$("#submitOk").trigger("click");
			}
		}
	});
});

var userName, role, position1, id1, oTable1, code, seniorcode, seciorid,line,status;
function pageScript() {
	$("#sampletable2 th:nth-child(1), #sampletable2 td:nth-child(1)").hide();
	var context = $("#context").text().trim();
	var a = "http://" + window.location.host;
	var b = "/css/copy_csv_xls_pdf.swf";
	var c = a.concat(context);
	var n = c.concat(b);
	$("#sampletable2 tbody tr").click(function(e) {
		position1 = oTable1.fnGetPosition(this);
		userName = oTable1.fnGetData(position1)[0];
		id1 = oTable1.fnGetData(position1)[2];
		role = oTable1.fnGetData(position1)[1];
		code = oTable1.fnGetData(position1)[3];
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
		$("input[name='id']").val(id1);
		
		window.location.assign("showProject?id="+id1);
	});
	oTable1 = $('#sampletable2')
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
	$("#roleStringAdd").change(function() {
		var role = $("#roleStringAdd").val();
		if (role == 'operator')
			$("#seniorOpSelect").removeClass('hide');
		else
			$("#seniorOpSelect").addClass('hide');

	});
}


function events() {

	$("#btnShow").click(function(e) {
		var anSelected = fnGetSelected(oTable1);
		if (anSelected.length !== 0) {
			e.preventDefault();
			$("input[name='id']").val(id1);
			$("input[name='userName']").val(userName);
			$("select[name='roleString']").val(role);
			$("input[name='code']").val(code);
			$("input[name='pwd']").val("");

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
		$("input[name='userName']").val("");
		$("select[name='roleString']").val("");
		$("input[name='code']").val("");
		$("input[name='pwd']").val("");
		$("input[name='confirmPwd']").val("");
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
							$("input[name='userName']").val(userName);
							$("select[name='roleString']").val(role);
							$("input[name='code']").val(code);
							$("input[name='pwd']").val("");
							$("input[name='confirmPwd']").val("");
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
