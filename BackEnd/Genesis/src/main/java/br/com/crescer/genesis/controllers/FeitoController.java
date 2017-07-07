/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.genesis.controllers;

import br.com.crescer.genesis.entidades.Feito;
import br.com.crescer.genesis.services.FeitoService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author rafa
 */
@RestController
@RequestMapping(value = "/feitos")
public class FeitoController {
    
    @Autowired
    FeitoService service;
    
    @GetMapping
    public List<Feito> listarFeitos(){
        return service.buscarTodosFeitos();
    }
    
    @PostMapping
    public String cadastraFeito(Feito feito){
        return service.cadastrarFeito(feito);
    }
    
    @PutMapping
    public String atualizarFeito(Feito feito){
        return service.atualizarFeito(feito);
    }
    
    @DeleteMapping
    public String removerFeito(Feito feito){
        return service.removerFeito(feito);
    }
}
