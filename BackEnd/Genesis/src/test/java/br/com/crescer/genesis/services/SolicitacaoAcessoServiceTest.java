/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.genesis.services;

import br.com.crescer.genesis.entidades.SolicitacaoAcesso;
import br.com.crescer.genesis.repositorios.ColaboradorRepositorio;
import br.com.crescer.genesis.repositorios.SolicitacaoAcessoRepositorio;
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
public class SolicitacaoAcessoServiceTest {

    @Mock
    private SolicitacaoAcesso solicitacaoAcesso;

    @Mock
    private ColaboradorRepositorio colaboradorRepositorio;
    @Mock
    private SolicitacaoAcessoRepositorio solicitacaoAcessoRepositorio;

    @InjectMocks
    private SolicitacaoAcessoService solicitacaoAcesoService;

    /**
     * Test of buscarTodos method, of class SolicitacaoAcessoService.
     */
    @Test
    public void testBuscarTodos() {

    }

    /**
     * Test of cadastrarSolicitacao method, of class SolicitacaoAcessoService.
     */
    @Test
    public void testCadastrarSolicitacao() {

    }

    /**
     * Test of removerSolicitacao method, of class SolicitacaoAcessoService.
     */
    @Test
    public void testRemoverSolicitacao() {
        String email = "alanaeweiss@gmail.com";
        when(solicitacaoAcessoRepositorio.findOneByEmail(email)).thenReturn(solicitacaoAcesso);
       
        SolicitacaoAcessoService solicitacaoAcessoMock = mock(SolicitacaoAcessoService.class);
        doNothing().when(solicitacaoAcessoMock).removerSolicitacao(email);
    }

}
