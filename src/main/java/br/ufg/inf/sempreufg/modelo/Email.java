package br.ufg.inf.sempreufg.modelo;

import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Email {

    private static final String EMAIL_PADRAO =
        "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
            + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

    private static final Pattern padrao = Pattern.compile(EMAIL_PADRAO, Pattern.CASE_INSENSITIVE);

    public static boolean validarEmail(String email){
        Matcher matcher = padrao.matcher(email);
        return matcher.matches();
    }

    public static void enviarEmail(String emailSolicitante) throws EmailException {
        SimpleEmail email = new SimpleEmail();
        SimpleEmail email2 = new SimpleEmail();
        email.setSslSmtpPort("465");
        email.setAuthentication("sempreufg2", "sempreufg2016");
        email.setHostName("smtp.gmail.com"); // o servidor SMTP para envio do e-mail
        email.addTo(emailSolicitante, "Solicitante"); //destinatário
        email.setFrom("sempreufg2@gmail.com", "SempreUFG"); // remetente
        email.setSubject("Email de confirma��o"); // assunto do e-mail
        email.setMsg("Este � o e-mail confirmando que sua solicita��o foi bem "
                + "e que aguarda um parecer."); //conteudo do e-mail
        email.setSSL(true);
        email.setTLS(true);
        email.send();

        //Enviando email para o respons�vel por aprovar a solicita��o

        email2.setSslSmtpPort("465");
        email2.setAuthentication("sempreufg2", "sempreufg2016");
        email2.setHostName("smtp.gmail.com"); // o servidor SMTP para envio do e-mail
        email2.addTo("matheus_estudante@hotmail.com", " Gestor do Sistema"); //destinatário
        email2.setFrom("sempreufg2@gmail.com", "SempreUFG"); // remetente
        email2.setSubject("Email para aprova��o"); // assunto do e-mail
        email2.setMsg("Este � o e-mail que informa que existe uma solicita��o "
                + "aguardando parecer."); //conteudo do e-mail
        email2.setSSL(true);
        email2.setTLS(true);
        email2.send();
    }


}
