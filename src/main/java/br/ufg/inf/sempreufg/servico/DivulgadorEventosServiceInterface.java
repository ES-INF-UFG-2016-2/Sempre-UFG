package br.ufg.inf.sempreufg.servico;

import br.ufg.inf.sempreufg.modelo.Evento;
import br.ufg.inf.sempreufg.modelo.Usuario;

import java.util.Date;
import java.util.List;
import java.util.Map;

public interface DivulgadorEventosServiceInterface {

    boolean divulgarEventoParaListaDeUsuarios(Evento evento, List<Usuario> usuarios);
    boolean divulgarEventoParaTodosUsuarios(Evento evento);
    Map<Date, Map<Usuario, Evento>> obtenhaEventosQueNaoForamEnviadosAinda();
}
