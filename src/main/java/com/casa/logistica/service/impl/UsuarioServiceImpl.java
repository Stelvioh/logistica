package com.casa.logistica.service.impl;

import com.casa.logistica.domain.Usuario;
import com.casa.logistica.service.UsuarioService;
import org.springframework.stereotype.Service;
import com.casa.logistica.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;
import java.util.List;

import static java.time.LocalDate.now;


@Service
public class UsuarioServiceImpl implements UsuarioService{

    // bean do repositorio de usuario
    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public Usuario criarUsuario(Usuario usuario) {

        //persistir o usuario no banco de dados a partir do repositorio
        //valida usuario maior de idade
        if (usuario.getDataNascimento().getYear() > LocalDate.now().getYear() - 18) {
            throw new RuntimeException("Usuario menor de idade");
        }
        return usuarioRepository.save(usuario);

    }

    @Override
    public List<Usuario> buscarUsuarios(){
        return usuarioRepository.findAll();
    }


}
