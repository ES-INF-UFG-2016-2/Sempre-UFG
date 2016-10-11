package br.ufg.inf.DAO;

import br.ufg.inf.modelo.AreaDeConhecimentoStub;
import br.ufg.inf.interfaces.AreaDeConhecimentoDAOInterface;

import java.util.List;

/**
 * Created by ${Rafael_Canedo} on 09/10/2016.
 */
public class AreaDeConhecimentoDAOStub implements AreaDeConhecimentoDAOInterface{

    @Override
    public static AreaDeConhecimentoStub salvar(AreaDeConhecimentoStub areaDeConhecimentoStub) {
        return new AreaDeConhecimentoStub("EXATAS",01);
    }

    @Override
    public static void alterar(AreaDeConhecimentoStub areaDeConhecimentoStub) {

    }

    @Override
    public static void deletar(int id_areaDeConhecimento) {

    }

    @Override
    public static AreaDeConhecimentoStub getById(int id_AreaDeConhecimento) {
        return null;
    }

    @Override
    public static List<AreaDeConhecimentoStub> getAll() {
        return null;
    }
}
