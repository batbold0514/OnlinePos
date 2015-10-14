$(document).ready(function()
{
	checkPage();
});
function checkPage(){
	var page = $("#page").text().trim();
	if (page != null || page != "")
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