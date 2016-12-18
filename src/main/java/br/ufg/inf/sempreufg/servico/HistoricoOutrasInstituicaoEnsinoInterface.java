package br.ufg.inf.sempreufg.servico;

import java.io.InputStream;

import br.ufg.inf.sempreufg.modelo.HistoricoOutrasIES;

public interface HistoricoOutrasInstituicaoEnsinoInterface {
	HistoricoOutrasIES converterXmlParaHistoricoOutrasIntituicaoEnsino(InputStream content);
}
