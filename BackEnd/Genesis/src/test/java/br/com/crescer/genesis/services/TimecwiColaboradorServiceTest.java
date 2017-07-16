/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.genesis.services;

import br.com.crescer.genesis.entidades.Colaborador;
import br.com.crescer.genesis.entidades.TimecwiColaborador;
import br.com.crescer.genesis.repositorios.ColaboradorRepositorio;
import br.com.crescer.genesis.repositorios.TimecwiColaboradorRepositorio;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.when;
import org.mockito.runners.MockitoJUnitRunner;

/**
 *
 * @author alana'
 */
@RunWith(MockitoJUnitRunner.class)
public class TimecwiColaboradorServiceTest {
    @Mock
    private TimecwiColaborador timeColaborador;

    @Mock
    private ColaboradorRepositorio colaboradorRepositorio;

    @Mock
    private TimecwiColaboradorRepositorio timeColaboradorRepositorio;

    @Mock
    private Colaborador colaborador;

    @InjectMocks
    private TimecwiColaboradorService timeColaboradorService;

    @Mock
    TimecwiService timecwiService;

    /**
     * Test of buscarTodos method, of class TimecwiColaboradorService.
     */
    @Test
    public void testBuscarTodos() {
        List<TimecwiColaborador> listTimeColab = new ArrayList<>();
        listTimeColab.add(timeColaborador);
        Iterable<TimecwiColaborador> iterable = (Iterable) listTimeColab;
        when(timeColaboradorRepositorio.findAll()).thenReturn(iterable);
        assertEquals(iterable, timeColaboradorService.buscarTodos());
        
    }

    /**
     * Test of buscarColaboradoresPorIdDoTime method, of class TimecwiColaboradorService.
     */
    @Test
    public void testBuscarColaboradoresPorIdDoTime() {
        System.out.println("buscarColaboradoresPorIdDoTime");
        Long id = null;
        TimecwiColaboradorService instance = new TimecwiColaboradorService();
        Iterable<TimecwiColaborador> expResult = null;
        Iterable<TimecwiColaborador> result = instance.buscarColaboradoresPorIdDoTime(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of buscarOwners method, of class TimecwiColaboradorService.
     */
    @Test
    public void testBuscarOwners() {
        List<TimecwiColaborador> listTimeColab = new ArrayList<>();
        timeColaborador.setTipo('O');
        listTimeColab.add(timeColaborador);
        
        when(timeColaboradorRepositorio.findByTipo('O')).thenReturn(listTimeColab);
        assertEquals(listTimeColab, timeColaboradorService.buscarOwners());
    }

    /**
     * Test of buscarTimeDoOwner method, of class TimecwiColaboradorService.
     */
    @Test
    public void testBuscarTimeDoOwner() {
        System.out.println("buscarTimeDoOwner");
        Colaborador colab = null;
        TimecwiColaboradorService instance = new TimecwiColaboradorService();
        TimecwiColaborador expResult = null;
        TimecwiColaborador result = instance.buscarTimeDoOwner(colab);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of buscarPorColaborador method, of class TimecwiColaboradorService.
     */
    @Test
    public void testBuscarPorColaborador() {
        System.out.println("buscarPorColaborador");
        Colaborador col = null;
        TimecwiColaboradorService instance = new TimecwiColaboradorService();
        TimecwiColaborador expResult = null;
        TimecwiColaborador result = instance.buscarPorColaborador(col);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
