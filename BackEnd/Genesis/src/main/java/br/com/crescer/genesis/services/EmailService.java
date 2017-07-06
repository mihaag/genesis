/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.genesis.services;

import br.com.crescer.genesis.entidades.Colaborador;
import br.com.crescer.genesis.entidades.Email;
import br.com.crescer.genesis.repositorios.EmailRepositorio;

/**
 *
 * @author rafael.barreto
 */
public class EmailService {
    
    /**     * 
     * @param colaborador
     * @param assunto
     * @param mensagem
     * metodo que recebe um colaborador um assunto e uma mensagems, depois
     * monta e envia um email para o colaborador especifico.
     */
    public void enviarEmail(Colaborador colaborador, String assunto, String mensagem){
        Email email = new Email();
        email.setColaborador(colaborador);
        email.setAssunto(assunto);
        email.setMensagem(mensagem);
        
        EmailRepositorio  repositorio = new EmailRepositorio();
        repositorio.enviarEmail(email);
    }
    
    
  
    
}
