package br.ufg.inf.sempreufg.interfaces;

import br.ufg.inf.sempreufg.modelo.AreaDeConhecimento;

import java.util.List;

/**
 * Created by ${Rafael_Canedo} on 09/10/2016.
 */
public interface AreaDeConhecimentoDAOInterface {

    public void salvar(AreaDeConhecimento areaDeConhecimento);

    public void alterar(AreaDeConhecimento areaDeConhecimento);

    public void deletar(int id_areaDeConhecimento);

    public AreaDeConhecimento getById(int id_AreaDeConhecimento);

    public List<AreaDeConhecimento> getAll();

}
