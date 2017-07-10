package br.com.crescer.genesis.repositorios;

import br.com.crescer.genesis.entidades.Colaborador;
import br.com.crescer.genesis.entidades.ColaboradorReacaoTag;
import br.com.crescer.genesis.entidades.ColaboradorTag;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author alana'
 */
public interface ColaboradorReacaoTagRepositorio extends CrudRepository<ColaboradorReacaoTag, Long>{
    public ColaboradorReacaoTag findOneById(Long id);
public ColaboradorReacaoTag findByIdColaboradorAndIdColaboradortag(Colaborador colab, ColaboradorTag colabTag);
}
