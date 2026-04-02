package com.senai.cadastro.DTO;

import jakarta.validation.constraints.PositiveOrZero;

public record PedidoResposta (

        Long id,
        String descricao,
        Double valor,
        Long idCliente
) {
}
