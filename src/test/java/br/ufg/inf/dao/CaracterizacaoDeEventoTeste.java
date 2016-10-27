/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufg.inf.dao;

import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.After;


/**
 *
 * @author Kalyn
 */
public class CaracterizacaoDeEventoTeste {
    private int contador = 0;
    public CaracterizacaoDeEventoTeste() {
    }
    
    private int contagem(){
        return contador ++;
    }
    
    @Before
    public void preparacao(){
        String sql = "DELETE FROM EVENTO;";
        ExecutorSqlDAO.executarSQL(sql);
        
        //Para assunto repetido
        sql = "INSERT INTO EVENTO VALUES (" + contagem() + ", \'Teste 1.2.2\', \'NOTICIA\', \'Assunto repetido\', "
                + "\'20-10-2016 10:20:00\', \'Edmundo Sergio Spoto\', \'edmund@inf.ufg.br\', "
                + "\'NOTICIA\', \'COMUNIDADE\', \'20-10-2017\')";
        ExecutorSqlDAO.executarSQL(sql);
    }
    
    @After
    public void conclusao(){
        String sql = "DELETE FROM EVENTO;";
        ExecutorSqlDAO.executarSQL(sql);
    }
    
    @Test
    public void testeTodosCamposValidos() {
        String sqlTesteObjetivo = "INSERT INTO evento VALUES (" + contagem() + ", \'Teste 1.1\', \'NOTICIA\', \'Campos Validos\', "
                + "\'20-10-2016 10:20:00\', \'Edmundo Sergio Spoto\', "
                + "\'edmundoinf.ufg.br\', \'NOTICIA\', \'COMUNIDADE\', \'20-10-2017\')";
        
        String sqlTesteRetorno = "select * from evento where assunto = \'Teste 1.1\'";
        
        ExecutorSqlDAO.executarSQL(sqlTesteObjetivo);
        String retorno = ExecutorSqlDAO.executarSqlComRetorno(sqlTesteRetorno, "Assunto");
        
        assertEquals("Teste 1.1", retorno);
    }
    
    @Test
    public void testeAssuntoNulo(){
        String sqlTesteObjetivo = "INSERT INTO EVENTO VALUES (" + contagem() + ", "
                + "\'null\', \'NOTICIA\', \'Assunto = "
                + "nulo.\', \'20-10-2016 10:20:00\', \'Edmundo Sergio Spoto\', "
                + "\'edmundo@inf.ufg.br\', \'NOTICIA\', \'COMUNIDADE\', \'20-10-2017\');";
        
        String sqlTesteRetorno = "select * from evento where descricao = \'Assunto = nulo.\'";
        
        ExecutorSqlDAO.executarSQL(sqlTesteObjetivo);
        String retorno = ExecutorSqlDAO.executarSqlComRetorno(sqlTesteRetorno, "Assunto");
        
        assertEquals("Nenhum Resultado", retorno);
    }

    @Test
    public void testeDescricaoEventoNulo(){
        String sqlTesteObjetivo = "INSERT INTO EVENTO VALUES (" + contagem() +", "
                + "\'Teste 1.3\', \'NOTICIA\', \'null\', \'20-10-2016 10:20:00\', "
                + "\'Edmundo Sergio Spoto\', \'edmundo@inf.ufg.br\', \'NOTICIA\', "
                + "\'COMUNIDADE\', \'20-10-2017\')";
        
        String sqlTesteRetorno = "select * from evento where assunto = \'Teste 1.3\'";
        
        ExecutorSqlDAO.executarSQL(sqlTesteObjetivo);
        String retorno = ExecutorSqlDAO.executarSqlComRetorno(sqlTesteRetorno, "Assunto");
        
        assertEquals("Nenhum Resultado", retorno);
    }
    
    @Test
    public void testeDataHoraDivulgacaoNulo(){
        String sqlTesteObjetivo = "INSERT INTO EVENTO VALUES (" + contagem() +", "
                + "\'Teste 1.4\', \'NOTICIA\', \'Data e Hora = nulo.\', "
                + "\'null\', \'Edmundo Sergio Spoto\', \'edmundo@inf.ufg.br\\',"
                + " \'NOTICIA\', \'COMUNIDADE\\', \'20-10-2017\')";
        
        String sqlTesteRetorno = "select * from evento where assunto = \'Teste 1.4\'";
        
        ExecutorSqlDAO.executarSQL(sqlTesteObjetivo);
        String retorno = ExecutorSqlDAO.executarSqlComRetorno(sqlTesteRetorno, "Assunto");
        
        assertEquals("Nenhum Resultado", retorno);
    }
    
    @Test
    public void testeIdentificacaoQuemSolicitaNulo(){
        String sqlTesteObjetivo = "INSERT INTO EVENTO VALUES (" + contagem() +", "
                + "\'Teste 1.5\', \'NOTICIA\', \'Identificação de quem solicita = nulo\',"
                + " \'20-10-2016 10:20:00\', \'null\', \'edmundo@inf.ufg.br\',"
                + " \'NOTICIA\', \'COMUNIDADE\', \'20-10-2017\')";
        
        String sqlTesteRetorno = "select * from evento where assunto = \'Teste 1.5\'";
        
        ExecutorSqlDAO.executarSQL(sqlTesteObjetivo);
        String retorno = ExecutorSqlDAO.executarSqlComRetorno(sqlTesteRetorno, "Assunto");
        
        assertEquals("Nenhum Resultado", retorno);
    }
    
    @Test
    public void testeEmailSolicitanteNulo(){
        String sqlTesteObjetivo = "INSERT INTO EVENTO VALUES (" + contagem() +", "
                + "\'Teste 1.6\', \'NOTICIA\', \'Email solicitante = nulo\', "
                + "\'20-10-2016 10:20:00\', \'Edmundo Sergio Spoto\', \'null\', "
                + "\'NOTICIA\', \'COMUNIDADE\', \'20-10-2017\')";
        
        String sqlTesteRetorno = "select * from evento where assunto = \'Teste 1.6\'";
        
        ExecutorSqlDAO.executarSQL(sqlTesteObjetivo);
        String retorno = ExecutorSqlDAO.executarSqlComRetorno(sqlTesteRetorno, "Assunto");
        
        assertEquals("Nenhum Resultado", retorno);
    }
    
    @Test
    public void testeDataExpiracaoNulo(){
        String sqlTesteObjetivo = "INSERT INTO EVENTO VALUES (" + contagem() +", "
                + "\'Teste 1.7.1\', \'NOTICIA\', \'Data de Expiração = nulo.\',"
                + " \'20-10-2016 10:20:00\', \'Edmundo Sergio Spoto\',"
                + " \'edmundo@inf.ufg.br\', \'NOTICIA\', \'null\')";
        
        String sqlTesteRetorno = "select * from evento where assunto = \'Teste 1.7.1\'";
        
        ExecutorSqlDAO.executarSQL(sqlTesteObjetivo);
        String retorno = ExecutorSqlDAO.executarSqlComRetorno(sqlTesteRetorno, "Assunto");
        
        assertEquals("Nenhum Resultado", retorno);
    }
    
    @Test
    public void testeDataExpiracaoMenorQueAtual(){
        String sqlTesteObjetivo = "INSERT INTO EVENTO VALUES (" + contagem() +", "
                + "\'Teste 1.7.2\', \'NOTICIA\', \'Data de expiração anterior a"
                + " data atual\', \'20-10-2016 10:20:00\', \'Edmundo Sergio Spoto\',"
                + " \'edmundo@inf.ufg.br\', \'NOTICIA\', \'COMUNIDADE\', \'08-10-2016\')";
        
        String sqlTesteRetorno = "select * from evento where assunto = \'Teste 1.7.2\'";
        
        ExecutorSqlDAO.executarSQL(sqlTesteObjetivo);
        String retorno = ExecutorSqlDAO.executarSqlComRetorno(sqlTesteRetorno, "Assunto");
        
        assertEquals("Nenhum Resultado", retorno);
    }
    
    @Test
    public void testeDataExpiracaoMenorQueDataDivulgacao(){
        String sqlTesteObjetivo = "INSERT INTO EVENTO VALUES (" + contagem() +", "
                + "\'Teste 1.7.3\', \'NOTICIA\', \'Data de Expiração anterior a"
                + " data de divulgação\', \'20-10-2016 10:20:00\', \'Edmundo"
                + " Sergio Spoto\', \'edmundo@inf.ufg.br\', \'NOTICIA\',"
                + " \'COMUNIDADE\', \'20-10-2015\')";
        
        String sqlTesteRetorno = "select * from evento where assunto = \'Teste 1.7.3\'";
        
        ExecutorSqlDAO.executarSQL(sqlTesteObjetivo);
        String retorno = ExecutorSqlDAO.executarSqlComRetorno(sqlTesteRetorno, "Assunto");
        
        assertEquals("Nenhum Resultado", retorno);
    }
    
    @Test
    public void testeTipoEventoNoticia(){
        String sqlTesteObjetivo = "INSERT INTO EVENTO VALUES (" + contagem() +", "
                + "\'Teste 2.1\', \'NOTICIA\', \'Tipo de Evento = Noticia\'"
                + ", \'20-10-2016 10:20:00\', \'Edmundo Sergio Spoto\', "
                + "\'edmundo@inf.ufg.br\', \'NOTICIA\', \'COMUNIDADE\', \'20-10-2017\')";
        
        String sqlTesteRetorno = "select * from evento where assunto = \'Teste 2.1\'";
        
        ExecutorSqlDAO.executarSQL(sqlTesteObjetivo);
        String retorno = ExecutorSqlDAO.executarSqlComRetorno(sqlTesteRetorno, "Assunto");
        
        assertEquals("Teste 2.1", retorno);
    }
    
    @Test
    public void testeTipoEventoPalestra(){
        String sqlTesteObjetivo = "INSERT INTO EVENTO VALUES (" + contagem() +", "
                + "\'Teste 2.2\', \'PALESTRA\', \'Tipo de Evento = Palestra\',"
                + " \'20-10-2016 10:20:00\', \'Edmundo Sergio Spoto\', \'edmundo@inf.ufg.br\',"
                + " \'NOTICIA\', \'COMUNIDADE\', \'20-10-2017\')";
        
        String sqlTesteRetorno = "select * from evento where assunto = \'Teste 2.2\'";
        
        ExecutorSqlDAO.executarSQL(sqlTesteObjetivo);
        String retorno = ExecutorSqlDAO.executarSqlComRetorno(sqlTesteRetorno, "Assunto");
        
        assertEquals("Teste 2.2", retorno);
    }
    
    @Test
    public void testeTipoEventoCurso(){
        String sqlTesteObjetivo = "INSERT INTO EVENTO VALUES (" + contagem() +", "
                + "\'Teste 2.3\', \'CURSO\', \'Tipo de Evento = Curso\',"
                + " \'20-10-2016 10:20:00\', \'Edmundo Sergio Spoto\',"
                + " \'edmundo@inf.ufg.br\', \'NOTICIA\', \'COMUNIDADE\', \'20-10-2017\')";
        
        String sqlTesteRetorno = "select * from evento where assunto = \'Teste 2.3\'";
        
        ExecutorSqlDAO.executarSQL(sqlTesteObjetivo);
        String retorno = ExecutorSqlDAO.executarSqlComRetorno(sqlTesteRetorno, "Assunto");
        
        assertEquals("Teste 2.3", retorno);
    }
    
    @Test
    public void testeTipoEventoOportunidadeEmprego(){
        String sqlTesteObjetivo = "INSERT INTO EVENTO VALUES (" + contagem() +", "
                + "\'Teste 2.4\', \'OPORTUNIDADE DE EMPREGO\', \'Tipo de Evento = Oportunidade de Emprego\',"
                + " \'20-10-2016 10:20:00\', \'Edmundo Sergio Spoto\',"
                + " \'edmundo@inf.ufg.br\', \'NOTICIA\', \'COMUNIDADE\', \'20-10-2017\')";
        
        String sqlTesteRetorno = "select * from evento where assunto = \'Teste 2.4\'";
        
        ExecutorSqlDAO.executarSQL(sqlTesteObjetivo);
        String retorno = ExecutorSqlDAO.executarSqlComRetorno(sqlTesteRetorno, "Assunto");
        
        assertEquals("Teste 2.4", retorno);
    }
    
    @Test
    public void testeTipoEventoDiversos(){
        String sqlTesteObjetivo = "INSERT INTO EVENTO VALUES (" + contagem() +", "
                + "\'Teste 2.5\', \'DIVERSOS\', \'Tipo de Evento = Diversos\',"
                + " \'20-10-2016 10:20:00\', \'Edmundo Sergio Spoto\',"
                + " \'edmundo@inf.ufg.br\', \'NOTICIA\', \'COMUNIDADE\', \'20-10-2017\')";
        
        String sqlTesteRetorno = "select * from evento where assunto = \'Teste 2.5\'";
        
        ExecutorSqlDAO.executarSQL(sqlTesteObjetivo);
        String retorno = ExecutorSqlDAO.executarSqlComRetorno(sqlTesteRetorno, "Assunto");
        
        assertEquals("Teste 2.5", retorno);
    }
    
    @Test
    public void testeTipoEventoNulo(){
        String sqlTesteObjetivo = "INSERT INTO EVENTO VALUES (" + contagem() 
                +", \'Teste 2.6\', \'null\', \'Tipo de Evento = nulo\',"
                + " \'20-10-2016 10:20:00\', \'Edmundo Sergio Spoto\',"
                + " \'edmundo@inf.ufg.br\', \'NOTICIA\', \'COMUNIDADE\', \'20-10-2017\')";
        
        String sqlTesteRetorno = "select * from evento where assunto = \'Teste 2.6\'";
        
        ExecutorSqlDAO.executarSQL(sqlTesteObjetivo);
        String retorno = ExecutorSqlDAO.executarSqlComRetorno(sqlTesteRetorno, "Assunto");
        
        assertEquals("Nenhum Resultado", retorno);
    }
    
    @Test
    public void testeEscopoApenasEgressos() {
        String sqlTesteObjetivo = "INSERT INTO evento VALUES (" + contagem() 
                + ", \'Teste 3.1\', \'NOTICIA\', \'Escopo = Apenas Egressos\', "
                + "\'20-10-2016 10:20:00\', \'Edmundo Sergio Spoto\', "
                + "\'edmundoinf.ufg.br\', \'NOTICIA\', \'APENAS EGRESSOS\', \'20-10-2017\')";
        
        String sqlTesteRetorno = "select * from evento where assunto = \'Teste 3.1\'";
        
        ExecutorSqlDAO.executarSQL(sqlTesteObjetivo);
        String retorno = ExecutorSqlDAO.executarSqlComRetorno(sqlTesteRetorno, "Assunto");
        
        assertEquals("Teste 3.1", retorno);
    }
    
    @Test
    public void testeEscopoComunidade() {
        String sqlTesteObjetivo = "INSERT INTO evento VALUES (" + contagem() 
                + ", \'Teste 3.2\', \'NOTICIA\', \'Escopo = Comunidade\', "
                + "\'20-10-2016 10:20:00\', \'Edmundo Sergio Spoto\', "
                + "\'edmundoinf.ufg.br\', \'NOTICIA\', \'APENAS EGRESSOS\', \'20-10-2017\')";
        
        String sqlTesteRetorno = "select * from evento where assunto = \'Teste 3.2\'";
        
        ExecutorSqlDAO.executarSQL(sqlTesteObjetivo);
        String retorno = ExecutorSqlDAO.executarSqlComRetorno(sqlTesteRetorno, "Assunto");
        
        assertEquals("Teste 3.2", retorno);
    }
    
    @Test
    public void testeEscopoForaDeEscopo() {
        String sqlTesteObjetivo = "INSERT INTO evento VALUES (" + contagem() 
                + ", \'Teste 3.3\', \'NOTICIA\', \'Escopo = Fora de Escopo\', "
                + "\'20-10-2016 10:20:00\', \'Edmundo Sergio Spoto\', "
                + "\'edmundoinf.ufg.br\', \'NOTICIA\', \'FORA DE ESCOPO\', \'20-10-2017\')";
        
        String sqlTesteRetorno = "select * from evento where assunto = \'Teste 3.3\'";
        
        ExecutorSqlDAO.executarSQL(sqlTesteObjetivo);
        String retorno = ExecutorSqlDAO.executarSqlComRetorno(sqlTesteRetorno, "Assunto");
        
        assertEquals("Teste 3.3", retorno);
    }
    
    @Test
    public void testeEscopoNulo() {
        String sqlTesteObjetivo = "INSERT INTO evento VALUES (" + contagem() 
                + ", \'Teste 3.4\', \'NOTICIA\', \'Escopo = nulo\', "
                + "\'20-10-2016 10:20:00\', \'Edmundo Sergio Spoto\', "
                + "\'edmundoinf.ufg.br\', \'NOTICIA\', \'null\', \'20-10-2017\')";
        
        String sqlTesteRetorno = "select * from evento where assunto = \'Teste 3.4\'";
        
        ExecutorSqlDAO.executarSQL(sqlTesteObjetivo);
        String retorno = ExecutorSqlDAO.executarSqlComRetorno(sqlTesteRetorno, "Assunto");
        
        assertEquals("Nenhum Resultado", retorno);
    }
    
    @Test
    public void testeFormaDivulgacaoMensagem() {
        String sqlTesteObjetivo = "INSERT INTO evento VALUES (" + contagem() 
                + ", \'Teste 4.1\', \'NOTICIA\', \'Forma de Divulgacao = Mensagem\', "
                + "\'20-10-2016 10:20:00\', \'Edmundo Sergio Spoto\', "
                + "\'edmundoinf.ufg.br\', \'MENSAGEM\', \'APENAS EGRESSOS\', \'20-10-2017\')";
        
        String sqlTesteRetorno = "select * from evento where assunto = \'Teste 4.1\'";
        
        ExecutorSqlDAO.executarSQL(sqlTesteObjetivo);
        String retorno = ExecutorSqlDAO.executarSqlComRetorno(sqlTesteRetorno, "Assunto");
        
        assertEquals("Teste 4.1", retorno);
    }
    
    @Test
    public void testeFormaDivulgacaoNoticia() {
        String sqlTesteObjetivo = "INSERT INTO evento VALUES (" + contagem() 
                + ", \'Teste 4.2\', \'NOTICIA\', \'Forma de Divulgacao = Noticia\', "
                + "\'20-10-2016 10:20:00\', \'Edmundo Sergio Spoto\', "
                + "\'edmundoinf.ufg.br\', \'NOTICIA\', \'APENAS EGRESSOS\', \'20-10-2017\')";
        
        String sqlTesteRetorno = "select * from evento where assunto = \'Teste 4.2\'";
        
        ExecutorSqlDAO.executarSQL(sqlTesteObjetivo);
        String retorno = ExecutorSqlDAO.executarSqlComRetorno(sqlTesteRetorno, "Assunto");
        
        assertEquals("Teste 4.2", retorno);
    }
    
    @Test
    public void testeFormaDivulgacaoAmbos() {
        String sqlTesteObjetivo = "INSERT INTO evento VALUES (" + contagem() 
                + ", \'Teste 4.3\', \'NOTICIA\', \'Forma de Divulgacao = Noticia\', "
                + "\'20-10-2016 10:20:00\', \'Edmundo Sergio Spoto\', "
                + "\'edmundoinf.ufg.br\', \'AMBOS\', \'APENAS EGRESSOS\', \'20-10-2017\')";
        
        String sqlTesteRetorno = "select * from evento where assunto = \'Teste 4.3\'";
        
        ExecutorSqlDAO.executarSQL(sqlTesteObjetivo);
        String retorno = ExecutorSqlDAO.executarSqlComRetorno(sqlTesteRetorno, "Assunto");
        
        assertEquals("Teste 4.3", retorno);
    }
    
    @Test
    public void testeFormaDivulgacaoNenhuma() {
        String sqlTesteObjetivo = "INSERT INTO evento VALUES (" + contagem() 
                + ", \'Teste 4.4\', \'NOTICIA\', \'Forma de Divulgacao = Nenhuma\', "
                + "\'20-10-2016 10:20:00\', \'Edmundo Sergio Spoto\', "
                + "\'edmundoinf.ufg.br\', \'NENHUMA\', \'APENAS EGRESSOS\', \'20-10-2017\')";
        
        String sqlTesteRetorno = "select * from evento where assunto = \'Teste 4.4\'";
        
        ExecutorSqlDAO.executarSQL(sqlTesteObjetivo);
        String retorno = ExecutorSqlDAO.executarSqlComRetorno(sqlTesteRetorno, "Assunto");
        
        assertEquals("Teste 4.4", retorno);
    }
    
    @Test
    public void testeFormaDivulgacaoNulo() {
        String sqlTesteObjetivo = "INSERT INTO evento VALUES (" + contagem() 
                + ", \'Teste 4.5\', \'NOTICIA\', \'Forma de Divulgacao = nulo\', "
                + "\'20-10-2016 10:20:00\', \'Edmundo Sergio Spoto\', "
                + "\'edmundoinf.ufg.br\', \'null\', \'APENAS EGRESSOS\', \'20-10-2017\')";
        
        String sqlTesteRetorno = "select * from evento where assunto = \'Teste 4.5\'";
        
        ExecutorSqlDAO.executarSQL(sqlTesteObjetivo);
        String retorno = ExecutorSqlDAO.executarSqlComRetorno(sqlTesteRetorno, "Assunto");
        
        assertEquals("Nenhum Resultado", retorno);
    }
}
