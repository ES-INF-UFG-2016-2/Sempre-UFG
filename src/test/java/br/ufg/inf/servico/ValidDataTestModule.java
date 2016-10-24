package br.ufg.inf.servico;

import org.junit.After;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

import java.sql.*;

@Ignore
public class ValidDataTestModule {

    String URLCONEXAO = "jdbc:postgresql://localhost:5432/teste";
    String USUARIO = "";
    String SENHA = "";

    private Object sut = new Object();

    //http://www.fileformat.info/tip/java/date2millis.htm

    @Test
    private void testSucessfulImportBy_initialAndFinalDate() {
        Date dataInicial = new Date(1420070400000L); //01/01/15 00:00
        Date dataFinal = new Date(1451606400000L); //01/01/16 00:00
        //sut.import(dataInicial, dataFinal);
        int [] EXPECTED = {3, 3, 3};
        int [] ACTUAL = {countImportations("egresso"), countImportations("residencia"), countImportations("localizacao_geografica")};
        Assert.assertEquals(EXPECTED, ACTUAL);
    }

    @Test
    private void testSucessfulImportBy_initialAndFinalDate_withEgressesId() {
        Date dataInicial = new Date(1420070400000L); //01/01/15 00:00
        Date dataFinal = new Date(1451606400000L); //01/01/16 00:00
        //sut.import(dataInicial, dataFinal, new File("resources/EgressIDlist.txt"));
        int [] EXPECTED = {3, 3, 3};
        int [] ACTUAL = {countImportations("egresso"), countImportations("residencia"), countImportations("localizacao_geografica")};
        Assert.assertEquals(EXPECTED, ACTUAL);
    }

    @Test
    private void testSucessfulImportBy_initialAndFinalDate_withCoursesId() {
        Date dataInicial = new Date(1420070400000L); //01/01/15 00:00
        Date dataFinal = new Date(1451606400000L); //01/01/16 00:00
        //sut.import(dataInicial, dataFinal, new File("resources/CourseIDList.txt"));
        int [] EXPECTED = {3, 3, 3};
        int [] ACTUAL = {countImportations("egresso"), countImportations("residencia"), countImportations("localizacao_geografica")};
        Assert.assertEquals(EXPECTED, ACTUAL);
    }

    @Test
    private void testSucessfulImportBy_initialAndFinalDate_withAcademicUnitsId() {
        Date dataInicial = new Date(1420070400000L); //01/01/15 00:00
        Date dataFinal = new Date(1451606400000L); //01/01/16 00:00
        //sut.import(dataInicial, dataFinal, new File("resources/AcademicUnitsIDlist.txt"));
        int [] EXPECTED = {3, 3, 3};
        int [] ACTUAL = {countImportations("egresso"), countImportations("residencia"), countImportations("localizacao_geografica")};
        Assert.assertEquals(EXPECTED, ACTUAL);
    }

    @Test
    private void testSucessfulImportBy_initialAndFinalDate_withReginalsId() {
        Date dataInicial = new Date(1420070400000L); //01/01/15 00:00
        Date dataFinal = new Date(1451606400000L); //01/01/16 00:00
        //sut.import(dataInicial, dataFinal, new File("resources/RegionalsIDlist.txt"));
        int [] EXPECTED = {3, 3, 3};
        int [] ACTUAL = {countImportations("egresso"), countImportations("residencia"), countImportations("localizacao_geografica")};
        Assert.assertEquals(EXPECTED, ACTUAL);
    }

    private int countImportations(String TABELA) {
        Connection conn = null;
        int counter = 0;
        Statement stmt;
        try {
            Class.forName("org.postgresql.Driver");
            conn = DriverManager.getConnection(
                    URLCONEXAO,
                    USUARIO,
                    SENHA);
            conn.setAutoCommit(false);
            String sql = "SELECT " + "id" + " FROM " + TABELA + "";
            stmt = conn.createStatement();
            ResultSet resultSet = stmt.executeQuery(sql);
            stmt.close();
            conn.commit();
            conn.close();
            while (resultSet.first()) {
                counter++;
            }
        } catch (ClassNotFoundException | SQLException e) {
            try {
                System.out.printf(e.toString());
                if (conn != null) {
                    conn.rollback();
                }
            } catch (SQLException e1) {
                System.out.printf(e1.toString());
            }
        }
        return counter;
    }

    @After
    private void deletePreviousTestData(){
        System.out.println("Cleaning DB for next test...");
        Connection conn = null;
        Statement stmt;
        try {
            Class.forName("org.postgresql.Driver");
            conn = DriverManager.getConnection(
                    URLCONEXAO,
                    USUARIO,
                    SENHA);
            conn.setAutoCommit(false);
            String sql = "DELETE * FROM TABELA";
            stmt = conn.createStatement();
            stmt.executeUpdate(sql);
            stmt.close();
            conn.commit();
            conn.close();
        } catch (ClassNotFoundException | SQLException e) {
            try {
                System.out.printf(e.toString());
                if (conn != null) {
                    conn.rollback();
                }
            } catch (SQLException e1) {
                System.out.printf(e1.toString());
            }
        }
    }

}
