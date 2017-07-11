package br.com.crescer.genesis.repositorios;

import br.com.crescer.genesis.entidades.SolicitacaoAcesso;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author mirela.adam
 */


public interface SolicitacaoAcessoRepositorio extends CrudRepository<SolicitacaoAcesso, Long> {
    public SolicitacaoAcesso findOneByEmail(String email);
}