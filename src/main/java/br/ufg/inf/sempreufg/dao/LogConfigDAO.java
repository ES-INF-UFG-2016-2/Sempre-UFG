/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufg.inf.sempreufg.dao;

import br.ufg.inf.sempreufg.dados.ManipulaDB;
import br.ufg.inf.sempreufg.modelo.ParametroLog;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author DYEGO-VOSTRO
 */
public class LogConfigDAO 
{
    static Connection conexao = null;

	public Connection abreConexao() 
        {

		if (conexao == null) 
                {
			ManipulaDB db;
			try 
                        {
				db = new ManipulaDB();
				return db.criaConexao();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return null;
	}
        
        public static void testaConexao() throws IOException 
        {

            if (conexao == null) 
            {
		ManipulaDB db = new ManipulaDB();
		conexao = db.criaConexao();

            }
	}
        
        public void persistirParametros(ArrayList<ParametroLog> parametros )
        {
            Iterator<ParametroLog> iterador = parametros.iterator();
            
            while( iterador.hasNext() )
            {
                ParametroLog parametro = iterador.next();
                
                String siglaParametro = parametro.getSigla();
                String idSempreUFG = parametro.getIdSempreUFG();
                String tipoParametro = parametro.getTipo();
                String descricaoParametro = parametro.getDescricao();
                String valor = parametro.getValor();
                
                persistirParametro(siglaParametro, idSempreUFG, tipoParametro, descricaoParametro, valor );
            }
        }

    private void persistirParametro(String siglaParametro, String idSempreUFG, String tipoParametro, String descricaoParametro, String valor )
    {
        try
        {
            testaConexao();
            
            PreparedStatement existe = conexao.prepareStatement("SELECT EXISTS (SELECT 1 FROM PARAMETRO WHERE sigla_parametro=?)");
            existe.setString( 1, siglaParametro);
            
            boolean nome = false;
            ResultSet teste = existe.executeQuery();
            while( teste.next() )
			{
				nome = teste.getBoolean(1);
			}
            
            
            if( nome == false )
            {
            	System.out.println( "entrei onde nao devia");
            	PreparedStatement instrucao = conexao.prepareStatement( "INSERT INTO PARAMETRO (sigla_parametro, idSempreUFG, tipo, descricao_parametro, valor) VALUES(?, ?, ?, ?, ?)");

	            instrucao.setString(1, siglaParametro);
	            instrucao.setString(2, idSempreUFG);
	            instrucao.setString(3, tipoParametro);
	            instrucao.setString(4, descricaoParametro);
	            instrucao.setString(5, valor);
            
	            instrucao.executeUpdate();
	            instrucao.close();
            }
            else
            {
            	PreparedStatement instrucao = conexao.prepareStatement( "UPDATE PARAMETRO SET idSempreUFG = ?, tipo = ?, descricao_parametro = ?, valor = ? WHERE sigla_parametro = ?;");

            	instrucao.setString(1, idSempreUFG);
	            instrucao.setString(2, tipoParametro);
	            instrucao.setString(3, descricaoParametro);
	            instrucao.setString(4, valor);
	            instrucao.setString(5, siglaParametro);
	            
	            instrucao.executeUpdate();
	            instrucao.close();
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

	public String getCaminhoArquivoDeConfiguracao()
	{
		String caminho = null;
		
		try
		{
			testaConexao();
			PreparedStatement instrucao = conexao.prepareStatement( "SHOW config_file" );
			ResultSet resultado = instrucao.executeQuery();
			
			while( resultado.next() )
			{
				caminho = resultado.getString( 1 );
			}
						
		} catch (Exception e ) {
			e.printStackTrace();
		}
		
		return caminho;
	}
}
