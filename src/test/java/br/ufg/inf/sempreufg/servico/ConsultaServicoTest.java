package br.ufg.inf.sempreufg.servico;

import br.ufg.inf.sempreufg.db.ConexaoBanco;
import br.ufg.inf.sempreufg.excecoes.ErroNaConsultaException;
import br.ufg.inf.sempreufg.interfaces.ConsultaServicoInterface;
import br.ufg.inf.sempreufg.modelo.Campo;
import br.ufg.inf.sempreufg.modelo.Tabela;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ConsultaServicoTest {

    ConsultaServicoInterface consultaServico = new ConsultaServico();
    private static Connection connection;

    @BeforeClass
    public static void adicionaInformacoesExemplo() throws SQLException, IOException {
        connection = ConexaoBanco.getConnection();
        Statement statement = connection.createStatement();
        String query = buscaSQLInserirCursoParaEgresso();
        statement.execute(query);
    }

    @AfterClass
    public static void removeInformacoesExemplo() throws SQLException {
        Statement statement = connection.createStatement();
        statement.execute("TRUNCATE TABLE area_conhecimento CASCADE;");
        statement.execute("TRUNCATE TABLE localizacao_geografica CASCADE;");
        statement.execute("TRUNCATE TABLE instancia_administrativa_ufg CASCADE;");
        statement.execute("TRUNCATE TABLE egresso CASCADE;");
    }

    @Test
    public void testaExecutarConsultaComSucesso() throws ErroNaConsultaException {

        List<String> atributos = new ArrayList<String>() {{
            add("nome_do_curso");
        }};
        String filtroSelecao = "instancia_administrativa_ufg.nome = 'Engenharia de Software'";
        Tabela tabela = consultaServico.executaConsultaDeEgressosAdHoc(atributos, filtroSelecao);

        Campo campoObtido = tabela.getLinhas().get(0).getCampos().get(0);
        Campo campoTeste = criaCampoParaTeste();

        Assert.assertEquals(campoTeste.getChave(), campoObtido.getChave());
        Assert.assertEquals(campoTeste.getValor(), campoObtido.getValor());
    }

    private Campo criaCampoParaTeste() {
        return new Campo("nome", "Engenharia de Software");
    }

    private static String buscaSQLInserirCursoParaEgresso() throws IOException {
        StringBuilder consultaInserirCursoParaEgresso = new StringBuilder();
        BufferedReader bufferedReader = new BufferedReader(new FileReader("src/test/resources/inserirCursoParaEgresso.sql"));
        String line;
        while ((line = bufferedReader.readLine()) != null) {
            consultaInserirCursoParaEgresso.append(line);
        }
        return consultaInserirCursoParaEgresso.toString();
    }
}
