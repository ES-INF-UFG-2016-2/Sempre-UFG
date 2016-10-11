package br.ufg.inf;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Date;

import static org.junit.Assert.assertEquals;

public class AtualEgresTest {

	@Before
	public void adicionaEgressoDeTeste(){
		EgressoDAOStub.adicionarEgresso(new EgressoStub("alunoa-uuid", "Aluno A", "Mãe do Aluno A", new Date(), "Masc/Fem", "alunoA@emailalternativo.com", "publico"));
	}

	@After
	public void removeEgressoDeTeste(){
		EgressoDAOStub.removeEgresso("alunoa-uuid");
	}

	@Test(expected = IdentificadorNaoEncontradoStub.class)
	public void testIdentificadorInvalido(){
		String identificador = "aluno-a-uuid";
		EgressoStub novosDados = new EgressoStub("Aluno A", "Mãe do Aluno A", new Date(), "Masc/Fem", "alunoA@emailalternativo.com", "publico");
		EgressoDAOStub.modificaEgresso(identificador, novosDados);
	}

	@Test
	public void testIdentificadorValido(){
		String identificador = "alunoa-uuid";
		EgressoStub novosDados = new EgressoStub("Aluno A Sobrenome B", "Mãe do Aluno A Sobrenome B", new Date(), "Masc", "alunoAdiferente@emailalternativo.com", "privado");
		EgressoDAOStub.modificaEgresso(identificador, novosDados);
		assertEquals(novosDados, EgressoDAOStub.recuperarEgresso(identificador));
	}
}
