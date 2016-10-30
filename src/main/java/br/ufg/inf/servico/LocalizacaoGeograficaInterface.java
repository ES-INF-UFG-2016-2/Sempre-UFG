package br.ufg.inf.servico;

import java.io.InputStream;

import br.ufg.inf.modelo.LocalizacaoGeografica;

public interface LocalizacaoGeograficaInterface {
	LocalizacaoGeografica converterXmlParaLocalizacaoGeografica(InputStream content);
}
