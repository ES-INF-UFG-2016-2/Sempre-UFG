package br.ufg.inf;

import org.mariadb.jdbc.MariaDbDataSource;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import static org.junit.Assert.assertEquals;

public class DBConnection {
    String host = "localhost";
    int porta = 13306;
    String nomeBanco = "SempreUFG";
    String usuario = "";
    String senha = "";

    public Connection getConexao(Properties propriedadesDaConexao) throws SQLException {
        String url = "jdbc:mariadb://" + host + ":" + porta + "/" + nomeBanco;
        propriedadesDaConexao.setProperty("user", usuario);
        propriedadesDaConexao.setProperty("password", senha);
        return DriverManager.getConnection(url, propriedadesDaConexao);
    }

    private void testarConexao() throws SQLException {

        MariaDbDataSource banco = new MariaDbDataSource();
        banco.setDatabaseName(nomeBanco);
        banco.setPort(porta);
        banco.setServerName(host);

        Connection conexao = getConexao(new Properties());

        try {
            assertEquals(conexao.isValid(0), true);
        } finally {
            if (conexao != null) {
                try {
                    conexao.close();
                } catch (Exception e) {
                }
            }
        }

    }

}
