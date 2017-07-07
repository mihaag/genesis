/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.genesis.services;

import br.com.crescer.genesis.entidades.Colaborador;
import br.com.crescer.genesis.entidades.Email;
import com.sendgrid.SendGrid;
import com.sendgrid.SendGridException;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author rafael.barreto
 */
@Service
public class EmailService {

    @Autowired
    private SendGrid sendGrid;

    /**
     * *
     * @param colaborador
     * @param assunto
     * @param mensagem metodo que recebe um colaborador um assunto e uma
     * mensagems, depois monta e envia um email para o colaborador especifico.
     */
    public void enviarEmail(List<Colaborador> listaColaborador, String assunto, String mensagem) {
        Email email = new Email();
        List<Email> listaEmail = new ArrayList<>();
        listaColaborador.forEach(colaborador -> {
            email.setColaborador(colaborador);
            email.setAssunto(assunto);
            email.setMensagem(mensagem);
            listaEmail.add(email);
        });
        sendEmail(listaEmail);
    }

    /**
     *
     * @param email
     */
    public void sendEmail(List<Email> emails) {
        List<String> nomesColaboradores = new ArrayList<>();
        List<String> emailColaboradores = new ArrayList<>();
        String assunto = emails.get(0).getAssunto();
        String mensagem = emails.get(0).getMensagem();

        for (Email email : emails) {
            nomesColaboradores.add(email.getColaborador().getNomecompleto());
            emailColaboradores.add(email.getMensagem());
        }
        //configuracoes do sendmail para enviar email
        SendGrid.Email welcomeMail = new SendGrid.Email();
        welcomeMail.addTo((String[]) emailColaboradores.toArray());
        welcomeMail.addToName((String[]) nomesColaboradores.toArray());
        welcomeMail.setFrom("tccgenesis@gmail.com");
        welcomeMail.setSubject(assunto); // assunto do email;
        welcomeMail.setText(mensagem);// mensagem do email

        try {
            SendGrid.Response response = sendGrid.send(welcomeMail);
        } catch (SendGridException sge) {
            sge.printStackTrace();
        }
    }
}
