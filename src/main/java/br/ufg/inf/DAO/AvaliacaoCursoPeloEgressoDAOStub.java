package br.ufg.inf.DAO;

import br.ufg.inf.modelo.AvaliacaoCursoPeloEgressoStub;
import br.ufg.inf.interfaces.AvaliacaoCursoPeloEgressoDAOInterface;

import java.util.List;

/**
 * Created by ${Rafael_Canedo} on 09/10/2016.
 */
public class AvaliacaoCursoPeloEgressoDAOStub implements AvaliacaoCursoPeloEgressoDAOInterface{
    @Override
    public void salvar(AvaliacaoCursoPeloEgressoStub avaliacaoCursoPeloEgresso) {

    }

    @Override
    public void alterar(AvaliacaoCursoPeloEgressoStub avaliacaoCursoPeloEgressoStub) {

    }

    @Override
    public void deletar(int id_avaliacaoCursoPeloEgresso) {

    }

    @Override
    public AvaliacaoCursoPeloEgressoStub getById(int id_avaliacaoCursoPeloEgresso) {
        return null;
    }

    @Override
    public List<AvaliacaoCursoPeloEgressoStub> getAll() {
        return null;
    }
}
