<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="display" uri="http://displaytag.sf.net"%>
<div class="hidden" id="page">
	<s:url action="diagnosisList" includeParams="none" />
</div>
<div class="page-content">
	<div class="page-header">
		<h2>
			<s:text name="DiagnosisList" />
			<small> <i class="icon-double-angle-right"></i> Жагсаалт
			</small>
		</h2>
	</div>
	<div class="row">
		<div class="col-xs-12">
			<div class="table-responsive" id="list-result">
				<display:table name="diagnosisList" cellpadding="0" cellspacing="0"
					class="table table-striped table-bordered table-hover" id="example">
					<display:column property="id" title="Д/д" />
					<display:column property="code" title="Оношны код" />
					<display:column property="name" title="Оношны нэр" />
				</display:table>
			</div>
		</div>
	</div>
</div>
<div id="parseResult" class="hidden"></div>
<div id="dialog-show" class="hide">
	<div class="form-group">
		<s:hidden key="id" />
		<div class="row">
			<div class="col-sm-12">
				<label for="code" class="control-label col-sm-5 col-lg-5"> <s:text
						name="code" />
				</label>
				<div class="col-sm-7 col-lg-6">
					<s:textfield name="code" cssClass="form-control" id="code"
						autofocus="" disabled="true" />
				</div>
			</div>
		</div>
		<div class="row">
			<div class="col-sm-12">
				<label for="name" class="control-label col-sm-5 col-lg-5"> <s:text
						name="name" />
				</label>
				<div class="col-sm-7 col-lg-6">
					<s:textfield name="name" cssClass="form-control" id="name"
						autofocus="" disabled="true" />
				</div>
			</div>
		</div>
	</div>
</div>
<div id="dialog-addnew" class="hide">
	<s:form action="saveColour" cssClass="form-horizontal" id="addForm">
		<s:hidden name="id" />
		<div class="form-group">
			<div class="row">
				<div class="col-sm-12">
					<label for="code" class="control-label col-sm-5 col-lg-5">
						<s:text name="code" />
					</label>
					<div class="col-sm-7 col-lg-6">
						<s:textfield name="code" cssClass="form-control" id="code"
							autofocus="" />
					</div>
				</div>
			</div>
			<div class="row">
				<div class="col-sm-offset-4 col-sm-7 col-lg-offset-3 col-lg-6"
					id="errorCodeResult">
					<s:fielderror fieldName="name" />
				</div>
			</div>
		</div>
		<div class="form-group">
			<div class="row">
				<div class="col-sm-12">
					<label for="name" class="control-label col-sm-5 col-lg-5">
						<s:text name="name" />
					</label>
					<div class="col-sm-7 col-lg-6">
						<s:textfield name="name" cssClass="form-control" id="name"
							autofocus="" />
					</div>
				</div>
			</div>
		</div>
	</s:form>
</div>
<div id="context" class="hidden">
	${pageContext.request.contextPath}</div>
<br />

<script>
	jQuery(function($) {
		pageScript();
	});
	function pageScript() {
		$("#example th:nth-child(1), #example td:nth-child(1)").hide();
		$(".errorMessage").parents(".form-group").addClass("has-error");
		var id, name, position1, oTable1, code;
		var context = $("#context").text().trim();
		var a = "http://" + window.location.host;
		var b = "/css/copy_csv_xls_pdf.swf";
		var c = a.concat(context);
		var n = c.concat(b);
		$("#example tbody tr").click(function(e) {
			position1 = oTable1.fnGetPosition(this);
			id = oTable1.fnGetData(position1)[0];
			code = oTable1.fnGetData(position1)[1];
			name = oTable1.fnGetData(position1)[2];
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
			code = oTable1.fnGetData(position1)[1];
			name = oTable1.fnGetData(position1)[2];
			$(".errorMessage").parents(".form-group")
			.removeClass("has-error");
	$(".errorMessage").remove();
	$("input[name='id']").val(id);
	$("input[name='name']").val(name);
	$("input[name='code']").val(code);
	var $dialogContent1 = $("#dialog-addnew")
			.removeClass('hide')
			.dialog(
					{
						width : 450,
						modal : true,
						title : "Тариф засах",
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
												"save-diagnosis-ajax");
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
		$("#show").click(
				function(e) {
					var anSelected = fnGetSelected(oTable1);
					if (anSelected.length !== 0) {
						e.preventDefault();
						$(".errorMessage").parents(".form-group").removeClass(
								"has-error");
						$(".errorMessage").remove();
						$("input[name='id']").val(id);
						$("input[name='name']").val(name);
						$("input[name='code']").val(code);
						var dialog = $("#dialog-show").removeClass('hide')
								.dialog({
									width : 450,
									modal : true,
									title : "Онош",
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
							$("input[name='name']").val("");
							$("input[name='code']").val("");
							var $dialogContent = $("#dialog-addnew")
									.removeClass('hide')
									.dialog(
											{
												width : 450,
												modal : true,
												title : "Онош нэмэх",
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
																		"save-diagnosis-ajax");
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
								$("input[name='name']").val(name);
								$("input[name='code']").val(code);
								var $dialogContent1 = $("#dialog-addnew")
										.removeClass('hide')
										.dialog(
												{
													width : 450,
													modal : true,
													title : "Тариф засах",
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
																			"save-diagnosis-ajax");
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
							url : "diagnosis-list",
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
						$dialogContent.find("input[name='code']").val("");
						$(dialog).dialog("close");
					}
				}
			});
		}
	}

	
</script>

