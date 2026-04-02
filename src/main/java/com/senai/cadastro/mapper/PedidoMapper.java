package com.senai.cadastro.mapper;

import com.senai.cadastro.DTO.PedidoRequisicao;
import com.senai.cadastro.DTO.PedidoResposta;
import com.senai.cadastro.model.Pedido;
import org.springframework.stereotype.Component;

@Component
public class PedidoMapper {

    public Pedido paraEntidade (PedidoRequisicao requisicao) {
        return new Pedido(
                requisicao.descricao(),
                requisicao.valor(),
                requisicao.idCliente()
        );
    }
    public PedidoResposta paraResposta (Pedido pedido) {
        return new PedidoResposta(
                pedido.getId(),
                pedido.getDescricao(),
                pedido.getValor(),
                pedido.getCliente().getId()
        );
    }


}
