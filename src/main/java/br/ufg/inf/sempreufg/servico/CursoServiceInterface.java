package br.ufg.inf.sempreufg.servico;


import java.io.InputStream;
import java.util.List;

import br.ufg.inf.sempreufg.modelo.CursoUFG;
import br.ufg.inf.sempreufg.modelo.Usuario;

public interface CursoServiceInterface {
    List<Usuario> obtenhaUsuariosDoCurso(Integer idCurso);
    CursoUFG converterXmlParaCurso(InputStream input);
}
