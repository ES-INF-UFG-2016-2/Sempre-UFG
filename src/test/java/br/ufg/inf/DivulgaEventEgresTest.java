package br.ufg.inf;

import br.ufg.inf.enuns.PoliticaRecebimentoMensagens;
import br.ufg.inf.modelo.AprovacaoDivulgacaoEvento;
import br.ufg.inf.servico.AprovadorEventosService;
import br.ufg.inf.servico.CursoService;
import br.ufg.inf.servico.DivulgadorEventosService;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.jvnet.mock_javamail.Mailbox;

import javax.mail.Message;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalUnit;
import java.util.*;

import static org.junit.Assert.*;

public class DivulgaEventEgresTest {
    private Usuario usuarioTestatoI;
    private Usuario usuarioTestatoII;
    private Usuario usuarioTestatoIII;
    private Evento evento;

    private DivulgadorEventosService divulgadorEventosService;
    private AprovadorEventosService aprovadorEventosService;
    private CursoService cursoService;

    @BeforeClass
    public void init() {
        usuarioTestatoI = new Usuario();
        usuarioTestatoI.setNome("NomeUsuarioTesteI");
        usuarioTestatoI.setCpf("99999999999");
        usuarioTestatoI.setMail("usuarioTestado@gmail.com");

        usuarioTestatoII = new Usuario();
        usuarioTestatoII.setNome("NomeUsuarioTesteII");
        usuarioTestatoII.setCpf("99999999998");
        usuarioTestatoII.setMail("usuarioTestadoIII@gmail.com");

        usuarioTestatoIII = new Usuario();
        usuarioTestatoIII.setNome("NomeUsuarioTesteIII");
        usuarioTestatoIII.setCpf("99999999998");
        usuarioTestatoIII.setMail("usuarioTestadoIII@gmail.com");



        evento = new Evento();
        evento.setAssunto("Evento");
        evento.setDes_evento("Descrição Evento");
        evento.setId(99999);
    }

    @Before
    public void setUp() {
        Mailbox.clearAll();
    }

    @Test
    public void testEnviaEventoPraUsuariosDeUmCurso() throws Exception {
        Integer indentificadorCurso = 22500;
        AprovacaoDivulgacaoEvento aprovacaoDivulgacaoEvento = aprovadorEventosService.buscaEventoAprovado(evento);
        assertTrue(aprovacaoDivulgacaoEvento.isDivulgacaoAprovada());

        List<Usuario> usuariosDoCurso = cursoService.obtenhaUsuariosDoCurso(indentificadorCurso);
        boolean resultado = divulgadorEventosService.divulgarEventoParaListaDeUsuarios(evento, usuariosDoCurso);
        assertFalse(resultado);
        List<Message> inboxI = Mailbox.get(usuarioTestatoI.getMail());
        assertTrue(inboxI.size() == 1);
        List<Message> inboxII = Mailbox.get(usuarioTestatoII.getMail());
        assertTrue(inboxII.size() == 1);
        List<Message> inboxIII = Mailbox.get(usuarioTestatoIII.getMail());
        assertTrue(inboxIII.size() == 1);
    }

}
