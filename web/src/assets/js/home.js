$(function() {
	$('#home-slider').slick({
		autoplay: true,
		autoplaySpeed: 5000,
		fade: true,
		arrows: false,
		dots: true,
		slidesToShow: 1,
		slidesToScroll: 1,
		rows: 0,
		asNavFor: '#home-slider-bg',
		pauseOnHover: false,
	});
	$('#home-slider-bg').slick({
		fade: true,
		arrows: false,
		centerMode: true,
		centerPadding: '0',
		slidesToShow: 1,
		slidesToScroll: 1,
		rows: 0,
		asNavFor: '#home-slider',
	});
	$(window).on('load resize', function(){
		var windowW = $(window).innerWidth();
		var windowH = $(window).innerHeight();
		var scrollPosi = 0;
		if(windowW > 576){
			$('#home-slider-wrap').css('height',windowH + 'px');
			$(window).on('scroll', function () {
				scrollPosi = $(document).scrollTop();
				$('#home-slider-bg').stop(true, true).animate({
					'top': -scrollPosi / 3 + 'px'
				}, 100);
			});
		} else {
			$('#home-slider-wrap').css('height', 450 + 'px');
		}
	});
	//banner slider
	$('#home-banner').slick({
		autoplay: true,
		autoplaySpeed: 3000,
		arrows: true,
		slidesToShow: 3,
		slidesToScroll: 1,
		//variableWidth: true,
		rows: 0,
		responsive: [
			{
				breakpoint: 576,
				settings: {
					arrows: false,
					slidesToShow: 1,
					centerMode: true,
					variableWidth: true,
				}
			},
		]
	});
	//trunk
	$('.card-title').trunk8({
		lines: 2
	});
});


