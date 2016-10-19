package main.java.br.ufg.inf.utils;

import java.time.Period;

/**
 * Created by DYEGO-VOSTRO on 19/10/2016.
 */
public class StubBackupUtils {
    public static final String CAMINHO_TEST_VALIDO = System.getProperty("user.home");//user.home sempre um caminho "Local" válido.
    public static final Period TEMPO_TEST_PERIODICIDADE_ZERO = Period.ofDays(0);
    public static final Period TEMPO_TEST_PERIODICIDADE_NEGATIVA = Period.ofDays(-1);
    public static final Period TEMPO_TEST_PERIODICIDADE_NULO = null;
    public static final String CAMINHO_TEST_CAMINHO = "&6@#$|//\\?";
    public static final String CAMINHO_TEST_CAMINHO_NULO = null;
    public static final String CAMINHO_TEST_CAMINHO_COM_ESPACO = " " + CAMINHO_TEST_VALIDO;

    public static final Period TEMPO_VALIDO = Period.ofDays(1);

}
