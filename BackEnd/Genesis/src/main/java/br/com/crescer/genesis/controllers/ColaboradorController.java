package br.com.crescer.genesis.controllers;

import br.com.crescer.genesis.entidades.Colaborador;
import br.com.crescer.genesis.entidades.VwUsuariosDisponiveis;
import br.com.crescer.genesis.security.SocialUserDetailsService;
import br.com.crescer.genesis.services.ColaboradorService;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Role;
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
        Colaborador u = Optional.ofNullable(authentication)
                .map(Authentication::getPrincipal)
                .map(User.class::cast)
                .map(User::getUsername)
                .map(colabService::buscarPorEmail)
                .orElse(null);
        final HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("dados", u);
        return hashMap;
    }

    @GetMapping
    public Iterable<Colaborador> buscarTodosColaboradores() {
        return colabService.buscarTodos();
    }

    @RequestMapping(value = "/perfil/{id}", method = RequestMethod.GET)
    public Colaborador buscarColaboradorPorID(@PathVariable("id") Long id) {
        return colabService.buscarPorID(id);
    }

    @RequestMapping(value = "/procurar/{texto}", method = RequestMethod.GET)
    public Iterable<Colaborador> buscarPorNome(@PathVariable("texto") String texto) {
         return colabService.buscarPorNome(texto);
    }
    
    @GetMapping("/buscarPorNomeComFiltro/{texto}")
    public Iterable<Object> buscarPorNomeComFiltro(@PathVariable("texto") String texto){
        return colabService.buscarPorNomeComFiltro(texto);
    }

    @PostMapping("/novo-acesso")
    public Colaborador buscarPorEmailCriptografado(@RequestBody Map<String, String> map) throws Exception {
        return colabService.buscarPorEmailCriptografado(map);
    }

    @PostMapping
    @Secured("ROLE_ADMINISTRADOR")
    public Colaborador cadastrarColaborador(@RequestBody Colaborador colab) throws Exception {
        return colabService.cadastrar(colab);
    }

    @PostMapping("/novo-acesso/nova-senha")
    public Colaborador cadastrarNovaSenha(@RequestBody HashMap<String, String> map) throws Exception {
        return colabService.cadastrarSenhaNova(map);
    }
    
    @PutMapping("/atualizar-senha")
    public Colaborador atualizarSenha(@RequestBody Colaborador colaborador) {
        return colabService.atualizarSenha(colaborador);
    }
    
    @PutMapping
    public Colaborador atualizarColaborador(@RequestBody Colaborador colab) {
        //NA SERVICE TESTAR PERMISSOES POIS OWNER SÓ PODE ALTERAR CAMPO SEDE DA TABELA COLABORADOR
        colabService.atualizar(colab);
        return colab;
    }

}
