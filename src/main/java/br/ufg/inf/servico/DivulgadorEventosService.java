package br.ufg.inf.servico;

import br.ufg.inf.Evento;
import br.ufg.inf.Usuario;

import java.util.Date;
import java.util.List;
import java.util.Map;

public interface DivulgadorEventosService {

    boolean divulgarEventoParaListaDeUsuarios(Evento evento, List<Usuario> usuarios);

    boolean divulgarEventoParaTodosUsuarios(Evento evento);

    Map<Date, Map<Usuario, Evento>> obtenhaEventosQueNaoForamEnviadosAinda();

}
