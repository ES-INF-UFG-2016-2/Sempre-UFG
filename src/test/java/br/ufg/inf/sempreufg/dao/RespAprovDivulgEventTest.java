package br.ufg.inf.sempreufg.dao;

import br.ufg.inf.sempreufg.dao.AprovacaoDivulgacaoEventoDAO;
import br.ufg.inf.sempreufg.modelo.AprovacaoDivulgacaoEvento;
import br.ufg.inf.sempreufg.modelo.Evento;
import br.ufg.inf.sempreufg.modelo.Responsavel;
import br.ufg.inf.sempreufg.modelo.Usuario;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class RespAprovDivulgEventTest {
	private static Responsavel responsavel;
	private static Evento evento;
	private static AprovacaoDivulgacaoEvento aprovacaoDivulgacaoEventoResponsavel;
	private static AprovacaoDivulgacaoEvento aprovacaoDivulgacaoEventoUsuario;
	private static AprovacaoDivulgacaoEventoDAO aprovacaoDivulgacaoEventoDAO;
	private static Usuario usuario;

	private static Date date;

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
}
