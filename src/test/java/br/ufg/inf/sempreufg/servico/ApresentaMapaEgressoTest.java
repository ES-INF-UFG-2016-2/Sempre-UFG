package br.ufg.inf.sempreufg.servico;

import br.ufg.inf.sempreufg.interfaces.ApresentaMapaEgressoInterface;
import br.ufg.inf.sempreufg.interfaces.Planilha;
import br.ufg.inf.sempreufg.stubs.ApresPlaniEgresStub;
import br.ufg.inf.sempreufg.stubs.ApresentaMapaEgressoStub;
import br.ufg.inf.sempreufg.stubs.PlanilhaStub;
import org.junit.Assert;
import org.junit.Test;

import java.util.UUID;

public class ApresentaMapaEgressoTest {

    @Test
    public void testApresMapaEgresParametroValido(){
        Planilha planilha = new PlanilhaStub();
        Assert.assertEquals(planilha instanceof Planilha, true);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testApresMapaEgressoComPlanilhaNula(){
        ApresentaMapaEgressoInterface apresentaMapaEgresso = new ApresentaMapaEgressoStub();
        apresentaMapaEgresso.apresentaMapa(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testContaResultadosPlanilhaComPlanilhaNula(){
        ApresentaMapaEgressoInterface apresentaMapaEgresso = new ApresentaMapaEgressoStub();
        apresentaMapaEgresso.contaResultadosPlanilha(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testContaResultadosPlanilhaPorCidadeComPlanilhaNula(){
        ApresentaMapaEgressoInterface apresentaMapaEgresso = new ApresentaMapaEgressoStub();
        apresentaMapaEgresso.contaResultadosPlanilhaPorCidade(null, "");
    }
}
