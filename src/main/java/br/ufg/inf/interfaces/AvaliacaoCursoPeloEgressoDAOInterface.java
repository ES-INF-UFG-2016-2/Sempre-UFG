package br.ufg.inf.interfaces;

import br.ufg.inf.modelo.AvaliacaoCursoPeloEgressoStub;

import java.util.List;

/**
 * Created by ${Rafael_Canedo} on 09/10/2016.
 */
public interface AvaliacaoCursoPeloEgressoDAOInterface {
    public void salvar(AvaliacaoCursoPeloEgressoStub valiacaoCursoPeloEgresso);

    public void alterar(AvaliacaoCursoPeloEgressoStub avaliacaoCursoPeloEgressoStub);

    public void deletar(int id_avaliacaoCursoPeloEgresso);

    public AvaliacaoCursoPeloEgressoStub getById(int id_AvaliacaoCursoPeloEgresso);

    public List<AvaliacaoCursoPeloEgressoStub> getAll();
}
