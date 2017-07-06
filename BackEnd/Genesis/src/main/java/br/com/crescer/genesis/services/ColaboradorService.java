package br.com.crescer.genesis.services;

import br.com.crescer.genesis.entidades.Colaborador;
import br.com.crescer.genesis.repositorios.ColaboradorRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
/*
 * @author mirela.adam
 */
@Service
public class ColaboradorService {
    @Autowired
    ColaboradorRepositorio colabRepositorio;

    public Iterable<Colaborador> buscarTodos() {
        return colabRepositorio.findAll();
    }

    public Colaborador buscarPorID(Long id) {
        return colabRepositorio.findOneById(id);
    }

    public Iterable<Colaborador> buscarPorEmailOuNome(String texto) {
        return colabRepositorio.findByNomecompletoContainingIgnoreCase(texto);
    }

    public Colaborador cadastrar(Colaborador colab) {
        return colabRepositorio.save(colab);
    }

    public Colaborador atualizar(Colaborador colab) {
        return colabRepositorio.save(colab);
    }
}
