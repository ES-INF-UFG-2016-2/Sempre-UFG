package br.ufg.inf.sempreufg.dao;

import br.ufg.inf.sempreufg.dados.ManipulaDB;
import static br.ufg.inf.sempreufg.dao.AvalSolicDivulgEventDAO.conn;
import br.ufg.inf.sempreufg.interfaces.AvalSolicDivulgEventInterface;
import br.ufg.inf.sempreufg.modelo.AprovDivulgEvent;
import br.ufg.inf.sempreufg.modelo.DivulgacaoEventoComunidade;
import br.ufg.inf.sempreufg.modelo.DivulgacaoNoticia;
import br.ufg.inf.sempreufg.modelo.Evento;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class AvalSolicDivulgEventDAO implements AvalSolicDivulgEventInterface {
    
    // conexao
    static Connection conn = null;

    public Connection abreConexao() {
        if (conn == null) {
                ManipulaDB db;
                try {
                        db = new ManipulaDB();
                        return db.criaConexao();
                } catch (Exception e) {
                        e.printStackTrace();
                }
        }
        return null;
    }

    public static void testaConexao() throws IOException {

        if (conn == null) {
                ManipulaDB db = new ManipulaDB();
                conn = db.criaConexao();

        }
    }
    
    
    @Override
    public boolean reprovaSolicDivulEvent(String parecer, Date data_aprovacao_ou_rejeicao, int evento_id, int usuario_id) throws Exception {  
        try {
            testaConexao();

            String update_reprov_data = "UPDATE aprovacao_de_divulgacao"
                            + "SET divulgacao_aprovada = ?,"
                            + "SET parecer_sobre_divulgacao = ?,"
                            + "SET data_aprovacao_ou_rejeicao = ?"
                            + "WHERE evento = ? AND usuario = ?";

            PreparedStatement ps = conn.prepareStatement(update_reprov_data);
            ps.setBoolean(1, false);
            ps.setString(2, parecer);
            ps.setDate(3, data_aprovacao_ou_rejeicao);
            ps.setInt(4, evento_id);
            ps.setInt(5, usuario_id);
            ps.executeQuery();
        } catch (Exception e) {
            // log the exception
            throw e;
        }

        return false;
    }

    @Override
    public boolean aprovaSolicDivulEvent(String parecer, Date data_aprovacao_ou_rejeicao, int evento_id, int usuario_id) throws Exception {
        try {
            testaConexao();

            String update_reprov_data = "UPDATE aprovacao_de_divulgacao"
                            + "SET divulgacao_aprovada = ?,"
                            + "SET parecer_sobre_divulgacao = ?,"
                            + "SET data_aprovacao_ou_rejeicao = ?"
                            + "WHERE evento = ? AND usuario = ?";

            PreparedStatement ps = conn.prepareStatement(update_reprov_data);
            ps.setBoolean(1, true);
            ps.setString(2, parecer);
            ps.setDate(3, data_aprovacao_ou_rejeicao);
            ps.setInt(4, evento_id);
            ps.setInt(5, usuario_id);
            ps.executeQuery();
            
            if(buscaEscopoDivulEvento(evento_id).equals("EGRESSOS")) {
                new AprovDivulgEvent(evento_id, true);
            } else if(buscaEscopoDivulEvento(evento_id).equals("COMUNIDADE")) {
                if(buscaFormaDivulEvento(evento_id).equals("MENSAGEM")) {
                    Evento evento = new Evento();
                    //necessitaria buscar o objeto evento através do id 'evento.busca_evento(evento_id);
                    new DivulgacaoEventoComunidade(evento);
                } else if(buscaFormaDivulEvento(evento_id).equals("NOTICIA")) {
                    new DivulgacaoNoticia(evento_id);
                } else if(buscaFormaDivulEvento(evento_id).equals("AMBOS")) {
                    Evento evento = new Evento();
                    new DivulgacaoEventoComunidade(evento);
                    new DivulgacaoNoticia(evento_id);
                }
            }
            
        } catch (Exception e) {
            // log the exception
            throw e;
        }

        return false;
    }
    
    
    @Override
    public String buscaEscopoDivulEvento(int evento_id) {
        String busca = "SELECT escopo_divulgacao FROM aprovacao_de_divulgacao WHERE " + "evento = ?;";
        
        String escopo_divulgacao = "";
        
        try {
            PreparedStatement ps = conn.prepareStatement(busca);
            ps.setInt(1, 1);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                escopo_divulgacao = rs.getString("escopo_divulgacao");
                return escopo_divulgacao;
            } else {
                return null;
            }
        } catch (Exception e) {

        }

        return null;
    }
    
    @Override
    public String buscaFormaDivulEvento(int evento_id) {
        String busca = "SELECT forma_divulgacao FROM aprovacao_de_divulgacao WHERE " + "evento = ?;";
        
        String forma_divulgacao = "";
        
        try {
            PreparedStatement ps = conn.prepareStatement(busca);
            ps.setInt(1, 1);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                forma_divulgacao = rs.getString("forma_divulgacao");
                return forma_divulgacao;
            } else {
                return null;
            }
        } catch (Exception e) {

        }

        return null;
    }
}
