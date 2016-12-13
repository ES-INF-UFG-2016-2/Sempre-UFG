package br.ufg.inf.sempreufg.rd_gestimport;

import java.sql.*;
import java.util.Calendar;

public class TestePK extends Teste {

    public TestePK(Connection conexaoDb, RdGestImport rd) {
        super(conexaoDb, rd);
    }

    public void efetuarTestes() {
        System.out.print("Testando PK com inserção válida:");
        apagarTabela();
        if (testeDePKValido()) {
            System.out.println("OK");

        } else {
            System.out.println("Falhou");
        }
        apagarTabela();
        System.out.print("Testando PK com inserção inválida:");
        if (testeDePKInvalido()) {
            System.out.println("OK");

        } else {
            System.out.println("Falhou");
        }
    }

    private boolean testeDePKValido() {
        try {
            PreparedStatement preparedStatement = this.conexaoDb.prepareStatement(this.getSqlInsert());
            Calendar cal = Calendar.getInstance();
            Date data = new Date(cal.getTimeInMillis());
            preparedStatement.setDate(1, data);
            preparedStatement.setDate(2, data);
            preparedStatement.setDate(3, data);
            preparedStatement.setInt(4, 10);
            preparedStatement.setInt(5, 10);
            preparedStatement.setInt(6, 10);
            preparedStatement.setInt(7, 10);
            preparedStatement.setInt(8, 10);
            preparedStatement.setInt(9, 10);
            boolean execute = preparedStatement.executeUpdate() > 0;
            if (execute) {
                preparedStatement = this.conexaoDb.prepareStatement(this.getSqlInsert());
                data = new Date(cal.getTimeInMillis());
                preparedStatement.setDate(1, data);
                preparedStatement.setDate(2, data);
                preparedStatement.setDate(3, data);
                preparedStatement.setInt(4, 10);
                preparedStatement.setInt(5, 10);
                preparedStatement.setInt(6, 10);
                preparedStatement.setInt(7, 10);
                preparedStatement.setInt(8, 10);
                preparedStatement.setInt(9, 11);
                execute = preparedStatement.executeUpdate() > 0;
            }
            return execute;
        } catch (SQLException e) {
            return false;
        }
    }

    private boolean testeDePKInvalido() {
        try {
            PreparedStatement preparedStatement = this.conexaoDb.prepareStatement(this.getSqlInsert());
            Calendar cal = Calendar.getInstance();
            Date data = new Date(cal.getTimeInMillis());
            preparedStatement.setDate(1, data);
            preparedStatement.setDate(2, data);
            preparedStatement.setDate(3, data);
            preparedStatement.setInt(4, 10);
            preparedStatement.setInt(5, 10);
            preparedStatement.setInt(6, 10);
            preparedStatement.setInt(7, 10);
            preparedStatement.setInt(8, 10);
            preparedStatement.setInt(9, 10);
            boolean execute = preparedStatement.executeUpdate() > 0;
            if (execute) {
                preparedStatement = this.conexaoDb.prepareStatement(this.getSqlInsert());
                data = new Date(cal.getTimeInMillis());
                preparedStatement.setDate(1, data);
                preparedStatement.setDate(2, data);
                preparedStatement.setDate(3, data);
                preparedStatement.setInt(4, 10);
                preparedStatement.setInt(5, 10);
                preparedStatement.setInt(6, 10);
                preparedStatement.setInt(7, 10);
                preparedStatement.setInt(8, 10);
                preparedStatement.setInt(9, 10);
                execute = preparedStatement.executeUpdate() == 0;
            }
            return execute;
        } catch (SQLException e) {
            return true;
        }
    }

    @Override
    public String getNomeColuna() {
        return rd.getColunaUsuario();
    }
}
