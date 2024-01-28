package com.casa.logistica.service;

import com.casa.logistica.domain.Usuario;
import org.springframework.stereotype.Service;

@Service
public interface UsuarioService {

    Usuario criarUsuario(Usuario usuario);

}
