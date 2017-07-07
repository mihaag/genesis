package br.com.crescer.genesis.controllers;

import br.com.crescer.genesis.entidades.Colaborador;
import br.com.crescer.genesis.services.ColaboradorService;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author mirela.adam
 */
@RestController
@RequestMapping(value = "/colaboradores")
public class ColaboradorController {
    @Autowired 
    ColaboradorService colabService;
    
    
    @RequestMapping(value = "/usuario-logado", method = RequestMethod.GET)
    public Map<String, Object> retornarUsuarioLogado(Authentication authentication) {
        User u = Optional.ofNullable(authentication)
                .map(Authentication::getPrincipal)
                .map(User.class::cast)
                .orElse(null);
        final HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("dados", u);
        return hashMap;
    }
    
    @GetMapping
    public Iterable<Colaborador> buscarTodosColaboradores(){
        return colabService.buscarTodos();
    }
    
    @RequestMapping(value = "/perfil/{id}", method = RequestMethod.GET)
    public Colaborador buscarColaboradorPorID(@PathVariable("id") Long id) {
        return colabService.buscarPorID(id);
    } 
    
    @RequestMapping(value="/procurar/{texto}", method = RequestMethod.GET) 
    public Iterable<Colaborador> buscarPorNomeOuEmail (@PathVariable("texto") String texto) {
        return colabService.buscarPorEmailOuNome(texto);
    }
    
    @PostMapping
    //@Secured("Administrador")
    public Colaborador cadastrarColaborador(@RequestBody Colaborador colab) {
        colabService.cadastrar(colab);
        return colab;
    }
    
    @PutMapping
    public Colaborador atualizarColaborador(@RequestBody Colaborador colab) {
        
        //NA SERVICE TESTAR PERMISSOES POIS OWNER SÓ PODE ALTERAR CAMPO SEDE DA TABELA COLABORADOR
        colabService.atualizar(colab);
        return colab;
    }
    
}
