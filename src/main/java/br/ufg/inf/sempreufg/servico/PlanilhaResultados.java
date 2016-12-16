package br.ufg.inf.sempreufg.servico;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import org.jopendocument.dom.OOUtils;
import org.jopendocument.dom.spreadsheet.SpreadSheet;

public class PlanilhaResultados {


	private Object[][] tabela = null;

	public void salvaParametros(Object[][] tabela, String caminho, String nome) throws Exception {

		if (tabela == null) {

			throw new NullPointerException("Tabela nula ou invalida.");

		} else if (!caminhoEhValido(caminho)) {

			throw new Exception("O caminho do arquivo e invalido.");

		} else if (caminho == null) {

			throw new Exception("Caminho não pode ser nulo.");
		} else if (nome == null) {

			throw new Exception("Nome não pode ser nulo.");

		}

		Object[] columns = new Object[tabela[0].length];
		for (int i = 0; i < tabela[0].length; i++) {

			columns[i] = tabela[0][i];
		}

		this.tabela =	retiraNomeColunas(tabela);

		TableModel model = new DefaultTableModel(this.tabela, columns);

		final File file = new File(caminho + File.separator + nome + ".ods");

		File arquivo = testaArquivoExistente(nome, caminho);

		try {
			SpreadSheet.createEmpty(model).saveAs(arquivo);
			OOUtils.open(arquivo);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public Object[][] retiraNomeColunas(Object[][] tabela) {

		for (int i = 0; i < tabela.length; i++) {

			for (int j = 0; j < tabela[i].length; j++) {

				if (i == tabela.length - 1) {

					tabela[i][j] = "";

				} else {

					tabela[i][j] = tabela[i + 1][j];
				}
			}

		}

		return tabela;

	}

	public boolean caminhoEhValido(String caminho) {

		File file = new File(caminho);
		if (file.isDirectory()) {

			return true;
		}
		if (file.getParentFile().exists()) {

			file.mkdir();

			return true;
		}
		return false;
	}

	public File testaArquivoExistente(String nome, String caminho) {

		File arquivo = new File(caminho + File.separator + nome + ".ods");

		if (arquivo.exists()) {

			System.out.println("O arquivo já existe, deseja substituí-lo?");

			Scanner sc = new Scanner(System.in);

			boolean loop = true;
			while (loop) {

				switch (sc.next()) {

				case "s":

					loop = false;
					break;

				case "S":

					loop = false;
					break;

				case "n":

					arquivo = modificaNomeArquivo(nome, caminho);
					loop = false;

					break;

				case "N":

					arquivo = modificaNomeArquivo(nome, caminho);
					loop = false;
					break;

				default:

					System.out.println("Escolha Invalida!");

				}

			}
		}
		return arquivo;

	}

	public File modificaNomeArquivo(String nome, String caminho) {

		File novo_arquivo = new File(caminho + File.separator + nome + "2" + ".ods");

		return novo_arquivo;
	}
}
