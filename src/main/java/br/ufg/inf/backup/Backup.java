package main.java.br.ufg.inf.backup;

import java.time.Period;

public interface Backup {
	
	boolean configurarBackup(Period periodicidade, String caminho);
	

}
