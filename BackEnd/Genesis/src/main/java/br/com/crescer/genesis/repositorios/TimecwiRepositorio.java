package br.com.crescer.genesis.repositorios;

import br.com.crescer.genesis.entidades.Timecwi;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author mirela.adam
 */
public interface TimecwiRepositorio extends CrudRepository<Timecwi, Long>{

    public Timecwi findOneById(Long id);
    
}
