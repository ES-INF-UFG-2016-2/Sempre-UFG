package br.ufg.inf.sempreufg.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import br.ufg.inf.sempreufg.modelo.Noticia;
import br.ufg.inf.sempreufg.repository.NoticiaRepository;
import org.json.JSONObject;

public class DivulgNoticServlet extends HttpServlet {

    private NoticiaRepository noticiaRepository = new NoticiaRepository();

    private void enviarNoticias(HttpServletResponse response)
        throws ServletException, IOException {

        response.setContentType("application/json");

        try (PrintWriter out = response.getWriter()) {

            JSONObject JSON = new JSONObject();

            noticiaRepository.obterListaNoticiasNaoExpiradas().forEach(noticia ->
            {
                JSON.put("id", noticia.getIdEvento());
                JSON.put("dataExpiracao", noticia.getDataExpiracao());
            });

            out.print(JSON);
            out.flush();

        }
    }

    private void receberNoticia(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {

        try (PrintWriter out = response.getWriter()) {

            String idEvento = request.getParameter("idEvento");
            String dataExpiracao = request.getParameter("dataPublicacao");
            DateFormat formatter = new SimpleDateFormat("mm/dd/yy");
            noticiaRepository.persisteNoticia(new Noticia(Integer.parseInt(idEvento), formatter.parse(dataExpiracao)));

            out.flush();

        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

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
        enviarNoticias(response);
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
        receberNoticia(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Servlet para divulgação de notícias.";
    }
}
