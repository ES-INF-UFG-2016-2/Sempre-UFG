/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufg.inf.sempreufg.servico;

import br.ufg.inf.sempreufg.enums.TipoParametro;
import br.ufg.inf.sempreufg.modelo.Parametros;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author Kleudson
 */
public interface ParametrosServiceInterface {
    
    Boolean criar (int sigla, TipoParametro tipo, String valor);
    HashMap<String,String> recuperarValores(int sigla);
    Parametros buscar(int sigla);
    Parametros buscar(String descricao);
    List<Parametros> retornarPorTipo(TipoParametro tipo);
    List<Parametros> retornarTodos();
    Boolean atualizar(int sigla, Parametros parametro);
    Boolean remover(int sigla);
    
}
