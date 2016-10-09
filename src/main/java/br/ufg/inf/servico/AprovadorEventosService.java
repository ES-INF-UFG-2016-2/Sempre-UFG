package br.ufg.inf.servico;

import br.ufg.inf.modelo.Evento;
import br.ufg.inf.modelo.AprovacaoDivulgacaoEvento;

public interface AprovadorEventosService {

    AprovacaoDivulgacaoEvento buscaEventoAprovado(Evento evento);

}
