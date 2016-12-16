package br.ufg.inf.sempreufg.servico;

import br.ufg.inf.sempreufg.stubs.PriorMaintenanceManagerStub;
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
