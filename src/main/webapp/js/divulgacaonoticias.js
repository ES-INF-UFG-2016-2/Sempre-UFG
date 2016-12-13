
function obtenhaListaDeEventos() {
    $.ajax({
        url: "/divulgacaonoticia/obtenhaNoticiasParaEnviar",
        dataType: "json",
        success: function(resultado){
            var objetoJson = JSON.parse(resultado);
            $("#corpoPainel").html(obtenhaTabelaEventos(objetoJson));
        },
        error: function (resultado) {
            console.log(resultado);
            $("#corpoPainel").html(obtenhaExcecao());
        }
    });
}

function obtenhaTabelaEventos(eventos) {
    var html = '';
    for(indexEvento in eventos['eventos']){
        var evento = eventos['eventos'][indexEvento];
        html += obtenhaLinhaTabelaEventos(evento)
    }
    if(html == ''){
        html = obtenhaExcecao();
    }else{
        html = obtenhaHTMLTabelaEventos().replace('corpoTabela', html);
    }

    return html
}

function obtenhaHTMLTabelaEventos() {
    return '<table class="table table-striped table-bordered table-hover"> <thead> <tr> <th>Evento</th> <th>Tipo</th> <th>Ações</th> </tr> </thead> <tbody>corpoTabela</tbody> </table>'

}

function obtenhaExcecao() {
    return '<p>Não há solicitações de eventos aprovadas!</p>'
}

function obtenhaLinhaTabelaEventos(evento) {
    return '<tr>' +
            '<td>'+evento['nome']+'</td>'+
            '<td>'+evento['tipo']+'</td>'+
            '<td>'+obtenhaBotoesAcoes(evento['id'])+'</td>'+
        '<\tr>';
}

function obtenhaBotoesAcoes(idEvento) {
    return '<button class="btn btn-default" onclick="enviarNoticia('+idEvento+')" type="button">Enviar</button>'
}

function enviarNoticia(idEvento) {
    $( "#dialog-confirm" ).dialog({
        resizable: false,
        height: "auto",
        width: 400,
        modal: true,
        buttons: {
            "OK": function() {
                $.ajax({
                    url: "/divulgacaonoticia/enviarNoticia",
                    dataType: "json",
                    type: "POST",
                    data: {
                        idEvento : idEvento,
                        dataPublicacao : $("#dataPublicacao").val()
                    },
                    success: function(resultado){
                        $("#rodapePainel").html(mensagemSucesso(resultado))
                    },
                    error: function (resultado) {
                        $("#rodapePainel").html(mensagemErro(resultado))
                    }
                });
            },
            "Cancelar": function() {
                $( this ).dialog("close");
            }
        }
    });
}

function mensagemSucesso($message){
    return '<div class="alert btn-success alert-dismissable"><button type="button" class="close" data-dismiss="alert" aria-hidden="true">×</button>'+ $message + '</div>';
}
function mensagemErro($message){
    return '<div class="alert btn-danger alert-dismissable"><button type="button" class="close" data-dismiss="alert" aria-hidden="true" style="">×</button>'+ $message + '</div>';
}
