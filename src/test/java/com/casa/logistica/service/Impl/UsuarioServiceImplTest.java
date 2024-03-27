package com.casa.logistica.service.Impl;

import com.casa.logistica.domain.Usuario;
import com.casa.logistica.repository.UsuarioRepository;
import com.casa.logistica.service.impl.UsuarioServiceImpl;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class UsuarioServiceImplTest {

    @Mock
    private UsuarioRepository usuarioRepository;

    @InjectMocks
    private UsuarioServiceImpl usuarioService;

    @Test
    void shouldCreateUserWhenUserIsAdult() {
        Usuario usuario = new Usuario();
        usuario.setDataNascimento(LocalDate.now().minusYears(20));
        when(usuarioRepository.save(any(Usuario.class))).thenReturn(usuario);

        Usuario createdUser = usuarioService.criarUsuario(usuario);

        assertNotNull(createdUser, "O usuário criado não deve ser nulo.");
        assertEquals(LocalDate.now().minusYears(20), createdUser.getDataNascimento(), "A data de nascimento do usuário criado deve corresponder à fornecida.");
        verify(usuarioRepository, times(1)).save(usuario);
    }

    @Test
    void shouldThrowExceptionWhenUserIsMinor() {
        Usuario usuario = new Usuario();
        usuario.setDataNascimento(LocalDate.now().minusYears(16));

        Exception exception = assertThrows(RuntimeException.class, () -> usuarioService.criarUsuario(usuario),
                "Esperava-se que uma RuntimeException fosse lançada para um usuário menor de idade.");

        String expectedMessage = "Usuario menor de idade"; // Supondo que sua implementação inclua uma mensagem de erro.
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage), "A mensagem da exceção deve indicar que o usuário é menor de idade.");
        verify(usuarioRepository, never()).save(usuario);
    }
}
