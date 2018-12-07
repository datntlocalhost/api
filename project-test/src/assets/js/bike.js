$(function() {
	$('#bike-img-slider').slick({
		//autoplay: true,
		arrows: true,
		dots: false,
		centerMode: true,
		variableWidth: true,
		rows: 0,
		appendArrows: $('#bike-img-arrow'),
		responsive: [
			{
				breakpoint: 576,
				settings: {
					arrows: false,
					dots: true,
					centerMode: false,
					centerPadding: 0,
					rows: 0,
					variableWidth: false,
				}
			}
		]
	});
	//calendar
	$('#bike-calendar').slick({
		//autoplay: true,
		arrows: true,
		dots: false,
		//centerMode: true,
		variableWidth: true,
		slidesToShow: 2,
		slidesToScroll: 1,
		infinite: false,
		adaptiveHeight: true,
		rows: 0,
		appendArrows: $('#bike-calendar-arrow'),
		responsive: [
			{
				breakpoint: 576,
				settings: {
					slidesToShow: 1,
					
				}
			}
		]
	});
	$(window).on('load resize',function(){
		var windowW = $(window).innerWidth();
		if(windowW < 577){
			var containerW = $('#bike-calendar').innerWidth();
			$('.calendar').css('width', containerW + 'px');
		} else {
			$('.calendar').removeAttr('style');
		}
	});
	//tooltip
	tippy('.tooltip-trigger',{
		placement: 'bottom',
		arrow: 'true',
		theme: 'custom',
		//trigger: 'click'
	});
	//accordion
	$('#review-slide-body').hide();
	$('#review-slide-trigger').on('click', function(){
		$('#review-slide-body').slideToggle();
		$(this).toggleClass('is-open');
	});
});






//map
var circleOptions = null;
function initMap() {
	// 初期設定
	var mapdiv = document.getElementById('bike-map');
	// 新宿駅
	var center_latlng = new google.maps.LatLng(35.660522, 139.689288);
	var options = 
			{
				// ズーム倍率
				zoom : 17, 
				// 地図中央の緯度・経度（新宿駅）
				center : center_latlng,
				// 地図タイプ
				mapTypeId : google.maps.MapTypeId.ROADMAP 
			};
	map = new google.maps.Map(mapdiv, options);
	var circleOptions = { 
		center: center_latlng,  // 中心点(google.maps.LatLng)
		fillColor: '#a2f412',   // 塗りつぶし色
		fillOpacity: 0.6,       // 塗りつぶし透過度（0: 透明 ⇔ 1:不透明）
		map: map,               // 表示させる地図（google.maps.Map）
		radius: 100,           // 半径（ｍ）
		strokeColor: '#8dd908', // 外周色
		strokeOpacity: 1,       // 外周透過度（0: 透明 ⇔ 1:不透明）
		strokeWeight: 2         // 外周太さ（ピクセル）
	};
	// 丸を設定
	circleObj = new google.maps.Circle(circleOptions); 
}













