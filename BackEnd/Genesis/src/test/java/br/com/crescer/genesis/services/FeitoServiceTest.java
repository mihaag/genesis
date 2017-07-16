/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.genesis.services;

import br.com.crescer.genesis.entidades.Feito;
import br.com.crescer.genesis.entidades.Permissao;
import br.com.crescer.genesis.repositorios.FeitoRepositorio;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.mockito.runners.MockitoJUnitRunner;

/**
 *
 * @author alana'
 */
@RunWith(MockitoJUnitRunner.class)
public class FeitoServiceTest {

    @Mock
    private FeitoRepositorio feitoRepositorio;

    @InjectMocks
    private FeitoService feitoService;

    @Mock
    private Feito feito;

    /**
     * Test of buscarTodosFeitos method, of class FeitoService.
     */
    @Test
    public void testBuscarTodosFeitos() {
        Permissao permissao = new Permissao();
        permissao.setId(4l);
        permissao.setDescricao("publica");
        List<Feito> listFeito = new ArrayList<>();
        feito.setDescricao("descricao");
        feito.setId(0l);
        feito.setImagem("imegem.png");
        feito.setIdPermissao(permissao);
        short a = 2;
        feito.setRelevancia(a);
        listFeito.add(feito);
        when(feitoRepositorio.findAll()).thenReturn(listFeito);
        assertEquals(listFeito, feitoService.buscarTodosFeitos());
        verify(feitoRepositorio).findAll();

    }

    /**
     * Test of buscarFeitoPorId method, of class FeitoService.
     */
    @Test
    public void testBuscarFeitoPorId() {
        when(feitoRepositorio.findOneById(1l)).thenReturn(feito);
        assertEquals(feito, feitoService.buscarFeitoPorId(1l));
        verify(feitoRepositorio).findOneById(1l);
    }

    /**
     * Test of buscarPorNome method, of class FeitoService.
     */
    @Test
    public void testBuscarPorNome() {
        Permissao permissao = new Permissao();
        permissao.setId(4l);
        permissao.setDescricao("publica");
        List<Feito> listFeito = new ArrayList<>();
        feito.setNome("Nome");
        feito.setDescricao("descricao");
        feito.setId(0l);
        feito.setImagem("imegem.png");
        feito.setIdPermissao(permissao);
        short a = 2;
        feito.setRelevancia(a);
        listFeito.add(feito);
        when(feitoRepositorio.findByNomeIgnoreCase("nome")).thenReturn(listFeito);

        assertEquals(listFeito, feitoService.buscarPorNome("nome"));
        verify(feitoRepositorio).findByNomeIgnoreCase("nome");
    }

    /**
     * Test of buscarPorPermissao method, of class FeitoService.
     */
    @Test
    public void testBuscarPorPermissao() {
        Permissao permissao = new Permissao();
        permissao.setId(4l);
        permissao.setDescricao("publica");
        List<Feito> listFeito = new ArrayList<>();
        feito.setNome("Nome");
        feito.setDescricao("descricao");
        feito.setId(0l);
        feito.setImagem("imegem.png");
        feito.setIdPermissao(permissao);
        short a = 2;
        feito.setRelevancia(a);
        listFeito.add(feito);
        when(feitoRepositorio.findAllByIdPermissao(permissao)).thenReturn(listFeito);

        assertEquals(listFeito, feitoService.buscarPorPermissao(permissao));
        verify(feitoRepositorio).findAllByIdPermissao(permissao);
    }

    /**
     * Test of cadastrarFeito method, of class FeitoService.
     */
    @Test
    public void testCadastrarFeito() {
        Permissao permissao = new Permissao();
        permissao.setId(4l);
        permissao.setDescricao("publica");
        List<Feito> listFeito = new ArrayList<>();
        feito.setNome("Nome");
        feito.setDescricao("descricao");
        feito.setId(0l);
        feito.setImagem("imegem.png");
        feito.setIdPermissao(permissao);
        short a = 2;
        feito.setRelevancia(a);

        when(feitoRepositorio.findTop1ByNomeContainingIgnoreCase(feito.getNome())).thenReturn(null);
        assertEquals(feito, feitoService.cadastrarFeito(feito));
        verify(feitoRepositorio).save(feito);
        verify(feitoRepositorio).findTop1ByNomeContainingIgnoreCase(feito.getNome());
    }
    
    /**
     * Test of atualizarFeito method, of class FeitoService.
     */
    @Test
    public void testAtualizarFeito() {
        Permissao permissao = new Permissao();
        permissao.setId(4l);
        permissao.setDescricao("publica");
        List<Feito> listFeito = new ArrayList<>();
        feito.setNome("Nome");
        feito.setDescricao("descricao");
        feito.setId(0l);
        feito.setImagem("imegem.png");
        feito.setIdPermissao(permissao);
        short a = 2;
        feito.setRelevancia(a);
        assertEquals(feito, feitoService.atualizarFeito(feito));
        verify(feitoRepositorio).save(feito);
    }

    /**
     * Test of removerFeito method, of class FeitoService.
     */
    @Test
    public void testRemoverFeito() {
        Permissao permissao = new Permissao();
        permissao.setId(4l);
        permissao.setDescricao("publica");
        List<Feito> listFeito = new ArrayList<>();
        feito.setNome("Nome");
        feito.setDescricao("descricao");
        feito.setId(0l);
        feito.setImagem("imegem.png");
        feito.setIdPermissao(permissao);
        short a = 2;
        feito.setRelevancia(a);
        assertEquals(feito, feitoService.removerFeito(feito));
        verify(feitoRepositorio).delete(feito);
    }

}
