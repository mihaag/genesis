/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.genesis.services;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author usuario
 */
public class CriptografiaServiceTest {
    
    @Autowired
    CriptografiaService criptografiaService;
    
    public CriptografiaServiceTest() {
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

    @Test
    public void testEncrypt() throws Exception {
        System.out.println("encrypt");
        String text = "rsmennabarreto@gmail.com";
        String expResult = "E97ZkF8qU08MZDYo200LLpZaoWLeMDKTuX1kq1zl27k=";
        String result = CriptografiaService.encrypt(text);
        assertEquals(expResult, result);                
    }

    @Test
    public void testDecrypt() throws Exception {
        System.out.println("decrypt");
        String text = "E97ZkF8qU08MZDYo200LLpZaoWLeMDKTuX1kq1zl27k=";
        String expResult = "rsmennabarreto@gmail.com";
        String result = CriptografiaService.decrypt(text);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.        
    }
    
}
