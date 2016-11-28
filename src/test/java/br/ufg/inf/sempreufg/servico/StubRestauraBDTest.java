package br.ufg.inf.sempreufg.servico;

import br.ufg.inf.sempreufg.interfaces.RestauraBD;
import br.ufg.inf.sempreufg.servico.StubRestauraBD;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static br.ufg.inf.sempreufg.utils.StubRestauraBDUtils.*;

public class StubRestauraBDTest {

    private RestauraBD backup;

    @Before
    public void setUp() {
        backup = new StubRestauraBD();
        System.out.println(CAMINHO_TEST_VALIDO);
    }

    @Test
    public void testValido() {
        Assert.assertTrue(backup.restaurarBD(TEMPO_VALIDO, CAMINHO_TEST_VALIDO, DATA_VALIDA_VINCULADA));
    }

    @Test
    public void testPeriodicidadeZero() {
        Assert.assertFalse(backup.restaurarBD(TEMPO_TEST_PERIODICIDADE_ZERO, CAMINHO_TEST_VALIDO, DATA_VALIDA_VINCULADA));
    }

    @Test
    public void testPeriodicidadeNegativa() {
        Assert.assertFalse(backup.restaurarBD(TEMPO_TEST_PERIODICIDADE_NEGATIVA, CAMINHO_TEST_VALIDO, DATA_VALIDA_VINCULADA));
    }

    @Test
    public void testPeriodicidadeNulo() {
        Assert.assertFalse(backup.restaurarBD(TEMPO_TEST_PERIODICIDADE_NULO, CAMINHO_TEST_VALIDO, DATA_VALIDA_VINCULADA));
    }

    @Test
    public void testCaminho() {
        Assert.assertFalse(backup.restaurarBD(TEMPO_VALIDO, CAMINHO_TEST_CAMINHO, DATA_VALIDA_VINCULADA));
    }

    @Test
    public void testCaminhoNulo() {
        Assert.assertFalse(backup.restaurarBD(TEMPO_VALIDO, CAMINHO_TEST_CAMINHO_NULO, DATA_VALIDA_VINCULADA));
    }

    @Test
    public void testCaminhoComEspaco() {
        Assert.assertTrue(backup.restaurarBD(TEMPO_VALIDO, CAMINHO_TEST_CAMINHO_COM_ESPACO, DATA_VALIDA_VINCULADA));
    }

    @Test
    public void testDataNulo() {
        Assert.assertFalse(backup.restaurarBD(TEMPO_VALIDO, CAMINHO_TEST_VALIDO, DATA_NULO));
    }

    @Test
    public void testDataSuperiorAtual() {
        Assert.assertFalse(backup.restaurarBD(TEMPO_VALIDO, CAMINHO_TEST_VALIDO, DATA_SUPERIOR_ATUAL));
    }

    @Test
    public void testDataInexistente() {
        Assert.assertFalse(backup.restaurarBD(TEMPO_VALIDO, CAMINHO_TEST_VALIDO, DATA_INEXISTENTE));
    }

    @Test
    public void testDataValida() {
        Assert.assertFalse(backup.restaurarBD(TEMPO_VALIDO, CAMINHO_TEST_VALIDO, DATA_VALIDA_NAO_VINCULADA));
    }

    //Teste se a data é válida e se a mesma está vinculada ao arquivo de backup
    @Test
    public void testDataValidaVinculada() {
        Assert.assertTrue(backup.restaurarBD(TEMPO_VALIDO, CAMINHO_TEST_VALIDO, DATA_VALIDA_VINCULADA));
    }

}
