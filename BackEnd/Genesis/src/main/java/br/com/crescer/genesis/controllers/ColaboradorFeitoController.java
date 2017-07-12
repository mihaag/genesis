/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.genesis.controllers;

import br.com.crescer.genesis.entidades.Colaborador;
import br.com.crescer.genesis.entidades.ColaboradorFeito;
import br.com.crescer.genesis.services.ColaboradorFeitoService;
import br.com.crescer.genesis.services.ColaboradorService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author rafae
 */
@RestController
@RequestMapping(value = "/colaboradores-feitos")
public class ColaboradorFeitoController {

    @Autowired
    ColaboradorFeitoService service;

    @Autowired
    ColaboradorService serviceColaborador;

    @PostMapping
    public void vincularColaboradorFeito(@RequestBody ColaboradorFeito colFeito) {
        service.novoColaboradorFeito(colFeito);
    }

    @GetMapping
    public Iterable<ColaboradorFeito> buscarTodosColaboradoresFeitos(@AuthenticationPrincipal User user) {
        if (user != null) {
            Colaborador colab = serviceColaborador.buscarPorEmail(user.getUsername());
            Iterable<ColaboradorFeito> listaAutenticada = service.buscarTodos(colab);
            return listaAutenticada;
        } else {
            Iterable<ColaboradorFeito> listaPublica = service.feitosPublicos();
            return listaPublica;
        }
    }

}
