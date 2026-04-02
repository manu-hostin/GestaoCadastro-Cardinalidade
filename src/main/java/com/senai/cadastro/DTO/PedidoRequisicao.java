package com.senai.cadastro.DTO;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;

public record PedidoRequisicao (

        @NotNull(message = "É necessário descrição")
        String descricao,
        @PositiveOrZero
        Double valor,

        @PositiveOrZero
        Long idCliente

){
}
