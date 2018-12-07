$(function() {
	//tooltip
	tippy('.tooltip-trigger',{
		placement: 'bottom',
		arrow: 'true',
		theme: 'custom bike-user',
		//trigger: 'click'
	});
	//trunk
	$('.card-title').trunk8({
		lines: 2
	});
	//accordion
	$('#review-slide-body').hide();
	$('#review-slide-trigger').on('click', function(){
		$('#review-slide-body').slideToggle();
		$(this).toggleClass('is-open');
	});
});