package br.com.crescer.genesis.services;

import br.com.crescer.genesis.entidades.Colaborador;
import br.com.crescer.genesis.entidades.Permissao;
import br.com.crescer.genesis.entidades.Timecwi;
import br.com.crescer.genesis.entidades.TimecwiColaborador;
import br.com.crescer.genesis.models.TimeModel;
import br.com.crescer.genesis.models.TimePerfilModel;
import br.com.crescer.genesis.repositorios.ColaboradorFeitoRepositorio;
import br.com.crescer.genesis.repositorios.ColaboradorRepositorio;
import br.com.crescer.genesis.repositorios.FeitoRepositorio;
import br.com.crescer.genesis.repositorios.TimecwiColaboradorRepositorio;
import br.com.crescer.genesis.repositorios.TimecwiRepositorio;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.when;
import org.mockito.runners.MockitoJUnitRunner;

/**
 *
 * @author Mirela
 */
@RunWith(MockitoJUnitRunner.class)
public class TimecwiServiceTest {
    @InjectMocks
    private TimecwiService timeService;
            
    @Mock
    private TimecwiRepositorio timeRepositorio;

    @Mock
    private ColaboradorRepositorio colabRepositorio;

    @Mock
    private TimecwiColaboradorRepositorio timeColabRepositorio;
    
    @Mock
    private ColaboradorFeitoRepositorio colabFeitoRepositorio;
    
    @Mock
    FeitoRepositorio feitoRepositorio;
    
    @Mock 
    private Timecwi time;
    
    @Mock
    EmailService emailService;
    
    /**
     * Test of buscarTodos method, of class TimecwiService.
     */
    @Test
    public void testBuscarTodos() {
        System.out.println("buscarTodos");
        
        time.setNome("Financeiro");
        time.setDescricao("Teste");
        time.setId(0l);
        time.setSituacao('A');        
        List<Timecwi> lista = new ArrayList();
        lista.add(time);
        
        when(timeRepositorio.findAll()).thenReturn(lista);
        Iterable<Timecwi> resultadoBusca = timeService.buscarTodos();
        assertEquals(lista, (List)resultadoBusca);
    }

    /*
    @Test
    public void testCadastrarTime() {
        System.out.println("cadastrarTime");
        TimeModel timeModel = new TimeModel();
        timeModel.setId(0L);
        timeModel.setNome("Teste Nome");
        timeModel.setDescricao("Teste Descrição");
        timeModel.setDescricaoresumida("Resumo");
        timeModel.setSituacao('A');
        
        ArrayList<Long> listaOwners = new ArrayList<>();
        listaOwners.add(1L);
        ArrayList<Long> listaMembros = new ArrayList<>();
        listaMembros.add(2L);
        
        timeModel.setOwners(listaOwners);
        timeModel.setMembros(listaMembros);

        Permissao permissao = new Permissao();
        permissao.setId(1L);
        permissao.setDescricao("Administrador");
        
        Colaborador colabOwner = new Colaborador();
        colabOwner.setId(0L);
        colabOwner.setNomecompleto("Mirela Haag");
        colabOwner.setAdmissao(new Date());
        colabOwner.setEmail("mirela@cwi.com.br");
        colabOwner.setNascimento(new Date());
        colabOwner.setPossuiTime('N');
        colabOwner.setIdPermissao(permissao);
        colabOwner.setFoto("foto");
        colabOwner.setSituacao('A');
               
        Colaborador colabMembro = new Colaborador();
        colabMembro.setId(0L);
        colabMembro.setNomecompleto("Vanessa Schenkel");
        colabMembro.setAdmissao(new Date());
        colabMembro.setEmail("vanessa@cwi.com.br");
        colabMembro.setNascimento(new Date());
        colabMembro.setPossuiTime('N');
        colabMembro.setIdPermissao(permissao);
        colabMembro.setFoto("foto");
        colabMembro.setSituacao('A');

        Timecwi timeEsperado = new Timecwi();
        timeEsperado.setNome("Teste Nome");
        timeEsperado.setDescricao("Teste Descrição");
        timeEsperado.setDescricaoresumida("Resumo");
        timeEsperado.setSituacao('A');
        
        when(colabRepositorio.findOneById(1L)).thenReturn(colabOwner);
        when(colabRepositorio.findOneById(2L)).thenReturn(colabMembro);        
        when(timeRepositorio.save(timeEsperado)).thenReturn(timeEsperado);
        
        Timecwi timeResultado = timeService.cadastrarTime(timeModel);
       
        assertEquals(timeEsperado.getDescricao(), timeResultado.getDescricao());
    }
    */
    
    /**
     * Test of inativarTime method, of class TimecwiService.
    */ 
    @Test
    public void testInativarTime() {
        System.out.println("inativarTime");
        Long id = 1L;
        
        time.setId(1L);
        time.setNome("Teste Nome");
        time.setDescricao("Teste Descrição");
        time.setDescricaoresumida("Resumo");
        time.setSituacao('A');
        
        Permissao permissao = new Permissao();
        permissao.setId(1L);
        permissao.setDescricao("Administrador");
        
        Colaborador colabOwner = new Colaborador();
        colabOwner.setId(0L);
        colabOwner.setNomecompleto("Mirela Haag");
        colabOwner.setAdmissao(new Date());
        colabOwner.setEmail("mirela@cwi.com.br");
        colabOwner.setNascimento(new Date());
        colabOwner.setPossuiTime('N');
        colabOwner.setIdPermissao(permissao);
        colabOwner.setFoto("foto");
        colabOwner.setSituacao('A');
        
        TimecwiColaborador timeColab = new TimecwiColaborador();
        timeColab.setId(0L);
        timeColab.setIdColaborador(colabOwner);
        timeColab.setIdTimecwi(time);
        timeColab.setTipo('O');
        
        List<TimecwiColaborador> membros = new ArrayList<>();
        membros.add(timeColab);
        
        when(timeColabRepositorio.findByIdTimecwi_idIn(1L)).thenReturn((Iterable<TimecwiColaborador>)membros);
        when(timeRepositorio.findOneById(1L)).thenReturn(time);
        when(timeRepositorio.save(time)).thenReturn(time);
        
        Timecwi result = timeService.inativarTime(id);
        assertEquals(time, result);
    }

    
    @Test
    public void testBuscarPorID() {
        System.out.println("buscarPorID");
        time.setId(0L);
        time.setNome("Teste");
        time.setDescricao("Teste");
        time.setDescricaoresumida("Teste");
        time.setSituacao('A');
        when(timeRepositorio.findOneById(1L)).thenReturn(time);
        assertEquals(time, timeService.buscarPorID(1L));
    }

    @Test
    public void testBuscarPorNomePesquisa() {
        System.out.println("buscarPorNomePesquisa");
        
        String termo = "Financeiro";
        time.setId(0L);
        time.setNome("Equipe Financeiro");
        time.setDescricao("Teste");
        time.setDescricaoresumida("Teste");
        time.setSituacao('A');
        
        List<Timecwi> timesBuscados = new ArrayList<>();
        timesBuscados.add(time);
        
        when(timeRepositorio.findByNomeContainingIgnoreCase(termo)).thenReturn(timesBuscados);
        
        assertEquals(time, timeService.buscarPorNomePesquisa(termo).get(0));
        assertEquals(timesBuscados, timeService.buscarPorNomePesquisa(termo));
    }
/*
    @Test
    public void testBuscarTimesComFotosPorPesquisa() {
        System.out.println("buscarTimesComFotosPorPesquisa");
        String termo = "ceiro";
        
        time.setId(0L);
        time.setNome("Equipe Financeiro");
        time.setDescricao("Teste");
        time.setDescricaoresumida("Teste");
        time.setSituacao('A');
        
        TimePerfilModel timePerfil = new TimePerfilModel();
        timePerfil.setTime(time);
        
        Permissao permissao = new Permissao();
        permissao.setId(1L);
        permissao.setDescricao("Administrador");
        
        Colaborador colabOwner = new Colaborador();
        colabOwner.setId(0L);
        colabOwner.setNomecompleto("Mirela Haag");
        colabOwner.setAdmissao(new Date());
        colabOwner.setEmail("mirela@cwi.com.br");
        colabOwner.setNascimento(new Date());
        colabOwner.setPossuiTime('N');
        colabOwner.setIdPermissao(permissao);
        colabOwner.setFoto("foto");
        colabOwner.setSituacao('A');
        
        TimecwiColaborador timecolaborador = new TimecwiColaborador();
        timecolaborador.setId(1L);
        timecolaborador.setIdColaborador(colabOwner);
        timecolaborador.setIdTimecwi(time);
        timecolaborador.setTipo('O');
        
        List<TimecwiColaborador> iterableTimeColab = new ArrayList<>();
        iterableTimeColab.add(timecolaborador);
        
        List<Timecwi> timesBuscados = new ArrayList<>();
        timesBuscados.add(time);
        
        when(timeRepositorio.findByNomeContainingIgnoreCase(termo)).thenReturn(timesBuscados);
        when(timeRepositorio.findOneById(1L)).thenReturn(time);
        when(timeColabRepositorio.findByIdTimecwi_idIn(time.getId())).thenReturn(iterableTimeColab);
        when(colabRepositorio.findOneById(timecolaborador.getIdColaborador().getId())).thenReturn(colabOwner);
        assertEquals(timePerfil.getTime(), timeService.buscarTimesComFotosPorPesquisa(termo));

    }

    /**
     * Test of alterar method, of class TimecwiService.
     
    @Test
    public void testAlterar() {
        System.out.println("alterar");
        TimeModel timeModel = null;
        TimecwiService instance = new TimecwiService();
        Timecwi expResult = null;
        Timecwi result = instance.alterar(timeModel);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of buscarTimesComFotos method, of class TimecwiService.
     
    @Test
    public void testBuscarTimesComFotos() {
        System.out.println("buscarTimesComFotos");
        TimecwiService instance = new TimecwiService();
        List<TimePerfilModel> expResult = null;
        List<TimePerfilModel> result = instance.buscarTimesComFotos();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of buscarTimePorIdComFotos method, of class TimecwiService.
     
    @Test
    public void testBuscarTimePorIdComFotos() {
        System.out.println("buscarTimePorIdComFotos");
        Long id = null;
        TimecwiService instance = new TimecwiService();
        TimePerfilModel expResult = null;
        TimePerfilModel result = instance.buscarTimePorIdComFotos(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of removerUsuarioDoTime method, of class TimecwiService.
     
    @Test
    public void testRemoverUsuarioDoTime() {
        System.out.println("removerUsuarioDoTime");
        DadosUsuarioAserDeletadoModel dadosUsuarioASerRemovido = null;
        TimecwiService instance = new TimecwiService();
        Map<String, String> expResult = null;
        Map<String, String> result = instance.removerUsuarioDoTime(dadosUsuarioASerRemovido);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of tornarOwner method, of class TimecwiService.
     
    @Test
    public void testTornarOwner() {
        System.out.println("tornarOwner");
        Colaborador col = null;
        TimecwiService instance = new TimecwiService();
        Map<String, String> expResult = null;
        Map<String, String> result = instance.tornarOwner(col);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    * */
    
}
