package br.com.crescer.genesis.repositorios;

import br.com.crescer.genesis.entidades.Colaborador;
import br.com.crescer.genesis.entidades.ColaboradorSeguindo;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author Mirela
 */
public interface ColaboradorSeguindoRepositorio extends CrudRepository<ColaboradorSeguindo, Long>{

    public ColaboradorSeguindo findOneByIdSeguidorAndIdSeguido(Colaborador seguidor, Colaborador seguido);

    
}
