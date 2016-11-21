package br.ufg.inf;

import br.ufg.inf.dao.AprovacaoDivulgacaoEventoDAO;
import br.ufg.inf.modelo.*;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class RespAprovDivulgEventTest {

    private static Responsavel responsavel;
    private static Evento evento ;
    private static AprovacaoDivulgacaoEvento aprovacaoDivulgacaoEventoResponsavel;
    private static AprovacaoDivulgacaoEvento aprovacaoDivulgacaoEventoUsuario;
    private static AprovacaoDivulgacaoEventoDAO aprovacaoDivulgacaoEventoDAO;
    private static Usuario usuario;

    private static Date date;

    @BeforeClass
    public static void init(){
        date = new Date();

        List listResponsaveis = new ArrayList();
        listResponsaveis.add("Usuario Responsavel");

        Usuario usuario = new Usuario();

        Responsavel responsavel = new Responsavel(listResponsaveis);

        evento = new Evento(1, "teste de divulgação", "teste", date, 1, date,
            "teste", "teste", "teste");

        aprovacaoDivulgacaoEventoResponsavel = new AprovacaoDivulgacaoEvento(
            evento, responsavel, true, "Teste", date);

        aprovacaoDivulgacaoEventoUsuario = new AprovacaoDivulgacaoEvento(
            evento, usuario, false, "Teste", date);

        aprovacaoDivulgacaoEventoDAO = new AprovacaoDivulgacaoEventoDAO();
    }


    @Test
    public void testeEventoAprovadoComResponsavel() {
        aprovacaoDivulgacaoEventoDAO.salvar(aprovacaoDivulgacaoEventoResponsavel);
        assertTrue(
            aprovacaoDivulgacaoEventoDAO.obtemStatusAprovacaoEvento());
    }

    @Test
    public void testeEventoAprovadoComUsuarioNormal() {
        aprovacaoDivulgacaoEventoDAO.salvar(aprovacaoDivulgacaoEventoUsuario);
        assertFalse(
            aprovacaoDivulgacaoEventoDAO.obtemStatusAprovacaoEvento());
    }
}
