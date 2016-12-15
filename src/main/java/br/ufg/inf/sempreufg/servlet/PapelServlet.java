package br.ufg.inf.sempreufg.servlet;

import br.ufg.inf.sempreufg.dao.PapelDAO;
import br.ufg.inf.sempreufg.modelo.Papel;
import org.json.JSONArray;
import org.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class PapelServlet extends HttpServlet{

        private PapelDAO papelDAO = new PapelDAO();

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

                String idPapel = request.getParameter("idPapel");
                JSONArray JSON = new JSONArray();

                if(idPapel != null && !idPapel.trim().equals("")){
                    Papel papel = papelDAO.consultarPorId(Integer.parseInt(idPapel));
                    JSON.put(papel.toJSON());
                }
                else {
                    papelDAO.consultarTodos().forEach(JSON::put);
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

                String papelStr = request.getParameter("papel");
                Papel papel = Papel.fromJSON(new JSONObject(papelStr));
                papelDAO.salvar(papel.getSiglaPapel(), papel.getNomePapel(), papel.getListaUsuario(), papel.getListaRecurso());

                out.flush();

            }
        }

        @Override
        protected void doPut(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

            try (PrintWriter out = response.getWriter()) {

                String idPapel = request.getParameter("idPapel");
                String papelStr = request.getParameter("papel");
                papelDAO.atualizar(Integer.parseInt(idPapel), Papel.fromJSON(new JSONObject(papelStr)));

                out.flush();

            }
        }

        @Override
        protected void doDelete(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

            try (PrintWriter out = response.getWriter()) {

                String idPapel = request.getParameter("idPapel");
                papelDAO.remover(Integer.parseInt(idPapel));

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
            return "Servlet para gerenciamento e CRUD de papeis.";
        }
}
