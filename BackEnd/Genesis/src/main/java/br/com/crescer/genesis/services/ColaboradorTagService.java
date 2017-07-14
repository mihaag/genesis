package br.com.crescer.genesis.services;

import br.com.crescer.genesis.entidades.Colaborador;
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
        colabTag.setDescricao(colabTag.getDescricao().toLowerCase());
        return colabTagRepositorio.save(colabTag);
    }
    
    public void excluirTag(Long id){
       ColaboradorTag colabTag = colabTagRepositorio.findOneById(id);
       colabTagRepositorio.delete(colabTag);
    }
    
    public List<ColaboradorTag> procurarTagPorBusca(String termo){
        return colabTagRepositorio.findAllByDescricaoContaining(termo.toLowerCase());
    }
    
    public List<ColaboradorTag> buscarTagsColab(Long id){
         Colaborador colab = colabService.buscarPorID(id);
        return colabTagRepositorio.findAllByIdColaborador(colab);
    }
}
