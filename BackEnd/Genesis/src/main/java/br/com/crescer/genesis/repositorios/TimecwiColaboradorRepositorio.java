package br.com.crescer.genesis.repositorios;

import br.com.crescer.genesis.entidades.Colaborador;
import br.com.crescer.genesis.entidades.TimecwiColaborador;
import java.util.List;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author mirela.adam
 */
public interface TimecwiColaboradorRepositorio extends CrudRepository<TimecwiColaborador, Long>{

    public Iterable<TimecwiColaborador> findByIdTimecwi_idIn(Long id);
    public List<TimecwiColaborador> findByTipo(Character tipo);
    public List<TimecwiColaborador> findByTipoAndIdColaborador(Character tipo, Colaborador colaborador);
}
