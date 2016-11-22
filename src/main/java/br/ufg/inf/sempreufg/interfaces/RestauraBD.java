package br.ufg.inf.sempreufg.interfaces;

import java.time.Period;

public interface RestauraBD {
    boolean restaurarBD(Period periodicidade, String caminho, String dataBackup);
}
