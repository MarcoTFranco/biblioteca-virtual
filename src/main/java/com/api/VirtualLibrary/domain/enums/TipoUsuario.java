package com.api.VirtualLibrary.domain.enums;

import com.api.VirtualLibrary.domain.entities.Usuario;

public enum TipoUsuario {
    padrao {
        @Override
        public boolean podePegar(TipoDeCirculacao tipoDeCirculacao) {
            if (tipoDeCirculacao == TipoDeCirculacao.restrito) {
                return false;
            }
            return true;
        }

        @Override
        public boolean podeEmprestar(Usuario usuario) {
            if (usuario.getEmprestimos().size() + 1 > 5) {
                return false;
            }
            return true;
        }
    }, pesquisador {
        @Override
        public boolean podePegar(TipoDeCirculacao tipoDeCirculacao) {
            return true;
        }

        @Override
        public boolean podeEmprestar(Usuario Usuario) {
            return true;
        }
    };

    public abstract boolean podePegar(TipoDeCirculacao tipoDeCirculacao);

    public abstract boolean podeEmprestar(Usuario Usuario);
}
