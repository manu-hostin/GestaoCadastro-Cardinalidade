package com.senai.cadastro.controller;

import com.senai.cadastro.DTO.PedidoRequisicao;
import com.senai.cadastro.DTO.PedidoResposta;
import com.senai.cadastro.repository.PedidoRepo;
import com.senai.cadastro.service.PedidoService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pedido")
@RequiredArgsConstructor
public class PedidoController {

    private final PedidoService service;

    @PostMapping
    public PedidoResposta cadastrarPedido (@Valid @RequestBody PedidoRequisicao requisicao) {
        return service.cadastrarPedido(requisicao);
    }

    @GetMapping
    public List<PedidoResposta> listarPedidos () {
        return service.listarPedidos();
    }

    @GetMapping("/{id}")
    public PedidoResposta findByClienteId (@PathVariable Long id) {
        return service.findByClienteId(id);
    }

    @GetMapping("/buscarNome")
    public PedidoResposta findByClienteNome (@RequestParam String nome) {
        return service.findByClienteNome(nome);
    }

    @GetMapping("/buscarDescricao")
    public PedidoResposta findByIdAndDescricao (@RequestParam Long id, @RequestParam String descricao) {
        return service.findByIdAndDescricao(id, descricao);
    }




}
