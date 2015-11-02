jQuery(function($) {
	pageScript();
	initValidator();
	events();
	$(document).keydown(function(e){
		if($("#dialog-addnew").parents(".ui-dialog").is(":visible")){
			if(e.which == 13){
				$("#submitOk").trigger("click");
			}
		}
	});
});
function initValidator(){
	$('#addform').bootstrapValidator({
        fields: {
        	personDescription:{
        		validators: {
                    notEmpty: {
                      	 message: 'Хоосон байна'
                      }
                }
        	}
        }
	}).on('success.form.bv', function(e) {
        e.preventDefault();
        $.post('save-person-ajax', $("#addform").serialize(), function(result) {
        	if (result.trim() != "") {
				errorMessage();
				$("#parseResult").html(result);
				for ( var i = 0; $(".errorMessage").length > i; i++) {
					var idName = $(".errorMessage").eq(i).attr("id");
						$('#addform').bootstrapValidator('updateMessage',idName,"notEmpty",$("#"+idName+"From").val()+" интервалд агуулагдаж байна");
						$('#addform').bootstrapValidator('resetField',idName,"true");
						$('#addform').bootstrapValidator('revalidateField',idName);
				}
			} else {
				successMessage();
				$.ajax({
					url : "person-list-ajax",
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
var position1, id1, oTable,description;
function pageScript() {
	$("#peopleTable th:nth-child(1), #peopleTable td:nth-child(1)").hide();
	var context = $("#context").text().trim();
	var a = "http://" + window.location.host;
	var b = "/css/copy_csv_xls_pdf.swf";
	var c = a.concat(context);
	var n = c.concat(b);
	$("#peopleTable tbody tr").click(function(e) {
		position1 = oTable1.fnGetPosition(this);
		id1 = oTable1.fnGetData(position1)[0];
		description = oTable1.fnGetData(position1)[1];
		if ($(this).hasClass('success')) {
			$(this).removeClass('success');
		} else {
			oTable1.$('tr.success').removeClass('success');
			$(this).addClass('success');
		}
	});
	oTable1 = $('#peopleTable')
			.dataTable(
					{
						"sDom" : "<'row'<'col-xs-4'l><'col-xs-4'f><'col-xs-4'T>r>t<'row'<'col-xs-4 customTool'><'col-xs-4'i><'col-xs-4'p>>",
						"aaSorting" : [ [ 0, "desc" ] ],
						"iDisplayLength" : 25,
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
}
	function events(){
		
	$("#btnShow").click(function(e) {
		var anSelected = fnGetSelected(oTable1);
		if (anSelected.length !== 0) {
			e.preventDefault();
			$("input[name='id']").val(id1);
			$("input[name='personDescription']").val(description);
			var dialog = $( "#dialog-show" ).removeClass('hide').dialog({
				width: 450,
				modal: true,
				title: "Харах",
				open: function(event, ui) {  
					   $('#addform').bootstrapValidator('resetForm');
				},
				buttons: [ 
					{
						text: "Болих",
						"class" : "btn",
						click: function() {
							$( this ).dialog( "close" ); 
						} 
					}
				]
			}).prev(".ui-dialog-titlebar").css("background","blue");
		}
	});

	$("#btnAdd").click(function(e) {
		e.preventDefault();
		$("input[name='id']").val("");
		$("input[name='personDescription']").val("");
		var $dialogContent = $( "#dialog-addnew" ).removeClass('hide').dialog({
			width: 450,
			modal: true,
			title: 'Нэмэх',
			open: function(event, ui) {  
				   $('#addform').bootstrapValidator('resetForm');
			},
			buttons: [
				{
					html: "<i class='fa fa-times bigger-110'></i>&nbsp; Cancel",
					"class" : "btn btn-danger",
					click: function() {
						$( this ).dialog( "close" );
					}
				}
				,
				{
					html: "<i class='fa fa-save bigger-110'></i>&nbsp; Save",
					"class" : "btn btn-success",
					click: function() {
						var dialog = this;
						$("#submitOk").trigger("click");
						/*ajaxResults($dialogContent,dialog);*/
					}
				}
			]
		}).prev(".ui-dialog-titlebar").css("background","green");

	});
	$("#btnEdit").click(
			function(e) {
				var anSelected = fnGetSelected(oTable1);
				if (anSelected.length !== 0) {
					e.preventDefault();
					$("input[name='id']").val(id1);
					$("input[name='personDescription']").val(description);
					var $dialogContent1 = $( "#dialog-addnew" ).removeClass('hide').dialog({
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
									var dialog = this;
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
