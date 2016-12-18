package br.ufg.inf.sempreufg.servico;

import br.ufg.inf.sempreufg.modelo.Atributo;
import br.ufg.inf.sempreufg.modelo.Entidade;
import br.ufg.inf.sempreufg.db.ConfiguraAtualizacaoEgressoDbTeste;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertFalse;

public class ConfiguraAtualizacaoEgressoTest {

    private ConfiguraAtualizacaoEgresso configuraAtualizacaoEgresso;
    private ConfiguraAtualizacaoEgressoDbTeste configuraAtualizacaoEgressoDbTeste;

    @Before
    public void startUp(){
        configuraAtualizacaoEgressoDbTeste = new ConfiguraAtualizacaoEgressoDbTeste();
        configuraAtualizacaoEgresso = new ConfiguraAtualizacaoEgresso();
    }

    @Test
    public void testeGetConfiguracoesAtualizacaoEgresso(){
        List<Entidade> entidadesGravadas = configuraAtualizacaoEgressoDbTeste.populaBancoDeDadosParaTeste();
        List<Entidade> entidadesBuscadas = configuraAtualizacaoEgresso.getConfiguracoesAtualizacaoEgresso();
        Assert.assertTrue(EqualsBuilder.reflectionEquals(
            entidadesGravadas,entidadesBuscadas));
    }

    @Test
    public void testeSalvaConfiguracoesAtualizacaoEgresso(){
        configuraAtualizacaoEgressoDbTeste.limpaDadosBD();
        List<Entidade> entidadesGravadas = criaEntidadesFicticia();
        configuraAtualizacaoEgresso.setEntidades(entidadesGravadas);
        configuraAtualizacaoEgresso.gravarConfiguracoesAtualizacaoEgresso();
        List<Entidade> entidadesBuscadas = configuraAtualizacaoEgresso.getConfiguracoesAtualizacaoEgresso();
        Assert.assertTrue(EqualsBuilder.reflectionEquals(
            entidadesGravadas,entidadesBuscadas));
    }

    @Test
    public void testeAlteararConfiguracoesAtualizacaoEgresso(){
        List<Entidade> entidadesGravar = configuraAtualizacaoEgressoDbTeste.populaBancoDeDadosParaTeste();
        configuraAtualizacaoEgressoDbTeste.limpaDadosBD();
        configuraAtualizacaoEgresso.setEntidades(entidadesGravar);
        configuraAtualizacaoEgresso.gravarConfiguracoesAtualizacaoEgresso();
        List<Entidade> entidadesAlterar = criaEntidadesFicticia();
        configuraAtualizacaoEgresso.setEntidades(entidadesAlterar);
        configuraAtualizacaoEgresso.alterarConfiguracoesAtualizacaoEgresso();
        List<Entidade> entidadesGravada = configuraAtualizacaoEgresso.getConfiguracoesAtualizacaoEgresso();
        Assert.assertTrue(EqualsBuilder.reflectionEquals(
            entidadesAlterar,entidadesGravada));
    }

    @Test
    public void testeRemoverConfiguracoesAtualizacaoEgresso(){
        configuraAtualizacaoEgressoDbTeste.populaBancoDeDadosParaTeste();
        configuraAtualizacaoEgresso.removeConfiguracoesAtualizacaoEgresso();
        assertFalse(configuraAtualizacaoEgressoDbTeste.existeDadosNaTabela("entidade"));
        assertFalse(configuraAtualizacaoEgressoDbTeste.existeDadosNaTabela("atributo"));
        assertFalse(configuraAtualizacaoEgressoDbTeste.existeDadosNaTabela("atributo_desvia_para_atributo"));
        assertFalse(configuraAtualizacaoEgressoDbTeste.existeDadosNaTabela("atributos_contidos_por_entidades"));
    }

    private List<Entidade> criaEntidadesFicticia(){
        List<Entidade> entidades = new ArrayList<>();
        List<String> informacoesEntidade = new ArrayList<>();

        informacoesEntidade.add("1");
        informacoesEntidade.add("Egresso");
        Entidade entidade1 = criaEntidadeFicticia(informacoesEntidade,null,criaAtributosFicticiosTipo1());
        entidades.add(entidade1);

        informacoesEntidade = new ArrayList<>();
        informacoesEntidade.add("2");
        informacoesEntidade.add("Usuario");
        Entidade entidade2 = criaEntidadeFicticia(informacoesEntidade,entidade1,criaAtributosFicticiosTipo2());
        entidades.add(entidade2);

        informacoesEntidade = new ArrayList<>();
        informacoesEntidade.add("3");
        informacoesEntidade.add("Atuacao");
        Entidade entidade3 = criaEntidadeFicticia(informacoesEntidade,entidade2,criaAtributosFicticiosTipo3());
        entidades.add(entidade3);

        return entidades;
    }

    private List<Atributo> criaAtributosFicticiosTipo1(){
        List<String> parametros = new ArrayList<>();
        parametros.add("1");
        parametros.add("Nome");
        parametros.add("");
        parametros.add("2");
        parametros.add("Nome da Mae");
        parametros.add("");
        parametros.add("3");
        parametros.add("Data de Nascimento");
        parametros.add("Teste 1");
        return criaListaAtributosFicticos(parametros);
    }

    private List<Atributo> criaAtributosFicticiosTipo2(){
        List<String> parametros = new ArrayList<>();
        parametros.add("4");
        parametros.add("Email");
        parametros.add("");
        parametros.add("5");
        parametros.add("Nome Usuario");
        parametros.add("");
        parametros.add("6");
        parametros.add("CPF");
        parametros.add("Teste 2");
        return criaListaAtributosFicticos(parametros);
    }

    private List<Atributo> criaAtributosFicticiosTipo3(){
        List<String> parametros = new ArrayList<>();
        parametros.add("7");
        parametros.add("Data Inicio");
        parametros.add("");
        parametros.add("8");
        parametros.add("Data Dim");
        parametros.add("");
        parametros.add("9");
        parametros.add("Forma Ingresso");
        parametros.add("Teste 3");
        return criaListaAtributosFicticos(parametros);
    }

    private List<Atributo> criaListaAtributosFicticos(List<String> parametros){
        List<Atributo> atributos = new ArrayList<>();
        List<String> informacoesAtributos = new ArrayList<>();
        int i=0;

        informacoesAtributos.add(parametros.get(i++));
        informacoesAtributos.add(parametros.get(i++));
        informacoesAtributos.add(parametros.get(i++));
        Atributo atributo1 = criaAtributoFicticio(informacoesAtributos,null,null);

        informacoesAtributos = new ArrayList<>();
        informacoesAtributos.add(parametros.get(i++));
        informacoesAtributos.add(parametros.get(i++));
        informacoesAtributos.add(parametros.get(i++));
        Atributo atributo2 = criaAtributoFicticio(informacoesAtributos,atributo1,null);

        informacoesAtributos = new ArrayList<>();
        informacoesAtributos.add(parametros.get(i++));
        informacoesAtributos.add(parametros.get(i++));
        informacoesAtributos.add(parametros.get(i++));
        Atributo atributo3 = criaAtributoFicticio(informacoesAtributos,atributo2,atributo1);

        atributos.add(atributo1);
        atributos.add(atributo2);
        atributos.add(atributo3);

        return atributos;
    }

    private Entidade criaEntidadeFicticia(List<String> informacoesEntidade,
                                          Entidade entidadeAntecedente, List<Atributo> atributos){
        Entidade entidade = new Entidade();
        int i = 0;
        entidade.setId(informacoesEntidade.get(i++));
        entidade.setNomeDaEntidade(informacoesEntidade.get(i));
        entidade.setTituloDoGrupoDeQuestoes(informacoesEntidade.get(i));
        entidade.setTituloDoGrupoDeCampos(informacoesEntidade.get(i));
        entidade.setEntidadeAntecedente(entidadeAntecedente);
        entidade.setAtributos(atributos);
        return entidade;
    }

    private Atributo criaAtributoFicticio(List<String> informacoesAtributo,
                                          Atributo atributoAntecedente, Atributo desviaPara){
        Atributo atributo = new Atributo();
        int i=0;
        atributo.setId(informacoesAtributo.get(i++));
        atributo.setNomeDoAtributo(informacoesAtributo.get(i));
        atributo.setTituloDoCampo(informacoesAtributo.get(i));
        atributo.setTituloDaQuestao(informacoesAtributo.get(i++));
        atributo.setValorAtributoDeOrigem(informacoesAtributo.get(i));
        atributo.setAtributoAntecedente(atributoAntecedente);
        atributo.setDesviaPara(desviaPara);
        return atributo;
    }
}
