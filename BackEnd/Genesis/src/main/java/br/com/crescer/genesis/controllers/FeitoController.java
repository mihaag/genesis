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
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
    public Feito cadastraFeito(@RequestBody Feito feito){
       return service.cadastrarFeito(feito);
    }
    
    @PutMapping
    public Feito atualizarFeito(@RequestBody Feito feito){
        return service.atualizarFeito(feito);
    }
    
    @RequestMapping(value = "/excluir", method = RequestMethod.POST)
    public Feito removerFeito(@RequestBody Feito feito){
        return service.removerFeito(feito);
    }
    
    @GetMapping("/{id}")
    public Feito procurarPorId(@PathVariable Long id){
        return service.buscarFeitoPorId(id);
    }
}
