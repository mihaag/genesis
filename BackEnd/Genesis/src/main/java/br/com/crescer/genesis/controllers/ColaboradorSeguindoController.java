package br.com.crescer.genesis.controllers;

import br.com.crescer.genesis.entidades.ColaboradorSeguindo;
import br.com.crescer.genesis.services.ColaboradorSeguindoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Mirela
 */
@RestController
@RequestMapping(value = "/seguidores")
public class ColaboradorSeguindoController {
    @Autowired
    ColaboradorSeguindoService service;
    
    @PostMapping(value = "/follow/{id}")
    public ColaboradorSeguindo seguirColaborador(@PathVariable Long id, @AuthenticationPrincipal User user){
        return service.seguir(user, id);
    } 
    
    @PostMapping(value = "/unfollow/{id}")
    public ColaboradorSeguindo pararDeSeguirColaborador(@PathVariable Long id, @AuthenticationPrincipal User user){
        return service.pararDeSeguir(user, id);
    } 
}
