package br.ufg.inf.servico;

import br.ufg.inf.modelo.Noticia;
import java.util.Date;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Matheus Cardoso Duarte Santos
 */
public class DivulgadorNoticiasServiceTest {

    private int idEvento = 1651681;

    public DivulgadorNoticiasServiceTest() {
    }

    /**
     * Test of divulgarNoticia method, of class DivulgadorNoticiasService.
     */
    @Test
    public void testDivulgarNoticia() {
        int idEvento = this.idEvento;
        Date dataExpiracao = null;
        DivulgadorNoticiasService instance = new DivulgadorNoticiasService();
        boolean expResult = true;
        boolean result = instance.divulgarNoticia(idEvento, dataExpiracao);
        List<Noticia> noticias = instance.getNoticias();
        boolean achou = false;
        for (int i = 0; i < noticias.size(); i++) {
            if (noticias.get(i).getIdEvento() == idEvento) {
                achou = true;
            } else {
                achou = false;
            }
        }
        assertEquals("A noticia não foi divulgada", true, achou);
        assertEquals("O teste falhou! Não foi possivel divulgar a noticia",
                expResult, result);
    }

    /**
     * Test of divulgarNoticia method, of class DivulgadorNoticiasService.
     */
    @Test
    public void testDivulgarNoticiaRepetida() {
        int idEvento = this.idEvento;
        Date dataExpiracao = null;
        DivulgadorNoticiasService instance = new DivulgadorNoticiasService();
        boolean result = instance.divulgarNoticia(idEvento, dataExpiracao);
        List<Noticia> noticias = instance.getNoticias();
        boolean achou = false;
        for (int i = 0; i < noticias.size(); i++) {
            if (noticias.get(i).getIdEvento() == idEvento) {
                achou = true;
            } else {
                achou = false;
            }
        }
        assertEquals("A noticia não foi divulgada", true, achou);
        result = instance.divulgarNoticia(idEvento, dataExpiracao);
        int contador = 0;
        for (int i = 0; i < noticias.size(); i++) {
            if (noticias.get(i).getIdEvento() == idEvento) {
                contador++;
            }
        }
        assertTrue("Adicionando noticias repetidas", contador == 1);
        assertEquals("O teste falhou! Não foi possivel divulgar a noticia",
                false, result);

    }

    /**
     * Test of removerNoticiasExpiradas method, of class
     * DivulgadorNoticiasService.
     */
    @Test
    public void testRemoverNoticiasExpiradas() {
        int idEvento = this.idEvento;
        Date dataExpiracao = new Date(System.currentTimeMillis()-10);
        System.out.println(dataExpiracao.getTime() + "DAta 1");
        DivulgadorNoticiasService instance = new DivulgadorNoticiasService();
        instance.divulgarNoticia(idEvento, dataExpiracao);
        List<Noticia> noticias = instance.getNoticias();
        boolean achou = false;
        
        for (int i = 0; i < noticias.size(); i++) {
            if (noticias.get(i).getIdEvento() == idEvento) {
                achou = true;
            }
        }
        assertEquals("A noticia não foi divulgada", true, achou);
        instance.removerNoticiasExpiradas();
        achou = false;
        
        for (int i = 0; i < noticias.size(); i++) {
            if (noticias.get(i).getIdEvento() == idEvento) {
                achou = true;
            }
        }
        assertEquals("A noticia não foi removida", false, achou);
    }

}
