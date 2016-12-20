package br.ufg.inf.sempreufg.servico;

import br.ufg.inf.sempreufg.db.HibernateSession;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.json.JSONArray;
import org.json.JSONObject;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MapaEgressoService {

    private static Map<String, String> dicionarioSQLJOIN;
    private static Map<String, String> dicionarioSQLSELECT;
    private static final SessionFactory sessionFactory = HibernateSession.getSessionFactory();

    static {
        dicionarioSQLJOIN = new HashMap<>();
        dicionarioSQLSELECT = new HashMap<>();
        dicionarioSQLJOIN.put("curso", "FROM historico_na_ufg ON egresso.id = historico_na_ufg.id_egresso\n" +
            "  INNER JOIN curso_da_ufg ON historico_na_ufg.curso = curso_da_ufg.area_conhecimento_codigo\n" +
            "  INNER JOIN unidade_academica_ufg ON curso_da_ufg.unidade_academica = unidade_academica_ufg.id\n" +
            "  INNER JOIN localizacao_geografica ON unidade_academica_ufg.id_localizacao_geografica = localizacao_geografica.id GROUP BY curso_nome");
        dicionarioSQLSELECT.put("curso", "SELECT curso_nome, latitudade, longitude");
    }

    public JSONObject obtenhaJSONEgressosAgrupados(JSONObject camposAgrupamento){
        List<String> chavesTratadas = trateChavesAgrupamentos(camposAgrupamento);
        return new JSONObject(obtenhaEgressoAgrupados(chavesTratadas));
    }

    private List<Map> obtenhaEgressoAgrupados(List<String> camposAgrupamentos){
        StringBuilder stringBuilder = new StringBuilder();

        for(String campoAgrupamento : camposAgrupamentos){
            stringBuilder.append(dicionarioSQLSELECT.get(campoAgrupamento));
            stringBuilder.append(dicionarioSQLJOIN.get(campoAgrupamento));
        }

        List<Map> egressosAgrupados = new ArrayList<>();
        Transaction transacao = null;

        try (Session session = sessionFactory.openSession()) {
            transacao = session.beginTransaction();
            egressosAgrupados = session.createQuery(stringBuilder.toString()).list();
            transacao.commit();
        } catch (HibernateException e) {
            if (transacao != null) {
                transacao.rollback();
            }
            e.printStackTrace();
        }

        return egressosAgrupados;
    }

    private List<String> trateChavesAgrupamentos(JSONObject camposAgrupamento){
        List<String> chavesTratadas = obtenhaChaves(camposAgrupamento);
        List<String> chavesAgrupamento = new ArrayList<>();

        if(chavesTratadas.contains("cidade")){
            chavesAgrupamento.add("cidade");
        }
        chavesTratadas.remove("nome");

        chavesAgrupamento.addAll(chavesTratadas);

        return chavesAgrupamento;
    }

    private List<String> obtenhaChaves(JSONObject jsonObject){
        List<String> chaves = new ArrayList<>();
        JSONArray arrayDeChaves = jsonObject.getJSONArray("chaves");

        for(int k = 0; k < arrayDeChaves.length(); k++){
            chaves.add(arrayDeChaves.getString(k));
        }

        return chaves;
    }
}
