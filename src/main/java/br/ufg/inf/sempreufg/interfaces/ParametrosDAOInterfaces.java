/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufg.inf.sempreufg.interfaces;

import br.ufg.inf.sempreufg.enums.TipoParametro;
import br.ufg.inf.sempreufg.modelo.Parametros;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author Kleudson
 * @param <T>
 */
public interface ParametrosDAOInterfaces <T extends Serializable> extends IDao<Parametros>{
    
    Parametros buscar(int sigla);
    Parametros buscar(String descricao);
    Boolean adicionar(Parametros parametro);
    Boolean remover(Parametros parametro);
    Boolean atualizar(int sigla, Parametros novoParametro);
    List<Parametros> retornarTodos();
    List<Parametros> retornarPorTipo(TipoParametro tipo);
    
}
