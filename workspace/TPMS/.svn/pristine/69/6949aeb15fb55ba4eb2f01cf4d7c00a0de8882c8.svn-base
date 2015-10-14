var last_gritter;
$(document).ready(function()
{
	ajaxSetup();
	checkPage();
});

function checkPage()
{
	var page = $("#page").text().trim();
	if (page != null && page != "")
	{
		$("#menu li").removeClass("active");
		$("#menu li").removeClass("open");
		$("#menu li ul li").removeClass("active");
		var $pageLi = $("#menu a[href$='" + page + "']").parent();
		$pageLi.addClass("active");
		$pageLi.parent().parent().addClass("active");
		$pageLi.parent().parent().addClass("open");
	}
}

function ajaxSetup()
{
	$.widget("ui.dialog", $.extend({}, $.ui.dialog.prototype,
	{
		_title: function(title)
		{
			var $title = this.options.title || '&nbsp;';
			if(("title_html" in this.options) && this.options.title_html == true)
				title.html($title);
			else
				title.text($title);
		}
	}));	
	
	$("#loadingDialog").dialog(
	{
		autoOpen: false,
		modal: true
	});
	
	$("#errorDialog").dialog(
	{
		autoOpen: false,
		modal: true,
		title: "<div class='widget-header header-color-red'><h5><i class='icon-warning-sign'></i>&nbsp;Анхааруулга!</h5></div>",
		title_html: true,
		width: 550,
		buttons:
		[{
			html: "<i class='icon-refresh'></i>&nbsp; Дахин унших",
			"class": "btn btn-success btn-xs",
			click: function()
			{
				window.location.reload(true);
			}
		},
		{
			html: "<i class='icon-remove'></i>&nbsp; Цуцлах",
			"class": "btn btn-xs",
			click: function()
			{
				$(this).dialog("close");
			}
		}]
	});
	
	$.ajaxSetup(
	{
		async: false
	});
	
	$(document).ajaxError(function(event, xhr, options)
	{
		if (xhr.status == 500)
		{
			errorDialog("Серверт алдаа гарсан байна!<br/>Алдааны хүсэлт: " + options.url);
		}
		else if (xhr.status == 400)
		{
			errorDialog("Таны хүсэлт алдаатай байна!<br/>Алдааны хүсэлт: " + options.url);
		}
		else if (xhr.status == 404)
		{
			errorDialog("Сервертэй холбогдохгүй буюу серверээс холболт тасарсан байна!<br/>Алдааны хүсэлт: " + options.url);
		}
		else if (xhr.status == 0)
		{
			errorDialog("Сервер унтарсан эсвэл сүлжээ тасарсан байна!<br/>Алдааны хүсэлт: " + options.url);
		}
		else
		{
			errorDialog("Веб програмд ямар нэгэн алдаа гарлаа!<br/>Алдааны хүсэлт: " + options.url);
		}
	});
}

function errorDialog(message)
{
	$("#errorMessage").html("<strong><i class='icon-remove'></i></strong>&nbsp; " + message);
	$("#errorDialog").dialog("open");
}

function convertBytes(size)
{
	if (size == 0)
		return '0 bytes';
	var sizes = ['bytes', 'KB', 'MB', 'GB', 'TB']
	var i = parseInt(Math.floor(Math.log(size) / Math.log(1024)));
    return Math.round(size / Math.pow(1024, i), 2) + " " + sizes[i];
};