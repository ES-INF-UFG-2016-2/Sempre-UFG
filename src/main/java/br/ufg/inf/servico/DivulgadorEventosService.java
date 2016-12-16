package br.ufg.inf.servico;

import br.ufg.inf.modelo.Evento;
import br.ufg.inf.modelo.Usuario;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;
import java.util.Date;
import java.util.List;
import java.util.Map;

public class DivulgadorEventosService implements DivulgadorEventosServiceInterface {

    @Override
    public boolean divulgarEventoParaListaDeUsuarios(Evento evento, List<Usuario> usuarios) {

        for(Usuario usuario : usuarios){
            try {
                Email email = new SimpleEmail();
                email.addTo(usuario.getNome() + "@gmail.com");
                email.setFrom("inf@inf.com.br");
                email.setSubject(evento.toString());
                email.setMsg(evento.toString());
                email.setHostName("inf@inf.com.br");
                email.send();
            } catch (EmailException e) {
                e.printStackTrace();
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean divulgarEventoParaTodosUsuarios(Evento evento) {
        return false;
    }

    @Override
    public Map<Date, Map<Usuario, Evento>> obtenhaEventosQueNaoForamEnviadosAinda() {
        return null;
    }
}
