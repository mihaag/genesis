
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.genesis.services;

import br.com.crescer.genesis.entidades.Colaborador;
import br.com.crescer.genesis.entidades.SolicitacaoTrocatime;
import br.com.crescer.genesis.entidades.Timecwi;
import br.com.crescer.genesis.entidades.TimecwiColaborador;
import br.com.crescer.genesis.repositorios.SolicitacaoTrocaTimeRepositorio;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author alana'
 */
@Service
public class SolicitacaoTrocaTimeService {

    @Autowired
    SolicitacaoTrocaTimeRepositorio repositorio;

    @Autowired
    TimecwiService timeService;

    @Autowired
    ColaboradorService colaboradorService;

    @Autowired
    TimecwiService timecwiService;

    @Autowired
    TimecwiColaboradorService timecwiColaboradorService;

    public SolicitacaoTrocatime criarSolicitacao(SolicitacaoTrocatime solicitacao) {
        return repositorio.save(solicitacao);
    }

    public List<SolicitacaoTrocatime> buscarSolicitacoes(Long id) {
        Timecwi time = timeService.buscarPorID(id);
        return repositorio.findAllByIdNovotime(time);
    }

    public Long countSolicitacoesTime(Long id) {
        Timecwi time = timeService.buscarPorID(id);
        return repositorio.countByIdNovotime(time);
    }

    public Map<String, String> deletarSolicitacao(SolicitacaoTrocatime solicitacao) {
        Map<String, String> map = new HashMap<>();
        repositorio.delete(solicitacao.getId());
        map.put("mensagem", "solicitacao deletada");
        return map;
    }

    public HashMap<String, String> trocarDeTime(SolicitacaoTrocatime solicitacao) {

        Colaborador col = colaboradorService.buscarPorID(solicitacao.getIdColaborador().getId());
        TimecwiColaborador timecwiColaborador = timecwiColaboradorService.buscarPorColaborador(col);
        if (timecwiColaborador != null) {
            timecwiColaboradorService.repositorio.delete(timecwiColaborador.getId());
        }

        TimecwiColaborador novoTime = new TimecwiColaborador();
        novoTime.setId(0l);
        novoTime.setIdColaborador(solicitacao.getIdColaborador());
        novoTime.setIdTimecwi(solicitacao.getIdNovotime());
        novoTime.setTipo('M');

        repositorio.delete(solicitacao.getId());
        timecwiColaboradorService.repositorio.save(novoTime);

        HashMap<String, String> map = new HashMap<>();
        map.put("mensagem", "time trocado com sucesso");
        return map;
    }
}
