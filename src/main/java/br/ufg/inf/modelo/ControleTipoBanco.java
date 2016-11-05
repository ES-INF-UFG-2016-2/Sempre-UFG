package br.ufg.inf.modelo;

import br.ufg.inf.enums.TipoBanco;

public class ControleTipoBanco {
	public static TipoBanco obterTipoBancoLogado(){
		return TipoBanco.MARIA_DB;
	}
}
