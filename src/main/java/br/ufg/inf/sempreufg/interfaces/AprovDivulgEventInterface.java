package br.ufg.inf.sempreufg.interfaces;

import br.ufg.inf.sempreufg.modelo.Evento;
import br.ufg.inf.sempreufg.modelo.Responsavel;

public interface AprovDivulgEventInterface {

	public String getResultado();

	void atribuirResponsavelPorAprovacaoDivulgacao(Evento evento, Responsavel reponsavel);

}
