package br.ufg.inf.sempreufg.interfaces;

import java.time.Period;

public interface Backup {

	boolean configurarBackup(Period periodicidade, String caminho);
}
