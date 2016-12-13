package br.ufg.inf.sempreufg.servico;

import java.util.List;

import br.ufg.inf.sempreufg.modelo.Egresso;

public interface EgressoServiceInterface {
	public List<Egresso> converterJsonParaListaEgresso(String json);
	public boolean egressoEValido(Egresso egresso);
}
