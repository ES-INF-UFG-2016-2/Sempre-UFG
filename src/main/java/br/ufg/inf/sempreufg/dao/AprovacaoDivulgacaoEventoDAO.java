package br.ufg.inf.sempreufg.dao;

import br.ufg.inf.sempreufg.interfaces.AprovacaoDivulgacaoEventoDAOInterface;
import br.ufg.inf.sempreufg.modelo.AprovacaoDivulgacaoEvento;

public class AprovacaoDivulgacaoEventoDAO implements AprovacaoDivulgacaoEventoDAOInterface{

    private AprovacaoDivulgacaoEvento aprovacaoDivulgacaoEvento;

    @Override
    public void salvar(AprovacaoDivulgacaoEvento aprovacaoDivulgacaoEvento) {
        this.aprovacaoDivulgacaoEvento = aprovacaoDivulgacaoEvento;
    }

    @Override
    public void alterar(AprovacaoDivulgacaoEvento aprovacaoDivulgacaoEvento) {

    }

    @Override
    public void deletar(int id_AprovacaoDivulgacaoEvento) {

    }

    @Override
    public AprovacaoDivulgacaoEvento getById(int id_Areid_AprovacaoDivulgacaoEvento) {
        return null;
    }

    @Override
    public boolean obtemStatusAprovacaoEvento() {
        return aprovacaoDivulgacaoEvento.isDivulgacaoAprovada();
    }
}
