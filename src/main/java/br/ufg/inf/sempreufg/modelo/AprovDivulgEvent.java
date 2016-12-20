package br.ufg.inf.sempreufg.modelo;

import java.util.Date;

public class AprovDivulgEvent {

    private int idAprovacao;
    private Responsavel responsavel;
    private Evento evento;
    private Date dataAprovacao;
    private boolean divulgacaoAprovada;
    private String parecer;
    private Responsavel gestorSistema;
    private Usuario solicitante;

    public Responsavel getResponsavel() {
        return responsavel;
    }

    public Evento getEvento() {
        return evento;
    }

    public void setEvento(Evento evento) {
        this.evento = evento;
    }

    public void setDataAprovacao(Date dataAprovacao) {
        this.dataAprovacao = dataAprovacao;
    }

    public void setDivulgacaoAprovada(boolean divulgacaoAprovada) {
        this.divulgacaoAprovada = divulgacaoAprovada;
    }

    public void setParecer(String parecer) {
        this.parecer = parecer;
    }

    public Evento encaminhaDivulgacaoAprovada(Evento evento){
        divulgacaoAprovada = true;
        return evento;
    }

    public String encaminhaDiculgacaoNegada(String parecer){
        divulgacaoAprovada = false;
        return parecer;
    }

    public Responsavel getGestorSistema() {
        return gestorSistema;
    }

    public Usuario getSolicitante() {
        return solicitante;
    }

	@Override
	public void atribuirResponsavelPorAprovacaoDivulgacao(Evento evento, Responsavel reponsavel) {
		// TODO Auto-generated method stub
		// Metodo criado para o build funcionar
	
	}

}
