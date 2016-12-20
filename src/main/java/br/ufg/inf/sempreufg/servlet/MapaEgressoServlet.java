/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufg.inf.sempreufg.servlet;

import br.ufg.inf.sempreufg.servico.MapaEgressoService;
import org.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class MapaEgressoServlet extends HttpServlet{

    private MapaEgressoService mapaEgressoService = new MapaEgressoService();

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String camposAgrupamento = request.getParameter("camposAgrupamentos");
        JSONObject camposAgrupamentoJson = new JSONObject(camposAgrupamento);
        PrintWriter out = response.getWriter();
        JSONObject egressosAgrupados = mapaEgressoService.obtenhaJSONEgressosAgrupados(camposAgrupamentoJson);

        out.print(egressosAgrupados);
    }
}
