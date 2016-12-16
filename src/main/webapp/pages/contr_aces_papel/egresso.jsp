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
        <font size="6">Alterar dados</font>
      </div>
    </label>

    <div class="checkbox">
        <label>
            <input type="checkbox" value=""><font size="4">Editar dados de usuário</font>
        </label>
    </div>
    <div class="paragrafo-checkbox">
    <p>Usuário com esta permissão pode editar seus dados, exceto dados de cursos da UFG </p>
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