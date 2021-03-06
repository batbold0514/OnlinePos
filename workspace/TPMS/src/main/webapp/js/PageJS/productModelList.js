$(document).ready(function()
	{
		var oTable,id1,position1;
		var context = $("#context").text().trim();
		var a = "http://" + window.location.host;
		var b = "/css/copy_csv_xls_pdf.swf";
		var c = a.concat(context);
		var n = c.concat(b);
		var columnsd = new Array();
		$("#productModel tbody tr").dblclick(function(event) {
			var position = oTable.fnGetPosition(this);
			var id = oTable.fnGetData(position)[0];
			window.location = "editProductModel?model.id=" + id;
		});
		$("#productModel tbody tr").click(function(e) {
			position1 = oTable.fnGetPosition(this);
			id1 = oTable.fnGetData(position1)[0];
			if ($(this).hasClass('success')) {
				$(this).removeClass('success');
			} else {
				oTable.$('tr.success').removeClass('success');
				$(this).addClass('success');
			}
		});
		$("#productModel th:nth-child(1), #productModel td:nth-child(1)").hide();
  		var a = document.getElementById('productModel').rows[0].cells.length;
  		for(var i= 0; i<a-2;i++){
  		    columnsd[i] = i+2;
  		}
		oTable = $('#productModel').dataTable( {
			"sScrollX": "100%",
			"sDom" : "<'row'<'col-xs-4'l><'col-xs-4'f><'col-xs-4'T>r>t<'row'<'col-xs-4 customTool'><'col-xs-4'i><'col-xs-4'p>>",
			"aaSorting" : [],
			"oLanguage" : {
				"sUrl" : "../localisation/dataTable.mn.txt"
			},
			"oTableTools" : {
				"sSwfPath" : n,
				"sRowSelect" : "single",
				"aButtons" : [ {
					"sExtends" : "copy",
					"sButtonText" : "Хуулах",
					"mColumns": columnsd
				}, {
					"sExtends" : "xls",
					"sButtonText" : "Excel руу хадгалах",
					"mColumns": columnsd
				} ]
			}
		} );
		new FixedColumns( oTable, {
	 		"iLeftColumns": 3
	 	} );
		$(".customTool")
		.html(
				'<div class="btn-group"><a class="btn btn-success" id="addNew"><span class="icon-plus"></span></a> <a class="btn btn-warning" id="edit"><span class="icon-edit"></span></a></div>');
		$("#addNew").click(function(e) {
			window.location="productModel";
		});
		$("#edit").click(
				function(e) {
					var anSelected = fnGetSelected(oTable);
					if (anSelected.length !== 0) {
						window.location = "editProductModel?model.id=" + id1;
					}
				});
		$("#focus").focus();
		$("#productModel tbody tr").css('cursor', 'pointer');
	});
	function fnGetSelected(oTableLocal) {
		return oTableLocal.$('tr.success');
	}

	hs.graphicsDir = '../highslide/graphics/';
	hs.align = 'center';
	hs.transitions = [ 'expand', 'crossfade' ];
	hs.outlineType = 'rounded-white';
	hs.fadeInOut = true;
	hs.dimmingOpacity = 0.75;
	hs.useBox = true;
	hs.width = 640;
	hs.height = 480;

	hs.addSlideshow(
	{
		interval : 5000,
		repeat : false,
		useControls : true,
		fixedControls : 'fit',
		overlayOptions :
		{
			opacity : 1,
			position : 'bottom center',
			hideOnMouseOut : true
		},
		thumbstrip:
		{
			position: 'above',
			mode: 'horizontal',
			relativeTo: 'expander'
		}
	});
	$("#mybuttondialog").dialog({
		width : 300,
		autoOpen : true,
		modal : true,
		title : "Загвар амжилттай хадгалагдлаа",
		buttons : [ {
			html : "<i class='icon-save bigger-110'></i>&nbsp; Ok",
			"class" : "btn btn-success btn-xs",
			click : function() {
				$(this).dialog("close");
			}
		} ]
	});