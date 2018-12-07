function initMap() {
	var center = {lat: 35.656418, lng: 139.699598};
	var map = new google.maps.Map(
		document.getElementById('appointment-map-detail'), {
			zoom: 15,
			center: center
		});
  var marker = new google.maps.Marker({position: center, map: map});
	
	var circleOptions = null;
	var mapCircle = document.getElementById('appointment-map-circle');
	var options = 
			{
				zoom : 15, 
				center : center,
			};
	map = new google.maps.Map( mapCircle, options);
	var circleOptions = { 
		center: center,
		fillColor: '#a2f412',
		fillOpacity: 0.6,
		map: map,
		radius: 400,
		strokeColor: '#8dd908',
		strokeOpacity: 1,
		strokeWeight: 2
	};
	circleObj = new google.maps.Circle(circleOptions); 
}









