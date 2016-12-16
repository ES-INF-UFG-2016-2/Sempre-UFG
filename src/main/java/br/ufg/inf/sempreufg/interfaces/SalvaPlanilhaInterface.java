package br.ufg.inf.sempreufg.interfaces;

import java.util.List;

public interface SalvaPlanilhaInterface {

	boolean salvaPlanilha(Object[][] tabela, String nome, String caminho);

	boolean salvaPlanilha(List tabela, String nome, String caminho);

}
