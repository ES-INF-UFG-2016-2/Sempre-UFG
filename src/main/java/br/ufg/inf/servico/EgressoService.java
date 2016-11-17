package br.ufg.inf.servico;

import java.util.List;
import java.util.Map;

import br.ufg.inf.enums.NomeCampos;
import br.ufg.inf.interfaces.EgressoServiceInterface;
import br.ufg.inf.modelo.Egresso;

public class EgressoService implements EgressoServiceInterface{

	@Override
	public List<Egresso> consultarEgressoPorConsultaPreDefinida(String string) {
		return new ExecultarConsultasMock().criarListaEgresso();
	}

	@Override
	public List<Egresso> consultaPorAdHoc(Map<NomeCampos, String> parametros) {
		return new ExecultarConsultasMock().criarListaEgresso();
	}

}
