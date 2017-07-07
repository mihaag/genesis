package br.com.crescer.genesis.services;

import br.com.crescer.genesis.entidades.Timecwi;
import br.com.crescer.genesis.entidades.TimecwiColaborador;
import br.com.crescer.genesis.repositorios.TimecwiColaboradorRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
/**
 *
 * @author mirela.adam
 */
@Service
public class TimecwiColaboradorService  {
    @Autowired
    TimecwiColaboradorRepositorio repositorio;
    
     public Iterable<TimecwiColaborador> buscarTodos() {
        return repositorio.findAll();
    }
    
}
