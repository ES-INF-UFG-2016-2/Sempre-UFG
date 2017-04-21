/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufg.inf.sempreufg.daoParaTestes;

import br.ufg.inf.sempreufg.db.ConexaoBanco;
import br.ufg.inf.sempreufg.entidadesParaTestes.*;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Kalyn
 */
public class RD_DivulgInfoDAO {
        
    public void LimparEvento(){
        
        try {
            String sql = "DELETE FROM EVENTO;";
            
            Connection con = ConexaoBanco.getConnection();
            Statement stm = con.createStatement();
            stm.execute(sql);

            con.close();
            
        } catch (SQLException ex) {
            Logger.getLogger(RD_DivulgInfoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void LimparAreaDeConhecimento(){
        
        try {
            String sql = "DELETE FROM AREA_DE_CONHECIMENTO;";
            
            Connection con = ConexaoBanco.getConnection();
            Statement stm = con.createStatement();
            stm.execute(sql);

            con.close();
            
        } catch (SQLException ex) {
            Logger.getLogger(RD_DivulgInfoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void LimparInstanciaAdministrativa(){
        
        try {
            String sql = "DELETE FROM INSTANCIA_ADMINISTRATIVA_UFG;";
            
            Connection con = ConexaoBanco.getConnection();
            Statement stm = con.createStatement();
            stm.execute(sql);

            con.close();
            
        } catch (SQLException ex) {
            Logger.getLogger(RD_DivulgInfoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void LimparEventoRelacionadoArea(){
        
        try {
            String sql = "DELETE FROM EVENTO_RELACIONADO_A_AREA;";
            
            Connection con = ConexaoBanco.getConnection();
            Statement stm = con.createStatement();
            stm.execute(sql);

            con.close();
            
        } catch (SQLException ex) {
            Logger.getLogger(RD_DivulgInfoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void LimparEventoRelacionadoInstancia(){
        
        try {
            String sql = "DELETE FROM EVENTO_INTERESSA_A_INSTANCIA;";
            
            Connection con = ConexaoBanco.getConnection();
            Statement stm = con.createStatement();
            stm.execute(sql);

            con.close();
            
        } catch (SQLException ex) {
            Logger.getLogger(RD_DivulgInfoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public String InserirEvento (Evento evento){
        String sql = "INSERT INTO EVENTO VALUES (?, ?, ?::tipo_evento, ?, ?,"
                + " ?, ?, ?::forma_divulgacao, ?::escopo_divulgacao, ?)";
        String retorno;
        
        try {
            Connection con = ConexaoBanco.getConnection();
            PreparedStatement pst = con.prepareStatement(sql);
            
            pst.setInt(1, evento.getEVENTO_ID());
            
            if(evento.getASSUNTO() == null){
                pst.setNull(2, Types.VARCHAR);
            }
            else{
                pst.setString(2, evento.getASSUNTO());
            }
            
            if(evento.getTIPO() == null){
                pst.setNull(3, Types.VARCHAR);
            }
            else{
                pst.setString(3, evento.getTIPO());
            }
            
            if(evento.getDESCRICAO() == null){
                pst.setNull(4, Types.VARCHAR);
            }
            else{
                pst.setString(4, evento.getDESCRICAO());
            }
            
            if(evento.getDATA_SOLICITA_DIVULGACAO() == null){
                pst.setNull(5, Types.TIMESTAMP);
            }
            else{
                pst.setTimestamp(5, evento.getDATA_SOLICITA_DIVULGACAO());
            }
            
            if(evento.getSOLICITANTE_DIVULGACAO() == null){
                pst.setNull(6, Types.VARCHAR);
            }
            else{
                pst.setString(6, evento.getSOLICITANTE_DIVULGACAO());
            }
            
            if(evento.getSOLICITANTE_EMAIL() == null){
                pst.setNull(7, Types.VARCHAR);
            }
            else{
                pst.setString(7, evento.getSOLICITANTE_EMAIL());
            }
            
            if(evento.getFORMA_DIVULGACAO() == null){
                pst.setNull(8, Types.VARCHAR);
            }
            else{
                pst.setString(8, evento.getFORMA_DIVULGACAO());
            }
            
            if(evento.getESCOPO_DIVULGACAO() == null){
                pst.setNull(9, Types.VARCHAR);
            }
            else{
                pst.setString(9, evento.getESCOPO_DIVULGACAO());
            }
            
            if(evento.getDATA_EXPIRACAO() == null){
                pst.setNull(10, Types.DATE);
            }
            else{
                pst.setDate(10, evento.getDATA_EXPIRACAO());
            }
            
            pst.execute();
            retorno = "sucesso";
            
        } catch (Exception ex) {
            retorno = ex.getMessage();
        }
        
        return retorno;
    }
    
    public String InserirAreaDeConhecimento(AreaDeConhecimento area){
        String sql = "INSERT INTO AREA_DE_CONHECIMENTO VALUES (?, ?, ?, ?)";
        String retorno;
        
        try {
            Connection con = ConexaoBanco.getConnection();
            PreparedStatement pst = con.prepareStatement(sql);
            
            pst.setInt(1, area.getAREA_DE_CONHECIMENTO_ID());
            
            if(area.getNOME() == null){
                pst.setNull(2, Types.VARCHAR);
            }
            else{
                pst.setString(2, area.getNOME());
            }
            
            if(area.getCODIGO()== null){
                pst.setNull(3, Types.INTEGER);
            }
            else{
                pst.setInt(3, Integer.parseInt(area.getCODIGO()));
            }
            
            if(area.getAREA_CONHECIMENTO() == null){
                pst.setNull(4, Types.INTEGER);
            }
            else{
                pst.setInt(4, Integer.parseInt(area.getAREA_CONHECIMENTO()));
            }
            
            pst.execute();
            retorno = "sucesso";
            
        } catch (Exception ex) {
            retorno = ex.getMessage();
        }
        
        return retorno;
    }
    
    public String InserirInstanciaAdministrativa(InstanciaAdministrativa instancia){
        String sql = "INSERT INTO INSTANCIA_ADMINISTRATIVA_UFG VALUES (?, ?, ?, ?::tipo_instancia, ?, ?, ?, ?)";
        String retorno;
        
        try {
            Connection con = ConexaoBanco.getConnection();
            PreparedStatement pst = con.prepareStatement(sql);
            
            pst.setInt(1, instancia.getINSTANCIA_ADMINISTRATIVA_ID());
            
            if(instancia.getSIGLA_INSTANCIA()== null){
                pst.setNull(2, Types.VARCHAR);
            }
            else{
                pst.setString(2, instancia.getSIGLA_INSTANCIA());
            }
            
            if(instancia.getNOME() == null){
                pst.setNull(3, Types.VARCHAR);
            }
            else{
                pst.setString(3, instancia.getNOME());
            }
            
            if(instancia.getTIPO()== null){
                pst.setNull(4, Types.VARCHAR);
            }
            else{
                pst.setString(4, instancia.getTIPO());
            }
            
            if(instancia.getDATA_CRIACAO() == null){
                pst.setNull(5, Types.DATE);
            }
            else{
                pst.setDate(5, instancia.getDATA_CRIACAO());
            }
            
            if(instancia.getDATA_ENCERR() == null){
                pst.setNull(6, Types.DATE);
            }
            else{
                pst.setDate(6, instancia.getDATA_ENCERR());
            }
            
            if(instancia.getEMAIL_INSTITUCIONAL() == null){
                pst.setNull(7, Types.VARCHAR);
            }
            else{
                pst.setString(7, instancia.getEMAIL_INSTITUCIONAL());
            }
            
            if(instancia.getURL_INSTITUCIONAL() == null){
                pst.setNull(8, Types.VARCHAR);
            }
            else{
                pst.setString(8, instancia.getURL_INSTITUCIONAL());
            }
            
            pst.execute();
            retorno = "sucesso";
            
        } catch (Exception ex) {
            retorno = ex.getMessage();
        }
        
        return retorno;
    }
    
    public String InserirEventoRelacionadoArea(EventoRelacionadoArea eventoArea){
        String sql = "INSERT INTO EVENTO_RELACIONADO_A_AREA VALUES (?, ?)";
        String retorno;
        
        try {
            Connection con = ConexaoBanco.getConnection();
            PreparedStatement pst = con.prepareStatement(sql);
            
            if(eventoArea.getEVENTO() == null){
                pst.setNull(1, Types.INTEGER);
            }
            else{
                pst.setInt(1, Integer.parseInt(eventoArea.getEVENTO()));
            }
            
            if(eventoArea.getAREA_CONHECIMENTO() == null){
                pst.setNull(2, Types.INTEGER);
            }
            else{
                pst.setInt(2, Integer.parseInt(eventoArea.getAREA_CONHECIMENTO()));
            }
            
            pst.execute();
            retorno = "sucesso";
            
        } catch (Exception ex) {
            retorno = ex.getMessage();
        }
        
        return retorno;
    }
    
    public String InserirEventoRelacionadoInstancia(EventoRelacionadoInstancia eventoInstancia){
        String sql = "INSERT INTO EVENTO_INTERESSA_A_INSTANCIA VALUES(?, ?)";
        String retorno;
        
        try {
            Connection con = ConexaoBanco.getConnection();
            PreparedStatement pst = con.prepareStatement(sql);
            
            if(eventoInstancia.getEVENTO() == null){
                pst.setNull(1, Types.INTEGER);
            }
            else{
                pst.setInt(1, Integer.parseInt(eventoInstancia.getEVENTO()));
            }
            
            if(eventoInstancia.geINSTANCIA_ADMINISTRATIVA() == null){
                pst.setNull(2, Types.INTEGER);
            }
            else{
                pst.setInt(2, Integer.parseInt(eventoInstancia.geINSTANCIA_ADMINISTRATIVA()));
            }
            
            pst.execute();
            retorno = "sucesso";
            
        } catch (Exception ex) {
            retorno = ex.getMessage();
        }
        
        return retorno;
    }
}
