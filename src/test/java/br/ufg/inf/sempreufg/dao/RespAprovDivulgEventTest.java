package br.ufg.inf.sempreufg.dao;

import br.ufg.inf.sempreufg.modelo.*;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class RespAprovDivulgEventTest {

	private static Responsavel responsavel;
	private static Evento evento;
	private static AprovacaoDivulgacaoEvento aprovacaoDivulgacaoEventoResponsavel;
	private static AprovacaoDivulgacaoEvento aprovacaoDivulgacaoEventoUsuario;
	private static AprovacaoDivulgacaoEventoDAO aprovacaoDivulgacaoEventoDAO;
	private static Usuario usuario;

	private static Date date;
  
      private RespAprovaDivulgacaoEventoDao respAprovaDivulgacaoEventoDao;

    @Before
    public void startUp(){
        respAprovaDivulgacaoEventoDao = new RespAprovaDivulgacaoEventoDao();
    }

	@BeforeClass
	public static void init() {
		date = new Date();

		List listResponsaveis = new ArrayList();
		listResponsaveis.add("Usuario Responsavel");

		Usuario usuario = new Usuario();

		Responsavel responsavel = new Responsavel(listResponsaveis);

		evento = new Evento(1, "teste de divulgação", "teste", date, 1, date, "teste", "teste", "teste");

		aprovacaoDivulgacaoEventoResponsavel = new AprovacaoDivulgacaoEvento();
		aprovacaoDivulgacaoEventoResponsavel.setEvento(evento);
		aprovacaoDivulgacaoEventoResponsavel.setAprovadoPor(responsavel);
		aprovacaoDivulgacaoEventoResponsavel.setDivulgacaoAprovada(true);
		aprovacaoDivulgacaoEventoResponsavel.setParecerSobreDivulgacao("Teste");
		aprovacaoDivulgacaoEventoResponsavel.setDataDoParecer(date);

		aprovacaoDivulgacaoEventoUsuario = new AprovacaoDivulgacaoEvento();
		aprovacaoDivulgacaoEventoUsuario.setEvento(evento);
		aprovacaoDivulgacaoEventoUsuario.setAprovadoPor(usuario);
		aprovacaoDivulgacaoEventoUsuario.setDivulgacaoAprovada(false);
		aprovacaoDivulgacaoEventoUsuario.setParecerSobreDivulgacao("Teste");
		aprovacaoDivulgacaoEventoUsuario.setDataDoParecer(date);

		aprovacaoDivulgacaoEventoDAO = new AprovacaoDivulgacaoEventoDAO();
	}

	@Test
	public void testeEventoAprovadoComResponsavel() {
		aprovacaoDivulgacaoEventoDAO.salvar(aprovacaoDivulgacaoEventoResponsavel);
		assertTrue(aprovacaoDivulgacaoEventoDAO.obtemStatusAprovacaoEvento());
	}

	@Test
	public void testeEventoAprovadoComUsuarioNormal() {
		aprovacaoDivulgacaoEventoDAO.salvar(aprovacaoDivulgacaoEventoUsuario);
		assertFalse(aprovacaoDivulgacaoEventoDAO.obtemStatusAprovacaoEvento());
	}

    @Test
    public void testeGravarRespAprovaDivulgacaoEvento(){
        RespAprovaDivulgacaoEvento respAprovaDivulgacaoEvento =
            respAprovaDivulgacaoEventoDao.criaRespAprovaDivulgacaoEventoStub();

        RespAprovaDivulgacaoEvento respAprovaDivulgacaoEventoGravado =
            respAprovaDivulgacaoEventoDao.salvar(respAprovaDivulgacaoEvento);

        Assert.assertTrue(EqualsBuilder.reflectionEquals(
            respAprovaDivulgacaoEvento,respAprovaDivulgacaoEventoGravado));
    }

    @Test
    public void testeGravarRespAprovaDivulgacaoEventoInvalido(){
        RespAprovaDivulgacaoEvento respAprovaDivulgacaoEvento = null;

        RespAprovaDivulgacaoEvento respAprovaDivulgacaoEventoGravado =
            respAprovaDivulgacaoEventoDao.salvar(respAprovaDivulgacaoEvento);

        assertNull(respAprovaDivulgacaoEventoGravado);
    }

    @Test
    public void testeAlterarRespAprovaDivulgacaoEvento(){
        RespAprovaDivulgacaoEvento respAprovaDivulgacaoEvento =
            respAprovaDivulgacaoEventoDao.criaRespAprovaDivulgacaoEventoStub();

        Usuario usuario = new Usuario();
        usuario.setNome("Teste de Alteracao");
        usuario.setCpf(675934422);
        usuario.setMail("testeAlteracao@testeAlteracao.com");
        respAprovaDivulgacaoEvento.setUsuario(usuario);

        RespAprovaDivulgacaoEvento respAprovaDivulgacaoEventoGravado =
            respAprovaDivulgacaoEventoDao.alterar(respAprovaDivulgacaoEvento);

        Assert.assertTrue(EqualsBuilder.reflectionEquals(
            respAprovaDivulgacaoEvento,respAprovaDivulgacaoEventoGravado));
    }

    @Test
    public void testeAlterarRespAprovaDivulgacaoEventoInvalido(){
        RespAprovaDivulgacaoEvento respAprovaDivulgacaoEvento = null;

        RespAprovaDivulgacaoEvento respAprovaDivulgacaoEventoGravado =
            respAprovaDivulgacaoEventoDao.alterar(respAprovaDivulgacaoEvento);

        assertNull(respAprovaDivulgacaoEventoGravado);
    }

    @Test
    public void testeDeletarRespAprovaDivulgacaoEvento(){
        assertTrue(respAprovaDivulgacaoEventoDao.deletar(
            respAprovaDivulgacaoEventoDao.criaRespAprovaDivulgacaoEventoStub()));
    }
    @Test
    public void testeDeletarRespAprovaDivulgacaoEventoInvalido(){
        RespAprovaDivulgacaoEvento respAprovaDivulgacaoEvento = null;
        assertFalse(respAprovaDivulgacaoEventoDao.deletar(respAprovaDivulgacaoEvento));
    }

    @Test
    public void testeGetByIdRespAprovaDivulgacaoEvento(){
        RespAprovaDivulgacaoEvento respAprovaDivulgacaoEvento =
            respAprovaDivulgacaoEventoDao.criaRespAprovaDivulgacaoEventoStub();

        RespAprovaDivulgacaoEvento respAprovaDivulgacaoEventoById =
            respAprovaDivulgacaoEventoDao.getById("idTeste");

        assertEquals(respAprovaDivulgacaoEvento.getId(),respAprovaDivulgacaoEventoById.getId());
        Assert.assertTrue(EqualsBuilder.reflectionEquals(
            respAprovaDivulgacaoEvento.getUsuario(),respAprovaDivulgacaoEventoById.getUsuario()));
        Assert.assertTrue(EqualsBuilder.reflectionEquals(
            respAprovaDivulgacaoEvento.getEvento(),respAprovaDivulgacaoEventoById.getEvento()));
    }

    @Test
    public void testeGetByIdRespAprovaDivulgacaoEventoInvalido(){
        String strNull = null;
        assertNull(respAprovaDivulgacaoEventoDao.getById(strNull));
    }

    @Test
    public void testeGetAllRespAprovaDivulgacaoEvento(){
        List<RespAprovaDivulgacaoEvento> respAprovaDivulgacaoEventos = new ArrayList<>();
        respAprovaDivulgacaoEventos.add(respAprovaDivulgacaoEventoDao.criaRespAprovaDivulgacaoEventoStub());

        Assert.assertTrue(EqualsBuilder.reflectionEquals(
            respAprovaDivulgacaoEventos,respAprovaDivulgacaoEventoDao.getAll()));
    }
}
