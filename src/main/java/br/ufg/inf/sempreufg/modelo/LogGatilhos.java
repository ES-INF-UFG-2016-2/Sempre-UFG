package br.ufg.inf.sempreufg.modelo;

import br.ufg.inf.sempreufg.interfaces.LogConfigItem;

import java.util.HashMap;

/**
 * Created by DYEGO-VOSTRO on 28/11/2016.
 */
public class LogGatilhos implements LogConfigItem{
    private String destinoLog;
    private String diretorioLog;
    private String nomeArquivo;
    private int tempoDeVidaLog;
    private int tamanhoMaximoLog;

    public String getDestinoLog() {
        return destinoLog;
    }

    public void setDestinoLog(String destinoLog) {
        this.destinoLog = destinoLog;
    }

    public String getDiretorioLog() {
        return diretorioLog;
    }

    public void setDiretorioLog(String diretorioLog) {
        this.diretorioLog = diretorioLog;
    }

    public String getNomeArquivo() {
        return nomeArquivo;
    }

    public void setNomeArquivo(String nomeArquivo) {
        this.nomeArquivo = nomeArquivo;
    }

    public int getTempoDeVidaLog() {
        return tempoDeVidaLog;
    }

    public void setTempoDeVidaLog(int tempoDeVidaLog) {
        this.tempoDeVidaLog = tempoDeVidaLog;
    }

    public int getTamanhoMaximoLog() {
        return tamanhoMaximoLog;
    }

    public void setTamanhoMaximoLog(int tamanhoMaximoLog) {
        this.tamanhoMaximoLog = tamanhoMaximoLog;
    }

    @Override
    public void configurarParametros(HashMap parametros) {

    }
}
