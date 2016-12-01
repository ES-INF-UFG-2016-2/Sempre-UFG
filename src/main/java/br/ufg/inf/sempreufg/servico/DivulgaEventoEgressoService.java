package br.ufg.inf.sempreufg.servico;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import br.ufg.inf.sempreufg.interfaces.DivulgaEventoEgressoServiceInterface;
import br.ufg.inf.sempreufg.modelo.CursoUFG;
import br.ufg.inf.sempreufg.modelo.Evento;
import br.ufg.inf.sempreufg.modelo.Usuario;

public class DivulgaEventoEgressoService implements DivulgaEventoEgressoServiceInterface {

	@Override
	public boolean divulgaEventoDoCursoParaEgresso(Evento evento, CursoUFG cursoUFG) {

		Integer identificadorCurso = cursoUFG.getId();
		CursoService cursoService = new CursoService();
		List<Usuario> listaUsuarios = cursoService.obtenhaUsuariosDoCurso(identificadorCurso);
		List<Usuario> listaUsuariosDestinatarios = new ArrayList<>();
		DivulgadorEventosService divulgadorEventos = new DivulgadorEventosService();
		for (Usuario usuario : listaUsuarios) {

			switch (usuario.getTipoDivulgacao()) {
			case DIARIA:
				if (!usuarioRecebeuHoje(usuario)) {
					listaUsuariosDestinatarios.add(usuario);
				}
			case CADA_EVENTO:
				listaUsuariosDestinatarios.add(usuario);
				break;

			case SEMANAL:
				if (!usuarioRecebeuSemanal(usuario)) {
					listaUsuariosDestinatarios.add(usuario);
				}

			case MENSAL:
				if (!usuarioRecebeuMensal(usuario)) {
					listaUsuariosDestinatarios.add(usuario);
				}

			default:
				break;
			}

		}
		divulgadorEventos.divulgarEventoParaListaDeUsuarios(evento, listaUsuariosDestinatarios);

		return false;
	}

	public boolean usuarioRecebeuHoje(Usuario usuario) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(usuario.getUltimoEventoRecebido());
		calendar.set(Calendar.HOUR, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		calendar.set(Calendar.MILLISECOND, 0);
		Calendar dataAtual = Calendar.getInstance();
		dataAtual.set(Calendar.HOUR, 0);
		dataAtual.set(Calendar.MINUTE, 0);
		dataAtual.set(Calendar.SECOND, 0);
		dataAtual.set(Calendar.MILLISECOND, 0);
		if (calendar.compareTo(dataAtual) == 0) {
			return true;
		}
		return false;
	}

	public boolean usuarioRecebeuSemanal(Usuario usuario) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(usuario.getUltimoEventoRecebido());
		Calendar dataAtual = Calendar.getInstance();
		Integer semanaAtual = dataAtual.getWeekYear();
		if (calendar.getWeekYear() == semanaAtual) {
			return true;
		}
		return false;
	}

	public boolean usuarioRecebeuMensal(Usuario usuario) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(usuario.getUltimoEventoRecebido());
		Calendar dataAtual = Calendar.getInstance();
		Integer mesAtual = dataAtual.get(Calendar.MONTH);
		if (calendar.get(Calendar.MONTH) == mesAtual) {
			return true;
		}
		return false;
	}
}
