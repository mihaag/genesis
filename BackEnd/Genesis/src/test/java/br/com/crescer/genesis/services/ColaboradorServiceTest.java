package br.com.crescer.genesis.services;

import br.com.crescer.genesis.entidades.Colaborador;
import br.com.crescer.genesis.repositorios.ColaboradorRepositorio;
import java.util.ArrayList;
import java.util.List;
//import org.h2.engine.User;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.core.userdetails.User;

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
    
     @Mock
    EmailService email;

    @Mock
    CriptografiaService criptografia;
    
    @Before
    public void setUp() {
        
    }
//    
    @Test
    public void testBuscarPorID() {
        when(colaboradorRepositorio.findOneById(8l)).thenReturn(colaborador);
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
    
    
//    /**
//     * Test of buscarPorEmail method, of class ColaboradorService.
//     */
    @Test
    public void testBuscarPorEmail() {
        colaborador.setEmail("alanaeweiss@gmail.com");
        when(colaboradorRepositorio.findOneByEmail("alanaeweiss@gmail.com")).thenReturn(colaborador);
        
        assertEquals(colaborador, colaboradorService.buscarPorEmail("alanaeweiss@gmail.com"));
        verify(colaboradorRepositorio).findOneByEmail("alanaeweiss@gmail.com");
    }
//
//    /**
//     * Test of buscarPorEmailCriptografado method, of class ColaboradorService.
//     */
    

    /**
     * Test of atualizarSenha method, of class ColaboradorService.
     */
//    @Test
//    public void testAtualizarSenha() {
//        
//        User u = new User("alanaeweiss@gmail.com","1234", null);
//        
//        when(colaboradorRepositorio.findOneByEmail("alanaeweiss@gmail.com")).thenReturn(colaborador);
//       
//        colaborador = colaboradorService.buscarPorEmail(u.getUsername());
//        colaborador.setSenha("12345");
//        assertEquals(new BCryptPasswordEncoder().encode("12345"), colaboradorService.atualizarSenha(colaborador, u));
//       
//    }
}
