$(function() {
	$('#spot-slider').slick({
		arrows: true,
		dots: false,
		rows: 0,
		responsive: [
			{
				breakpoint: 576,
				settings: {
					arrows: false,
					dots: true,
					rows: 0,
				}
			}
		]
	});
	$('#spot-favorite').on('click', function(){
		$(this).toggleClass('is-selected');
	});
});

function initMap() {
	var center = {lat: 35.656418, lng: 139.699598};
	var map = new google.maps.Map(
		document.getElementById('spot-map'), {zoom: 15, center: center});
	var marker = new google.maps.Marker({
		position: center,
		map: map
	});
}