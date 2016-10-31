package br.ufg.inf.rd_gestimport;

import java.util.Date;


public class RdGestImport {

    private String nomeTabela;
    private String colunaTimestamp;
    private String colunaInicioPeriodo;
    private String colunaFimPeriodo;
    private String colunaQtdRecebidos;
    private String colunaQtdImportados;
    private String colunaQtdSucesso;
    private String colunaQtdIncorretos;
    private String colunaQtdReplicados;
    private String colunaIdentificador;
    private String colunaUsuario;

    public String getColunaIdentificador() {
        return colunaIdentificador;
    }

    public void setColunaIdentificador(String colunaIdentificador) {
        this.colunaIdentificador = colunaIdentificador;
    }

    public String getColunaUsuario() {
        return colunaUsuario;
    }

    public void setColunaUsuario(String colunaUsuario) {
        this.colunaUsuario = colunaUsuario;
    }

    public String getNomeTabela() {
        return nomeTabela;
    }

    public void setNomeTabela(String nomeTabela) {
        this.nomeTabela = nomeTabela;
    }

    public String getColunaTimestamp() {
        return colunaTimestamp;
    }

    public void setColunaTimestamp(String colunaTimestamp) {
        this.colunaTimestamp = colunaTimestamp;
    }

    public String getColunaInicioPeriodo() {
        return colunaInicioPeriodo;
    }

    public void setColunaInicioPeriodo(String colunaInicioPeriodo) {
        this.colunaInicioPeriodo = colunaInicioPeriodo;
    }

    public String getColunaFimPeriodo() {
        return colunaFimPeriodo;
    }

    public void setColunaFimPeriodo(String colunaFimPeriodo) {
        this.colunaFimPeriodo = colunaFimPeriodo;
    }

    public String getColunaQtdRecebidos() {
        return colunaQtdRecebidos;
    }

    public void setColunaQtdRecebidos(String colunaQtdRecebidos) {
        this.colunaQtdRecebidos = colunaQtdRecebidos;
    }

    public String getColunaQtdImportados() {
        return colunaQtdImportados;
    }

    public void setColunaQtdImportados(String colunaQtdImportados) {
        this.colunaQtdImportados = colunaQtdImportados;
    }

    public String getColunaQtdSucesso() {
        return colunaQtdSucesso;
    }

    public void setColunaQtdSucesso(String colunaQtdSucesso) {
        this.colunaQtdSucesso = colunaQtdSucesso;
    }

    public String getColunaQtdIncorretos() {
        return colunaQtdIncorretos;
    }

    public void setColunaQtdIncorretos(String colunaQtdIncorretos) {
        this.colunaQtdIncorretos = colunaQtdIncorretos;
    }

    public String getColunaQtdReplicados() {
        return colunaQtdReplicados;
    }

    public void setColunaQtdReplicados(String colunaQtdReplicados) {
        this.colunaQtdReplicados = colunaQtdReplicados;
    }
}
