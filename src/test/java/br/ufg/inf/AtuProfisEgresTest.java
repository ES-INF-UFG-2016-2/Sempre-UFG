import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class AtuProfisEgresTest {

    @Test
    public void testInserirDataInicioCorreta() {

        int data = 20122012;
        boolean inserido = true;

        AtuProfisEgres atuProfisEgres = new AtuProfisEgres();
        assertEquals(inserido, atuProfisEgres.inserirDataInicio(data));
    }

    @Test
    public void testInserirDataInicioIncorreta() {

        int data = -40;
        boolean inserido = false;

        AtuProfisEgres atuProfisEgres = new AtuProfisEgres();
        assertEquals(inserido, atuProfisEgres.inserirDataInicio(data));
    }

    @Test
    public void testInserirDataInicioIncorreta2() {

        int data = 0;
        boolean inserido = false;

        AtuProfisEgres atuProfisEgres = new AtuProfisEgres();
        assertEquals(inserido, atuProfisEgres.inserirDataInicio(data));
    }

    @Test
    public void testInserirDataFimCorreta() {

        int data = 20122012;
        boolean inserido = true;

        AtuProfisEgres atuProfisEgres = new AtuProfisEgres();
        assertEquals(inserido, atuProfisEgres.inserirDataFim(data));
    }

    @Test
    public void testInserirDataFimIncorreta() {

        int data = -32;
        boolean inserido = false;

        AtuProfisEgres atuProfisEgres = new AtuProfisEgres();
        assertEquals(inserido, atuProfisEgres.inserirDataFim(data));
    }

    @Test
    public void testInserirFormaIngressoCorreta() {

        String forma = "Concurso";
        boolean inserido = true;

        AtuProfisEgres atuProfisEgres = new AtuProfisEgres();
        assertEquals(inserido, atuProfisEgres.inserirFormaIngresso(forma));
    }

    @Test
    public void testInserirFormaIngressoIncorreta() {

        String forma = "";
        boolean inserido = false;

        AtuProfisEgres atuProfisEgres = new AtuProfisEgres();
        assertEquals(inserido, atuProfisEgres.inserirFormaIngresso(forma));
    }

    @Test
    public void testInserirRendaMensalMediaCorreta() {

        float renda = (float) 880.90;
        boolean inserido = true;

        AtuProfisEgres atuProfisEgres = new AtuProfisEgres();
        assertEquals(inserido, atuProfisEgres.inserirRendaMensaMedia(renda));
    }

    @Test
    public void testInserirRendaMensalMediaIncorreta() {

        float renda = (float) -3;
        boolean inserido = false;

        AtuProfisEgres atuProfisEgres = new AtuProfisEgres();
        assertEquals(inserido, atuProfisEgres.inserirRendaMensaMedia(renda));
    }

    @Test
    public void testInserirSatisfacaoComRendaCorreta() {

        int satisfacao = 5;
        boolean inserido = true;

        AtuProfisEgres atuProfisEgres = new AtuProfisEgres();
        assertEquals(inserido, atuProfisEgres.inserirSatisfacaoComRenda(satisfacao));
    }

    @Test
    public void testInserirSatisfacaoComRendaIncorreta() {

        int satisfacao = -2;
        boolean inserido = false;

        AtuProfisEgres atuProfisEgres = new AtuProfisEgres();
        assertEquals(inserido, atuProfisEgres.inserirSatisfacaoComRenda(satisfacao));
    }

    @Test
    public void testInserirPerspectivaFuturoCorreta() {

        int perspectiva = 5;
        boolean inserido = true;

        AtuProfisEgres atuProfisEgres = new AtuProfisEgres();
        assertEquals(inserido, atuProfisEgres.inserirPerspectivaFuturo(perspectiva));
    }

    @Test
    public void testInserirPerspectivaFuturoIncorreta() {

        int perspectiva = 12;
        boolean inserido = false;

        AtuProfisEgres atuProfisEgres = new AtuProfisEgres();
        assertEquals(inserido, atuProfisEgres.inserirPerspectivaFuturo(perspectiva));
    }

    @Test
    public void testInserirComentarioCorreto() {

        String comentario = "Muito bom";
        boolean inserido = true;

        AtuProfisEgres atuProfisEgres = new AtuProfisEgres();
        assertEquals(inserido, atuProfisEgres.inserirComentario(comentario));
    }

    @Test
    public void testInserirComentarioIncorreto() {

        String comentario = "";
        boolean inserido = false;

        AtuProfisEgres atuProfisEgres = new AtuProfisEgres();
        assertEquals(inserido, atuProfisEgres.inserirComentario(comentario));
    }
}
