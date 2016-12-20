package br.ufg.inf.sempreufg.servico;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.Date;
import java.util.List;
import java.util.Map;

import br.ufg.inf.sempreufg.dao.EgressoDao;
import br.ufg.inf.sempreufg.enums.NomeCampos;
import br.ufg.inf.sempreufg.enums.Sexo;
import br.ufg.inf.sempreufg.enums.VisibilidadeDados;
import br.ufg.inf.sempreufg.modelo.CursoUFG;
import br.ufg.inf.sempreufg.modelo.Egresso;
import br.ufg.inf.sempreufg.modelo.HistoricoUFG;
import br.ufg.inf.sempreufg.modelo.LocalizacaoGeografica;
import br.ufg.inf.sempreufg.to.ImportarEgressoTO;
import br.ufg.inf.sempreufg.to.ResultadoImportacaoTO;

public class EgressoService implements EgressoServiceInterface {

    static EgressoDao EgressoDao;

    @Override
    public void atualizarEgresso(Egresso egresso) {
        EgressoDao = new EgressoDao();
        EgressoDao.atualizar(egresso);
    }

    @Override
    public Egresso getEgresso(int id) {
        EgressoDao = new EgressoDao();
        Egresso egresso = null;
        try {
            egresso = EgressoDao.getById(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return egresso;
    }

    @Override
    public void removerEgresso(int id) throws Exception {
        EgressoDao = new EgressoDao();
        EgressoDao.deletar(id);
    }

    @Override
    public Egresso converterXmlParaEgresso(InputStream content) {
        Egresso egresso = new Egresso();
        return egresso;
    }

    @Override
    public boolean egressoEValido(Egresso egresso) {
        return false;
    }

    @Override
    public List<Egresso> buscarDadosEgressoViaWebService() {
        return criarListaEgressoMock();
    }

    @Override
    public List<Egresso> buscarDadosEgressoPeloPeriodoConclusaoCurso(Date dataInicial, Date dataFinal) {
        return criarListaEgressoMock();
    }

    @Override
    public List<Egresso> buscarDadosEgressoPeloIdentificadorEgresso(List<Integer> identificadores) {
        return criarListaEgressoMock();
    }

    @Override
    public List<Egresso> buscarDadosEgressoPeloCurso(List<Integer> identificadores) {
        return criarListaEgressoMock();
    }

    @Override
    public List<Egresso> buscarDadosEgressoPelaUnidadeAcademica(List<Integer> identificadores) {
        return criarListaEgressoMock();
    }

    public List<Egresso> criarListaEgressoMock() {
        List<Egresso> egressos = new ArrayList<Egresso>();

        for (int i = 0; i < 10; i++) {
            Egresso egresso = new Egresso("Everton Jose", "Maria", new Date(), Sexo.MASCULINO, "emailAlternativo@gmail.com", new BitSet(),
                    new BitSet(), VisibilidadeDados.PUBLICO, new ArrayList<HistoricoUFG>(), new LocalizacaoGeografica());
            egressos.add(egresso);
        }

        return egressos;
    }

    @Override
    public List<Egresso> consultarEgressoPorConsultaPreDefinida(String string) {
        return new ExecultarConsultasMock().criarListaEgresso();
    }

    @Override
    public List<Egresso> consultaPorAdHoc(Map<NomeCampos, String> parametros) {
        return new ExecultarConsultasMock().criarListaEgresso();
    }

    final CursoService cursoService = new CursoService();

    /**
     * @see br.ufg.inf.sempreufg.servico.EgressoServiceInterface#importarEgressos()
     */
    @Override
    public ResultadoImportacaoTO importarEgressos(final ImportarEgressoTO importarEgressoTO) {
        return this.resultadoImportacaoMock();
    }

    /**
     * @see br.ufg.inf.sempreufg.servico.EgressoServiceInterface#obterListaPeriodo()
     */
    @Override
    public List<String> obterListaPeriodo() {
        return this.criarListaPeriodoMock();
    }

    /**
     * @see br.ufg.inf.sempreufg.servico.EgressoServiceInterface#obterListaCursos()
     */
    @Override
    public List<CursoUFG> obterListaCursos() {
        return this.cursoService.obterListaCursos();
    }

    /**
     * @see br.ufg.inf.sempreufg.servico.EgressoServiceInterface#obterListaUnidadeAcademica()
     */
    @Override
    public List<String> obterListaUnidadeAcademica() {
        return this.criarListaPeriodoMock();
    }

    /**
     * @see br.ufg.inf.sempreufg.servico.EgressoServiceInterface#obterListaRegional()
     */
    @Override
    public List<String> obterListaRegional() {
        return this.criarListaPeriodoMock();
    }

    /**
     * @see br.ufg.inf.sempreufg.servico.EgressoServiceInterface#validarFiltroImportacao(br.ufg.inf.sempreufg.to.ImportarEgressoTO)
     */
    @Override
    public boolean validarFiltroImportacao(ImportarEgressoTO importarEgressoTO) {

        boolean filtroImportacaoValida = true;

        if (importarEgressoTO.getPeriodoInicial().isEmpty()) {
            filtroImportacaoValida = false;
        } else if (importarEgressoTO.getPeriodoFinal().isEmpty()) {
            filtroImportacaoValida = false;
        }

        return filtroImportacaoValida;
    }

    /**
     *
     * Método responsável por criar uma lista de periodos mockada.
     * 
     * @return List
     * @author Bruno Martins de Carvalho
     */
    private List<String> criarListaPeriodoMock() {
        List<String> egressos = new ArrayList<String>();

        for (int i = 0; i < 10; i++) {
            egressos.add(2000 + i + ".1");
            egressos.add(2000 + i + ".2");
        }

        return egressos;
    }

    private ResultadoImportacaoTO resultadoImportacaoMock() {
        final ResultadoImportacaoTO resultadoImportacao = new ResultadoImportacaoTO();

        resultadoImportacao.setTotalExportadoCercomp(50);
        resultadoImportacao.setTotalImportadoSucesso(40);
        resultadoImportacao.setTotalNaoImportadoErro(30);
        resultadoImportacao.setTotalNaoImportadoReplicacao(20);

        resultadoImportacao.setListaEgressoImportado(this.criarListaEgressoMock());

        return resultadoImportacao;
    }

}
