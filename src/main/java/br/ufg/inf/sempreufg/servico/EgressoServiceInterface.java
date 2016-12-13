package br.ufg.inf.sempreufg.servico;

import br.ufg.inf.sempreufg.enums.NomeCampos;
import br.ufg.inf.sempreufg.modelo.Egresso;

import java.io.InputStream;
import java.util.Date;
import java.util.List;
import java.util.Map;

public interface EgressoServiceInterface {

    void atualizarEgresso(Egresso egresso) throws Exception;
    Egresso getEgresso(int id);
    void removerEgresso(int id) throws Exception;

    public Egresso converterXmlParaEgresso(InputStream content);
	public boolean egressoEValido(Egresso egresso);
	public List<Egresso> buscarDadosEgressoViaWebService();
	public List<Egresso> buscarDadosEgressoPeloPeriodoConclusaoCurso(Date dataInicial, Date dataFinal);
	public List<Egresso> buscarDadosEgressoPeloIdentificadorEgresso(List<Integer> identificadores);
	public List<Egresso> buscarDadosEgressoPeloCurso(List<Integer> identificadores);
	public List<Egresso> buscarDadosEgressoPelaUnidadeAcademica(List<Integer> identificadores);
    public List<Egresso> consultarEgressoPorConsultaPreDefinida(String string);
    public List<Egresso> consultaPorAdHoc(Map<NomeCampos, String> parametros);
}
