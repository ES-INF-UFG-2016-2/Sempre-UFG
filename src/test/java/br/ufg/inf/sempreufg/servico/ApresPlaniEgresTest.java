package br.ufg.inf.sempreufg.servico;

import br.ufg.inf.sempreufg.interfaces.Planilha;
import br.ufg.inf.sempreufg.stubs.ApresPlaniEgresStub;
import br.ufg.inf.sempreufg.stubs.PlanilhaStub;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by Bruno on 10/30/2016.
 */
public class ApresPlaniEgresTest {


    @Test
    public void testapresPlaniEgresParametroValido(){
        Planilha planilha = new PlanilhaStub();
        Assert.assertEquals(planilha instanceof Planilha, true);

    }

    @Test
    public void testapresPlaniEgresValidUrl(){

        Planilha planilha = new PlanilhaStub();
        String regex = "^(https?|http)://[-a-zA-Z0-9+&@#/%?=~_|!:,.;]*[-a-zA-Z0-9+&@#/%=~_|]";
        ApresPlaniEgresStub stub = new ApresPlaniEgresStub();
        String urlStub = "http://sempreufg.ufg.br/egressos/id=122252/planilha.pdf";
        Assert.assertEquals(regex.matches(urlStub), regex.matches(stub.apresPlaniEgres(planilha)));

    }
}
