/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.genesis.services;

import br.com.crescer.genesis.entidades.Feito;
import br.com.crescer.genesis.entidades.Permissao;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author alana'
 */
public class FeitoServiceTest {
    
    public FeitoServiceTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of buscarTodosFeitos method, of class FeitoService.
     */
    @Test
    public void testBuscarTodosFeitos() {
        System.out.println("buscarTodosFeitos");
        FeitoService instance = new FeitoService();
        List<Feito> expResult = null;
        List<Feito> result = instance.buscarTodosFeitos();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of buscarFeitoPorId method, of class FeitoService.
     */
    @Test
    public void testBuscarFeitoPorId() {
        System.out.println("buscarFeitoPorId");
        long id = 0L;
        FeitoService instance = new FeitoService();
        Feito expResult = null;
        Feito result = instance.buscarFeitoPorId(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of buscarPorNome method, of class FeitoService.
     */
    @Test
    public void testBuscarPorNome() {
        System.out.println("buscarPorNome");
        String nome = "";
        FeitoService instance = new FeitoService();
        List<Feito> expResult = null;
        List<Feito> result = instance.buscarPorNome(nome);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of buscarPorPermissao method, of class FeitoService.
     */
    @Test
    public void testBuscarPorPermissao() {
        System.out.println("buscarPorPermissao");
        Permissao permissao = null;
        FeitoService instance = new FeitoService();
        List<Feito> expResult = null;
        List<Feito> result = instance.buscarPorPermissao(permissao);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of cadastrarFeito method, of class FeitoService.
     */
    @Test
    public void testCadastrarFeito() {
        System.out.println("cadastrarFeito");
        Feito feito = null;
        FeitoService instance = new FeitoService();
        Feito expResult = null;
        Feito result = instance.cadastrarFeito(feito);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of atualizarFeito method, of class FeitoService.
     */
    @Test
    public void testAtualizarFeito() {
        System.out.println("atualizarFeito");
        Feito feito = null;
        FeitoService instance = new FeitoService();
        Feito expResult = null;
        Feito result = instance.atualizarFeito(feito);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of removerFeito method, of class FeitoService.
     */
    @Test
    public void testRemoverFeito() {
        System.out.println("removerFeito");
        Feito feito = null;
        FeitoService instance = new FeitoService();
        Feito expResult = null;
        Feito result = instance.removerFeito(feito);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
