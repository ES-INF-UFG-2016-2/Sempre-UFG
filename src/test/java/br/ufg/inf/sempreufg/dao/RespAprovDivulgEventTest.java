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

		aprovacaoDivulgacaoEventoResponsavel.setResponsavelPorAprovar(RespAprovDivulgEventTest.responsavel);
		aprovacaoDivulgacaoEventoUsuario.setResponsavelPorAprovar(RespAprovDivulgEventTest.responsavel);

		evento = new Evento();

		aprovacaoDivulgacaoEventoResponsavel = new AprovacaoDivulgacaoEvento();
		aprovacaoDivulgacaoEventoResponsavel.setEvento(evento);
		aprovacaoDivulgacaoEventoResponsavel.setAprovadoPor(responsavel);
		aprovacaoDivulgacaoEventoResponsavel.setDivulgacaoAprovada(true);
		aprovacaoDivulgacaoEventoResponsavel.setParecerSobreDivulgacao("Teste");
		aprovacaoDivulgacaoEventoResponsavel.setDataDoParecer(date);
		aprovacaoDivulgacaoEventoResponsavel.getResponsavelPorAprovar().setMail("teste");
		aprovacaoDivulgacaoEventoResponsavel.getResponsavelPorAprovar().setCpf(111111111);

		aprovacaoDivulgacaoEventoUsuario = new AprovacaoDivulgacaoEvento();
		aprovacaoDivulgacaoEventoUsuario.setEvento(evento);
		aprovacaoDivulgacaoEventoUsuario.setAprovadoPor(usuario);
		aprovacaoDivulgacaoEventoUsuario.setDivulgacaoAprovada(false);
		aprovacaoDivulgacaoEventoUsuario.setParecerSobreDivulgacao("Teste");
		aprovacaoDivulgacaoEventoUsuario.setDataDoParecer(date);
		aprovacaoDivulgacaoEventoUsuario.getResponsavelPorAprovar().setMail("teste");
		aprovacaoDivulgacaoEventoUsuario.getResponsavelPorAprovar().setCpf(111111111);

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
