package br.ufg.inf.servico;

import java.io.InputStream;

import br.ufg.inf.modelo.Residencia;

public interface ResidenciaInterface {
	Residencia converterXmlParaResidencia(InputStream content);
}
