package br.ufg.inf.sempreufg.servico;

import org.junit.BeforeClass;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class MontadorSQLTest {

    private static MontadorSQL montadorSQL;

    @BeforeClass
    public static void setup() {
        montadorSQL = new MontadorSQL();
    }

    @Test
    public void testMontarConsultaComSucesso() {
        List<String> atributos = getAtributosParaTeste();
        String clausulaWhere = "WHERE teste";
        String consultaObtida = montadorSQL.montarConsulta(atributos, clausulaWhere);

        String consultaEsperada ="SELECT A, B, C FROM TABLE " + clausulaWhere;
        assertEquals(consultaEsperada, consultaObtida);
    }

    private List<String> getAtributosParaTeste() {
        return new ArrayList<String>() {{
            add("A");
            add("B");
            add("C");
        }};
    }

}
