package br.ufg.inf.sempreufg.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import br.ufg.inf.sempreufg.modelo.AreaDeConhecimento;
import br.ufg.inf.sempreufg.enums.NiveisCurso;
import br.ufg.inf.sempreufg.enums.TiposResolucao;
import br.ufg.inf.sempreufg.enums.Turnos;
import br.ufg.inf.sempreufg.interfaces.CursoUFGDAOInterface;
import br.ufg.inf.sempreufg.modelo.CursoUFG;

/**
 * Created by ${Rafael_Canedo} on 09/10/2016.
 */
public class CursoUFGDAO implements CursoUFGDAOInterface<CursoUFG>{

    @Override
    public void salvar(CursoUFG cursoUFG) {

    }

    @Override
    public void alterar(CursoUFG CursoUFG) {

    }

    @Override
    public void deletar(int id_cursoUFG) {

    }

    @Override
    public CursoUFG getById(int id_cursoUFG) {
        return null;
    }

    @Override
    public List<CursoUFG> getAll() {
        return null;
    }

	@Override
	public void inserir(CursoUFG entity) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<CursoUFG> select(String sql, Map<String, Object> parametros) {
		return criarListaCursoUfgMock();
	}

	@Override
	public List<CursoUFG> select(String sql) {
		return criarListaCursoUfgMock();
	}

	@Override
	public List<CursoUFG> selectAll() {
		return criarListaCursoUfgMock();
	}

	@Override
	public CursoUFG buscarById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<CursoUFG> criarListaCursoUfgMock(){
		List<CursoUFG> cursos = new ArrayList<CursoUFG>();

		for (int i = 0; i < 10; i++) {
			CursoUFG cursoUFG	= new CursoUFG(NiveisCurso.BACHARELADO,
											   TiposResolucao.CONSUNI,
											   12312312,
											   true,
											   Turnos.INTEGRAL,
											   new AreaDeConhecimento("AreaConhecimento", 10));
			cursos.add(cursoUFG);
		}

		return cursos;
	}
}
