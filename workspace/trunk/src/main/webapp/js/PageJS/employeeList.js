jQuery(function($) {
		pageScript();
		$("#birthday1").datepicker({
			changeMonth : true,
			changeYear : true,
			dateFormat : "yy-mm-dd",
		});
	});
	function pageScript() {
		$("#example th:nth-child(1), #example td:nth-child(1)").hide();
		$("#example th:nth-child(11), #example td:nth-child(12)").hide();
		$("#example th:nth-child(12), #example td:nth-child(13)").hide();
		$(".errorMessage").parents(".form-group").addClass("has-error");
		var id, fname, lname, email, phone, birthday, regNumber, position, status, user, position1, posID, userID,oTable1,code;
		var context = $("#context").text().trim();
		var a = "http://" + window.location.host;
		var b = "/css/copy_csv_xls_pdf.swf";
		var c = a.concat(context);
		var n = c.concat(b);
		$("#example tbody tr").click(function(e) {
			position1 = oTable1.fnGetPosition(this);
			id = oTable1.fnGetData(position1)[0];
			lname = oTable1.fnGetData(position1)[1];
			fname = oTable1.fnGetData(position1)[2];
			code = oTable1.fnGetData(position1)[3];
			regNumber = oTable1.fnGetData(position1)[4];
			position = oTable1.fnGetData(position1)[5];
			birthday = oTable1.fnGetData(position1)[6];
			phone = oTable1.fnGetData(position1)[7];
			email = oTable1.fnGetData(position1)[8];
			status = oTable1.fnGetData(position1)[9];
			user = oTable1.fnGetData(position1)[10];
			posID = oTable1.fnGetData(position1)[11];
			userID = oTable1.fnGetData(position1)[12];
			if ($(this).hasClass('success')) {
				$(this).removeClass('success');
			} else {
				oTable1.$('tr.success').removeClass('success');
				$(this).addClass('success');
			}
		});
		oTable1 = $('#example')
				.dataTable(
						{
							"sDom" : "<'row'<'col-xs-4'l><'col-xs-4'f><'col-xs-4'T>r>t<'row'<'col-xs-4 customTool'><'col-xs-4'i><'col-xs-4'p>>",
							"aaSorting" : [ [ 0, "desc" ] ],
							"iDisplayLength": 25,
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
		
		function fnGetSelected(oTableLocal) {
			return oTableLocal.$('tr.success');
		}
		$("#show").click(
				function(e) {
					var anSelected = fnGetSelected(oTable1);
					if (anSelected.length !== 0) {
						e.preventDefault();
						$(".errorMessage").parents(".form-group").removeClass(
								"has-error");
						$(".errorMessage").remove();
						$("input[name='id']").val(id);
						$("input[name='lastName']").val(lname);
						$("input[name='firstName']").val(fname);
						$("input[name='code']").val(code);
						$("input[name='regNumber']").val(regNumber);
						$("input[name='postion.name']").val(position);
						$("input[name='birthday']").val(birthday);
						$("input[name='phone']").val(phone);
						$("input[name='email']").val(email);
						$("input[name='status.label']").val(status);
						$("input[name='empUser.userName']").val(user);
						var dialog = $("#dialog-show").removeClass('hide')
								.dialog({
									width : 450,
									modal : true,
									title : "Ажилчин",
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
							$("input[name='firstName']").val("");
							$("input[name='lastName']").val("");
							$("input[name='code']").val("");
							$("input[name='regNumber']").val("");
							$("input[name='positionString']").val("");
							$("input[name='birthString']").val("");
							$("input[name='email']").val("");
							$("input[name='phone']").val("");
							$("input[name='employeeUser']").val("");
							$("input[name='status']").val("");
							var $dialogContent = $("#dialog-addnew")
									.removeClass('hide')
									.dialog(
											{
												width : 450,
												modal : true,
												title : "Ажилчин нэмэх",
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
																		dialog,
																		"addForm",
																		"save-employee-ajax");
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
						$("input[name='id']").val(id);
						$("input[name='lastName']").val(lname);
						$("input[name='firstName']").val(fname);
						$("input[name='code']").val(code);
						$("input[name='regNumber']").val(regNumber);
						$('#positionID option[value="'+posID+'"]').prop('selected',true);
						$("input[name='birthString']").val(birthday);
						$("input[name='phone']").val(phone);
						$("input[name='email']").val(email);
						$("input[name='status']").val(status);
						$('#empUserID option[value="'+userID+'"]').prop('selected',true);
						var $dialogContent1 = $("#dialog-addnew")
								.removeClass('hide')
								.dialog(
										{
											width : 450,
											modal : true,
											title : "Ажилчны мэдээлэл засах",
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
																	dialog,
																	"addForm","save-employee-ajax");
														}
													} ]
										});
					}
				});
		function ajaxResults($dialogContent, dialog, formID, urll) {
			$.ajax({
				url : urll,
				data : $("#" + formID + "").serialize(),
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
							url : "employee-list-ajax",
							success : function(result) {
								$("#list-result").html(result);
								pageScript();
							}
						});
						$(".errorMessage").parents(".form-group").removeClass(
								"has-error");
						$(".errorMessage").remove();
						$dialogContent.find("input[name='firstName']").val("");
						$dialogContent.find("input[name='lastName']").val("");
						$dialogContent.find("input[name='code']").val("");
						$dialogContent.find("input[name='id']").val("");
						$(dialog).dialog("close");
					}
				}
			});
		}
	}