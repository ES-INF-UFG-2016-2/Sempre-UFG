/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.java.br.ufg.inf;



import java.time.Period;

import static test.java.br.ufg.inf.StubBackupTest.*;


public class StubBackup implements Backup {

    public boolean configurarBackup(Period periodicidade, String caminho) {
        return isPeriodicidadeValida(periodicidade) && isCaminhoValido(caminho);
    }

    private boolean isCaminhoValido(String caminho) {
        if (caminho == CAMINHO_TEST_CAMINHO_NULO) {
            return false;
        } else if (caminho.equals(CAMINHO_TEST_CAMINHO)) {
            return false;
        } else if (caminho.equals(CAMINHO_TEST_CAMINHO_COM_ESPACO)) {
            return true;
        } else if (caminho.equals(CAMINHO_TEST_VALIDO)) {
            return true;
        }
        return false;
    }

    private boolean isPeriodicidadeValida(Period periodicidade) {
        if (periodicidade == TEMPO_VALIDO) {
            return true;
        } else if (periodicidade == TEMPO_TEST_PERIODICIDADE_ZERO) {
            return false;
        } else if (periodicidade == TEMPO_TEST_PERIODICIDADE_NEGATIVA) {
            return false;
        } else if (periodicidade == TEMPO_TEST_PERIODICIDADE_NULO) {
            return false;
        }

        return false;

    }

}
