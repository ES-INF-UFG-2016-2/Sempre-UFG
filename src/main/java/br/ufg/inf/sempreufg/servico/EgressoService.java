package br.ufg.inf.sempreufg.servico;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.Date;
import java.util.List;

import br.ufg.inf.sempreufg.enums.Sexo;
import br.ufg.inf.sempreufg.enums.VisibilidadeDados;
import br.ufg.inf.sempreufg.modelo.Egresso;
import br.ufg.inf.sempreufg.modelo.HistoricoUFG;


public class EgressoService implements EgressoServiceInterface{

	@Override
	public Egresso converterXmlParaEgresso(InputStream content) {
		Egresso egresso = new Egresso();
		return egresso;
	}

	@Override
	public boolean egressoEValido(Egresso egresso) {
		return false;
	}

	@Override
	public List<Egresso> buscarDadosEgressoViaWebService() {
		return criarListaEgressoMock();
	}

	@Override
	public List<Egresso> buscarDadosEgressoPeloPeriodoConclusaoCurso(Date dataInicial, Date dataFinal) {
		return criarListaEgressoMock();
	}

	@Override
	public List<Egresso> buscarDadosEgressoPeloIdentificadorEgresso(List<Integer> identificadores) {
		return criarListaEgressoMock();
	}

	@Override
	public List<Egresso> buscarDadosEgressoPeloCurso(List<Integer> identificadores) {
		return criarListaEgressoMock();
	}

	@Override
	public List<Egresso> buscarDadosEgressoPelaUnidadeAcademica(List<Integer> identificadores) {
		return criarListaEgressoMock();
	}

	public List<Egresso> criarListaEgressoMock(){
		List<Egresso> egressos = new ArrayList<Egresso>();

		for (int i = 0; i < 10; i++) {
			Egresso egresso = new Egresso("Everton Jose",
										  "Maria",
										  new Date(),
										  Sexo.MASCULINO,
										  "emailAlternativo@gmail.com",
										  new BitSet(),
										  new BitSet(),
										  VisibilidadeDados.PUBLICO,
										  new ArrayList<HistoricoUFG>());
			egressos.add(egresso);
		}

		return egressos;
	}
}
