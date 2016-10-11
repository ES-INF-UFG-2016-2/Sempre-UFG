package br.ufg.inf.stubs;

/**
 * Created by Leonardo on 09/10/2016.
 */
public class EgressoDAOStub {

	private static EgressoStub egresso;

	public static void adicionarEgresso(EgressoStub novoEgresso){
		egresso = novoEgresso;
	}

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
        egresso.mudarId(id);
	}

	public static void removeEgresso(String id){
		egresso = null;
	}


}
