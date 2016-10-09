package java.br.ufg.inf;

import java.util.Date;

/**
 * Created by Leonardo on 09/10/2016.
 */
public class EgressoDAOStub {

	private static EgressoStub egresso = new EgressoStub("Aluno A Sobrenome B", "Mãe do Aluno A Sobrenome B", new Date(), "Masc", "alunoAdiferente@emailalternativo.com", "privado");

	public static EgressoStub recuperarEgresso(String id){
		if (id.equals(egresso.pegarId())){
			return egresso;
		}
		else{
			throw new IdentificadorNaoEncontradoStub();
		}
	}

	public static void modificaEgresso(String id, EgressoStub novosDados){
		EgressoStub egressoNoBanco = recuperarEgresso(id);
		egresso = novosDados;
	}


}
