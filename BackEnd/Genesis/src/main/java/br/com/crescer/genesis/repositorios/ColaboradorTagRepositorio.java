package br.com.crescer.genesis.repositorios;

import br.com.crescer.genesis.entidades.ColaboradorTag;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author alana'
 */
public interface ColaboradorTagRepositorio extends CrudRepository<ColaboradorTag, Long> {

    public ColaboradorTag findOneById(Long id);
    
    @Query("SELECT DISTINCT(LOWER(t.descricao)) FROM ColaboradorTag t")
    List<String> findTagsDistintas();
    
    public List<ColaboradorTag> findAllByDescricaoContaining(String termo);
}
