/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.genesis.controllers;

import br.com.crescer.genesis.entidades.ColaboradorReacaoTag;
import br.com.crescer.genesis.models.ColaboradorReacaoModel;
import br.com.crescer.genesis.services.ColaboradorReacaoTagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author alana'
 */
@RestController
@RequestMapping(value = "/colaborador-reacao")
public class ColaboradorReacaoTagController {
    @Autowired 
    ColaboradorReacaoTagService reacaoService;
    
    @PostMapping("/curtir")
    public ColaboradorReacaoTag adicionarReacaoCurtir(@RequestBody ColaboradorReacaoModel colabReacaoModel){
        return reacaoService.adicionarCurtir(colabReacaoModel);
    }
    
    @PostMapping(value = "/descurtir")
    public ColaboradorReacaoTag descurtir(@RequestBody ColaboradorReacaoModel colabReacaoModel){
        return reacaoService.adicionarDescurtir(colabReacaoModel);
    }
}
