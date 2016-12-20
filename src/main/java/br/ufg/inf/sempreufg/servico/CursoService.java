package br.ufg.inf.sempreufg.servico;

import java.io.InputStream;
import java.util.List;

import br.ufg.inf.sempreufg.dao.CursoUFGDAO;
import br.ufg.inf.sempreufg.modelo.CursoUFG;
import br.ufg.inf.sempreufg.modelo.Usuario;

public class CursoService implements CursoServiceInterface {

    @Override
    public List<Usuario> obtenhaUsuariosDoCurso(Integer idCurso) {
        return null;
    }

    @Override
    public CursoUFG converterXmlParaCurso(InputStream input) {
        return null;
    }

    /**
     * @see br.ufg.inf.sempreufg.servico.CursoServiceInterface#obterListaCursos()
     */
    @Override
    public List<CursoUFG> obterListaCursos() {
        CursoUFGDAO dao = new CursoUFGDAO();
        return dao.getAll();
    }
}
