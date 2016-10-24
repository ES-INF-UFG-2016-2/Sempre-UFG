package br.ufg.inf.servico;

import br.ufg.inf.modelo.AprovacaoDivulgacaoEvento;
import br.ufg.inf.modelo.Evento;
import br.ufg.inf.modelo.Usuario;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;

public class DivulgaEventEgresTest {
    private Usuario usuarioTestatoI;
    private Usuario usuarioTestatoII;
    private Usuario usuarioTestatoIII;
    private Evento evento;

    private DivulgadorEventosServiceMock divulgadorEventosService;
    private AprovadorEventosServiceMock aprovadorEventosService;
    private CursoServiceMock cursoService;

    @Before
    public void setUp() {
        aprovadorEventosService = new AprovadorEventosServiceMock();
        cursoService = new CursoServiceMock();
        divulgadorEventosService = new DivulgadorEventosServiceMock();
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

    @Test
    public void testEnviaEventoPraUsuariosDeUmCurso() throws Exception {
        Integer indentificadorCurso = 22500;
        AprovacaoDivulgacaoEvento aprovacaoDivulgacaoEvento = aprovadorEventosService.buscaEventoAprovado(evento);
        assertTrue(aprovacaoDivulgacaoEvento.isDivulgacaoAprovada());

        List<Usuario> usuariosDoCurso = cursoService.obtenhaUsuariosDoCurso(indentificadorCurso);
        boolean resultado = divulgadorEventosService.divulgarEventoParaListaDeUsuarios(evento, usuariosDoCurso);
        assertTrue(resultado);
        List<String> inboxI = MailBoxMock.getMessages(usuarioTestatoI.getMail());
        assertTrue(inboxI.size() == 1);
        List<String> inboxII = MailBoxMock.getMessages(usuarioTestatoII.getMail());
        assertTrue(inboxII.size() == 1);
        List<String> inboxIII = MailBoxMock.getMessages(usuarioTestatoIII.getMail());
        assertTrue(inboxIII.size() == 1);
    }

    private class DivulgadorEventosServiceMock implements DivulgadorEventosService {

        @Override
        public boolean divulgarEventoParaListaDeUsuarios(Evento evento, List<Usuario> usuarios) {
            return true;
        }

        @Override
        public boolean divulgarEventoParaTodosUsuarios(Evento evento) {
            return false;
        }

        @Override
        public Map<Date, Map<Usuario, Evento>> obtenhaEventosQueNaoForamEnviadosAinda() {
            return null;
        }
    }

    private class AprovadorEventosServiceMock implements AprovadorEventosService {
        @Override
        public AprovacaoDivulgacaoEvento buscaEventoAprovado(Evento evento) {
            AprovacaoDivulgacaoEvento aprovacaoDivulgacaoEvento = new AprovacaoDivulgacaoEvento();
            aprovacaoDivulgacaoEvento.setDivulgacaoAprovada(true);
            return aprovacaoDivulgacaoEvento;
        }
    }

    private class CursoServiceMock implements CursoService {
        @Override
        public List<Usuario> obtenhaUsuariosDoCurso(Integer idCurso) {
            List<Usuario> listaUsuarios = new ArrayList<>();

            listaUsuarios.add(usuarioTestatoI);
            listaUsuarios.add(usuarioTestatoII);
            listaUsuarios.add(usuarioTestatoIII);

            return listaUsuarios;
        }
    }

    private static class MailBoxMock{

        private static List<String> getMessages(String email){
            ArrayList<String> mensagens = new ArrayList<>();
            mensagens.add("teste");
            return mensagens;
        }

    }

}
