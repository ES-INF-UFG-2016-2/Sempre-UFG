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

public class ServletEgresso extends HttpServlet{

    static EgressoService egressoService;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("application/json");

        JSONObject JSON = new JSONObject();

        try (PrintWriter out = response.getWriter()) {

            int id = Integer.valueOf(request.getParameter("id"));

            ValidadorEgresso validadorEgresso = new ValidadorEgresso();
            boolean egressoExiste = validadorEgresso.validaEgresso(id);

            if (egressoExiste) {
                egressoService = new EgressoService();
                Egresso egresso = egressoService.getEgresso(id);

                JSON.put("id", egresso.getId());
                JSON.put("nome", egresso.getNome());
                JSON.put("nome_mae", egresso.getNome_mae());
                JSON.put("data_nascimento", egresso.getData_nascimento());
                JSON.put("sexo", egresso.getSexo());
                JSON.put("email_alternativo", egresso.getEmail_alternativo());
                JSON.put("foto_principal", egresso.getFoto_principal());
                JSON.put("fotos_adicionais", egresso.getFotos_adicionais());
                JSON.put("visibilidade", egresso.getVisibilidade());
                JSON.put("lista_historicosUFG", egresso.getLista_historicosUFG());
                JSON.put("naturalidade", egresso.getNaturalidade());

            } else try {
                throw new Exception("Egresso não encontrado!");
            } catch (Exception e) {
                e.printStackTrace();
            }

            out.print(JSON);
            out.flush();
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");

        try (PrintWriter out = response.getWriter()) {

            //capturar egresso do usuario e atualizar base de dados
            String id = request.getParameter("id");


        }




    }


}
