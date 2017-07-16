package br.com.crescer.genesis.controllers;

import br.com.crescer.genesis.entidades.ColaboradorTag;
import br.com.crescer.genesis.services.ColaboradorTagService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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

    @PostMapping
    @Secured({"ROLE_ADMINISTRADOR", "ROLE_COLABORADOR", "ROLE_MASTER"})
    public ColaboradorTag cadastrarColaborador(@RequestBody ColaboradorTag colabTag) {
       ColaboradorTag cadastrar = colabTagService.adicionarTag(colabTag);
        return cadastrar;
  }
    
    @GetMapping
    public List<String> buscarTagsCadastradas(){
        List<String> tags = colabTagService.buscarTodos();
        return tags;
    }
    
    @DeleteMapping("/excluir/{id}")
    @Secured({"ROLE_ADMINISTRADOR", "ROLE_COLABORADOR", "ROLE_MASTER"})
    public void excluirTag(@PathVariable Long id ){
        colabTagService.excluirTag(id);
    }
    
    @GetMapping("/colaborador/{id}")
    public List<ColaboradorTag> buscarTagsColaborador(@PathVariable Long id){
       return colabTagService.buscarTagsColab(id);
    }
    
    @GetMapping("procurar")
    public List<ColaboradorTag> procurarPorDescricao(@RequestParam String termo){
        return colabTagService.procurarTagPorBusca(termo);
    }
    
}
