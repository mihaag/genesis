/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.genesis.services;

import br.com.crescer.genesis.entidades.Colaborador;
import br.com.crescer.genesis.entidades.ColaboradorTag;
import br.com.crescer.genesis.repositorios.ColaboradorRepositorio;
import br.com.crescer.genesis.repositorios.ColaboradorTagRepositorio;
import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.assertEquals;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.mockito.runners.MockitoJUnitRunner;

/**
 *
 * @author alana'
 */
@RunWith(MockitoJUnitRunner.class)
public class ColaboradorTagServiceTest {

    @Mock
    private ColaboradorTagRepositorio colaboradorTagRepositorio;
    
    @Mock
    private ColaboradorRepositorio colaboradorRepositorio;

    @InjectMocks
    private ColaboradorTagService colaboradorTagService;
    
    @Mock
    private ColaboradorService colaboradorService;

    @Mock
    private ColaboradorTag colaboradorTag;

    @Mock
    private Colaborador colaborador;

    /**
     * Test of buscarTodos method, of class ColaboradorTagService.
     */
    @Test
    public void testBuscarTodos() {
        List<String> listTag = new ArrayList<>();
        colaboradorTag.setDescricao("tag1");
        listTag.add(colaboradorTag.getDescricao());
        colaboradorTag.setDescricao("tag1");
        listTag.add(colaboradorTag.getDescricao());

        when(colaboradorTagRepositorio.findTagsDistintas()).thenReturn(listTag);
        assertEquals(listTag, colaboradorTagService.buscarTodos());
        verify(colaboradorTagRepositorio).findTagsDistintas();
    }

    /**
     * Test of buscarPorID method, of class ColaboradorTagService.
     */
    @Test
    public void testBuscarPorID() {
        when(colaboradorTagRepositorio.findOneById(8l)).thenReturn(colaboradorTag);
        assertEquals(colaboradorTag, colaboradorTagService.buscarPorID(8l));
        verify(colaboradorTagRepositorio).findOneById(8l);
    }

    /**
     * Test of adicionarTag method, of class ColaboradorTagService.
     */
    @Test
    public void testAdicionarTag() {
        colaboradorTag = new ColaboradorTag();
        colaboradorTag.setDescricao("teste");
        colaboradorTag.setId(1l);
        colaboradorTag.setIdColaborador(colaborador);
        ColaboradorTag aux = colaboradorTag;

        when(colaboradorTagRepositorio.save(colaboradorTag)).thenReturn(aux);

        assertEquals(colaboradorTag, colaboradorTagService.adicionarTag(colaboradorTag));

        verify(colaboradorTagRepositorio).save(colaboradorTag);
    }

    /**
     * Test of procurarTagPorBusca method, of class ColaboradorTagService.
     */
    @Test
    public void testProcurarTagPorBusca() {
        List<ColaboradorTag> listTag = new ArrayList<>();
        colaboradorTag.setDescricao("java");
        listTag.add(colaboradorTag);
        colaboradorTag.setDescricao("java");
        listTag.add(colaboradorTag);

        when(colaboradorTagRepositorio.findAllByDescricaoContaining("java".toLowerCase())).thenReturn(listTag);
        assertEquals(listTag, colaboradorTagService.procurarTagPorBusca("java"));
        verify(colaboradorTagRepositorio).findAllByDescricaoContaining("java".toLowerCase());
    }

    /**
     * Test of buscarTagsColab method, of class ColaboradorTagService.
     */
    @Test
    public void testBuscarTagsColab() {
        List<ColaboradorTag> listTag = new ArrayList<>();
        colaborador.setId(8l);
        colaboradorTag.setDescricao("java");
        colaboradorTag.setId(1l);
        colaboradorTag.setIdColaborador(colaborador);
        listTag.add(colaboradorTag);
        
        when(colaboradorService.buscarPorID(8l)).thenReturn(colaborador);
        when(colaboradorTagRepositorio.findAllByIdColaborador(colaborador)).thenReturn(listTag);
        
        assertEquals(listTag, colaboradorTagService.buscarTagsColab(8l));
        verify(colaboradorService).buscarPorID(8l);
        verify(colaboradorTagRepositorio).findAllByIdColaborador(colaborador);
    }

}
