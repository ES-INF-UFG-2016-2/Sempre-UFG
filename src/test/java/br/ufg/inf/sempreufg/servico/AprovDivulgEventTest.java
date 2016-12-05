package br.ufg.inf.sempreufg.servico;

import br.ufg.inf.sempreufg.interfaces.AprovDivulgEventInterface;
import br.ufg.inf.sempreufg.modelo.AprovDivulgEvent;

import static org.junit.Assert.*;

import org.junit.Test;

public class AprovDivulgEventTest {

    private static int id_valido = 42; // 0 a 49
    private static boolean aprovada = true;
    private static AprovDivulgEventInterface avaliacao;

    @Test
    public void testDivulgacaoAprovada() {

        assertTrue(new AprovDivulgEvent(id_valido, aprovada)
            .getResultado() == "Evento divulgado aos egressos.");
    }

    @Test
    public void testDivulgacaoRejeitada() {

        assertTrue(new AprovDivulgEvent(id_valido, false)
            .getResultado() == "Parecer encaminhado ao gestor e ao solicitante.");
    }

    @Test
    public void testIdInvalido() {

        assertTrue(new AprovDivulgEvent(50, aprovada)
            .getResultado() == "Nao existe evento com id correspondente.");
    }

    @Test
    public void testIdNegativo() {

        assertTrue(new AprovDivulgEvent(-1, aprovada)
            .getResultado() == "Id nao pode ser menor que 1.");
    }

    @Test
    public void testIdZero() {

        assertTrue(new AprovDivulgEvent(0, aprovada)
            .getResultado() == "Id nao pode ser menor que 1.");
    }
}
