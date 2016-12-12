package br.ufg.inf.sempreufg.interfaces;

import java.util.List;

public interface SalvaPlanilhaInterface {

	void salvaPlanilha(Object[][] tabela, String nome, String caminho) throws Exception;

	void salvaPlanilha(List tabela, String nome, String caminho) throws Exception;

}
