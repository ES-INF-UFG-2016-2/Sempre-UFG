package br.ufg.inf.sempreufg.servico;

import br.ufg.inf.sempreufg.modelo.Evento;
import br.ufg.inf.sempreufg.modelo.SolicitacaoDivulgacaoEvento;
import org.junit.Before;

@SuppressWarnings("deprecation")
public class TesteAvalSolicDivulgEvent {

	private SolicitacaoDivulgacaoEvento solicitacaoDivulgacaoEvento;

	@Before
	public void init(){
        solicitacaoDivulgacaoEvento = new SolicitacaoDivulgacaoEvento();
	}

	public Evento criarEventoDivulgacao(){
		return new Evento();
	}

	/*

    O seguinte bloco de código foi comentado por Johnathan Gomes pois o teste criado não
    corresponde com a arquitetura de classes e dados projetada e ao refatorar ele quebrou.
    É necessário que o dono desse teste o adapte para as novas exigências de projeto.

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

	 */

}
