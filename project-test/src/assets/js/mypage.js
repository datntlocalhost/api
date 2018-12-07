$(function(){
	var parent;
	var parentID;
	//modal
	$(document).on('click', '.modal-trigger', function(event) {
		event.preventDefault();
		var target = '#' + $(this).attr('data-modal-target');
		$(target).iziModal('open');
	});
	$('.modal-init').iziModal({
		width: 640,
		overlayColor: 'rgba(0,0,0,.7)',
		radius: 0,
		bodyOverflow: true,
		focusInput: false,
		zindex: 10001,
	});
	$(document).on('click', '.crop-trigger', function(){
		var cropParent = '[data-modal-target="' + $(this).attr('data-modal-target') + '"]';
		var cropParentID = '#' + $(this).attr('data-modal-target');
		parent = cropParent;
		parentID = cropParentID;
		//console.log(parent,parentID);
	});
	//cropper
	var image = '.crop-img-select'; 
	// 初期設定
	var options =
			{
				dragMode: 'move', // 画像を動かす設定
				aspectRatio: 1 / 0.667, //アスペクト比
				viewMode: 0,
				//minContainerHeight: 450,
				minCropBoxWidth: 450,
				minCropBoxHeight: 300,
				background: false,
				guides: false,
				zoomOnTouch: false,
				zoomOnWheel: false,
				cropBoxMovable: false,
				cropBoxResizable: false,
				crop: function(e) {
					cropData = $(image).cropper("getData");
					$("#upload-image-x").val(Math.floor(cropData.x));
					$("#upload-image-y").val(Math.floor(cropData.y));
					$("#upload-image-w").val(Math.floor(cropData.width));
					$("#upload-image-h").val(Math.floor(cropData.height));
					$("#upload-image-r").val(Math.floor(cropData.rotate));
				}
			}
	// 初期設定2
	var options2 =
			{
				dragMode: 'move', // 画像を動かす設定
				aspectRatio: 1 / 1, //アスペクト比
				viewMode: 0,
				//minContainerHeight: 450,
				minCropBoxWidth: 300,
				minCropBoxHeight: 300,
				background: false,
				guides: false,
				zoomOnTouch: false,
				zoomOnWheel: false,
				cropBoxMovable: false,
				cropBoxResizable: false,
				crop: function(e) {
					cropData = $(image).cropper("getData");
					$(".upload-image-x").val(Math.floor(cropData.x));
					$(".upload-image-y").val(Math.floor(cropData.y));
					$(".upload-image-w").val(Math.floor(cropData.width));
					$(".upload-image-h").val(Math.floor(cropData.height));
					$(".upload-image-r").val(Math.floor(cropData.rotate));
				}
			}
	// 拡大縮小
	$('.crop-zoom').on('click', function(){
		$(parentID).find(image).cropper('zoom', 0.1);
	});
	$('.crop-unzoom').on('click', function(){
		$(parentID).find(image).cropper('zoom', -0.1);
	});
	// 削除
	$('.crop-erase').on('click', function(){
		$(parentID).find('.cropper-canvas img').remove();
		$(parentID).find('.cropper-view-box img').remove();
		$(parent).find('.crop-img-area').hide();
	});
	$(".crop-upload").on('change', function(){
		// ファイル選択変更時に、選択した画像をCropperに設定する
		$(parentID).find(image).cropper('replace', URL.createObjectURL(this.files[0]));
	});
	
	$('.crop-sq-wrap .crop-trigger').on('click', function() {
		// 初期設定をセットする
		$(image).cropper(options);
	});
	$('.crop-circle-wrap .crop-trigger').on('click', function() {
		// 初期設定をセットする
		$(image).cropper(options2);
	});
	//保存ボタン押下で該当の場所に切り抜いた画像を表示
	$('.getcropped').on('click', function(){
		var imageData = $(parentID).find(image).cropper('getCroppedCanvas').toDataURL();
		$(parent).find('.crop-img-area').attr('src', imageData);
		$(parent).find('.crop-img-area').show();
	});
	
	//accordion
	$(document).on('click', '.list-slide-trigger', function(){
		//$('.list-slide-body').slideToggle();
		$('.list-slide-body').toggleClass('is-open');
		$(this).toggleClass('is-open');
	});
	
	//rating
	var nowchecked = [];
	$('.rating-input-btn:checked').each(function(){
		nowchecked.push( $(this).attr('id') );
	});
	$('.rating-input-btn').on('click', function(){
		var idx = $.inArray( $(this).attr('id'), nowchecked ); // nowcheckedにクリックされたボタンのidが含まれるか判定。なければ-1が返る。
		if( idx >= 0 ) { // クリックしたボタンにチェックが入っていた場合
			$(this).prop('checked', false); // チェックを外す
			nowchecked.splice(idx,1); // nowcheckedからこのボタンのidを削除
		} else { // チェックが入っていなかった場合
		// 同じname属性のラジオボタンをnowcheckedから削除する
			var name = $(this).attr('name');
			$('input[name="' + name + '"]').each(function(){
				var idx2 = $.inArray( $(this).attr('id'), nowchecked);
				if( idx2 >= 0 ){
					nowchecked.splice(idx2,1);
				}
			});
			// チェックしたものをnowcheckedに追加
			nowchecked.push( $(this).attr('id') );
		}
	});
	
	//tr link
	$('.mp-list-table tr[data-href]').addClass('clickable').click( function() {
		window.location = $(this).attr('data-href');
	}).find('a').hover( function() {
		$(this).parents('tr').unbind('click');
	}, function() {
		$(this).parents('tr').click( function() {
			window.location = $(this).attr('data-href');
		});
	});
	
	//chat
	$(window).on('load resize', function(){
		var windowH = $(window).innerHeight();
		var headerH = $('#global-header').outerHeight();
		var pageheadrH = $('#page-header').outerHeight();
		var chatheaderH = $('#chat-header').outerHeight();
		var chatfooterH = $('#chat-footer').outerHeight();
		var chatbackH =$('#chat-back').outerHeight(true);
		var chatH = windowH - (headerH + pageheadrH + chatheaderH + chatfooterH + chatbackH);
		
		//console.log(headerH,pageheadrH,chatfooterH,chatbackH);
		$('#chat-body').css({
			'min-height': chatH + 'px',
		});
		$('#chat-wrap').css({
			'padding-bottom':  chatfooterH+ 'px',
		});
	});
	
	var $chatTA = $('#chat-input');
	var chatMaxH = 14 * 1.5 * 4;
	//$chatTA.height(30);//init
	//$chatTA.css("lineHeight","1.5");//init
	$chatTA.on("input",function(evt){
		if(evt.target.scrollHeight > evt.target.offsetHeight) {   
			$(evt.target).height(evt.target.scrollHeight);
			if(evt.target.offsetHeight > chatMaxH) {
				$chatTA.css({
					height: chatMaxH
				});
			}
		} else {          
			var lineHeight = Number($(evt.target).css("lineHeight").split("px")[0]);
			while (true){
				$(evt.target).height($(evt.target).height() - lineHeight); 
				if(evt.target.scrollHeight > evt.target.offsetHeight){
					$(evt.target).height(evt.target.scrollHeight);
					break;
				}
			}
		}
	});
});
