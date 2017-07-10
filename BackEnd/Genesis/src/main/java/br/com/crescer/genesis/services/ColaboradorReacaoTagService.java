package br.com.crescer.genesis.services;

import br.com.crescer.genesis.entidades.Colaborador;
import br.com.crescer.genesis.entidades.ColaboradorReacaoTag;
import br.com.crescer.genesis.entidades.ColaboradorTag;
import br.com.crescer.genesis.models.ColaboradorReacaoModel;
import br.com.crescer.genesis.repositorios.ColaboradorReacaoTagRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author alana'
 */
@Service
public class ColaboradorReacaoTagService {
    @Autowired
    ColaboradorReacaoTagRepositorio colabReacaoTagRepo;
    
    public ColaboradorReacaoTag adicionarCurtir(ColaboradorReacaoModel colabReacaoModel){
        ColaboradorReacaoTag colabReacaoTag = new ColaboradorReacaoTag();
         Colaborador colab = colabReacaoModel.getColaborador();
         ColaboradorTag colabTag = colabReacaoModel.getColaboradorTag();
          colabReacaoTag = colabReacaoTagRepo.findByIdColaboradorAndIdColaboradortag(colab, colabTag);
         if(colabReacaoTag == null){
            colabReacaoTag.setId(colabReacaoModel.getId());
            colabReacaoTag.setIdColaborador(colabReacaoModel.getColaborador());
            colabReacaoTag.setIdColaboradortag(colabReacaoModel.getColaboradorTag());
            colabReacaoTag.setReacao('S');
         }
         else{
             colabReacaoTag.setReacao('S');             
         }
        return colabReacaoTagRepo.save(colabReacaoTag);
    }
    
    public ColaboradorReacaoTag adicionarDescurtir(ColaboradorReacaoModel colabReacaoModel){
         ColaboradorReacaoTag colabReacaoTag = new ColaboradorReacaoTag();
         Colaborador colab = colabReacaoModel.getColaborador();
         ColaboradorTag colabTag = colabReacaoModel.getColaboradorTag();
          colabReacaoTag = colabReacaoTagRepo.findByIdColaboradorAndIdColaboradortag(colab, colabTag);
         if(colabReacaoTag == null){
            colabReacaoTag.setId(colabReacaoModel.getId());
            colabReacaoTag.setIdColaborador(colabReacaoModel.getColaborador());
            colabReacaoTag.setIdColaboradortag(colabReacaoModel.getColaboradorTag());
            colabReacaoTag.setReacao('N');
         }
         else colabReacaoTag.setReacao('N');

        return colabReacaoTagRepo.save(colabReacaoTag);
    }
}
