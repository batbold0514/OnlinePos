$(function() {
		$("input[type=submit]").button();
	});
	$(document)
			.ready(
					function() {
						setHidden();
						$("#selectStatus").focus();
						$('.clazz')
								.change(
										function() {
											if ($("select[name='subCategory']")
													.val() != -1
													&& $(
															"select[name='subGauge']")
															.val() != -1
													&& $(
															"select[name='subProductTypeString']")
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
															success : function(
																	result) {
																$('#subNumber')
																		.val(
																				result);
															}
														});
											}
										});
						  $("#plus-btn").click(function(e) {
								e.preventDefault();
								$.ajax({
									url : "product-model-color",
									data : $("#editForm").serialize(),
									success : function(result) {
										$("#listcolordiv").html(result);
									}
								});
							});
							$("#minus-btn").click(function(e) {
								e.preventDefault();
								$.ajax({
									url : "product-model-minus",
									data : $("#editForm").serialize(),
									success : function(result) {
										$("#listcolordiv").html(result);
									}
								});
							});
					});
	function setHidden() {
		if ($("#selectStatus").val() == 'active') {
			$('#submitId').hide();
			$('#submitId1').show();
		} else {
			$('#submitId').show();
			$('#submitId1').hide();
		}
	};
