package br.ufg.inf.sempreufg.stubs;

import java.util.ArrayList;

import org.junit.Before;

public class MantPapelStub {
	private ArrayList<String> listaPermissoes = new ArrayList<>(); 

	//Lista somente para representar permissoes atribuidas a usuarios que tera cadastrado no banco
	public void initArray(){
		listaPermissoes.add("Jean");
		listaPermissoes.add("Carlos");
		listaPermissoes.add("Lucas");
		listaPermissoes.add("Joao");
		listaPermissoes.add("Felipe");
		listaPermissoes.add("Juliano");
		listaPermissoes.add("Patricia");
		listaPermissoes.add("Ana");
		
	}
	public String criarPermissaoUsuario(String papel, String recurso) {
		String resultadoInsercao = "Não foi Possivel Inserir a Permissão";
		if(papel.equals("")){
			resultadoInsercao += ": Papel não foi inserido";
		}
		if(recurso.equals("")){
			resultadoInsercao += ": Recurso não foi inserido";
		}
		if(!papel.equals("") && !recurso.equals("")){
			resultadoInsercao = "Permissão Inserida";
		}
		
		
        return resultadoInsercao;
    }

	public boolean consultaPermissao(String usuario){
		initArray();
		boolean achouPermissao = false;
		for (int i = 0; i < listaPermissoes.size(); i++) {
			if(listaPermissoes.get(i).equals(usuario)){
				achouPermissao = true;
			}
		}
		return achouPermissao;
	}
    public String excluirPermissaoUsuario( String usuario ) {
    	initArray();
    	String resultadoExclusao;
    	
    	
    	if(consultaPermissao(usuario)==false){
			resultadoExclusao = "Permissao não Existente";
		}
    	else{
    		listaPermissoes.remove(usuario);
			resultadoExclusao = "Permissão Excluida";
			
		}
		return resultadoExclusao;
	 }
}
