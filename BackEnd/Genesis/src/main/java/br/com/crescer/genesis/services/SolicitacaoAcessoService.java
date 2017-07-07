package br.com.crescer.genesis.services;

import br.com.crescer.genesis.entidades.Colaborador;
import br.com.crescer.genesis.entidades.Email;
import br.com.crescer.genesis.entidades.SolicitacaoAcesso;
import br.com.crescer.genesis.repositorios.ColaboradorRepositorio;
import br.com.crescer.genesis.repositorios.EmailRepositorio;
import br.com.crescer.genesis.repositorios.SolicitacaoAcessoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author mirela.adam
 */
@Service
public class SolicitacaoAcessoService {
    @Autowired
    SolicitacaoAcessoRepositorio repositorio;
    
    @Autowired 
    ColaboradorRepositorio colabRepositorio;

    public Iterable<SolicitacaoAcesso> buscarTodos() {
        return repositorio.findAll();
    }

    public SolicitacaoAcesso cadastrarSolicitacao(SolicitacaoAcesso solicitacao) {    
        Email email = new Email();
        email.setAssunto("Solicitação de Acesso");
        email.setMensagem("Usuário " + solicitacao.getEmail() + " solicita cadastro na rede Genesis." );
        
        Iterable<Colaborador> listaAdmins = colabRepositorio.findByIdPermissao_idIn(1L);
        
        for (Colaborador usuarioAdministrador : listaAdmins) {
            email.setColaborador(usuarioAdministrador);
            EmailRepositorio.enviarEmail(email);
        }
        
        return repositorio.save(solicitacao);
    }
    
}