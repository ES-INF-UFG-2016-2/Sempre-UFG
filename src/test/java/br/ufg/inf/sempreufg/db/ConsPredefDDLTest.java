package br.ufg.inf.sempreufg.db;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

import java.sql.*;

@Ignore
public class ConsPredefDDLTest {

    private String URLCONEXAO = "jdbc:mysql://localhost:3306/sempreUFG";
    private String USUARIO = "";
    private String SENHA = "";

    private Object sut = new Object();

    @Test
    private void testQueryMetadataTableDDL() {
        runQuery("");
        Assert.assertEquals(1, countQueryMetadata("query_metadata", "id"));
        try {
            Connection con = DriverManager.getConnection(URLCONEXAO, USUARIO, SENHA);

            ResultSet rs = con.getMetaData().getCatalogs();

            while (rs.next()) {
                System.out.println("TABLE_CAT = " + rs.getString("TABLE_CAT") );
                //TODO compare result set actual table_cat values to ddl oracle values.
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void runQuery(String ddlQuery) {
        try {
            Connection  connection = DriverManager.getConnection(URLCONEXAO, USUARIO, SENHA);
            Statement stmt = connection.createStatement();
            stmt.executeUpdate(ddlQuery);
            stmt.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test
    private void testSucessfulQueryMetadataPersistence() {
        //sut.saveQueryMetada(QueryMetadata object);
        Assert.assertEquals(1, countQueryMetadata("query_metadata", "id"));
    }

    private int countQueryMetadata(String TABLE_NAME, String IDENTIFIER_NAME) {
        Connection connection = null;
        int counter = 0;
        Statement stmt;
        try {
            connection = DriverManager.getConnection(URLCONEXAO, USUARIO, SENHA);
            connection.setAutoCommit(false);
            stmt = connection.createStatement();
            String sql = "SELECT " + IDENTIFIER_NAME + " FROM " + TABLE_NAME + ";";
            ResultSet resultSet = stmt.executeQuery(sql);
            stmt.close();
            connection.commit();
            connection.close();
            while (resultSet.first()) {
                counter++;
            }
        } catch (SQLException e) {
            System.out.printf(e.toString());
            if (connection != null) {
                try {
                    connection.rollback();
                } catch (SQLException e1) {
                    System.out.printf(e1.toString());
                }
            }
        }
        return counter;
    }

}
