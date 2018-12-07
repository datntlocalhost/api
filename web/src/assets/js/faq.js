$(function() {
	$('.faq-menu-item').on('click',function(){
		var $th = $(this).index();
		$('.faq-body.is-active').fadeOut('fast', function(){
			$(this).removeClass('is-active')
			$('.faq-body').eq($th).fadeIn('fast').addClass('is-active');
		});
	});
});

