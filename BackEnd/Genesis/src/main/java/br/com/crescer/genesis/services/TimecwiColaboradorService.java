package br.com.crescer.genesis.services;

import br.com.crescer.genesis.entidades.Colaborador;
import br.com.crescer.genesis.entidades.TimecwiColaborador;
import br.com.crescer.genesis.repositorios.TimecwiColaboradorRepositorio;
import java.util.List;
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

    public Iterable<TimecwiColaborador> buscarColaboradoresPorIdDoTime(Long id) {
        return repositorio.findByIdTimecwi_idIn(id);
    }
    
    public List<TimecwiColaborador> buscarOwners(){
        return repositorio.findByTipo('O');
    }
    
    public List<TimecwiColaborador> buscarTimeDoOwner(Colaborador colab){
        return repositorio.findByTipoAndIdColaborador('O', colab);
    }
    
}
