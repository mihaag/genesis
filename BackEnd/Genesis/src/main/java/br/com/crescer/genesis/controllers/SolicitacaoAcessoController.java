package br.com.crescer.genesis.controllers;

import br.com.crescer.genesis.entidades.SolicitacaoAcesso;
import br.com.crescer.genesis.services.SolicitacaoAcessoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author mirela.adam
 */

@RestController
@RequestMapping(value = "/solicitacao-acesso")
public class SolicitacaoAcessoController {
    @Autowired 
    SolicitacaoAcessoService service;
        
    @GetMapping
    public Iterable<SolicitacaoAcesso> buscarTodasSolicitacoes(){
        return service.buscarTodos();
    }
    
    @PostMapping
    public SolicitacaoAcesso cadastrarSolicitacao(@RequestBody SolicitacaoAcesso solicitacao){      
        return service.cadastrarSolicitacao(solicitacao);
    }
}

