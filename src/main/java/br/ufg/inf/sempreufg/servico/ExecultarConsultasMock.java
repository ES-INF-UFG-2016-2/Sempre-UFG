package br.ufg.inf.sempreufg.servico;

import br.ufg.inf.sempreufg.enums.Sexo;
import br.ufg.inf.sempreufg.enums.VisibilidadeDados;
import br.ufg.inf.sempreufg.modelo.Egresso;
import br.ufg.inf.sempreufg.modelo.HistoricoUFG;
import br.ufg.inf.sempreufg.modelo.LocalizacaoGeografica;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ExecultarConsultasMock {
	public List<Egresso> criarListaEgresso(){
		List<Egresso> egressos = new ArrayList<Egresso>();

		egressos.add(criarEgresso("Pablo", "Mae Pablo", Sexo.MASCULINO, VisibilidadeDados.PUBLICO));
		egressos.add(criarEgresso("Kaique", "Mae Kaique", Sexo.MASCULINO, VisibilidadeDados.PRIVADO));
		egressos.add(criarEgresso("Everton", "Mae do Everton", Sexo.MASCULINO, VisibilidadeDados.SO_EGRESSOS));

		return egressos;
	}

	public Egresso criarEgresso(String nome, String NomeMae, Sexo sexo, VisibilidadeDados visibilidadeDados){
		Egresso egresso = new Egresso(nome,
									  NomeMae,
									  new Date(),
									  sexo,
                                      "",
									  null,
									  null,
									  visibilidadeDados,
									  criarListaHistoricoUfg(),
                                                                          new LocalizacaoGeografica());
		return egresso;
	}

	private List<HistoricoUFG> criarListaHistoricoUfg() {
		return new ArrayList<HistoricoUFG>();
	}
}
