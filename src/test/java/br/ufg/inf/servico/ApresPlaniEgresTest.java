package br.ufg.inf.servico;

import br.ufg.inf.interfaces.Planilha;
import br.ufg.inf.stubs.ApresPlaniEgresStub;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by Bruno on 10/30/2016.
 */
public class ApresPlaniEgresTest {

    @Test
    public void testapresPlaniEgresValidUrl(Planilha planilha){

        String regex = "^(https?|http)://[-a-zA-Z0-9+&@#/%?=~_|!:,.;]*[-a-zA-Z0-9+&@#/%=~_|]";
        ApresPlaniEgresStub stub = new ApresPlaniEgresStub();
        String urlStub = "http://sempreufg.ufg.br/egressos/id=122252/planilha.pdf";
        Assert.assertEquals(regex.matches(urlStub), regex.matches(stub.apresPlaniEgres(planilha)));

    }
}
