package com.casa.logistica.domain;

// criar uma entidade Usuario, com id, uuid, nome e email

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.Date;


@Entity
@Data
@Table(name = "usuario")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_USUARIO")
    private Long id_usuario;
    @Column(name = "UUID_USUARIO", unique = true)
    private String uuid_usuario;
    @Column(name = "NOME")
    private String nome;
    @Column(unique = true, name = "EMAIL")
    private String email;
    @JsonFormat(pattern = "dd/MM/yyyy")
    @Column(name = "DATA_NASCIMENTO")
    private LocalDate dataNascimento;

}
