package br.ufg.inf.sempreufg.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.ufg.inf.sempreufg.modelo.CursoUFG;
import br.ufg.inf.sempreufg.modelo.Egresso;
import br.ufg.inf.sempreufg.servico.EgressoService;
import br.ufg.inf.sempreufg.servico.EgressoServiceInterface;
import br.ufg.inf.sempreufg.to.ResultadoImportacaoTO;

/**
 * <p>
 * ImportEgresPeriodServlet.
 * </p>
 * <p>
 * Descrição: Servlet para a pagina resulta_importacao.jsp
 * </p>
 *
 * @author Bruno Martins de Carvalho
 */

public class ResultadoImportacaoEgressoServlet extends HttpServlet {

    private static final long serialVersionUID = -1032411736214093346L;

    final EgressoServiceInterface egressoService = new EgressoService();

    private static int recordsPerPage = 10;

    private ResultadoImportacaoTO resultadoImportacao;

    /**
     * @see javax.servlet.http.HttpServlet#doGet(javax.servlet.http.HttpServletRequest,
     *      javax.servlet.http.HttpServletResponse)
     */
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int page = 1;

        if (request.getParameter("page") != null) {
            page = Integer.parseInt(request.getParameter("page"));
        }

        this.incializarListas(request);

        if (request.getSession().getAttribute("resultadoImportacao") != null) {
            this.resultadoImportacao = (ResultadoImportacaoTO) request.getSession().getAttribute("resultadoImportacao");
        }

        final List<Egresso> lista = this.resultadoImportacao.getListaEgressoImportado();

        final int noOfRecords = lista.size();

        final int noOfPages = (int) Math.ceil(noOfRecords * 1.0 / recordsPerPage);

        if (page > noOfPages) {
            page = noOfPages;
        }

        final List<Egresso> listaPaginada = this.paginarLista(page, lista);

        request.setAttribute("listaEgresso", listaPaginada);
        request.setAttribute("noOfPages", noOfPages);

        request.setAttribute("totalExportadoCercomp", this.resultadoImportacao.getTotalExportadoCercomp());
        request.setAttribute("totalImportadoSucesso", this.resultadoImportacao.getTotalImportadoSucesso());
        request.setAttribute("totalNaoImportadoErro", this.resultadoImportacao.getTotalNaoImportadoErro());
        request.setAttribute("totalNaoImportadoReplicacao", this.resultadoImportacao.getTotalNaoImportadoReplicacao());

        final RequestDispatcher view = request.getRequestDispatcher("resultado_importacao.jsp");
        view.forward(request, response);
    }

    /**
     * @see javax.servlet.http.HttpServlet#doPost(javax.servlet.http.HttpServletRequest,
     *      javax.servlet.http.HttpServletResponse)
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int page = 1;

        if (request.getParameter("page") != null) {
            page = Integer.parseInt(request.getParameter("page"));
        }

        if (this.resultadoImportacao == null) {
            this.resultadoImportacao = new ResultadoImportacaoTO();
        }

        this.incializarListas(request);

        final List<Egresso> lista = this.resultadoImportacao.getListaEgressoImportado();

        final int noOfRecords = lista.size();

        final int noOfPages = (int) Math.ceil(noOfRecords * 1.0 / recordsPerPage);

        if (page > noOfPages) {
            page = noOfPages;
        }

        final List<Egresso> listaFiltrada = this.filtrarLista(lista, request);

        final List<Egresso> listaPaginada = this.paginarLista(page, listaFiltrada);

        request.setAttribute("listaEgresso", listaPaginada);
        request.setAttribute("noOfPages", noOfPages);

        request.setAttribute("totalExportadoCercomp", this.resultadoImportacao.getTotalExportadoCercomp());
        request.setAttribute("totalImportadoSucesso", this.resultadoImportacao.getTotalImportadoSucesso());
        request.setAttribute("totalNaoImportadoErro", this.resultadoImportacao.getTotalNaoImportadoErro());
        request.setAttribute("totalNaoImportadoReplicacao", this.resultadoImportacao.getTotalNaoImportadoReplicacao());

        final RequestDispatcher view = request.getRequestDispatcher("resultado_importacao.jsp");
        view.forward(request, response);
    }

    /**
     *
     * Método responsável por inicializar as listas utilizadas em tela;
     *
     * @param request
     * @param egressoService
     * @author Bruno Martins de Carvalho
     */
    private void incializarListas(HttpServletRequest request) {
        final List<String> listaPeriodo = this.egressoService.obterListaPeriodo();
        final List<CursoUFG> listaCursoUFG = this.egressoService.obterListaCursos();
        final List<String> listaUnidadeAcademica = this.egressoService.obterListaUnidadeAcademica();
        final List<String> listaRegional = this.egressoService.obterListaRegional();
        final List<String> listaStatus = this.egressoService.obterListaRegional();

        request.setAttribute("listaPeriodo", listaPeriodo);
        request.setAttribute("listaCursoUFG", listaCursoUFG);
        request.setAttribute("listaUnidadeAcademica", listaUnidadeAcademica);
        request.setAttribute("listaRegional", listaRegional);
        request.setAttribute("listaStatus", listaStatus);
    }

    /**
     *
     * Método responsável por filtrar a lista de acordo com os filtros em tela.
     *
     * @param lista
     * @return List
     * @author Bruno Martins de Carvalho
     */
    private List<Egresso> filtrarLista(List<Egresso> lista, HttpServletRequest request) {

        final List<Egresso> listaFiltrada = lista;

        final String periodo = request.getParameter("periodo");
        final String curso = request.getParameter("curso");
        final String unidadeAcademica = request.getParameter("unidadeAcademica");
        final String regional = request.getParameter("regional");
        final String status = request.getParameter("status");

        for (final Egresso egresso : lista) {
            // TODO filtrar a lista aqui, assim que estiver definido como será o
            // retorno da lista de egressos importados.
        }

        request.setAttribute("periodoSelect", periodo);
        request.setAttribute("cursoSelect", curso);
        request.setAttribute("unidadeAcademicaSelect", unidadeAcademica);
        request.setAttribute("regionalSelect", regional);
        request.setAttribute("statusSelect", status);

        return listaFiltrada;
    }

    /**
     *
     * Método responsável por fazer a paginação da lista de egressos importados.
     *
     * @param paginaSelecionada
     * @param lista
     * @return List
     * @author Bruno Martins de Carvalho
     */
    private List<Egresso> paginarLista(final int paginaSelecionada, final List<Egresso> lista) {

        final List<Egresso> listaPaginada = new ArrayList<Egresso>();

        for (int i = (paginaSelecionada - 1) * recordsPerPage; (i < recordsPerPage * paginaSelecionada) && i < lista.size(); i++) {
            listaPaginada.add(lista.get(i));
        }

        return listaPaginada;
    }

}
