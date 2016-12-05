package br.ufg.inf.sempreufg.servico;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import javax.lang.model.element.Element;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import org.jopendocument.dom.OOUtils;
import org.jopendocument.dom.spreadsheet.SpreadSheet;

import br.ufg.inf.sempreufg.dados.Campo;
import br.ufg.inf.sempreufg.dados.Linha;
import br.ufg.inf.sempreufg.dados.Tabela;

public class PlanilhaResultados {

	private Object[][] tabela = null;
	String caminho_arq;
	String nome_arq;

	public static void main(String args[]) {

		final Object[][] data = new Object[6][1];
		data[0] = new Object[] { "Nome", "Cpf", "Cidade", "Idade", "Ano Graduacao" };
		data[1] = new Object[] { "Rafael", "12313123123", "Goiânia", "22", "2010" };
		data[2] = new Object[] { "Rafael", "12313123123", "Goiânia", "23", "2011" };
		data[3] = new Object[] { "Rafael", "12313123123", "Goiânia", "24", "2012" };
		data[4] = new Object[] { "Rafael", "12313123123", "Goiânia", "25", "2013" };
		data[5] = new Object[] { "Rafael", "12313123123", "Goiânia", "26", "2014" };

		String path = "C:\\Users\\Rafael\\Desktop\\planilhas";
		String nome = "Resultados";
		new PlanilhaResultados().salvaParametros(data, path, nome);

	}

	public void salvaParametros(Object[][] tabela, String caminho, String nome) {

		Object[] columns = new Object[tabela[0].length];
		for (int i = 0; i < tabela[0].length; i++) {

			columns[i] = tabela[0][i];
		}

		this.tabela = new PlanilhaResultados().retiraNomeColunas(tabela);

		TableModel model = new DefaultTableModel(this.tabela, columns);

		final File file = new File(caminho + File.separator + nome + ".ods");

		try {
			SpreadSheet.createEmpty(model).saveAs(file);
			OOUtils.open(file);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public Object[][] retiraNomeColunas(Object[][] tabela) {

		for (int i = 0; i < tabela.length; i++) {

			for (int j = 0; j < tabela[i].length; j++) {

				System.out.println(i + "," + j);
				System.out.println(tabela[i][j]);

				if (i == tabela.length - 1) {

					tabela[i][j] = "";

				} else {

					tabela[i][j] = tabela[i + 1][j];
				}
			}

		}

		return tabela;

	}

}
