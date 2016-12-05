package br.ufg.inf.sempreufg.servico;

import br.ufg.inf.sempreufg.modelo.Evento;
import br.ufg.inf.sempreufg.modelo.AprovacaoDivulgacaoEvento;

public interface AprovadorEventosServiceInterface {

    AprovacaoDivulgacaoEvento buscaEventoAprovado(Evento evento);
    Boolean isEventoAprovado(Evento evento);
}
