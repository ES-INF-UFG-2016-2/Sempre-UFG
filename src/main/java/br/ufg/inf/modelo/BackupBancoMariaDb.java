package br.ufg.inf.modelo;

import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;

import br.ufg.inf.abstratas.AbstractBackupBanco;
import br.ufg.inf.factory.ConnectionFactoryMariaDb;


public class BackupBancoMariaDb extends AbstractBackupBanco {
	
	

	public BackupBancoMariaDb() throws ClassNotFoundException, SQLException {
		super();
		setCon(new ConnectionFactoryMariaDb().getConnection());
	}

	@Override
	public void realizarBackup(ParametrosBackupBanco parametros) {
		String caminho = parametros.getDiretorioBackup();
		String caminhoPadraoParaExecucao = parametros.getDiretorioPadraoExecucaoBackup();
		if (caminhoBackupEValido(caminho)) {
			criarBackup(caminho, caminhoPadraoParaExecucao);
		}
	}

	@Override
	public void criarBackup(String caminho, String caminhoPadraoParaExecucao) {
		try {
            Process process = Runtime.getRuntime().exec(caminhoPadraoParaExecucao+"\\"+"mysqldump -u root --password=duckmaster sempre_ufg -r "+caminho);
            process.waitFor();
            InputStream stream = process.getErrorStream();
            byte[] content = new byte[stream.available()];
            if (content.length > 0){
               stream.read(content);
               System.out.println("*** ERRO *** ");
               System.out.println(new String(content));
            }
            System.out.println("Processo Finalizado");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
	}
}
