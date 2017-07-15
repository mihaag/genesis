package br.com.crescer.genesis.services;

import br.com.crescer.genesis.entidades.Colaborador;
import br.com.crescer.genesis.repositorios.ColaboradorRepositorio;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;
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
public class ColaboradorServiceTest {
     
    @Mock
    private ColaboradorRepositorio colaboradorRepositorio;
    
    @InjectMocks
    private ColaboradorService colaboradorService;
    
    @Mock
    private Colaborador colaborador;
    
    @Before
    public void setUp() {
        when(colaboradorRepositorio.findOneById(8l)).thenReturn(colaborador);
    }
//    
    @Test
    public void testBuscarPorID() {
        assertEquals(colaborador, colaboradorService.buscarPorID(8l));
        verify(colaboradorRepositorio).findOneById(8l);
    }

      /**
//     * Test of buscarPorNome method, of class ColaboradorService.
//     */
   @Test
    public void testBuscarPorNome() {
        List<Colaborador> listColab = new ArrayList<>();
        colaborador = new Colaborador();
        colaborador.setNomecompleto("Alana");
        listColab.add(colaborador);
        when(colaboradorRepositorio.findByNomecompletoContainingIgnoreCase("alana")).thenReturn(listColab);
        
        assertEquals(listColab, colaboradorService.buscarPorNome("alana"));
        verify(colaboradorRepositorio).findByNomecompletoContainingIgnoreCase("alana");
    }
//
//    /**
//     * Test of cadastrar method, of class ColaboradorService.
//     */
//    @Test
//    public void testCadastrar() throws Exception {
//        System.out.println("cadastrar");
//        Colaborador colab = null;
//        ColaboradorService instance = new ColaboradorService();
//        Colaborador expResult = null;
//        Colaborador result = instance.cadastrar(colab);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of atualizar method, of class ColaboradorService.
//     */
//    @Test
//    public void testAtualizar() {
//        System.out.println("atualizar");
//        Colaborador colab = null;
//        ColaboradorService instance = new ColaboradorService();
//        Colaborador expResult = null;
//        Colaborador result = instance.atualizar(colab);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of buscarPorEmail method, of class ColaboradorService.
//     */
//    @Test
//    public void testBuscarPorEmail() {
//        System.out.println("buscarPorEmail");
//        String email = "";
//        ColaboradorService instance = new ColaboradorService();
//        Colaborador expResult = null;
//        Colaborador result = instance.buscarPorEmail(email);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of buscarPorEmailCriptografado method, of class ColaboradorService.
//     */
//    @Test
//    public void testBuscarPorEmailCriptografado() throws Exception {
//        System.out.println("buscarPorEmailCriptografado");
//        Map<String, String> emailBuscar = null;
//        ColaboradorService instance = new ColaboradorService();
//        Colaborador expResult = null;
//        Colaborador result = instance.buscarPorEmailCriptografado(emailBuscar);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of cadastrarSenhaNova method, of class ColaboradorService.
//     */
//    @Test
//    public void testCadastrarSenhaNova() throws Exception {
//        System.out.println("cadastrarSenhaNova");
//        HashMap<String, String> map = null;
//        ColaboradorService instance = new ColaboradorService();
//        Colaborador expResult = null;
//        Colaborador result = instance.cadastrarSenhaNova(map);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of atualizarSenha method, of class ColaboradorService.
//     */
//    @Test
//    public void testAtualizarSenha() {
//        System.out.println("atualizarSenha");
//        Colaborador colaborador = null;
//        User user = null;
//        ColaboradorService instance = new ColaboradorService();
//        Colaborador expResult = null;
//        Colaborador result = instance.atualizarSenha(colaborador, user);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//    
}
