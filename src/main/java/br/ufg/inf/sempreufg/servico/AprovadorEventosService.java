package br.ufg.inf.sempreufg.servico;

import br.ufg.inf.sempreufg.modelo.AprovacaoDivulgacaoEvento;
import br.ufg.inf.sempreufg.modelo.Evento;

public class AprovadorEventosService implements AprovadorEventosServiceInterface {

    @Override
    public AprovacaoDivulgacaoEvento buscaEventoAprovado(Evento evento) {
        return null;
    }

    @Override
    public Boolean isEventoAprovado(Evento evento) {
        return true;
    }
}
