package br.ufg.inf.sempreufg.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.ufg.inf.sempreufg.modelo.CursoUFG;
import br.ufg.inf.sempreufg.servico.EgressoService;
import br.ufg.inf.sempreufg.servico.EgressoServiceInterface;
import br.ufg.inf.sempreufg.to.ImportarEgressoTO;
import br.ufg.inf.sempreufg.to.ResultadoImportacaoTO;

/**
 * <p>
 * ImportEgresPeriodServlet.
 * </p>
 * <p>
 * Descrição: Servlet para a tela importar_egressos
 * </p>
 *
 * @author Bruno Martins de Carvalho
 */

public class ImportacaoEgressoServlet extends HttpServlet {

    private static final long serialVersionUID = -1032411736214093346L;

    final EgressoServiceInterface egressoService = new EgressoService();

    /**
     * @see javax.servlet.http.HttpServlet#doGet(javax.servlet.http.HttpServletRequest,
     *      javax.servlet.http.HttpServletResponse)
     */
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        this.incializarListas(request);

        final RequestDispatcher view = request.getRequestDispatcher("importar_egressos.jsp");
        view.forward(request, response);
    }

    /**
     * @see javax.servlet.http.HttpServlet#doPost(javax.servlet.http.HttpServletRequest,
     *      javax.servlet.http.HttpServletResponse)
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        final ImportarEgressoTO importarEgressoTO = new ImportarEgressoTO();

        importarEgressoTO.setPeriodoInicial(request.getParameter("periodoInicial"));
        importarEgressoTO.setPeriodoFinal(request.getParameter("periodoFinal"));
        importarEgressoTO.setMatriculaEgresso(request.getParameter("matriculaEgresso"));
        importarEgressoTO.setCursoUFG(request.getParameter("cursoUfg"));
        importarEgressoTO.setUnidadeAcademica(request.getParameter("unidadeAcademica"));
        importarEgressoTO.setRegional(request.getParameter("regional"));

        if (this.egressoService.validarFiltroImportacao(importarEgressoTO)) {
            final ResultadoImportacaoTO resultadoImportacao = this.egressoService.importarEgressos(importarEgressoTO);

            request.getSession().setAttribute("resultadoImportacao", resultadoImportacao);

            response.sendRedirect("resultado_importacao");
        } else {

            this.incializarListas(request);

            request.setAttribute("mensagem", "'Período inicial' e 'Período final' obrigatórios!");

            final RequestDispatcher view = request.getRequestDispatcher("importar_egressos.jsp");
            view.forward(request, response);

        }
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

        request.setAttribute("listaPeriodo", listaPeriodo);
        request.setAttribute("listaCursoUFG", listaCursoUFG);
        request.setAttribute("listaUnidadeAcademica", listaUnidadeAcademica);
        request.setAttribute("listaRegional", listaRegional);
    }

}
