package br.ufg.inf.sempreufg.servico;

import br.ufg.inf.sempreufg.modelo.CursoUFG;
import br.ufg.inf.sempreufg.modelo.Egresso;
import br.ufg.inf.sempreufg.modelo.HistoricoUFG;
import br.ufg.inf.sempreufg.modelo.LocalizacaoGeografica;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Testa a classe {@link AutenticacaoService}
 *
 * @author cleber
 */
public class AutenticacaoServiceTest {

    /**
     * Stub utilizado para testar a classe {@link AutenticacaoService}
     */
    private class AutenticacaoServiceStub extends AutenticacaoService {

        private final Egresso usuarioTeste = new Egresso();

        public AutenticacaoServiceStub() {
            usuarioTeste.setCpf(12345678901l);
            usuarioTeste.setMail("usuarioTeste@teste.com");
            usuarioTeste.setSenha("senhaTeste");

            usuarioTeste.setNome_mae("Mãe do Egresso");

            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
            try {
                usuarioTeste.setData_nascimento(simpleDateFormat.parse("29/10/1990"));
            } catch (ParseException exception) {
            }

            LocalizacaoGeografica naturalidade = new LocalizacaoGeografica();
            naturalidade.setNomeDoPais("Brasil");
            usuarioTeste.setNaturalidade(naturalidade);

            CursoUFG cursoEngenhariaSoftware = new CursoUFG();
            cursoEngenhariaSoftware.setNome("Engenharia de Software");
            CursoUFG cursoCienciasComputacao = new CursoUFG();
            cursoCienciasComputacao.setNome("Ciencias da Computação");
            List<HistoricoUFG> historicosUFG = new ArrayList<>();
            historicosUFG.add(new HistoricoUFG(123456, 0, 0, 0, 0, cursoEngenhariaSoftware, ""));
            historicosUFG.add(new HistoricoUFG(147852, 0, 0, 0, 0, cursoCienciasComputacao, ""));
            usuarioTeste.setLista_historicosUFG(historicosUFG);
        }

        @Override
        public boolean login(String login, String senha) {
            if (login == null || senha == null) {
                setErro("Login e senha são obrigatório(s)");
                setUsuarioAutenticado(null);
                setAutenticado(false);
            } else if ((login.equals(Long.toString(usuarioTeste.getCpf())) || login.equals(usuarioTeste.getMail()))
                    && senha.equals(usuarioTeste.getSenha())) {
                setErro("");
                setUsuarioAutenticado(usuarioTeste);
                setAutenticado(true);
            } else {
                setErro("Login e/ou senha inválido(s)");
                setUsuarioAutenticado(null);
                setAutenticado(false);
            }
            return isAutenticado();
        }

        @Override
        public boolean loginPrimeiroAcesso(Egresso egresso) {
            if (verificaInsuficienciaDadosAutenticacao(egresso)) {
                setErro("Dados insuficientes para autenticação");
                setUsuarioAutenticado(null);
                setAutenticado(false);
            } else if (egresso.getNome_mae().equals(usuarioTeste.getNome_mae())
                    && egresso.getData_nascimento() == usuarioTeste.getData_nascimento()
                    && egresso.getNaturalidade().getNomeDoPais().equals(usuarioTeste.getNaturalidade().getNomeDoPais())
                    && verificaCursoMatricula(egresso.getLista_historicosUFG().get(0))) {
                setErro("");
                setUsuarioAutenticado(egresso);
                setAutenticado(true);
            } else {
                setErro("Dados não conferem");
                setUsuarioAutenticado(null);
                setAutenticado(false);
            }
            return isAutenticado();
        }

        private boolean verificaInsuficienciaDadosAutenticacao(Egresso egresso) {
            return (egresso == null
                    || egresso.getNome_mae() == null
                    || egresso.getData_nascimento() == null
                    || egresso.getNaturalidade() == null
                    || egresso.getNaturalidade().getNomeDoPais() == null
                    || egresso.getLista_historicosUFG() == null
                    || egresso.getLista_historicosUFG().isEmpty()
                    || egresso.getLista_historicosUFG().get(0) == null
                    || egresso.getLista_historicosUFG().get(0).getCursoUFG() == null
                    || egresso.getLista_historicosUFG().get(0).getCursoUFG().getNome() == null);
        }

        private boolean verificaCursoMatricula(HistoricoUFG historicoUFG) {
            boolean cursoMatriculaConferem = false;
            for (HistoricoUFG historicoUFGSalvo : usuarioTeste.getLista_historicosUFG()) {
                if (historicoUFG.getNum_matricula() == historicoUFGSalvo.getNum_matricula()
                        && historicoUFG.getCursoUFG().getNome().equals(
                                historicoUFGSalvo.getCursoUFG().getNome())) {
                    cursoMatriculaConferem = true;
                    break;
                }
            }
            return cursoMatriculaConferem;
        }

    }

    private Egresso criarEgressoTestePadrao() {
        Egresso usuarioTeste = new Egresso();
        usuarioTeste.setNome_mae("Mãe do Egresso");

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
        try {
            usuarioTeste.setData_nascimento(simpleDateFormat.parse("29/10/1990"));
        } catch (ParseException exception) {
        }

        LocalizacaoGeografica naturalidade = new LocalizacaoGeografica();
        naturalidade.setNomeDoPais("Brasil");
        usuarioTeste.setNaturalidade(naturalidade);

        CursoUFG cursoEngenhariaSoftware = new CursoUFG();
        cursoEngenhariaSoftware.setNome("Engenharia de Software");
        CursoUFG cursoCienciasComputacao = new CursoUFG();
        cursoCienciasComputacao.setNome("Ciencias da Computação");
        ArrayList<CursoUFG> cursos = new ArrayList<>();
        cursos.add(cursoEngenhariaSoftware);
        cursos.add(cursoCienciasComputacao);
        List<HistoricoUFG> historicosUFG = new ArrayList<>();
        historicosUFG.add(new HistoricoUFG(123456, 0, 0, 0, 0, cursoEngenhariaSoftware, ""));
        historicosUFG.add(new HistoricoUFG(147852, 0, 0, 0, 0, cursoCienciasComputacao, ""));
        usuarioTeste.setLista_historicosUFG(historicosUFG);
        return usuarioTeste;
    }

    /**
     * Teste do método {@link AutenticacaoService#login(java.lang.String, java.lang.String) quando login e senha são ambos nulos.
     */
    @Test
    public void testLoginLoginSenhaNulos() {
        AutenticacaoService autenticacaoService = new AutenticacaoServiceStub();
        assertEquals(false, autenticacaoService.login(null, null));
    }

    /**
     * Teste do método {@link AutenticacaoService#login(java.lang.String, java.lang.String) quando o login é nulo.
     */
    @Test
    public void testLoginLoginNulo() {
        AutenticacaoService autenticacaoService = new AutenticacaoServiceStub();
        assertEquals(false, autenticacaoService.login(null, "senhaTeste"));
    }

    /**
     * Teste do método {@link AutenticacaoService#login(java.lang.String, java.lang.String) quando a senha é nula.
     */
    @Test
    public void testLoginSenhaNula() {
        AutenticacaoService autenticacaoService = new AutenticacaoServiceStub();
        assertEquals(false, autenticacaoService.login("12345678901", null));
    }

    /**
     * Teste do método {@link AutenticacaoService#login(java.lang.String, java.lang.String) quando login e senha são diferentes do esperado.
     */
    @Test
    public void testLoginLoginSenhaDiferentes() {
        AutenticacaoService autenticacaoService = new AutenticacaoServiceStub();
        assertEquals(false, autenticacaoService.login("98765432101", "minhaSenha"));
    }

    /**
     * Teste do método {@link AutenticacaoService#login(java.lang.String, java.lang.String) quando o login é diferente do esperado.
     */
    @Test
    public void testLoginLoginDiferente() {
        AutenticacaoService autenticacaoService = new AutenticacaoServiceStub();
        assertEquals(false, autenticacaoService.login("98765432101", "senhaTeste"));
    }

    /**
     * Teste do método {@link AutenticacaoService#login(java.lang.String, java.lang.String) quando a senha é diferente do esperado.
     */
    @Test
    public void testLoginSenhaDiferente() {
        AutenticacaoService autenticacaoService = new AutenticacaoServiceStub();
        assertEquals(false, autenticacaoService.login("12345678901", "minhaSenha"));
    }

    /**
     * Teste do método {@link AutenticacaoService#login(java.lang.String, java.lang.String) quando o login corresponde ao CPF.
     */
    @Test
    public void testLoginLoginCPF() {
        AutenticacaoService autenticacaoService = new AutenticacaoServiceStub();
        assertEquals(true, autenticacaoService.login("12345678901", "senhaTeste"));
    }

    /**
     * Teste do método {@link AutenticacaoService#login(java.lang.String, java.lang.String) quando o login corresponde ao email.
     */
    @Test
    public void testLoginLoginEmail() {
        AutenticacaoService autenticacaoService = new AutenticacaoServiceStub();
        assertEquals(true, autenticacaoService.login("usuarioTeste@teste.com", "senhaTeste"));
    }

    /**
     * Teste do método {@link AutenticacaoService#loginPrimeiroAcesso(br.ufg.inf.modelo.Egresso) quando o egresso é nulo.
     */
    @Test
    public void testLoginPrimeiroAcessoEgressoNulo() {
        Egresso egressoPrimeiroAcesso = null;
        AutenticacaoService instance = new AutenticacaoServiceStub();
        boolean resultado = instance.loginPrimeiroAcesso(egressoPrimeiroAcesso);
        assertEquals(false, resultado);
    }

    /**
     * Teste do método {@link AutenticacaoService#loginPrimeiroAcesso(br.ufg.inf.modelo.Egresso) quando o nome da mãe é nulo.
     */
    @Test
    public void testLoginPrimeiroAcessoNomeMaeNulo() {
        Egresso egressoPrimeiroAcesso = criarEgressoTestePadrao();

        egressoPrimeiroAcesso.setNome_mae(null);

        AutenticacaoService instance = new AutenticacaoServiceStub();
        boolean resultado = instance.loginPrimeiroAcesso(egressoPrimeiroAcesso);
        assertEquals(false, resultado);
    }

    /**
     * Teste do método {@link AutenticacaoService#loginPrimeiroAcesso(br.ufg.inf.modelo.Egresso) quando o nome da mãe não confere.
     */
    @Test
    public void testLoginPrimeiroAcessoNomeMaeNaoConfere() {
        Egresso egressoPrimeiroAcesso = criarEgressoTestePadrao();

        egressoPrimeiroAcesso.setNome_mae("Mãe inválida do egresso");

        AutenticacaoService instance = new AutenticacaoServiceStub();
        boolean resultado = instance.loginPrimeiroAcesso(egressoPrimeiroAcesso);
        assertEquals(false, resultado);
    }

    /**
     * Teste do método {@link AutenticacaoService#loginPrimeiroAcesso(br.ufg.inf.modelo.Egresso) quando a data de nascimento é nula.
     */
    @Test
    public void testLoginPrimeiroAcessoDataNascimentoNula() {
        Egresso egressoPrimeiroAcesso = criarEgressoTestePadrao();

        egressoPrimeiroAcesso.setData_nascimento(null);

        AutenticacaoService instance = new AutenticacaoServiceStub();
        boolean resultado = instance.loginPrimeiroAcesso(egressoPrimeiroAcesso);
        assertEquals(false, resultado);
    }

    /**
     * Teste do método {@link AutenticacaoService#loginPrimeiroAcesso(br.ufg.inf.modelo.Egresso) quando a data de nascimento não confere.
     */
    @Test
    public void testLoginPrimeiroAcessoDataNascimentoNaoConfere() {
        Egresso egressoPrimeiroAcesso = criarEgressoTestePadrao();

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
        try {
            egressoPrimeiroAcesso.setData_nascimento(simpleDateFormat.parse("11/12/1995"));
        } catch (ParseException exception) {
        }

        AutenticacaoService instance = new AutenticacaoServiceStub();
        boolean resultado = instance.loginPrimeiroAcesso(egressoPrimeiroAcesso);
        assertEquals(false, resultado);
    }

    /**
     * Teste do método {@link AutenticacaoService#loginPrimeiroAcesso(br.ufg.inf.modelo.Egresso) quando a nacionalidade é nula.
     */
    @Test
    public void testLoginPrimeiroAcessoNacionalidadeNula() {
        Egresso egressoPrimeiroAcesso = criarEgressoTestePadrao();

        egressoPrimeiroAcesso.setNaturalidade(null);

        AutenticacaoService instance = new AutenticacaoServiceStub();
        boolean resultado = instance.loginPrimeiroAcesso(egressoPrimeiroAcesso);
        assertEquals(false, resultado);
    }

    /**
     * Teste do método {@link AutenticacaoService#loginPrimeiroAcesso(br.ufg.inf.modelo.Egresso) quando o nome do país na nacionalidade é nulo.
     */
    @Test
    public void testLoginPrimeiroAcessoNomePaisNulo() {
        Egresso egressoPrimeiroAcesso = criarEgressoTestePadrao();

        LocalizacaoGeografica naturalidade = new LocalizacaoGeografica();
        naturalidade.setNomeDoPais(null);
        egressoPrimeiroAcesso.setNaturalidade(naturalidade);

        AutenticacaoService instance = new AutenticacaoServiceStub();
        boolean resultado = instance.loginPrimeiroAcesso(egressoPrimeiroAcesso);
        assertEquals(false, resultado);
    }

    /**
     * Teste do método {@link AutenticacaoService#loginPrimeiroAcesso(br.ufg.inf.modelo.Egresso) quando a nacionalidade não confere.
     */
    @Test
    public void testLoginPrimeiroAcessoNacionalidadeNaoConfere() {
        Egresso egressoPrimeiroAcesso = criarEgressoTestePadrao();

        LocalizacaoGeografica naturalidade = new LocalizacaoGeografica();
        naturalidade.setNomeDoPais("País Qualquer");
//        egressoPrimeiroAcesso.setNaturalidade(naturalidade);

        AutenticacaoService instance = new AutenticacaoServiceStub();
        boolean resultado = instance.loginPrimeiroAcesso(egressoPrimeiroAcesso);
        assertEquals(false, resultado);
    }

    /**
     * Teste do método {@link AutenticacaoService#loginPrimeiroAcesso(br.ufg.inf.modelo.Egresso) quando a lista de cursos é nula.
     */
    @Test
    public void testLoginPrimeiroAcessoListaCursosNula() {
        Egresso egressoPrimeiroAcesso = criarEgressoTestePadrao();

        egressoPrimeiroAcesso.setLista_historicosUFG(null);

        AutenticacaoService instance = new AutenticacaoServiceStub();
        boolean resultado = instance.loginPrimeiroAcesso(egressoPrimeiroAcesso);
        assertEquals(false, resultado);
    }

    /**
     * Teste do método {@link AutenticacaoService#loginPrimeiroAcesso(br.ufg.inf.modelo.Egresso) quando a lista de cursos é vazia.
     */
    @Test
    public void testLoginPrimeiroAcessoListaCursosVazia() {
        Egresso egressoPrimeiroAcesso = criarEgressoTestePadrao();

        egressoPrimeiroAcesso.setLista_historicosUFG(new ArrayList<HistoricoUFG>());

        AutenticacaoService instance = new AutenticacaoServiceStub();
        boolean resultado = instance.loginPrimeiroAcesso(egressoPrimeiroAcesso);
        assertEquals(false, resultado);
    }

    /**
     * Teste do método {@link AutenticacaoService#loginPrimeiroAcesso(br.ufg.inf.modelo.Egresso) quando o histórico é nulo.
     */
    @Test
    public void testLoginPrimeiroAcessoHistoricoNulo() {
        Egresso egressoPrimeiroAcesso = criarEgressoTestePadrao();

        List<HistoricoUFG> historicosUFG = new ArrayList<>();
        historicosUFG.add(null);
        egressoPrimeiroAcesso.setLista_historicosUFG(historicosUFG);

        AutenticacaoService instance = new AutenticacaoServiceStub();
        boolean resultado = instance.loginPrimeiroAcesso(egressoPrimeiroAcesso);
        assertEquals(false, resultado);
    }

    /**
     * Teste do método {@link AutenticacaoService#loginPrimeiroAcesso(br.ufg.inf.modelo.Egresso) quando a matrícula não confere.
     */
    @Test
    public void testLoginPrimeiroAcessoMatriculaNaoConfere() {
        Egresso egressoPrimeiroAcesso = criarEgressoTestePadrao();

        List<HistoricoUFG> historicosUFG = new ArrayList<>();
        historicosUFG.add(new HistoricoUFG(963258, 0, 0, 0, 0, null, ""));
        egressoPrimeiroAcesso.setLista_historicosUFG(historicosUFG);

        AutenticacaoService instance = new AutenticacaoServiceStub();
        boolean resultado = instance.loginPrimeiroAcesso(egressoPrimeiroAcesso);
        assertEquals(false, resultado);
    }

    /**
     * Teste do método {@link AutenticacaoService#loginPrimeiroAcesso(br.ufg.inf.modelo.Egresso) quando o curso é nulo.
     */
    @Test
    public void testLoginPrimeiroAcessoCursoNulo() {
        Egresso egressoPrimeiroAcesso = criarEgressoTestePadrao();

        List<HistoricoUFG> historicosUFG = new ArrayList<>();
        historicosUFG.add(new HistoricoUFG(123456, 0, 0, 0, 0, null, ""));
        egressoPrimeiroAcesso.setLista_historicosUFG(historicosUFG);

        AutenticacaoService instance = new AutenticacaoServiceStub();
        boolean resultado = instance.loginPrimeiroAcesso(egressoPrimeiroAcesso);
        assertEquals(false, resultado);
    }

    /**
     * Teste do método {@link AutenticacaoService#loginPrimeiroAcesso(br.ufg.inf.modelo.Egresso) quando o nome do curso é nulo.
     */
    @Test
    public void testLoginPrimeiroAcessoNomeCursoNulo() {
        Egresso egressoPrimeiroAcesso = criarEgressoTestePadrao();

        CursoUFG cursoCienciasComputacao = new CursoUFG();
        cursoCienciasComputacao.setNome(null);
        List<HistoricoUFG> historicosUFG = new ArrayList<>();
        historicosUFG.add(new HistoricoUFG(123456, 0, 0, 0, 0, cursoCienciasComputacao, ""));
        egressoPrimeiroAcesso.setLista_historicosUFG(historicosUFG);

        AutenticacaoService instance = new AutenticacaoServiceStub();
        boolean resultado = instance.loginPrimeiroAcesso(egressoPrimeiroAcesso);
        assertEquals(false, resultado);
    }

    /**
     * Teste do método {@link AutenticacaoService#loginPrimeiroAcesso(br.ufg.inf.modelo.Egresso) quando o nome do curso não confere.
     */
    @Test
    public void testLoginPrimeiroAcessoNomeCursoNaoConfere() {
        Egresso egressoPrimeiroAcesso = criarEgressoTestePadrao();

        CursoUFG cursoCienciasComputacao = new CursoUFG();
        cursoCienciasComputacao.setNome("Um curso qualquer");
        List<HistoricoUFG> historicosUFG = new ArrayList<>();
        historicosUFG.add(new HistoricoUFG(123456, 0, 0, 0, 0, cursoCienciasComputacao, ""));
        egressoPrimeiroAcesso.setLista_historicosUFG(historicosUFG);

        AutenticacaoService instance = new AutenticacaoServiceStub();
        boolean resultado = instance.loginPrimeiroAcesso(egressoPrimeiroAcesso);
        assertEquals(false, resultado);
    }

    /**
     * Teste do método {@link AutenticacaoService#loginPrimeiroAcesso(br.ufg.inf.modelo.Egresso) quando todas as informações conferem.
     */
    @Test
    public void testLoginPrimeiroAcessoSucesso() {
        Egresso egressoPrimeiroAcesso = criarEgressoTestePadrao();
        AutenticacaoService instance = new AutenticacaoServiceStub();
        boolean resultado = instance.loginPrimeiroAcesso(egressoPrimeiroAcesso);
        assertEquals(false, resultado);
    }

}
