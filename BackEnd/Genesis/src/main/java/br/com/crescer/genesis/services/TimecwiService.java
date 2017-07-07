package br.com.crescer.genesis.services;


import br.com.crescer.genesis.entidades.Timecwi;
import br.com.crescer.genesis.repositorios.TimecwiRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author mirela.adam
 */

@Service
public class TimecwiService {
    @Autowired
    private TimecwiRepositorio repositorio;

    public Iterable<Timecwi> buscarTodos() {
        return repositorio.findAll();
    }

    public Timecwi cadastrarTime(Timecwi time) {
        return repositorio.save(time);
    }
}
