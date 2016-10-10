package test;

import main.InvalidImportDataException;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Date;

public class ReportTestModule {

    private Object sut = new Object();
    private String PATH_TO_REPORTS = "";
    private String REPORT_NAME = "";

    //http://www.fileformat.info/tip/java/date2millis.htm

    @Test
    private void testSucessfulReportBy_initialAndFinalDate() throws IOException {
        Date dataInicial = new Date(1420070400000L); //01/01/15 00:00
        Date dataFinal = new Date(1451606400000L); //01/01/16 00:00
        sut.import(dataInicial, dataFinal);
        Assert.assertEquals(readReportAsString(REPORT_NAME), readReportAsString("OracleReport1.txt"));
    }

    @Test
    private void testSucessfulReportBy_initialAndFinalDate_withEgressesId() throws IOException {
        Date dataInicial = new Date(1420070400000L); //01/01/15 00:00
        Date dataFinal = new Date(1451606400000L); //01/01/16 00:00
        sut.import(dataInicial, dataFinal, new File("resources/EgressIDlist.txt"));
        Assert.assertEquals(readReportAsString(REPORT_NAME), readReportAsString("OracleReport2.txt"));
    }

    @Test
    private void testSucessfulReportBy_initialAndFinalDate_withCoursesId() throws IOException {
        Date dataInicial = new Date(1420070400000L); //01/01/15 00:00
        Date dataFinal = new Date(1451606400000L); //01/01/16 00:00
        sut.import(dataInicial, dataFinal, new File("resources/CourseIDList.txt"));
        Assert.assertEquals(readReportAsString(REPORT_NAME), readReportAsString("OracleReport3.txt"));
    }

    @Test
    private void testSucessfulReportBy_initialAndFinalDate_withAcademicUnitsId() throws IOException {
        Date dataInicial = new Date(1420070400000L); //01/01/15 00:00
        Date dataFinal = new Date(1451606400000L); //01/01/16 00:00
        sut.import(dataInicial, dataFinal, new File("resources/AcademicUnitsIDlist.txt"));
        Assert.assertEquals(readReportAsString(REPORT_NAME), readReportAsString("OracleReport4.txt"));
    }

    @Test
    private void testSucessfulReportBy_initialAndFinalDate_withReginalsId() throws IOException {
        Date dataInicial = new Date(1420070400000L); //01/01/15 00:00
        Date dataFinal = new Date(1451606400000L); //01/01/16 00:00
        sut.import(dataInicial, dataFinal, new File("resources/RegionalsIDlist.txt"));
        Assert.assertEquals(readReportAsString(REPORT_NAME), readReportAsString("OracleReport5.txt"));
    }

    @Test(expected = InvalidImportDataException.class)
    private void testFailedReportBy_initialAndFinalDate() throws IOException {
        Date dataInicial = new Date(1420070400000L); //01/01/15 00:00
        Date dataFinal = new Date(1451606400000L); //01/01/16 00:00
        sut.import(dataInicial, dataFinal);
        Assert.assertEquals(readReportAsString(REPORT_NAME), readReportAsString("OracleReport6.txt"));
    }

    @Test(expected = InvalidImportDataException.class)
    private void testFailedReportBy_initialAndFinalDate_withEgressesId() throws IOException {
        Date dataInicial = new Date(1420070400000L); //01/01/15 00:00
        Date dataFinal = new Date(1451606400000L); //01/01/16 00:00
        sut.import(dataInicial, dataFinal, new File("resources/EgressIDlist.txt"));
        Assert.assertEquals(readReportAsString(REPORT_NAME), readReportAsString("OracleReport7.txt"));
    }

    @Test(expected = InvalidImportDataException.class)
    private void testFailedReportBy_initialAndFinalDate_withCoursesId() throws IOException {
        Date dataInicial = new Date(1420070400000L); //01/01/15 00:00
        Date dataFinal = new Date(1451606400000L); //01/01/16 00:00
        sut.import(dataInicial, dataFinal, new File("resources/CourseIDList.txt"));
        Assert.assertEquals(readReportAsString(REPORT_NAME), readReportAsString("OracleReport8.txt"));
    }

    @Test(expected = InvalidImportDataException.class)
    private void testFailedReportBy_initialAndFinalDate_withAcademicUnitsId() throws IOException {
        Date dataInicial = new Date(1420070400000L); //01/01/15 00:00
        Date dataFinal = new Date(1451606400000L); //01/01/16 00:00
        sut.import(dataInicial, dataFinal, new File("resources/AcademicUnitsIDlist.txt"));
        Assert.assertEquals(readReportAsString(REPORT_NAME), readReportAsString("OracleReport9.txt"));
    }

    @Test(expected = InvalidImportDataException.class)
    private void testFailedReportBy_initialAndFinalDate_withReginalsId() throws IOException {
        Date dataInicial = new Date(1420070400000L); //01/01/15 00:00
        Date dataFinal = new Date(1451606400000L); //01/01/16 00:00
        sut.import(dataInicial, dataFinal, new File("resources/RegionalsIDlist.txt"));
        Assert.assertEquals(readReportAsString(REPORT_NAME), readReportAsString("OracleReport10.txt"));
    }
    
    @After
    private void eraseReport(){
        File[] files = new File(PATH_TO_REPORTS).listFiles();
        if(files != null) {
            for(File f : files) {
                f.delete();
            }
        }
    }

    private String readReportAsString(String fileName) throws IOException {
        return new String(Files.readAllBytes(Paths.get("fileName")));
    }

}
