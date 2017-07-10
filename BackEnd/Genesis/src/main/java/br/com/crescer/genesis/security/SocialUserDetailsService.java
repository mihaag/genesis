
package br.com.crescer.genesis.security;

import br.com.crescer.genesis.entidades.Colaborador;
import br.com.crescer.genesis.services.ColaboradorService;
import java.util.ArrayList;
import javax.validation.constraints.AssertFalse.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * @author carloshenrique
 */
@Service
public class SocialUserDetailsService implements UserDetailsService {
    
    @Autowired
    ColaboradorService service;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Colaborador colaborador = service.buscarPorEmail(username);
        ArrayList<GrantedAuthority> grants = new ArrayList<>();        
        grants.add(() -> colaborador.getIdPermissao().getDescricao());
        if (colaborador == null) {
            throw new UsernameNotFoundException("");
        }
        return new User(colaborador.getEmail(), colaborador.getSenha(), grants);
    }
}
