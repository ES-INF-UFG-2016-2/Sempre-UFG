package br.ufg.inf.servico;

import br.ufg.inf.modelo.Evento;
import br.ufg.inf.modelo.Usuario;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;

import javax.mail.Folder;
import javax.mail.Session;
import javax.mail.Store;

public class DivulgaEventEgresTest {
    private Usuario usuarioTestatoI;
    private Usuario usuarioTestatoII;
    private Usuario usuarioTestatoIII;
    private List<Usuario> usuarioCurso;
    private Evento evento;

    private DivulgadorEventosServiceInterface divulgadorEventosServiceInterface;
    private AprovadorEventosServiceInterface aprovadorEventosServiceInterface;
    private CursoServiceInterface cursoServiceInterface;

    @Before
    public void setUp() {
        usuarioCurso = new ArrayList<>();
        aprovadorEventosServiceInterface = new AprovadorEventosService();
        cursoServiceInterface = new CursoService();
        divulgadorEventosServiceInterface = new DivulgadorEventosService();
        usuarioTestatoI = new Usuario();
        usuarioTestatoI.setNome("NomeUsuarioTesteI");
        usuarioTestatoI.setCpf(99999999999l);
        usuarioTestatoI.setMail("usuarioTestado");

        usuarioTestatoII = new Usuario();
        usuarioTestatoII.setNome("NomeUsuarioTesteII");
        usuarioTestatoII.setCpf(99999999998l);
        usuarioTestatoII.setMail("usuarioTestadoIII");

        usuarioTestatoIII = new Usuario();
        usuarioTestatoIII.setNome("NomeUsuarioTesteIII");
        usuarioTestatoIII.setCpf(99999999998l);
        usuarioTestatoIII.setMail("usuarioTestadoIII");

        usuarioCurso.add(usuarioTestatoI);
        usuarioCurso.add(usuarioTestatoII);
        usuarioCurso.add(usuarioTestatoIII);

        evento = new Evento();
        evento.setAssunto("Evento");
        evento.setDes_evento("Descrição Evento");
        evento.setId(99999);
    }

    @Test
    public void testEnviaEventoPraUsuariosDeUmCurso() throws Exception {
        Boolean aprovacaoDivulgacaoEvento = aprovadorEventosServiceInterface.isEventoAprovado(evento);
        Session session = Session.getDefaultInstance(new Properties());
        Store storeUsuario1 = session.getStore("pop3");
        Store storeUsuario2 = session.getStore("pop3");
        Store storeUsuario3 = session.getStore("pop3");

        storeUsuario1.connect("gmail.com", usuarioTestatoI.getNome(), "password");
        storeUsuario2.connect("gmail.com", usuarioTestatoII.getNome(), "password");
        storeUsuario3.connect("gmail.com", usuarioTestatoIII.getNome(), "password");

        Folder folderUsuario1 = storeUsuario1.getFolder("inbox");
        Folder folderUsuario2 = storeUsuario2.getFolder("inbox");
        Folder folderUsuario3 = storeUsuario3.getFolder("inbox");
        boolean resultado = divulgadorEventosServiceInterface.divulgarEventoParaListaDeUsuarios(evento, usuarioCurso);

        folderUsuario1.open(Folder.READ_ONLY);
        folderUsuario2.open(Folder.READ_ONLY);
        folderUsuario3.open(Folder.READ_ONLY);

        assertTrue(aprovacaoDivulgacaoEvento);
        assertTrue(resultado);
        assertTrue(folderUsuario1.getMessages().length == 1);
        assertTrue(folderUsuario2.getMessages().length == 1);
        assertTrue(folderUsuario3.getMessages().length == 1);
    }
}
