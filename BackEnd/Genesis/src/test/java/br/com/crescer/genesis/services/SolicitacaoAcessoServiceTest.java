/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.genesis.services;

import br.com.crescer.genesis.entidades.Colaborador;
import br.com.crescer.genesis.entidades.SolicitacaoAcesso;
import br.com.crescer.genesis.repositorios.ColaboradorRepositorio;
import br.com.crescer.genesis.repositorios.SolicitacaoAcessoRepositorio;
import java.util.ArrayList;
import java.util.List;
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
public class SolicitacaoAcessoServiceTest {

    @Mock
    private SolicitacaoAcesso solicitacaoAcesso;

    @Mock
    private ColaboradorRepositorio colaboradorRepositorio;
    
    @Mock
    private SolicitacaoAcessoRepositorio solicitacaoAcessoRepositorio;

    @Mock
    private Colaborador colaborador;
    
    @Mock
    private EmailService emailService;

    @InjectMocks
    private SolicitacaoAcessoService solicitacaoAcessoService;

    /**
     * Test of buscarTodos method, of class SolicitacaoAcessoService.
     */
    @Test
    public void testBuscarTodos() {
        List<SolicitacaoAcesso> listSolicitacao = new ArrayList<>();
        listSolicitacao.add(solicitacaoAcesso);
        
        when(solicitacaoAcessoRepositorio.findAll()).thenReturn(listSolicitacao);
        assertEquals(listSolicitacao, solicitacaoAcessoService.buscarTodos());
        verify(solicitacaoAcessoRepositorio).findAll();
    }

    /**
     * Test of cadastrarSolicitacao method, of class SolicitacaoAcessoService.
     */
    @Test
    public void testCadastrarSolicitacao() {
        List<Colaborador> listColab = new ArrayList<>();
        listColab.add(colaborador);
               
        when(colaboradorRepositorio.findByIdPermissao_idIn(1L)).thenReturn(listColab);
        when(solicitacaoAcessoRepositorio.save(solicitacaoAcesso)).thenReturn(solicitacaoAcesso);
        assertEquals(solicitacaoAcesso, solicitacaoAcessoService.cadastrarSolicitacao(solicitacaoAcesso));
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
