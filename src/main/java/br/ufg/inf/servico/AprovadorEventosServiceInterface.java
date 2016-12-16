package br.ufg.inf.servico;

import br.ufg.inf.modelo.Evento;
import br.ufg.inf.modelo.AprovacaoDivulgacaoEvento;

public interface AprovadorEventosServiceInterface {

    AprovacaoDivulgacaoEvento buscaEventoAprovado(Evento evento);
    Boolean isEventoAprovado(Evento evento);
}
