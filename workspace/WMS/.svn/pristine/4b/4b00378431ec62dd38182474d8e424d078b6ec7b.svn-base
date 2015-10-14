$(document).ready(function()
{
	$("#submit").click(function(event)
	{
		$.ajax(
		{
			url : "check-article-min",
			data :
			{
				id : $("#selectedArticle option:selected").val(),
				count : $("#doOutputArticle_outCount").val()
			},
			success : function(result)
			{
				if (result == 0)
				{
					$("#warning-dialog").dialog("open");
				}
				else if (result == -1)
				{
					$("#danger-dialog").dialog("open");
				}
				else
				{
					$("#doOutputArticle").submit();
				}
			}
		});
	});
	
	$("#customerAdd").css('cursor', 'hand');
	$("#customerAdd").click(function(event)
	{
		event.preventDefault();
		$("#add-customer-dialog").dialog("open");
	});
	
	$("#add-customer-dialog").dialog(
	{
		autoOpen : false,
		modal: true,
		buttons :
		[
			{
				text: "Хадгалах",
				click: function()
				{
					var str = $("#customerName").val();
					$.ajax(
					{
						url : "addCustomerInArticle",
						data :
						{
							"customerName" : str
						},
						success : function(result)
						{
							document.getElementById('listCustomers').innerHTML = result;
						}
					});
					$(this).dialog("close");
				}
			},
			{
				text: "Цуцлах",
				click: function()
				{
					$(this).dialog("close");
				}
			}
		]
	});
	
	$("#warning-dialog").dialog(
	{
		autoOpen : false,
		modal : true,
		buttons :
		{
			OK : function()
			{
				$(this).dialog("close");
				$("#doOutputArticle").submit();
			},
			Цуцлах : function()
			{
				$(this).dialog("close");
			}
		}
	});

	$("#danger-dialog").dialog(
	{
		autoOpen : false,
		modal : true,
		buttons :
		{
			OK : function()
			{
				$(this).dialog("close");
				$("#doOutputArticle").submit();
			},
			Цуцлах : function()
			{
				$(this).dialog("close");
			}
		}
	});
	
});