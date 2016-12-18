package br.ufg.inf.sempreufg.interfaces;

import br.ufg.inf.sempreufg.modelo.RespAprovaDivulgacaoEvento;

import java.util.List;

/**
 * Created by Marcos on 16/12/2016.
 */
public interface RespAprovaDivulgacaoEventoDaoInterface {

    public RespAprovaDivulgacaoEvento salvar(RespAprovaDivulgacaoEvento respAprovaDivulgacaoEvento);

    public RespAprovaDivulgacaoEvento alterar(RespAprovaDivulgacaoEvento respAprovaDivulgacaoEvento);

    public boolean deletar(RespAprovaDivulgacaoEvento respAprovaDivulgacaoEvento);

    public RespAprovaDivulgacaoEvento getById(String id);

    public List<RespAprovaDivulgacaoEvento> getAll();
}

