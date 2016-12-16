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
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * Classe responsável por gerenciar as operações relacionadas a consultas de egressos.
 */
public class ConsultaServico implements ConsultaServicoInterface {

    private Connection conexaoBD;

    public ConsultaServico() {
        conexaoBD = ConexaoBanco.getConnection();
    }

    /**
     * Salva uma consulta de egressos.
     *
     * @param dadosConsultaJson
     * @return TRUE se a consulta foi salva corretamente ou FALSE caso contrário.
     */
    public boolean salvarConsulta(String dadosConsultaJson) {
        //TODO: Implementar método conforme requisitos. A implementação que eu estou insindo aqui é STUB.
        return ("".equals(dadosConsultaJson)) ? false : true;
    }

    /**
     * Busca todas as entidades existentes no banco de dados, incluindo seus atributos para que uma nova consulta seja
     * definida.
     *
     * @return mapa contendo a chave de identificação da entidade e seu atributo, e o valor daquela combinação de
     * entidade e atributo a ser apresentado para o usuário.
     */
    public Map<String, String> buscarMapaTodasEntidades() {
        //TODO: Implementar método conforme requisitos. A implementação que eu estou insindo aqui é STUB.
        Map<String, String> entidades = new LinkedHashMap<>();
        entidades.put("egresso.nome", "Egresso - Nome");
        entidades.put("egresso.idade", "Egresso - Idade");
        entidades.put("egresso.dataNascimento", "Egresso - Data de Nascimento");
        entidades.put("egresso.nomeMae", "Egresso - Nome da Mãe");
        entidades.put("egresso.sexo", "Egresso - Sexo");
        entidades.put("egresso.cidadeOrigem", "Egresso - Cidade de Origem");
        entidades.put("curso.nome", "Curso - Nome");
        entidades.put("curso.regional", "Curso - Regional");
        entidades.put("curso.codigo", "Curso - Código");
        entidades.put("instituicao.nome", "Instituição - Nome");
        entidades.put("instituicao.cidade", "Instituição - Cidade");
        entidades.put("instituicao.campus", "Instituição - Campus");

        return entidades;
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
