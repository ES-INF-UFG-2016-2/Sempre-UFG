package test.java.br.ufg.inf;

import java.time.Period;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import main.java.br.ufg.inf.Backup;
import main.java.br.ufg.inf.StubBackup;

public class StubBackupTest {

    public static final String CAMINHO_TEST_VALIDO = System.getProperty("user.home");//user.home sempre um caminho "Local" válido.
    public static final Period TEMPO_TEST_PERIODICIDADE_ZERO = Period.ofDays(0);
    public static final Period TEMPO_TEST_PERIODICIDADE_NEGATIVA = Period.ofDays(-1);
    public static final Period TEMPO_TEST_PERIODICIDADE_NULO = null;
    public static final String CAMINHO_TEST_CAMINHO = "&6@#$|//\\?";
    public static final String CAMINHO_TEST_CAMINHO_NULO = null;
    public static final String CAMINHO_TEST_CAMINHO_COM_ESPACO = " " + CAMINHO_TEST_VALIDO;

    public static final Period TEMPO_VALIDO = Period.ofDays(1);

    private Backup backup;

    @Before
    public void setUp() {
        backup = new StubBackup();
        System.out.println(CAMINHO_TEST_VALIDO);

    }

    @Test
    public void testValido() {
        Assert.assertTrue(backup.configurarBackup(TEMPO_VALIDO, CAMINHO_TEST_VALIDO));
    }

    @Test
    public void testPeriodicidadeZero() {
        Assert.assertFalse(backup.configurarBackup(TEMPO_TEST_PERIODICIDADE_ZERO, CAMINHO_TEST_VALIDO));
    }

    @Test
    public void testPeriodicidadeNegativa() {
        Assert.assertFalse(backup.configurarBackup(TEMPO_TEST_PERIODICIDADE_NEGATIVA, CAMINHO_TEST_VALIDO));
    }

    @Test
    public void testPeriodicidadeNulo() {
        Assert.assertFalse(backup.configurarBackup(TEMPO_TEST_PERIODICIDADE_NULO, CAMINHO_TEST_VALIDO));
    }

    @Test
    public void testCaminho() {
        Assert.assertFalse(backup.configurarBackup(TEMPO_VALIDO, CAMINHO_TEST_CAMINHO));
    }

    @Test
    public void testCaminhoNulo() {

        Assert.assertFalse(backup.configurarBackup(TEMPO_VALIDO, CAMINHO_TEST_CAMINHO_NULO));
    }

    @Test
    public void testCaminhoComEspaco() {

        Assert.assertTrue(backup.configurarBackup(TEMPO_VALIDO, CAMINHO_TEST_CAMINHO_COM_ESPACO));
    }

}
