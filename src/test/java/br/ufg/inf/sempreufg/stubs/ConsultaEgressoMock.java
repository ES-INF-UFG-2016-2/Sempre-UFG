package br.ufg.inf.sempreufg.stubs;

import br.ufg.inf.sempreufg.excecoes.ColunaInexistenteException;
import br.ufg.inf.sempreufg.excecoes.ErroNaConsultaException;
import br.ufg.inf.sempreufg.excecoes.IdentificadorInexistenteExepction;
import br.ufg.inf.sempreufg.excecoes.ParametrosErradosException;
import br.ufg.inf.sempreufg.interfaces.ConsultaEgressoInterface;

import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;

public class ConsultaEgressoMock implements ConsultaEgressoInterface {
    private Date ultimaConsulta;

    public LinkedHashMap<String, String> executaConsultaDeEgressosPredefinida(int identificador, LinkedHashMap<String, String> parametros) throws ErroNaConsultaException {

        LinkedHashMap<String, String> resultado = new LinkedHashMap<String, String>();


        switch (identificador) {
            case 1:
                return resultadoDesejadoParaConsultaDeEgressoPredefinidaSemParametrosComSucesso(resultado);
            case 2:
                return resultadoDesejadoParaConsultaDeEgressoPredefinidaComParametrosMultiplosComSucesso(resultado);
            case 3:
                return resultadoParaConsultaDeEgressoPredefinidaComIdentificadorInexistente(resultado, 2);
            case 4:
                return resultadoDesejadoParaConsultaDeEgressoPredefinidaComErroNaConsulta(resultado, 3);
            case 5:
                return resultadoParaConsultaDeEgressoPredefinidaComParametrosIncompativeis(resultado);
            default:
                return null;
        }
    }

    @Override
    public LinkedHashMap<String, String> executaConsultaDeEgressosAdHoc(List<String> colunasABuscar, LinkedHashMap<String, String> parametros) throws ErroNaConsultaException {

        if (colunasABuscar.contains("TESTE")) {
            throw new ColunaInexistenteException("COLUNA INEXISTENTE NO BANCO");
        } else if (parametros == null) {
            return resultadoDesejadoParaConsultaDeEgressoAdHocSemParametrosComSucesso();
        } else if (parametros.containsKey("SEXO") && parametros.get("SEXO").equals("1990")) {
            throw new ParametrosErradosException("EXISTEM PARÂMETROS INCOMPATÍVEIS NA CONSULTA");
        } else
            return resultadoDesejadoParaConsultaDeEgressoAdHocComParametrosComSucesso();

    }


    public void atualizaDataUltimaConsulta(int identificadorConsulta) {
        ultimaConsulta = new Date();
    }

    public Date getUltimaConsulta() {
        return ultimaConsulta;
    }

    public void setUltimaConsulta(Date ultimaConsulta) {
        this.ultimaConsulta = ultimaConsulta;
    }

    private LinkedHashMap<String, String> resultadoDesejadoParaConsultaDeEgressoPredefinidaSemParametrosComSucesso(LinkedHashMap<String, String> resultado) {
        resultado.put("NOME", "MARIA EDUARDA;JOAO PEDRO;HELENA PEREIRA");
        resultado.put("DATANASCIMENTO", "01/01/1996;10/03/1994;05/09/1990");
        resultado.put("CURSO", "MEDICINA;PEDAGOGIA;ENGENHARIA DE PETROLEO");
        atualizaDataUltimaConsulta(1);
        return resultado;
    }

    private LinkedHashMap<String, String> resultadoDesejadoParaConsultaDeEgressoPredefinidaComParametrosMultiplosComSucesso(LinkedHashMap<String, String> resultado) {
        resultado.put("NOME", "MARIA EDUARDA");
        resultado.put("DATANASCIMENTO", "01/01/1996");
        setUltimaConsulta(new Date());
        return resultado;
    }

    private LinkedHashMap<String, String> resultadoParaConsultaDeEgressoPredefinidaComIdentificadorInexistente(LinkedHashMap<String, String> resultado, int identificador) throws IdentificadorInexistenteExepction {
        throw new IdentificadorInexistenteExepction("IDENTIFICADOR INEXISTENTE: " + identificador);
    }

    private LinkedHashMap<String, String> resultadoParaConsultaDeEgressoPredefinidaComParametrosIncompativeis(LinkedHashMap<String, String> resultado) throws ParametrosErradosException {
        throw new ParametrosErradosException("EXISTEM PARÂMETROS INCOMPATÍVEIS NA CONSULTA.");
    }

    private LinkedHashMap<String, String> resultadoDesejadoParaConsultaDeEgressoPredefinidaComErroNaConsulta(LinkedHashMap<String, String> resultado, int identificador) throws ErroNaConsultaException {
        throw new ErroNaConsultaException("ERRO AO EXECUTAR A CONSULTA.");
    }

    private LinkedHashMap<String, String> resultadoDesejadoParaConsultaDeEgressoAdHocSemParametrosComSucesso() {
        LinkedHashMap<String, String> resultado = new LinkedHashMap<String, String>();
        resultado.put("NOME", "MARIA EDUARDA;JOAO PEDRO;HELENA PEREIRA");
        resultado.put("DATANASCIMENTO", "01/01/1996;10/03/1994;05/09/1990");
        resultado.put("CURSO", "MEDICINA;PEDAGOGIA;ENGENHARIA DE PETROLEO");
        return resultado;
    }

    private LinkedHashMap<String, String> resultadoDesejadoParaConsultaDeEgressoAdHocComParametrosComSucesso() {
        LinkedHashMap<String, String> resultado = new LinkedHashMap<String, String>();
        resultado.put("NOME", "MARIA EDUARDA");
        resultado.put("DATANASCIMENTO", "01/01/1996");
        return resultado;
    }

}
