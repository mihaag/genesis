/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.genesis.controllers;

import br.com.crescer.genesis.services.SolicitacaoTrocaTimeService;
import br.com.crescer.genesis.entidades.SolicitacaoTrocatime;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author alana'
 */
@RestController
@RequestMapping(value = "/trocar-time")
public class SolicitacaoTrocaTimeController {
    @Autowired
    SolicitacaoTrocaTimeService service;
    
    @PostMapping
    public SolicitacaoTrocatime criarSolicitacao(@RequestBody SolicitacaoTrocatime solicitacao){
        return service.criarSolicitacao(solicitacao);
    }
    
    @GetMapping("/{id}")
    public List<SolicitacaoTrocatime> buscarSolicitacoesDoTime(@PathVariable Long id){
       return service.buscarSolicitacoes(id);
    }
    @GetMapping("/quant-solicitacoes/{id}")
    public Long contarSolicitacoes(@PathVariable Long id){
       return service.countSolicitacoesTime(id);
    }
}
