package com.api.VirtualLibrary.usecase.usuario;

import com.api.VirtualLibrary.domain.entities.Usuario;
import com.api.VirtualLibrary.domain.enums.TipoUsuario;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.util.Assert;

class CriarUsuarioImplTest {


    @Test
    @DisplayName("Deve criar um usuário")
    void test1() {
        Usuario usuario = new Usuario("João", "joao@gmail.com", TipoUsuario.padrao);
        Assert.notNull(usuario, "Usuário não pode ser nulo");
    }

    @Test
    @DisplayName("Deve lançar uma exceção quando o usuario for nulo")
    void test2() {
        Usuario usuario = null;
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            Assert.notNull(usuario, "Usuário não pode ser nulo");
        });
    }

}