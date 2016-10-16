package br.ufg.inf;

import br.ufg.inf.enuns.PolitRecebMsg;
import br.ufg.inf.modelo.AprovacaoDivulgacaoEvento;
import br.ufg.inf.modelo.Evento;
import br.ufg.inf.modelo.Usuario;
import br.ufg.inf.servico.AprovadorEventosService;
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
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

public class DivulgaEventComunTest {

    private String remetenteEmails = "sempreufg@sempreufg.br";
    private String destinatarioPadraoEmails = "aluno@sempreufg.br";
    private String outroDestinatarioEmails = "outroaluno@sempreufg.br";
    private Usuario usuarioTestado;
    private Evento evento;

    private DivulgadorEventosService divulgadorEventosService;
    private AprovadorEventosService aprovadorEventosService;

    @BeforeClass
    public void init() {
        //Cria usuário e evento em comum
        usuarioTestado = new Usuario();
        usuarioTestado.setNome("Teste");
        usuarioTestado.setCpf("1234123");
        usuarioTestado.setMail(destinatarioPadraoEmails);
        evento = new Evento();
        evento.setAssunto("Evento");
        evento.setDes_evento("Descrição Evento");
        evento.setId(1);
    }

    @Before
    public void setUp() {
        //Limpa mensagens anteriores
        Mailbox.clearAll();
    }

    @Test
    public void testEventoNaoAprovadoNaoEEnviado() throws Exception {
        AprovacaoDivulgacaoEvento aprovacaoDivulgacaoEvento = aprovadorEventosService.buscaEventoAprovado(evento);
        assertFalse(aprovacaoDivulgacaoEvento.isDivulgacaoAprovada());
        List<Usuario> usuarios = new ArrayList<>();
        usuarios.add(usuarioTestado);
        boolean resultado = divulgadorEventosService.divulgarEventoParaListaDeUsuarios(evento, usuarios);
        assertFalse(resultado);
        List<Message> inbox = Mailbox.get(destinatarioPadraoEmails);
        assertTrue(inbox.size() == 0);
    }

    @Test
    public void testEventoSoEhDivulgadoUmaVez() throws Exception {
        AprovacaoDivulgacaoEvento aprovacaoDivulgacaoEvento = aprovadorEventosService.buscaEventoAprovado(evento);
        assertTrue(aprovacaoDivulgacaoEvento.isDivulgacaoAprovada());
        List<Usuario> usuarios = new ArrayList<>();
        usuarios.add(usuarioTestado);
        boolean resultado = divulgadorEventosService.divulgarEventoParaListaDeUsuarios(evento, usuarios);
        assertTrue(resultado);
        List<Message> inbox = Mailbox.get(destinatarioPadraoEmails);
        assertTrue(inbox.size() == 1);
        Message eventoDivulgado = inbox.get(0);
        assertEquals(evento.getAssunto(), eventoDivulgado.getSubject());
        assertEquals(evento.getDes_evento(), eventoDivulgado.getContent().toString());
    }

    @Test
    public void testEventoDivulgadoApenasUmaVezUsuarioRepetidoNaLista() throws Exception {
        AprovacaoDivulgacaoEvento aprovacaoDivulgacaoEvento = aprovadorEventosService.buscaEventoAprovado(evento);
        assertTrue(aprovacaoDivulgacaoEvento.isDivulgacaoAprovada());
        List<Usuario> usuarios = new ArrayList<>();
        usuarios.add(usuarioTestado);
        usuarios.add(usuarioTestado);
        usuarios.add(usuarioTestado);
        boolean resultado = divulgadorEventosService.divulgarEventoParaListaDeUsuarios(evento, usuarios);
        assertTrue(resultado);
        List<Message> inbox = Mailbox.get(destinatarioPadraoEmails);
        assertTrue(inbox.size() == 1);
        Message eventoDivulgado = inbox.get(0);
        assertEquals(evento.getAssunto(), eventoDivulgado.getSubject());
        assertEquals(evento.getDes_evento(), eventoDivulgado.getContent().toString());
    }

    @Test
    public void testEventoDivulgadoParaUsuarioNotificaoMensal() throws Exception {
        Date hoje = new Date();
        Date emUmMes = adicionarUmaUnidadeDataAtual(hoje, 1L, ChronoUnit.MONTHS);
        Usuario outroUsuario = new Usuario();
        outroUsuario.setTipoDivulgacao(PolitRecebMsg.MENSAL);
        outroUsuario.setMail(outroDestinatarioEmails);
        AprovacaoDivulgacaoEvento aprovacaoDivulgacaoEvento = aprovadorEventosService.buscaEventoAprovado(evento);
        assertTrue(aprovacaoDivulgacaoEvento.isDivulgacaoAprovada());
        List<Usuario> usuarios = new ArrayList<>();
        usuarios.add(outroUsuario);
        boolean resultado = divulgadorEventosService.divulgarEventoParaListaDeUsuarios(evento, usuarios);
        assertTrue(resultado);
        List<Message> inbox = Mailbox.get(outroDestinatarioEmails);
        assertTrue(inbox.size() == 0);
        Map<Date, Map<Usuario, Evento>> eventosAindaNaoEnviados = divulgadorEventosService
            .obtenhaEventosQueNaoForamEnviadosAinda();
        assertTrue(eventosAindaNaoEnviados.containsKey(emUmMes));
        Map<Usuario, Evento> usuarioEventoMap = eventosAindaNaoEnviados.get(emUmMes);
        assertTrue(usuarioEventoMap.containsKey(outroUsuario));
    }

    @Test
    public void testEventoDivulgadoParaUsuarioNotificaoSemanal() throws Exception {
        Date hoje = new Date();
        Date emUmaSemana = adicionarUmaUnidadeDataAtual(hoje, 1L, ChronoUnit.WEEKS);
        Usuario outroUsuario = new Usuario();
        outroUsuario.setTipoDivulgacao(PolitRecebMsg.SEMANAL);
        outroUsuario.setMail(outroDestinatarioEmails);
        AprovacaoDivulgacaoEvento aprovacaoDivulgacaoEvento = aprovadorEventosService.buscaEventoAprovado(evento);
        assertTrue(aprovacaoDivulgacaoEvento.isDivulgacaoAprovada());
        List<Usuario> usuarios = new ArrayList<>();
        usuarios.add(outroUsuario);
        boolean resultado = divulgadorEventosService.divulgarEventoParaListaDeUsuarios(evento, usuarios);
        assertTrue(resultado);
        List<Message> inbox = Mailbox.get(outroDestinatarioEmails);
        assertTrue(inbox.size() == 0);
        Map<Date, Map<Usuario, Evento>> eventosAindaNaoEnviados = divulgadorEventosService
            .obtenhaEventosQueNaoForamEnviadosAinda();
        assertTrue(eventosAindaNaoEnviados.containsKey(emUmaSemana));
        Map<Usuario, Evento> usuarioEventoMap = eventosAindaNaoEnviados.get(emUmaSemana);
        assertTrue(usuarioEventoMap.containsKey(outroUsuario));
    }

    @Test
    public void testEventoDivulgadoParaUsuarioNotificaoDiaria() throws Exception {
        Date hoje = new Date();
        Date amanha = adicionarUmaUnidadeDataAtual(hoje, 1L, ChronoUnit.DAYS);
        Usuario outroUsuario = new Usuario();
        outroUsuario.setTipoDivulgacao(PolitRecebMsg.DIARIA);
        outroUsuario.setMail(outroDestinatarioEmails);
        AprovacaoDivulgacaoEvento aprovacaoDivulgacaoEvento = aprovadorEventosService.buscaEventoAprovado(evento);
        assertTrue(aprovacaoDivulgacaoEvento.isDivulgacaoAprovada());
        List<Usuario> usuarios = new ArrayList<>();
        usuarios.add(outroUsuario);
        boolean resultado = divulgadorEventosService.divulgarEventoParaListaDeUsuarios(evento, usuarios);
        assertTrue(resultado);
        List<Message> inbox = Mailbox.get(outroDestinatarioEmails);
        assertTrue(inbox.size() == 0);
        Map<Date, Map<Usuario, Evento>> eventosAindaNaoEnviados = divulgadorEventosService
            .obtenhaEventosQueNaoForamEnviadosAinda();
        assertTrue(eventosAindaNaoEnviados.containsKey(amanha));
        Map<Usuario, Evento> usuarioEventoMap = eventosAindaNaoEnviados.get(amanha);
        assertTrue(usuarioEventoMap.containsKey(outroUsuario));
    }

    @Test
    public void testEventoDivulgadoParaTodosUsuarios() throws Exception {
        Usuario outroUsuario = new Usuario();
        outroUsuario.setMail(outroDestinatarioEmails);
        AprovacaoDivulgacaoEvento aprovacaoDivulgacaoEvento = aprovadorEventosService.buscaEventoAprovado(evento);
        assertTrue(aprovacaoDivulgacaoEvento.isDivulgacaoAprovada());
        boolean resultado = divulgadorEventosService.divulgarEventoParaTodosUsuarios(evento);
        assertTrue(resultado);
        List<Message> inbox = Mailbox.get(destinatarioPadraoEmails);
        assertTrue(inbox.size() == 1);
        List<Message> inboxOutroUsuario = Mailbox.get(outroDestinatarioEmails);
        assertTrue(inboxOutroUsuario.size() == 1);
        Message eventoDivulgado = inbox.get(0);
        assertEquals(evento.getAssunto(), eventoDivulgado.getSubject());
        assertEquals(evento.getDes_evento(), eventoDivulgado.getContent().toString());
        Message eventoDivulgadoOutro = inbox.get(0);
        assertEquals(evento.getAssunto(), eventoDivulgadoOutro.getSubject());
        assertEquals(evento.getDes_evento(), eventoDivulgadoOutro.getContent().toString());
        assertEquals(eventoDivulgado, eventoDivulgadoOutro);
    }

    private Date adicionarUmaUnidadeDataAtual(Date atual, Long quantidade,
                                              TemporalUnit unidadeTemporal) {
        LocalDateTime localDateTimeAtual = LocalDateTime.from(atual.toInstant());
        localDateTimeAtual.plus(quantidade, unidadeTemporal);
        return Date.from(Instant.from(localDateTimeAtual));
    }

}
