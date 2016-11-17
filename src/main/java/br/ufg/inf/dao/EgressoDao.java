package br.ufg.inf.dao;

import java.util.List;
import java.util.Map;

import br.ufg.inf.enums.NomeCampos;
import br.ufg.inf.interfaces.EgressoDaoInterface;
import br.ufg.inf.modelo.Egresso;
import br.ufg.inf.servico.ExecultarConsultasMock;


public class EgressoDao implements EgressoDaoInterface<Egresso> {
	
	public void consultarPorConsultaPreDefinida(){
		
	}

	@Override
	public Map<Object, Egresso> listarTodos() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<Object, Egresso> listarPorId(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<Object, Egresso> consultaPorAdHoc(Map<NomeCampos, String> parametros) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Egresso> select(String string) {
		return new ExecultarConsultasMock().criarListaEgresso();
	}
	
}
