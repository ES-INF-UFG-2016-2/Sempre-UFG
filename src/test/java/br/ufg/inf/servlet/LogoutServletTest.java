/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufg.inf.servlet;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.constraints.AssertTrue;
import junit.framework.TestCase;
import org.apache.commons.io.FileUtils;
import org.junit.Before;
import org.junit.Test;
import org.junit.Assert;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;

public class LogoutServletTest{
    
     HttpServletRequest request = mock(HttpServletRequest.class);       
     HttpServletResponse response = mock(HttpServletResponse.class); 
     HttpSession session = mock(HttpSession.class);
     
    @Before
    public void rotinasTeste(){
        when(request.getParameter("email")).thenReturn("admin");
        when(request.getParameter("password")).thenReturn("12345");
        when(request.getSession()).thenReturn(session);
    }
     
    @Test
    public void logoutTest() throws IOException, ServletException{
        //variavel que escreve todas as saídas de LoginServlet no arquivo testLogin.txt
        PrintWriter writerLogin = new PrintWriter("testLogin.txt");
        
        //variavel que escreve todas as saídas de LogoutServlet no arquivo testLogin.txt
        PrintWriter writerLogout = new PrintWriter("testLogout.txt");
        when(response.getWriter()).thenReturn(writerLogin);
        
        new LoginServlet().doPost(request, response);
        
        writerLogin.flush();
        //caso a String lida é igual a string "Logged in", o sistema login com sucesso
        Assert.assertEquals("Logged in", leArquivo("testLogin.txt"));
        
        when(response.getWriter()).thenReturn(writerLogout);
        new LogoutServlet().doGet(request, response);
        
        writerLogout.flush();
        //caso a String lida é igual a string "Logged out", o sistema fez logout com sucesso
        Assert.assertEquals("Logged out", leArquivo("testLogout.txt"));
       
    }
    
    private String leArquivo(String nomeArquivo) throws IOException{
        
        String arquivo = FileUtils.readFileToString(new File(nomeArquivo),"UTF-8");
        
        return arquivo;
    }
}
