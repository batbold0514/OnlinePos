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
	
	$(".select").chosen();
	$(".date").datepicker({
		changeMonth : true,
		changeYear : true,
		dateFormat : "yy-mm-dd",
	});
	
});
function initValidator() {
	$('#addForm').bootstrapValidator({
		fields : {
			userName : {
				validators : {
					notEmpty : {
						message : 'Хэрэглэгчийн хоосон байна'
					}
				}
			},
			code : {
				validators : {
					notEmpty : {
						message : 'Код хоосон байна'
					}
				}
			},
			roleString : {
				validators : {
					notEmpty : {
						message : 'Хэрэглэгчийн эрх хоосон байна'
					}
				}
			},
			pwd : {
				validators : {
					identical : {
						field : 'confirmPwd',
						message : 'Нууц үг буруу байна'
					},
					notEmpty : {
						message : 'Нууц үг хоосон байна'
					}
				}
			},
			confirmPwd : {
				validators : {
					identical : {
						field : 'pwd',
						message : 'Нууц үг буруу байна'
					},
					notEmpty : {
						message : 'Нууц үг хоосон байна'
					}
				}
			},

		}
	}).on('success.form.bv', function(e) {
        e.preventDefault();
        $.post('save-user-ajax', $("#addForm").serialize(), function(result) {
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
					url : "get-userList-ajax",
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

	$("#userNameAdd").keydown(
			function(event) {
				$('#addForm').bootstrapValidator('updateMessage', "userName",
						'notEmpty', "Нэр хоосон байна");
			});
}
var userName, role, position1, id1, oTable1, code, seniorcode, seciorid,line,status;
function pageScript() {
	$("#sampletable2 th:nth-child(3), #sampletable2 td:nth-child(3)").hide();
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
		userName = oTable1.fnGetData(position1)[0];
		id1 = oTable1.fnGetData(position1)[2];
		role = oTable1.fnGetData(position1)[1];
		$("input[name='id']").val(id1);
		$("input[name='userName']").val(userName);
		$("select[name='roleString']").val(role);
		$("input[name='code']").val(code);
		$("input[name='pwd']").val("");
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
	
	$("#addBtn").click(function(e){
		var dialog = $("#dialog-task").removeClass('hide').dialog({
			width : 450,
			modal : true,
			title : 'Add task',
			open : function(event, ui) {
				$(".dselect").chosen();
			},
			buttons : [{
				text : 'cancel',
				click : function(){
					$(this).dialog("close");
				}
			},{
				text : 'add',
				click : function(){
					$(this).dialog("close");
				}
			}]
		});
	});
	
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
