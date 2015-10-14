$(document).ready(function()
{
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
		buttons:
		{
			"Хадгалах": function()
			{
				var str = $("#customerName").val();
				$.ajax(
				{
					url: "addCustomerInArticle",
					data:
					{
						"customerName": str
					},
					success: function(result)
					{
						document.getElementById('listCustomers').innerHTML = result;
					}
				});
				$(this).dialog("close");
			},
			"Болих": function()
			{
				$(this).dialog("close");
			}
		},
	});
});