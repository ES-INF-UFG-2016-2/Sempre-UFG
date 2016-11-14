package br.ufg.inf.servico;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import br.ufg.inf.enums.MotivosReprovacaoEvento;
import br.ufg.inf.enums.UsuariosSistema;
import br.ufg.inf.modelo.Evento;
import br.ufg.inf.modelo.SolicitacaoDivulgacao;

@SuppressWarnings("deprecation")
public class TesteAvalSolicDivulgEvent {

	private SolicitacaoDivulgacao solicitacaoDivulgacao;

	@Before
	public void init(){
		solicitacaoDivulgacao = new SolicitacaoDivulgacao(criarEventoDivulgacao());
	}

	public Evento criarEventoDivulgacao(){
		return new Evento();
	}

	@SuppressWarnings("deprecation")
	@Test
	public void testeEventoEstaReprovado(){
		solicitacaoDivulgacao.reprovarEvento(MotivosReprovacaoEvento.NAO_RELEVANTE_A_ORGANIZACAO);
		Assert.assertEquals(false, solicitacaoDivulgacao.isAprovado());
	}

	@SuppressWarnings("deprecation")
	@Test
	public void testeEventoAprovaSolicitacao(){
		solicitacaoDivulgacao.aprovarEvento(UsuariosSistema.COMUNIDADE);
		Assert.assertEquals(true, solicitacaoDivulgacao.isAprovado());
	}

	@Test
	public void testeRejeitarSolicitacao(){
		solicitacaoDivulgacao.reprovarEvento(MotivosReprovacaoEvento.NAO_RELEVANTE_A_ORGANIZACAO);
		solicitacaoDivulgacao.enviarParaProcessoEncerramento();
		Assert.assertEquals(false, solicitacaoDivulgacao.isAprovado());
	}

	@Test
	public void regristrarFormaDeDivulgacaoPorMensagem(){
		solicitacaoDivulgacao.aprovarEvento(UsuariosSistema.COMUNIDADE);

		String mensagemDivulgacao = solicitacaoDivulgacao.criarMensagemDivulgacao();
		solicitacaoDivulgacao.registrarFormaDivulgacaoPorMensagem(mensagemDivulgacao);
		Assert.assertEquals(true, solicitacaoDivulgacao.isMensagensEnviadas());
	}

	@Test
	public void registrarFormaDeDivulgacaoPorPortalSistema(){
		solicitacaoDivulgacao.aprovarEvento(UsuariosSistema.COMUNIDADE);

		String mensagemDivulgacao = solicitacaoDivulgacao.criarMensagemDivulgacao();
		solicitacaoDivulgacao.registrarFormaDivulgacaoPorPortal(mensagemDivulgacao);
		Assert.assertEquals(true, solicitacaoDivulgacao.isMensagensPublicadas());
	}

	@Test
	public void registrarFormaDivulgacaoDupla(){
		solicitacaoDivulgacao.aprovarEvento(UsuariosSistema.COMUNIDADE);

		String mensagemDivulgacao = solicitacaoDivulgacao.criarMensagemDivulgacao();
		solicitacaoDivulgacao.registrarFormaDivulgacaoPorMensagem(mensagemDivulgacao);
		solicitacaoDivulgacao.registrarFormaDivulgacaoPorPortal(mensagemDivulgacao);
		boolean result = (solicitacaoDivulgacao.isMensagensEnviadas() && solicitacaoDivulgacao.isMensagensPublicadas());
		Assert.assertEquals(true, result);
	}


	@Test
	public void testarEscopoEventoEgressos(){
		solicitacaoDivulgacao.aprovarEvento(UsuariosSistema.EGRESSOS);
		Assert.assertEquals(UsuariosSistema.EGRESSOS, solicitacaoDivulgacao.getEscopoEvento());
	}

	@Test
	public void testarEscopoEventoComunidade(){
		solicitacaoDivulgacao.aprovarEvento(UsuariosSistema.COMUNIDADE);
		Assert.assertEquals(UsuariosSistema.COMUNIDADE, solicitacaoDivulgacao.getEscopoEvento());
	}

	@Test
	public void testeEncaminharSolicitacaoParaResponsaveisDoCursoParaAprovacaoComEscopoEgressos(){
		solicitacaoDivulgacao.aprovarEvento(UsuariosSistema.EGRESSOS);
		solicitacaoDivulgacao.encaminharSolicitacaoParaAprovacaoDosCursosResponsaveis();
		Assert.assertEquals(true, solicitacaoDivulgacao.isAprovado());
	}

	@Test
	public void testeEncaminharSolicitacaoParaResponsaveisDoCursoParaAprovacaoComEscopoDaComunidade(){
		solicitacaoDivulgacao.aprovarEvento(UsuariosSistema.COMUNIDADE);
		solicitacaoDivulgacao.encaminharSolicitacaoParaAprovacaoDosCursosResponsaveis();
		Assert.assertEquals(false, solicitacaoDivulgacao.isAprovado());
	}

	@Test
	public void encaminharSolicitacaoNaoAprovadaParaDivulgacao(){
		solicitacaoDivulgacao.reprovarEvento(MotivosReprovacaoEvento.NAO_RELEVANTE_A_ORGANIZACAO);
		String resposta = solicitacaoDivulgacao.encaminhaSolicitacaoParaDivulgacao();
		Assert.assertEquals("Solicitação com status de reprovada não pode ser divulgada", resposta);
	}

	@Test
	public void encaminharSolicitacaoParaDilvulgacao(){
		solicitacaoDivulgacao.aprovarEvento(UsuariosSistema.COMUNIDADE);

		String mensagemDivulgacao = solicitacaoDivulgacao.criarMensagemDivulgacao();
		solicitacaoDivulgacao.registrarFormaDivulgacaoPorMensagem(mensagemDivulgacao);
		solicitacaoDivulgacao.registrarFormaDivulgacaoPorPortal(mensagemDivulgacao);

		String resposta = solicitacaoDivulgacao.encaminhaSolicitacaoParaDivulgacao();

		Assert.assertEquals("Solicitação em processo de divulgacao", resposta);

	}
}
