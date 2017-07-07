package br.com.crescer.genesis.controllers;

import br.com.crescer.genesis.entidades.Timecwi;
import br.com.crescer.genesis.services.TimecwiService;
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
@RequestMapping(value = "/times")
public class TimecwiController {
    @Autowired 
    TimecwiService timeService;
    
    @GetMapping
    public Iterable<Timecwi> buscarTodosTimes(){
        return timeService.buscarTodos();
    }
    
    @PostMapping
    public Timecwi cadastrarTime(@RequestBody Timecwi time){
        return timeService.cadastrarTime(time);
    }
    
}
