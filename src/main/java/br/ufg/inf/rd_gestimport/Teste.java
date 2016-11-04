package br.ufg.inf.rd_gestimport;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public abstract class Teste {

    protected RdGestImport rd;

    protected Connection conexaoDb;


    public Teste(Connection conexaoDb, RdGestImport rd) {
        this.rd = rd;
        this.conexaoDb = conexaoDb;
    }

    abstract void efetuarTestes();


    abstract String getNomeColuna();

    public boolean testeExistencia() {
        try {
            PreparedStatement preparedStatement = conexaoDb.prepareStatement(String.format("SELECT %s FROM %s", getNomeColuna(), rd.getNomeTabela()));
            preparedStatement.executeQuery();
            return true;
        } catch (SQLException e) {
            return false;
        }
    }

    protected String getSqlInsert() {
        return String.format("INSERT INTO %s (%s,%s,%s,%s,%s,%s,%s,%s,%s) VALUES (?,?,?,?,?,?,?,?,?)",
                rd.getNomeTabela(),
                rd.getColunaTimestamp(),
                rd.getColunaInicioPeriodo(),
                rd.getColunaFimPeriodo(),
                rd.getColunaQtdIncorretos(),
                rd.getColunaQtdRecebidos(),
                rd.getColunaQtdSucesso(),
                rd.getColunaQtdReplicados(),
                rd.getColunaUsuario(),
                rd.getColunaIdentificador());
    }

    protected void apagarTabela() {
        try {
            PreparedStatement preparedStatement = conexaoDb.prepareStatement(String.format("DELETE FROM %s", rd.getNomeTabela()));
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.printf(e.getMessage());
        }
    }
}
