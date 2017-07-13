package br.com.crescer.genesis.controllers;

import br.com.crescer.genesis.entidades.Colaborador;
import br.com.crescer.genesis.entidades.TimecwiColaborador;
import br.com.crescer.genesis.entidades.VwUsuariosDisponiveis;
import br.com.crescer.genesis.services.TimecwiColaboradorService;
import br.com.crescer.genesis.services.VwUsuariosDisponiveisService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
    VwUsuariosDisponiveisService vwUsuariosDisponiveisService;
    
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Iterable<TimecwiColaborador> buscarColaboradoresDoTime(@PathVariable("id") Long id) {
        return service.buscarColaboradoresPorIdDoTime(id);
    }
    
    @GetMapping("/teste")
    public List<Colaborador> timesComMaisDeUmOwner(){
        return (List<Colaborador>)vwUsuariosDisponiveisService.buscarTodos();
    }            
}
