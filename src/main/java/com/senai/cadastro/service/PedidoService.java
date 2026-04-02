package com.senai.cadastro.service;

import com.senai.cadastro.DTO.PedidoRequisicao;
import com.senai.cadastro.DTO.PedidoResposta;
import com.senai.cadastro.mapper.ClienteMapper;
import com.senai.cadastro.mapper.PedidoMapper;
import com.senai.cadastro.model.Cliente;
import com.senai.cadastro.model.Pedido;
import com.senai.cadastro.repository.ClienteRepo;
import com.senai.cadastro.repository.PedidoRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class PedidoService {

    private final PedidoRepo repo;
    private final PedidoMapper mapper;
    private final ClienteRepo clienteRepo;
    public PedidoResposta cadastrarPedido (PedidoRequisicao requisicao) {
        Cliente cliente = clienteRepo.findById(requisicao.idCliente())
                .orElseThrow(() -> new RuntimeException("Cliente não existe"));

        Pedido pedido = mapper.paraEntidade(requisicao);
        pedido.setCliente(cliente);

        Pedido salvar = repo.save(pedido);

        return mapper.paraResposta(salvar);
    }

    public List<PedidoResposta> listarPedidos () {
        List<Pedido> pedidos = repo.findAll();
        List<PedidoResposta> pedidoRespostas = new ArrayList<>();

        for (Pedido pedido : pedidos) {
            pedidoRespostas.add(mapper.paraResposta(pedido));
        }

        return pedidoRespostas;
    }

    public PedidoResposta buscarPedido (Long id) {
        Pedido pedido = repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Pedido não existe!"));

        return mapper.paraResposta(pedido);
    }

    // Filtros
    public PedidoResposta findByClienteId (Long clienteId) {
        Pedido pedido = repo.findByClienteId(clienteId);

        return mapper.paraResposta(pedido);
    }

    public PedidoResposta findByClienteNome (String clienteNome) {
        Pedido pedido = repo.findByClienteNome(clienteNome);

        return mapper.paraResposta(pedido);
    }

    public PedidoResposta findByIdAndDescricao (Long id, String descricao) {
        Pedido pedido = repo.findByIdAndDescricao(id, descricao);

        return mapper.paraResposta(pedido);
    }
}
