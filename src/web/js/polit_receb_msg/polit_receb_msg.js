$(function() {
    $('#mensagem_individual').click(function(){
        $('#frequencia').hide();
    });

    $('#mensagem_agrupada').click(function(){
        $('#frequencia').show();
    });

    $('.btn.btn-primary').click(function(){
        $('.alert.alert-success').show();
    });
});