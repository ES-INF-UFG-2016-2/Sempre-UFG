package br.ufg.inf.sempreufg.dao;

import br.ufg.inf.sempreufg.db.ConexaoBanco;
import br.ufg.inf.sempreufg.enums.Sexo;
import br.ufg.inf.sempreufg.enums.VisibilidadeDados;
import br.ufg.inf.sempreufg.interfaces.EgressoDAOInterface;
import br.ufg.inf.sempreufg.modelo.Egresso;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

public class EgressoDAO implements EgressoDAOInterface{

    private static Connection conexao = null;
    private static PreparedStatement instrucao = null;

    @Override
    public Egresso salvar(Egresso egresso) throws SQLException{
        if (conexao == null) conexao = ConexaoBanco.getConnection();

        try{
            String dadosEgresso =
                "INSERT INTO egresso (nome, nome_mae, data_nascimento, foto_principal, " +
                    "foto_adicionais, visibilidade, sexo) values (?,?,?,?,?,?,?);";

            instrucao = conexao.prepareStatement(dadosEgresso);

            instrucao.setString(1, egresso.getNome());
            instrucao.setString(2, egresso.getNome_mae());
            instrucao.setDate(3, (java.sql.Date) egresso.getData_nascimento());
            instrucao.setBytes(4, egresso.getFoto_principal());
            instrucao.setBytes(5, egresso.getFotos_adicionais());
            instrucao.setString(6, egresso.getVisibilidade().toString());
            instrucao.setString(7, egresso.getSexo().toString());

            instrucao.executeQuery(dadosEgresso);

        }catch(Exception erro){
            System.out.println("ERRO NA EXECUÇÃO DA QUERY - SALVAR EGRESSO!");
            erro.printStackTrace();
        }

        Egresso novoEgresso = null;

        try{
            String consultaEgresso = "SELECT id FROM egresso where nome = '" + egresso.getNome() + "' AND " +
                "nome_mae = '" + egresso.getNome_mae() + "' AND data_nascimento = '" + egresso.getData_nascimento() + "';";

            instrucao = conexao.prepareStatement(consultaEgresso);
            ResultSet resultado = instrucao.executeQuery();
            int id_Egresso = resultado.getInt(1);
            novoEgresso = new Egresso(id_Egresso, egresso.getNome(),
                egresso.getNome_mae(), egresso.getData_nascimento(), egresso.getFoto_principal(),
                egresso.getFotos_adicionais(), egresso.getVisibilidade(), egresso.getSexo());

        }catch(Exception erro){
            erro.printStackTrace();
            System.err.println("ERRO NA EXECUÇÃO DA QUERY - CONSULTAR EGRESSO APÓS SALVAR!");
        }

        if (novoEgresso == null) throw new RuntimeException("ERRO AO MONTAR NOVO EGRESSO APÓS SALVAR!");
        else return novoEgresso;
    }


    @Override
    public boolean alterar(Egresso egresso) throws SQLException {
        if (conexao == null) conexao = ConexaoBanco.getConnection();

        try{
            String alteraEgresso = "UPDATE TABLE egresso SET () WHERE id = '" + egresso.getId_Egresso() + "';";
            instrucao = conexao.prepareStatement(alteraEgresso);
            instrucao.executeQuery();
        }catch(Exception erro){
            erro.printStackTrace();
            System.err.println("ERRO NA EXECUÇÃO DA QUERY - ATUALIZAR EGRESSO!");
        }
        return false;
    }

    @Override
    public boolean deletar(int id_Egresso) throws SQLException{
        if (conexao == null) conexao = ConexaoBanco.getConnection();

        try{
            String deletaEgresso = "DELETE FROM egresso where id = '" + id_Egresso + "';";
            instrucao = conexao.prepareStatement(deletaEgresso);
            instrucao.executeUpdate(deletaEgresso);
        }catch(Exception erro){
            erro.printStackTrace();
            System.err.println("ERRO NA EXECUÇÃO DA QUERY - DELETAR EGRESSO!");
        }

        ResultSet resultado = null;

        try{
            String consultaEgressoRemovido = "SELECT * FROM egresso WHERE id = '" + id_Egresso + "';";
            instrucao = conexao.prepareStatement(consultaEgressoRemovido);
            resultado = instrucao.executeQuery(consultaEgressoRemovido);
        }catch(Exception erro){
            erro.printStackTrace();
            System.err.println("ERRO NA CONSULTA DA QUERY APÓS DELETAR!");
        }

        return resultado.isBeforeFirst();
    }

    @Override
    public Egresso getById(int id_Egresso) throws SQLException{
        if (conexao == null) conexao = ConexaoBanco.getConnection();

        Egresso egresso = null;

        try{
            String selectEgresso = "SELECT (id, nome, nome_mae, data_nascimento, foto_principal, " +
                "fotos_adicionais, visibilidade, sexo) FROM egresso WHERE id = '" + id_Egresso + "';";

            instrucao = conexao.prepareStatement(selectEgresso);
            ResultSet resultado = instrucao.executeQuery();

            String nome = resultado.getString(2);
            String  nome_mae = resultado.getString(3);
            Date data_nascimento = (java.util.Date) resultado.getDate(4);

            byte[] foto_principal = resultado.getBytes(5);
            byte[] fotos_adicionais = resultado.getBytes(6);

            VisibilidadeDados visibilidade; // PUBLICO, PRIVADO, SO_EGRESSOS
            String visibilidadeTexto = resultado.getString(7).toUpperCase();
            switch (visibilidadeTexto){
                case "PUBLICO":
                    visibilidade = VisibilidadeDados.PUBLICO;
                    break;
                case "PRIVADO":
                    visibilidade = VisibilidadeDados.PRIVADO;
                    break;
                case "SO_EGRESSOS":
                    visibilidade = VisibilidadeDados.SO_EGRESSOS;
                    break;
                default:
                    throw new RuntimeException("String visibilidade não identificada em: resultado.getString(7)");
            }

            Sexo sexo; // MASCULINO, FEMININO
            String sexoTexto = resultado.getString(8).toUpperCase();
            switch (sexoTexto) {
                case "MASCULINO":
                    sexo = Sexo.MASCULINO;
                    break;
                case "FEMININO":
                    sexo = Sexo.FEMININO;
                    break;
                default:
                    throw new RuntimeException("String sexo não identificada em: resultado.getString(8)");
            }

            egresso = new Egresso(
                id_Egresso,
                nome,
                nome_mae,
                data_nascimento,
                foto_principal,
                fotos_adicionais,
                visibilidade,
                sexo
            );

        }catch (Exception erro){
            erro.printStackTrace();
            System.err.println("ERRO NA EXECUÇÃO DA QUERY - GET EGRESSO BY ID!");

        }

        if (egresso == null) throw new RuntimeException("Egresso não encontrado!");
        else return egresso;
    }

    @Override
    public List<Egresso> getAll() throws SQLException{
        return null;
    }
}
