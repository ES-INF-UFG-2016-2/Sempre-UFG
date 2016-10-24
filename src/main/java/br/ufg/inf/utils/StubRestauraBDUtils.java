package br.ufg.inf.utils;

import java.time.Period;

public class StubRestauraBDUtils {
    //Arquivo referenciado pelos testes de backup criado por DYEGO-VOSTRO
    public static final String CAMINHO_TEST_VALIDO = System.getProperty("user.home");//user.home sempre um caminho "Local" válido.
    public static final Period TEMPO_TEST_PERIODICIDADE_ZERO = Period.ofDays(0);
    public static final Period TEMPO_TEST_PERIODICIDADE_NEGATIVA = Period.ofDays(-1);
    public static final Period TEMPO_TEST_PERIODICIDADE_NULO = null;
    public static final String CAMINHO_TEST_CAMINHO = "&6@#$|//\\?";
    public static final String CAMINHO_TEST_CAMINHO_NULO = null;
    public static final String CAMINHO_TEST_CAMINHO_COM_ESPACO = " " + CAMINHO_TEST_VALIDO;

    public static final Period TEMPO_VALIDO = Period.ofDays(1);
    
    //Adicionado parametros para a execução de teste Restaura BD
    public static final String DATA_NULO = null;
    public static final String DATA_SUPERIOR_ATUAL = "30/01/2017";
    public static final String DATA_INEXISTENTE = "30/02/2016";
    public static final String DATA_VALIDA = "15/10/2016";
    public static final String DATA_VINCULADA_AO_BACKUP = DATA_VALIDA;
}
