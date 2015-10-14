jQuery(function($) {
		var errorVal = true;
		var myRules = new Array();
		var validationObject;
		var $validation = false;
		$('.upload').fileupload({
			dataType : 'json',
			done : function(e, data) {
			}
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
								$
										.ajax({
											url : "save-productModel-ajax",
											data : $("#addForm").serialize(),
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
													document.getElementById('next').click();
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
		$('.imageInput').ace_file_input({
			no_file : 'Файл байхгүй ...',
			btn_choose : 'Сонгох',
			btn_change : 'Өөрчлөх',
			droppable : false,
			onchange : null,
			thumbnail : false
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
		
		$("#addpic").click(function(e) {
			$('#imageTable tr:last').prev().before('<tr><td><input name="im" type="file" class="imageInput upload" data-url="turshilt"></td></tr>');
			$('.imageInput').ace_file_input({
				no_file : 'Файл байхгүй ...',
				btn_choose : 'Сонгох',
				btn_change : 'Өөрчлөх',
				droppable : false,
				onchange : null,
				thumbnail : false
			});
			$('.upload').fileupload({
				dataType : 'json',
				done : function(e, data) {
				}
			});
		});

	})