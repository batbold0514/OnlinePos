jQuery(function($) {
	events();
	initValidator();
	initHS();
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
function initValidator() {
	$('#addForm').bootstrapValidator({
		fields : {
			groupName : {
				validators : {
					notEmpty : {
						message : 'Дэд бүлгийн нэр оруулна уу?'
					}
				}
			}

		}
	}).on('success.form.bv', function(e) {
        e.preventDefault();
        $.post('save-subgroup-ajax', $("#addForm").serialize(), function(result) {
        	if (result.trim() != "") {
				errorMessage();
				$("#parseResult").html(result);
				for ( var i = 0; $(".errorMessage").length > i; i++) {
					var idName = $(".errorMessage").eq(i).attr("id");
						$('#addForm').bootstrapValidator(
								'revalidateField', idName);
				}
			} else {
				window.location = "KeepingAndCredit";
			}
        });
    });

}
function removeTeachingAid(subGroupId,TeachingAid){
	Metronic.startPageLoading();
	$.ajax({
		url:"removeTeachingAid",
		data:{
			"id":subGroupId,
			"taId":TeachingAid
		},
		success:function(result){
			Metronic.stopPageLoading();
			window.location= $("#returnPackage").text().trim();
		}
	
	});
}
function editTeachingAid(TeachingAid){
	Metronic.startPageLoading();
	$.ajax({
		url:"editTeachingAid",
		data:{"id":TeachingAid},
		success : function(result){
			$("#addTeachingAid").html(result);
			var $dialogContent = $("#addTeachingAid").removeClass('hide').dialog({
				width : $( window ).width()*0.5,
				modal : true,
				title : 'Сургалтын материал нэмэх',
				animate : true,
				open : function(event, ui) {
					$('#addTeachingAidFrom').bootstrapValidator('resetForm');
					Metronic.stopPageLoading();
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
						$("#editTeachingAidFrom").submit();
					}
				},
				 {
					html : "<i class='fa fa-picture-o bigger-110'></i>&nbsp; Зураг",
					"class" : "btn green",
					click : function() {
						event.preventDefault();
						$("#editImageUpload").trigger("click");
					}
				 }
				,
				 {
					html : "<i class='fa fa-picture-o bigger-110'></i>&nbsp; Техт",
					"class" : "btn green",
					click : function() {
						event.preventDefault();
						$("#editTextUpload").trigger("click");
					}
				 }
				]
			}).prev(".ui-dialog-titlebar").css("background", "#f0ad4e");
		}
	});
}
function addTeachingAid(TeachingId){
	Metronic.startPageLoading();
	$.ajax({
		url:"showTeachingAid",
		data:{"id":TeachingId},
		success : function(result){
			$("#addTeachingAid").html(result);
			var $dialogContent = $("#addTeachingAid").removeClass('hide').dialog({
				width : $( window ).width()*0.5,
				modal : true,
				title : 'Сургалтын материал нэмэх',
				animate : true,
				open : function(event, ui) {
					$('#addTeachingAidFrom').bootstrapValidator('resetForm');
					Metronic.stopPageLoading();
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
						$("#addTeachingAidFrom").submit();
					}
				},
				 {
					html : "<i class='fa fa-picture-o bigger-110'></i>&nbsp; Зураг",
					"class" : "btn green",
					click : function() {
						event.preventDefault();
						$("#imageUpload").trigger("click");
					}
				 }
				,
				 {
					html : "<i class='fa fa-picture-o bigger-110'></i>&nbsp; Техт",
					"class" : "btn green",
					click : function() {
						event.preventDefault();
						$("#textUpload").trigger("click");
					}
				 }
				]
			}).prev(".ui-dialog-titlebar").css("background", "green");
		}
	});
}
function removeSubGroup(subGroupId){
	Metronic.startPageLoading();
	$.ajax({
		url:"removeSubGroup",
		data:{"id":subGroupId},
		success:function(result){
			Metronic.stopPageLoading();
			window.location = "KeepingAndCredit";
		}
	});
}
function editSubGroup(subGroupId){
	Metronic.startPageLoading();
	$.ajax({
		url:"editSubGroup",
		data:{"id":subGroupId},
		success:function(result){
			$("#addSubGroup").html(result);
			var $dialogContent = $("#addSubGroup").removeClass('hide').dialog({
				width : $( window ).width()*0.5,
				modal : true,
				title : 'Дэд бүлэг засах',
				animate : true,
				open : function(event, ui) {
					$('#addSubGroupFrom').bootstrapValidator('resetForm');
					Metronic.stopPageLoading();
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
						$("#addSubGroupFrom").submit();
					}
				} ]
			}).prev(".ui-dialog-titlebar").css("background", "#f0ad4e");
			
		}
	});
}
function addSubGroup(subGroupId){
	Metronic.startPageLoading();
	$.ajax({
		url:"showSubGroup",
		data:{"id":subGroupId},
		success:function(result){
			$("#addSubGroup").html(result);
			var $dialogContent = $("#addSubGroup").removeClass('hide').dialog({
				width : $( window ).width()*0.5,
				modal : true,
				title : 'Дэд бүлэг нэмэх',
				animate : true,
				open : function(event, ui) {
					$('#addSubGroupFrom').bootstrapValidator('resetForm');
					Metronic.stopPageLoading();
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
						$("#addSubGroupFrom").submit();
					}
				} ]
			}).prev(".ui-dialog-titlebar").css("background", "green");
			
		}
	});
}
function events() {

	$("#addGroup").click(function(e) {
		e.preventDefault();
		var $dialogContent = $("#dialog-addGroup").removeClass('hide').dialog({
			width : $( window ).width()*0.5,
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
