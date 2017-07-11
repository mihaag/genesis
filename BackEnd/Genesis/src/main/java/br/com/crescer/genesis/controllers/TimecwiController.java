package br.com.crescer.genesis.controllers;

import br.com.crescer.genesis.entidades.Timecwi;
import br.com.crescer.genesis.models.TimeModel;
import br.com.crescer.genesis.models.TimePerfilModel;
import br.com.crescer.genesis.services.TimecwiService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
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
    public Timecwi cadastrarTime(@RequestBody TimeModel time){
        return timeService.cadastrarTime(time);
    }
    
    @RequestMapping(value = "/inativar/{id}", method = RequestMethod.POST)
    public Timecwi inativarTime(@PathVariable("id") Long id){
        return timeService.inativarTime(id);
    }
    
    @PutMapping
    public Timecwi alterarTime(@RequestBody TimeModel time){
        return timeService.alterar(time);
    }
    
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Timecwi buscarTimePorID(@PathVariable("id") Long id){
        return timeService.buscarPorID(id);
    }
    
    @GetMapping("/procurar")
    public List<Timecwi> buscarPorTermo(@RequestParam String termo){
        return timeService.buscarPorNomePesquisa(termo);
    }
    
    @GetMapping("/buscar-times")
    public List<TimePerfilModel> buscarTimesComFotos(){
        return timeService.buscarTimesComFotos();
    }
}
