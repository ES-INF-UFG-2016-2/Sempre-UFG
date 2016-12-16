package br.ufg.inf.sempreufg.interfaces;

import br.ufg.inf.sempreufg.modelo.AprovacaoDivulgacaoEvento;

public interface AprovacaoDivulgacaoEventoDAOInterface {

    public void salvar(AprovacaoDivulgacaoEvento aprovacaoDivulgacaoEvento);

    public void alterar(AprovacaoDivulgacaoEvento aprovacaoDivulgacaoEvento);

    public void deletar(int id_AprovacaoDivulgacaoEvento) ;

    public AprovacaoDivulgacaoEvento getById(int id_Areid_AprovacaoDivulgacaoEvento);

    public boolean obtemStatusAprovacaoEvento();

}
