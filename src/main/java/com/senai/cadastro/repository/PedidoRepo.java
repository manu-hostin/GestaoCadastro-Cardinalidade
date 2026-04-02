package com.senai.cadastro.repository;

import com.senai.cadastro.model.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PedidoRepo extends JpaRepository<Pedido, Long> {

    Pedido findByClienteId (Long clienteId);

    Pedido findByClienteNome (String clienteNome);

    Pedido findByIdAndDescricao (Long id, String descricao);
}
