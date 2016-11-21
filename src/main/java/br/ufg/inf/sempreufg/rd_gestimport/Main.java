package br.ufg.inf.sempreufg.rd_gestimport;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);

    private static ConexaoDb db = new ConexaoDb();
    private static List<Teste> testes = new LinkedList<Teste>();

    public static void main(String[] args) {
        System.out.println("###### Teste RD - GestImport ######");
        System.out.println("Informe abaixo os dados de conexão com o banco de dados postgreSQL.");
        solicitarDadosDoBanco();
        try {
            db.abraConexao();
            RdGestImport rd = getDddGestImport();
            testes.add(new TesteTimestamp(db.getConexao(), rd));
            testes.add(new TesteInicioPeriodo(db.getConexao(), rd));
            testes.add(new TesteFimPeriodo(db.getConexao(), rd));
            testes.add(new TesteEgressosRecebidos(db.getConexao(), rd));
            testes.add(new TesteImportadosComSucesso(db.getConexao(), rd));
            testes.add(new TesteEgressosIncorretos(db.getConexao(), rd));
            testes.add(new TesteEgressosReplicados(db.getConexao(), rd));
            testes.add(new TesteUsuario(db.getConexao(), rd));
            testes.add(new TestePK(db.getConexao(), rd));
            do {
                efetuarTestes();
                System.out.println("Digite SAIR para finalizar os testes ou tecle enter para realizar os testes novamente:");
            } while (!Main.ler("sim").toUpperCase().equals("SAIR"));
        } catch (Exception e) {
            System.out.println(e);
            main(args);
        }
    }

    private static void solicitarDadosDoBanco() {
        try {
            System.out.println();
            System.out.print("HOST (localhost):");
            db.setUrl(ler("localhost"));
            System.out.print("Porta (5432):");
            db.setPorta(ler(5432));
            System.out.print("Base de dados:");
            db.setBaseDeDados(Main.<String>ler(null));
            System.out.print("Usuário (postgres):");
            db.setUsuario(ler("postgres"));
            System.out.print("Senha:");
            db.setSenha(Main.<String>ler(""));
        } catch (Exception e) {
            System.err.println("Dado informado é inválido, tente novamente");
            solicitarDadosDoBanco();
        }
    }

    private static RdGestImport getDddGestImport() {
        RdGestImport rd = new RdGestImport();
        rd.setNomeTabela("processo_importacao");
        rd.setColunaTimestamp("momento_execucao");
        rd.setColunaInicioPeriodo("inicio_periodo");
        rd.setColunaFimPeriodo("fim_periodo");
        rd.setColunaQtdSucesso("quantidade_importados_sucesso");
        rd.setColunaQtdIncorretos("quantidade_importados_dados_incorretos");
        rd.setColunaQtdReplicados("quantidade_importados_replicados");
        rd.setColunaQtdRecebidos("quantidade_egressos_recebidos");
        rd.setColunaIdentificador("id");
        rd.setColunaUsuario("id_usuario_autorizador");
        return rd;
    }

    private static <T> T ler(T def) {
        try {
            String cheese = null;
            cheese = scanner.nextLine();
            if (cheese.isEmpty()) {
                if (def != null && !def.toString().equals("0")) {
                    return def;
                } else {
                    throw new Exception();
                }
            } else {
                return (T) cheese;
            }
        } catch (Exception e) {
            System.out.print("Valor informado é inválido, tente novamente:");
            return Main.ler(def);
        }
    }

    private static <T> T ler() {
        return Main.<T>ler(null);
    }

    private static int ler(int def) {
        try {
            String cheese = null;
            cheese = scanner.nextLine();
            if (cheese.isEmpty()) {
                if (def != 0) {
                    return def;
                } else {
                    throw new Exception();
                }
            } else {
                return Integer.parseInt(cheese);
            }
        } catch (Exception e) {
            System.out.print("Valor informado é inválido, tente novamente:");
            return Main.ler(def);
        }
    }

    private static void efetuarTestes() {
        boolean colunaFaltando = false;
        System.out.println("Iniciando teste da tabela processo_importacao.");
        for (Teste t : testes) {
            if (!t.testeExistencia()) {
                System.out.println("Coluna " + t.getNomeColuna() + " não existe na tabela de processo_importacao.");
                colunaFaltando = true;
            }
        }
        if (!colunaFaltando) {
            for (Teste t : testes) {
                t.efetuarTestes();
                System.out.println();
            }
        } else {
            System.out.println("Para realizar os teste é necessário todas as colunas na tabela.");
        }
    }
}
