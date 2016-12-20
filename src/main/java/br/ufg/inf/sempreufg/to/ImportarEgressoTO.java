package br.ufg.inf.sempreufg.to;

/**
 * <p>
 * ImportarEgressoTO.
 * </p>
 * <p>
 * Descrição: Classe responsavel por armazenar os dados que serão utilizados
 * para realizar a importação dos egressos do CERCOMP.
 * </p>
 *
 * @author Bruno Martins de Carvalho
 */

public class ImportarEgressoTO {

    private String periodoInicial;
    private String periodoFinal;
    private String matriculaEgresso;
    private String cursoUFG;
    private String unidadeAcademica;
    private String regional;

    /**
     * Retorna o valor do periodoInicial.
     *
     * @return the periodoInicial
     */
    public String getPeriodoInicial() {
        return this.periodoInicial;
    }

    /**
     * Retorna o valor do periodoFinal.
     *
     * @return the periodoFinal
     */
    public String getPeriodoFinal() {
        return this.periodoFinal;
    }

    /**
     * Retorna o valor do matriculaEgresso.
     *
     * @return the matriculaEgresso
     */
    public String getMatriculaEgresso() {
        return this.matriculaEgresso;
    }

    /**
     * Retorna o valor do cursoUFG.
     *
     * @return the cursoUFG
     */
    public String getCursoUFG() {
        return this.cursoUFG;
    }

    /**
     * Retorna o valor do unidadeAcademica.
     *
     * @return the unidadeAcademica
     */
    public String getUnidadeAcademica() {
        return this.unidadeAcademica;
    }

    /**
     * Retorna o valor do regional.
     *
     * @return the regional
     */
    public String getRegional() {
        return this.regional;
    }

    /**
     * Atribui o valor ao campo.
     *
     * @param periodoInicial
     *            the periodoInicial to set
     */
    public void setPeriodoInicial(String periodoInicial) {
        this.periodoInicial = periodoInicial;
    }

    /**
     * Atribui o valor ao campo.
     *
     * @param periodoFinal
     *            the periodoFinal to set
     */
    public void setPeriodoFinal(String periodoFinal) {
        this.periodoFinal = periodoFinal;
    }

    /**
     * Atribui o valor ao campo.
     *
     * @param matriculaEgresso
     *            the matriculaEgresso to set
     */
    public void setMatriculaEgresso(String matriculaEgresso) {
        this.matriculaEgresso = matriculaEgresso;
    }

    /**
     * Atribui o valor ao campo.
     *
     * @param cursoUFG
     *            the cursoUFG to set
     */
    public void setCursoUFG(String cursoUFG) {
        this.cursoUFG = cursoUFG;
    }

    /**
     * Atribui o valor ao campo.
     *
     * @param unidadeAcademica
     *            the unidadeAcademica to set
     */
    public void setUnidadeAcademica(String unidadeAcademica) {
        this.unidadeAcademica = unidadeAcademica;
    }

    /**
     * Atribui o valor ao campo.
     *
     * @param regional
     *            the regional to set
     */
    public void setRegional(String regional) {
        this.regional = regional;
    }

}
