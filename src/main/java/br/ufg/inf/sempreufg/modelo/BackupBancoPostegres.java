package br.ufg.inf.sempreufg.modelo;

import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;

import br.ufg.inf.sempreufg.abstratas.AbstractBackupBanco;
import br.ufg.inf.sempreufg.factory.ConnectionFactoryPostegres;


public class BackupBancoPostegres extends AbstractBackupBanco{

	public BackupBancoPostegres() throws ClassNotFoundException, SQLException {
		super();
		setCon(new ConnectionFactoryPostegres().getConnection());
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
	public void criarBackup(String caminho,String caminhoPadraoParaExecucao) {
		try {
            Process process = Runtime.getRuntime().exec(caminhoPadraoParaExecucao+"\\"+" pg_dump -h localhost -U postgres sempre_ufg -f "+caminho);
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
