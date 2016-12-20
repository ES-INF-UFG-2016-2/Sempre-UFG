package br.ufg.inf.sempreufg.servico;

import br.ufg.inf.sempreufg.dao.AtributoDAO;
import br.ufg.inf.sempreufg.dao.ConfiguraAtualizacaoEgressoDAO;
import br.ufg.inf.sempreufg.dao.EntidadeDAO;
import br.ufg.inf.sempreufg.modelo.Atributo;
import br.ufg.inf.sempreufg.modelo.Entidade;

import java.security.InvalidParameterException;
import java.util.*;

/**
 * Created by Marcos on 12/12/2016.
 */
public class ConfiguraAtualizacaoEgresso {

    private List<Entidade> entidades;
    private EntidadeDAO entidadeDAO;
    private AtributoDAO atributoDAO;
    private ConfiguraAtualizacaoEgressoDAO configuraAtualizacaoEgressoDAO;

    public ConfiguraAtualizacaoEgresso() {
        entidadeDAO = new EntidadeDAO();
        atributoDAO = new AtributoDAO();
        configuraAtualizacaoEgressoDAO = new ConfiguraAtualizacaoEgressoDAO();
    }

    public List<Entidade> getEntidades() {
        return entidades;
    }

    public void setEntidades(List<Entidade> entidades) {
        this.entidades = entidades;
    }

    public boolean gravarConfiguracoesAtualizacaoEgresso(){
        verificaIntegridadeDasEntidades();
        verificaContinuidadeDasEntidades();

        for (Entidade entidade : entidades) {
            for (Atributo atributo : entidade.getAtributos()) {
                if(atributoDAO.salvar(atributo) == null){
                    return false;
                }

                if(atributo.getDesviaPara() != null){
                    configuraAtualizacaoEgressoDAO.gravarAtributoDesviaParaAtributo(atributo);
                }
            }

            if(entidadeDAO.salvar(entidade) == null){
                return false;
            }

            for (Atributo atributo : entidade.getAtributos()) {
                configuraAtualizacaoEgressoDAO.gravarReferenciasAtributosEntidades(
                    entidade.getNome(),atributo.getNomeDoAtributo());
            }
        }
        return true;
    }

    public boolean alterarConfiguracoesAtualizacaoEgresso(){
        verificaIntegridadeDasEntidades();
        verificaContinuidadeDasEntidades();
        if(removeConfiguracoesAtualizacaoEgresso()){
            if(gravarConfiguracoesAtualizacaoEgresso()){
                return true;
            }
            return false;
        }
        return false;
    }

    public boolean removeConfiguracoesAtualizacaoEgresso(){
        if(!configuraAtualizacaoEgressoDAO.deletaAtributoDesviaParaAtributo()){return false;}
        if(!configuraAtualizacaoEgressoDAO.deletaReferenciasAtributosEntidades()){return false;}
        if(!atributoDAO.deleteAll()){return false;}
        if(!entidadeDAO.deleteAll()){return false;}
        return true;
    }

    public List<Entidade> getConfiguracoesAtualizacaoEgresso(){
        List<Entidade>  entidades = entidadeDAO.getAll();
        return entidades;
    }

    private void verificaIntegridadeDasEntidades(){
        try {
            if (entidades == null) {
                throw new InvalidParameterException("entidades");
            }

            for (Entidade entidade : entidades) {
                for (Atributo atributo : entidade.getAtributos()) {
                    if (atributo == null) {
                        throw new InvalidParameterException("atributo");
                    }

                    if (atributo.getDesviaPara() != null){
                        if ((atributo.getValorAtributoDeOrigem() == null) ||
                            ("".equals(atributo.getValorAtributoDeOrigem()))){
                            throw new InvalidParameterException("atributo desvia para");
                        }
                    }
                }
            }
        } catch (NullPointerException e) {
            throw new InvalidParameterException("entidades");
        }
    }

    private void verificaContinuidadeDasEntidades(){
        int count = 0;
        for (int i = 0; i < entidades.size(); i++) {
            if(entidades.get(i).getEntidadeAntecedente() == null){
                count ++;
            }
        }

        if (count > 1){
            throw new InvalidParameterException("entidades");
        }
    }
}
