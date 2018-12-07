function initMap() {
	// The location of center
	var center = {lat: 35.656418, lng: 139.699598};
	// The map, centered at center
	var map = new google.maps.Map(
		document.getElementById('mp-spot-map'), {zoom: 15, center: center});
	// The marker, positioned at center
  var marker = new google.maps.Marker({position: center, map: map});
}









