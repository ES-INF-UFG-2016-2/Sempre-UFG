package br.ufg.inf.sempreufg.servico;

import java.io.InputStream;

import br.ufg.inf.sempreufg.modelo.Residencia;

public interface ResidenciaInterface {
	Residencia converterXmlParaResidencia(InputStream content);
}
