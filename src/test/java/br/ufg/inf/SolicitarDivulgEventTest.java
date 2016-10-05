package br.ufg.inf;

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
        String descricao = "Descrição";
        String publicoAlvo = "Público Alvo";
        String areasRelacionadas = "Áreas Relacionadas";
        String instanciasInteressadas = "Instancias Interessadas";
        EventoSolicitado evento = new EventoSolicitado(email, descricao,
                publicoAlvo, areasRelacionadas, instanciasInteressadas);
        SolicitarDivulgEvent instance = new SolicitarDivulgEvent();
        instance.enviarSolicitacao(evento);
        Assert.assertNotEquals("Email com valor Null",
                instance.getEvento().getEmail(), "");
        Assert.assertTrue("Email Inválido", instance.emailValido());
        Assert.assertNotEquals("Descrição com valor Null",
                instance.getEvento().getDescricao(), "");
        Assert.assertNotEquals("Público Alvo com valor Null",
                instance.getEvento().getPublicoAlvo(), "");
        Assert.assertNotEquals("Areas Relacionadas com valor Null",
                instance.getEvento().getAreasRelacionadas(), "");
        Assert.assertNotEquals("Instancias Interessadas com valor Null",
                instance.getEvento().getInstanciasInteressadas(), "");
        Email.enviarEmail(email);
    }

}
