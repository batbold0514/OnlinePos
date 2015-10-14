var ourCenter = new google.maps.LatLng(47.924832, 106.902278);
function initialize()
{
	var mapProp =
	{
		center: ourCenter,
		zoom: 15,
		mapTypeId: google.maps.MapTypeId.ROADMAP
	};
	var map = new google.maps.Map(document.getElementById("googleMap"), mapProp);
	var marker = new google.maps.Marker(
	{
		position: ourCenter
	});
	marker.setMap(map);
}
google.maps.event.addDomListener(window, 'load', initialize);