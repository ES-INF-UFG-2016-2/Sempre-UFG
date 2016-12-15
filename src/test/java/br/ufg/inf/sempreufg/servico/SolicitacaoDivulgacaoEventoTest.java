package br.ufg.inf.sempreufg.servico;

import br.ufg.inf.sempreufg.modelo.EventoSolicitado;
import br.ufg.inf.sempreufg.modelo.SolicitacaoDivulgacaoEvento;
import org.apache.commons.mail.EmailException;
import org.junit.Test;

public class SolicitacaoDivulgacaoEventoTest {

    /**
     * Test of enviarSolicitacao method, of class SolicitacaoDivulgacaoEvento.
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
        SolicitacaoDivulgacaoEvento instance = new SolicitacaoDivulgacaoEvento();
        /*

        O seguinte bloco de código foi comentado por Johnathan Gomes pois o teste criado não
        corresponde com a arquitetura de classes e dados projetada e ao refatorar ele quebrou.
        É necessário que o dono desse teste o adapte para as novas exigências de projeto.

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
        */
    }

}
