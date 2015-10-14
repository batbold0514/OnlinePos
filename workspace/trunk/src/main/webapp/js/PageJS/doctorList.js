jQuery(function($) {
	pageScript();
});
function pageScript() {
	$("#example th:nth-child(1), #example td:nth-child(1)").hide();
	$(".errorMessage").parents(".form-group").addClass("has-error");
	var id, regNumber, fname, m1, m2, pnumber, name, status, doctorUserString, position1, oTable1;
	var context = $("#context").text().trim();
	var a = "http://" + window.location.host;
	var b = "/css/copy_csv_xls_pdf.swf";
	var c = a.concat(context);
	var n = c.concat(b);
	$("#example tbody tr").click(function(e) {
		position1 = oTable1.fnGetPosition(this);
		id = oTable1.fnGetData(position1)[0];
		regNumber = oTable1.fnGetData(position1)[1];
		fname = oTable1.fnGetData(position1)[2];
		name = oTable1.fnGetData(position1)[3];
		m1 = oTable1.fnGetData(position1)[4];
		m2 = oTable1.fnGetData(position1)[5];
		pnumber = oTable1.fnGetData(position1)[6];
		status = oTable1.fnGetData(position1)[7];
		doctorUserString = oTable1.fnGetData(position1)[8];
		if ($(this).hasClass('success')) {
			$(this).removeClass('success');
		} else {
			oTable1.$('tr.success').removeClass('success');
			$(this).addClass('success');
		}
	});
	$("#example tbody tr").dblclick(function(e) {
		position1 = oTable1.fnGetPosition(this);
		id = oTable1.fnGetData(position1)[0];
		regNumber = oTable1.fnGetData(position1)[1];
		fname = oTable1.fnGetData(position1)[2];
		name = oTable1.fnGetData(position1)[3];
		m1 = oTable1.fnGetData(position1)[4];
		m2 = oTable1.fnGetData(position1)[5];
		pnumber = oTable1.fnGetData(position1)[6];
		status = oTable1.fnGetData(position1)[7];
		doctorUserString = oTable1.fnGetData(position1)[8];
		$(".errorMessage").parents(".form-group").removeClass(
		"has-error");
		$(".errorMessage").remove();
		$("input[name='id']").val(id);
		$("input[name='registrationNumber']")
				.val(regNumber);
		$("input[name='familyName']").val(fname);
		$("input[name='name']").val(name);
		$("input[name='mobile1']").val(m1);
		$("input[name='mobile2']").val(m2);
		$("input[name='phoneNumber']").val(pnumber);
		$("input[name='doctorUserStringHid']").val(doctorUserString);
		$("select[name='status']").val(status);
		$("select[name='doctorUserString']").val("");
		var $dialogContent1 = $("#dialog-addnew")
				.removeClass('hide')
				.dialog(
						{
							width : 450,
							modal : true,
							title : "Өнгө засах",
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
													"addForm",
													"save-doctor-ajax");
										}
									} ]
						});
	});
	oTable1 = $('#example')
			.dataTable(
					{
						"sDom" : "<'row'<'col-xs-4'l><'col-xs-4'f><'col-xs-4'T>r>t<'row'<'col-xs-4 customTool'><'col-xs-4'i><'col-xs-4'p>>",
						"aaSorting" : [ [ 0, "desc" ] ],
						"iDisplayLength" : 25,
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
	$("#show").click(function(e) {
		var anSelected = fnGetSelected(oTable1);
		if (anSelected.length !== 0) {
			e.preventDefault();
			$(".errorMessage").parents(".form-group").removeClass("has-error");
			$(".errorMessage").remove();
			$("input[name='id']").val(id);
			$("input[name='registrationNumber']").val(regNumber);
			$("input[name='familyName']").val(fname);
			$("input[name='name']").val(name);
			$("input[name='mobile1']").val(m1);
			$("input[name='mobile2']").val(m2);
			$("input[name='phoneNumber']").val(pnumber);
			$("select[name='status']").val(status);
			$("input[name='doctorUserString']").val(doctorUserString);
			var dialog = $("#dialog-show").removeClass('hide').dialog({
				width : 450,
				modal : true,
				title : "Эмч харах",
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
						$(".errorMessage").parents(".form-group").removeClass(
								"has-error");
						$(".errorMessage").remove();
						$("input[name='id']").val("");
						$("input[name='registrationNumber']").val("");
						$("input[name='familyName']").val("");
						$("input[name='name']").val("");
						$("input[name='mobile1']").val("");
						$("input[name='mobile2']").val("");
						$("input[name='phoneNumber']").val("");
						$("input[name='status']").val("");
						$("select[name='doctorUserString']").val("");
						var $dialogContent = $("#dialog-addnew")
								.removeClass('hide')
								.dialog(
										{
											width : 450,
											modal : true,
											title : "Өнгө нэмэх",
											buttons : [
													{
														html : "<i class='icon-remove bigger-110'></i>&nbsp; Cancel",
														"class" : "btn btn-danger btn-xs",
														click : function() {
															$(this).dialog(
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
																	"save-doctor-ajax");
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
							$(".errorMessage").parents(".form-group").removeClass(
							"has-error");
							$(".errorMessage").remove();
							$("input[name='id']").val(id);
							$("input[name='registrationNumber']")
									.val(regNumber);
							$("input[name='familyName']").val(fname);
							$("input[name='name']").val(name);
							$("input[name='mobile1']").val(m1);
							$("input[name='mobile2']").val(m2);
							$("input[name='phoneNumber']").val(pnumber);
							$("input[name='doctorUserStringHid']").val(doctorUserString);
							$("select[name='status']").val(status);
							$("select[name='doctorUserString']").val("");
							var $dialogContent1 = $("#dialog-addnew")
									.removeClass('hide')
									.dialog(
											{
												width : 450,
												modal : true,
												title : "Өнгө засах",
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
																		"addForm",
																		"save-doctor-ajax");
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
						url : "get-select-doctorList-ajax",
						success : function(result) {
							$("#doctor-list").html(result);
							//pageScript();
						}
					});
					$.ajax({
						url : "get-doctorList-ajax",
						success : function(result) {
							$("#list-result").html(result);
							pageScript();
						}
					});
					
					$(".errorMessage").parents(".form-group").removeClass(
							"has-error");
					$(".errorMessage").remove();
					$(dialog).dialog("close");
				}
			}
		});
	}
}
