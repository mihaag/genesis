/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.genesis.repositorios;

import br.com.crescer.genesis.entidades.Colaborador;
import br.com.crescer.genesis.entidades.Email;
import com.sendgrid.SendGrid;
import com.sendgrid.SendGridException;

/**
 *
 * @author rafael.barreto
 */
public class EmailRepositorio {
    
    public static void enviarEmail(Email email){
        
        String emailParaQualVaiSerEnviado = email.getColaborador().getEmail();
        String nomeDoColaborador = email.getColaborador().getNomecompleto();
        String assunto = email.getAssunto();
        String mensagem = email.getMensagem();
        
        //configuracoes do sendmail para enviar email
        SendGrid sendgrid = new SendGrid("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");// token da API
        SendGrid.Email welcomeMail = new SendGrid.Email();
        welcomeMail.addTo(emailParaQualVaiSerEnviado);
        welcomeMail.addToName(nomeDoColaborador);
        welcomeMail.setFrom("tccgenesis@gmail.com"); 
        welcomeMail.setSubject(assunto); // assunto do email;
        welcomeMail.setText("caro " + nomeDoColaborador+ " " + mensagem);// mensagem do email

        try {
            SendGrid.Response response = sendgrid.send(welcomeMail);           
        } catch (SendGridException sge) {
           sge.printStackTrace();
        }
    }
}
