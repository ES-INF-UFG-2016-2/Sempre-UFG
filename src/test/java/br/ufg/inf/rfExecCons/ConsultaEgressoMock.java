package test.java.br.ufg.inf.rfExecCons;

import main.java.br.ufg.inf.consulta.IConsultaEgresso;
import main.java.br.ufg.inf.excecoes.ErroNaConsultaException;
import main.java.br.ufg.inf.excecoes.IdentificadorInexistenteExepction;
import main.java.br.ufg.inf.excecoes.ParametrosErradosException;

import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;

public class ConsultaEgressoMock implements IConsultaEgresso {
    private Date ultimaConsulta;

    public LinkedHashMap<String, String> executaConsultaDeEgressosPredefinida(int identificador, LinkedHashMap<String, String> parametros) throws ErroNaConsultaException {

        LinkedHashMap<String, String> resultado = new LinkedHashMap<String, String>();

        switch (identificador){
            case 1: return resultadoDesejadoParaConsultaDeEgressoPredefinidaSemParametrosComSucesso(resultado);
            case 2: return resultadoParaConsultaDeEgressoPredefinidaComIdentificadorInexistente(resultado, 2);
            case 3: return resultadoDesejadoParaConsultaDeEgressoPredefinidaComFalha(resultado, 3);
            case 4: return resultadoDesejadoParaConsultaDeEgressoPredefinidaComParametrosComSucesso(resultado);
            case 5: return resultadoDesejadoParaConsultaDeEgressoPredefinidaComParametrosComSucesso(resultado);
            case 6: return resultadoParaConsultaDeEgressoPredefinidaComParametrosIncompativeis(resultado);
            default: return null;
        }
    }


    public LinkedHashMap<String, String> executaConsultaDeEgressosAdHoc(LinkedHashMap<String, String> colunasABuscar, LinkedHashMap<String, String> parametros) {
        return null;
    }


    public void atualizaDataUltimaConsulta(int identificadorConsulta) {
        ultimaConsulta.setTime(System.currentTimeMillis());
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

        return resultado;
    }

    private LinkedHashMap<String, String> resultadoDesejadoParaConsultaDeEgressoPredefinidaComParametrosComSucesso(LinkedHashMap<String, String> resultado) {
        resultado.put("NOME", "MARIA EDUARDA");
        resultado.put("DATANASCIMENTO", "01/01/1996");

        return resultado;
    }

    private LinkedHashMap<String, String> resultadoParaConsultaDeEgressoPredefinidaComIdentificadorInexistente(LinkedHashMap<String, String> resultado, int identificador) throws IdentificadorInexistenteExepction {
        throw new IdentificadorInexistenteExepction("IDENTIFICADOR INEXISTENTE: " + identificador);
    }

    private LinkedHashMap<String, String> resultadoParaConsultaDeEgressoPredefinidaComParametrosIncompativeis(LinkedHashMap<String, String> resultado) throws ParametrosErradosException {
        throw new ParametrosErradosException("EXISTEM PARÂMETROS INCOMPATÍVEIS NA CONSULTA.");
    }

    private LinkedHashMap<String, String> resultadoDesejadoParaConsultaDeEgressoPredefinidaComFalha(LinkedHashMap<String, String> resultado, int identificador) throws ErroNaConsultaException {
        throw new ErroNaConsultaException("ERRO AO EXECUTAR A CONSULTA.");
    }
}
