package java.br.ufg.inf;

import org.junit.Test;

import java.util.Date;

import static org.junit.Assert.assertEquals;

public class AtualEgresTest {


	@Test(expected = IdentificadorNaoEncontradoStub.class)
	public void testIdentificadorInvalido(){
		String identificador = "aluno-a-uuid";
		EgressoStub novosDados = new EgressoStub("alunoa-uuid", "Aluno A", "Mãe do Aluno A", new Date(), "Masc/Fem", "alunoA@emailalternativo.com", "publico");
		EgressoDAOStub.modificaEgresso(identificador, novosDados);
	}

	@Test
	public void testIdentificadorValido(){
		String identificador = "alunoa-uuid";
		EgressoStub novosDados = new EgressoStub("alunoa-uuid", "Aluno A", "Mãe do Aluno A", new Date(), "Masc/Fem", "alunoA@emailalternativo.com", "publico");
		EgressoDAOStub.modificaEgresso(identificador, novosDados);
		assertEquals(novosDados, EgressoDAOStub.recuperarEgresso(identificador));
	}
}