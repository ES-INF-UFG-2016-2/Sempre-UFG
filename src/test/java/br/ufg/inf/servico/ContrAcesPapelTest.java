package br.ufg.inf.servico;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import br.ufg.inf.modelo.Papel;
import br.ufg.inf.modelo.Recurso;
import br.ufg.inf.modelo.Usuario;
import br.ufg.inf.stubs.PapelStub;
import br.ufg.inf.stubs.RecursoServiceStub;
import br.ufg.inf.stubs.RecursoStub;
import br.ufg.inf.stubs.UsuarioStub;

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
		final Recurso recurso = new RecursoStub("idRecurso", "SR", "descricao");
		final Papel papel = new PapelStub(recurso);
		final Usuario usuario = new UsuarioStub(papel);

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
		final Recurso recurso = new RecursoStub("idRecurso", "SR", "descricao");
		final Papel papel = new PapelStub(recurso);
		final Usuario usuario = new UsuarioStub(papel);

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
		final Recurso recurso = new RecursoStub("idRecurso", "SR", "descricao");
		final Papel papel = new PapelStub(recurso);
		final Usuario usuario = new UsuarioStub(papel);

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
		final Recurso recurso1 = new RecursoStub("idRecurso1", "SR", "descricao1");
		final Recurso recurso2 = new RecursoStub("idRecurso2", "SR", "descricao2");
		final Recurso recurso3 = new RecursoStub("idRecurso3", "SR", "descricao3");

		final Papel papel = new PapelStub(recurso1, recurso2, recurso3);
		final Usuario usuario = new UsuarioStub(papel);

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
		final Recurso recurso1 = new RecursoStub("idRecurso1", "SR", "descricao1");
		final Recurso recurso2 = new RecursoStub("idRecurso2", "SR", "descricao2");
		final Recurso recurso3 = new RecursoStub("idRecurso3", "SR", "descricao3");

		final Papel papel = new PapelStub(recurso1, recurso2);
		final Usuario usuario = new UsuarioStub(papel);

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
		final Recurso recurso = new RecursoStub("idRecurso1", "SR", "descricao1");

		final Papel papel1 = new PapelStub(recurso);
		final Papel papel2 = new PapelStub(recurso);
		final Papel papel3 = new PapelStub(recurso);

		final Usuario usuario = new UsuarioStub(papel1, papel2, papel3);

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
		final Recurso recurso1 = new RecursoStub("idRecurso1", "SR", "descricao1");
		final Recurso recurso2 = new RecursoStub("idRecurso2", "SR", "descricao3");

		final Papel papel1 = new PapelStub(recurso1);
		final Papel papel2 = new PapelStub(recurso1);
		final Papel papel3 = new PapelStub(recurso1);

		final Usuario usuario = new UsuarioStub(papel1, papel2, papel3);

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
		final Recurso recurso1 = new RecursoStub("idRecurso1", "SR", "descricao1");
		final Recurso recurso2 = new RecursoStub("idRecurso2", "SR", "descricao2");
		final Recurso recurso3 = new RecursoStub("idRecurso3", "SR", "descricao3");

		final Papel papel1 = new PapelStub(recurso1);
		final Papel papel2 = new PapelStub(recurso1, recurso2);
		final Papel papel3 = new PapelStub(recurso3);

		final Usuario usuario = new UsuarioStub(papel1, papel2, papel3);

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
		final Recurso recurso1 = new RecursoStub("idRecurso1", "SR", "descricao1");
		final Recurso recurso2 = new RecursoStub("idRecurso2", "SR", "descricao2");
		final Recurso recurso3 = new RecursoStub("idRecurso3", "SR", "descricao3");

		final Papel papel1 = new PapelStub(recurso1);
		final Papel papel2 = new PapelStub(recurso1, recurso2);

		final Usuario usuario = new UsuarioStub(papel1, papel2);

		Assert.assertFalse(this.recursoService.isUsuarioPossuiAcessoRecurso(usuario, recurso3));
	}

}
