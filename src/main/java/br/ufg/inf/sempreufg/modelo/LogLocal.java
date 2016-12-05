package br.ufg.inf.sempreufg.modelo;

import br.ufg.inf.sempreufg.enums.ComandoSQL;
import br.ufg.inf.sempreufg.enums.MensagemClienteValores;
import br.ufg.inf.sempreufg.enums.MensagemValores;
import br.ufg.inf.sempreufg.enums.NivelMensagensCliente;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

/**
 * Created by DYEGO-VOSTRO on 28/11/2016.
 */
public class LogLocal implements LogConfigItem
{

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
    public void configurarParametros(ArrayList<ParametroLog> parametros)
    {
        Iterator<ParametroLog> iterador = parametros.iterator();

        while(iterador.hasNext() )
        {
            ParametroLog param = iterador.next();

            for(MensagemClienteValores valor : MensagemClienteValores.values() )
            {
                System.out.println("Testando: " + valor.name() );
                if(valor.name().equals(param.getValor() ) )
                {
                    System.out.println("É um valor válido");
                }
            }


        }
    }

}
