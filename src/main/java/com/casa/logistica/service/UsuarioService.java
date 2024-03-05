package com.casa.logistica.service;

import com.casa.logistica.domain.Usuario;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UsuarioService {

    Usuario criarUsuario(Usuario usuario);

    List<Usuario> buscarUsuarios();

}
