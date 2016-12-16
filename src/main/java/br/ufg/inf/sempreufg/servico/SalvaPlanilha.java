package br.ufg.inf.sempreufg.servico;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import org.jopendocument.dom.OOUtils;
import org.jopendocument.dom.spreadsheet.SpreadSheet;

import br.ufg.inf.sempreufg.interfaces.SalvaPlanilhaInterface;

public class SalvaPlanilha implements SalvaPlanilhaInterface {

	private static Object[][] tabela = null;
	private static Scanner sc = new Scanner(System.in);

	private Object[][] retiraTituloColunas(Object[][] tabela) {

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

	private boolean caminhoValido(String caminho) {

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

	private File testaArquivoExistente(String nome, String caminho) {

		File arquivo = new File(caminho + File.separator + nome + ".ods");

		if (arquivo.exists()) {

			System.out.println("O arquivo já existe, deseja substituí-lo?");

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

	private File modificaNomeArquivo(String nome, String caminho) {

		File novo_arquivo = new File(caminho + File.separator + nome + "2" + ".ods");

		return novo_arquivo;
	}

	@Override
	public boolean salvaPlanilha(Object[][] tabela, String nome, String caminho) {

		if (!planilhaValida(tabela) || !caminhoValido(caminho) || !nomeValido(nome)) {

			return false;
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
		} catch (Exception e) {
			return false;
		}
		return true;

	}

	@Override
	public boolean salvaPlanilha(List lista, String nome, String caminho) {

		if (!planilhaValida(lista) || !caminhoValido(caminho) || !nomeValido(nome)) {

			return false;
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
		} catch (Exception e) {
			return false;
		}

		return true;

	}

	private Object[][] listToArray(List lista) {

		Object[][] o = new Object[lista.size()][];

		for (int i = 0; i < lista.size(); i++) {

			o[i] = ((List) lista.get(i)).toArray();

		}

		return o;
	}

	private boolean planilhaValida(List planilha) {

		Iterator i = planilha.iterator();
		while (i.hasNext()) {

			List lista = (ArrayList) i.next();
			Iterator j = lista.iterator();
			if (j == null) {
				return false;
			} else {

				while (j.hasNext()) {

					Object valor = j.next();
					if (valor == null || valor == "") {

						return false;
					}
				}
			}
		}
		return true;

	}

	private boolean planilhaValida(Object[][] tabela) {

		for (int i = 0; i < tabela.length; i++) {

			if (tabela[i] == null) {

				System.out.println("lista nula");
				return false;
			}

			for (int j = 0; j < tabela[j].length; j++) {

				if (tabela[i][j] == null || tabela[i][j] == "") {

					System.out.println("string nula");
					return false;
				}
			}
		}

		return true;
	}

	private boolean nomeValido(String nome) {

		if ((nome.contains("#")) || (nome.contains("?")) || (nome.contains("%")) || (nome.contains("<"))
				|| (nome.contains("|")) || (nome.contains(":")) || (nome.contains("~")) || (nome.contains("\\"))
				|| (nome.contains(">")) || (nome.contains("/")) || (nome == "") || (nome == null)
				|| (nome.length() < 2)) {

			return false;
		}

		return true;
	}

}
