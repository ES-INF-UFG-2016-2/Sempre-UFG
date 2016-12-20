package br.ufg.inf.sempreufg.interfaces;

import br.ufg.inf.sempreufg.enums.NomeCampos;
import br.ufg.inf.sempreufg.modelo.Egresso;

import java.util.List;
import java.util.Map;

public interface EgressoServiceInterface {

    public List<Egresso> consultaPorAdHoc(Map<NomeCampos, String> parametros);
    public List<Egresso> consultarEgressoPorConsultaPreDefinida(String string);

    void atualizarEgresso(Egresso egresso) throws Exception;
    Egresso getEgresso(int id);
    void removerEgresso(int id) throws Exception;

}
