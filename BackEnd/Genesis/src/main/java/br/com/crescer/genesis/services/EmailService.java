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
        final int tamanhoArray = emails.getColaborador().size();
        String [] nome = new String[tamanhoArray];
        String [] email = new String[tamanhoArray];
        String assunto = emails.getAssunto();
        String mensagem = emails.getMensagem();
        
        for(int i = 0 ; i < tamanhoArray ; i++){
            nome[i] = emails.getColaborador().get(i).getNomecompleto();
            email[i] = emails.getColaborador().get(i).getEmail();
        }
        
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
