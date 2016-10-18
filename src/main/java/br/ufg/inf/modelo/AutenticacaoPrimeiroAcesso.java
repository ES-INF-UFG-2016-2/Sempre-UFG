package br.ufg.inf.modelo;

import java.util.Date;

/**
 *
 * @author cleber
 */
public class AutenticacaoPrimeiroAcesso {
    private String nomeMae;
    private Date dataNascimento;
    private String naturalidade;
    private String curso;
    private String matricula;

    public AutenticacaoPrimeiroAcesso() {
        dataNascimento = new Date();
    }

    public String getNomeMae() {
        return nomeMae;
    }

    public void setNomeMae(String nomeMae) {
        this.nomeMae = nomeMae;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getNaturalidade() {
        return naturalidade;
    }

    public void setNaturalidade(String naturalidade) {
        this.naturalidade = naturalidade;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }
    
}
