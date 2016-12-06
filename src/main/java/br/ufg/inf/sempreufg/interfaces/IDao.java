package br.ufg.inf.sempreufg.interfaces;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

public interface IDao<T extends Serializable> {
	void inserir(T entity);
	List<T> select(String sql, Map<String, Object> parametros);
	List<T> select(String sql);
	List<T> selectAll();
	T buscarById(int id);
}
