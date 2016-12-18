package br.ufg.inf.sempreufg.servico;

import java.io.InputStream;

import br.ufg.inf.sempreufg.modelo.LocalizacaoGeografica;

public interface LocalizacaoGeograficaInterface {
	LocalizacaoGeografica converterXmlParaLocalizacaoGeografica(InputStream content);
}
