package br.ufg.inf.backup;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static br.ufg.inf.utils.StubRestauraBDUtils.*;

public class StubRestauraBDTest {
    
    private RestauraBD backup;

    @Before
    public void setUp() {
        backup = new StubRestauraBD();
        System.out.println(CAMINHO_TEST_VALIDO);
    }

    @Test
    public void testValido() {
        Assert.assertTrue(backup.restaurarBD(TEMPO_VALIDO, CAMINHO_TEST_VALIDO, DATA_VALIDA));
    }

    @Test
    public void testPeriodicidadeZero() {
        Assert.assertFalse(backup.restaurarBD(TEMPO_TEST_PERIODICIDADE_ZERO, CAMINHO_TEST_VALIDO, DATA_VALIDA));
    }

    @Test
    public void testPeriodicidadeNegativa() {
        Assert.assertFalse(backup.restaurarBD(TEMPO_TEST_PERIODICIDADE_NEGATIVA, CAMINHO_TEST_VALIDO, DATA_VALIDA));
    }

    @Test
    public void testPeriodicidadeNulo() {
        Assert.assertFalse(backup.restaurarBD(TEMPO_TEST_PERIODICIDADE_NULO, CAMINHO_TEST_VALIDO, DATA_VALIDA));
    }

    @Test
    public void testCaminho() {
        Assert.assertFalse(backup.restaurarBD(TEMPO_VALIDO, CAMINHO_TEST_CAMINHO, DATA_VALIDA));
    }

    @Test
    public void testCaminhoNulo() {
        Assert.assertFalse(backup.restaurarBD(TEMPO_VALIDO, CAMINHO_TEST_CAMINHO_NULO, DATA_VALIDA));
    }

    @Test
    public void testCaminhoComEspaco() {
        Assert.assertTrue(backup.restaurarBD(TEMPO_VALIDO, CAMINHO_TEST_CAMINHO_COM_ESPACO, DATA_VALIDA));
    }
    
    @Test
    public void testDataNulo() {
        Assert.assertTrue(backup.restaurarBD(TEMPO_VALIDO, CAMINHO_TEST_VALIDO, DATA_NULO));
    }
    
    @Test
    public void testDataSuperiorAtual() {
        Assert.assertTrue(backup.restaurarBD(TEMPO_VALIDO, CAMINHO_TEST_VALIDO, DATA_SUPERIOR_ATUAL));
    }
    
    @Test
    public void testDataInexistente() {
        Assert.assertTrue(backup.restaurarBD(TEMPO_VALIDO, CAMINHO_TEST_VALIDO, DATA_INEXISTENTE));
    }
    
    @Test
    public void testDataValida() {
        Assert.assertTrue(backup.restaurarBD(TEMPO_VALIDO, CAMINHO_TEST_VALIDO, DATA_VALIDA));
    }
    
    //Teste se a data é válida e se a mesma está vinculada ao arquivo de backup
    @Test
    public void testDataValidaVinculada() {
        Assert.assertTrue(backup.restaurarBD(TEMPO_VALIDO, CAMINHO_TEST_VALIDO, DATA_VINCULADA_AO_BACKUP));
    }

}
