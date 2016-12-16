<%@ include page = "default/cabecalho.jsp" %>

<div class="form-group" >
    <label>
      <div class="titulo-checkbox">
        <font size="6">Executar consultas</font>
      </div>
    </label>

    <div class="checkbox">
        <label>
            <input type="checkbox" value=""><font size="4">Consultas pré-definidas</font>
        </label>
    </div>
    <div class="paragrafo-checkbox">
    <p>Consultas pré-definidas são consultas geralmente realizadas com muita frequência, gravadas para facilitar o acesso do usuário à informação. Usuários com essa permissão não poderão criar consultas pré-definidas, mas poderâo executar qualquer consulta que já estiver registrada</p>
    </div>
    <div class="checkbox">
        <label>
            <input type="checkbox" value=""><font size="4">Consultas ad-hoc</font>
    </div>
    <div class="paragrafo-checkbox">
    <p>Consultas ad-hoc são uma forma de montar consultas pela interface. Usuários com esta permissão poderão montar qualquer consulta, recebendo ou não parâmetros</p>
    </div>
</div>

<div class="form-group" >
    <label>
      <div class="titulo-checkbox">
        <font size="6">Dados de Egressos</font>
      </div>
    </label>

    <div class="checkbox">
        <label>
            <input type="checkbox" value=""><font size="4">Editar dados de Egresso</font>
        </label>
    </div>
    <div class="paragrafo-checkbox">
    <p>Usuário com esta permissão pode editar os dados dos Egressos (Apenas relacionados à UFG)</p>
    </div>

    <div class="checkbox">
        <label>
            <input type="checkbox" value=""><font size="4">Editar todos os dados de Egresso</font>
        </label>
    </div>
    <div class="paragrafo-checkbox">
    <p>Usuário com esta permissão pode editar todos os dados dos Egressos</p>
    </div>

    <div class="checkbox">
        <label>
            <input type="checkbox" value=""><font size="4">Adicionar Egresso no sistema</font>
        </label>
    </div>
    <div class="paragrafo-checkbox">
    <p>Concede a permissão de adicionar novos Egressos ao sistema</p>
    </div>

</div>

<div class="form-group" >
    <label>
      <div class="titulo-checkbox">
        <font size="6">Acesso à notícias</font>
        </div>
    </label>

    <div class="checkbox">
        <label>
            <input type="checkbox" value=""><font size="4">Cadastrar notícias</font>
        </label>
    </div>
    <div class="paragrafo-checkbox">
    <p>Concede permissão apenas para cadastrar notícias</p>
    </div>
    <div class="checkbox">
        <label>
            <input type="checkbox" value=""><font size="4">Receber notícias</font>
    </div>
    <div class="paragrafo-checkbox">
      <p>Permite ao usuário apenas ler e receber as notícias cadastradas
    </div>
</div>


<%@ include page = "default/cabecalho.jsp" %>
