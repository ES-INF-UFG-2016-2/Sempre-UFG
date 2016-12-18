<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <title>Formulário de Atualização de Dados do Egresso</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
          integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">

    <link class="jsbin" href="http://ajax.googleapis.com/ajax/libs/jqueryui/1/themes/base/jquery-ui.css"
          rel="stylesheet" type="text/css"/>
    <script class="jsbin" src="http://ajax.googleapis.com/ajax/libs/jquery/1/jquery.min.js"></script>
    <script class="jsbin" src="http://ajax.googleapis.com/ajax/libs/jqueryui/1.8.0/jquery-ui.min.js"></script>

</head>
<body>

<nav class="navbar navbar-light bg-primary">
    <h3>SEMPRE UFG</h3>
</nav>

<div class="container">

    <h1>Formulário de Atualização de Dados do Egresso</h1>
    <hr width=100% >

    <script type="text/javascript" src="http://code.jquery.com/jquery-1.10.1.min.js"></script>
    <script>

var qtdeCampos = 0;

function addAtributos() {

var objEntidade = document.getElementById("campoEntidade");
//Criando o elemento DIV;
var objAtributo = document.createElement("div");
//Definindo atributos ao objAtributo:
objAtributo.setAttribute("id","atributo"+qtdeCampos);

//Inserindo o elemento na Entidade:
objEntidade.appendChild(objAtributo);
//Escrevendo algo no atributo recém-criado:
document.getElementById("atributo"+qtdeCampos).innerHTML = "<input type='checkbox' maxlength='8' style='width:50px;' id='visualiza' name='campo[]' class='form-control' value='Atributo com id: "+qtdeCampos+"'> <input type='number' maxlength='10' style='width:60px;' id='posicao' class='form-control' ><input type='text' id='campo"+qtdeCampos+"' name='campo[]' class='form-control' value='Atributo com id: "+qtdeCampos+"'> <input type='button' class='btn btn-default' onclick='removerCampo("+qtdeCampos+")' value='Apagar campo'>";
qtdeCampos++;
}

function removerCampo(id) {
var objEntidade = document.getElementById("campoEntidade");
var objAtributo = document.getElementById("atributo"+id);

//Removendo o DIV com id específico do nó-Entidade:
var removido = objEntidade.removeChild(objAtributo);
}


</script>
    </head>
        <form class= "form-inline" name="form1" action="formulario.php" method="POST">
                    <input type="checkbox"  class="form-control" maxlength="8" style="width:50px;" </input>
                     <input type='number' maxlength='10' style='width:60px;' id='posicao' class='form-control'</input>
                    <input type="text"  style="width:429px;" class="form-control" id="exampleInputName2" placeholder="Grupo de Questões">
                    <button type="button" class="btn btn-primary " onclick="addAtributos()">Adicionar Atributo</button>
            <div id="campoEntidade"></div>

            <hr width=100% >
            <button type="button" class="btn btn-success " onclick="">Salvar</button>
            <button type="button" class="btn btn-primary " onclick="addEntidade">Adicionar Grupo de Questões</button>
            <button type="button" class="btn btn-danger " onclick="">Apagar Grupo Selecionado</button>


        </form></center>
    </body>
</html>