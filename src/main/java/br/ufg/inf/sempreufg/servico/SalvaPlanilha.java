package br.ufg.inf.sempreufg.servico;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import org.jopendocument.dom.OOUtils;
import org.jopendocument.dom.spreadsheet.SpreadSheet;

import br.ufg.inf.sempreufg.interfaces.SalvaPlanilhaInterface;

public class SalvaPlanilha implements SalvaPlanilhaInterface {

	private Object[][] tabela = null;

	public Object[][] retiraTituloColunas(Object[][] tabela) {

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

				switch (sc.next().toLowerCase()) {

				case "s":

					loop = false;
					break;

				case "n":

					loop = false;
					arquivo = modificaNomeArquivo(nome, caminho);
					break;

				}

			}
		}
		return arquivo;

	}

	public File modificaNomeArquivo(String nome, String caminho) {

		File novo_arquivo = new File(caminho + File.separator + nome + "2" + ".ods");

		return novo_arquivo;
	}

	@Override
	public void salvaPlanilha(Object[][] tabela, String nome, String caminho) throws Exception {
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

		this.tabela = retiraTituloColunas(tabela);

		TableModel model = new DefaultTableModel(this.tabela, columns);
		File arquivo = testaArquivoExistente(nome, caminho);

		try {
			SpreadSheet.createEmpty(model).saveAs(arquivo);
			OOUtils.open(arquivo);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void salvaPlanilha(List lista, String nome, String caminho) throws Exception {

		if (lista == null) {

			throw new NullPointerException("Tabela nula ou invalida.");

		} else if (!caminhoEhValido(caminho)) {

			throw new Exception("O caminho do arquivo e invalido.");

		} else if (caminho == null) {

			throw new Exception("Caminho não pode ser nulo.");
		} else if (nome == null) {

			throw new Exception("Nome não pode ser nulo.");

		}

		Object[][] tabela = listToArray(lista);

		Object[] columns = new Object[tabela[0].length];
		for (int i = 0; i < tabela[0].length; i++) {

			columns[i] = tabela[0][i];
		}

		this.tabela = retiraTituloColunas(tabela);

		TableModel model = new DefaultTableModel(this.tabela, columns);
		File arquivo = testaArquivoExistente(nome, caminho);

		try {
			SpreadSheet.createEmpty(model).saveAs(arquivo);
			OOUtils.open(arquivo);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	Object[][] listToArray(List lista) {

		Object[][] o = new Object[lista.size()][];

		for (int i = 0; i < lista.size(); i++) {

			o[i] = ((List) lista.get(i)).toArray();

		}

		return o;
	}
}
