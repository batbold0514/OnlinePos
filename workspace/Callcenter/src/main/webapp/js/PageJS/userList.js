jQuery(function($) {
	pageScript();
	events();
	fileUpload();
	initHS();
	initValidator();
	$(document).keydown(function(e){
		if($("#dialog-addnew").parents(".ui-dialog").is(":visible")){
			if(e.which == 13){
				$("#submitOk").trigger("click");
			}
		}
	});
	
});

function initHS()
{
	hs.graphicsDir = '../js/fileinput/graphics/';
	hs.align = 'center';
	hs.transitions = ['expand', 'crossfade'];
	hs.wrapperClassName = 'dark borderless';
	hs.fadeInOut = true;
	hs.dimmingOpacity = .75;
	
	if (hs.addSlideshow)
		hs.addSlideshow(
		{
			interval: 5000,
			repeat: false,
			useControls: true,
			fixedControls: 'fit',
			overlayOptions:
			{
				opacity: .6,
				position: 'bottom center',
				hideOnMouseOut: true
			}
		});
}

function fileUpload(){
	$('#ImageUploadEdit').ajaxfileupload({
		  'action' : 'images-edit-save',
		  'onComplete' : function(response) {
			  if(response.trim() == "success")
			  {
				 $.ajax({
					 url: "image-list",
					 success: function(result)
						{
							 $("#imageTable tbody").html(result);
								$.gritter.add(
								{
									title: 'Амжилттай хадгаллаа',
									text: 'Зурагнуудыг амжилттай хадгаллаа!',
									class_name: 'gritter-success gritter-right',
									time : '3000'
								});   
						}
				 });
				    
			  } else{
				  $.gritter.add(
							{
								title: 'Мэдээлэл',
								text: response,
								class_name: 'gritter-error gritter-right',
								time : '3000'
							});
			  }
			}
		}); 
	$('#custImageUpload').ajaxfileupload({
		  'action' : 'images-save',
		  'onComplete' : function(response) {
			  if(response.trim() == "success")
			  {
				 $.ajax({
					 url: "image-list",
					 success: function(result)
						{
							 $("#imageTable tbody").html(result);
								$.gritter.add(
								{
									title: 'Амжилттай хадгаллаа',
									text: 'Зурагнуудыг амжилттай хадгаллаа!',
									class_name: 'gritter-success gritter-right',
									time : '3000'
								});   
						}
				 });
				    
			  } else{
				  $.gritter.add(
							{
								title: 'Мэдээлэл',
								text: response,
								class_name: 'gritter-error gritter-right',
								time : '3000'
							});
			  }
			}
		}); 
}
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
	$("#sampletable2 th:nth-child(6), #sampletable2 td:nth-child(6)").hide();
	$("#sampletable2 th:nth-child(9), #sampletable2 td:nth-child(9)").hide();
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
		seniorcode = oTable1.fnGetData(position1)[4];
		seniorid = oTable1.fnGetData(position1)[5];
		line = oTable1.fnGetData(position1)[6];
		status = oTable1.fnGetData(position1)[8];
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
		$("input[name='operatorLine']").val(line);
		$("input[name='confirmPwd']").val("");
		$("select[name='senior_id']").val(seniorid);
		$("select[name='statusString']").val(status);
		if (role == 'operator') {
			$("#seniorOpSelect").removeClass('hide');
		} else
			$("#seniorOpSelect").addClass('hide');
		var $dialogContent1 = $("#dialog-addnew").removeClass('hide').dialog({
			width : 450,
			modal : true,
			title : "Засварлах",
			open : function(event, ui) {
				 $.ajax({
					 url: "setId-image-list",
					 data:{
						id:id1 
					 },
					 success: function(result)
						{
						 	$('#addForm').bootstrapValidator('resetForm');
							$("#imageTable tbody").html(result);
						}
				 });
			},
			buttons : [ {
				html : "<i class='icon-remove bigger-110'></i>&nbsp; Болих",
				"class" : "btn btn-danger",
				click : function() {
					$(this).dialog("close");
				}
			},
			{
				html : "<i class='fa fa-picture-o bigger-110'></i>&nbsp; Зураг",
				"class" : "btn green",
				click : function() {
					event.preventDefault();
					$("#ImageUploadEdit").trigger("click");
				}
			},
			{
				html : "<i class='icon-save bigger-110'></i>&nbsp; Хадгалах",
				"class" : "btn btn-success",
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

	$("#btnShow").click(function(e) {
		var anSelected = fnGetSelected(oTable1);
		if (anSelected.length !== 0) {
			e.preventDefault();
			$("input[name='id']").val(id1);
			$("input[name='userName']").val(userName);
			$("select[name='roleString']").val(role);
			$("input[name='code']").val(code);
			$("input[name='pwd']").val("");
			$("input[name='operatorLine']").val(line);
			$("input[name='confirmPwd']").val("");
			$("select[name='statusString']").val(status);

			var dialog = $("#dialog-show").removeClass('hide').dialog({
				width : 450,
				modal : true,
				title : "Харах",
				open : function(event, ui) {
					 $.ajax({
						 url: "new-image-list",
						 data:{
							id:id1 
						 },
						 success: function(result)
							{
							 $('#addForm').bootstrapValidator('resetForm');
							 $("#imageId").html(result);
							}
					 });
					 
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
		$("input[name='operatorLine']").val("");
		$("input[name='pwd']").val("");
		$("input[name='confirmPwd']").val("");
		$("select[name='statusString']").val("");
		var $dialogContent = $("#dialog-addnew").removeClass('hide').dialog({
			width : 450,
			modal : true,
			title : 'Нэмэх',
			animate : true,
			open : function(event, ui) {
				$('#addForm').bootstrapValidator('resetForm');
				$("#imageTable tbody").html("");
			},
			buttons : [ {
				html : "<i class='fa fa-times bigger-110'></i>&nbsp; Болих",
				"class" : "btn btn-danger",
				click : function() {
					$(this).dialog("close");
				}
			
			},
			{
				html : "<i class='fa fa-picture-o bigger-110'></i>&nbsp; Зураг",
				"class" : "btn green",
				click : function() {
					event.preventDefault();
					$("#custImageUpload").trigger("click");
				}
			},
			{
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
							$("input[name='operatorLine']").val(line);
							$("select[name='senior_id']").val(seniorid);
							$("select[name='statusString']").val(status);
							if (role == 'operator') {
								$("#seniorOpSelect").removeClass('hide');
							} else
								$("#seniorOpSelect").addClass('hide');
							var $dialogContent1 = $("#dialog-addnew")
									.removeClass('hide')
									.dialog(
											{
												width : 450,
												modal : true,
												title : "Засварлах",
												open : function(event, ui) {
														 $.ajax({
															 url: "setId-image-list",
															 data:{
																id:id1 
															 },
															 success: function(result)
																{
																 $('#addForm')
																	.bootstrapValidator(
																			'resetForm');
																	 $("#imageTable tbody").html(result);
																}
														 });
														 
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
															html : "<i class='fa fa-picture-o bigger-110'></i>&nbsp; Зураг",
															"class" : "btn green",
															click : function() {
																event.preventDefault();
																$("#ImageUploadEdit").trigger("click");
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


/*
 * image start
 * */

function initTableEvents()
{
//	$("#imageTable tbody tr input:checkbox").click(function(event)
//  	{
//  		if ($(this).prop('checked'))
//  			$(this).parents("tr:eq(0)").addClass("success");
//  		else
//  			$(this).parents("tr:eq(0)").removeClass("success");
//  	});
	
	$(".set-main-image-btn").click(function(event)
			{
				event.preventDefault();
				var id = $(this).parents("tr:eq(0)").attr("data-id");
				$.ajax(
				{
					url: "set-main-image-pm",
					data:
					{
						"id": id1,
						"imageId": id
					},
					success: function(result)
					{
						$("#imageTable tbody").html(result);
						$.gritter.add(
							{
								title: 'Мэдээлэл',
								text: 'Нүүр зураг амжилттай солигдлоо!',
								class_name: 'gritter-info gritter-right',
								time : '4000'
							});
					},
				});
			});
	$(".delete-image-btn").click(function(event)
	{
		event.preventDefault();
		var id = $(this).parents("tr:eq(0)").attr("data-id");
		var ids = [];
		ids[0] = id;
		$.ajax(
		{
			url: "delete-pm-images",
			data:
			{
				"id": id1,
				"imageIds": ids
			},
			success: function(result)
			{
				$("#imageTable tbody tr[data-id='" + id + "']").remove();
				$.gritter.add(
				{
					title: 'Мэдээлэл',
					text: 'Зургийг амжилттай устгалаа!',
					class_name: 'gritter-info gritter-right',
					time : '4000'
				});
			}
		});
	});
}



function initEvents()
{
	
	$('#imageTable thead th input:checkbox').on('click' , function()
	{
		var that = this;
		$(this).closest('table').find('tr > td:first-child input:checkbox').each(function()
		{
			this.checked = that.checked;
			if ($(this).prop('checked'))
				$(this).parents("tr:eq(0)").addClass("success");
			else
				$(this).parents("tr:eq(0)").removeClass("success");
		});
	});
	
	$("#deleteImagesBtn").click(function(event)
	{
		event.preventDefault();
		if ($("#imageTable tbody tr.success").length > 0)
		{
			var ids = [];
			for (var i = 0; i < $("#imageTable tbody tr.success").length; i++)
			{
				ids[i] = $("#imageTable tbody tr.success").eq(i).attr("data-id");
			}
			
			$.ajax(
			{
				url: "delete-pm-images",
				data:
				{
					"id": id1,
					"imageIds": ids
				},
				success: function(result)
				{
					$("#imageTable tbody tr.success").remove();
					$.gritter.add(
					{
						title: 'Мэдээлэл',
						text: 'Зурагнуудыг амжилттай устгалаа!',
						class_name: 'gritter-info gritter-right',
						time : '3000'
					});
				}
			});
		}
		else
		{
			$.gritter.add(
			{
				title: 'Анхааруулга',
				text: 'Та ямар нэгэн зураг сонгоогүй байна.<br/>Устгах зурагнуудаа сонгоно уу!',
				class_name: 'gritter-warning gritter-center',
				time : '3000'
			});
		}
	});
	
}

