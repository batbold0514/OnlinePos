jQuery(function($) {
	initValidatorSub();
	fileUpload();
});
function addVideos(){
	$.ajax({
		url:"addVideos",
		data:$("#addTeachingAidFrom").serialize(),
		success:function(result){
			$("#videosId").html(result);
		}
	});
}
function addSound(){
	$.ajax({
		url:"addSound",
		data:$("#addTeachingAidFrom").serialize(),
		success:function(result){
			$("#soundId").html(result);
		}
	});
}
function initValidatorSub() {
	$('#addTeachingAidFrom').bootstrapValidator({
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
        $.post('addTeachingAidAjax', $("#addTeachingAidFrom").serialize(), function(result) {
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
	$('#imageUpload').ajaxfileupload({
		  'action' : 'save-images',
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
	$('#textUpload').ajaxfileupload({
		  'action' : 'save-textFile',
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

