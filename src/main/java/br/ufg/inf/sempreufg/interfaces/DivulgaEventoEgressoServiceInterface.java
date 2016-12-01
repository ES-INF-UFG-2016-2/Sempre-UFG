package br.ufg.inf.sempreufg.interfaces;

import br.ufg.inf.sempreufg.modelo.CursoUFG;
import br.ufg.inf.sempreufg.modelo.Evento;
import br.ufg.inf.sempreufg.modelo.Usuario;

public interface DivulgaEventoEgressoServiceInterface {
	boolean divulgaEventoDoCursoParaEgresso(Evento evento, CursoUFG cursoUFG);
	boolean usuarioRecebeuHoje(Usuario usuario);
	boolean usuarioRecebeuSemanal(Usuario usuario);
	boolean usuarioRecebeuMensal(Usuario usuario);
}
