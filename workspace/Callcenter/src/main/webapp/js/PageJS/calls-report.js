
jQuery(function($) {
	pageScript();
	$("#startDate").datepicker({
		changeMonth : true,
		changeYear : true,
		dateFormat : "yy-mm-dd",
	});
	$("#endDate").datepicker({
		changeMonth : true,
		changeYear : true,
		dateFormat : "yy-mm-dd",
	});
	$(".selects").chosen();
	myPlaylist =$("#jquery_jplayer_1").jPlayer({
			swfPath: "../js/jplayer/jquery.jplayer.swf",
			supplied: "wav",
			wmode: "window",
			useStateClassSkin: true,
			autoBlur: true,
			smoothPlayBar: true,
			keyEnabled: true,
			remainingDuration: true,
			toggleDuration: true
		});
});
function pageScript() {
	// $("#sampletable2").DataTable();
	$("#sampletable2 th:nth-child(7), #sampletable2 td:nth-child(7)").hide();
	$(".errorMessage").parents(".form-group").addClass("has-error");
	var id, sizes, position1,myPlaylist;
	var context = $("#context").text().trim();
	var a = "http://" + window.location.host;
	var b = "/css/copy_csv_xls_pdf.swf";
	var c = a.concat(context);
	var n = c.concat(b);
	var oTable1 = $('#sampletable2')
			.dataTable(
					{
						"fnFooterCallback" : function(nRow, aaData, iStart,
								iEnd, aiDisplay) {
							var total = 0;
							for ( var i = 0; i < aaData.length; i++) {
								total += numeral().unformat(aaData[i][4]);
							}
							var nCells = document
									.getElementById('totalDuration');
							nCells.innerHTML = numeral(total).format('0,0.00');

						},
						"sDom" : "<'row'<'col-xs-4'l><'col-xs-4'f><'col-xs-4'T>r>t<'row'<'col-xs-4 customTool'><'col-xs-4'i><'col-xs-4'p>>",
						"aaSorting" : [ [ 0, "asc" ] ],
						"iDisplayLength" : 25,
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
	$("#sampletable2 tbody tr").click(function(e) {
		position1 = oTable1.fnGetPosition(this);
		if ($(this).hasClass('success')) {
			$(this).removeClass('success');
		} else {
			oTable1.$('tr.success').removeClass('success');
			$(this).addClass('success');
		}
	});

	$("#sampletable2 tbody tr").dblclick(function(e) {
		 position1 = oTable1.fnGetPosition(this);
		 var soundfile = oTable1.fnGetData(position1)[6];
		 $("#jquery_jplayer_1").jPlayer("setMedia", {
				wav: "../sound/"+soundfile+".wav"
			});
		$("#audio-dialog").removeClass('hide').dialog({
			width : 500,
			modal : true,
			draggable: true,
			title : "Бичлэг сонсох",
			title_html : true,
			autoOpen : true,
			open:function(){
				$("#play").trigger('click');
			},
			buttons : [ {
				html : "&nbsp; Болих ",
				"class" : "btn btn-danger btn-xs",
				"id" : "btnPhoneNumberCancel",
				click : function() {
					$("#stop").trigger('click');
					$(this).dialog("close");
				}
			} ]
		}).prev(".ui-dialog-titlebar").css("background", "blue");
	});

	/*
	 * $("#sampletable2 tbody tr").dblclick(function(e) { position1 =
	 * oTable1.fnGetPosition(this); var id = oTable1.fnGetData(position1)[0];
	 * window.location = "show-plan?model.id=" + id; });
	 */

	function fnGetSelected(oTableLocal) {
		return oTableLocal.$('tr.success');
	}
}