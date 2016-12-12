$(function() {
    $('.btn.btn-success').click(function(){
    	$('.btn').prop("disabled",true);
    	$('#reprovar').hide();
        $('.alert.alert-success').show();
    });
});