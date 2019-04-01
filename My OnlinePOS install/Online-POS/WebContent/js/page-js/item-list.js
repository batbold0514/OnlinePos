jQuery(function($) {
	initDialog();
	initList();
	initAssetAcc();
	initUnits();
	addItem();
	$("#btnAdd").click(function(e){
		$("#addItemsDialog").dialog("open");
	});
});
function addItem(){
	$('#addform').validate({
		rules: {
        	quantity:"required", 
        	assetAcc:"required",
        	unitId:"required",
        	itemName:"required",
        	required:"required",
        	price:"required",
        	description:"required",
        },
        messages:{
    		quantity:"Хоосон байна",
    		assetAcc:"Хоосон байна",
    		unitId:"Хоосон байна",
    		itemName:"Хоосон байна",
    		required:"Хоосон байна",
    		price:"Хоосон байна",
    		description:"Хоосон байна"
        		
    	},submitHandler: function () { 
    		var as = JSON.stringify($("#assetAccounts").val());
    		var obj = new Object();
    		obj.quantity = $("#quantity").val();
    		obj.itemName = $("#itemName").val();
    		obj.units = $("#units").val();
    		obj.price = $("#price").val();
    		obj.description = $("#description").val();
    		obj.assetAcc = as;
    		console.log(obj);
    		$.ajax({
    				url: 'add-item-setup', 
    				data:
    				{
		    			"quantity": $("#quantity").val(),
		        		"itemName": $("#itemName").val(),
		        		"unitId": $("#units").val(),
		        		"price": $("#price").val(),
		        		"description": $("#description").val(),
		        		"assetAcc": as
					}, 
					success: function(result) {
	    			switch(result){
	    				case "200":
	    					successMessage();
	    					$('#addform').trigger("reset");
	    					dt.fnReloadAjax();
	    					$("#addItemsDialog").dialog("close");
	    					break;
	    				case "201":alert( +" уг тасагт бүртгэлтэй байна");
							break;
	    				case "404":alert($("#itemName").val() +" ийм нэртэй бараа бүртгэлтэй байна");
							break;
						default:
							alert(result);
	    			}
				}
    		});
    	}
	});
}
var position1,dt;
function initList(){
	$("#mainTable tbody tr").click(function(e) {
		position1 = oTable1.fnGetPosition(this);
//		id1 = oTable1.fnGetData(position1)[0];
//		duration= oTable1.fnGetData(position1)[1];
		console.log(position1);
		if ($(this).hasClass('success')) {
			$(this).removeClass('success');
		} else {
			oTable1.$('tr.success').removeClass('success');
			$(this).addClass('success');
		}
	});
	dt = $('#mainTable').dataTable({
		"sDom" : "<'row'<'col-xs-4'l><'col-xs-4'f><'col-xs-4'T>r>t<'row'<'col-xs-4 customTool'><'col-xs-4'i><'col-xs-4'p>>",
//		bServerSide: true,
		"iDisplayLength" : 10,
		"oLanguage" : {
			"sUrl" : "localisation/dataTable.mn.txt"
		},
        "sAjaxSource":"item-list-ajax",
        "aoColumns": [
              { "mData": "num","bVisible":    false },
              { "mData": "id" ,"bVisible":    false},
              { "mData": "name" },
              { "mData": "description" },
              { "mData": "item_unit_id" ,"bVisible":    false},
              { "mData": "item_unit_name" },
              { "mData": "asset_acc" },
              { "mData": "quantity" },
              { "mData": "price" },
           ]

	});
}
function initUnits(){
	$.ajax({
		url: "get-units",
		success: function(result)
		{
			$("#units").html(result);
		}
	});
	$("#units").select2();
}
function initAssetAcc(){
	$.ajax({
		url: "get-asset-accounts",
		success: function(result)
		{
			$("#assetAccounts").html(result);
		}
	});
	$("#assetAccounts").select2();
}
function initDialog()
{
	$("#addItemsDialog").dialog({
		width: 450,
		modal: true,
		autoOpen: false,
		title: "Нэмэх",
		open: function(event, ui) {  
			$("#units").select2();
			$("#assetAccounts").select2();
		},
		buttons: [ 
			{
				html: "<i class='fa fa-times bigger-110'></i>&nbsp; Болих",
				"class" : "btn btn-danger",
				click: function() {
					$( this ).dialog( "close" );
				}
			},
			{
				html: "<i class='fa fa-save bigger-110'></i>&nbsp; Хадгалах",
				"class" : "btn btn-success",
				click: function() {
					var dialog = this;
					$("#addform").submit();
				}
			}
		]});
	$("#logoutDialog").dialog(
			{
				title: "Гарах",
				title_html: true,
				autoOpen: false,
				modal: true,
				buttons:[ 
						{
							html: "<i class='icon-off bigger-110'></i>&nbsp; Гарах",
							"class" : "btn btn-danger btn-xs ",
							"id" : "btnok",
								click: function() {
									window.location = "logout";
								}
							},
							{
							html: "<i class='icon-remove bigger-110'></i>&nbsp; Болих",
							"class" : "btn btn-success btn-xs",
							"id" : "btnCncl",
								click: function() {
									$(this).dialog("close");
								}
							}
				         ]
			});
}

function successMessage() {
	$.gritter.add({
		title : 'тайлбар',
		text : 'Амжилттай хадгаллаа',
		sticky : false,
		time : '1000'
	});
}