package br.ufg.inf.sempreufg.servico;

import br.ufg.inf.sempreufg.interfaces.Backup;
import br.ufg.inf.sempreufg.servico.StubBackup;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static br.ufg.inf.sempreufg.utils.StubBackupUtils.*;

public class StubBackupTest {


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
