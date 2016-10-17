package br.ufg.inf.DAO;

import br.ufg.inf.modelo.AreaDeConhecimentoStub;
import br.ufg.inf.interfaces.AreaDeConhecimentoDAOInterface;

import java.util.List;

/**
 * Created by ${Rafael_Canedo} on 09/10/2016.
 */
public class AreaDeConhecimentoDAOStub implements AreaDeConhecimentoDAOInterface{

    @Override
    public AreaDeConhecimentoStub salvar(AreaDeConhecimentoStub areaDeConhecimentoStub) {
        return new AreaDeConhecimentoStub("EXATAS",01);
    }

    @Override
    public  void alterar(AreaDeConhecimentoStub areaDeConhecimentoStub) {

    }

    @Override
    public  void deletar(int id_areaDeConhecimento) {

    }

    @Override
    public AreaDeConhecimentoStub getById(int id_AreaDeConhecimento) {
        return null;
    }

    @Override
    public  List<AreaDeConhecimentoStub> getAll() {
        return null;
    }

}
