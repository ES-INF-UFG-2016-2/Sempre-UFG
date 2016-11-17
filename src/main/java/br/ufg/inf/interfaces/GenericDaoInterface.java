package br.ufg.inf.interfaces;

import java.io.Serializable;
import java.util.Map;

public interface GenericDaoInterface<T extends Serializable>{
	public Map<Object, T> listarTodos();
	public Map<Object, T> listarPorId(int id);
}
