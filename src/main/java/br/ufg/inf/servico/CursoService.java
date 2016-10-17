package br.ufg.inf.servico;


import br.ufg.inf.modelo.Usuario;
import java.util.List;

public interface CursoService {
    List<Usuario> obtenhaUsuariosDoCurso(Integer idCurso);
}
