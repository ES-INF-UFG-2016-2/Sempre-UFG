/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufg.inf.sempreufg.dao;

import br.ufg.inf.sempreufg.enums.TipoParametro;
import br.ufg.inf.sempreufg.interfaces.ParametrosDAOInterfaces;
import br.ufg.inf.sempreufg.modelo.Parametros;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Kleudson
 */
public class ParametrosDAO implements ParametrosDAOInterfaces<Parametros>{
    
    private Parametros parametros = new Parametros();
    private List<Parametros> listaParametros = new ArrayList<Parametros>();

    @Override
    public Parametros buscar(int sigla) {
        return parametros;
    }

    @Override
    public Parametros buscar(String descricao) {
        return parametros;
    }

    @Override
    public Boolean adicionar(Parametros parametro) {
        return true;
    }

    @Override
    public Boolean remover(Parametros parametro) {
        return true;
    }

    @Override
    public Boolean atualizar(int sigla, Parametros novoParametro) {
        return true;
    }

    @Override
    public List<Parametros> retornarTodos() {
        return listaParametros;
    }

    @Override
    public List<Parametros> retornarPorTipo(TipoParametro tipo) {
        return listaParametros;
    }

    @Override
    public void inserir(Parametros entity) {
        
    }

    @Override
    public List<Parametros> select(String sql, Map<String, Object> parametros) {
        return listaParametros;
    }

    @Override
    public List<Parametros> select(String sql) {
        return listaParametros;
    }

    @Override
    public List<Parametros> selectAll() {
        return listaParametros;
    }

    @Override
    public Parametros buscarById(int id) {
        return parametros;
    }

    


    
}
