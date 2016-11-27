package br.ufg.inf.sempreufg.dao;

import br.ufg.inf.sempreufg.db.ConexaoBanco;
import br.ufg.inf.sempreufg.enums.Sexo;
import br.ufg.inf.sempreufg.enums.VisibilidadeDados;
import br.ufg.inf.sempreufg.interfaces.EgressoDAOInterface;
import br.ufg.inf.sempreufg.modelo.Egresso;
import com.sun.mail.iap.ByteArray;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Arrays;
import java.util.Date;
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
            instrucao.setBytes(4, egresso.getFoto_principal());
            instrucao.setBytes(5, egresso.getFotos_adicionais());
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
        if (conexao == null) conexao = ConexaoBanco.getConnection();
        Egresso egresso = null;

        try{
            String selectEgresso = "SELECT (id, nome, nome_mae, data_nascimento, foto_principal, " +
                "fotos_adicionais, visibilidade, sexo) FROM egresso WHERE id = '" + id_egresso + "';";

            instrucao = conexao.prepareStatement(selectEgresso);
            ResultSet resultado = instrucao.executeQuery();

            String id_Egresso = resultado.getString(1);
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
                    throw new RuntimeException("String sexo não identificada em: resultado.getString(8)")
            }

            egresso = new Egresso(
                id_egresso,
                nome,
                nome_mae,
                data_nascimento,
                foto_principal,
                fotos_adicionais,
                visibilidade,
                sexo
            );

        }catch (Exception erro){
            System.out.println("ERRO NA EXECUÇÃO DA QUERY - GET EGRESSO BY ID!");
            erro.printStackTrace();
        }

        if (egresso == null) throw new RuntimeException("Egresso não encontrado!");
        else return egresso;
    }

    @Override
    public List<Egresso> getAll() {
        return null;
    }
}
