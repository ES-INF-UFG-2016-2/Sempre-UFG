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
 * Descrição: TODO
 * </p>
 *
 * @author Bruno Martins de Carvalho
 */

public class ImportEgresPeriodServlet extends HttpServlet {

    private static final long serialVersionUID = -1032411736214093346L;

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int page = 1;
        int recordsPerPage = 10;
        if (request.getParameter("page") != null)
            page = Integer.parseInt(request.getParameter("page"));

        List<Egresso> list = new ArrayList<Egresso>();

        for (int i = 0; i < 100; i++) {
            Egresso egresso = new Egresso("Nome " + i, "Nome Mae", new Date(), Sexo.MASCULINO, "123@123.com", null, null, VisibilidadeDados.PRIVADO,
                    new ArrayList<>(), null);
            egresso.setId(i);
            list.add(egresso);
        }

        int noOfRecords = list.size();
        int noOfPages = (int) Math.ceil(noOfRecords * 1.0 / recordsPerPage);

        List<Egresso> listExibir = new ArrayList<Egresso>();

        for (int i = (page - 1) * recordsPerPage; i < recordsPerPage * page; i++) {
            listExibir.add(list.get(i));
        }

        request.setAttribute("listaEgresso", listExibir);
        request.setAttribute("noOfPages", noOfPages);
        request.setAttribute("currentPage", page);

        RequestDispatcher view = request.getRequestDispatcher("resultado_importacao.jsp");
        view.forward(request, response);
    }

}
