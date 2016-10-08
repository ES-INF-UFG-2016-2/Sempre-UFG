package br.ufg.inf.servico;

import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;

public class EnviadorDeEmails {

    public void enviarEmailSimples(String para, String de, String assunto,
                                  String mensagem) throws EmailException {
        Email email = new SimpleEmail();
        email.addTo(para);
        email.setFrom(de);
        email.setSubject(assunto);
        email.setMsg(mensagem);
        email.setHostName("testmail.com");
        email.send();
    }

}
