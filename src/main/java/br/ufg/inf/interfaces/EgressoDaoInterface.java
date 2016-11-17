package br.ufg.inf.interfaces;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import br.ufg.inf.enums.NomeCampos;
import br.ufg.inf.modelo.Egresso;

public interface EgressoDaoInterface<T extends Serializable> extends GenericDaoInterface<T> {
	public Map<Object, Egresso> consultaPorAdHoc(Map<NomeCampos, String> parametros);
	public List<T> select(String string);
}
