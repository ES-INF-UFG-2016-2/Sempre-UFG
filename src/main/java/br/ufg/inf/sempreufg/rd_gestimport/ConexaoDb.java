package br.ufg.inf.sempreufg.rd_gestimport;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConexaoDb {

    private String url;
    private String baseDeDados;
    private String usuario;
    private String senha;
    private int porta = 5432;
    private Connection conexao;

    public ConexaoDb(String url, String baseDeDados, String usuario, String senha, Connection conexao) {
        this.url = url;
        this.baseDeDados = baseDeDados;
        this.usuario = usuario;
        this.senha = senha;
        this.conexao = conexao;
    }

    public ConexaoDb(String url, String baseDeDados, String usuario, String senha, int porta) {
        this.url = url;
        this.baseDeDados = baseDeDados;
        this.usuario = usuario;
        this.senha = senha;
        this.porta = porta;
    }

    public ConexaoDb() {

    }

    public Connection getConexao() {
        return conexao;
    }

    public String getBaseDeDados() {
        return baseDeDados;
    }

    public void setBaseDeDados(String baseDeDados) {
        this.baseDeDados = baseDeDados;
    }

    public int getPorta() {
        return porta;
    }

    public void setPorta(Integer porta) {
        this.porta = porta;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String toString() {
        return String.format("jdbc:postgresql://%s:%s/%s", getUrl(), getPorta(), getBaseDeDados());
    }

    public void abraConexao() {
        try {
            Properties props = new Properties();
            props.setProperty("user", getUsuario());
            props.setProperty("password", getSenha());
            this.conexao = DriverManager.getConnection(this.toString(), props);
        } catch (SQLException e) {
            throw new IllegalArgumentException(
                    "Erro ao tentar conectar ao banco de dados.\n" +
                            "URL:" + this.toString() + "\n" +
                            "Usuário:" + this.getUsuario() + "\n" +
                            "Erro:" + e.getMessage()
            );
        }
    }
}
