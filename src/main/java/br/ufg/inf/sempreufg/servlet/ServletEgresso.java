package br.ufg.inf.sempreufg.servlet;

import br.ufg.inf.sempreufg.modelo.Egresso;
import br.ufg.inf.sempreufg.servico.EgressoService;
import br.ufg.inf.sempreufg.servico.ValidadorEgresso;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class ServletEgresso extends HttpServlet{

    static EgressoService egressoService;

    public void editaEgresso(Egresso egresso){

    }

    public Egresso instanciaEgresso(
        
    ){
        egressoService = new EgressoService();
        return egressoService.getEgresso("");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String nome = request.getParameter("nome");

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String nome = request.getParameter("id_Egresso");

        ValidadorEgresso validadorEgresso = new ValidadorEgresso();
        validadorEgresso.validaEgresso()
    }
}
