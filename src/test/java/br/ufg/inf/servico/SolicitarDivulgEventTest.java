package br.ufg.inf.servico;

import br.ufg.inf.modelo.Email;
import br.ufg.inf.modelo.EventoSolicitado;
import br.ufg.inf.modelo.SolicitarDivulgEvent;
import org.apache.commons.mail.EmailException;
import org.junit.Assert;
import org.junit.Test;

public class SolicitarDivulgEventTest {

    /**
     * Test of enviarSolicitacao method, of class SolicitarDivulgEvent.
     *
     * @throws org.apache.commons.mail.EmailException
     */
    @Test
    public void testEnviarSolicitacao() throws EmailException {
        String email = "mtesedd@gmail.com";
        String descricao = "Descri��o";
        String publicoAlvo = "P�blico Alvo";
        String areasRelacionadas = "�reas Relacionadas";
        String instanciasInteressadas = "Instancias Interessadas";
        EventoSolicitado evento = new EventoSolicitado(email, descricao,
                publicoAlvo, areasRelacionadas, instanciasInteressadas);
        SolicitarDivulgEvent instance = new SolicitarDivulgEvent();
        instance.enviarSolicitacao(evento);
        Assert.assertNotEquals("Email com valor Null",
                instance.getEvento().getEmail(), "");
        Assert.assertTrue("Email Inv�lido", instance.emailValido());
        Assert.assertNotEquals("Descri��o com valor Null",
                instance.getEvento().getDescricao(), "");
        Assert.assertNotEquals("P�blico Alvo com valor Null",
                instance.getEvento().getPublicoAlvo(), "");
        Assert.assertNotEquals("Areas Relacionadas com valor Null",
                instance.getEvento().getAreasRelacionadas(), "");
        Assert.assertNotEquals("Instancias Interessadas com valor Null",
                instance.getEvento().getInstanciasInteressadas(), "");
        Email.enviarEmail(email);
    }

}
