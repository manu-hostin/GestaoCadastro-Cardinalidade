package com.senai.cadastro.DTO;

import org.antlr.v4.runtime.misc.NotNull;

public record ClienteRequisicao (

        @NotNull()
        String nome,

        @NotNull()
        String email
){
}
