package br.ufg.inf.sempreufg.servico;


import br.ufg.inf.sempreufg.modelo.Usuario;

import java.util.List;

public interface CursoServiceInterface {
    List<Usuario> obtenhaUsuariosDoCurso(Integer idCurso);
}
