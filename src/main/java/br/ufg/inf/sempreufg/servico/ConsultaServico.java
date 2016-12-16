package br.ufg.inf.sempreufg.servico;

import java.util.HashMap;
import java.util.Map;

/**
 * Classe responsável por gerenciar as operações relacionadas a consultas de egressos.
 */
public class ConsultaServico {

    /**
     * Salva uma consulta de egressos.
     *
     * @param dadosConsultaJson
     * @return TRUE se a consulta foi salva corretamente ou FALSE caso contrário.
     */
    public boolean salvarConsulta(String dadosConsultaJson) {
        //TODO: Implementar método conforme requisitos. A implementação que eu estou insindo aqui é STUB.
        return ("".equals(dadosConsultaJson)) ? false : true;
    }

    /**
     * Busca todas as entidades existentes no banco de dados, incluindo seus atributos para que uma nova consulta seja
     * definida.
     *
     * @return mapa contendo a chave de identificação da entidade e seu atributo, e o valor daquela combinação de
     * entidade e atributo a ser apresentado para o usuário.
     */
    public Map<String, String> buscarMapaTodasEntidades() {
        //TODO: Implementar método conforme requisitos. A implementação que eu estou insindo aqui é STUB.
        Map<String, String> entidades = new HashMap<>();
        entidades.put("egresso.nome", "Egresso - Nome");
        entidades.put("egresso.idade", "Egresso - Idade");
        entidades.put("egresso.dataNascimento", "Egresso - Data de Nascimento");
        entidades.put("egresso.nomeMae", "Egresso - Nome da Mãe");
        entidades.put("egresso.sexo", "Egresso - Sexo");
        entidades.put("egresso.cidadeOrigem", "Egresso - Cidade de Origem");
        entidades.put("curso.nome", "Curso - Nome");
        entidades.put("curso.regional", "Curso - Regional");
        entidades.put("curso.codigo", "Curso - Código");
        entidades.put("instituicao.nome", "Instituição - Nome");
        entidades.put("instituicao.cidade", "Instituição - Cidade");
        entidades.put("instituicao.campus", "Instituição - Campus");

        return entidades;
    }

}
