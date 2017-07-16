package br.com.crescer.genesis.controllers;

import br.com.crescer.genesis.entidades.ColaboradorFeito;
import br.com.crescer.genesis.services.ColaboradorFeitoService;
import br.com.crescer.genesis.services.ColaboradorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
    @Secured("ROLE_ADMINISTRADOR")
    public void vincularColaboradorFeito(@RequestBody ColaboradorFeito colFeito) {
        service.novoColaboradorFeito(colFeito);
    }

    @RequestMapping(value = "home-aut", method = RequestMethod.GET)
    public Iterable<ColaboradorFeito> buscarTodosColaboradoresFeitos(@AuthenticationPrincipal User user) {
            Iterable<ColaboradorFeito> listaAutenticada = service.buscarTodos(user);
            return listaAutenticada;
    } 
    
    @RequestMapping(value = "home-publica", method = RequestMethod.GET)
    public Iterable<ColaboradorFeito> buscarTodosColaboradoresFeitosPublicos() {
            Iterable<ColaboradorFeito> listaPublica = service.buscarTodos(null);
            return listaPublica;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Iterable<ColaboradorFeito> buscarFeitosDoColaborador(@AuthenticationPrincipal User user, @PathVariable("id") Long id) {
        Iterable<ColaboradorFeito> listaAutenticada = service.buscarFeitosPerfil(user, id);
        return listaAutenticada;
    }
    
    @RequestMapping(value = "perfil/{id}", method = RequestMethod.GET)
    public Iterable<ColaboradorFeito> buscarFeitosDoColaboradorPublico(@PathVariable("id") Long id) {
        Iterable<ColaboradorFeito> listaPublica = service.buscarFeitosPerfil(null, id);
        return listaPublica;
    }
}
