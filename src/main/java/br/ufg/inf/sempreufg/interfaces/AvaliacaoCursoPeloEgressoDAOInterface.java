package br.ufg.inf.sempreufg.interfaces;

import br.ufg.inf.sempreufg.modelo.AvaliacaoCursoPeloEgresso;

import java.util.List;

/**
 * Created by ${Rafael_Canedo} on 09/10/2016.
 */
public interface AvaliacaoCursoPeloEgressoDAOInterface {
    public void salvar(AvaliacaoCursoPeloEgresso valiacaoCursoPeloEgresso);

    public void alterar(AvaliacaoCursoPeloEgresso avaliacaoCursoPeloEgresso);

    public void deletar(int id_avaliacaoCursoPeloEgresso);

    public AvaliacaoCursoPeloEgresso getById(int id_AvaliacaoCursoPeloEgresso);

    public List<AvaliacaoCursoPeloEgresso> getAll();
}
