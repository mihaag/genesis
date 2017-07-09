package br.com.crescer.genesis.controllers;

import br.com.crescer.genesis.entidades.ColaboradorTag;
import br.com.crescer.genesis.services.ColaboradorTagService;
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
@RequestMapping(value = "/colaborador-tag")
public class ColaboradorTagController {
   @Autowired 
    ColaboradorTagService colabTagService;
//
    @PostMapping
    //@Secured("Administrador")
    public ColaboradorTag cadastrarColaborador(@RequestBody ColaboradorTag colabTag) {
       ColaboradorTag cadastrar = colabTagService.adicionarTag(colabTag);
        return cadastrar;
  }
    
}
