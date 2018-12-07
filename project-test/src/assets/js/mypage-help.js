function initMap() {
	var center = {lat: 35.656418, lng: 139.699598};
	var map = new google.maps.Map(
		document.getElementById('mp-help-map'), {
			zoom: 15,
			center: center
		});
  var marker = new google.maps.Marker({position: center, map: map});
}









