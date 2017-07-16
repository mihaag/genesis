/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.genesis.services;

import br.com.crescer.genesis.entidades.Colaborador;
import br.com.crescer.genesis.entidades.Timecwi;
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
import static org.mockito.Mockito.verify;
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
    
    @Mock
    private Timecwi timecwi;

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
        verify(timeColaboradorRepositorio).findAll();
        
    }

    /**
     * Test of buscarColaboradoresPorIdDoTime method, of class TimecwiColaboradorService.
     */
    @Test
    public void testBuscarColaboradoresPorIdDoTime() {
        List<TimecwiColaborador> listTimeColab = new ArrayList<>();
        listTimeColab.add(timeColaborador);
        Iterable<TimecwiColaborador> iterable = (Iterable<TimecwiColaborador>) listTimeColab;
        
        when(timeColaboradorRepositorio.findByIdTimecwi_idIn(1l)).thenReturn(iterable);
        assertEquals(iterable, timeColaboradorService.buscarColaboradoresPorIdDoTime(1l));
        verify(timeColaboradorRepositorio).findByIdTimecwi_idIn(1l);
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
        verify(timeColaboradorRepositorio).findByTipo('O');
    }

    /**
     * Test of buscarTimeDoOwner method, of class TimecwiColaboradorService.
     */
    @Test
    public void testBuscarTimeDoOwner() {
       when(timeColaboradorRepositorio.findByTipoAndIdColaborador('O', colaborador)).thenReturn(timeColaborador);
       assertEquals(timeColaborador, timeColaboradorService.buscarTimeDoOwner(colaborador));
       verify(timeColaboradorRepositorio).findByTipoAndIdColaborador('O', colaborador);
    }

    /**
     * Test of buscarPorColaborador method, of class TimecwiColaboradorService.
     */
    @Test
    public void testBuscarPorColaborador() {
        when(timeColaboradorRepositorio.findOneByIdColaborador(colaborador)).thenReturn(timeColaborador);
        assertEquals(timeColaborador, timeColaboradorService.buscarPorColaborador(colaborador));
        verify(timeColaboradorRepositorio).findOneByIdColaborador(colaborador);
    }
}
