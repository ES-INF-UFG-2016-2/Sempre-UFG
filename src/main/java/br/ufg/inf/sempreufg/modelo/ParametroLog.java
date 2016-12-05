package br.ufg.inf.sempreufg.modelo;

import br.ufg.inf.sempreufg.enums.TipoParametros;
import br.ufg.inf.sempreufg.interfaces.Parametro;

/**
 * Created by HP-Dyego_ENG on 05/12/2016.
 */
public class ParametroLog implements Parametro
{
    String sigla;
    TipoParametros tipo;
    String descricaoParametro;
    String valor;
    
    

    public String getSigla() {
        return sigla;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
    }

    public TipoParametros getTipo() {
        return tipo;
    }

    public void setTipo(TipoParametros tipo) {
        this.tipo = tipo;
    }

    public String getDescricaoParametro() {
        return descricaoParametro;
    }

    public void setDescricaoParametro(String descricaoParametro) {
        this.descricaoParametro = descricaoParametro;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }
}
