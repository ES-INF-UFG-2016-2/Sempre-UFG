package br.ufg.inf.sempreufg.servico;

import java.io.InputStream;
import java.util.Date;
import java.util.List;
import java.util.Map;

import br.ufg.inf.sempreufg.enums.NomeCampos;
import br.ufg.inf.sempreufg.modelo.CursoUFG;
import br.ufg.inf.sempreufg.modelo.Egresso;
import br.ufg.inf.sempreufg.to.ImportarEgressoTO;
import br.ufg.inf.sempreufg.to.ResultadoImportacaoTO;

public interface EgressoServiceInterface {

    void atualizarEgresso(Egresso egresso) throws Exception;

    Egresso getEgresso(int id);

    void removerEgresso(int id) throws Exception;

    public Egresso converterXmlParaEgresso(InputStream content);

    public boolean egressoEValido(Egresso egresso);

    public List<Egresso> buscarDadosEgressoViaWebService();

    public List<Egresso> buscarDadosEgressoPeloPeriodoConclusaoCurso(Date dataInicial, Date dataFinal);

    public List<Egresso> buscarDadosEgressoPeloIdentificadorEgresso(List<Integer> identificadores);

    public List<Egresso> buscarDadosEgressoPeloCurso(List<Integer> identificadores);

    public List<Egresso> buscarDadosEgressoPelaUnidadeAcademica(List<Integer> identificadores);

    public List<Egresso> consultarEgressoPorConsultaPreDefinida(String string);

    public List<Egresso> consultaPorAdHoc(Map<NomeCampos, String> parametros);

    /**
     *
     * Método responsável por realizar a importacao dos egressos do CERCOMP.
     *
     * @author Bruno Martins de Carvalho
     */
    ResultadoImportacaoTO importarEgressos(ImportarEgressoTO importarEgressoTO);

    /**
     *
     * Método responsável por obter a lista de periodos a serem utilizados como
     * filtro na importacao dos egressos.
     *
     * @return List
     * @author Bruno Martins de Carvalho
     */
    List<String> obterListaPeriodo();

    /**
     *
     * Método responsável por listar os cursos a serem utilizados como
     * possibilidade de filtro na importacao dos egressos.
     *
     * @return List
     * @author Bruno Martins de Carvalho
     */
    List<CursoUFG> obterListaCursos();

    /**
     *
     * Método responsável por obter a lista de unidades academicas a serem
     * utilizadas como possiblidade de filtro na importação dos egressos.
     *
     * @return List unidadeAcademica
     * @author Bruno Martins de Carvalho
     */
    List<String> obterListaUnidadeAcademica();

    /**
     *
     * Método responsável por obter a lista de reginais a serem utilizadas como
     * possiblidade de filtro na importação dos egressos.
     *
     * @return List regional
     * @author Bruno Martins de Carvalho
     */
    List<String> obterListaRegional();

    /**
     *
     * Método responsável por validar se os campos obrigatórios foram
     * preenchidos.
     *
     * @param importarEgressoTO
     * @return boolean
     * @author Bruno Martins de Carvalho
     */
    boolean validarFiltroImportacao(ImportarEgressoTO importarEgressoTO);
}
