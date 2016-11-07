package br.ufg.inf.modelo;

import br.ufg.inf.enums.MotivosReprovacaoEvento;
import br.ufg.inf.enums.UsuariosSistema;

public class SolicitacaoDivulgacao {

	private boolean aprovado;
	private boolean mensagensEnviadas;
	private boolean mensagensPublicadas;
	private UsuariosSistema escopoEvento;

	private Evento eventoDivulgacao;

	public SolicitacaoDivulgacao(Evento criarEventoDivulgacao) {

	}


	public void aprovarEvento(UsuariosSistema egressos) {
		setAprovado(true);
		setEscopoEvento(egressos);
	}

	public void reprovarEvento(MotivosReprovacaoEvento motivoReprovacao) {
		setAprovado(false);
	}

	public void enviarParaProcessoEncerramento() {

	}

	public void registrarFormaDivulgacaoPorMensagem(String mensagemDivulgacao) {
		setMensagensEnviadas(true);
	}

	public void registrarFormaDivulgacaoPorPortal(String mensagemDivulgacao) {
		setMensagensPublicadas(true);
	}

	public String criarMensagemDivulgacao() {
		return null;
	}

	public void encaminharSolicitacaoParaAprovacaoDosCursosResponsaveis() {
		if (getEscopoEvento().equals(UsuariosSistema.COMUNIDADE)) {
			setAprovado(false);
		}else{
			setAprovado(true);
		}
	}

	public String encaminhaSolicitacaoParaDivulgacao() {
		if (isAprovado()) {
			return "Solicitação em processo de divulgacao";
		}else{
			return "Solicitação com status de reprovada não pode ser divulgada";
		}

	}


	public boolean isAprovado() {
		return aprovado;
	}


	public void setAprovado(boolean aprovado) {
		this.aprovado = aprovado;
	}


	public boolean isMensagensEnviadas() {
		return mensagensEnviadas;
	}


	public void setMensagensEnviadas(boolean mensagensEnviadas) {
		this.mensagensEnviadas = mensagensEnviadas;
	}


	public boolean isMensagensPublicadas() {
		return mensagensPublicadas;
	}


	public void setMensagensPublicadas(boolean mensagensPublicadas) {
		this.mensagensPublicadas = mensagensPublicadas;
	}


	public UsuariosSistema getEscopoEvento() {
		return escopoEvento;
	}


	public void setEscopoEvento(UsuariosSistema escopoEvento) {
		this.escopoEvento = escopoEvento;
	}


	public Evento getEventoDivulgacao() {
		return eventoDivulgacao;
	}


	public void setEventoDivulgacao(Evento eventoDivulgacao) {
		this.eventoDivulgacao = eventoDivulgacao;
	}
}
