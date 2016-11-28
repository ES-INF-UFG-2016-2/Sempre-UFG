package br.ufg.inf.sempreufg.servico;

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
        if (forma == "Concurso Público" || forma == "Seleção Interna" || forma == "Indicação" ||
                forma == "Voluntário" || forma == "Outra") {
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
