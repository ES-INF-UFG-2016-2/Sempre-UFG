package br.ufg.inf.servico;


import java.io.InputStream;
import java.util.List;

import br.ufg.inf.modelo.CursoUFG;
import br.ufg.inf.modelo.Usuario;

public interface CursoServiceInterface {
    List<Usuario> obtenhaUsuariosDoCurso(Integer idCurso);
    CursoUFG converterXmlParaCurso(InputStream input);
}
