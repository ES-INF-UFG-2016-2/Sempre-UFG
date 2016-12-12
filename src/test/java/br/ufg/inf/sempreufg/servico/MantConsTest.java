package br.ufg.inf.sempreufg.servico;

import br.ufg.inf.sempreufg.excecoes.IdentificadorInexistenteExepction;
import br.ufg.inf.sempreufg.excecoes.ParametrosErradosException;
import br.ufg.inf.sempreufg.modelo.Consulta;
import br.ufg.inf.sempreufg.stubs.ConsultaServiceStub;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.After;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

/**
 *
 * @author Kalyn
 */
public class MantConsTest {

    private Consulta consultaValida, consultaAlterada, consultaIndice;

    @Before
    public void beforeMethod() throws ParametrosErradosException {
        consultaValida = new Consulta();
        consultaValida.setIdentificador("1");
        consultaValida.setPublica(false);
        List<String> atributos = new ArrayList<>();
        atributos.add("Egresso.sexo");
        atributos.add("Egresso.Residência.LocalizaçãoGeográfica.Nomedacidade");
        atributos.add("(Egresso.Residência.DatadeFim");
        String expressao = "(Egresso.sexo = “feminino”) E (Egresso.Residência.LocalizaçãoGeográfica.Nomedacidade = “Goiânia”) E\n"
                + "(Egresso.Residência.DatadeFim = Nulo)";
        consultaValida.setAtributos(atributos);
        consultaValida.setExpressao(expressao);

        ConsultaServiceStub consultaService = new ConsultaServiceStub();

        consultaAlterada = new Consulta();
        consultaAlterada.setIdentificador("2");
        consultaAlterada.setPublica(false);
        consultaAlterada.setAtributos(atributos);
        expressao = "(Egresso.sexo = “masculino”) E (Egresso.Residência.LocalizaçãoGeográfica.Nomedacidade = “Goiânia”) E\n"
                + "(Egresso.Residência.DatadeFim = Nulo)";
        consultaAlterada.setExpressao(expressao);
        consultaService.salvaConsulta("2", true, atributos, expressao);

        consultaIndice = new Consulta();
        consultaIndice.setIdentificador("3");
        consultaIndice.setAtributos(atributos);
        consultaIndice.setPublica(false);
        consultaIndice.setExpressao(expressao);
        consultaService.salvaConsulta("3", false, atributos, expressao);

        consultaService.salvaConsulta("4", true, atributos, expressao);
    }

    @After
    public void afterMethod() {
        ConsultaServiceStub consultaService = new ConsultaServiceStub();
        for (int i = 1; i < 8; i++) {
            try {
                consultaService.removeConsulta(Integer.toString(i));
            } catch (ParametrosErradosException | IdentificadorInexistenteExepction ex) {
                Logger.getLogger(MantConsTest.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @Test
    public void testSalvaConsulta() throws ParametrosErradosException {
        String identificador = "1";
        Boolean publica = false;
        List<String> atributos = new ArrayList<>();
        atributos.add("Egresso.sexo");
        atributos.add("Egresso.Residência.LocalizaçãoGeográfica.Nomedacidade");
        atributos.add("(Egresso.Residência.DatadeFim");
        String expressao = "(Egresso.sexo = “feminino”) E (Egresso.Residência.LocalizaçãoGeográfica.Nomedacidade = “Goiânia”) E\n"
                + "(Egresso.Residência.DatadeFim = Nulo)";
        ConsultaServiceStub instance = new ConsultaServiceStub();
        Consulta result = instance.salvaConsulta(identificador, publica, atributos, expressao);
        assertEquals(consultaValida, result);
    }

    @Test
    public void testObtenhaConsultaPeloIdentificador() throws IdentificadorInexistenteExepction, ParametrosErradosException {
        String identificador = "3";
        ConsultaServiceStub instance = new ConsultaServiceStub();
        Consulta result = instance.obtenhaConsultaPeloIdentificador(identificador);
        assertEquals(consultaIndice, result);
    }

    @Test
    public void testAtualizaConsulta() throws ParametrosErradosException, IdentificadorInexistenteExepction {
        String identificadorAntigo = "2";
        String identificadorNovo = "2";
        Boolean publica = false;
        List<String> atributos = new ArrayList<>();
        atributos.add("Egresso.sexo");
        atributos.add("Egresso.Residência.LocalizaçãoGeográfica.Nomedacidade");
        atributos.add("(Egresso.Residência.DatadeFim");
        String expressao = "(Egresso.sexo = “masculino”) E (Egresso.Residência.LocalizaçãoGeográfica.Nomedacidade = “Goiânia”) E\n"
                + "(Egresso.Residência.DatadeFim = Nulo)";
        ConsultaServiceStub instance = new ConsultaServiceStub();
        Consulta result = instance.atualizaConsulta(identificadorAntigo, identificadorNovo, publica, atributos, expressao);
        assertEquals(consultaAlterada, result);
    }

    @Test
    public void testRemoveConsulta() throws ParametrosErradosException, IdentificadorInexistenteExepction {
        String identificador = "4";
        ConsultaServiceStub instance = new ConsultaServiceStub();
        instance.removeConsulta(identificador);
        assertNull(instance.obtenhaConsultaPeloIdentificador(identificador));
    }

    @Test(expected = ParametrosErradosException.class)
    public void testSalvarConsultaIdNulo() throws ParametrosErradosException {
        String identificador = null;
        Boolean publica = false;
        List<String> atributos = new ArrayList<>();
        atributos.add("Egresso.sexo");
        atributos.add("Egresso.Residência.LocalizaçãoGeográfica.Nomedacidade");
        atributos.add("(Egresso.Residência.DatadeFim");
        String expressao = "(Egresso.sexo = “feminino”) E (Egresso.Residência.LocalizaçãoGeográfica.Nomedacidade = “Goiânia”) E\n"
                + "(Egresso.Residência.DatadeFim = Nulo)";
        ConsultaServiceStub instance = new ConsultaServiceStub();
        instance.salvaConsulta(identificador, publica, atributos, expressao);
    }

    @Test(expected = ParametrosErradosException.class)
    public void testSalvarConsultaPublicaNulo() throws ParametrosErradosException {
        String identificador = "5";
        Boolean publica = null;
        List<String> atributos = new ArrayList<>();
        atributos.add("Egresso.sexo");
        atributos.add("Egresso.Residência.LocalizaçãoGeográfica.Nomedacidade");
        atributos.add("(Egresso.Residência.DatadeFim");
        String expressao = "(Egresso.sexo = “feminino”) E (Egresso.Residência.LocalizaçãoGeográfica.Nomedacidade = “Goiânia”) E\n"
                + "(Egresso.Residência.DatadeFim = Nulo)";
        ConsultaServiceStub instance = new ConsultaServiceStub();
        instance.salvaConsulta(identificador, publica, atributos, expressao);
    }

    @Test(expected = ParametrosErradosException.class)
    public void testSalvarConsultaAtributosNulo() throws ParametrosErradosException {
        String identificador = "6";
        Boolean publica = false;
        List<String> atributos = null;
        String expressao = "(Egresso.sexo = “feminino”) E (Egresso.Residência.LocalizaçãoGeográfica.Nomedacidade = “Goiânia”) E\n"
                + "(Egresso.Residência.DatadeFim = Nulo)";
        ConsultaServiceStub instance = new ConsultaServiceStub();
        instance.salvaConsulta(identificador, publica, atributos, expressao);
    }

    @Test(expected = ParametrosErradosException.class)
    public void testSalvarConsultaExpressaoNulo() throws ParametrosErradosException {
        String identificador = "7";
        Boolean publica = false;
        List<String> atributos = new ArrayList<>();
        atributos.add("Egresso.sexo");
        atributos.add("Egresso.Residência.LocalizaçãoGeográfica.Nomedacidade");
        atributos.add("(Egresso.Residência.DatadeFim");
        String expressao = null;
        ConsultaServiceStub instance = new ConsultaServiceStub();
        instance.salvaConsulta(identificador, publica, atributos, expressao);
    }

    @Test(expected = ParametrosErradosException.class)
    public void testAtualizaConsultaIdAntigoNulo() throws ParametrosErradosException, IdentificadorInexistenteExepction {
        String identificadorAntigo = null;
        String identificadorNovo = "2";
        Boolean publica = false;
        List<String> atributos = new ArrayList<>();
        atributos.add("Egresso.sexo");
        atributos.add("Egresso.Residência.LocalizaçãoGeográfica.Nomedacidade");
        atributos.add("(Egresso.Residência.DatadeFim");
        String expressao = "(Egresso.sexo = “masculino”) E (Egresso.Residência.LocalizaçãoGeográfica.Nomedacidade = “Goiânia”) E\n"
                + "(Egresso.Residência.DatadeFim = Nulo)";
        ConsultaServiceStub instance = new ConsultaServiceStub();
        instance.atualizaConsulta(identificadorAntigo, identificadorNovo, publica, atributos, expressao);
    }

    @Test(expected = ParametrosErradosException.class)
    public void testAtualizaConsultaIdNovoNulo() throws ParametrosErradosException, IdentificadorInexistenteExepction {
        String identificadorAntigo = "2";
        String identificadorNovo = null;
        Boolean publica = false;
        List<String> atributos = new ArrayList<>();
        atributos.add("Egresso.sexo");
        atributos.add("Egresso.Residência.LocalizaçãoGeográfica.Nomedacidade");
        atributos.add("(Egresso.Residência.DatadeFim");
        String expressao = "(Egresso.sexo = “masculino”) E (Egresso.Residência.LocalizaçãoGeográfica.Nomedacidade = “Goiânia”) E\n"
                + "(Egresso.Residência.DatadeFim = Nulo)";
        ConsultaServiceStub instance = new ConsultaServiceStub();
        instance.atualizaConsulta(identificadorAntigo, identificadorNovo, publica, atributos, expressao);
    }

    @Test(expected = ParametrosErradosException.class)
    public void testAtualizaConsultaPublicaNulo() throws ParametrosErradosException, IdentificadorInexistenteExepction {
        String identificadorAntigo = "2";
        String identificadorNovo = "2";
        Boolean publica = null;
        List<String> atributos = new ArrayList<>();
        atributos.add("Egresso.sexo");
        atributos.add("Egresso.Residência.LocalizaçãoGeográfica.Nomedacidade");
        atributos.add("(Egresso.Residência.DatadeFim");
        String expressao = "(Egresso.sexo = “masculino”) E (Egresso.Residência.LocalizaçãoGeográfica.Nomedacidade = “Goiânia”) E\n"
                + "(Egresso.Residência.DatadeFim = Nulo)";
        ConsultaServiceStub instance = new ConsultaServiceStub();
        instance.atualizaConsulta(identificadorAntigo, identificadorNovo, publica, atributos, expressao);
    }

    @Test(expected = ParametrosErradosException.class)
    public void testAtualizaConsultaAtributosNulo() throws ParametrosErradosException, IdentificadorInexistenteExepction {
        String identificadorAntigo = "2";
        String identificadorNovo = "2";
        Boolean publica = false;
        List<String> atributos = null;
        String expressao = "(Egresso.sexo = “masculino”) E (Egresso.Residência.LocalizaçãoGeográfica.Nomedacidade = “Goiânia”) E\n"
                + "(Egresso.Residência.DatadeFim = Nulo)";
        ConsultaServiceStub instance = new ConsultaServiceStub();
        instance.atualizaConsulta(identificadorAntigo, identificadorNovo, publica, atributos, expressao);
    }

    @Test(expected = ParametrosErradosException.class)
    public void testAtualizaConsultaExpressaoNulo() throws ParametrosErradosException, IdentificadorInexistenteExepction {
        String identificadorAntigo = "2";
        String identificadorNovo = "2";
        Boolean publica = false;
        List<String> atributos = new ArrayList<>();
        atributos.add("Egresso.sexo");
        atributos.add("Egresso.Residência.LocalizaçãoGeográfica.Nomedacidade");
        atributos.add("(Egresso.Residência.DatadeFim");
        String expressao = null;
        ConsultaServiceStub instance = new ConsultaServiceStub();
        instance.atualizaConsulta(identificadorAntigo, identificadorNovo, publica, atributos, expressao);
    }

    @Test(expected = ParametrosErradosException.class)
    public void testObtenhaConsultaPeloIdentificadorIdNulo() throws IdentificadorInexistenteExepction, ParametrosErradosException {
        String identificador = null;
        ConsultaServiceStub instance = new ConsultaServiceStub();
        instance.obtenhaConsultaPeloIdentificador(identificador);
    }

    @Test(expected = ParametrosErradosException.class)
    public void testRemoveConsultaIdNulo() throws ParametrosErradosException, IdentificadorInexistenteExepction {
        String identificador = null;
        ConsultaServiceStub instance = new ConsultaServiceStub();
        instance.removeConsulta(identificador);
    }

    @Test(expected = IdentificadorInexistenteExepction.class)
    public void testAtualizaConsultaIdAntigoInexistente() throws ParametrosErradosException, IdentificadorInexistenteExepction {
        String identificadorAntigo = "100";
        String identificadorNovo = "100";
        Boolean publica = false;
        List<String> atributos = new ArrayList<>();
        atributos.add("Egresso.sexo");
        atributos.add("Egresso.Residência.LocalizaçãoGeográfica.Nomedacidade");
        atributos.add("(Egresso.Residência.DatadeFim");
        String expressao = "(Egresso.sexo = “masculino”) E (Egresso.Residência.LocalizaçãoGeográfica.Nomedacidade = “Goiânia”) E\n"
                + "(Egresso.Residência.DatadeFim = Nulo)";
        ConsultaServiceStub instance = new ConsultaServiceStub();
        instance.atualizaConsulta(identificadorAntigo, identificadorNovo, publica, atributos, expressao);
    }

    @Test(expected = IdentificadorInexistenteExepction.class)
    public void testObtenhaConsultaPeloIdentificadorIdInexistente() throws IdentificadorInexistenteExepction, ParametrosErradosException {
        String identificador = "100";
        ConsultaServiceStub instance = new ConsultaServiceStub();
        instance.obtenhaConsultaPeloIdentificador(identificador);
    }

    @Test(expected = IdentificadorInexistenteExepction.class)
    public void testRemoveConsultaIdInexistente() throws ParametrosErradosException, IdentificadorInexistenteExepction {
        String identificador = "100";
        ConsultaServiceStub instance = new ConsultaServiceStub();
        instance.removeConsulta(identificador);
    }

}
