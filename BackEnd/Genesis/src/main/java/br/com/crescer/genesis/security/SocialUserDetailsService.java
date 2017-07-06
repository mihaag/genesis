package br.com.crescer.genesis.security;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * @author carloshenrique
 */
@Service
public class SocialUserDetailsService implements UserDetailsService {
    
//    @Autowired
//    UsuarioService usuarioService;
    
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        
//        Usuario u = usuarioService.buscarPorEmail(username);
//        
//        final List<GrantedAuthority> grants = new ArrayList<>();
//        
//        if (u == null) {
//            throw new UsernameNotFoundException("");
//        }
//        return new User(u.getEmail(), u.getSenha(),grants);
        return null;
    }
}
