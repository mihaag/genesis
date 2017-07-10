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

    public ColaboradorReacaoTag adicionarCurtir(ColaboradorReacaoModel colabReacaoModel) {
        ColaboradorReacaoTag colabReacaoTag = new ColaboradorReacaoTag();
        Colaborador colab = colabReacaoModel.getColaborador();
        ColaboradorTag colabTag = colabReacaoModel.getColaboradorTag();
        colabReacaoTag = colabReacaoTagRepo.findByIdColaboradorAndIdColaboradortag(colab, colabTag);
        if (colabReacaoTag == null) {
            ColaboradorReacaoTag aux = new ColaboradorReacaoTag();
            aux.setId(colabReacaoModel.getId());
            aux.setIdColaborador(colabReacaoModel.getColaborador());
            aux.setIdColaboradortag(colabReacaoModel.getColaboradorTag());
            aux.setReacao('S');
            return colabReacaoTagRepo.save(aux);
        }
        
        colabReacaoTag.setReacao('S');             
        return colabReacaoTagRepo.save(colabReacaoTag);

    }

    public ColaboradorReacaoTag adicionarDescurtir(ColaboradorReacaoModel colabReacaoModel) {
        ColaboradorReacaoTag colabReacaoTag = new ColaboradorReacaoTag();
        Colaborador colab = colabReacaoModel.getColaborador();
        ColaboradorTag colabTag = colabReacaoModel.getColaboradorTag();
        colabReacaoTag = colabReacaoTagRepo.findByIdColaboradorAndIdColaboradortag(colab, colabTag);
        if (colabReacaoTag == null) {
            ColaboradorReacaoTag aux = new ColaboradorReacaoTag();
            aux.setId(colabReacaoModel.getId());
            aux.setIdColaborador(colabReacaoModel.getColaborador());
            aux.setIdColaboradortag(colabReacaoModel.getColaboradorTag());
            aux.setReacao('N');
            return colabReacaoTagRepo.save(aux);
        }
        colabReacaoTag.setReacao('N');
        return colabReacaoTagRepo.save(colabReacaoTag);
    }
}
