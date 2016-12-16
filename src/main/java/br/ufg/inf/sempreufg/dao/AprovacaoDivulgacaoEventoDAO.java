package br.ufg.inf.sempreufg.dao;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import br.ufg.inf.sempreufg.db.ConexaoBanco;
import br.ufg.inf.sempreufg.interfaces.AprovacaoDivulgacaoEventoDAOInterface;
import br.ufg.inf.sempreufg.modelo.AprovacaoDivulgacaoEvento;

public class AprovacaoDivulgacaoEventoDAO implements AprovacaoDivulgacaoEventoDAOInterface {

	private AprovacaoDivulgacaoEvento aprovacaoDivulgacaoEvento;

	@Override
	public void salvar(AprovacaoDivulgacaoEvento aprovacaoDivulgacaoEvento) {

		String sql = "INSERT INTO aprovacao_de_divulgacao" + " (" + "divulgacao_aprovada,"
				+ " parecer_sobre_divulgacao, " + "data_aprovacao_ou_rejeicao, " + "evento, " + "usuario_email, "
				+ "usuario_cpf)" + " values" + "(?,?,?,?,?,?)";

		try {
			PreparedStatement ps = ConexaoBanco.getConnection().prepareStatement(sql);
			ps.setBoolean(1, aprovacaoDivulgacaoEvento.isDivulgacaoAprovada());
			ps.setString(2, aprovacaoDivulgacaoEvento.getParecerSobreDivulgacao());
			ps.setDate(3, (Date) aprovacaoDivulgacaoEvento.getDataDoParecer());
			ps.setString(4, aprovacaoDivulgacaoEvento.getEvento().getAssunto());
			ps.setString(5, aprovacaoDivulgacaoEvento.getResponsavelPorAprovar().getMail());
			ps.setLong(6, aprovacaoDivulgacaoEvento.getResponsavelPorAprovar().getCpf());

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void alterar(AprovacaoDivulgacaoEvento aprovacaoDivulgacaoEvento) {

	}

	@Override
	public void deletar(int id_AprovacaoDivulgacaoEvento) {

	}

	@Override
	public AprovacaoDivulgacaoEvento getById(int id_Areid_AprovacaoDivulgacaoEvento) {
		return null;
	}

	@Override
	public boolean obtemStatusAprovacaoEvento() {
		return aprovacaoDivulgacaoEvento.isDivulgacaoAprovada();
	}
}
