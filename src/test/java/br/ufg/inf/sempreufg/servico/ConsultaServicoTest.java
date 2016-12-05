package br.ufg.inf.sempreufg.servico;

import br.ufg.inf.sempreufg.interfaces.ConsultaServicoInterface;
import br.ufg.inf.sempreufg.excecoes.ErroNaConsultaException;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class ConsultaServicoTest {

    ConsultaServicoInterface consultaServico = new ConsultaServico();

    @Test
    public void testaExecutarConsultaComSucesso() throws ErroNaConsultaException {

        List<String> atributos = new ArrayList<String>() {{
            add("dissertação");
            add("atributo_teste");
            add("C");
        }};
        consultaServico.executaConsultaDeEgressosAdHoc(atributos, "where teste");
    }


}
