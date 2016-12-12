package br.ufg.inf.sempreufg.stubs;

import br.ufg.inf.sempreufg.excecoes.IdentificadorInexistenteExepction;
import br.ufg.inf.sempreufg.excecoes.ParametrosErradosException;
import br.ufg.inf.sempreufg.modelo.Consulta;
import java.util.ArrayList;
import java.util.List;


public class ConsultaServiceStub {
    private Consulta consultaValida, consultaAlterada, consultaIndice;
    
    public ConsultaServiceStub(){
        consultaValida = new Consulta();
        consultaValida.setIdentificador("1");
        consultaValida.setPublica(false);
        List<String> atributos = new ArrayList<>();
        atributos.add("Egresso.sexo");
        atributos.add("Egresso.Residência.LocalizaçãoGeográfica.Nomedacidade");
        atributos.add("(Egresso.Residência.DatadeFim");
        String expressao = "(Egresso.sexo = “feminino”) E (Egresso.Residência.LocalizaçãoGeográfica.Nomedacidade = “Goiânia”) E\n" +
"(Egresso.Residência.DatadeFim = Nulo)";
        consultaValida.setAtributos(atributos);
        consultaValida.setExpressao(expressao);
        
        consultaAlterada = new Consulta();
        consultaAlterada.setIdentificador("2");
        consultaAlterada.setPublica(false);
        consultaAlterada.setAtributos(atributos);
        expressao = "(Egresso.sexo = “masculino”) E (Egresso.Residência.LocalizaçãoGeográfica.Nomedacidade = “Goiânia”) E\n" +
"(Egresso.Residência.DatadeFim = Nulo)";
        consultaAlterada.setExpressao(expressao);
        
        consultaIndice = new Consulta();
        consultaIndice.setIdentificador("3");
        consultaIndice.setAtributos(atributos);
        consultaIndice.setPublica(false);
        consultaIndice.setExpressao(expressao);
    }
    
    public Consulta salvaConsulta(String identificador, Boolean publica, List<String> atributos, String expressao) throws ParametrosErradosException{
        if(identificador == null || publica == null || atributos == null || expressao == null){
            throw new ParametrosErradosException("Parametros Invalidos");
        }else{
            return consultaValida;
        }
    }
    
    public Consulta obtenhaConsultaPeloIdentificador(String identificador) throws IdentificadorInexistenteExepction, ParametrosErradosException{
        if("100".equals(identificador)){
            throw new IdentificadorInexistenteExepction("Identificador 100 não existe");
        }
        if(identificador == null){
            throw new ParametrosErradosException("Parametros Invalidos");
        }
        if("4".equals(identificador)){
            return null;
        }
        return consultaIndice;
    }
    
    public Consulta atualizaConsulta(String identificadorAntigo, String identificadorNovo, Boolean publica, List<String> atributos, String expressao) throws ParametrosErradosException, IdentificadorInexistenteExepction{
        if(identificadorAntigo == null || identificadorNovo == null || publica == null || atributos == null || expressao == null){
            throw new ParametrosErradosException("Parametros Invalidos");
        }
        if("100".equals(identificadorAntigo)){
            throw new IdentificadorInexistenteExepction("Identificador 100 não existe");
        }
        return consultaAlterada;
    }
    
    public void removeConsulta(String identificador) throws ParametrosErradosException, IdentificadorInexistenteExepction{
        if(identificador == null){
            throw new ParametrosErradosException("Parametros Invalidos");
        }
        if("100".equals(identificador)){
            throw new IdentificadorInexistenteExepction("Identificador 100 não existe");
        }
    }
}
