package br.ufg.inf.config;

import br.ufg.inf.enums.ComandosSQLRegistrados;
import br.ufg.inf.enums.NivelDetalheLog;
import br.ufg.inf.enums.NivelMensagensCliente;
import br.ufg.inf.enums.TipoMensagensOuComandosServidor;

import java.util.ArrayList;

public class Log {
    // Parâmetros de quando os registros de log devem ser feitos
    private NivelMensagensCliente nivelCliente;
    private TipoMensagensOuComandosServidor nivelServidor;
    private TipoMensagensOuComandosServidor tipoComandos;
    private int duracaoComando;

    // Parâmetros do quê deve ser registrado
    private NivelDetalheLog nivelDeDetalheDoLog;
    private ComandosSQLRegistrados comandoSQLRegistrado;
    private boolean registrarTentativaDeConexao;
    private boolean registrarDesconexao;
    private boolean registrarDuracaoDeComandos;
    private boolean registrarNomeDoServidor;
    private boolean registrarTimeoutDeSessao;
    private boolean registrarComandoDeReplicacao;
    private String textoDoInicioDeCadaRegistroDoLog;
    private String nomeDaAplicacao;
    private String fusoHorario;

    // Parâmetros de onde os registros de log devem estar
    private ArrayList<String> destinosDosArquivosDeLog;
    private String diretorioDosArquivosDeLog;
    private String nomeDoLog;
    private int tempoDeVida;
    private int tamanhoMaximoDoLog;

    public NivelMensagensCliente getNivelCliente() {
        return nivelCliente;
    }

    public void setNivelCliente(NivelMensagensCliente nivelCliente) {
        this.nivelCliente = nivelCliente;
    }

    public TipoMensagensOuComandosServidor getNivelServidor() {
        return nivelServidor;
    }

    public void setNivelServidor(TipoMensagensOuComandosServidor nivelServidor) {
        this.nivelServidor = nivelServidor;
    }

    public TipoMensagensOuComandosServidor getTipoComandos() {
        return tipoComandos;
    }

    public void setTipoComandos(TipoMensagensOuComandosServidor tipoComandos) {
        this.tipoComandos = tipoComandos;
    }

    public int getDuracaoComando() {
        return duracaoComando;
    }

    public void setDuracaoComando(int duracaoComando) {
        this.duracaoComando = duracaoComando;
    }

    public NivelDetalheLog getNivelDeDetalheDoLog() {
        return nivelDeDetalheDoLog;
    }

    public void setNivelDeDetalheDoLog(NivelDetalheLog nivelDeDetalheDoLog) {
        this.nivelDeDetalheDoLog = nivelDeDetalheDoLog;
    }

    public ComandosSQLRegistrados getComandoSQLRegistrado() {
        return comandoSQLRegistrado;
    }

    public void setComandoSQLRegistrado(ComandosSQLRegistrados comandoSQLRegistrado) {
        this.comandoSQLRegistrado = comandoSQLRegistrado;
    }

    public boolean isRegistrarTentativaDeConexao() {
        return registrarTentativaDeConexao;
    }

    public void setRegistrarTentativaDeConexao(boolean registrarTentativaDeConexao) {
        this.registrarTentativaDeConexao = registrarTentativaDeConexao;
    }

    public boolean isRegistrarDesconexao() {
        return registrarDesconexao;
    }

    public void setRegistrarDesconexao(boolean registrarDesconexao) {
        this.registrarDesconexao = registrarDesconexao;
    }

    public boolean isRegistrarDuracaoDeComandos() {
        return registrarDuracaoDeComandos;
    }

    public void setRegistrarDuracaoDeComandos(boolean registrarDuracaoDeComandos) {
        this.registrarDuracaoDeComandos = registrarDuracaoDeComandos;
    }

    public boolean isRegistrarNomeDoServidor() {
        return registrarNomeDoServidor;
    }

    public void setRegistrarNomeDoServidor(boolean registrarNomeDoServidor) {
        this.registrarNomeDoServidor = registrarNomeDoServidor;
    }

    public boolean isRegistrarTimeoutDeSessao() {
        return registrarTimeoutDeSessao;
    }

    public void setRegistrarTimeoutDeSessao(boolean registrarTimeoutDeSessao) {
        this.registrarTimeoutDeSessao = registrarTimeoutDeSessao;
    }

    public boolean isRegistrarComandoDeReplicacao() {
        return registrarComandoDeReplicacao;
    }

    public void setRegistrarComandoDeReplicacao(boolean registrarComandoDeReplicacao) {
        this.registrarComandoDeReplicacao = registrarComandoDeReplicacao;
    }

    public String getTextoDoInicioDeCadaRegistroDoLog() {
        return textoDoInicioDeCadaRegistroDoLog;
    }

    public void setTextoDoInicioDeCadaRegistroDoLog(String textoDoInicioDeCadaRegistroDoLog) {
        this.textoDoInicioDeCadaRegistroDoLog = textoDoInicioDeCadaRegistroDoLog;
    }

    public String getNomeDaAplicacao() {
        return nomeDaAplicacao;
    }

    public void setNomeDaAplicacao(String nomeDaAplicacao) {
        this.nomeDaAplicacao = nomeDaAplicacao;
    }

    public String getFusoHorario() {
        return fusoHorario;
    }

    public void setFusoHorario(String fusoHorario) {
        this.fusoHorario = fusoHorario;
    }

    public ArrayList<String> getDestinosDosArquivosDeLog() {
        return destinosDosArquivosDeLog;
    }

    public void setDestinosDosArquivosDeLog(ArrayList<String> destinosDosArquivosDeLog) {
        this.destinosDosArquivosDeLog = destinosDosArquivosDeLog;
    }

    public String getDiretorioDosArquivosDeLog() {
        return diretorioDosArquivosDeLog;
    }

    public void setDiretorioDosArquivosDeLog(String diretorioDosArquivosDeLog) {
        this.diretorioDosArquivosDeLog = diretorioDosArquivosDeLog;
    }

    public String getNomeDoLog() {
        return nomeDoLog;
    }

    public void setNomeDoLog(String nomeDoLog) {
        this.nomeDoLog = nomeDoLog;
    }

    public int getTempoDeVida() {
        return tempoDeVida;
    }

    public void setTempoDeVida(int tempoDeVida) {
        this.tempoDeVida = tempoDeVida;
    }

    public int getTamanhoMaximoDoLog() {
        return tamanhoMaximoDoLog;
    }

    public void setTamanhoMaximoDoLog(int tamanhoMaximoDoLog) {
        this.tamanhoMaximoDoLog = tamanhoMaximoDoLog;
    }
}
