package br.ufg.inf.servico;

import br.ufg.inf.modelo.AprovacaoDivulgacaoEvento;
import br.ufg.inf.modelo.Evento;

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
