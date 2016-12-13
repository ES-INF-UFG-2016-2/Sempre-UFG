package br.ufg.inf.sempreufg.servlet;

import br.ufg.inf.sempreufg.dao.DivulgacaoEventoComunidadeDAO;
import br.ufg.inf.sempreufg.modelo.DivulgacaoEventoComunidade;
import org.json.JSONArray;
import org.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class DivulgEventComunServlet extends HttpServlet {

    private DivulgacaoEventoComunidadeDAO divulgacaoEventoComunidadeDAO = new DivulgacaoEventoComunidadeDAO();

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">

    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request  servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException      if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {

        response.setContentType("application/json");

        try (PrintWriter out = response.getWriter()) {

            String idDivulgacaoEventoComunidade = request.getParameter("idDivulgacaoEventoComunidade");
            JSONArray JSON = new JSONArray();

            if (idDivulgacaoEventoComunidade != null && !idDivulgacaoEventoComunidade.trim().equals("")) {
                DivulgacaoEventoComunidade divulgacaoEventoComunidade = divulgacaoEventoComunidadeDAO.consultarPorId(Integer.parseInt(idDivulgacaoEventoComunidade));
                JSON.put(divulgacaoEventoComunidade.toJSON());
            } else {
                divulgacaoEventoComunidadeDAO.consultarTodos().forEach(JSON::put);
            }
            out.print(JSON);
            out.flush();
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request  servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException      if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {

        try (PrintWriter out = response.getWriter()) {

            String divulgacaoEventoComunidadeStr = request.getParameter("divulgacaoEventoComunidade");
            DivulgacaoEventoComunidade divulgacaoEventoComunidade = DivulgacaoEventoComunidade.fromJSON(new JSONObject(divulgacaoEventoComunidadeStr));
            divulgacaoEventoComunidadeDAO.salvar(divulgacaoEventoComunidade.getEvento(), divulgacaoEventoComunidade.getUsuarios());

            out.flush();

        }
    }

    @Override
    protected void doPut(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {

        try (PrintWriter out = response.getWriter()) {

            String idDivulgacaoEventoComunidade = request.getParameter("idDivulgacaoEventoComunidade");
            String divulgacaoEventoComunidadeStr = request.getParameter("divulgacaoEventoComunidade");
            divulgacaoEventoComunidadeDAO.atualizar(Integer.parseInt(idDivulgacaoEventoComunidade), DivulgacaoEventoComunidade.fromJSON(new JSONObject(divulgacaoEventoComunidadeStr)));

            out.flush();

        }
    }

    @Override
    protected void doDelete(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {

        try (PrintWriter out = response.getWriter()) {

            String idDivulgacaoEventoComunidade = request.getParameter("idDivulgacaoEventoComunidade");
            divulgacaoEventoComunidadeDAO.remover(Integer.parseInt(idDivulgacaoEventoComunidade));

            out.flush();
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Servlet para gerenciamento e CRUD de Divulgações de Evento para a Comunidade.";
    }
}
