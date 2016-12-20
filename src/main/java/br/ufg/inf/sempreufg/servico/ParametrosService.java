/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufg.inf.sempreufg.servico;

import br.ufg.inf.sempreufg.enums.TipoParametro;
import br.ufg.inf.sempreufg.modelo.Parametros;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author Kleudson
 */
public class ParametrosService implements ParametrosServiceInterface{
    
    private Parametros parametros = new Parametros();
    private HashMap<String, String> valores;
    private List<Parametros> listaParametros = new ArrayList<Parametros>();

    @Override
    public Boolean criar(int sigla, TipoParametro tipo, String valor) {
        return true;
    }

    @Override
    public HashMap<String, String> recuperarValores(int sigla) {
        return valores;
    }

    @Override
    public Parametros buscar(int sigla) {
        return parametros;
    }

    @Override
    public Parametros buscar(String descricao) {
        return parametros;
    }

    @Override
    public List<Parametros> retornarPorTipo(TipoParametro tipo) {
        return listaParametros;
    }

    @Override
    public List<Parametros> retornarTodos() {
        return listaParametros;
    }

    @Override
    public Boolean atualizar(int sigla, Parametros parametro) {
        return true;
    }

    @Override
    public Boolean remover(int sigla) {
        return true;
    }
    
    
    
    
}
