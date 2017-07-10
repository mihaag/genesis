package br.com.crescer.genesis.services;

import br.com.crescer.genesis.entidades.ColaboradorTag;
import br.com.crescer.genesis.repositorios.ColaboradorTagRepositorio;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
/*
 * @author alana'
 */
@Service
public class ColaboradorTagService {
    @Autowired
    ColaboradorTagRepositorio colabTagRepositorio;
    @Autowired
    ColaboradorService colabService;

    public List<String> buscarTodos() {
        return colabTagRepositorio.findTagsDistintas();
    }

    public ColaboradorTag buscarPorID(Long id) { 
        return colabTagRepositorio.findOneById(id);
    }


    public ColaboradorTag adicionarTag(ColaboradorTag colabTag) {
        return colabTagRepositorio.save(colabTag);
    }
    
    public void excluirTag(Long id){
       ColaboradorTag colabTag = colabTagRepositorio.findOneById(id);
       colabTagRepositorio.delete(colabTag);
    }
}
