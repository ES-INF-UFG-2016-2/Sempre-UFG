package br.ufg.inf.backup;

import java.time.Period;

public interface RestauraBD {
    boolean restaurarBD(Period periodicidade, String caminho, String dataBackup);
}
