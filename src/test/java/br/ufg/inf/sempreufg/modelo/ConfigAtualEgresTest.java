package br.ufg.inf.sempreufg.modelo;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Test;

import br.ufg.inf.modelo.Atributo;
import br.ufg.inf.modelo.Entidade;

public class ConfigAtualEgresTest extends BaseConfigAtualEgres {

	/**
	 * A estrutura se diz valida quando somente uma delas
	 * tem o antecessor null e nao podem ter mais de um antecessor em comum
	 * ex. se existir 2 entidades com o mesmo antecessor seria uma estrutura invalida
	 * @throws Exception
	 */
	@Test
	public void testaEstruturaEntidade() throws Exception{
		// Testa com uma estrutura valida
		List<Entidade> entidades = entidadesJSONTOEntidade(retornaEntradaEntidadeAtributoJSONValido());

		List<Integer> referenciasAntecessoras= new ArrayList();
		for(Entidade entidade: entidades){
			referenciasAntecessoras.add(entidade.getAntecessor());
		}

		for(Integer referencia : referenciasAntecessoras){
			if(Collections.frequency(referenciasAntecessoras, referencia) >1){
				throw new Exception("Nao pode haver mais de uma entidade com o mesmo antecessor");
			}
		}
	}

	@Test
	public void testaEstruturaAtributo() throws Exception{
		// Testa com uma estrutura valida
		List<Entidade> entidades = entidadesJSONTOEntidade(retornaEntradaEntidadeAtributoJSONValido());

		List<Integer> referenciasAntecessoras= new ArrayList();
		for(Entidade entidade: entidades){
			for(Atributo atributo : entidade.getAtributos()){
				referenciasAntecessoras.add(atributo.getAntecessor());
			}

			for(Integer referencia : referenciasAntecessoras){
				if(Collections.frequency(referenciasAntecessoras, referencia) >1){
					throw new Exception("Nao pode haver mais de um atributo com o mesmo antecessor");
				}
			}

			referenciasAntecessoras.clear();
		}
	}

	@Test
	public void testaEstruturaAtributoInvalido() throws Exception{
		// Testa com uma estrutura valida
		List<Entidade> entidades = entidadesJSONTOEntidade(retornaEntradaEntidadeAtributoJSONInValido());

		List<Integer> referenciasAntecessoras= new ArrayList();
		for(Entidade entidade: entidades){
			for(Atributo atributo : entidade.getAtributos()){
				referenciasAntecessoras.add(atributo.getAntecessor());
			}

			for(Integer referencia : referenciasAntecessoras){
				try{
					if(Collections.frequency(referenciasAntecessoras, referencia) >1){
						throw new Exception("Nao pode haver mais de um atributo com o mesmo antecessor");
					}
				}catch (Exception e) {
					assertEquals(e.getMessage(), "Nao pode haver mais de um atributo com o mesmo antecessor");
				}

			}

			referenciasAntecessoras.clear();
		}
	}

	@Test
	public void testaEstruturaEntidadeInvalida() throws Exception{
		// Testa com uma estrutura invalida
		List<Entidade> entidades = entidadesJSONTOEntidade(retornaEntradaEntidadeAtributoJSONInValido());

		List<Integer> referenciasAntecessoras= new ArrayList();
		for(Entidade entidade: entidades){
			referenciasAntecessoras.add(entidade.getAntecessor());
		}

		for(Integer referencia : referenciasAntecessoras){
			try{
				if(Collections.frequency(referenciasAntecessoras, referencia) >1){
					throw new Exception("Nao pode haver mais de uma entidade com o mesmo antecessor");
				}
			}catch(Exception e){
				assertEquals(e.getMessage(), "Nao pode haver mais de uma entidade com o mesmo antecessor");
			}
		}
	}

	@Test
	public void testaPersistirConfiguracaoEntidadeAtributo() throws Exception{
		List<Entidade> entidades = entidadesJSONTOEntidade(retornaEntradaEntidadeAtributoJSONValido());

		Integer ultimoIdEntidade = null;
		for(Entidade entidade: entidades){
			entidade.setAntecessor(ultimoIdEntidade);
			ultimoIdEntidade = inserirEntidade(entidade);

			Integer ultimoIdAtributo = null;
			for(Atributo atributo : entidade.getAtributos()){
				atributo.setEntidade(ultimoIdEntidade);

				atributo.setAntecessor(ultimoIdAtributo);
				ultimoIdAtributo = inserirAtributo(atributo);
			}
		};


		List<Entidade> entidadesInseridas = listarTodasEntidades();

		assertEquals(3, entidadesInseridas.size());

		int counterEntidade = 1;
		for(Entidade entidadeConsultada : entidadesInseridas){
			assertEquals("Entidade " + counterEntidade, entidadeConsultada.getNome());

			List<Atributo> atributos = listarTodosAtributos(entidadeConsultada.getId());

			for(int i = 0 ; i < atributos.size() ; i ++ ){
				assertEquals("Atributo " + (i+1), atributos.get(i).getNome());
				assertEquals(atributos.get(i).getEntidade(), entidadeConsultada.getId());

				if(i == 0){
					assertEquals(new Integer(0), atributos.get(i).getAntecessor());
				}else{
					try {
						assertEquals(atributos.get(i).getAntecessor(), atributos.get(i-1).getId());
					} catch (IndexOutOfBoundsException e) {
						// para fins de testes
					}
				}

			}
			assertEquals(3, atributos.size());

			counterEntidade++;
		}
	}

	/**
	 * Somente uma entidade pode ter o antecessor vazio ou null( primeira questao )
	 */
	@Test
	public void testaEntidadeAntecessorValidoNull(){
		List<Entidade> listaEntidades = new ArrayList();

		Entidade entidade1 = new Entidade();
		Entidade entidade2 = new Entidade();
		Entidade entidade3 = new Entidade();
		Entidade entidade4 = new Entidade();

		entidade1.setAntecessor(null);
		entidade2.setAntecessor(1);
		entidade3.setAntecessor(3);
		entidade4.setAntecessor(5);

		int qualidadeEntidadeAntecessorasNullas = 0;

		listaEntidades.add(entidade1);
		listaEntidades.add(entidade2);
		listaEntidades.add(entidade3);
		listaEntidades.add(entidade4);

		for(Entidade entidade :listaEntidades){
			try{
				if(entidade.getAntecessor().equals(null)){

				}
			}catch (NullPointerException e) {
				qualidadeEntidadeAntecessorasNullas++;
			}
		}

		if(qualidadeEntidadeAntecessorasNullas > 1){
			fail("Somente uma entidade pode ter o antecessor como null");
		}
	}

	@Test
	public void testaEntidadeAntecessorInValidoNull(){
		List<Entidade> listaEntidades = new ArrayList();

		Entidade entidade1 = new Entidade();
		Entidade entidade2 = new Entidade();
		Entidade entidade3 = new Entidade();
		Entidade entidade4 = new Entidade();

		entidade1.setAntecessor(null);
		entidade2.setAntecessor(1);
		entidade3.setAntecessor(null);
		entidade4.setAntecessor(5);

		int qualidadeEntidadeAntecessorasNullas = 0;

		listaEntidades.add(entidade1);
		listaEntidades.add(entidade2);
		listaEntidades.add(entidade3);
		listaEntidades.add(entidade4);

		for(Entidade entidade :listaEntidades){
			try{
				if(entidade.getAntecessor().equals(null)){

				}
			}catch (NullPointerException e) {
				qualidadeEntidadeAntecessorasNullas++;
			}
		}

		try{
			if(qualidadeEntidadeAntecessorasNullas > 1){
				throw new Exception("Somente uma entidade pode ter o antecessor como null");
			}
		}catch (Exception e) {
			assertEquals(e.getMessage(), "Somente uma entidade pode ter o antecessor como null");
		}
	}

	/**
	 * Somente um atributo pode ter o id de referencia antecessor vazio ou null
	 */
	@Test
	public void testaAtributoAntecessorValidaNull(){
		List<Atributo> listaAtributos = new ArrayList();

		Atributo atributo1 = new Atributo();
		Atributo atributo2 = new Atributo();
		Atributo atributo3 = new Atributo();
		Atributo atributo4 = new Atributo();

		atributo1.setAntecessor(null);
		atributo2.setAntecessor(1);
		atributo3.setAntecessor(3);
		atributo4.setAntecessor(5);

		int qualidadeEntidadeAntecessorasNullas = 0;

		listaAtributos.add(atributo1);
		listaAtributos.add(atributo2);
		listaAtributos.add(atributo3);
		listaAtributos.add(atributo4);

		for(Atributo atributo :listaAtributos){
			try{
				if(atributo.getAntecessor().equals(null)){

				}
			}catch (NullPointerException e) {
				qualidadeEntidadeAntecessorasNullas++;
			}
		}

		if(qualidadeEntidadeAntecessorasNullas > 1){
			fail("Somente um atributo pode ter o antecessor como null");
		}
	}

	@Test
	public void testaAtributoAntecessorInValidoNull(){
		List<Atributo> listaAtributos = new ArrayList();

		Atributo atributo1 = new Atributo();
		Atributo atributo2 = new Atributo();
		Atributo atributo3 = new Atributo();
		Atributo atributo4 = new Atributo();

		atributo1.setAntecessor(null);
		atributo2.setAntecessor(1);
		atributo3.setAntecessor(3);
		atributo4.setAntecessor(null);

		int qualidadeAtributoAntecessorasNullas = 0;

		listaAtributos.add(atributo1);
		listaAtributos.add(atributo2);
		listaAtributos.add(atributo3);
		listaAtributos.add(atributo4);

		for(Atributo atributo :listaAtributos){
			try{
				if(atributo.getAntecessor().equals(null)){

				}
			}catch (NullPointerException e) {
				qualidadeAtributoAntecessorasNullas++;
			}
		}

		try {
			if(qualidadeAtributoAntecessorasNullas > 1){
				throw new Exception("Somente uma atributo pode ter o antecessor como null");
			}
		} catch (Exception e) {
			assertEquals(e.getMessage(), "Somente uma atributo pode ter o antecessor como null");
		}
	}

	@Test
	public void testaJSONToEntidade() throws JSONException{
		Entidade entidade = new Entidade();
		String nomeEntidade = "Entidade 1";
		Integer antecessor = 0;

		JSONObject entidadeJson = criaEntidadeJSON(nomeEntidade, antecessor);

		entidade = JSONToEntidade(entidadeJson);

		assertEquals(entidade.getNome(), nomeEntidade);
		assertEquals(entidade.getTituloGrupoDeQuestoes(), TITULO_GRUPO_QUESTOES);
		assertEquals(entidade.getTituloGrupoDeCampos(), TITULO_GRUPO_CAMPOS);
		assertEquals(entidade.getAntecessor(), antecessor);
	}
}
