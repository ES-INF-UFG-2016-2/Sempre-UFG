var navbarDropdowns = {
    usuario: "<a class='dropdown-toggle' data-toggle='dropdown' href='#'>" +
    "<i class='fa fa-user fa-fw'></i> <i class='fa fa-caret-down'></i>" +
    "</a>" +
    "<ul class='dropdown-menu dropdown-user'>" +
    "<li>" +
    "<a href='../atualizar_egresso/dados_pessoais.jsp'><i class='fa fa-user fa-fw'></i> Minha Conta</a>" +
    "</li>" +
    "<li class='divider'></li>" +
    "<li>" +
    "<a href='#'><i class='fa fa-sign-out fa-fw'></i> Sair</a>" +
    "</li>" +
    "</ul>"
};

var navbarSideMenus = {
    consultas: "<li>" +
    "<a href='#'><i class='fa fa-search fa-fw'></i> Consultas<span class='fa arrow'></span></a>" +
    "<ul class='nav nav-second-level'>" +
    "<li>" +
    "<a href='../consultas/nova-consulta'>Nova Consulta</a>" +
    "</li>" +
    "<li>" +
    "<a href='#'>Planilha Egresso</a>" +
    "</li>" +
    "<li>" +
    "<a href='#'>Mapa com Resultados</a>" +
    "</li>" +
    "</ul>" +
    "</li>",
    informacoes: "<li>" +
    "<a href='#'><i class='fa fa-info-circle fa-fw'></i> Informações<span class='fa arrow'></span></a>" +
    "<ul class='nav nav-second-level'>" +
    "<li>" +
    "<a href='#'>Notícias</a>" +
    "</li>" +
    "<li>" +
    "<a href='#'>Eventos e Oportunidades</a>" +
    "</li>" +
    "</ul>" +
    "</li>",
    apoio: "<li>" +
    "<a href='#'><i class='fa fa-question-circle fa-fw'></i> Apoio ao Usuário<span class='fa arrow'></span></a>" +
    "<ul class='nav nav-second-level'>" +
    "<li>" +
    "<a href='#'>Ajuda Online</a>" +
    "</li>" +
    "<li>" +
    "<a href='#'>Manuais</a>" +
    "</li>" +
    "<li>" +
    "<a href='#'>FAQs</a>" +
    "</li>" +
    "</ul>" +
    "</li>",
    log: "<li>" +
    "<a href='#'><i class='fa fa-bar-chart'></i> Dados e estatísticas<span class='fa arrow'></span></a>" +
    "<ul class='nav nav-second-level'>" +
    "<li>" +
    "<a href='/pages/config_log/log_operacoes.jsp'><i class='fa fa-table'></i> Log do banco de dados</a>" +
    "</li>" +
    "<li>" +
    "<a href='/pages/config_log/configuracao_log.jsp'><i class='fa fa-wrench'></i> Configuração do log</a>" +
    "</li>" +
    "</ul>" +
    "</li>",
    administracao: "<li>" +
    "<a href='#'><i class='fa fa-cogs fa-fw'></i> Administração<span class='fa arrow'></span></a>" +
    "<ul class='nav nav-second-level'>" +
    "<li>" +
    "<a href='#'>Cadastrar Notícias, Eventos e Oportunidades</a>" +
    "</li>" +
    "<li>" +
    "<a href='#'>Configurar Papéis de Usuários</a>" +
    "</li>" +
    "</ul>" +
    "</li>"

};

var loggedInUserDropdowns = ["usuario"];
var loggedInUserRoles = ["consultas", "informacoes", "apoio", "log", "administracao"];

$(document).ready(function () {

    loadNavbar();
    loadSideMenus();

});

function loadNavbar() {

    var html = "";

    for (var dropdown in loggedInUserDropdowns) {
        html += navbarDropdowns[loggedInUserDropdowns[dropdown]];
    }

    $('#upper-dropdowns').html(html);
}


function loadSideMenus() {

    var html = "";

    for (var menu in loggedInUserRoles) {
        html += navbarSideMenus[loggedInUserRoles[menu]];
    }

    $('#side-menu').html(html);
}

