package br.ufg.inf.sempreufg.db;

import br.ufg.inf.sempreufg.modelo.Atributo;
import br.ufg.inf.sempreufg.modelo.Entidade;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Marcos on 12/12/2016.
 */
public class ConfiguraAtualizacaoEgressoDbTeste {

    private Connection connection;
    private PreparedStatement preparedStatement;
    private String lineSeparator;

    private List<Entidade> entidades;
    private List<Atributo> atributosEgresso;
    private List<Atributo> atributosUsuario;

    public ConfiguraAtualizacaoEgressoDbTeste() {
        connection = ConexaoBanco.getConnection();
        lineSeparator = System.lineSeparator();
        criaTabelaAtributosContidosPorEntidades();
    }

    public List<Entidade> populaBancoDeDadosParaTeste(){
        entidades = new ArrayList<>();
        atributosEgresso = new ArrayList<>();
        atributosUsuario = new ArrayList<>();

        try {
            limpaDadosBD();
            inseriEntidadesDeTesteBD();
            insereAtributosDeTesteDB();
            entidades.get(0).setAtributos(atributosEgresso);
            entidades.get(1).setAtributos(atributosUsuario);
            return entidades;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public void limpaDadosBD() {
        String scripSQL = "delete from atributos_contidos_por_entidades;" + lineSeparator +
            "delete from atributo_desvia_para_atributo;" + lineSeparator +
            "delete from atributo;" + lineSeparator +
            "delete from entidade;";
        try {
            preparedStatement = connection.prepareStatement(scripSQL);
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public boolean existeDadosNaTabela(String nomeTabela){
        String scripSQL = "select * from " + nomeTabela;
        try {
            preparedStatement = connection.prepareStatement(scripSQL);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()){
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return false;
    }

    private void inseriEntidadesDeTesteBD() throws SQLException {
        List<String> dadosEntidadeEgresso = new ArrayList<>();
        List<String> dadosEntidadeUsuario = new ArrayList<>();

        Entidade entidadeEgresso = new Entidade();
        String nomeEgresso = "Egresso";
        entidadeEgresso.setId(ultimoIdInserido("id_interno","entidade"));
        entidadeEgresso.setNomeDaEntidade(nomeEgresso);
        entidadeEgresso.setTituloDoGrupoDeQuestoes(nomeEgresso);
        entidadeEgresso.setTituloDoGrupoDeCampos(nomeEgresso);
        dadosEntidadeEgresso.add(nomeEgresso);
        dadosEntidadeEgresso.add(nomeEgresso);
        dadosEntidadeEgresso.add(nomeEgresso);
        dadosEntidadeEgresso.add("-1");
        dadosEntidadeEgresso.add("-1");
        insereEntidadeBancoDaDados(dadosEntidadeEgresso);

        Entidade entidadeUsuario = new Entidade();
        String nomeUsuario = "Usuario";
        entidadeUsuario.setId(ultimoIdInserido("id_interno","entidade"));
        entidadeUsuario.setNomeDaEntidade(nomeUsuario);
        entidadeUsuario.setTituloDoGrupoDeQuestoes(nomeUsuario);
        entidadeUsuario.setTituloDoGrupoDeCampos(nomeUsuario);
        entidadeUsuario.setEntidadeAntecedente(entidadeEgresso);
        dadosEntidadeUsuario.add(nomeUsuario);
        dadosEntidadeUsuario.add(nomeUsuario);
        dadosEntidadeUsuario.add(nomeUsuario);
        dadosEntidadeUsuario.add(nomeEgresso);
        dadosEntidadeUsuario.add("-1");
        insereEntidadeBancoDaDados(dadosEntidadeUsuario);

        entidades.add(entidadeEgresso);
        entidades.add(entidadeUsuario);
    }

    private void insereAtributosDeTesteDB() throws SQLException {
        insereAtributosEgressos();
        insereAtributosUsuario();
    }

    private void insereAtributosEgressos() throws SQLException {
        List<String> dadosNomeOficialEgresso = new ArrayList<>();
        List<String> dadosNomeDaMaeEgresso = new ArrayList<>();

        Atributo atributoNome = new Atributo();
        String nomeNomeOficial = "Nome";
        atributoNome.setNomeDoAtributo(nomeNomeOficial);
        atributoNome.setId(ultimoIdInserido("identificador_interno","atributo"));
        atributoNome.setTituloDoCampo(nomeNomeOficial);
        atributoNome.setTituloDaQuestao(nomeNomeOficial);
        dadosNomeOficialEgresso.add(nomeNomeOficial);
        dadosNomeOficialEgresso.add(nomeNomeOficial);
        dadosNomeOficialEgresso.add(nomeNomeOficial);
        dadosNomeOficialEgresso.add("-1");
        dadosNomeOficialEgresso.add("Egresso");
        insereAtributosBancoDaDados(dadosNomeOficialEgresso);

        Atributo atributoNomeDaMae = new Atributo();
        String nomeNomeDaMae = "Nome da Mãe";
        atributoNomeDaMae.setNomeDoAtributo(nomeNomeDaMae);
        atributoNomeDaMae.setId(ultimoIdInserido("identificador_interno","atributo"));
        atributoNomeDaMae.setTituloDoCampo(nomeNomeDaMae);
        atributoNomeDaMae.setTituloDaQuestao(nomeNomeDaMae);
        atributoNomeDaMae.setAtributoAntecedente(atributoNome);
        dadosNomeDaMaeEgresso.add(nomeNomeDaMae);
        dadosNomeDaMaeEgresso.add(nomeNomeDaMae);
        dadosNomeDaMaeEgresso.add(nomeNomeDaMae);
        dadosNomeDaMaeEgresso.add(nomeNomeOficial);
        dadosNomeDaMaeEgresso.add("Egresso");
        insereAtributosBancoDaDados(dadosNomeDaMaeEgresso);

        atributosEgresso.add(atributoNome);
        atributosEgresso.add(atributoNomeDaMae);
    }

    private void insereAtributosUsuario() throws SQLException {
        List<String> dadosEmailUsuario = new ArrayList<>();
        List<String> dadosCPFUsuario = new ArrayList<>();

        Atributo atributoEmail = new Atributo();
        String nomeEmail = "Email";
        atributoEmail.setNomeDoAtributo(nomeEmail);
        atributoEmail.setId(ultimoIdInserido("identificador_interno","atributo"));
        atributoEmail.setTituloDoCampo(nomeEmail);
        atributoEmail.setTituloDaQuestao(nomeEmail);
        dadosEmailUsuario.add(nomeEmail);
        dadosEmailUsuario.add(nomeEmail);
        dadosEmailUsuario.add(nomeEmail);
        dadosEmailUsuario.add("-1");
        dadosEmailUsuario.add("Usuario");
        insereAtributosBancoDaDados(dadosEmailUsuario);

        Atributo atributoCPF = new Atributo();
        String nomeCPF = "CPF";
        atributoCPF.setNomeDoAtributo(nomeCPF);
        atributoCPF.setId(ultimoIdInserido("identificador_interno","atributo"));
        atributoCPF.setTituloDoCampo(nomeCPF);
        atributoCPF.setTituloDaQuestao(nomeCPF);
        atributoCPF.setAtributoAntecedente(atributoEmail);
        dadosCPFUsuario.add(nomeCPF);
        dadosCPFUsuario.add(nomeCPF);
        dadosCPFUsuario.add(nomeCPF);
        dadosCPFUsuario.add(nomeEmail);
        dadosCPFUsuario.add("Usuario");
        insereAtributosBancoDaDados(dadosCPFUsuario);

        atributosUsuario.add(atributoEmail);
        atributosUsuario.add(atributoCPF);
    }

    private void insereEntidadeBancoDaDados(List<String> informacoesEgresso) throws SQLException {
        String scripSQL = "INSERT INTO entidade(" + lineSeparator +
            "nome_entidade, id_interno, titulo_grupo_questoes," + lineSeparator +
            "titulo_grupo_campos, entidade_sucessora, atributo)" + lineSeparator +
            "VALUES (?,?,?,?,?,?);";
        preparedStatement = connection.prepareStatement(scripSQL);
        int i=1;
        preparedStatement.setString(i++,consultaFlagParaRetornarNulo(informacoesEgresso.get(0)));
        preparedStatement.setString(i++,ultimoIdInserido("id_interno","entidade"));
        preparedStatement.setString(i++,consultaFlagParaRetornarNulo(informacoesEgresso.get(1)));
        preparedStatement.setString(i++,consultaFlagParaRetornarNulo(informacoesEgresso.get(2)));
        preparedStatement.setString(i++,consultaFlagParaRetornarNulo(informacoesEgresso.get(3)));
        preparedStatement.setString(i++,consultaFlagParaRetornarNulo(informacoesEgresso.get(4)));
        preparedStatement.execute();
    }

    private void insereAtributosBancoDaDados(List<String> informacoesAtributos) throws SQLException {
        String scripSQL = "INSERT INTO public.atributo(" + lineSeparator +
            "nome_atributo, identificador_interno, titulo_da_questao," + lineSeparator +
            "titulo_do_campo, atributo_sucessor)" + lineSeparator +
            "VALUES (?, ?, ?, ?, ?);";
        preparedStatement = connection.prepareStatement(scripSQL);
        int i=1;
        preparedStatement.setString(i++,consultaFlagParaRetornarNulo(informacoesAtributos.get(0)));
        preparedStatement.setString(i++,ultimoIdInserido("identificador_interno","atributo"));
        preparedStatement.setString(i++,consultaFlagParaRetornarNulo(informacoesAtributos.get(1)));
        preparedStatement.setString(i++,consultaFlagParaRetornarNulo(informacoesAtributos.get(2)));
        preparedStatement.setString(i++,consultaFlagParaRetornarNulo(informacoesAtributos.get(3)));
        preparedStatement.execute();
        insereAtributosRelacionadosAEntidade(informacoesAtributos.get(0),informacoesAtributos.get(4));
    }

    private void insereAtributosRelacionadosAEntidade(String idAtributo, String idEntidade) throws SQLException {
        String scripSQL = "INSERT INTO atributos_contidos_por_entidades(" + lineSeparator +
            "nome_entidade, nome_atributo)" + lineSeparator +
            "VALUES (?, ?);";
        preparedStatement = connection.prepareStatement(scripSQL);
        int i=1;
        preparedStatement.setString(i++,idEntidade);
        preparedStatement.setString(i++,idAtributo);
        preparedStatement.execute();
    }

    private String ultimoIdInserido(String nomeDoFieldId, String nomeTabela) throws SQLException {
        PreparedStatement preparedStatementUltimoId;
        String scripSQL = "SELECT " + nomeDoFieldId + lineSeparator +
            "FROM " + nomeTabela + lineSeparator +
            "ORDER BY CAST(" + nomeDoFieldId +" AS INT) DESC" + lineSeparator +
            "LIMIT 1";
        preparedStatementUltimoId = connection.prepareStatement(scripSQL);
        ResultSet resultSet =  preparedStatementUltimoId.executeQuery();
        if (!resultSet.next()){
            return "1";
        } else{
            int ultimoIdInserido = resultSet.getInt(nomeDoFieldId);
            return Integer.toString(ultimoIdInserido+1);
        }
    }

    private String consultaFlagParaRetornarNulo(String entrada){
        if ("-1".equals(entrada)){
            return null;
        }
        return entrada;
    }

    private void criaTabelaAtributosContidosPorEntidades() {
        StringBuilder criarTabela = new StringBuilder();
        BufferedReader bufferedReader = null;

        try {
            bufferedReader =
                new BufferedReader(new FileReader("src/test/resources/IncluirTabelaAtributosContidosPorEntidades"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        String line;
        try {
            while ((line = bufferedReader.readLine()) != null) {
                criarTabela.append(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            preparedStatement = connection.prepareStatement(criarTabela.toString());
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
