package br.ufg.inf.servico;

import br.ufg.inf.modelo.AreaDeConhecimento;
import br.ufg.inf.modelo.CursoOutrasIES;
import br.ufg.inf.modelo.CursoUFG;
import br.ufg.inf.modelo.LocalizacaoGeografica;
import br.ufg.inf.modelo.RegionalUFG;
import br.ufg.inf.modelo.UnidadeAcademica;

class CursSup {

    public CursoUFG getCursoUFGPorIdentificador(int num_resolucao) {
        return null;
    }

    public LocalizacaoGeografica getLocalizacaoPorIdentificador(String id) {

        String nomeDaCidade = "Goiânia";
        String nomeDaUnidadeFederativa = "Goiás";
        String nomeDoPais = "Brasil";
        String siglaDaUnidadeFederativa = "GO";
        float longitude = 12312;

        LocalizacaoGeografica localizacao = new LocalizacaoGeografica(id, nomeDaCidade, nomeDaUnidadeFederativa, nomeDoPais, siglaDaUnidadeFederativa);
        localizacao.setLongitude(longitude);

        return localizacao;
    }

    public UnidadeAcademica getUnidadeAcademicaPorIdentificador(int idUnidadeAcademica) {
        return null;
    }

    public RegionalUFG getRegionalPorIdentificador(int id) {
        return null;
    }

    public AreaDeConhecimento getAreaDeConhecimentoPorIdentificador(String id) {
        return null;
    }

    public CursoOutrasIES getCursoOutraIESPorIdentificador(String id) {
        return null;
    }

    public boolean getTodosCursosSuperiores() {
        return true;
    }
}
