package br.ufg.inf.servico;

import br.ufg.inf.stubs.PriorMaintenanceManagerStub;
import org.junit.Assert;
import org.junit.Test;

public class PriorMaintenanceTest {

    private PriorMaintenanceManagerStub sut = new PriorMaintenanceManagerStub();

    @Test
    public void testPriorMaintenanceActivation() {
        sut.activateMaintenance();
        Assert.assertTrue(sut.priorMaintenanceIsActive());
    }

    @Test
    public void testPriorMaintenanceDeactivation() {
        sut.deactivateMaintenance();
        Assert.assertFalse(sut.priorMaintenanceIsActive());
    }

}
