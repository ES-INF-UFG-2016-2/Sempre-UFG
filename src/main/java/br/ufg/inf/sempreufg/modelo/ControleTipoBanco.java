package br.ufg.inf.sempreufg.modelo;

import br.ufg.inf.sempreufg.enums.TipoBanco;

public class ControleTipoBanco {
	public static TipoBanco obterTipoBancoLogado(){
		return TipoBanco.MARIA_DB;
	}
}
