package br.ufg.inf.sempreufg.dao;

import br.ufg.inf.sempreufg.enums.Sexo;
import br.ufg.inf.sempreufg.enums.VisibilidadeDados;
import br.ufg.inf.sempreufg.interfaces.EgressoDAOInterface;
import br.ufg.inf.sempreufg.modelo.Egresso;
import br.ufg.inf.sempreufg.modelo.HistoricoUFG;
import br.ufg.inf.sempreufg.modelo.LocalizacaoGeografica;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.*;

public class EgressoDAO implements EgressoDAOInterface<Egresso> {

    private static Connection conexao = null;
    private static PreparedStatement instrucao = null;

	@Override
	public void inserir(Egresso entity) {
	}

	@Override
	public List<Egresso> select(String sql, Map<String, Object> parametros) {
		return criarListaEgressoMock();
	}

	@Override
	public List<Egresso> select(String sql) {
		return criarListaEgressoMock();
	}

	@Override
	public List<Egresso> selectAll() {
		return criarListaEgressoMock();
	}

	@Override
	public Egresso buscarById(int id) {
		return null;
	}

	public List<Egresso> criarListaEgressoMock(){
		List<Egresso> egressos = new ArrayList<Egresso>();

		for (int i = 0; i < 10; i++) {
			Egresso egresso = new Egresso(
				"Everton Jose",
				"Maria",
				new Date(),
				Sexo.MASCULINO,
				"emailAlternativo@gmail.com",
				new BitSet(),
				new BitSet(),
				VisibilidadeDados.PUBLICO,
				new ArrayList<HistoricoUFG>(),
                new LocalizacaoGeografica()
			);

			egressos.add(egresso);
		}

		return egressos;
	}

    @Override
    public Egresso salvar(Egresso egresso) throws Exception {
        return null;
    }

    @Override
    public boolean alterar(Egresso egresso) throws SQLException {
        return false;
    }

    @Override
    public boolean deletar(Egresso egresso) throws SQLException {
        return false;
    }

    @Override
    public Egresso getById(int id) throws Exception {
        return null;
    }

    @Override
    public List<Egresso> getAll() throws SQLException {
        return null;
    }
}
