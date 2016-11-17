package br.ufg.inf.interfaces;

import java.util.List;
import java.util.Map;

import br.ufg.inf.enums.NomeCampos;
import br.ufg.inf.modelo.Egresso;

public interface EgressoServiceInterface {
	public List<Egresso> consultaPorAdHoc(Map<NomeCampos, String> parametros);
	public List<Egresso> consultarEgressoPorConsultaPreDefinida(String string);
}
