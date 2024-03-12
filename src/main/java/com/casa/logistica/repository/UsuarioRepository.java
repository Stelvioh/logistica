package com.casa.logistica.repository;

import com.casa.logistica.domain.Usuario;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

// Aqui estamos criando um repositório para a entidade Usuario utilizando crudRepository
// O crudRepository já possui métodos prontos para persistir, buscar, deletar e atualizar
// os dados no banco de dados
@Repository
public interface UsuarioRepository extends CrudRepository<Usuario, Long> {

    @Override
    List<Usuario> findAll();

}

