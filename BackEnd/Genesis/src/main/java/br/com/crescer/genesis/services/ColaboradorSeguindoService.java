package br.com.crescer.genesis.services;

import br.com.crescer.genesis.entidades.Colaborador;
import br.com.crescer.genesis.entidades.ColaboradorSeguindo;
import br.com.crescer.genesis.repositorios.ColaboradorRepositorio;
import br.com.crescer.genesis.repositorios.ColaboradorSeguindoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;

/**
 *
 * @author Mirela
 */
@Service
public class ColaboradorSeguindoService {
    @Autowired
    ColaboradorSeguindoRepositorio repositorio;
    
    @Autowired 
    ColaboradorRepositorio colabRepositorio; 

    public ColaboradorSeguindo seguir(User user, Long id) {
        Colaborador seguidor = colabRepositorio.findOneByEmail(user.getUsername());
        Colaborador seguido = colabRepositorio.findOneById(id);
        
        ColaboradorSeguindo relacao = new ColaboradorSeguindo();
        relacao.setIdSeguido(seguido);
        relacao.setIdSeguidor(seguidor);
        
        return repositorio.save(relacao);
    }

    public ColaboradorSeguindo pararDeSeguir(User user, Long id) {
        Colaborador seguidor = colabRepositorio.findOneByEmail(user.getUsername());
        Colaborador seguido = colabRepositorio.findOneById(id);
    
        ColaboradorSeguindo relacao = repositorio.findOneByIdSeguidorAndIdSeguido(seguidor, seguido);
        repositorio.delete(relacao);
        return relacao;
    }
    
}
