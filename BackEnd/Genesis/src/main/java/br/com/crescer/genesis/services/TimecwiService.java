package br.com.crescer.genesis.services;

import br.com.crescer.genesis.entidades.Colaborador;
import br.com.crescer.genesis.entidades.Timecwi;
import br.com.crescer.genesis.entidades.TimecwiColaborador;
import br.com.crescer.genesis.models.TimeModel;
import br.com.crescer.genesis.models.TimePerfilModel;
import br.com.crescer.genesis.repositorios.ColaboradorRepositorio;
import br.com.crescer.genesis.repositorios.TimecwiColaboradorRepositorio;
import br.com.crescer.genesis.repositorios.TimecwiRepositorio;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author mirela.adam
 */
@Service
public class TimecwiService {

    @Autowired
    private TimecwiRepositorio timeRepositorio;

    @Autowired
    private ColaboradorRepositorio colabRepositorio;

    @Autowired
    private TimecwiColaboradorRepositorio timeColabRepositorio;

    public Iterable<Timecwi> buscarTodos() {
        return timeRepositorio.findAll();
    }

    public Timecwi cadastrarTime(TimeModel timeModel) {
        Timecwi time = new Timecwi();

        time.setId(timeModel.getId());
        time.setNome(timeModel.getNome());
        time.setDescricao(timeModel.getDescricao());
        time.setDescricaoresumida(timeModel.getDescricaoresumida());
        time.setSituacao(timeModel.getSituacao());

        time = timeRepositorio.save(time);

        int quantidadeOwners = timeModel.getOwners().size();
        int quantidadeMembros = timeModel.getMembros().size();

        for (int i = 0; i < quantidadeOwners; i++) {
            Colaborador owner = colabRepositorio.findOneById(timeModel.getOwners().get(i));            
            RemoverVinculoTimeColaborador(owner);            
            owner.setPossuiTime('S');
            
            TimecwiColaborador timeCwiColab = new TimecwiColaborador();
            timeCwiColab.setId(0L);
            timeCwiColab.setIdColaborador(owner);
            timeCwiColab.setIdTimecwi(time);
            timeCwiColab.setTipo('O');

            timeColabRepositorio.save(timeCwiColab);
        }

        for (int i = 0; i < quantidadeMembros; i++) {
            Colaborador membro = colabRepositorio.findOneById(timeModel.getMembros().get(i));            
            RemoverVinculoTimeColaborador(membro);
            membro.setPossuiTime('S');
            
            TimecwiColaborador timeCwiColab = new TimecwiColaborador();
            timeCwiColab.setId(0L);
            timeCwiColab.setIdColaborador(membro);
            timeCwiColab.setIdTimecwi(time);
            timeCwiColab.setTipo('M');

            timeColabRepositorio.save(timeCwiColab);
        }
        return time;
    }

    public Timecwi inativarTime(Long id) {
        Timecwi time = timeRepositorio.findOneById(id);
        time.setSituacao('I');
        time = timeRepositorio.save(time);

        Iterable<TimecwiColaborador> membros = timeColabRepositorio.findByIdTimecwi_idIn(id);

        for (TimecwiColaborador membro : membros) {
            Colaborador c = membro.getIdColaborador();
            c.setPossuiTime('N');
            colabRepositorio.save(c);
            timeColabRepositorio.delete(membro);
        }

        return time;
    }

    public Timecwi buscarPorID(Long id) {
        return timeRepositorio.findOneById(id);
    }

    public List<Timecwi> buscarPorNomePesquisa(String termo) {
        return timeRepositorio.findByNomeContainingIgnoreCase(termo);
    }
    
    public List<TimePerfilModel> buscarTimesComFotosPorPesquisa(String termo){
        List<Timecwi> listaResultadosPesquisa = buscarPorNomePesquisa(termo);
        List<TimePerfilModel> resultadosComFotos = new ArrayList();
        for(Timecwi time : listaResultadosPesquisa){
            System.out.println(time.getId());
            resultadosComFotos.add(buscarTimePorIdComFotos(time.getId()));
        }
        return resultadosComFotos;
    }

    public Timecwi alterar(TimeModel timeModel) {
        Timecwi time = timeRepositorio.findOneById(timeModel.getId());

        time.setNome(timeModel.getNome());
        time.setDescricao(timeModel.getDescricao());
        time.setDescricaoresumida(timeModel.getDescricaoresumida());
        time.setSituacao(timeModel.getSituacao());
        timeRepositorio.save(time);

        Iterable<TimecwiColaborador> membros = timeColabRepositorio.findByIdTimecwi_idIn(time.getId());
        for (TimecwiColaborador membro : membros) {
            Colaborador c = membro.getIdColaborador();
            c.setPossuiTime('N');
            colabRepositorio.save(c);
            timeColabRepositorio.delete(membro);
        }

        int quantidadeOwners = timeModel.getOwners().size();
        int quantidadeMembros = timeModel.getMembros().size();

        for (int i = 0; i < quantidadeOwners; i++) {
            Colaborador owner = colabRepositorio.findOneById(timeModel.getOwners().get(i));
            owner.setPossuiTime('S');
            colabRepositorio.save(owner);

            TimecwiColaborador timeCwiColab = new TimecwiColaborador();
            timeCwiColab.setId(0L);
            timeCwiColab.setIdColaborador(owner);
            timeCwiColab.setIdTimecwi(time);
            timeCwiColab.setTipo('O');

            timeColabRepositorio.save(timeCwiColab);
        }

        for (int i = 0; i < quantidadeMembros; i++) {
            Colaborador membro = colabRepositorio.findOneById(timeModel.getMembros().get(i));
            membro.setPossuiTime('S');
            colabRepositorio.save(membro);

            TimecwiColaborador timeCwiColab = new TimecwiColaborador();
            timeCwiColab.setId(0L);
            timeCwiColab.setIdColaborador(membro);
            timeCwiColab.setIdTimecwi(time);
            timeCwiColab.setTipo('M');

            timeColabRepositorio.save(timeCwiColab);
        }

        return time;
    }

    public List<TimePerfilModel> buscarTimesComFotos() {
        Iterable<Timecwi> timesCadastrados = timeRepositorio.findAll();
        List<TimePerfilModel> listaDeTimesComFotosDosMembros = new ArrayList<>();

        for (Timecwi time : timesCadastrados) {
            TimePerfilModel timePerfil = new TimePerfilModel();
            timePerfil.setTime(time);

            List<String> linksFotos = new ArrayList<>();

            Iterable<TimecwiColaborador> colaboradores = timeColabRepositorio.findByIdTimecwi_idIn(time.getId());
            for (TimecwiColaborador colab : colaboradores) {
                linksFotos.add(colabRepositorio.findOneById(colab.getIdColaborador().getId()).getFoto());
            }

            if (linksFotos.size() == 0) {
                linksFotos.add("http://icon-icons.com/icons2/632/PNG/512/users_icon-icons.com_57999.png");
            }
            timePerfil.setFotosMembros(linksFotos);
            listaDeTimesComFotosDosMembros.add(timePerfil);
        }

        return listaDeTimesComFotosDosMembros;
    }

    public TimePerfilModel buscarTimePorIdComFotos(Long id) {
        Timecwi timecwi = timeRepositorio.findOneById(id);
        TimePerfilModel timePerfil = new TimePerfilModel();
        timePerfil.setTime(timecwi);

        List<String> linksFotos = new ArrayList<>();
        Iterable<TimecwiColaborador> colaboradores = timeColabRepositorio.findByIdTimecwi_idIn(timecwi.getId());

        for (TimecwiColaborador colab : colaboradores) {
            linksFotos.add(colabRepositorio.findOneById(colab.getIdColaborador().getId()).getFoto());
        }

        if (linksFotos.size() == 0) {
            linksFotos.add("http://icon-icons.com/icons2/632/PNG/512/users_icon-icons.com_57999.png");
        }
        timePerfil.setFotosMembros(linksFotos);
        return timePerfil;
    }

    private void RemoverVinculoTimeColaborador(Colaborador owner){
        TimecwiColaborador time = timeColabRepositorio.findOneByidColaborador(owner);            
            if(time != null)
                timeColabRepositorio.delete(time);
    }
}
