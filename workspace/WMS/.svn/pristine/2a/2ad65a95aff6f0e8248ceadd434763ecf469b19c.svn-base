$(document).ready(function()
{
	$(".focus").focus();
	checkPage();
	menuSelector();

	$("#mainTable_info").addClass("text-muted small");
	
	checkTableSize();
	$(window).resize(function()
	{
		checkTableSize();
	});

	$("#mainPanel").resizable(
	{
    	handles: 'e, w'
	});
	
	$("#birthday").datepicker(
	{
		changeMonth: true,
		changeYear: true,
		dateFormat: "yy-mm-dd",
		defaultDate: new Date(1980, 07, 15),
		minDate: "-90y",
		maxDate: "-7y",
		option: $.datepicker.regional["mn"]
	});
	
	$("#menu .panel-heading").css("cursor", "pointer");
	$(".questions .panel-heading").css("cursor", "pointer");
	
	$("#dateRange").datepicker(
			{
				changeMonth: true,
				changeYear: true,
				dateFormat: "yy-mm-dd",
	});
	$("#dateRange1").datepicker(
			{
				changeMonth: true,
				changeYear: true,
				dateFormat: "yy-mm-dd",
	});
	
	$(".errorMessage").parents(".form-group").addClass("has-error");
});

function checkPage()
{
	var page = $("#page").text().trim();
	if (page != null && page != "")
	{
		$("#menu .panel-primary").addClass("panel-default");
		$("#menu .panel-primary").removeClass("panel-primary");
		$("#menu .in").removeClass("in");
		$("#menu li").removeClass("active");
		$("#menu .badge").remove();
		var $pageLi = $("#menu a[href$='" + page + "']").parent();
		$pageLi.addClass("active");
		$pageLi.parent().parent().parent().addClass("in");
		$pageLi.parent().parent().parent().parent().addClass("panel-primary");
		$pageLi.parent().parent().parent().parent().removeClass("panel-default");
		$pageLi.parent().parent().parent().prev().children().children().append('<span class="badge pull-right"><i class="fa fa-thumb-tack"></i></span>');
	}
}

function menuSelector()
{
	$("#menu .panel-heading").click(function()
	{
		$(this).parent().toggleClass("panel-default panel-primary");
		$(this).next().collapse('toggle');
		
		var $clickedPanel = $(this).parent();
		$("#menu > .panel").each(function()
		{
			if ($(this)[0] != $clickedPanel[0])
			{
				$(this).filter(".panel-primary").toggleClass("panel-primary panel-default");
				$(this).children().first().next().filter(".in").collapse("toggle");
			}
		});
	});
}

function checkTableSize()
{
	var wBody = $("#body .panel").width();
	var wTable = $("#mainTable").width() + 20;
	if (wBody <= wTable)
	{
		$("#body .table-responsive").addClass("bh-table-scroll");
	}
	else
	{
		$("#body .table-responsive").removeClass("bh-table-scroll");
	}
}