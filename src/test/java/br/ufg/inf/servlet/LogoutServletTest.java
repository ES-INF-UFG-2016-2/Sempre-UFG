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

public class LogoutServletTest{
    
     HttpServletRequest request = mock(HttpServletRequest.class);       
     HttpServletResponse response = mock(HttpServletResponse.class); 
     HttpSession session = mock(HttpSession.class);
     
    @Before
    public void rotinas(){
        when(request.getParameter("email")).thenReturn("admin");
        when(request.getParameter("password")).thenReturn("12345");
        when(request.getSession()).thenReturn(session);
    }
     
    @Test
    public void logoutTest() throws IOException, ServletException{
       
        PrintWriter writer = new PrintWriter("test.txt");
        when(response.getWriter()).thenReturn(writer);
        
        new LoginServlet().doPost(request, response);
        
        new LogoutServlet().doGet(request, response);
        
        HttpSession sessionTest = request.getSession();
        
        Assert.assertEquals("Logged out", FileUtils.readFileToString(new File("test.txt"),"UTF-8"));
        writer.flush();
        
        
    }
}
