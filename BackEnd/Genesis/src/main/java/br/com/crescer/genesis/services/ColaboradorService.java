package br.com.crescer.genesis.services;

import br.com.crescer.genesis.entidades.Colaborador;
import br.com.crescer.genesis.entidades.ColaboradorFeito;
import br.com.crescer.genesis.entidades.VwUsuariosDisponiveis;
import br.com.crescer.genesis.repositorios.ColaboradorFeitoRepositorio;
import br.com.crescer.genesis.repositorios.ColaboradorRepositorio;
import br.com.crescer.genesis.repositorios.FeitoRepositorio;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

/*
 * @author mirela.adam
 */
@Service
public class ColaboradorService {

    @Autowired
    ColaboradorRepositorio colabRepositorio;

    @Autowired
    SolicitacaoAcessoService solicitacaoAcessoService;

    @Autowired
    EmailService email;

    @Autowired
    CriptografiaService criptografia;

    @Autowired
    ColaboradorFeitoRepositorio colabFeitoRepositorio;

    @Autowired
    FeitoRepositorio feitoRepositorio;
    
    @Autowired
    VwUsuariosDisponiveisService vwUsuariosDisponiveisService;

    public Iterable<Colaborador> buscarTodos() {
        return colabRepositorio.findAll();
    }

    public Colaborador buscarPorID(Long id) {
        return colabRepositorio.findOneById(id);
    }
    
    public List<Object> buscarPorNomeComFiltro(String texto){
        List<VwUsuariosDisponiveis> colValidos = (List<VwUsuariosDisponiveis>) vwUsuariosDisponiveisService.buscarTodos();
        List<Object> retorno = new ArrayList<>();
        
        if(colValidos.size()==0)
            return null;
        
        for(VwUsuariosDisponiveis col : colValidos){
            if(col.getNomecompleto().toLowerCase().contains(texto.toLowerCase()))
                   retorno.add(col);
        }
        return retorno; 
    }

    public Iterable<Colaborador> buscarPorNome(String texto) {
        return colabRepositorio.findByNomecompletoContainingIgnoreCase(texto);
    }

    public Colaborador cadastrar(Colaborador colab) throws Exception {
        final Colaborador colaborador = colabRepositorio.findOneByEmail(colab.getEmail());
        final String url = "http://localhost:8080/#!/primeiroAcesso?email=" + criptografia.encrypt(colab.getEmail());
        final boolean novoColaborador = colaborador == null ? true : !colaborador.getEmail().equals(colab.getEmail());

        if (novoColaborador) {
            final String assunto = "Cadastrar senha";
            String mensagem = "Acesse o link para cadastrar sua senha .:  " + url;

            List<Colaborador> listaColaborador = new ArrayList<>();
            listaColaborador.add(colab);

            email.enviarEmail(listaColaborador, assunto, mensagem);   
            solicitacaoAcessoService.removerSolicitacao(colab.getEmail());
            colab.setFoto("http://icon-icons.com/icons2/1141/PNG/512/1486395884-account_80606.png");
            Colaborador colaboradorCadastrado = colabRepositorio.save(colab);

            ColaboradorFeito colaboradorFeito = new ColaboradorFeito();
            colaboradorFeito.setId(0L);
            colaboradorFeito.setIdColaborador(colaboradorCadastrado);
            colaboradorFeito.setIdFeito(feitoRepositorio.findOneById(1L));
            colaboradorFeito.setDatafeito(colaboradorCadastrado.getAdmissao());
            colabFeitoRepositorio.save(colaboradorFeito);

            return colaboradorCadastrado;

        }

        return null;
    }

    public Colaborador atualizar(Colaborador colab) {
        Colaborador colaboradorAtualizado = colabRepositorio.findOneById(colab.getId());
        
        if(colaboradorAtualizado.getSenha() != null) {
            colab.setSenha(colaboradorAtualizado.getSenha()); 
        } else {
            if (colab.getSenha() != null) {
                String senha = colab.getSenha();
                String novaSenha = new BCryptPasswordEncoder().encode(senha);
                colab.setSenha(novaSenha);
            }
        }
        return colabRepositorio.save(colab);
    }

    public Colaborador buscarPorEmail(String email) {
        return colabRepositorio.findOneByEmail(email);
    }

    public Colaborador buscarPorEmailCriptografado(Map<String, String> emailBuscar) throws Exception {
        try {
            String emailColaborador = emailBuscar.get("email");
            String email = criptografia.decrypt(emailColaborador);
            return colabRepositorio.findOneByEmail(email);
        } catch (Exception e) {
            throw new Exception("Erro ao buscar Email");
        }
    }

    public Colaborador cadastrarSenhaNova(HashMap<String, String> map) throws Exception {
        try {
            Colaborador col = buscarPorEmailCriptografado(map);
            col.setSenha(new BCryptPasswordEncoder().encode(map.get("senha")));
            return colabRepositorio.save(col);

        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
    
    public Colaborador atualizarSenha(Colaborador colaborador, User user){
        Colaborador colaboradorLogado = buscarPorEmail(user.getUsername());
    
        colaborador.setSenha(new BCryptPasswordEncoder().encode(colaborador.getSenha()));
        return colabRepositorio.save(colaborador);
      
    }
}
