package br.ufg.inf.sempreufg.servico;

import br.ufg.inf.sempreufg.dao.AprovacaoDivulgacaoEventoDAO;
import br.ufg.inf.sempreufg.interfaces.AprovDivulgEventInterface;
import br.ufg.inf.sempreufg.modelo.AprovacaoDivulgacaoEvento;
import br.ufg.inf.sempreufg.modelo.Evento;
import br.ufg.inf.sempreufg.modelo.Responsavel;

public class AprovDivulgEventServico implements AprovDivulgEventInterface {

	AprovacaoDivulgacaoEventoDAO dao = new AprovacaoDivulgacaoEventoDAO();
	
	@Override
	public String getResultado() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void atribuirResponsavelPorAprovacaoDivulgacao(Evento evento, Responsavel reponsavel) {
		AprovacaoDivulgacaoEvento divulgacaoEvento = new AprovacaoDivulgacaoEvento();
		
		divulgacaoEvento.setEvento(evento);
		divulgacaoEvento.setResponsavelPorAprovar(reponsavel);
		divulgacaoEvento.setDivulgacaoAprovada(Boolean.FALSE);

		dao.salvar(divulgacaoEvento);
		
	}

}
