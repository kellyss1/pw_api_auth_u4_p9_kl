package uce.edu.web.api.auth.application;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import uce.edu.web.api.auth.application.representation.UsuarioRepresentation;
import uce.edu.web.api.auth.domain.Usuario;
import uce.edu.web.api.auth.infraestructure.UsuarioRepository;

@ApplicationScoped
public class UsuarioService {

    @Inject
    private UsuarioRepository usuarioRepository;

    public UsuarioRepresentation consultarPorId(Integer id) {
        Usuario usuario = this.usuarioRepository.findById(id.longValue());
        return this.mapper(usuario);
    }

    public UsuarioRepresentation validarUsuario(String user, String password) {
        Usuario usuario = this.usuarioRepository.buscarPorCredenciales(user, password);
        return this.mapper(usuario);
    }

    private UsuarioRepresentation mapper(Usuario usuario) {
        if (usuario == null) {
            return null;
        }
        UsuarioRepresentation usuarioR = new UsuarioRepresentation();
        usuarioR.user = usuario.getUser();
        usuarioR.password = usuario.getPassword();
        usuarioR.role = usuario.getRole();
        return usuarioR;
    }
}
