package br.com.crescer.genesis.controllers;

import br.com.crescer.genesis.services.SolicitacaoTrocaTimeService;
import br.com.crescer.genesis.entidades.SolicitacaoTrocatime;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author alana'
 */
@RestController
@RequestMapping(value = "/trocar-time")
public class SolicitacaoTrocaTimeController {
    @Autowired
    SolicitacaoTrocaTimeService service;
    
    @PostMapping
    @Secured({"ROLE_ADMINISTRADOR", "ROLE_COLABORADOR", "ROLE_MASTER"})
    public SolicitacaoTrocatime criarSolicitacao(@RequestBody SolicitacaoTrocatime solicitacao){
        return service.criarSolicitacao(solicitacao);
    }
    
    @PostMapping("/remover-solicitacao")
    @Secured({"ROLE_ADMINISTRADOR", "ROLE_COLABORADOR", "ROLE_MASTER"})
    public Map<String,String> removerSolicitacao(@RequestBody SolicitacaoTrocatime solicitacaoTrocatime){
        return service.deletarSolicitacao(solicitacaoTrocatime);
    }
    
    @GetMapping("/{id}")
    @Secured({"ROLE_ADMINISTRADOR", "ROLE_COLABORADOR", "ROLE_MASTER"})
    public List<SolicitacaoTrocatime> buscarSolicitacoesDoTime(@PathVariable Long id){
       return service.buscarSolicitacoes(id);
    }

    @GetMapping("/quant-solicitacoes/{id}")
    @Secured({"ROLE_ADMINISTRADOR", "ROLE_COLABORADOR", "ROLE_MASTER"})
    public Long contarSolicitacoes(@PathVariable Long id){
       return service.countSolicitacoesTime(id);
    }
}
