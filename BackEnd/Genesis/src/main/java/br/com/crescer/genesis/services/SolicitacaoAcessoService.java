package br.com.crescer.genesis.services;

import br.com.crescer.genesis.entidades.Colaborador;
import br.com.crescer.genesis.entidades.Email;
import br.com.crescer.genesis.entidades.SolicitacaoAcesso;
import br.com.crescer.genesis.repositorios.ColaboradorRepositorio;
import br.com.crescer.genesis.repositorios.SolicitacaoAcessoRepositorio;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author mirela.adam
 */
@Service
public class SolicitacaoAcessoService {

    @Autowired
    private SolicitacaoAcessoRepositorio repositorio;

    @Autowired
    private ColaboradorRepositorio colabRepositorio;

    @Autowired
    private EmailService emailService;

    public Iterable<SolicitacaoAcesso> buscarTodos() {
        return repositorio.findAll();
    }

    public SolicitacaoAcesso cadastrarSolicitacao(SolicitacaoAcesso solicitacao) {
        final String assunto = "Solicitação de Acesso";
        final String mensagem = "Usuário " + solicitacao.getEmail() + " solicita cadastro na rede Gênesis.";

        List<Colaborador> listaAdmins = (List<Colaborador>) colabRepositorio.findByIdPermissao_idIn(1L);
        emailService.enviarEmail(listaAdmins, assunto, mensagem);
        return repositorio.save(solicitacao);
    }

}
