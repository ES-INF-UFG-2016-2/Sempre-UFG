package br.ufg.inf.rd_gestimport;

import java.sql.*;
import java.util.Calendar;


public class TesteImportadosComSucesso extends Teste {


    public TesteImportadosComSucesso(Connection conexaoDb, RdGestImport rd) {
        super(conexaoDb, rd);
    }

    public void efetuarTestes() {
        System.out.println(String.format("Testando coluna %s...", rd.getColunaQtdSucesso()));
        apagarTabela();
        System.out.print("Testando obrigatóriedade...");
        if (this.testeDeObrigatoriedade()) {
            System.out.println("Ok");
        } else {
            System.out.println("Falhou");
        }
        apagarTabela();
        System.out.print("Testando inserção correta...");
        if (this.testeDeInsercaoCorreta()) {
            System.out.println("Ok");
        } else {
            System.out.println("Falhou");
        }
        apagarTabela();
        System.out.print("Testando inserção incorreta...");
        if (this.testeDeInsercaoIncorreta()) {
            System.out.println("Ok");
        } else {
            System.out.println("Falhou");
        }
    }

    @Override
    public String getNomeColuna() {
        return rd.getColunaQtdSucesso();
    }

    private boolean testeDeObrigatoriedade() {
        try {
            PreparedStatement preparedStatement = this.conexaoDb.prepareStatement(getSqlInsert());
            Calendar cal = Calendar.getInstance();
            preparedStatement.setDate(1, new Date(cal.getTimeInMillis()));
            preparedStatement.setDate(2, new Date(cal.getTimeInMillis()));
            preparedStatement.setDate(3, new Date(cal.getTimeInMillis()));
            preparedStatement.setInt(4, 10);
            preparedStatement.setInt(5, 10);
            preparedStatement.setNull(6, Types.INTEGER);
            preparedStatement.setInt(7, 10);
            preparedStatement.setInt(8, 10);
            preparedStatement.setInt(9, 10);
            boolean execute = preparedStatement.executeUpdate() > 0;
            return !execute;
        } catch (SQLException e) {
            return true;
        }
    }

    private boolean testeDeInsercaoCorreta() {
        try {
            PreparedStatement preparedStatement = this.conexaoDb.prepareStatement(getSqlInsert());
            Calendar cal = Calendar.getInstance();
            preparedStatement.setDate(1, new Date(cal.getTimeInMillis()));
            preparedStatement.setDate(2, new Date(cal.getTimeInMillis()));
            preparedStatement.setDate(3, new Date(cal.getTimeInMillis()));
            preparedStatement.setInt(4, 10);
            preparedStatement.setInt(5, 10);
            preparedStatement.setInt(6, 10);
            preparedStatement.setInt(7, 10);
            preparedStatement.setInt(8, 10);
            preparedStatement.setInt(9, 10);
            return preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    private boolean testeDeInsercaoIncorreta() {
        try {
            PreparedStatement preparedStatement = this.conexaoDb.prepareStatement(this.getSqlInsert());
            Calendar cal = Calendar.getInstance();
            preparedStatement.setDate(1, new Date(cal.getTimeInMillis()));
            preparedStatement.setDate(2, new Date(cal.getTimeInMillis()));
            preparedStatement.setDate(3, new Date(cal.getTimeInMillis()));
            preparedStatement.setInt(4, 10);
            preparedStatement.setInt(5, 10);
            preparedStatement.setString(6, "INCORRETO");
            preparedStatement.setInt(7, 10);
            preparedStatement.setInt(8, 10);
            preparedStatement.setInt(9, 10);
            return preparedStatement.executeUpdate() == 0;
        } catch (SQLException e) {
            return true;
        }
    }

}
