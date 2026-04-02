package com.senai.cadastro.mapper;

import com.senai.cadastro.DTO.ClienteRequisicao;
import com.senai.cadastro.DTO.ClienteResposta;
import com.senai.cadastro.DTO.PedidoRequisicao;
import com.senai.cadastro.DTO.PedidoResposta;
import com.senai.cadastro.model.Cliente;
import com.senai.cadastro.model.Pedido;
import org.springframework.stereotype.Component;

@Component
public class ClienteMapper {

    public Cliente paraEntidade (ClienteRequisicao requisicao) {
        return new Cliente (
                requisicao.nome(),
                requisicao.email()
        );
    }
    public ClienteResposta paraResposta (Cliente cliente) {
        return new ClienteResposta(
                cliente.getId(),
                cliente.getNome(),
                cliente.getEmail()
        );
    }

}
