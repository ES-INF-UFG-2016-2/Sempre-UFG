package br.ufg.inf.sempreufg.config;

import br.ufg.inf.sempreufg.enums.ComandosSQLRegistrados;
import br.ufg.inf.sempreufg.enums.NivelDetalheLog;
import br.ufg.inf.sempreufg.enums.NivelMensagensCliente;
import br.ufg.inf.sempreufg.enums.TipoMensagensOuComandosServidor;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Random;
import java.util.UUID;

import static org.junit.Assert.*;

public class LogTest {
    private Log log;

    @Before
    public void setUp(){
        log = new Log();
    }


    @Test
    public void testAlterarNivelDeMensagensEnviadasAoCliente(){
        Random random = new Random();
        int nivelAleatorio = random.nextInt(11);
        NivelMensagensCliente nivelMensagensCliente = null;

        if(nivelAleatorio == 0) nivelMensagensCliente = NivelMensagensCliente.DEBUG1;
        else if(nivelAleatorio == 1) nivelMensagensCliente = NivelMensagensCliente.DEBUG2;
        else if(nivelAleatorio == 2) nivelMensagensCliente = NivelMensagensCliente.DEBUG3;
        else if(nivelAleatorio == 3) nivelMensagensCliente = NivelMensagensCliente.DEBUG4;
        else if(nivelAleatorio == 4) nivelMensagensCliente = NivelMensagensCliente.DEBUG5;
        else if(nivelAleatorio == 5) nivelMensagensCliente = NivelMensagensCliente.LOG;
        else if(nivelAleatorio == 6) nivelMensagensCliente = NivelMensagensCliente.NOTICE;
        else if(nivelAleatorio == 7) nivelMensagensCliente = NivelMensagensCliente.WARNING;
        else if(nivelAleatorio == 8) nivelMensagensCliente = NivelMensagensCliente.ERROR;
        else if(nivelAleatorio == 9) nivelMensagensCliente = NivelMensagensCliente.FATAL;
        else if(nivelAleatorio == 10) nivelMensagensCliente = NivelMensagensCliente.PANIC;

        log.setNivelCliente(nivelMensagensCliente);

        assertEquals(log.getNivelCliente(), nivelMensagensCliente);
    }

    @Test
    public void testAlterarNivelDeMensagensEnviadasAoServidor(){
        Random random = new Random();
        int nivelAleatorio = random.nextInt(12);
        TipoMensagensOuComandosServidor tipoMensagensOuComandosServidor = retornaTipoDeComandosOuMensagensServidor(nivelAleatorio);

        log.setNivelServidor(tipoMensagensOuComandosServidor);

        assertEquals(log.getNivelServidor(), tipoMensagensOuComandosServidor);
    }

    @Test
    public void testAlterarTiposDeComandosRegistradosNoLog(){
        Random random = new Random();
        int nivelAleatorio = random.nextInt(12);
        TipoMensagensOuComandosServidor tipoDeComandosServidor = retornaTipoDeComandosOuMensagensServidor(nivelAleatorio);

        log.setTipoComandos(tipoDeComandosServidor);

        assertEquals(log.getTipoComandos(), tipoDeComandosServidor);
    }

    @Test
    public void testAlterarDuracaoDeComandosSendoRegistradosNoLog(){
        Random random = new Random();
        int duracaoAleatoria = random.nextInt();

        log.setDuracaoComando(duracaoAleatoria);

        assertEquals(log.getDuracaoComando(), duracaoAleatoria);
    }

    @Test
    public void testAlterarNivelDeDetalheDoLog(){
        Random random = new Random();
        int nivelDeDetalheAleatorio = random.nextInt(3);
        NivelDetalheLog nivelDetalheLog = null;

        if(nivelDeDetalheAleatorio == 0) nivelDetalheLog = NivelDetalheLog.DEFAULT;
        else if(nivelDeDetalheAleatorio == 1) nivelDetalheLog = NivelDetalheLog.TERSE;
        else if(nivelDeDetalheAleatorio == 2) nivelDetalheLog = NivelDetalheLog.VERBOSE;

        log.setNivelDeDetalheDoLog(nivelDetalheLog);

        Assert.assertEquals(log.getNivelDeDetalheDoLog(), nivelDetalheLog);
    }

    @Test
    public void testComandosSQLParaSeremRegistradosNoLog(){
        Random random = new Random();
        int comandosSQLAleatorios = random.nextInt(3);
        ComandosSQLRegistrados comandosSQLRegistrados = null;

        if(comandosSQLAleatorios == 0) comandosSQLRegistrados = ComandosSQLRegistrados.NONE;
        else if(comandosSQLAleatorios == 1) comandosSQLRegistrados = ComandosSQLRegistrados.MOD;
        else if(comandosSQLAleatorios == 2) comandosSQLRegistrados = ComandosSQLRegistrados.ALL;

        log.setComandoSQLRegistrado(comandosSQLRegistrados);

        Assert.assertEquals(log.getComandoSQLRegistrado(), comandosSQLRegistrados);
    }

    @Test
    public void testDefinirSeTentativaDeConexaoDeveSerRegistrada(){
        Random random = new Random();
        boolean registrarTentativaDeConexao = random.nextBoolean();

        log.setRegistrarTentativaDeConexao(registrarTentativaDeConexao);

        assertEquals(log.isRegistrarTentativaDeConexao(), registrarTentativaDeConexao);
    }

    @Test
    public void testDefinirSeDesconexaoDeveSerRegistrada(){
        Random random = new Random();
        boolean registrarDesconexao = random.nextBoolean();

        log.setRegistrarDesconexao(registrarDesconexao);

        assertEquals(log.isRegistrarDesconexao(), registrarDesconexao);
    }

    @Test
    public void testDefinirSeDuracaoDeComandoDeveSerRegistrada(){
        Random random = new Random();
        boolean registrarDuracaoDeComando = random.nextBoolean();

        log.setRegistrarDuracaoDeComandos(registrarDuracaoDeComando);

        assertEquals(log.isRegistrarDuracaoDeComandos(), registrarDuracaoDeComando);
    }

    @Test
    public void testDefinirSeNomeDoServidorDeveSerRegistrado(){
        Random random = new Random();
        boolean registrarNomeServidor = random.nextBoolean();

        log.setRegistrarNomeDoServidor(registrarNomeServidor);

        assertEquals(log.isRegistrarNomeDoServidor(), registrarNomeServidor);
    }

    @Test
    public void testDefinirSeTimeoutDeSessaoDeveSerRegistrado(){
        Random random = new Random();
        boolean timeoutDeSessao = random.nextBoolean();

        log.setRegistrarTimeoutDeSessao(timeoutDeSessao);

        assertEquals(log.isRegistrarTimeoutDeSessao(), timeoutDeSessao);
    }

    @Test
    public void testDefinirSeComandoDeReplicacaoDeveSerRegistrado(){
        Random random = new Random();
        boolean comandoDeReplicacao = random.nextBoolean();

        log.setRegistrarComandoDeReplicacao(comandoDeReplicacao);

        assertEquals(log.isRegistrarComandoDeReplicacao(), comandoDeReplicacao);
    }

    @Test
    public void testDefinirTextoInicialDeCadaRegistro(){
        String textoInicial = UUID.randomUUID().toString();

        log.setTextoDoInicioDeCadaRegistroDoLog(textoInicial);

        assertEquals(log.getTextoDoInicioDeCadaRegistroDoLog(), textoInicial);
    }

    @Test
    public void testDefinirNomeDaAplicacao(){
        String nomeAplicacao = UUID.randomUUID().toString();

        log.setNomeDaAplicacao(nomeAplicacao);

        assertEquals(log.getNomeDaAplicacao(), nomeAplicacao);
    }

    @Test
    public void testDefinirFusoHorario(){
        String fusoHorario = UUID.randomUUID().toString();

        log.setFusoHorario(fusoHorario);

        assertEquals(log.getFusoHorario(), fusoHorario);
    }

    @Test
    public void testDefinirDestinosDosArquivosDeLog(){
        Random random = new Random();
        int quantidadeDeDestinos = random.nextInt(30);
        ArrayList<String> destinos = new ArrayList<String>();

        for(int i = 0; i < quantidadeDeDestinos; i++){
            destinos.add(UUID.randomUUID().toString());
        }

        log.setDestinosDosArquivosDeLog(destinos);

        assertTrue(verificarDestinos(destinos, log.getDestinosDosArquivosDeLog()));
    }

    @Test
    public void testDefinirNomeDoLog(){
        String nomeDoLog = UUID.randomUUID().toString();

        log.setNomeDoLog(nomeDoLog);

        assertEquals(log.getNomeDoLog(), nomeDoLog);
    }

    @Test
    public void testDefinirTempoDeVida(){
        Random random = new Random();
        int tempoDeVida = random.nextInt();

        log.setTempoDeVida(tempoDeVida);

        assertEquals(log.getTempoDeVida(), tempoDeVida);
    }

    @Test
    public void testDefinirDiretorioDosArquivosDoLog(){
        String diretorioDosArquivosDeLog = UUID.randomUUID().toString();

        log.setDiretorioDosArquivosDeLog(diretorioDosArquivosDeLog);

        assertEquals(log.getDiretorioDosArquivosDeLog(), diretorioDosArquivosDeLog);
    }

    @Test
    public void testDefinirTamanhoMaximoDoLog(){
        Random random = new Random();
        int tamanhoMaximoDoLog = random.nextInt();

        log.setTamanhoMaximoDoLog(tamanhoMaximoDoLog);

        assertEquals(log.getTamanhoMaximoDoLog(), tamanhoMaximoDoLog);
    }

    /** MÉTODOS DE AUXÍLIO DOS TESTES **/
    public TipoMensagensOuComandosServidor retornaTipoDeComandosOuMensagensServidor(int nivelAleatorio){
        if(nivelAleatorio == 0) return TipoMensagensOuComandosServidor.DEBUG1;
        else if(nivelAleatorio == 1) return TipoMensagensOuComandosServidor.DEBUG2;
        else if(nivelAleatorio == 2) return TipoMensagensOuComandosServidor.DEBUG3;
        else if(nivelAleatorio == 3) return TipoMensagensOuComandosServidor.DEBUG4;
        else if(nivelAleatorio == 4) return TipoMensagensOuComandosServidor.DEBUG5;
        else if(nivelAleatorio == 5) return TipoMensagensOuComandosServidor.LOG;
        else if(nivelAleatorio == 6) return TipoMensagensOuComandosServidor.NOTICE;
        else if(nivelAleatorio == 7) return TipoMensagensOuComandosServidor.WARNING;
        else if(nivelAleatorio == 8) return TipoMensagensOuComandosServidor.ERROR;
        else if(nivelAleatorio == 9) return TipoMensagensOuComandosServidor.FATAL;
        else if(nivelAleatorio == 10) return TipoMensagensOuComandosServidor.PANIC;
        else if(nivelAleatorio == 11) return TipoMensagensOuComandosServidor.INFO;
        else return null;
    }

    public boolean verificarDestinos(ArrayList<String> original, ArrayList<String> adicionado){
        for(int i = 0; i< original.size(); i++){
            if(!original.get(i).equals(adicionado.get(i))) return false;
        }
        return true;
    }


}
