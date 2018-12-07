$(function() {
	$(window).on('load resize', function(){
		var windowW = $(window).innerWidth();
		if(windowW < 577){
			var headerH = $('#global-header').innerHeight();
			$('#global-header').next().css('margin-top', headerH + 'px');
		} else {
			$('#global-header').next().css('margin-top', 0);
			//pagetop
			var topBtn = $('#pagetop');
			topBtn.hide();
			$(window).scroll(function () {
				if ($(this).scrollTop() > 100) {
					topBtn.fadeIn();
				} else {
					topBtn.fadeOut();
				}
			});
			topBtn.click(function () {
				$('body,html').animate({
					scrollTop: 0
				}, 500);
				return false;
			});
		}
	});
	//smooth scroll
	$('a[href^="#"]').on('click', function(){
		var windowW = $(window).innerWidth();
		var speed = 500;
		var href= $(this).attr("href");
		var target = $(href == "#" || href == "" ? 'html' : href);
		var headerH = $('#global-header').innerHeight();
		var targetPos = target.offset().top
		if(windowW >= 577){
			var position = targetPos;
		} else{
			var position = targetPos - headerH;
		}
		$("html, body").animate({scrollTop:position}, speed, "swing");
		return false;
  });
	//accordion
	$('.slide-trigger').on('click', function(){
		$(this).next('.slide-body').slideToggle();
		$(this).toggleClass('is-open');
	});
	//datepicker
	$.datepicker.setDefaults({
		showButtonPanel: true,
		beforeShow: function(input, inst) {
			var calendar = inst.dpDiv;
			setTimeout(function() {
				calendar.position({
					my: 'right top',
					at: 'right bottom',
					of: input
				});
				var buttonPane = $(input).datepicker('widget').find('.ui-datepicker-buttonpane');
				$('<button>', { text: 'クリア',click: function() {
					$.datepicker._clearDate(input);
				}}).appendTo( buttonPane ).addClass('ui-datepicker-current ui-state-default ui-priority-secondary ui-corner-all');
			}, 1);
		},
		onChangeMonthYear: function(year, month, instance) {
			setTimeout(function() {
				var buttonPane = $(instance).datepicker('widget').find('.ui-datepicker-buttonpane');
				$('<button>', {text: 'クリア',click: function() {
					$.datepicker._clearDate(instance.input);
				}}).appendTo( buttonPane ).addClass('ui-datepicker-current ui-state-default ui-priority-secondary ui-corner-all');
			}, 1);
		}
	});
	$('.datepicker').datepicker();
	$('.datepicker-from').datepicker({
		/*minDate: 0,
		onSelect: function (selectedDate) {
			var option = 'minDate';
			$('.datepicker-to').datepicker('option', option, selectedDate);
		},*/
	});
	$('.datepicker-to').datepicker({
		/*minDate: 0,
		onSelect: function (selectedDate) {
			var option = 'maxDate';
			$('.datepicker-from').datepicker('option', option, selectedDate);
		}*/
	});
	//drawer
	$('.drawer-trigger').on('click', function(){
		$('#drawer-wrap').toggleClass('is-open');
	});
	//refine
	$('.refine-trigger').on('click', function(){
		$('.refine-slide-body').slideToggle();
		$('.refine-trigger').toggleClass('is-open');
	});
	//rating
	$('.rating-star').each(function(){
		var rating = $(this).data('rating') * 20;
		$(this).css('width', rating + '%');
	});
});















