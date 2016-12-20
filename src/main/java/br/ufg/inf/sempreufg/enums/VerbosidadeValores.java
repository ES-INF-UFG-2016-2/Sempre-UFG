package br.ufg.inf.sempreufg.enums;

/**
 * Created by DYEGO-VOSTRO on 28/11/2016.
 */
public enum VerbosidadeValores {

    TERSE, DEFAULT, VERBOSE;
	
	public static boolean contains(String test) {
        for (VerbosidadeValores valor : VerbosidadeValores.values()) {
            if (valor.name().equals(test)) {
                return true;
            }
        }

        return false;
    }


}
