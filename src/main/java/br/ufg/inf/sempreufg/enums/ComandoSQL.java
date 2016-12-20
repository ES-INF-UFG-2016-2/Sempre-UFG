package br.ufg.inf.sempreufg.enums;

/**
 * Created by DYEGO-VOSTRO on 28/11/2016.
 */
public enum ComandoSQL {
    NONE, DDL, MOD, ALL;
	
	public static boolean contains(String test) {

        for (MensagemClienteValores valor : MensagemClienteValores.values()) {
            if (valor.name().equals(test)) {
                return true;
            }
        }

        return false;
    }
}
