jQuery(function($) {
	pageScript();
	initValidator();
	autoSearch();
	
});
function initValidator(){
	$('#addform').bootstrapValidator({
        fields: {
        	phoneNumber:{
        		validators: {
        			notEmpty: {
                      	 message: 'Хоосон байна'
                      },numeric: {
                          message: 'Тоо оруулна уу'
                      },
                      regexp: {
				            regexp:/^[0-9]{6}$|^[0-9]{8}$/,
				            message: '123456 эсвэл 12345678 байж болно'
				            } 
                      
                }
        	}
        }
	}).on('success.form.bv', function(e) {
        e.preventDefault();
        $.post('search-ajax', $("#addform").serialize(), function(result) {
        	$("#parseResult").html(result);
        });
    });
}
function checkTime(i)
{
	if (i < 10)
    {
    	i = "0" + i;
    }
    return i;
}
function pageScript() {
	var id, sizes, position1;
	var context = $("#context").text().trim();
	var a = "http://" + window.location.host;
	var b = "/css/copy_csv_xls_pdf.swf";
	var c = a.concat(context);
	var n = c.concat(b);
	var oTable1 = $('#planCall')
			.dataTable(
					{
						"sDom" : "<'row'<'col-xs-4'l><'col-xs-4'f><'col-xs-4'T>r>t<'row'<'col-xs-4 customTool'><'col-xs-4'i><'col-xs-4'p>>",
						"aaSorting" : [ [ 0, "asc" ] ],
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
	var oTable2 = $('#planNotCall')
	.dataTable(
			{
				"sDom" : "<'row'<'col-xs-4'l><'col-xs-4'f><'col-xs-4'T>r>t<'row'<'col-xs-4 customTool'><'col-xs-4'i><'col-xs-4'p>>",
				"aaSorting" : [ [ 0, "asc" ] ],
				"oLanguage": {
					"sSearch" : "Хайх:",
					"sShow": "Харах",
		            "oPaginate": {
		                "sFirst": "Эхний ",
		                "sPrevious": "Өмнөх", 
		                "sNext": "Дараах",
		                "sLast": "Сүүлийн"
		               
		            },
		            "sEmptyTable": "Өгөгдөл байхгүй байна",
					"sInfoEmpty": "0 өгөгдөл харагдаж байна",
					"sInfo": "_START_ -с  _END_ нийт _TOTAL_ байна ",
					"sLengthMenu": "_MENU_ Харах боломжтой",
					"sZeroRecords": "Ямар ч өгөгдөл олдсонгүй",
					"sInfoFiltered": "(Нийт  _MAX_ өгөгдөл байна)",
					"sLoadingRecords": "ачаалалж байна...",
					"sProcessing": "Боловсруулж..."
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
	/*$("#planCall tbody tr").click(function(e) {
		position1 = oTable1.fnGetPosition(this);
		setTime();
		if ($(this).hasClass('success')) {
			$(this).removeClass('success');
		} else {
			oTable1.$('tr.success').removeClass('success');
			$(this).addClass('success');
		}
	});*/
/*	$("#planCall tbody tr").dblclick(function(e) {
		position1 = oTable1.fnGetPosition(this);
		var id = oTable1.fnGetData(position1)[0];
		window.location = "show-plan?model.id=" + id;
	});*/
	
	$("#operatorCallBtn").click(function(e){
		e.preventDefault();
		var id = oTable2.fnGetData(0)[0];
		window.location = "show-plan?model.id=" + id;
	});
	

	function fnGetSelected(oTableLocal) {
		return oTableLocal.$('tr.success');
	}
}

	function autoSearch(){
		setTimeout(function() {
			var status = $("#status_id").val();
			if(status == 2){
				$.ajax({
					url : 'search-ajax-auto',
					success : function(result) {
						if(result.trim()!=""){
						$("#parseResult").html(result);
						$("#status_id").val("");
						}else{
							$("#parseResult").html("<div class = 'row' style='text-align: center;font-size: 15px;color: red'>Хэрэглэгч бүртгэлгүй байна!!!</div>");
						}
					}
				});
			autoSearch();
			}
	}, 1000);
}
