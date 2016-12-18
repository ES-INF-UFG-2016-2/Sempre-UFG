package br.ufg.inf.sempreufg.modelo;

import org.json.JSONObject;

public class LocalizacaoGeografica {

    private int id;
    private String nomeDaCidade;
    private String nomeDaUnidadeFederativa;
    private String nomeDoPais;
    private String siglaDaUnidadeFederativa;
    private Double latitude;
    private Double longitude;

    public LocalizacaoGeografica(String nomeDaCidade, String nomeDaUnidadeFederativa, String nomeDoPais, String siglaDaUnidadeFederativa, Double latitude, Double longitude) {
        this.nomeDaCidade = nomeDaCidade;
        this.nomeDaUnidadeFederativa = nomeDaUnidadeFederativa;
        this.nomeDoPais = nomeDoPais;
        this.siglaDaUnidadeFederativa = siglaDaUnidadeFederativa;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public LocalizacaoGeografica() {
    }

    public String getNomeDaCidade() {
        return nomeDaCidade;
    }

    public void setNomeDaCidade(String nomeDaCidade) {
        this.nomeDaCidade = nomeDaCidade;
    }

    public String getNomeDaUnidadeFederativa() {
        return nomeDaUnidadeFederativa;
    }

    public void setNomeDaUnidadeFederativa(String nomeDaUnidadeFederativa) { this.nomeDaUnidadeFederativa = nomeDaUnidadeFederativa; }

    public String getNomeDoPais() {
        return nomeDoPais;
    }

    public void setNomeDoPais(String nomeDoPais) {
        this.nomeDoPais = nomeDoPais;
    }

    public String getSiglaDaUnidadeFederativa() {
        return siglaDaUnidadeFederativa;
    }

    public void setSiglaDaUnidadeFederativa(String siglaDaUnidadeFederativa) { this.siglaDaUnidadeFederativa = siglaDaUnidadeFederativa; }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public JSONObject toJson() {
        JSONObject localizacaoGeograficaAsJson = new JSONObject();
        JSONObject innerJson = new JSONObject();

        innerJson.put("nomeDaCidade", getNomeDaCidade());
        innerJson.put("nomeDaUnidadeFederativa", getNomeDaUnidadeFederativa());
        innerJson.put("nomeDoPais", getNomeDoPais());
        innerJson.put("siglaDaUnidadeFederativa", getSiglaDaUnidadeFederativa());
        innerJson.put("latitude", getLatitude());
        innerJson.put("longitude", getLongitude());

        localizacaoGeograficaAsJson.put( String.valueOf(getId()), innerJson);
        return localizacaoGeograficaAsJson;
    }

    public static LocalizacaoGeografica fromJson(JSONObject localizacaoGeograficaAsJson){
        return new LocalizacaoGeografica(
            localizacaoGeograficaAsJson.getString("nomeDaCidade"),
            localizacaoGeograficaAsJson.getString("nomeDaUnidadeFederativa"),
            localizacaoGeograficaAsJson.getString("nomeDoPais"),
            localizacaoGeograficaAsJson.getString("siglaDaUnidadeFederativa"),
            localizacaoGeograficaAsJson.getDouble("latitude"),
            localizacaoGeograficaAsJson.getDouble("longitude")
        );
    }
}
