package br.ufg.inf.backup;

import java.time.Period;

import static br.ufg.inf.utils.StubRestauraBDUtils.*;

public class StubRestauraBD implements RestauraBD {

    @Override
    public boolean restaurarBD(Period periodicidade, String caminho, String dataBackup) {
        return isPeriodicidadeValida(periodicidade) && isCaminhoValido(caminho) && isDataBackupValida(dataBackup) && isDataBackup(dataBackup);
    }

    //Verifica se existe o arquivo
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
    
    //Verifica se a periodicidade é válida
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
    
    //Verifica se a data é válida
    private boolean isDataBackupValida(String dataBackup) {
        if (dataBackup == DATA_NULO) {
            return false;
        } else if (dataBackup == DATA_SUPERIOR_ATUAL) {
            return false;
        } else if (dataBackup == DATA_INEXISTENTE) {
            return false;
        } else if (dataBackup == DATA_VALIDA_NAO_VINCULADA) {
            return false;
        } else if (dataBackup == DATA_VALIDA_VINCULADA) {
            //Verifica se a data está vinculada ao backup
            return true;
        }
        return false;
    }
}
