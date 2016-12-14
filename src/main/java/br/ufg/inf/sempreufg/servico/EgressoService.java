package br.ufg.inf.sempreufg.servico;

import br.ufg.inf.sempreufg.dao.EgressoDAO;
import br.ufg.inf.sempreufg.enums.NomeCampos;
import br.ufg.inf.sempreufg.enums.Sexo;
import br.ufg.inf.sempreufg.enums.VisibilidadeDados;
import br.ufg.inf.sempreufg.modelo.Egresso;
import br.ufg.inf.sempreufg.modelo.HistoricoUFG;
import br.ufg.inf.sempreufg.modelo.LocalizacaoGeografica;

import java.io.InputStream;
import java.sql.SQLException;
import java.util.*;


public class EgressoService implements EgressoServiceInterface {

    static EgressoDAO egressoDAO;

    @Override
    public void atualizarEgresso(Egresso egresso) {
        egressoDAO = new EgressoDAO();
        egressoDAO.atualizar(egresso);
    }

    @Override
    public Egresso getEgresso(int id) {
        egressoDAO = new EgressoDAO();
        Egresso egresso = null;
        try {
            egresso = egressoDAO.getById(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return egresso;
    }

    @Override
    public void removerEgresso(int id) throws Exception {
        try {
            egressoDAO = new EgressoDAO();
            egressoDAO.deletar(id);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new Exception("Não foi possível remover o Egresso!");
        }
    }

    @Override
    public Egresso converterXmlParaEgresso(InputStream content) {
        Egresso egresso = new Egresso();
        return egresso;
    }

    @Override
    public boolean egressoEValido(Egresso egresso) {
        return false;
    }

    @Override
        return criarListaEgressoMock();
    }

    @Override
        return criarListaEgressoMock();
    }

    @Override
        return criarListaEgressoMock();
    }

    @Override
        return criarListaEgressoMock();
    }

    @Override
        return criarListaEgressoMock();
    }


        for (int i = 0; i < 10; i++) {
            Egresso egresso = new Egresso("Everton Jose",
                "Maria",
                new Date(),
                Sexo.MASCULINO,
                "emailAlternativo@gmail.com",
                new BitSet(),
                new BitSet(),
                VisibilidadeDados.PUBLICO,
                new ArrayList < HistoricoUFG > (),
                new LocalizacaoGeografica());
            egressos.add(egresso);
        }

        return egressos;
    }

    @Override
        return new ExecultarConsultasMock().criarListaEgresso();
    }

    @Override
        return new ExecultarConsultasMock().criarListaEgresso();
    }

}
