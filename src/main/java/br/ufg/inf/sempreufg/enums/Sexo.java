package br.ufg.inf.sempreufg.enums;

/**
 * Created by user1 on 09/10/2016.
 */
public enum Sexo {
    MASCULINO("masculino"), FEMININO("feminino");
    private String sexo;

    Sexo(String sexo) {
        this.sexo = sexo;
    }

    public String getSexo() {
        return sexo;
    }

}
