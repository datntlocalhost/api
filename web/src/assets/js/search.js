$(function() {
	$(window).on('load resize',function(){
		var windowW = $(window).innerWidth();
		var windowH = $(window).innerHeight();
		var headerH = $('#global-header').innerHeight();
		if(windowW > 577){
			$('#search-wrap').css('height', windowH - headerH + 'px');
		} else {
			$('#search-wrap').css('height', 'auto');
		}
	});
});

//map
var infoWindow = [],
		marker = [],
		map = {},
		markers = [];

function initMap() {
	var centerPos = new google.maps.LatLng(35.695934, 139.762177);
	var myOptions = {
		zoom: 15,
		center: centerPos,
		scrollwheel: false,
		mapTypeId: google.maps.MapTypeId.ROADMAP
	}
	var map = new google.maps.Map(document.getElementById("search-map"), myOptions);
	
	var set = google.maps.InfoWindow.prototype.set;
	google.maps.InfoWindow.prototype.set = function(key, val) {
		if (key === "map") {
			if (! this.get("noSuppress")) {
				return;
			}
		}
		set.apply(this, arguments);
	}

	markers = [{
		num: 1,
		name: '自転車1',
		lat: 35.6954806,
		lng: 139.76325010000005,
		price: '¥3,000',
		ward: '渋谷区',
		img: '../assets/img/bike/bike8.jpg',
		avatar: '../assets/img/user/user-avatar.jpg',
	}, {
		num: 2,
		name: '自転車2',
		lat: 35.6951212,
		lng: 139.76610649999998,
		price: '¥4,700',
		ward: '渋谷区',
		img: '../assets/img/bike/bike11.jpg',
		avatar: '../assets/img/user/user-avatar.jpg',
	}, {
		num: 3,
		name: '自転車3',
		lat: 35.69496,
		lng: 139.76746000000003,
		price: '¥5,000',
		ward: '渋谷区',
		img: '../assets/img/bike/bike12.jpg',
		avatar: '../assets/img/user/user-avatar2.jpg',
	}, {
		num: 4,
		name: '自転車4',
		lat: 35.6993529,
		lng: 139.76526949999993,
		price: '¥4,500',
		ward: '渋谷区',
		img: '../assets/img/bike/bike7.jpg',
		avatar: '../assets/img/user/user-avatar2.jpg',
	}, {
		num: 5,
		name: '自転車5',
		lat: 35.695932,
		lng: 139.75762699999996,
		price: '¥4,000',
		ward: '渋谷区',
		img: '../assets/img/bike/bike3.jpg',
		avatar: '../assets/img/user/user-avatar.jpg',
	}, {
		num: 6,
		name: '自転車6',
		lat: 35.696932,
		lng: 139.76543200000003,
		price: '¥3,500',
		ward: '渋谷区',
		img: '../assets/img/bike/bike2.jpg',
		avatar: '../assets/img/user/user-avatar2.jpg',
	}];

	markers.forEach(function( val, i ){
		var markerLatLng = {lat: markers[i].lat, lng: markers[i].lng};
		
		var infoitem = '<div class="map-overlay-wrap"><div class="map-ol-inner"><div class="map-ol-unit"><div class="map-ol-img"><img src="' + markers[i].img + '" class="img-fluid" ></div><div class="map-ol-info"><div class="user-avatar"><img alt="" src="' + markers[i].avatar + '" class="img-fluid"></div><div class="map-ol-item"><p class="map-ol-title">' + markers[i].name + '</p><p class="map-ol-detail">' + markers[i].price + '<span>' + markers[i].ward + '</span></p></div></div></div></div></div>';
		var infooption = {
			content: infoitem,
			pixelOffset: new google.maps.Size(-125, -30),
			alignBottom: true,
			position: markerLatLng,
			boxClass: "gmap-info-window",
			closeBoxMargin: "0",
			disableAutoPan: false,
		};
		
		marker[i] = new MarkerWithLabel({
			map: map,
			position: markerLatLng,
			icon:{
				url: ' ',
			},
			labelContent: '<span class="map-label-inner">' + markers[i].price + '</span>',
			labelAnchor: new google.maps.Point(28, 30),
			labelClass: 'map-label',
			labelStyle: {opacity: 1} ,
		});
		
		infoWindow[i] = new InfoBox(infooption);
		
		/*google.maps.event.addListener(marker[i],'mouseover', function () {
			infoWindow[i].open(map, marker[i]);
		});
		google.maps.event.addListener(marker[i],'mouseout', function () {
			infoWindow[i].close();
		});*/
		
		markerEvent(i);
		function closeInfoWindow() {
			for (var i = 0; i < markers.length; i++) {
				infoWindow[i].close(map, marker[i]);
			}
		}
		function markerEvent(i) {
			marker[i].addListener('click', function() {
				closeInfoWindow();
				infoWindow[i].open(map, marker[i]);
			});
		}
	});
	
	$('.marker-trigger').on('mouseover',function(){
		for (var i = 0; i < markers.length; i++) {
			infoWindow[i].close();
			if(markers[i].num == $(this).attr("data-markerNum")) {
				infoWindow[i].open(map, marker[i]);
			}
		}
	});
	$('.marker-trigger').on('mouseout',function(){
		for (var i = 0; i < markers.length; i++) {
			infoWindow[i].close();
		}
	});
}
window.onload = initMap;


















