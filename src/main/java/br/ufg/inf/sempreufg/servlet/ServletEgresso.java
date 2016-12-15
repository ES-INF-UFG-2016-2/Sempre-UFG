package br.ufg.inf.sempreufg.servlet;

import br.ufg.inf.sempreufg.modelo.Egresso;
import br.ufg.inf.sempreufg.servico.EgressoService;
import br.ufg.inf.sempreufg.servico.ValidadorEgresso;
import org.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class ServletEgresso extends HttpServlet {

    private EgressoService egressoService;

    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        boolean egressoValido = validarEgresso(request);

        if (egressoValido) {
            enviarEgresso(request, response);
        } else {
            enviarErroDeValidacao(response);
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
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            atualizarEgresso(request, response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private boolean validarEgresso(HttpServletRequest request) throws ServletException, IOException {

        ValidadorEgresso validadorEgresso = new ValidadorEgresso();
        int id = Integer.valueOf(request.getParameter("id"));

        return validadorEgresso.validaEgresso(id);
    }

    private void enviarEgresso(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {

        response.setContentType("application/json");

        JSONObject egressoAsJson = new JSONObject();

        try (PrintWriter out = response.getWriter()) {

            int id = Integer.valueOf(request.getParameter("id"));

            egressoService = new EgressoService();
            Egresso egresso = egressoService.getEgresso(id);
            egressoAsJson = egresso.toJson();

            out.print(egressoAsJson);
            out.flush();
        }
    }

    private void enviarErroDeValidacao(HttpServletResponse response)
        throws ServletException, IOException {

        response.setContentType("application/json");

        JSONObject JSON = new JSONObject();

        try (PrintWriter out = response.getWriter()) {

            JSON.put("erro", "Egresso não Encontrado");
            out.print(JSON);
            out.flush();
        }
    }


    private void atualizarEgresso(HttpServletRequest request, HttpServletResponse response)
        throws Exception {

        response.setContentType("text/html");

        try (PrintWriter out = response.getWriter()) {

            JSONObject egressoJson = new JSONObject(request.getParameter("egresso"));
            Egresso egresso = Egresso.fromJson(egressoJson);
            egressoService = new EgressoService();
            egressoService.atualizarEgresso(egresso);
            out.flush();
        }
    }
}
