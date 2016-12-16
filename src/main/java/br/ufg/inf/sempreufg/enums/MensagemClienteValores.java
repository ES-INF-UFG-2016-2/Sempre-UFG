package br.ufg.inf.sempreufg.enums;

/**
 * Created by DYEGO-VOSTRO on 28/11/2016.
 */
public enum MensagemClienteValores{
    DEBUG5, DEBUG4, DEBUG3, DEBUG2, DEBUG1, LOG, NOTICE, WARNNING, ERROR, FATAL, PANIC;

    public static boolean contains(String test) {

        for (MensagemClienteValores valor : MensagemClienteValores.values()) {
            if (valor.name().equals(test)) {
                return true;
            }
        }

        return false;
    }
}
