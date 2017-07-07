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
        email.setColaborador(listaColaborador);
        email.setAssunto(assunto);
        email.setMensagem(mensagem);
        sendEmail(email);
    }

    /**
     *
     * @param email
     */
    public void sendEmail(Email emails) {        
        String assunto = emails.getAssunto();
        String mensagem = emails.getMensagem();
        
        final String[] nome = emails.getColaborador().stream()
                .map(Colaborador::getNomecompleto).toArray(String[]::new);
        final String[] email = emails.getColaborador().stream()
                .map(Colaborador::getEmail).toArray(String[]::new);
        
        //configuracoes do sendmail para enviar email
        SendGrid.Email welcomeMail = new SendGrid.Email();
        welcomeMail.addTo(email);
        welcomeMail.addToName(nome);
        welcomeMail.setFrom("tccgenesios@gmail.com");
        welcomeMail.setSubject(assunto); // assunto do email;
        welcomeMail.setText(mensagem);// mensagem do email

        try {
            SendGrid.Response response = sendGrid.send(welcomeMail);
        } catch (SendGridException sge) {
            sge.printStackTrace();
        }
    }
}
