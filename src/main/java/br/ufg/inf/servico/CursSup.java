package br.ufg.inf.servico;

import br.ufg.inf.modelo.AreaDeConhecimento;
import br.ufg.inf.modelo.CursoOutrasIES;
import br.ufg.inf.modelo.CursoUFG;
import br.ufg.inf.modelo.LocalizacaoGeografica;
import br.ufg.inf.modelo.RegionalUFG;
import br.ufg.inf.modelo.UnidadeAcademica;

class CursSup {

    public CursoUFG getCursoUFGPorIdentificador(int num_resolucao) {
        if (num_resolucao == 1) {

        }

        return null;
    }

    public LocalizacaoGeografica getLocalizacaoPorIdentificador(String id) {

        if (id == "3") {
            String nomeDaCidade = "Goiânia";
            String nomeDaUnidadeFederativa = "Goiás";
            String nomeDoPais = "Brasil";
            String siglaDaUnidadeFederativa = "GO";
            float longitude = 12312;

            LocalizacaoGeografica localizacao = new LocalizacaoGeografica(id, nomeDaCidade, nomeDaUnidadeFederativa, nomeDoPais, siglaDaUnidadeFederativa);
            localizacao.setLongitude(longitude);

            return localizacao;
        }

        return null;

    }

    public UnidadeAcademica getUnidadeAcademicaPorIdentificador(int idUnidadeAcademica) {

        if (idUnidadeAcademica == 1) {
            UnidadeAcademica unidade = new UnidadeAcademica(0, null, null, null);
            return unidade;
        }
        return null;
    }

    public RegionalUFG getRegionalPorIdentificador(int id) {

        if (id == 1) {

        }
        return null;
    }

    public AreaDeConhecimento getAreaDeConhecimentoPorIdentificador(String id) {

        if (id == "1") {

        }

        return null;
    }

    public CursoOutrasIES getCursoOutraIESPorIdentificador(String id) {

        if (id == "1") {

        }

        return null;
    }

    public boolean getTodosCursosSuperiores() {
        return true;
    }
}
