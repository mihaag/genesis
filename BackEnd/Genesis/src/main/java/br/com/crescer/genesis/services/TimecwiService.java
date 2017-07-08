package br.com.crescer.genesis.services;


import br.com.crescer.genesis.entidades.Timecwi;
import br.com.crescer.genesis.entidades.TimecwiColaborador;
import br.com.crescer.genesis.models.TimeModel;
import br.com.crescer.genesis.repositorios.ColaboradorRepositorio;
import br.com.crescer.genesis.repositorios.TimecwiColaboradorRepositorio;
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
     
    @Autowired
    private ColaboradorRepositorio colabRepositorio;

    @Autowired
    private TimecwiColaboradorRepositorio timeColabRepositorio;
    
    public Iterable<Timecwi> buscarTodos() {
        return repositorio.findAll();
    }

    public Timecwi cadastrarTime(TimeModel timeModel) {
        Timecwi time = new Timecwi();
        
        time.setId(timeModel.getId());
        time.setNome(timeModel.getNome());
        time.setDescricao(timeModel.getNome());
        time.setDescricaoresumida(timeModel.getDescricaoresumida());
        time.setSituacao(timeModel.getSituacao());
        
        time = repositorio.save(time);
        
        int quantidadeOwners = timeModel.getOwners().size();
        int quantidadeMembros = timeModel.getMembros().size();
        
        for(int i = 0; i < quantidadeOwners; i++){
            TimecwiColaborador timeCwiColab = new TimecwiColaborador();
            timeCwiColab.setId(0L);
            timeCwiColab.setIdColaborador(colabRepositorio.findOneById(timeModel.getOwners().get(i)));
            timeCwiColab.setIdTimecwi(time);
            timeCwiColab.setTipo('O');
            timeColabRepositorio.save(timeCwiColab);
        }
        
        for(int i = 0; i < quantidadeMembros; i++){
            TimecwiColaborador timeCwiColab = new TimecwiColaborador();
            timeCwiColab.setId(0L);
            timeCwiColab.setIdColaborador(colabRepositorio.findOneById(timeModel.getMembros().get(i)));
            timeCwiColab.setIdTimecwi(time);
            timeCwiColab.setTipo('M');
            timeColabRepositorio.save(timeCwiColab);
        }   
        return time;
    }
}
