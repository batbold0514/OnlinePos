jQuery(function($) {
		pageScript();
	});
	function pageScript() {
		$(
				"#productTypeTable th:nth-child(4), #productTypeTable td:nth-child(4)")
				.hide();
		$(".errorMessage").parents(".form-group").addClass("has-error");
		var name, position1, id1, prefix, active,oTable1;
		var context = $("#context").text().trim();
		var a = "http://" + window.location.host;
		var b = "/css/copy_csv_xls_pdf.swf";
		var c = a.concat(context);
		var n = c.concat(b);
		$("#productTypeTable tbody tr").click(function(e) {
			position1 = oTable1.fnGetPosition(this);
			prefix = oTable1.fnGetData(position1)[0];
			active = oTable1.fnGetData(position1)[2];
			name = oTable1.fnGetData(position1)[1];
			id1 = oTable1.fnGetData(position1)[3];

			if ($(this).hasClass('success')) {
				$(this).removeClass('success');
			} else {
				oTable1.$('tr.success').removeClass('success');
				$(this).addClass('success');
			}
		});
		oTable1 = $('#productTypeTable')
				.dataTable(
						{
							"sDom" : "<'row'<'col-xs-4'l><'col-xs-4'f><'col-xs-4'T>r>t<'row'<'col-xs-4 customTool'><'col-xs-4'i><'col-xs-4'p>>",
							"aaSorting" : [ [ 3, "desc" ] ],
							"iDisplayLength": 25,
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

		$(".customTool")
				.html(
						'<div class="btn-group"><a class="btn btn-success" id="addNew"><span class="icon-plus"></span></a> <a class="btn btn-warning" id="edit"><span class="icon-edit"></span></a> <a class="btn btn-primary" id="show"><span class="icon-eye-open"></span></a></div>');
		$("#show").click(
				function(e) {
					var anSelected = fnGetSelected(oTable1);
					if (anSelected.length !== 0) {
						e.preventDefault();
						$(".errorMessage").parents(".form-group").removeClass(
								"has-error");
						$(".errorMessage").remove();
						$("input[name='id']").val(id1);
						$("input[name='prefix']").val(prefix);
						if (active == "true") {
							/* $('input:radio[name=active]')[0].checked = true;
							$('input:radio[name=active]')[1].checked = false ;
							$('input[name="active"][value="'+true+'"]').prop('checked',true);
							$('input:radio[name=active]:nth(0)').attr('checked',true);*/
							$('#radio1').attr('checked', true); 
						} else {
							 $('#radio2').attr('checked', true); 
						}
						$("input[name='name']").val(name);
						var dialog = $("#dialog-show").removeClass('hide')
								.dialog({
									width : 450,
									modal : true,
									title : "Загварын төрөл",
									buttons : [ {
										text : "Cancel",
										"class" : "btn btn-xs",
										click : function() {
											$(this).dialog("close");
										}
									}, {
										text : "OK",
										"class" : "btn btn-primary btn-xs",
										click : function() {
											$(this).dialog("close");
										}
									} ]
								});
					}
				});
		$("#addNew")
				.click(
						function(e) {
							e.preventDefault();
							$(".errorMessage").parents(".form-group")
									.removeClass("has-error");
							$(".errorMessage").remove();
							$("input[name='id']").val("");
							$('input[name="active"][value="'+true+'"]').prop('checked',true);
							$("input[name='prefix']").val("");
							$("input[name='name']").val("");
							var $dialogContent = $("#dialog-addnew")
									.removeClass('hide')
									.dialog(
											{
												width : 450,
												modal : true,
												title : "Загварын төрөл нэмэх",
												buttons : [
														{
															html : "<i class='icon-remove bigger-110'></i>&nbsp; Cancel",
															"class" : "btn btn-danger btn-xs",
															click : function() {
																$(this)
																		.dialog(
																				"close");
															}
														},
														{
															html : "<i class='icon-save bigger-110'></i>&nbsp; Save",
															"class" : "btn btn-success btn-xs",
															click : function() {
																var dialog = this;
																ajaxResults(
																		$dialogContent,
																		dialog);
															}
														} ]
											});
						});
		$("#edit")
				.click(
						function(e) {
							var anSelected = fnGetSelected(oTable1);
							if (anSelected.length !== 0) {
								e.preventDefault();
								$(".errorMessage").parents(".form-group")
										.removeClass("has-error");
								$(".errorMessage").remove();
								$("input[name='id']").val(id1);
								$('input[name="active"][value="'+active+'"]').prop('checked',true);
								$("input[name='prefix']").val(prefix);
								$("input[name='name']").val(name);
								var $dialogContent1 = $("#dialog-addnew")
										.removeClass('hide')
										.dialog(
												{
													width : 450,
													modal : true,
													title : "Загварын төрөл засах",
													buttons : [
															{
																html : "<i class='icon-remove bigger-110'></i>&nbsp; Cancel",
																"class" : "btn btn-danger btn-xs",
																click : function() {
																	$(
																			".errorMessage")
																			.parents(
																					".form-group")
																			.removeClass(
																					"has-error");
																	$(this)
																			.dialog(
																					"close");
																}
															},
															{
																html : "<i class='icon-save bigger-110'></i>&nbsp; Save",
																"class" : "btn btn-success btn-xs",
																click : function() {
																	var dialog = this;
																	ajaxResults(
																			$dialogContent1,
																			dialog);
																}
															} ]
												});
							}
						});
		function fnGetSelected(oTableLocal) {
			return oTableLocal.$('tr.success');
		}
		function ajaxResults($dialogContent, dialog) {
			$.ajax({
				url : "save-product-type-ajax",
				data : $("#addForm").serialize(),
				success : function(result) {
					if (result.trim() != "") {
						$(".errorMessage").parents(".form-group").removeClass(
								"has-error");
						$(".errorMessage").remove();
						$().toastmessage('showErrorToast', "Алдаа гарлаа!");
						$("#parseResult").html(result);
						for ( var i = 0; $(".errorMessage").length > i; i++) {
							var idName = $(".errorMessage").eq(i).attr("id");
							$("#" + idName + "Result").html(
									$(".errorMessage").eq(i));
						}
						$(".errorMessage").parents(".form-group").addClass(
								"has-error");
					} else {
						$().toastmessage('showSuccessToast',
								"Амжилттай хадгалагдлаа");
						$.ajax({
							url : "get-product-typeList-ajax",
							success : function(result) {
								$("#list-result").html(result);
								pageScript();
							}
						});
						$(".errorMessage").parents(".form-group").removeClass(
								"has-error");
						$(".errorMessage").remove();
						$dialogContent.find("input[name='name']").val("");
						$dialogContent.find("input[name='id']").val("");
						$('#radio1').attr('checked', true);
						$dialogContent.find("input[name='prefix']").val("");
						$dialogContent.find("input[name='name']").val("");
						$(dialog).dialog("close");
					}
				}
			});
		}
	}
