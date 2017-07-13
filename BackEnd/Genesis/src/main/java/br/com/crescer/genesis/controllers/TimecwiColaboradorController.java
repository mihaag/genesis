package br.com.crescer.genesis.controllers;

import br.com.crescer.genesis.entidades.Colaborador;
import br.com.crescer.genesis.entidades.SolicitacaoTrocatime;
import br.com.crescer.genesis.entidades.TimecwiColaborador;
import br.com.crescer.genesis.services.ColaboradorService;
import br.com.crescer.genesis.services.SolicitacaoTrocaTimeService;
import br.com.crescer.genesis.services.TimecwiColaboradorService;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Mirela
 */

@RestController
@RequestMapping(value = "/times-colaboradores")
public class TimecwiColaboradorController {
    
    @Autowired 
    TimecwiColaboradorService service;    
    
    @Autowired
    ColaboradorService serviceColaborador; 
    
    @Autowired
    SolicitacaoTrocaTimeService solicitacaoTrocatime;
    
    
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Iterable<TimecwiColaborador> buscarColaboradoresDoTime(@PathVariable("id") Long id) {
        return service.buscarColaboradoresPorIdDoTime(id);
    }
    
    @GetMapping
    public List<TimecwiColaborador> buscarOwners(){
        return service.buscarOwners();
    }
    
    @GetMapping("/owner")
    public TimecwiColaborador timesOndeUserEhOwner(@AuthenticationPrincipal User user){
       Colaborador colab = serviceColaborador.buscarPorEmail(user.getUsername());
       return service.buscarTimeDoOwner(colab);
    }
    
    @PostMapping("/confirmar-troca")
    public Map<String,String> confirmarTrocaDeTime(@RequestBody SolicitacaoTrocatime trocatime){
       return solicitacaoTrocatime.trocarDeTime(trocatime);
    }
}
