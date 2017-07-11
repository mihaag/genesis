package br.com.crescer.genesis.security;

import br.com.crescer.genesis.entidades.Colaborador;
import br.com.crescer.genesis.entidades.Permissao;
import br.com.crescer.genesis.services.ColaboradorService;
import java.util.ArrayList;
import java.util.Optional;
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

    public static enum Roles implements GrantedAuthority {

        ADMINISTRADOR("ROLE_ADMINISTRADOR"),
        COLABORADOR("ROLE_COLABORADOR"),
        MASTER("ROLE_MASTER");

        private final String role;

        private Roles(String role) {
            this.role = role;
        }

        @Override
        public String getAuthority() {
            return this.role;
        }

    }

    @Autowired
    private ColaboradorService service;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Colaborador colaborador = service.buscarPorEmail(username);
        ArrayList<GrantedAuthority> grants = new ArrayList<>();
        Optional.ofNullable(colaborador)
                .map(Colaborador::getIdPermissao)
                .map(Permissao::getDescricao)
                .map(String::toUpperCase)
                .map(Roles::valueOf)
                .ifPresent(grants::add);
        if (colaborador == null) {
            throw new UsernameNotFoundException("");
        }
        return new User(colaborador.getEmail(), colaborador.getSenha(), grants);
    }
}
