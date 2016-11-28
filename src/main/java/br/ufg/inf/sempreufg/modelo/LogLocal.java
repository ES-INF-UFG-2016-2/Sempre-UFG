package br.ufg.inf.sempreufg.modelo;

import br.ufg.inf.sempreufg.enums.ComandoSQL;
import br.ufg.inf.sempreufg.enums.MensagemClienteValores;
import br.ufg.inf.sempreufg.enums.MensagemValores;
import br.ufg.inf.sempreufg.interfaces.LogConfigItem;

import java.util.HashMap;

/**
 * Created by DYEGO-VOSTRO on 28/11/2016.
 */
public class LogLocal implements LogConfigItem {

    private MensagemClienteValores nivelMensagemCliente;
    private MensagemValores nivelMensagemLog;
    private ComandoSQL tipoComandosSQL;
    private int duracaoComando;

    public MensagemClienteValores getNivelMensagemCliente() {
        return nivelMensagemCliente;
    }

    public void setNivelMensagemCliente(MensagemClienteValores nivelMensagemCliente) {
        this.nivelMensagemCliente = nivelMensagemCliente;
    }

    public MensagemValores getNivelMensagemLog() {
        return nivelMensagemLog;
    }

    public void setNivelMensagemLog(MensagemValores nivelMensagemLog) {
        this.nivelMensagemLog = nivelMensagemLog;
    }

    public ComandoSQL getTipoComandosSQL() {
        return tipoComandosSQL;
    }

    public void setTipoComandosSQL(ComandoSQL tipoComandosSQL) {
        this.tipoComandosSQL = tipoComandosSQL;
    }

    public int getDuracaoComando() {
        return duracaoComando;
    }

    public void setDuracaoComando(int duracaoComando) {
        this.duracaoComando = duracaoComando;
    }


    @Override
    public void configurarParametros(HashMap parametros) {

    }
}
