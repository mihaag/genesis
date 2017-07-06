package br.com.crescer.genesis.repositorios;

import br.com.crescer.genesis.entidades.Colaborador;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author mirela.adam
 */
public interface ColaboradorRepositorio extends CrudRepository<Colaborador, Long> {

    public Colaborador findOneById(Long id);

    public Iterable<Colaborador> findByNomecompletoContainingIgnoreCase(String texto);
    
}
