package br.ufg.inf;

import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;

public class Email {

    public static void enviarEmail(String emailSolicitante) throws EmailException {
        SimpleEmail email = new SimpleEmail();
        SimpleEmail email2 = new SimpleEmail();
        email.setSslSmtpPort("465");
        email.setAuthentication("sempreufg2", "sempreufg2016");
        email.setHostName("smtp.gmail.com"); // o servidor SMTP para envio do e-mail
        email.addTo(emailSolicitante, "Solicitante"); //destinatÃ¡rio
        email.setFrom("sempreufg2@gmail.com", "SempreUFG"); // remetente
        email.setSubject("Email de confirmação"); // assunto do e-mail
        email.setMsg("Este é o e-mail confirmando que sua solicitação foi bem "
                + "e que aguarda um parecer."); //conteudo do e-mail
        email.setSSL(true);
        email.setTLS(true);
        email.send();
        
        //Enviando email para o responsável por aprovar a solicitação
        
        email2.setSslSmtpPort("465");
        email2.setAuthentication("sempreufg2", "sempreufg2016");
        email2.setHostName("smtp.gmail.com"); // o servidor SMTP para envio do e-mail
        email2.addTo("matheus_estudante@hotmail.com", " Gestor do Sistema"); //destinatÃ¡rio
        email2.setFrom("sempreufg2@gmail.com", "SempreUFG"); // remetente
        email2.setSubject("Email para aprovação"); // assunto do e-mail
        email2.setMsg("Este é o e-mail que informa que existe uma solicitação "
                + "aguardando parecer."); //conteudo do e-mail
        email2.setSSL(true);
        email2.setTLS(true);
        email2.send();
    }

}
