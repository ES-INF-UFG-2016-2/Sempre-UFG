package br.ufg.inf.sempreufg.servico;

import br.ufg.inf.sempreufg.db.ConexaoBanco;
import br.ufg.inf.sempreufg.excecoes.ErroNaConsultaException;
import br.ufg.inf.sempreufg.interfaces.ConsultaServicoInterface;
import br.ufg.inf.sempreufg.modelo.Campo;
import br.ufg.inf.sempreufg.modelo.Linha;
import br.ufg.inf.sempreufg.modelo.Tabela;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ConsultaServico implements ConsultaServicoInterface {

    private Connection conexaoBD;

    public ConsultaServico() {
        conexaoBD = ConexaoBanco.getConnection();
    }

    @Override
    public Tabela executaConsultaDeEgressosPredefinida(
        int identificador, String filtroSelecao) throws ErroNaConsultaException {
        return null;
    }

    @Override
    public Tabela executaConsultaDeEgressosAdHoc(
        List<String> colunasABuscar, String filtroSelecao) throws ErroNaConsultaException {

        MontadorSQL montadorSQL = new MontadorSQL();
        String consulta = montadorSQL.montarConsulta(colunasABuscar, filtroSelecao);

        ResultSet resultado = executaSQL(consulta);
        return montaTabelaDoResultado(resultado);
    }

    private ResultSet executaSQL(String query) {
        ResultSet resultSet;
        try {
            Statement statement = conexaoBD.createStatement();
            resultSet = statement.executeQuery(query);
        } catch (SQLException e) {
            resultSet = null;
            e.printStackTrace();
        }
        return resultSet;
    }

    private Tabela montaTabelaDoResultado(ResultSet resultado) {

        Tabela tabela = null;

        try {
            List<String> nomesColunas = obtenhaNomesColunas(resultado);
            List<Linha> linhas = new ArrayList<>();

            while (resultado.next()) {
                List<Campo> campos = new ArrayList<>();
                for (String nomeColuna : nomesColunas) {
                    String valorColuna = resultado.getString(nomeColuna);
                    campos.add(new Campo(nomeColuna, valorColuna));
                }
                linhas.add(new Linha(campos));
            }
            tabela = new Tabela(linhas);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return tabela;
    }

    private List<String> obtenhaNomesColunas(ResultSet resultado) throws SQLException {
        List<String> nomeColunas = new ArrayList<>();
        int qntAtributosBuscados = resultado.getMetaData().getColumnCount();
        for (int posicaoColuna = 1; posicaoColuna <= qntAtributosBuscados; posicaoColuna++) {
            String nomeColuna = resultado.getMetaData().getColumnLabel(posicaoColuna);
            nomeColunas.add(nomeColuna);
        }
        return nomeColunas;
    }

}
