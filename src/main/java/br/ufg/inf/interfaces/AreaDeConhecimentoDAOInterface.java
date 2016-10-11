package br.ufg.inf.interfaces;

import br.ufg.inf.modelo.AreaDeConhecimentoStub;

import java.util.List;

/**
 * Created by ${Rafael_Canedo} on 09/10/2016.
 */
public interface AreaDeConhecimentoDAOInterface {

    static abstract AreaDeConhecimentoStub salvar(AreaDeConhecimentoStub areaDeConhecimentoStub);

    public void alterar(AreaDeConhecimentoStub areaDeConhecimentoStub);

    public void deletar(int id_areaDeConhecimento);

    public AreaDeConhecimentoStub getById(int id_AreaDeConhecimento);

    public List<AreaDeConhecimentoStub> getAll();

}
