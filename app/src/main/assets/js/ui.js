$('.btn_animation').on('click', function() {
    var $this = $(this);
    $this.find('.dummy_disabled').addClass('ani');
	$this.find('.dummy_active').addClass('ani');

    setTimeout(function() {
		$this.find('.dummy_disabled').removeClass('ani');
		$this.find('.dummy_active').removeClass('ani');
	}, 1000);
})