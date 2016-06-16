$('.carousel').carousel({pause: "false"});

function doAnimations(elems) {
	elems.each(function () {
		$animationType = $(this).data('animation');
		setTimeout(function(){
			$(this).addClass($animationType).one('webkitAnimationEnd animationend', function () {
				$(this).removeClass($animationType);
			});
		}, 200);
	});
}

$('.carousel').on('slide.bs.carousel', function (e) { 
	doAnimations($(e.relatedTarget).find("[data-animation ^= 'animated']"));
});