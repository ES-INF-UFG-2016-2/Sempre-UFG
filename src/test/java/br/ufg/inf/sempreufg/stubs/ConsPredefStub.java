package br.ufg.inf.sempreufg.stubs;

import java.util.Date;

public class ConsPredefStub {

    private String siglaConsulta;
    private String visibilidade;
    private boolean expressaoBooleana;
    private Date dataUltimaModificacao;
    private Date dataUltimaExecucao;
    private String idUsuarioResponsavel;

    public ConsPredefStub(String siglaConsulta, String visibilidade, boolean expressaoBooleana, Date dataUltimaModificacao, Date dataUltimaExecucao, String idUsuarioResponsavel) {
        this.siglaConsulta = siglaConsulta;
        this.visibilidade = visibilidade;
        this.expressaoBooleana = expressaoBooleana;
        this.dataUltimaModificacao = dataUltimaModificacao;
        this.dataUltimaExecucao = dataUltimaExecucao;
        this.idUsuarioResponsavel = idUsuarioResponsavel;
    }

}