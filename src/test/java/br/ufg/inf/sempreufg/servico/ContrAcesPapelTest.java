package br.ufg.inf.sempreufg.servico;

import br.ufg.inf.sempreufg.enums.PoliticaRecebimentoMensagens;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import br.ufg.inf.sempreufg.modelo.Papel;
import br.ufg.inf.sempreufg.modelo.Recurso;
import br.ufg.inf.sempreufg.modelo.Usuario;
import br.ufg.inf.sempreufg.stubs.PapelStub;
import br.ufg.inf.sempreufg.stubs.RecursoServiceStub;
import br.ufg.inf.sempreufg.stubs.RecursoStub;
import br.ufg.inf.sempreufg.stubs.UsuarioStub;

import java.util.ArrayList;
import java.util.BitSet;
import java.util.Date;

/**
 * @author Bruno Martins de Carvalho
 *
 */
public class ContrAcesPapelTest {

	private RecursoServiceInterface recursoService;

	/**
	 *
	 * Método responsável por inicializar a interface de recursoService.
	 *
	 * @author Bruno Martins de Carvalho
	 */
	@Before
	public void setUp() {
		this.recursoService = new RecursoServiceStub();
	}

	/**
	 *
	 * Método responsável por testar se o usuário possui acesso a um determinado
	 * recurso. Usuário possui acesso ao recurso requisitado.
	 *
	 * @author Bruno Martins de Carvalho
	 */
	@Test
	public void testUsuarioPossuiAcessoARecurso() {
		final Recurso recurso = new Recurso("SR", "descricao", new ArrayList<>());
		final Papel papel = new Papel("PP", "nome", new ArrayList<>(), new ArrayList<>());
        papel.addRecurso(recurso);
		final Usuario usuario = new Usuario("", "", "", 12L, new BitSet(), PoliticaRecebimentoMensagens.CADA_EVENTO, new Date(), new Date(), new Date(), new ArrayList<>());
        usuario.addPapel(papel);

		Assert.assertTrue(this.recursoService.isUsuarioPossuiAcessoRecurso(usuario, recurso));
	}

	/**
	 *
	 * Método responsável por testar se o usuário possui acesso a um determinado
	 * recurso. Usuário não possui acesso ao recurso requisitado.
	 *
	 * @author Bruno Martins de Carvalho
	 */
	@Test
	public void testUsuarioNaoPossuiAcessoARecurso() {
        final Recurso recurso = new Recurso("SR", "descricao", new ArrayList<>());
        final Papel papel = new Papel("PP", "nome", new ArrayList<>(), new ArrayList<>());
        papel.addRecurso(recurso);
        final Usuario usuario = new Usuario("", "", "", 12L, new BitSet(), PoliticaRecebimentoMensagens.CADA_EVENTO, new Date(), new Date(), new Date(), new ArrayList<>());
        usuario.addPapel(papel);

		final Recurso recursoNaoUsado = new RecursoStub("idRecurso2", "SR", "descricao2");

		Assert.assertFalse(this.recursoService.isUsuarioPossuiAcessoRecurso(usuario, recursoNaoUsado));
	}

	/**
	 *
	 * Método responsável por testar se o usuario possui acesso a um determinado
	 * recurso. Usuario não possui acesso ao recurso requisitado; recurso nulo.
	 *
	 * @author Bruno Martins de Carvalho
	 */
	@Test
	public void testUsuarioNaoPossuiAcessoARecursoRecursoNulo() {
        final Recurso recurso = new Recurso("SR", "descricao", new ArrayList<>());
        final Papel papel = new Papel("PP", "nome", new ArrayList<>(), new ArrayList<>());
        papel.addRecurso(recurso);
        final Usuario usuario = new Usuario("", "", "", 12L, new BitSet(), PoliticaRecebimentoMensagens.CADA_EVENTO, new Date(), new Date(), new Date(), new ArrayList<>());
        usuario.addPapel(papel);

		Assert.assertFalse(this.recursoService.isUsuarioPossuiAcessoRecurso(usuario, null));
	}

	/**
	 *
	 * Método responsável por testar se o usuario possui acesso a um determinado
	 * recurso. Usuario possui acesso ao recurso requisitado; usuario possui
	 * acesso a varios recursos.
	 *
	 * @author Bruno Martins de Carvalho
	 */
	@Test
	public void testUsuarioPossuiAcessoARecursoUsuarioMultiplosRecursos() {
        final Recurso recurso1 = new Recurso("SR", "descricao1", new ArrayList<>());
        final Recurso recurso2 = new Recurso("SR", "descricao2", new ArrayList<>());
        final Recurso recurso3 = new Recurso("SR", "descricao3", new ArrayList<>());
        final Papel papel = new Papel("PP", "nome", new ArrayList<>(), new ArrayList<>());
        papel.addRecurso(recurso1);
        papel.addRecurso(recurso2);
        papel.addRecurso(recurso3);
        final Usuario usuario = new Usuario("", "", "", 12L, new BitSet(), PoliticaRecebimentoMensagens.CADA_EVENTO, new Date(), new Date(), new Date(), new ArrayList<>());
        usuario.addPapel(papel);

		Assert.assertTrue(this.recursoService.isUsuarioPossuiAcessoRecurso(usuario, recurso2));
	}

	/**
	 *
	 * Método responsável por testar se o usuario possui acesso a um determinado
	 * recurso. Usuario não possui acesso ao recurso requisitado; possui acesso
	 * a multiplos recursos porem nao possui ao requisitado.
	 *
	 * @author Bruno Martins de Carvalho
	 */
	@Test
	public void testUsuarioNaoPossuiAcessoARecursoUsuarioMultiplosRecursos() {
        final Recurso recurso1 = new Recurso("SR", "descricao1", new ArrayList<>());
        final Recurso recurso2 = new Recurso("SR", "descricao2", new ArrayList<>());
        final Recurso recurso3 = new Recurso("SR", "descricao3", new ArrayList<>());
        final Papel papel = new Papel("PP", "nome", new ArrayList<>(), new ArrayList<>());
        papel.addRecurso(recurso1);
        papel.addRecurso(recurso2);
        final Usuario usuario = new Usuario("", "", "", 12L, new BitSet(), PoliticaRecebimentoMensagens.CADA_EVENTO, new Date(), new Date(), new Date(), new ArrayList<>());
        usuario.addPapel(papel);

		Assert.assertFalse(this.recursoService.isUsuarioPossuiAcessoRecurso(usuario, recurso3));
	}

	/**
	 *
	 * Método responsável por testar se o usuario possui acesso a um determinado
	 * recurso. Usuario possui acesso ao recurso requisitado; usuario possui
	 * acesso a um único recurso, porem possui varios papeis.
	 *
	 * @author Bruno Martins de Carvalho
	 */
	@Test
	public void testUsuarioPossuiAcessoARecursoUsuarioMultiplosPapeis() {
        final Recurso recurso = new Recurso("SR", "descricao1", new ArrayList<>());
        final Papel papel1 = new Papel("PP1", "nome1", new ArrayList<>(), new ArrayList<>());
        final Papel papel2 = new Papel("PP2", "nome2", new ArrayList<>(), new ArrayList<>());
        final Papel papel3 = new Papel("PP3", "nome3", new ArrayList<>(), new ArrayList<>());
        papel1.addRecurso(recurso);
        papel2.addRecurso(recurso);
        papel3.addRecurso(recurso);
        final Usuario usuario = new Usuario("", "", "", 12L, new BitSet(), PoliticaRecebimentoMensagens.CADA_EVENTO, new Date(), new Date(), new Date(), new ArrayList<>());
        usuario.addPapel(papel1);
        usuario.addPapel(papel2);
        usuario.addPapel(papel3);

		Assert.assertTrue(this.recursoService.isUsuarioPossuiAcessoRecurso(usuario, recurso));
	}

	/**
	 *
	 * Método responsável por testar se o usuario possui acesso a um determinado
	 * recurso. Usuario nao possui acesso ao recurso requisitado, usuario possui
	 * acesso a um recurso atraves de multiplos papeis.
	 *
	 * @author Bruno Martins de Carvalho
	 */
	@Test
	public void testUsuarioNaoPossuiAcessoARecursoUsuarioMultiplosPapeis() {
        final Recurso recurso1 = new Recurso("SR", "descricao1", new ArrayList<>());
        final Recurso recurso2 = new Recurso("SR", "descricao2", new ArrayList<>());
        final Papel papel1 = new Papel("PP1", "nome1", new ArrayList<>(), new ArrayList<>());
        papel1.addRecurso(recurso1);
        final Papel papel2 = new Papel("PP2", "nome2", new ArrayList<>(), new ArrayList<>());
        papel2.addRecurso(recurso1);
        final Papel papel3 = new Papel("PP3", "nome3", new ArrayList<>(), new ArrayList<>());
        papel3.addRecurso(recurso1);
        final Usuario usuario = new Usuario("", "", "", 12L, new BitSet(), PoliticaRecebimentoMensagens.CADA_EVENTO, new Date(), new Date(), new Date(), new ArrayList<>());
        usuario.addPapel(papel1);
        usuario.addPapel(papel2);
        usuario.addPapel(papel3);

		Assert.assertFalse(this.recursoService.isUsuarioPossuiAcessoRecurso(usuario, recurso2));
	}

	/**
	 *
	 * Método responsável por testar se o usuario possui acesso a um determinado
	 * recurso. Usuario possui acesso ao recurso requisitado; usuario possui
	 * acesso a varios recursos, atraves de multiplos papeis.
	 *
	 * @author Bruno Martins de Carvalho
	 */
	@Test
	public void testUsuarioPossuiAcessoARecursoUsuarioMultiplosPapeisERecursos() {
        final Recurso recurso1 = new Recurso("SR", "descricao1", new ArrayList<>());
        final Recurso recurso2 = new Recurso("SR", "descricao2", new ArrayList<>());
        final Recurso recurso3 = new Recurso("SR", "descricao3", new ArrayList<>());

        final Papel papel1 = new Papel("PP1", "nome1", new ArrayList<>(), new ArrayList<>());
        papel1.addRecurso(recurso1);
        final Papel papel2 = new Papel("PP2", "nome2", new ArrayList<>(), new ArrayList<>());
        papel2.addRecurso(recurso1);
        papel2.addRecurso(recurso2);
        final Papel papel3 = new Papel("PP3", "nome3", new ArrayList<>(), new ArrayList<>());
        papel3.addRecurso(recurso3);

        final Usuario usuario = new Usuario("", "", "", 12L, new BitSet(), PoliticaRecebimentoMensagens.CADA_EVENTO, new Date(), new Date(), new Date(), new ArrayList<>());
        usuario.addPapel(papel1);
        usuario.addPapel(papel2);
        usuario.addPapel(papel3);

		Assert.assertTrue(this.recursoService.isUsuarioPossuiAcessoRecurso(usuario, recurso2));
	}

	/**
	 *
	 * Método responsável por testar se o usuario possui acesso a um determinado
	 * recurso. Usuario nao possui acesso ao recurso requisitado; usuario possui
	 * acesso a varios recursos, atraves de multiplos papeis, porem nenhum
	 * permite acesso ao recurso requisitado.
	 *
	 * @author Bruno Martins de Carvalho
	 */
	@Test
	public void testUsuarioNaoPossuiAcessoARecursoUsuarioMultiplosPapeisERecursos() {
        final Recurso recurso1 = new Recurso("SR", "descricao1", new ArrayList<>());
        final Recurso recurso2 = new Recurso("SR", "descricao2", new ArrayList<>());
        final Recurso recurso3 = new Recurso("SR", "descricao3", new ArrayList<>());

        final Papel papel1 = new Papel("PP1", "nome1", new ArrayList<>(), new ArrayList<>());
        papel1.addRecurso(recurso1);
        final Papel papel2 = new Papel("PP2", "nome2", new ArrayList<>(), new ArrayList<>());
        papel2.addRecurso(recurso1);
        papel2.addRecurso(recurso2);

        final Usuario usuario = new Usuario("", "", "", 12L, new BitSet(), PoliticaRecebimentoMensagens.CADA_EVENTO, new Date(), new Date(), new Date(), new ArrayList<>());
        usuario.addPapel(papel1);
        usuario.addPapel(papel2);

		Assert.assertFalse(this.recursoService.isUsuarioPossuiAcessoRecurso(usuario, recurso3));
	}

}
