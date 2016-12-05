package br.ufg.inf.sempreufg.interfaces;

import br.ufg.inf.sempreufg.enums.ComandoSQL;
import br.ufg.inf.sempreufg.enums.VerbosidadeValores;

/**
 * Created by DYEGO-VOSTRO on 28/11/2016.
 */
public class LogItens {

    private String nomeAplicacao;
    private boolean tentativasConexao;
    private boolean duracaoComandos;
    private VerbosidadeValores versidade;
    private boolean nomeServidor;
    private String comentarioPrefixo;
    private boolean esperaLimite;
    private ComandoSQL comandoSQL;
    private String fusoHorario;

    public String getNomeAplicacao() {
        return nomeAplicacao;
    }

    public void setNomeAplicacao(String nomeAplicacao) {
        this.nomeAplicacao = nomeAplicacao;
    }

    public boolean isTentativasConexao() {
        return tentativasConexao;
    }

    public void setTentativasConexao(boolean tentativasConexao) {
        this.tentativasConexao = tentativasConexao;
    }

    public boolean isDuracaoComandos() {
        return duracaoComandos;
    }

    public void setDuracaoComandos(boolean duracaoComandos) {
        this.duracaoComandos = duracaoComandos;
    }

    public VerbosidadeValores getVersidade() {
        return versidade;
    }

    public void setVersidade(VerbosidadeValores versidade) {
        this.versidade = versidade;
    }

    public boolean isNomeServidor() {
        return nomeServidor;
    }

    public void setNomeServidor(boolean nomeServidor) {
        this.nomeServidor = nomeServidor;
    }

    public String getComentarioPrefixo() {
        return comentarioPrefixo;
    }

    public void setComentarioPrefixo(String comentarioPrefixo) {
        this.comentarioPrefixo = comentarioPrefixo;
    }

    public boolean isEsperaLimite() {
        return esperaLimite;
    }

    public void setEsperaLimite(boolean esperaLimite) {
        this.esperaLimite = esperaLimite;
    }

    public ComandoSQL getComandoSQL() {
        return comandoSQL;
    }

    public void setComandoSQL(ComandoSQL comandoSQL) {
        this.comandoSQL = comandoSQL;
    }

    public String getFusoHorario() {
        return fusoHorario;
    }

    public void setFusoHorario(String fusoHorario) {
        this.fusoHorario = fusoHorario;
    }


}
