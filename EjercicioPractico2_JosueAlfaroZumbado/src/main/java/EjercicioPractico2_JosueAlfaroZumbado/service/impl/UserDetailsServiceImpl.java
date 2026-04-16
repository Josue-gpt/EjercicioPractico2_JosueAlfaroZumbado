package EjercicioPractico2_JosueAlfaroZumbado.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.*;
import org.springframework.stereotype.Service;
import EjercicioPractico2_JosueAlfaroZumbado.domain.Usuario;
import EjercicioPractico2_JosueAlfaroZumbado.repository.UsuarioRepository;

import java.util.Collections;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

        Usuario usuario = usuarioRepository.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("Usuario no encontrado"));

        return new User(
                usuario.getEmail(),
                usuario.getPassword(), // 🔥 aquí va texto plano
                Collections.singleton(() ->
                        "ROLE_" + usuario.getRol().getNombre()
                )
        );
    }
}
