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
        	typeName:{
        		validators: {
                    notEmpty: {
                        message: 'Нэр хоосон байна'
                    }
                }
        	},
        	typeNumber:{
        		validators: {
                    notEmpty: {
                    	 message: 'Хоосон байна'
                    },
        			numeric: {
                        message: 'Тоо оруулна уу'
                    }
                }
        	},
        	description:{
        		validators: {
                    notEmpty: {
                    	 message: 'Хоосон байна'
                    }
                }
        	},
        	debtTypeIndex:{
        		validators: {
        			 notEmpty: {
        				 message: 'Хоосон байна'
                     },
        			numeric: {
                        message: 'Тоо оруулна уу'
                    }
                }
        	}
        }
	}).on('success.form.bv', function(e) {
        e.preventDefault();
        $.post('save-debtType-ajax', $("#addform").serialize(), function(result) {
        	if (result.trim() != "") {
				errorMessage();
				$("#parseResult").html(result);
				for ( var i = 0; $(".errorMessage").length > i; i++) {
					var idName = $(".errorMessage").eq(i).attr("id");
					if($(".errorMessage").eq(i).text().trim() === 'Unique'){
						$("input[name='typeName']").val("");
						$('#addform').bootstrapValidator('revalidateField',idName);
						$('#addform').bootstrapValidator('updateMessage',"typeName", 'notEmpty',"Ижил өрийн нэр байна");
					}else{
						$('#addform').bootstrapValidator('revalidateField',idName);
					}
				
				}
			} else {
				successMessage();
				$.ajax({
					url : "debtTypes-result-ajax",
					success : function(result) {
						$("#list-result").html(result);
						pageScript();
					}
				});
				$("#dialog-addnew" ).dialog("close");
			}
        });
    });
        
	$("#typeName2").keydown(function(event){
		$('#addform').bootstrapValidator('updateMessage',"typeName", 'notEmpty',"Нэр хоосон байна");
	});
}
var typeName, typeNumber,description, position1, id1, oTable,debtTypeIndex,status,statusDescription;
function pageScript() {
	$("#debtTypeTable th:nth-child(1), #debtTypeTable td:nth-child(1)").hide();
	$("#debtTypeTable th:nth-child(7), #debtTypeTable td:nth-child(7)").hide();
	var context = $("#context").text().trim();
	var a = "http://" + window.location.host;
	var b = "/css/copy_csv_xls_pdf.swf";
	var c = a.concat(context);
	var n = c.concat(b);
	$("#debtTypeTable tbody tr").click(function(e) {
		position1 = oTable1.fnGetPosition(this);
		id1 = oTable1.fnGetData(position1)[0];
		typeName = oTable1.fnGetData(position1)[1];
		typeNumber = oTable1.fnGetData(position1)[3]
		description = oTable1.fnGetData(position1)[2];
		debtTypeIndex = oTable1.fnGetData(position1)[4];
		statusDescription = oTable1.fnGetData(position1)[5];
		status = oTable1.fnGetData(position1)[6];
		
		if ($(this).hasClass('success')) {
			$(this).removeClass('success');
		} else {
			oTable1.$('tr.success').removeClass('success');
			$(this).addClass('success');
		}
	});
	oTable1 = $('#debtTypeTable')
			.dataTable(
					{
						"sDom" : "<'row'<'col-xs-4'l><'col-xs-4'f><'col-xs-4'T>r>t<'row'<'col-xs-4 customTool'><'col-xs-4'i><'col-xs-4'p>>",
						"aaSorting" : [ [ 2, "desc" ] ],
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
			$("input[name='typeName']").val(typeName);
			$("input[name='typeNumber']").val(typeNumber);
			$("input[name='description']").val(description);
			$("input[name='debtTypeIndex']").val(debtTypeIndex);
			$("input[name='status']").val(statusDescription);
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
		$("input[name='typeName']").val("");
		$("input[name='typeNumber']").val("");
		$("input[name='description']").val("");
		$("input[name='debtTypeIndex']").val("");
		$("select[name='statusString']").val("0");
		var $dialogContent = $( "#dialog-addnew" ).removeClass('hide').dialog({
			width: 450,
			modal: true,
			title: 'Нэмэх',
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
		}).prev(".ui-dialog-titlebar").css("background","green");

	});
	$("#btnEdit").click(
			function(e) {
				var anSelected = fnGetSelected(oTable1);
				if (anSelected.length !== 0) {
					e.preventDefault();
					$("input[name='id']").val(id1);
					$("input[name='typeName']").val(typeName);
					$("input[name='typeNumber']").val(typeNumber);
					$("input[name='description']").val(description);
					$("input[name='debtTypeIndex']").val(debtTypeIndex);
					$("select[name='statusString']").val(status);
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

