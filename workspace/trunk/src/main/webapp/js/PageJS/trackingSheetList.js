(function($) {
	$.fn.dataTableExt.oApi.fnGetColumnData = function(oSettings, iColumn,
			bUnique, bFiltered, bIgnoreEmpty) {
		// check that we have a column id
		if (typeof iColumn == "undefined")
			return new Array();

		// by default we only want unique data
		if (typeof bUnique == "undefined")
			bUnique = true;

		// by default we do want to only look at filtered data
		if (typeof bFiltered == "undefined")
			bFiltered = true;

		// by default we do not want to include empty values
		if (typeof bIgnoreEmpty == "undefined")
			bIgnoreEmpty = true;

		// list of rows which we're going to loop through
		var aiRows;

		// use only filtered rows
		if (bFiltered == true)
			aiRows = oSettings.aiDisplay;
		// use all rows
		else
			aiRows = oSettings.aiDisplayMaster; // all row numbers

		// set up data array	
		var asResultData = new Array();

		for ( var i = 0, c = aiRows.length; i < c; i++) {
			iRow = aiRows[i];
			var aData = this.fnGetData(iRow);
			var sValue = aData[iColumn];

			// ignore empty values?
			if (bIgnoreEmpty == true && sValue.length == 0)
				continue;

			// ignore unique values?
			else if (bUnique == true
					&& jQuery.inArray(sValue, asResultData) > -1)
				continue;

			// else push the value onto the result data array
			else
				asResultData.push(sValue);
		}

		return asResultData;
	}
}(jQuery));

function fnCreateSelect(aData, count) {
	var r = '<datalist id="datalistId'+count+'"><option value=""></option>', i, iLen = aData.length;

	for (i = 0; i < iLen; i++) {
		r += '<option value="'+aData[i]+'">' + aData[i] + '</option>';
	}
	return r + '</datalist>';
}

$(document).ready(function() {
	pageScript();
});
function pageScript() {
	var context = $("#context").text().trim();
	var a = "http://" + window.location.host;
	var b = "/css/copy_csv_xls_pdf.swf";
	var c = a.concat(context);
	var n = c.concat(b);
	var asInitVals = new Array();
	$("tfoot input").keyup(
			function() {
				/*  Filter on the column (the index) of this element */
				var a = this.value;
				oTable.fnFilter(this.value, $("tfoot input").index(this),
						true, false);

			});

	$("tfoot input").each(function(i) {
		asInitVals[i] = this.value;
	});

	$(".date").datepicker({
		changeMonth : true,
		changeYear : true,
		dateFormat : "yy-mm-dd",
		defaultDate : new Date()
	});
	var d = new Date();
	var id1, position1,oTable;
	var y = d.getFullYear();
	var m;
	if (d.getMonth() + 1 < 10)
		m = '0' + (d.getMonth() + 1);
	else
		m = (d.getMonth() + 1);
	var dd;
	if (d.getDate() < 10)
		dd = '0' + d.getDate();
	else
		dd = d.getDate();
	$(".date").val(y + "-" + m + "-" + dd);
	$("tfoot input").focus(function() {
		if (this.className == "search_init") {
			this.className = "";
			this.value = "";
		}
	});

	$("tfoot input").blur(function(i) {
		if (this.value == "") {
			this.className = "search_init";
			this.value = asInitVals[$("tfoot input").index(this)];
		}
	});
	$("#example tbody tr").click(function(e) {
		position1 = oTable.fnGetPosition(this);
		id1 = oTable.fnGetData(position1)[0];
		if ($(this).hasClass('success')) {
			$(this).removeClass('success');
		} else {
			oTable.$('tr.success').removeClass('success');
			$(this).addClass('success');
		}
	});
	$("#example tbody tr").dblclick(function(event) {
		var position = oTable.fnGetPosition(this);
		var id = oTable.fnGetData(position)[0];
		window.location = "trackingSheetShow?model.id=" + id1;
	});
	oTable = $('#example')
			.dataTable(
					{
						"sDom" : "<'row'<'col-xs-4'l><'col-xs-4'f><'col-xs-4'T>r>t<'row'<'col-xs-4 customTool'><'col-xs-4'i><'col-xs-4'p>>",
						"aaSorting" : [ [ 0, "desc" ] ],
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
	
	$("tfoot td").each(function(i) {
		this.innerHTML = fnCreateSelect(oTable.fnGetColumnData(i), i);
		$('select', this).change(function() {
			oTable.fnFilter($(this).val(), i);
		});
	});
	
	$("#show").click(function(e) {
		var anSelected = fnGetSelected(oTable);
		if (anSelected.length !== 0) {
			window.location = "trackingSheetShow?model.id=" + id1;
		}
	});
	var $dialogContent = $("#dialog-addnew").dialog({
		width : 470,
		autoOpen : false,
		modal : true,
		title : "Add new",
		buttons : [ {
			html : "<i class='icon-remove bigger-110'></i>&nbsp; Cancel",
			"class" : "btn btn-danger btn-xs",
			click : function() {
				$(this).dialog("close");
			}
		}, {
			html : "<i class='icon-save bigger-110'></i>&nbsp; Save",
			"class" : "btn btn-success btn-xs",
			click : function() {
				var dialog = this;
				ajaxResults($dialogContent, dialog, "addForm");
			}
		} ]
	});
	var $dialogContent1 = $("#dialog-edit").dialog({
		width : 470,
		autoOpen : false,
		modal : true,
		title : "Edit new",
		buttons : [ {
			html : "<i class='icon-remove bigger-110'></i>&nbsp; Cancel",
			"class" : "btn btn-danger btn-xs",
			click : function() {
				$(this).dialog("close");
			}
		}, {
			html : "<i class='icon-save bigger-110'></i>&nbsp; Save",
			"class" : "btn btn-success btn-xs",
			click : function() {
				var dialog = this;
				ajaxResults($dialogContent1, dialog, "editForm");
			}
		} ]
	});
	$(".chosen-select").chosen();
	$("#productModelSelectID").change(
			function(e) {
				e.preventDefault();
				$.ajax({
					url : "trackingSheet-colors",
					data : {
						"modelID" : $("#productModelSelectID").val()
					},
					success : function(result) {
						$("#selectColors").html(result);
						$(".chosen-select").chosen();
						$dialogContent.find('.chosen-container').each(
								function() {
									$dialogContent.find('a:first-child')
											.css('width', '210px');
									$dialogContent.find('.chosen-drop')
											.css('width', '210px');
									$dialogContent.find(
											'.chosen-search input').css(
											'width', '200px');
								});
					}
				});
			});
	$("#addNew").click(
			function(e) {
				e.preventDefault();
				$(".errorMessage").parents(".form-group").removeClass(
						"has-error");
				$(".errorMessage").remove();
				$dialogContent.find('.chosen-container').each(
						function() {
							$dialogContent.find('a:first-child').css(
									'width', '210px');
							$dialogContent.find('.chosen-drop').css(
									'width', '210px');
							$dialogContent.find('.chosen-search input')
									.css('width', '200px');
						});
				$(".chosen-select").val('').trigger("chosen:updated");
				$("input[name='id']").val("");
				//$("select[name='kniterChecker']").val("");
				/* $("select[name='roleString']").val("");
				$("input[name='pwd']").val("");
				$("input[name='confirmPwd']").val(""); */
				$("#dialog-addnew").dialog("open");

			});
	$(document).ajaxStart(function() {
		$(function() {
			//$("#edit").click(function() {
				$("#pic").removeClass('hide');
				$("#edit-result").addClass('hide');
			//});
		});
	});
	$(document).ajaxStop(function() {
		$("#pic").addClass('hide');
		$("#edit-result").removeClass('hide');
	});
	$("#edit").click(
			function(e) {
				var anSelected = fnGetSelected(oTable);
				if (anSelected.length !== 0) {
					e.preventDefault();
					$.ajax({
						url : "trackingSheet-edit-ajax?model.id=" + id1,
						success : function(result) {
							if (result.trim() != "") {
							$("#edit-result").html(result);
							 $("#productModelSelectID1").change(
									function(e) {
										e.preventDefault();
										$.ajax({
											url : "trackingSheet-colors",
											data : {
												"modelID" : $("#productModelSelectID1").val()
											},
											success : function(result) {
												$("#selectColors1").html(result);
												$(".chosen-select").chosen();
												$dialogContent.find('.chosen-container').each(
														function() {
															$dialogContent.find('a:first-child')
																	.css('width', '210px');
															$dialogContent.find('.chosen-drop')
																	.css('width', '210px');
															$dialogContent.find(
																	'.chosen-search input').css(
																	'width', '200px');
														});
											}
										});
									}); 
							
							$(".chosen-select").chosen();
							$("#date-r").datepicker({
								changeMonth : true,
								changeYear : true,
								dateFormat : "yy-mm-dd",
								defaultDate : new Date()
							});
							$(".errorMessage").parents(".form-group")
									.removeClass("has-error");
							$dialogContent1.find('.chosen-container').each(
									function() {
										$dialogContent1.find(
												'a:first-child').css(
												'width', '210px');
										$dialogContent1
												.find('.chosen-drop').css(
														'width', '210px');
										$dialogContent1.find(
												'.chosen-search input')
												.css('width', '200px');
									});

							$("#dialog-edit").dialog("open");
							}else{
							$().toastmessage('showErrorToast', "Өөрчлөх боломжгүй байна!");
						}
						}
					
					});
					
					
				}
			});
	function fnGetSelected(oTableLocal) {
		return oTableLocal.$('tr.success');
	}
	function ajaxResults($dialogContent, dialog, formID) {
		$.ajax({
			url : "save-trackingST-ajax",
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
						$("#" + idName + formID+ "Result").html(
								$(".errorMessage").eq(i));
					}
					$(".errorMessage").parents(".form-group").addClass(
							"has-error");
				} else {
					$().toastmessage('showSuccessToast',
							"Амжилттай хадгалагдлаа");
					$.ajax({
						url : "trackingST-list-ajax",
						success : function(result) {
							$("#list-result").html(result);
							pageScript();
						}
					});
					$(".errorMessage").parents(".form-group").removeClass(
							"has-error");
					$(".errorMessage").remove();
					/* $dialogContent.find("input[name='userName']").val("");
					$dialogContent.find("select[name='roleString']").val("");
					$dialogContent.find("input[name='pwd']").val("");
					$dialogContent.find("input[name='confirmPwd']").val(""); */
					$(dialog).dialog("close");
				}
			}
		});
	}
}