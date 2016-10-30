package br.ufg.inf.servico;
import java.io.InputStream;
import java.util.List;

import br.ufg.inf.modelo.CursoUFG;
import br.ufg.inf.modelo.Usuario;

public class CursoService implements CursoServiceInterface {

    @Override
    public List<Usuario> obtenhaUsuariosDoCurso(Integer idCurso) {
        return null;
    }

	@Override
	public CursoUFG converterXmlParaCurso(InputStream input) {
		return null;
	}
}
