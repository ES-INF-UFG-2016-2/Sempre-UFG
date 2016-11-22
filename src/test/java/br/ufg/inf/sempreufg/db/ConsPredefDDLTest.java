package br.ufg.inf.db;

import br.ufg.inf.stubs.ConsPredefDAOStub;
import br.ufg.inf.stubs.ConsPredefStub;
import org.junit.Assert;
import org.junit.Test;

import java.io.*;
import java.sql.*;

public class ConsPredefDDLTest {

    private String sysBar = System.getProperty("file.separator");
    private String URLCONEXAO = "jdbc:mysql://localhost:3306/sempreufg";
    private String DDLPath = "db" + sysBar + "ddl" + sysBar + "RD-ConsPredef.sql";
    private String USUARIO = "root";
    private String SENHA = "root";

    private ConsPredefDAOStub sut = new ConsPredefDAOStub();

    @Test
    public void testQueryMetadataTableDDL() throws IOException {
        runQuery(DDLPath);
        try {
            Connection con = DriverManager.getConnection(URLCONEXAO, USUARIO, SENHA);

            ResultSet rs = con.getMetaData().getCatalogs();

            while (rs.next()) {
                System.out.println("TABLE_CAT = " + rs.getString("TABLE_CAT") );
                //TODO compare and assert actual table_cat values to expected values. Still to do because the DDL script doesn't work.
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void runQuery(String ddlPath) throws IOException {

        StringBuilder fileData = new StringBuilder();
        BufferedReader reader = new BufferedReader(new FileReader(new File(ddlPath)));
        char[] buf = new char[1024];
        int numRead;

        while((numRead = reader.read(buf)) != -1){
            String readData = String.valueOf(buf, 0, numRead);
            fileData.append(readData);
        }

        reader.close();

        try {
            Connection  connection = DriverManager.getConnection(URLCONEXAO, USUARIO, SENHA);
            Statement stmt = connection.createStatement();
            stmt.addBatch(fileData.toString());
            stmt.executeBatch();
            stmt.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testSucessfulQueryMetadataPersistence() {
        ConsPredefStub cps = new ConsPredefStub("", "", false, new Date(0L), new Date(0L), "");
        sut.saveQueryMetada(cps);// does nothing because its a plcaholder for the real thing.
        //Assert.assertEquals(1, countQueryMetadata("CONSPREDEF", "id"));
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