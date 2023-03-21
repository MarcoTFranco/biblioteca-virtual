package com.api.VirtualLibrary.usecase.usuario;

import com.api.VirtualLibrary.adapters.output.repositories.UsuarioRepository;
import com.api.VirtualLibrary.domain.entities.Usuario;
import com.api.VirtualLibrary.domain.enums.TipoUsuario;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.Mockito;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class ListarUsuarioImplTest {

    private UsuarioRepository usuarioRepository = Mockito.mock(UsuarioRepository.class);

    private static Stream<List<Usuario>> generator() {
        return Stream.of(
                List.of(
                        new Usuario("nome", "email", TipoUsuario.padrao),
                        new Usuario("nome2", "email2", TipoUsuario.pesquisador),
                        new Usuario("nome3", "email3", TipoUsuario.pesquisador)));
    }

    @Test
    @DisplayName("Deve retornar uma lista vazia de usuarios")
    void test1() {
        Mockito.when(usuarioRepository.findAll()).thenReturn(null);
        assertNull(usuarioRepository.findAll());
    }

    @ParameterizedTest
    @DisplayName("Deve retornar uma lista de usuarios")
    @MethodSource("generator")
    void test2(List<Usuario> usuarios) {
        Mockito.when(usuarioRepository.findAll()).thenReturn(usuarios);
        assertEquals(usuarios, usuarioRepository.findAll());
    }

}