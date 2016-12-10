package br.ufg.inf.sempreufg.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.ufg.inf.sempreufg.enums.Sexo;
import br.ufg.inf.sempreufg.enums.VisibilidadeDados;
import br.ufg.inf.sempreufg.modelo.Egresso;

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

    private static int recordsPerPage = 10;

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

        final List<Egresso> lista = this.obterEgressos();

        final int noOfRecords = lista.size();

        final int noOfPages = (int) Math.ceil(noOfRecords * 1.0 / recordsPerPage);

        if (page > noOfPages) {
            page = noOfPages;
        }

        final List<Egresso> listaPaginada = this.paginarLista(page, lista);

        request.setAttribute("listaEgresso", listaPaginada);
        request.setAttribute("noOfPages", noOfPages);

        request.setAttribute("totalExportadoCercomp", 100);
        request.setAttribute("totalImportadoSucesso", 90);
        request.setAttribute("totalNaoImportadoErro", 80);
        request.setAttribute("totalNaoImportadoReplicacao", 70);

        final RequestDispatcher view = request.getRequestDispatcher("resultado_importacao.jsp");
        view.forward(request, response);
    }

    /**
     * @see javax.servlet.http.HttpServlet#doPost(javax.servlet.http.HttpServletRequest,
     *      javax.servlet.http.HttpServletResponse)
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // TODO Auto-generated method stub
        super.doPost(req, resp);
    }

    private List<Egresso> obterEgressos() {
        final List<Egresso> lista = new ArrayList<Egresso>();

        for (int i = 0; i < 100; i++) {
            final Egresso egresso = new Egresso("Nome " + i, "Nome Mae", new Date(), Sexo.MASCULINO, "123@123.com", null, null,
                    VisibilidadeDados.PRIVADO, new ArrayList<>(), null);
            egresso.setId(i);
            lista.add(egresso);
        }
        return lista;
    }

    private List<Egresso> paginarLista(final int paginaSelecionada, final List<Egresso> lista) {

        final List<Egresso> listaPaginada = new ArrayList<Egresso>();

        for (int i = (paginaSelecionada - 1) * recordsPerPage; i < recordsPerPage * paginaSelecionada; i++) {
            listaPaginada.add(lista.get(i));
        }

        return listaPaginada;
    }

}
