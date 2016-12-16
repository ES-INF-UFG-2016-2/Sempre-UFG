package br.ufg.inf.sempreufg.servlet;

import br.ufg.inf.sempreufg.servico.ConsultaServico;
import com.google.gson.Gson;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Esta classe é responsável por gerenciar as requisições relacionadas às consultas de egressos.
 */
@WebServlet(name = "ConsultaEgressosServlet", urlPatterns = {"/pages/consultas/nova-consulta"})
public class ConsultaEgressosServlet extends HttpServlet {

    private static final String ACAO_NOVA_CONSULTA = "definirConsulta";

    private static final String PARAMETRO_ACAO = "acao";
    private static final String PARAMETRO_DADOS_CONSULTA = "dadosConsulta";
    private static final String PARAMETRO_RESULTADO = "resultado";
    private static final String PARAMETRO_MENSAGEM = "mensagem";

    private static final int RESULTADO_SUCESSO = 0;
    private static final int RESULTADO_ACAO_DESCONHECIDA = 1;
    private static final int RESULTADO_ERRO_SALVAR = 2;

    /**
     * Processa requisições para os métodos HTTP <code>GET</code> e <code>POST</code>.
     *
     * @param request Requisição do servlet
     * @param response Resporta do servlet
     * @throws ServletException se um erro específico do servlet acontece
     * @throws IOException se um erro de entrada e saída acontece.
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String acao = request.getParameter(PARAMETRO_ACAO);

        Map<String, Object> resultado;
        if (acao == null) {
            carregarPaginaFormularioConsulta(request, response);
        } else {
            switch (acao) {
                case ACAO_NOVA_CONSULTA:
                    resultado = definirConsulta(request, response);
                    break;
                default:
                    resultado = new HashMap<String, Object>();
                    resultado.put(PARAMETRO_RESULTADO, RESULTADO_ACAO_DESCONHECIDA);
                    resultado.put(PARAMETRO_MENSAGEM, "Tipo de requisição desconhecido");
            }

            Gson gson = new Gson();
            String resultadoJson = gson.toJson(resultado);

            response.setContentType("text/html;charset=UTF-8");
            response.getWriter().write(resultadoJson);
        }
    }

    /**
     * Carrega a página do formulário da consulta.
     *
     * @param request Requisição do servlet
     * @param response Resporta do servlet
     * @throws ServletException se um erro específico do servlet acontece
     * @throws IOException se um erro de entrada e saída acontece.
     */
    private void carregarPaginaFormularioConsulta(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ConsultaServico consultaServico = new ConsultaServico();
        Map<String, String> camposConsulta = consultaServico.buscarMapaTodasEntidades();
        request.setAttribute("mapaCampos", camposConsulta);
        request.getRequestDispatcher("/pages/consultas/formulario-consulta.jsp").forward(request, response);
    }

    /**
     * Recupera dos dados da consulta enviados na requisição e salva os mesmos no banco de dados, obtendo assim um
     * resultado.
     *
     * @param request Requisição do servlet
     * @param response Resporta do servlet
     * @return um mapa contendo o resultado da operação de definição de consulta.
     * @throws ServletException se um erro específico do servlet acontece
     * @throws IOException se um erro de entrada e saída acontece.
     */
    private Map definirConsulta(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Map<String, Object> resultado = new HashMap<>();

        String dadosConsultaJson = request.getParameter(PARAMETRO_DADOS_CONSULTA);
        System.out.println("JSON: " + dadosConsultaJson);

        ConsultaServico consultaServico = new ConsultaServico();
        boolean resultadoSalvamento = consultaServico.salvarConsulta(dadosConsultaJson);

        resultado = new HashMap<String, Object>();

        if (resultadoSalvamento) {
            resultado.put(PARAMETRO_RESULTADO, RESULTADO_SUCESSO);
            resultado.put(PARAMETRO_MENSAGEM, "Nova consulta criada com sucesso.");
        } else {
            resultado.put(PARAMETRO_RESULTADO, RESULTADO_ERRO_SALVAR);
            resultado.put(PARAMETRO_MENSAGEM, "Não foi possível salvar a consulta.");
        }

        return resultado;
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
        processRequest(request, response);
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
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Servlet responsável por gerenciar as requisições relacionadas às consultas de egressos";
    }// </editor-fold>

}
