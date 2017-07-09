package br.com.crescer.genesis.services;

import br.com.crescer.genesis.entidades.Colaborador;
import br.com.crescer.genesis.entidades.ColaboradorTag;
import br.com.crescer.genesis.repositorios.ColaboradorTagRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
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

    public Iterable<ColaboradorTag> buscarTodos() {
        return colabTagRepositorio.findAll();
    }

    public ColaboradorTag buscarPorID(Long id) { 
        return colabTagRepositorio.findOneById(id);
    }


    public ColaboradorTag adicionarTag(ColaboradorTag colabTag) {
        return colabTagRepositorio.save(colabTag);
    }
}
