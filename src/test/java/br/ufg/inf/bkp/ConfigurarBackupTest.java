package br.ufg.inf.bkp;

import java.time.Period;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ConfigurarBackupTest {

	private Backup backup;
    private String caminho;
    private Period tempo;
    private String diretorioHome;

    @Before
    public void setUp() {
        backup = new Stub_Bkp();
        diretorioHome = System.getProperty("user.home");//user.home sempre um caminho "Local" válido.
        System.out.println(diretorioHome);

    }

    @Test
    public void testValido() {
        caminho = diretorioHome;
        tempo = Period.ofDays(1);
        
        Assert.assertTrue(backup.configurarBackup(tempo, caminho));
    }
    
    @Test
    public void testPeriodicidadeZero() {
        caminho = diretorioHome;
        tempo = Period.ofDays(0);
        
        Assert.assertFalse(backup.configurarBackup(tempo, caminho));
    }
    
    @Test
    public void testPeriodicidadeNegativa() {
        caminho = diretorioHome;
        tempo = Period.ofDays(-1);
        
        Assert.assertFalse(backup.configurarBackup(tempo, caminho));
    }
    
    @Test
    public void testPeriodicidadeNulo() {
        caminho = diretorioHome;                
        Assert.assertFalse(backup.configurarBackup(null, caminho));
    }
    
    @Test
    public void testCaminho() {
        caminho = "&6@#$|//\\?"; 
        tempo = Period.ofDays(1);
        Assert.assertFalse(backup.configurarBackup(tempo, caminho));
    }
    
    @Test
    public void testCaminhoNulo() {
        caminho = null; 
        tempo = Period.ofDays(1);
        Assert.assertFalse(backup.configurarBackup(tempo, caminho));
    }
    
    // @Test
    // public void testCaminhoComEspaco() {
    //     caminho = " " + diretorioHome; 
    //     tempo = Period.ofDays(1);
    //     Assert.assertTrue(backup.configurarBackup(tempo, caminho));
    // }
    
}
