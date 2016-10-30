package br.ufg.inf.servico;

import java.io.InputStream;
import java.util.Date;
import java.util.List;

import br.ufg.inf.modelo.Egresso;

public interface EgressoServiceInterface {
	
	public Egresso converterXmlParaEgresso(InputStream content);
	public boolean egressoEValido(Egresso egresso);
	public List<Egresso> buscarDadosEgressoViaWebService();
	public List<Egresso> buscarDadosEgressoPeloPeriodoConclusaoCurso(Date dataInicial, Date dataFinal);
	public List<Egresso> buscarDadosEgressoPeloIdentificadorEgresso(List<Integer> identificadores);
	public List<Egresso> buscarDadosEgressoPeloCurso(List<Integer> identificadores);
	public List<Egresso> buscarDadosEgressoPelaUnidadeAcademica(List<Integer> identificadores);
}
