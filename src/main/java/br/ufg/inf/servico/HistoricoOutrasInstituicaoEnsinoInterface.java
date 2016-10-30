package br.ufg.inf.servico;

import java.io.InputStream;

import br.ufg.inf.modelo.HistoricoOutrasIES;

public interface HistoricoOutrasInstituicaoEnsinoInterface {
	HistoricoOutrasIES converterXmlParaHistoricoOutrasIntituicaoEnsino(InputStream content);
}
