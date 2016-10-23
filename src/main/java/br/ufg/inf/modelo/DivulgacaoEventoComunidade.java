package br.ufg.inf.modelo;

import br.ufg.inf.servico.DivulgadorEventosService;
import java.util.Date;
import java.util.List;
import java.util.Map;

public class DivulgacaoEventoComunidade implements DivulgadorEventosService {

    private Evento evento;

    public DivulgacaoEventoComunidade(Evento evento) {
        this.evento = evento;
    }

    @Override
    public boolean divulgarEventoParaListaDeUsuarios(Evento evento, List<Usuario> usuarios) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public boolean divulgarEventoParaTodosUsuarios(Evento evento) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Map<Date, Map<Usuario, Evento>> obtenhaEventosQueNaoForamEnviadosAinda() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public Evento getEvento() {
        return evento;
    }

    public void setEvento(Evento evento) {
        this.evento = evento;
    }

}
