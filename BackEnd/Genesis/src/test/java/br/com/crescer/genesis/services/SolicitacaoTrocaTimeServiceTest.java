/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.genesis.services;

import br.com.crescer.genesis.entidades.Colaborador;
import br.com.crescer.genesis.entidades.SolicitacaoTrocatime;
import br.com.crescer.genesis.entidades.Timecwi;
import br.com.crescer.genesis.repositorios.ColaboradorRepositorio;
import br.com.crescer.genesis.repositorios.SolicitacaoTrocaTimeRepositorio;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import static org.junit.Assert.assertEquals;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.mockito.runners.MockitoJUnitRunner;

/**
 *
 * @author alana'
 */
@RunWith(MockitoJUnitRunner.class)
public class SolicitacaoTrocaTimeServiceTest {

    @Mock
    private SolicitacaoTrocatime solicitacaoTrocaTime;

    @Mock
    private ColaboradorRepositorio colaboradorRepositorio;

    @Mock
    private SolicitacaoTrocaTimeRepositorio solicitacaoTrocatimeRepositorio;

    @Mock
    private Colaborador colaborador;

    @InjectMocks
    SolicitacaoTrocaTimeService solicitacaoTrocatimeService;

    @Mock
    TimecwiService timecwiService;

    /**
     * Test of criarSolicitacao method, of class SolicitacaoTrocaTimeService.
     */
    @Test
    public void testCriarSolicitacao() {
        when(solicitacaoTrocatimeRepositorio.save(solicitacaoTrocaTime)).thenReturn(solicitacaoTrocaTime);
        assertEquals(solicitacaoTrocaTime, solicitacaoTrocatimeService.criarSolicitacao(solicitacaoTrocaTime));
    }

    /**
     * Test of buscarSolicitacoes method, of class SolicitacaoTrocaTimeService.
     */
    @Test
    public void testBuscarSolicitacoes() {
        List<SolicitacaoTrocatime> listSolicitacao = new ArrayList<>();
        listSolicitacao.add(solicitacaoTrocaTime);

        Timecwi time = new Timecwi();
        when(timecwiService.buscarPorID(1l)).thenReturn(time);
        when(solicitacaoTrocatimeRepositorio.findAllByIdNovotime(time)).thenReturn(listSolicitacao);
        assertEquals(listSolicitacao, solicitacaoTrocatimeService.buscarSolicitacoes(1l));
        verify(timecwiService).buscarPorID(1L);
        verify(solicitacaoTrocatimeRepositorio).findAllByIdNovotime(time);
    }

    /**
     * Test of countSolicitacoesTime method, of class
     * SolicitacaoTrocaTimeService.
     */
    @Test
    public void testCountSolicitacoesTime() {
        List<SolicitacaoTrocatime> listSolicitacao = new ArrayList<>();
        listSolicitacao.add(solicitacaoTrocaTime);
        Timecwi time = new Timecwi();
        Long a = 1l;

        when(timecwiService.buscarPorID(1l)).thenReturn(time);
        when(solicitacaoTrocatimeRepositorio.countByIdNovotime(time)).thenReturn(a);

        assertEquals(a, solicitacaoTrocatimeService.countSolicitacoesTime(1l));
        verify(timecwiService).buscarPorID(1L);
        verify(solicitacaoTrocatimeRepositorio).countByIdNovotime(time);
    }

    /**
     * Test of deletarSolicitacao method, of class SolicitacaoTrocaTimeService.
     */
    @Test
    public void testDeletarSolicitacao() {
        Map<String, String> map = new HashMap<>();
        map.put("mensagem", "Solicitação excluída");

        when(colaboradorRepositorio.findOneById(8l)).thenReturn(colaborador);
        assertEquals(map, solicitacaoTrocatimeService.deletarSolicitacao(solicitacaoTrocaTime));
        verify(solicitacaoTrocatimeRepositorio).delete(solicitacaoTrocaTime.getId());
    }

}
