package br.ufg.inf.servico;

import br.ufg.inf.stubs.InvalidImportDataExceptionStub;
import org.junit.Test;

import java.sql.Date;

public class InvalidDataTestModule {

    private String URLCONEXAO = "jdbc:postgresql://localhost:5432/teste";
    private String USUARIO = "";
    private String SENHA = "";

    private Object sut = new Object();

    //http://www.fileformat.info/tip/java/date2millis.htm

    @Test(expected = InvalidImportDataExceptionStub.class)
    private void testFailedImportBy_initialAndFinalDate() {
        Date dataInicial = new Date(1420070400000L); //01/01/15 00:00
        Date dataFinal = new Date(1451606400000L); //01/01/16 00:00
        //sut.import(dataInicial, dataFinal);
    }

    @Test(expected = InvalidImportDataExceptionStub.class)
    private void testFailedImportBy_initialAndFinalDate_withEgressesId() {
        Date dataInicial = new Date(1420070400000L); //01/01/15 00:00
        Date dataFinal = new Date(1451606400000L); //01/01/16 00:00
        //sut.import(dataInicial, dataFinal, new File("resources/EgressIDlist.txt"));
    }

    @Test(expected = InvalidImportDataExceptionStub.class)
    private void testFailedImportBy_initialAndFinalDate_withCoursesId() {
        Date dataInicial = new Date(1420070400000L); //01/01/15 00:00
        Date dataFinal = new Date(1451606400000L); //01/01/16 00:00
        //sut.import(dataInicial, dataFinal, new File("resources/CourseIDList.txt"));
    }

    @Test(expected = InvalidImportDataExceptionStub.class)
    private void testFailedImportBy_initialAndFinalDate_withAcademicUnitsId() {
        Date dataInicial = new Date(1420070400000L); //01/01/15 00:00
        Date dataFinal = new Date(1451606400000L); //01/01/16 00:00
        //sut.import(dataInicial, dataFinal, new File("resources/AcademicUnitsIDlist.txt"));
    }

    @Test(expected = InvalidImportDataExceptionStub.class)
    private void testFailedImportBy_initialAndFinalDate_withReginalsId() {
        Date dataInicial = new Date(1420070400000L); //01/01/15 00:00
        Date dataFinal = new Date(1451606400000L); //01/01/16 00:00
        //sut.import(dataInicial, dataFinal, new File("resources/RegionalsIDlist.txt"));
    }

}
