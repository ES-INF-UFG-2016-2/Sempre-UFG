package br.ufg.inf.sempreufg.to;

import java.util.List;

import br.ufg.inf.sempreufg.modelo.Egresso;

/**
 * <p>
 * ResultadoImportacaoTO.
 * </p>
 * <p>
 * Descrição: TO que contem os resultados da importação de egressos pelo
 * CERCOMP.
 * </p>
 *
 * @author Bruno Martins de Carvalho
 */

public class ResultadoImportacaoTO {

    private Integer totalExportadoCercomp;
    private Integer totalImportadoSucesso;
    private Integer totalNaoImportadoErro;
    private Integer totalNaoImportadoReplicacao;

    private List<Egresso> listaEgressoImportado;

    /**
     * Retorna o valor do totalExportadoCercomp.
     *
     * @return the totalExportadoCercomp
     */
    public Integer getTotalExportadoCercomp() {
        return totalExportadoCercomp;
    }

    /**
     * Atribui o valor ao campo.
     *
     * @param totalExportadoCercomp
     *            the totalExportadoCercomp to set
     */
    public void setTotalExportadoCercomp(Integer totalExportadoCercomp) {
        this.totalExportadoCercomp = totalExportadoCercomp;
    }

    /**
     * Retorna o valor do totalImportadoSucesso.
     *
     * @return the totalImportadoSucesso
     */
    public Integer getTotalImportadoSucesso() {
        return totalImportadoSucesso;
    }

    /**
     * Atribui o valor ao campo.
     *
     * @param totalImportadoSucesso
     *            the totalImportadoSucesso to set
     */
    public void setTotalImportadoSucesso(Integer totalImportadoSucesso) {
        this.totalImportadoSucesso = totalImportadoSucesso;
    }

    /**
     * Retorna o valor do totalNaoImportadoErro.
     *
     * @return the totalNaoImportadoErro
     */
    public Integer getTotalNaoImportadoErro() {
        return totalNaoImportadoErro;
    }

    /**
     * Atribui o valor ao campo.
     *
     * @param totalNaoImportadoErro
     *            the totalNaoImportadoErro to set
     */
    public void setTotalNaoImportadoErro(Integer totalNaoImportadoErro) {
        this.totalNaoImportadoErro = totalNaoImportadoErro;
    }

    /**
     * Retorna o valor do totalNaoImportadoReplicacao.
     *
     * @return the totalNaoImportadoReplicacao
     */
    public Integer getTotalNaoImportadoReplicacao() {
        return totalNaoImportadoReplicacao;
    }

    /**
     * Atribui o valor ao campo.
     *
     * @param totalNaoImportadoReplicacao
     *            the totalNaoImportadoReplicacao to set
     */
    public void setTotalNaoImportadoReplicacao(Integer totalNaoImportadoReplicacao) {
        this.totalNaoImportadoReplicacao = totalNaoImportadoReplicacao;
    }

    /**
     * Retorna o valor do listaEgressoImportado.
     *
     * @return the listaEgressoImportado
     */
    public List<Egresso> getListaEgressoImportado() {
        return listaEgressoImportado;
    }

    /**
     * Atribui o valor ao campo.
     *
     * @param listaEgressoImportado
     *            the listaEgressoImportado to set
     */
    public void setListaEgressoImportado(List<Egresso> listaEgressoImportado) {
        this.listaEgressoImportado = listaEgressoImportado;
    }
}
