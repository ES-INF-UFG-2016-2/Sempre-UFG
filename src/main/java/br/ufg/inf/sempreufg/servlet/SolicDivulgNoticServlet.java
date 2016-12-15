package br.ufg.inf.sempreufg.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

import br.ufg.inf.sempreufg.dao.SolicitacaoDivulgacaoEventoDAO;
import br.ufg.inf.sempreufg.modelo.SolicitacaoDivulgacaoEvento;
import org.json.JSONObject;

public class SolicDivulgNoticServlet extends HttpServlet {

    private SolicitacaoDivulgacaoEventoDAO solicitacaoDivulgacaoEventoDAO = new SolicitacaoDivulgacaoEventoDAO();

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {

        response.setContentType("application/json");

        try (PrintWriter out = response.getWriter()) {

            String idEvento = request.getParameter("idEvento");
            JSONObject JSON = new JSONObject();

            if(idEvento != null && !idEvento.trim().equals("")){
                SolicitacaoDivulgacaoEvento solicitacaoDivulgacaoEvento = solicitacaoDivulgacaoEventoDAO.consultarPorId(Integer.parseInt(idEvento));
                JSON.put("id", solicitacaoDivulgacaoEvento.getId());
                JSON.put("idEvento", solicitacaoDivulgacaoEvento.getEvento());
                JSON.put("idUsuario", solicitacaoDivulgacaoEvento.getUsuario());
                JSON.put("aprovado", solicitacaoDivulgacaoEvento.isAprovado());
            }
            else {
                solicitacaoDivulgacaoEventoDAO.consultarTodas().forEach(solicitacaoDivulgacaoEventoConsumer ->
                {
                    JSON.put("idEvento", solicitacaoDivulgacaoEventoConsumer.getEvento());
                    JSON.put("idUsuario", solicitacaoDivulgacaoEventoConsumer.getUsuario());
                });
            }
            out.print(JSON);
            out.flush();
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {

        try (PrintWriter out = response.getWriter()) {

            String idEvento = request.getParameter("idEvento");
            String idUsuario = request.getParameter("idUsuario");
            solicitacaoDivulgacaoEventoDAO.salvar(Integer.parseInt(idEvento), Integer.parseInt(idUsuario));

            out.flush();

        }
    }

    @Override
    protected void doPut(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {

        try (PrintWriter out = response.getWriter()) {

            String id = request.getParameter("id");
            String idEvento = request.getParameter("idEvento");
            String idUsuario = request.getParameter("idUsuario");
            SolicitacaoDivulgacaoEvento solicitacaoDivulgacaoEvento = new SolicitacaoDivulgacaoEvento(Integer.parseInt(idEvento), Integer.parseInt(idUsuario));
            solicitacaoDivulgacaoEventoDAO.atualizar(Integer.parseInt(id), solicitacaoDivulgacaoEvento);

            out.flush();

        }
    }

    @Override
    protected void doDelete(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {

        try (PrintWriter out = response.getWriter()) {

            String id = request.getParameter("id");
            solicitacaoDivulgacaoEventoDAO.remover(Integer.parseInt(id));

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
        return "Servlet para solicitação de divulgação de notícias.";
    }
}
