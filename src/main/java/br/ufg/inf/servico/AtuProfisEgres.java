package br.ufg.inf.servico;

public class AtuProfisEgres {


    public Boolean inserirDataInicio(int data) {
        int entrada = 20122012;
        if (data == entrada){
            return true;
        } else {
            return false;
        }
    }

    public boolean inserirDataFim(int data) {
        int entrada = 20122012;
        if (data == entrada){
            return true;
        } else {
            return false;
        }
    }

    public boolean inserirFormaIngresso(String forma) {
        String entrada = "Concurso";
        if (forma == entrada){
            return true;
        } else {
            return false;
        }
    }

    public boolean inserirRendaMensaMedia(float renda) {
        float entrada = (float) 880.90;
        if (renda == entrada){
            return true;
        } else {
            return false;
        }
    }

    public boolean inserirSatisfacaoComRenda(int satisfacao) {
        int entrada = 5;
        if (satisfacao == entrada){
            return true;
        } else {
            return false;
        }
    }

    public boolean inserirPerspectivaFuturo(int perspectiva) {
        int entrada = 5;
        if (perspectiva == entrada){
            return true;
        } else {
            return false;
        }
    }

    public boolean inserirComentario(String comentario) {
        String entrada = "Muito bom";
        if (comentario == entrada) {
            return true;
        } else {
          return false;
        }
    }
}
