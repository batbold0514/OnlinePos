jQuery(function($) {
	pageScript();
	initValidator();
	$("#date").datepicker({
		changeMonth : true,
		changeYear : true,
		dateFormat : "yy-mm-dd",
	});
});

var id, sizes, position1,oTable1,regNumber,email,phoneNumber,operatorCode,companyName;
function initValidator(){
	$('#addform').bootstrapValidator({
        fields: {
        	operatorCode:{
        		validators: {
                    notEmpty: {
                        message: 'Оператор хоосон байна'
                    }
                }
        	}
        }
	}).on('success.form.bv', function(e) {
        e.preventDefault();
        $.post('edit-operator-ajax', $("#addform").serialize(), function(result) {
        	if (result.trim() != "") {
				errorMessage();
				$("#parseResult").html(result);
				for ( var i = 0; $(".errorMessage").length > i; i++) {
					var idName = $(".errorMessage").eq(i).attr("id");
					$('#addform').bootstrapValidator('revalidateField',idName);
				}
			} else {
				successMessage();
				$.ajax({
					url : "list-result-editOp-ajax",
					success : function(result) {
						$("#list-result").html(result);
						pageScript();
					}
				});
				$("#dialog-editOp").dialog("close");
			}
        });
    });
}

function pageScript() {
	// $("#sampletable2").DataTable();
	$("#sampletable2 th:nth-child(1), #sampletable2 td:nth-child(1)").hide();
	$(".errorMessage").parents(".form-group").addClass("has-error");
	var context = $("#context").text().trim();
	var a = "http://" + window.location.host;
	var b = "/css/copy_csv_xls_pdf.swf";
	var c = a.concat(context);
	var n = c.concat(b);
	oTable1 = $('#sampletable2')
			.dataTable(
					{
						"sDom" : "<'row'<'col-xs-4'l><'col-xs-4'f><'col-xs-4'T>r>t<'row'<'col-xs-4 customTool'><'col-xs-4'i><'col-xs-4'p>>",
						"aaSorting" : [ [ 0, "asc" ] ],
						"oLanguage": {
							"sUrl":"../localisation/dataTable.mn.txt"
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
	$("#sampletable2 tbody tr").click(function(e) {
		position1 = oTable1.fnGetPosition(this);	
		id1 = oTable1.fnGetData(position1)[0];
		regNumber = oTable1.fnGetData(position1)[1];
		companyName = oTable1.fnGetData(position1)[2];
		email = oTable1.fnGetData(position1)[4];
		phoneNumber = oTable1.fnGetData(position1)[5];
		if ($(this).hasClass('success')) {
			$(this).removeClass('success');
		} else {
			oTable1.$('tr.success').removeClass('success');
			$(this).addClass('success');
		}
	});
	$("#sampletable2 tbody tr").dblclick(function(e) {
		position1 = oTable1.fnGetPosition(this);
		var id = oTable1.fnGetData(position1)[0];
		window.location = "show-plan?model.id=" + id;
	});
	$("#btnEdit").click(function(e) {
		var anSelected = fnGetSelected(oTable1);
		if (anSelected.length !== 0) {
			var id = oTable1.fnGetData(position1)[0];
			window.location = "show-plan?model.id=" + id;	
		}
	});
	$("#btnEditOp").click(function(e) {
		var anSelected = fnGetSelected(oTable1);
		if (anSelected.length !== 0) {
			e.preventDefault();
			$("input[name='id']").val(id1);
			$("input[name='regNumber']").val(regNumber);
			$("input[name='companyName']").val(companyName);
			$("input[name='email']").val(email);
			$("input[name='phoneNumber']").val(phoneNumber);
			var $dialogContent1 = $( "#dialog-editOp" ).removeClass('hide').dialog({
				width: 450,
				modal: true,
				title: "Засварлах",
				open: function(event, ui) {  
					   $('#addform').bootstrapValidator('resetForm');
				},
				buttons: [
					{
						html: "<i class='fa fa-times bigger-110'></i>&nbsp; Болих",
						"class" : "btn btn-danger",
						click: function() {
							$( this ).dialog( "close" );
						}
					}
					,
					{
						html: "<i class='fa fa-save bigger-110'></i>&nbsp; Хадгалах",
						"class" : "btn btn-success",
						click: function() {
							$("#submitOk").trigger("click");
						}
					}
				]
			}).prev(".ui-dialog-titlebar").css("background","orange");
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