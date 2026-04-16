package EjercicioPractico2_JosueAlfaroZumbado.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import EjercicioPractico2_JosueAlfaroZumbado.domain.Usuario;
import EjercicioPractico2_JosueAlfaroZumbado.domain.Rol;
import EjercicioPractico2_JosueAlfaroZumbado.repository.UsuarioRepository;
import EjercicioPractico2_JosueAlfaroZumbado.repository.RolRepository;
import EjercicioPractico2_JosueAlfaroZumbado.service.UsuarioService;
import EjercicioPractico2_JosueAlfaroZumbado.service.EmailService;

import java.util.List;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private RolRepository rolRepository;

    @Autowired
    private EmailService emailService;

    @Override
    public List<Usuario> getUsuarios() {
        return usuarioRepository.findAll();
    }

    @Override
    public Usuario getUsuario(Usuario usuario) {
        return usuarioRepository.findById(usuario.getId()).orElse(null);
    }

    @Override
    public void save(Usuario usuario) {

        boolean esNuevo = (usuario.getId() == null);

        // 🔥 ASEGURAR QUE EL ROL SEA UNA ENTIDAD REAL
        if (usuario.getRol() != null && usuario.getRol().getId() != null) {
            Rol rol = rolRepository.findById(usuario.getRol().getId()).orElse(null);
            usuario.setRol(rol);
        }

        // 🔥 NO encriptar porque BD está en texto plano
        // usuario.setPassword(passwordEncoder.encode(usuario.getPassword()));

        usuarioRepository.save(usuario);

        // 🔥 ENVIAR CORREO SOLO SI ES NUEVO
        if (esNuevo) {
            try {
                String contenido = "<h2>Bienvenido " + usuario.getNombre() + "</h2>"
                        + "<p>Tu cuenta ha sido creada correctamente.</p>"
                        + "<p>Email: " + usuario.getEmail() + "</p>";

                emailService.enviarCorreo(
                        usuario.getEmail(),
                        "Bienvenido a la plataforma",
                        contenido
                );

            } catch (Exception e) {
                System.out.println("Error enviando correo: " + e.getMessage());
            }
        }
    }

    @Override
    public void delete(Usuario usuario) {
        usuarioRepository.delete(usuario);
    }

    @Override
    public Usuario findByEmail(String email) {
        return usuarioRepository.findByEmail(email).orElse(null);
    }

    @Override
    public List<Usuario> findByRol(String rol) {
        return usuarioRepository.findByRolNombre(rol);
    }
}