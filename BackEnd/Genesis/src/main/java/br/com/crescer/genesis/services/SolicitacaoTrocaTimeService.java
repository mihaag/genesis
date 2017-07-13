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
    TimecwiColaboradorService timecwiColaboradorService;
    
    @Autowired
    ColaboradorService colaboradorService;
    
    public SolicitacaoTrocatime criarSolicitacao(SolicitacaoTrocatime solicitacao){
        return repositorio.save(solicitacao);
    }
    
    public List<SolicitacaoTrocatime> buscarSolicitacoes(Long id){
        Timecwi time = timeService.buscarPorID(id);
        return repositorio.findAllByIdNovotime(time);
    }    
    
    public HashMap<String,String> trocarDeTime(SolicitacaoTrocatime solicitacao){
         HashMap<String,String> map = new HashMap<>();
         repositorio.delete(solicitacao);        
         Colaborador col = colaboradorService.buscarPorID(solicitacao.getIdColaborador().getId());
         TimecwiColaborador timecwiColaborador = timecwiColaboradorService.buscarPorColaborador(col);
         timecwiColaboradorService.repositorio.delete(timecwiColaborador);
         
         TimecwiColaborador novoTime = new TimecwiColaborador();         
         novoTime.setId(0l);
         novoTime.setIdColaborador(solicitacao.getIdColaborador());
         novoTime.setIdTimecwi(solicitacao.getIdNovotime());
         novoTime.setTipo('M');
         
         timecwiColaboradorService.repositorio.save(novoTime);
         map.put("mensagem", "time trocado com sucesso");
         return map;
    }
}
