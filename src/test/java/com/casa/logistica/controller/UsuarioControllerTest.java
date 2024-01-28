package com.casa.logistica.controller;

//Criar o teste para o controller de usuario

import com.casa.logistica.domain.Usuario;
import com.casa.logistica.service.UsuarioService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.time.LocalDate;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@WebMvcTest(UsuarioController.class)
public class UsuarioControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UsuarioService usuarioService;

    ObjectMapper mapper = new ObjectMapper();

    @Test
    public void criarUsuarioTest() throws Exception {

        Usuario usuario = new Usuario();
        usuario.setNome("João");;
        usuario.setEmail("teste@teste");
        usuario.setDataNascimento(LocalDate.of(2010, 10, 10));

        // converter usuario para json
        mapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
        mapper.registerModule(new JavaTimeModule());
        String json = mapper.writeValueAsString(usuario);


        // Aqui definimos o comportamento do mock
        Mockito.when(usuarioService.criarUsuario(Mockito.any(Usuario.class))).thenReturn(usuario);
        // Aqui fazemos a requisição POST para a rota /usuario/criar
        // passando o objeto usuario como JSON no corpo da requisição
        mockMvc.perform(post("/usuario/criar")
                        .contentType(MediaType.APPLICATION_JSON)
                //Conteudo usando model mapper
                        .content(json))
                // Aqui validamos o status da resposta da requisição
                .andExpect(status().isCreated());
    }
}
