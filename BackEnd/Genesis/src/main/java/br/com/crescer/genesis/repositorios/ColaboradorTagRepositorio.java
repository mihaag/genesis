package br.com.crescer.genesis.repositorios;

import br.com.crescer.genesis.entidades.ColaboradorTag;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author alana'
 */
public interface ColaboradorTagRepositorio extends CrudRepository<ColaboradorTag, Long> {

    public ColaboradorTag findOneById(Long id);
    
}
