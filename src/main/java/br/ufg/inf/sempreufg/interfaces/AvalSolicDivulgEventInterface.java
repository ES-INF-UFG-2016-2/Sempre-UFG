package br.ufg.inf.sempreufg.interfaces;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.Timestamp;


public interface AvalSolicDivulgEventInterface {
    
    boolean reprovaSolicDivulEvent(String parecer, Date data_aprovacao, int evento_id, int usuario_id) throws Exception;

    boolean aprovaSolicDivulEvent(String parecer, Date data_aprovacao, int evento_id, int usuario_id) throws Exception;
    
    String buscaEscopoDivulEvento(int evento_id);
    String buscaFormaDivulEvento(int evento_id);
}
