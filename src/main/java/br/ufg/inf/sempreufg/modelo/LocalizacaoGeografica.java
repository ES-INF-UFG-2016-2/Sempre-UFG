<<<<<<< HEAD:src/main/java/br/ufg/inf/modelo/LocalizacaoGeografica.java
package br.ufg.inf.modelo;

public class LocalizacaoGeografica {

    private String id;

    private String nomeDaCidade;

    private String nomeDaUnidadeFederativa;

    private String nomeDoPais;

    private String siglaDaUnidadeFederativa;

    private Float latitude;

    private Float longitude;

    public LocalizacaoGeografica() {
    }   
    
    public LocalizacaoGeografica(String id, String nomeDaCidade, String nomeDaUnidadeFederativa, String nomeDoPais, String siglaDaUnidadeFederativa) {
        this.id = id;
        this.nomeDaCidade = nomeDaCidade;
        this.nomeDaUnidadeFederativa = nomeDaUnidadeFederativa;
        this.nomeDoPais = nomeDoPais;
        this.siglaDaUnidadeFederativa = siglaDaUnidadeFederativa;
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

    public void setNomeDaUnidadeFederativa(String nomeDaUnidadeFederativa) {
        this.nomeDaUnidadeFederativa = nomeDaUnidadeFederativa;
    }

    public String getNomeDoPais() {
        return nomeDoPais;
    }

    public void setNomeDoPais(String nomeDoPais) {
        this.nomeDoPais = nomeDoPais;
    }

    public String getSiglaDaUnidadeFederativa() {
        return siglaDaUnidadeFederativa;
    }

    public void setSiglaDaUnidadeFederativa(String siglaDaUnidadeFederativa) {
        this.siglaDaUnidadeFederativa = siglaDaUnidadeFederativa;
    }

    public Float getLatitude() {
        return latitude;
    }

    public void setLatitude(Float latitude) {
        this.latitude = latitude;
    }

    public Float getLongitude() {
        return longitude;
    }

    public void setLongitude(Float longitude) {
        this.longitude = longitude;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

}
=======
package br.ufg.inf.sempreufg.modelo;

public class LocalizacaoGeografica {

	private String nomeDaCidade;

	private String nomeDaUnidadeFederativa;

	private String nomeDoPais;

	private String siglaDaUnidadeFederativa;

	private Float latitude;

	private Float longitude;

	public String getNomeDaCidade() {
		return nomeDaCidade;
	}
	public void setNomeDaCidade(String nomeDaCidade) {
		this.nomeDaCidade = nomeDaCidade;
	}
	public String getNomeDaUnidadeFederativa() {
		return nomeDaUnidadeFederativa;
	}
	public void setNomeDaUnidadeFederativa(String nomeDaUnidadeFederativa) {
		this.nomeDaUnidadeFederativa = nomeDaUnidadeFederativa;
	}
	public String getNomeDoPais() {
		return nomeDoPais;
	}
	public void setNomeDoPais(String nomeDoPais) {
		this.nomeDoPais = nomeDoPais;
	}
	public String getSiglaDaUnidadeFederativa() {
		return siglaDaUnidadeFederativa;
	}
	public void setSiglaDaUnidadeFederativa(String siglaDaUnidadeFederativa) {
		this.siglaDaUnidadeFederativa = siglaDaUnidadeFederativa;
	}
	public Float getLatitude() {
		return latitude;
	}
	public void setLatitude(Float latitude) {
		this.latitude = latitude;
	}
	public Float getLongitude() {
		return longitude;
	}
	public void setLongitude(Float longitude) {
		this.longitude = longitude;
	}



}
>>>>>>> origin/develop:src/main/java/br/ufg/inf/sempreufg/modelo/LocalizacaoGeografica.java
