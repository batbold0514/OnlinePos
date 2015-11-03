jQuery(function($) {
	initValidatorSub();
	fileUpload();
});
function editVideos(){
	$.ajax({
		url:"addVideos",
		data:$("#editTeachingAidFrom").serialize(),
		success:function(result){
			$("#videosId").html(result);
		}
	});
}
function editSound(){
	$.ajax({
		url:"addSound",
		data:$("#editTeachingAidFrom").serialize(),
		success:function(result){
			$("#soundId").html(result);
		}
	});
}
function initValidatorSub() {
	$('#editTeachingAidFrom').bootstrapValidator({
		fields : {
			aidName : {
				validators : {
					notEmpty : {
						message : 'Нэр хоосон байна'
					}
				}
			},
			aidDescription : {
				validators : {
					notEmpty : {
						message : 'Тайлбар хоосон байна'
					}
				}
			},
			

		}
	}).on('success.form.bv', function(e) {
        e.preventDefault();
        $.post('editTeachingAidAjax', $("#editTeachingAidFrom").serialize(), function(result) {
        	alert(result);
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
function fileUpload(){
	$('#editImageUpload').ajaxfileupload({
		  'action' : 'save-edit-images',
		  'onComplete' : function(response) {
				  if(response.trim() == "success")
				  {
					 $.ajax({
						 url: "new-image-list",
						 success: function(result)
							{
								 $("#imageId").html(result);
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
	$('#editTextUpload').ajaxfileupload({
		  'action' : 'save-edit-textFile',
		  'onComplete' : function(response) {
					 if(response.trim() == "success")
					  {
						 $.ajax({
							 url: "new-textFile-list",
							 success: function(result)
								{
									 $("#textId").html(result);
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
			  },
		}); 
}

