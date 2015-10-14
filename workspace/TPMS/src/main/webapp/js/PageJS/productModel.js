jQuery(function($) {
		var errorVal = true;
		var myRules = new Array();
		var validationObject;
		var $validation = false;
		$('#id-input-file-3').ace_file_input({
			style: 'well',
			btn_choose: 'Зурагнуудаа энд зөөж эсвэл энд дарж сонгоно уу!',
			btn_change: null,
			no_icon: 'icon-picture',
			droppable: true,
			thumbnail: 'small',
			before_change: function(files, dropped)
			{
				var allowed_files = [];
				for(var i = 0 ; i < files.length; i++)
				{
					var file = files[i];
					if (typeof file === "string")
					{
						//IE8 and browsers that don't support File Object
						if(! (/\.(jpe?g|png|gif|bmp)$/i).test(file) ) return false;
					}
					else
					{
						var type = $.trim(file.type);
						if ((type.length > 0 && ! (/^image\/(jpe?g|png|gif|bmp)$/i).test(type)) || (type.length == 0 && ! (/\.(jpe?g|png|gif|bmp)$/i).test(file.name)))
							continue;//not an image so don't keep this file
					}
					allowed_files.push(file);
				}
				if (allowed_files.length == 0)
					return false;
				return allowed_files;
			},
			preview_error : function(filename, error_code)
			{
				//name of the file that failed
				//error_code values
				//1 = 'FILE_LOAD_FAILED',
				//2 = 'IMAGE_LOAD_FAILED',
				//3 = 'THUMBNAIL_FAILED'
				//alert(error_code);
			}
		}).on('change', function()
		{
			//console.log($(this).data('ace_input_files'));
			//console.log($(this).data('ace_input_method'));
		});
		$(".chosen-select").chosen();
		$('#fuelux-wizard')
				.ace_wizard()
				.on(
						'change',
						function(e, info) {
							if (info.step == 2) {
								errorVal = true;
								return true;
							}
							if (errorVal == false) {
								return true;
							}
							if (info.step == 1) {
								if (!$('#addForm').valid())
									return false;
								var formData = new FormData($("#addForm")[0]);
								$
										.ajax({
											url : "save-productModel-ajax",
											data : formData,
											type: "POST",
									  		processData: false,
									  		contentType: false,
											success : function(result) {
												if (result.trim() != "") {
													$(".errorMessage").parents(".form-group").removeClass("has-error");
													$(".errorMessage").remove();
													$().toastmessage(
															'showErrorToast',
															"Алдаа гарлаа!");
													$("#parseResult").html(
															result);
													for ( var i = 0; $(".errorMessage").length > i; i++) {
														var idName = $(
																".errorMessage")
																.eq(i).attr(
																		"id");
														$("#"+ idName+ "Result").html($(".errorMessage").eq(i));
													}
													$(".errorMessage").parents(".form-group").addClass("has-error");
													errorVal = true;
												} else {
													$().toastmessage('showSuccessToast',"Дараагийн алхамд орлоо");
													$(".errorMessage").parents(".form-group").removeClass("has-error");
													$(".errorMessage").remove();
													$.ajax({
																url : "productModel-change",
																success : function(
																		result) {
																	$("#change-result").html(result);
																}
															});
													errorVal = false;
													//document.getElementById('next').click();
												}
											}
										});
							}
							if (errorVal == true) {
								return false;
							}
						}).on('finished', function(e) {
							$.ajax({
								url : "saveChange",
								data : $("#changeForm").serialize(),
								success : function(result) {
									if (result.trim() != "") {
										$().toastmessage('showErrorToast',"Алдаа гарлаа!");
										$("#change-result").html(result);
										$(".errorMessage").parents(".form-group").addClass("has-error");
									}
									else{
										$().toastmessage('showSuccessToast',"Амжилттай хадгалагдлаа");
										window.location = "productModels";
									}
								}
							});
					//document.getElementById('gogo').click();
				}).on('stepclick', function(e) {
					errorVal = true;
				});

		$('.clazz')
				.change(
						function() {
							if ($("select[name='subCategory']").val() != -1
									&& $("select[name='subGauge']").val() != -1
									&& $("select[name='subProductTypeString']")
											.val() != -1) {
								$
										.ajax({
											url : "generate",
											data : {
												"subMaterial" : $(
														"select[name='subMaterial']")
														.val(),
												"subCategory" : $(
														"select[name='subCategory']")
														.val(),
												"subGauge" : $(
														"select[name='subGauge']")
														.val(),
												"subProductTypeString" : $(
														"select[name='subProductTypeString']")
														.val(),
												"subModelId" : $(
														"input[name='modelId']")
														.val()
											},
											success : function(result) {
												$('#subNumber').val(result);
											}
										});
							}
						});
		$('#add')
				.click(
						function() {
							$('.wwFormTable tr:last')
									.prev()
									.prev()
									.before(
											'<tr><td></td><td><input type="file" id="saveProductModel_im" class="imageInput" style="float:left;" name="im" /></td></tr>');
						});
		$("#plus-btn").click(function(e) {
			e.preventDefault();
			$.ajax({
				url : "product-model-color",
				data : $("#addForm").serialize(),
				success : function(result) {
					$("#listcolordiv").html(result);
				}
			});
		});
		$("#minus-btn").click(function(e) {
			e.preventDefault();
			$.ajax({
				url : "product-model-minus",
				data : $("#addForm").serialize(),
				success : function(result) {
					$("#listcolordiv").html(result);
				}
			});
		});
	});