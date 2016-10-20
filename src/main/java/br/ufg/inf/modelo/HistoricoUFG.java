package br.ufg.inf.modelo;

/**
 * Created by user1 on 09/10/2016.
 */
public class HistoricoUFG {
    private int num_matricula;
    private int mes_inicio;
    private int mes_fim;
    private int ano_inicio;
    private int ano_fim;
    private CursoUFG cursoUFG;
    private String titulo_trabalho_Final;


    public HistoricoUFG(int num_matricula, int mes_inicio, int mes_fim, int ano_inicio, int ano_fim, CursoUFG cursoUFG, String titulo_trabalho_Final) {
        this.num_matricula = num_matricula;
        this.mes_inicio = mes_inicio;
        this.mes_fim = mes_fim;
        this.ano_inicio = ano_inicio;
        this.ano_fim = ano_fim;
        this.cursoUFG = cursoUFG;
        this.titulo_trabalho_Final = titulo_trabalho_Final;
    }

    public int getNum_matricula() {
        return num_matricula;
    }

    public void setNum_matricula(int num_matricula) {
        this.num_matricula = num_matricula;
    }

    public int getMes_inicio() {
        return mes_inicio;
    }

    public void setMes_inicio(int mes_inicio) {
        this.mes_inicio = mes_inicio;
    }

    public int getMes_fim() {
        return mes_fim;
    }

    public void setMes_fim(int mes_fim) {
        this.mes_fim = mes_fim;
    }

    public int getAno_inicio() {
        return ano_inicio;
    }

    public void setAno_inicio(int ano_inicio) {
        this.ano_inicio = ano_inicio;
    }

    public int getAno_fim() {
        return ano_fim;
    }

    public void setAno_fim(int ano_fim) {
        this.ano_fim = ano_fim;
    }

    public CursoUFG getCursoUFG() {
        return cursoUFG;
    }

    public void setCursoUFG(CursoUFG cursoUFG) {
        this.cursoUFG = cursoUFG;
    }

    public String getTitulo_trabalho_Final() {
        return titulo_trabalho_Final;
    }

    public void setTitulo_trabalho_Final(String titulo_trabalho_Final) {
        this.titulo_trabalho_Final = titulo_trabalho_Final;
    }
}
