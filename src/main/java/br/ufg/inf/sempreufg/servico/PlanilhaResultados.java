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


public class PlanilhaResultados {

	private Object[][] tabela = null;

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
