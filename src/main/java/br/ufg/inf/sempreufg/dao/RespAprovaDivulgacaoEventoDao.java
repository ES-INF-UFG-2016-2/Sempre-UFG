package br.ufg.inf.sempreufg.dao;

import br.ufg.inf.sempreufg.interfaces.RespAprovaDivulgacaoEventoDaoInterface;
import br.ufg.inf.sempreufg.modelo.Evento;
import br.ufg.inf.sempreufg.modelo.RespAprovaDivulgacaoEvento;
import br.ufg.inf.sempreufg.modelo.Usuario;
import org.omg.CORBA.RepositoryIdHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Marcos on 16/12/2016.
 */
public class RespAprovaDivulgacaoEventoDao implements RespAprovaDivulgacaoEventoDaoInterface {
    public RespAprovaDivulgacaoEventoDao() {
    }

    @Override
    public RespAprovaDivulgacaoEvento salvar(RespAprovaDivulgacaoEvento respAprovaDivulgacaoEvento) {
        if (respAprovaDivulgacaoEvento == null){
            return null;
        }
        return respAprovaDivulgacaoEvento;
    }

    @Override
    public RespAprovaDivulgacaoEvento alterar(RespAprovaDivulgacaoEvento respAprovaDivulgacaoEvento) {
        if (respAprovaDivulgacaoEvento == null){
            return null;
        }
        return respAprovaDivulgacaoEvento;
    }

    @Override
    public boolean deletar(RespAprovaDivulgacaoEvento respAprovaDivulgacaoEvento) {
        if (respAprovaDivulgacaoEvento == null){
            return false;
        }
        return true;
    }

    @Override
    public RespAprovaDivulgacaoEvento getById(String id) {
        if ((id == null) || ("".equals(id))){
            return null;
        }
        return criaRespAprovaDivulgacaoEventoStub();
    }

    @Override
    public List<RespAprovaDivulgacaoEvento> getAll() {
        return criaListaRespAprovaDivulgacaoEventoStub();
    }

    public RespAprovaDivulgacaoEvento criaRespAprovaDivulgacaoEventoStub(){
        Usuario usuario = new Usuario();
        usuario.setNome("Teste");
        usuario.setCpf(1234123l);
        usuario.setMail("teste@teste.com");

        Evento evento = new Evento();
        evento.setAssunto("Evento");
        evento.setDes_evento("Descrição Evento");
        evento.setId(1);

        RespAprovaDivulgacaoEvento respAprovaDivulgacaoEvento = new RespAprovaDivulgacaoEvento();
        respAprovaDivulgacaoEvento.setUsuario(usuario);
        respAprovaDivulgacaoEvento.setEvento(evento);
        respAprovaDivulgacaoEvento.setId("1");
        return respAprovaDivulgacaoEvento;
    }

    private List<RespAprovaDivulgacaoEvento> criaListaRespAprovaDivulgacaoEventoStub(){
        List<RespAprovaDivulgacaoEvento> respAprovaDivulgacaoEventos = new ArrayList<>();
        respAprovaDivulgacaoEventos.add(criaRespAprovaDivulgacaoEventoStub());
        return respAprovaDivulgacaoEventos;
    }
}
