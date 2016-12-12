package br.ufg.inf.sempreufg.interfaces;

import java.util.List;
import java.util.Map;

import br.ufg.inf.sempreufg.enums.NomeCampos;
import br.ufg.inf.sempreufg.modelo.Egresso;

public interface EgressoServiceInterface {
	public List<Egresso> consultaPorAdHoc(Map<NomeCampos, String> parametros);
	public List<Egresso> consultarEgressoPorConsultaPreDefinida(String string);
}
