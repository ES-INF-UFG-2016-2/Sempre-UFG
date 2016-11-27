package br.ufg.inf.sempreufg.dao;

import br.ufg.inf.sempreufg.db.ConexaoBanco;
import br.ufg.inf.sempreufg.interfaces.EgressoDAOInterface;
import br.ufg.inf.sempreufg.modelo.Egresso;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;

public class EgressoDAO implements EgressoDAOInterface{

    static Connection conexao = null;
    static PreparedStatement instrucao = null;

    @Override
    public Egresso salvar(Egresso egresso) {
        if (conexao == null) conexao = ConexaoBanco.getConnection();

        try{
            String dadosEgresso =
                "INSERT INTO egresso (nome, nome_mae, data_nascimento, foto_principal, " +
                    "foto_adicionais, visibilidade, sexo) values (?,?,?,?,?,?,?);";

            instrucao = conexao.prepareStatement(dadosEgresso);

            instrucao.setString(1, egresso.getNome());
            instrucao.setString(2, egresso.getNome_mae());
            instrucao.setDate(3, (java.sql.Date) egresso.getData_nascimento());
            instrucao.setBytes(4, egresso.getFoto_principal().getBytes());
            instrucao.setBytes(5, egresso.getFotos_adicionais().getBytes());
            instrucao.setString(6, egresso.getVisibilidade().toString());
            instrucao.setString(7, egresso.getSexo().toString());

            instrucao.executeQuery(dadosEgresso);

        }catch(Exception erro){
            System.out.println("ERRO NA EXECUÇÃO DA QUERY - SALVAR EGRESSO!");
            erro.printStackTrace();
        }

        return null;
    }

    @Override
    public boolean alterar(Egresso egresso) {
        return false;
    }

    @Override
    public boolean deletar(int id_egresso) {
        return false;
    }

    @Override
    public Egresso getById(int id_egresso) {
        return null;
    }

    @Override
    public List<Egresso> getAll() {
        return null;
    }
}
