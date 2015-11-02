jQuery(function($) {
		pageScript();
	});
function getval(sel, model) {
    $.ajax({
    	url:"changeOpId-ajax",
    	data:{
    		"opIdChild":sel,
    		"opModel":model.value
    	},
    	success : function(result) {
    		if(result.trim() == ""){
    			successMessage();
    		}else{
    			errorMessage();
    			alert(result);
    		}
    	}
    });
 }
	function pageScript() {
//		$("#sampletable2").DataTable();
		var id, sizes, position1;
		var context = $("#context").text().trim();
		var a = "http://" + window.location.host;
		var b = "/css/copy_csv_xls_pdf.swf";
		var c = a.concat(context);
		var n = c.concat(b);
		$("#sampletable2 th:nth-child(1), #sampletable2 td:nth-child(1)").hide();
		var oTable1 = $('#sampletable2')
				.dataTable(
						{
							"sDom" : "<'row'<'col-xs-4'l><'col-xs-4'f><'col-xs-4'T>r>t<'row'<'col-xs-4 customTool'><'col-xs-4'i><'col-xs-4'p>>",
							"aaSorting" : [ [ 6, "desc" ] ],
							"oLanguage": {
								"sUrl":"../localisation/dataTable.mn.txt"
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
			id1 = oTable1.fnGetData(position1)[0];
			if ($(this).hasClass('success')) {
				$(this).removeClass('success');
			} else {
				oTable1.$('tr.success').removeClass('success');
				$(this).addClass('success');
			}
		});
		$("#sampletable2 tbody tr")
		.dblclick(
				function(e) {
					id1 = oTable1.fnGetData(position1)[0];
					$("input[name='id']").val(id1);
//					location = "getTaxPayer?modelId="+id1;
					$.ajax({
						url : "getTaxPayer",
						data :{
							"modelId" : id1
						},
						success : function(result) {
							$("div[id='showTaxPayer']").html(result);
						}
					});
					$("#dialog").dialog("open");
				});
		 $("#btn").click( function() {
		       /* var data = oTable1.$('select').serialize();
		        alert(
		            "The following data would have been submitted to the server: \n\n"+
		            data.substr( 0, 120 )+'...'
		        );
		        return false;*/
		    } );
		 $('.changeopid').on('change', function() {
			  alert( this.value);
			  			});
		 //89197563 ganbat
		 $("#dialog").dialog(
					{
						title: "Индексийн задаргаа",
						title_html: true,
						autoOpen: false,
						modal: true,
						width: 600,
						buttons:[ 
										{
										html: "<i class='icon-check bigger-110'></i>&nbsp; Болих",
										"class" : "btn btn-success btn-xs",
										"id" : "btnBack",
											click: function() {
												$(this).dialog("close");
											}
										}
							         ]
					}).prev(".ui-dialog-titlebar").css("background","#4b8df8");
	}
	function successMessage() {
		$.gritter.add({
			title : 'тайлбар',
			text : 'Амжилттай хадгаллаа',
			sticky : false,
			time : '1000'
		});
	}

	function errorMessage() {
		$.gritter.add({
			title : 'тайлбар',
			text : 'Алдаа гарлаа',
			sticky : false,
			time : '1000'
		});
	}