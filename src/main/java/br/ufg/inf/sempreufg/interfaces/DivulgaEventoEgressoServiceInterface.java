package br.ufg.inf.sempreufg.interfaces;

import br.ufg.inf.sempreufg.modelo.CursoUFG;
import br.ufg.inf.sempreufg.modelo.Evento;

public interface DivulgaEventoEgressoServiceInterface {
	boolean divulgaEventoDoCursoParaEgresso(Evento evento, CursoUFG cursoUFG);
}
